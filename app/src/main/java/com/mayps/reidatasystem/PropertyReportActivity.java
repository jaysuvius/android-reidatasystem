package com.mayps.reidatasystem;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.print.PrintAttributes;
import android.print.pdf.PrintedPdfDocument;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mayps.reidatasystem.Controllers.AddressController;
import com.mayps.reidatasystem.Controllers.PropertyController;
import com.mayps.reidatasystem.Models.Address;
import com.mayps.reidatasystem.Models.Property;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PropertyReportActivity extends AppCompatActivity {

    private static final int STORAGE_CODE = 1000;
    PropertyController pc;
    AddressController ac;
    List<Property> properties;
    TableLayout propertyTable;
    ListView propertyList;
    View rowView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_report);

        pc = new PropertyController(getApplicationContext());
        properties = pc.getAll();


            if(Build.VERSION.SDK_INT > 22){
                if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                    String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                    requestPermissions(permissions, STORAGE_CODE);
                }
                else{
                    createPdf();
                }
            }
            else{
                createPdf();
            }

    }

    private void createPdf(){
        try {

            //Create time stamp
            Date date = new Date() ;
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(System.currentTimeMillis());

            File pdfFolder = new File(Environment.getExternalStorageDirectory() + "/" + "pdf");
            if (!pdfFolder.exists()) {
                pdfFolder.mkdir();
                Log.i("Printing Pdf", "Pdf Directory created");
            }

            String filePath = pdfFolder + "/" + timeStamp + ".pdf";

            File myFile = new File(filePath);

            PrintAttributes.Builder attr = new PrintAttributes.Builder();
            attr.setColorMode(PrintAttributes.COLOR_MODE_MONOCHROME);
            attr.setMediaSize(PrintAttributes.MediaSize.NA_LETTER);
            attr.setMinMargins(PrintAttributes.Margins.NO_MARGINS);
            PrintedPdfDocument document = new PrintedPdfDocument(getApplicationContext(),
                    attr.build());

            int pageNo = 0;
            if(properties.isEmpty()){
                Toast.makeText(this, "No properties to report.", Toast.LENGTH_SHORT);
                finish();
            }

            for(Property p : properties){
                PdfDocument.Page page = document.startPage(pageNo);

                View content = getContentView(properties.get(pageNo));

                int measureWidth = View.MeasureSpec.makeMeasureSpec(page.getCanvas().getWidth(), View.MeasureSpec.EXACTLY);
                int measuredHeight = View.MeasureSpec.makeMeasureSpec(page.getCanvas().getHeight(), View.MeasureSpec.EXACTLY);
                content.measure(measureWidth, measuredHeight);
                content.layout(0, 0, page.getCanvas().getWidth(), page.getCanvas().getHeight());

                content.draw(page.getCanvas());

                document.finishPage(page);


                pageNo++;

            }

            OutputStream output = new FileOutputStream(myFile);
            document.writeTo(output);

            document.close();

            viewPdf(myFile);

        }
        catch(IOException ex){
            Log.i("Export Pdf", "Pdf failed");
        }
        finish();
    }

    private void viewPdf(File file){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri pdfUri = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".DAL.GenericFileProvider", file);
        intent.setDataAndType(pdfUri, "application/pdf");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case STORAGE_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    createPdf();
                }
                else{
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_LONG).show();
                }
        }
    }

    private View getContentView(Property p){
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View propReport = inflater.inflate(R.layout.property_report_layout, null);
        fetch_elements(propReport, p);
        return propReport;
    }



        private View fetch_elements(View tableView, Property p){
            TextView timeStamp = (TextView) tableView.findViewById(R.id.timeStampReportLabel);
            timeStamp.setText(new Date().toString());
            TextView propertyNameValue = (TextView) tableView.findViewById(R.id.propertyNameValue);
            propertyNameValue.setText(p.getProperty_name());
            TextView addressNameValue = (TextView) tableView.findViewById(R.id.addressNameValue);
            addressNameValue.setText(getAddress(p.getAddress_id()));
            TextView styleNameValue = (TextView) tableView.findViewById(R.id.styleNameValue);
            styleNameValue.setText(p.getStyle());
            TextView sqftNameValue = (TextView) tableView.findViewById(R.id.sqftNameValue);
            sqftNameValue.setText(Integer.toString(p.getSq_ft()));
            TextView lotSizeValue = (TextView) tableView.findViewById(R.id.lotSizeValue);
            lotSizeValue.setText(Integer.toString(p.getLot_size()));
            TextView yrBuilteValue = (TextView) tableView.findViewById(R.id.yrBuiltValue);
            yrBuilteValue.setText(Integer.toString(p.getYear_built()));
            TextView hoaFeesValue = (TextView) tableView.findViewById(R.id.hoaFeesValue);
            hoaFeesValue.setText(Double.toString(p.getHoa_fees()));
            TextView _report_multi_value = (TextView) tableView.findViewById(R.id._report_multi_Value);
            _report_multi_value.setText(p.isIs_multi_unit() ? "True" : "False");
            TextView report_is_occupied_value = (TextView) tableView.findViewById(R.id.report_is_occupied_Value);
            report_is_occupied_value.setText(p.isIs_occupied() ? "True" : "False");
            TextView is_owner_occupied_value = (TextView) tableView.findViewById(R.id.report_owner_occupied_Value);
            is_owner_occupied_value.setText(p.isIs_owner_occupied() ? "True" : "False");
            TextView featuresValue = (TextView) tableView.findViewById(R.id.featuresValue);
            featuresValue.setText(p.getSpecial_features());
            TextView upgradesValue = (TextView) tableView.findViewById(R.id.upgradesValue);
            upgradesValue.setText(p.getUpgrades());
            TextView is_listed_values = (TextView) tableView.findViewById(R.id.is_listed_value);
            is_listed_values.setText(p.isIs_listed() ? "True" : "False");
            TextView report_other_offers_value = (TextView) tableView.findViewById(R.id.report_other_offers_value);
            report_other_offers_value.setText(p.isHas_other_offers() ? "True" : "False");
            TextView offerAmountValue = (TextView) tableView.findViewById(R.id.offerAmountValue);
            offerAmountValue.setText(Double.toString(p.getOffer_amount()));
            TextView listingDateValue = (TextView) tableView.findViewById(R.id.listingDateValue);
            listingDateValue.setText(p.getListing_date().toString());
            TextView realtorNameValue = (TextView) tableView.findViewById(R.id.realtorNameValue);
            realtorNameValue.setText(p.getRealtor());
            TextView realtorNumberValue = (TextView) tableView.findViewById(R.id.realtorNumberValue);
            realtorNumberValue.setText(p.getRealtor_phone());
            TextView reasonValue = (TextView) tableView.findViewById(R.id.reasonValue);
            reasonValue.setText(p.getReason_for_selling());
            TextView timeFramerValue = (TextView) tableView.findViewById(R.id.timeFramerValue);
            timeFramerValue.setText(p.getTime_frame());
            TextView noSellContValue = (TextView) tableView.findViewById(R.id.noSellContValue);
            noSellContValue.setText(p.getNo_sell_contingency());
            TextView mortAmountValue = (TextView) tableView.findViewById(R.id.mortAmountValue);
            mortAmountValue.setText(Double.toString(p.getMortgage_amount()));
            TextView has_liens_value = (TextView) tableView.findViewById(R.id.has_liens_Value);
            has_liens_value.setText(p.isHas_liens() ? "True" : "false");
            TextView otherLienValue = (TextView) tableView.findViewById(R.id.otherLienValue);
            otherLienValue.setText(Double.toString(p.getOther_lien_amount()));
            TextView payment_current_report_value = (TextView) tableView.findViewById(R.id.payment_current_report_value);
            payment_current_report_value.setText(p.isIs_payment_current() ? "True" : "False");
            TextView monthsBehindNameValue = (TextView) tableView.findViewById(R.id.monthsBehindValue);
            monthsBehindNameValue.setText(Integer.toString(p.getMonths_behind()));
            TextView amountBehindValue = (TextView) tableView.findViewById(R.id.amountBehindValue);
            amountBehindValue.setText(Double.toString(p.getAmount_behind()));
            TextView taxAmountValue = (TextView) tableView.findViewById(R.id.taxAmountValue);
            taxAmountValue.setText(Double.toString(p.getTax_amount()));
            TextView backTaxesValue = (TextView) tableView.findViewById(R.id.backTaxesValue);
            backTaxesValue.setText(Double.toString(p.getBack_taxes()));
            TextView monthlyPaymentValue = (TextView) tableView.findViewById(R.id.monthlyPaymentValue);
            monthlyPaymentValue.setText(Double.toString(p.getMonthly_payment()));
            TextView insuranceAmountValue = (TextView) tableView.findViewById(R.id.insuranceAmountValue);
            insuranceAmountValue.setText(Double.toString(p.getInsurance_amount()));
            TextView fixed_interest_report_value = (TextView) tableView.findViewById(R.id.fixed_interest_report_textView);
            fixed_interest_report_value.setText(p.isIs_fixed_rate() ? "True" : "False");
            TextView interest1Value = (TextView) tableView.findViewById(R.id.interest1Value);
            interest1Value.setText(Double.toString(p.getFirst_interest_rate()));
            TextView interest2Value = (TextView) tableView.findViewById(R.id.interest2Value);
            interest2Value.setText(Double.toString(p.getSecond_interest_rate()));
            TextView askingPriceValue = (TextView) tableView.findViewById(R.id.askingPriceValue);
            askingPriceValue.setText(Double.toString(p.getAsking_price()));
            TextView paymentPenaltyValue = (TextView) tableView.findViewById(R.id.paymentPenaltyValue);
            paymentPenaltyValue.setText(Double.toString(p.getPayment_penalty()));
            TextView mortgageCompany1Value = (TextView) tableView.findViewById(R.id.mortgageCompany1Value);
            mortgageCompany1Value.setText(p.getMortgage_company_1());
            TextView mortgageCompany2Value = (TextView) tableView.findViewById(R.id.mortgageCompany2Value);
            mortgageCompany2Value.setText(p.getGetMortgage_company_2());
            TextView is_flexible_report_value = (TextView) tableView.findViewById(R.id.is_flexible_report_vaiue);
            is_flexible_report_value.setText(p.isIs_flexible() ? "True" : "False");
            TextView priceDerivedValue = (TextView) tableView.findViewById(R.id.priceDerivedValue);
            priceDerivedValue.setText(p.getHow_price_derived());
            TextView bestPriceFastCloseValue = (TextView) tableView.findViewById(R.id.bestPriceFastCloseValue);
            bestPriceFastCloseValue.setText(Double.toString(p.getBest_price_cash_fast_close()));
            TextView bottomPriceValue = (TextView) tableView.findViewById(R.id.bottomPriceValue);
            bottomPriceValue.setText(Double.toString(p.getAbsolute_bottom_price()));
            TextView _report_accept_quickly_value = (TextView) tableView.findViewById(R.id._report_accept_quickly_textView);
            _report_accept_quickly_value.setText(p.isCan_accept_quickly() ? "True" : "False");
            TextView subject_to_report_value = (TextView) tableView.findViewById(R.id.subject_to_report_value);
            subject_to_report_value.setText(p.isWill_subject_to() ? "True" : "False");
            TextView report_likely_purchase_value = (TextView) tableView.findViewById(R.id.report_likely_purchase_value);
            report_likely_purchase_value.setText(p.isLikely_purchase() ? "True" : "False");
            TextView repairCostValue = (TextView) tableView.findViewById(R.id.repairCostValue);
            repairCostValue.setText(Double.toString(p.getRepair_cost()));
            TextView arvValue = (TextView) tableView.findViewById(R.id.arvValue);
            arvValue.setText(Double.toString(p.getArv()));
            TextView offer1Value = (TextView) tableView.findViewById(R.id.offer1Value);
            offer1Value.setText(Double.toString(p.getOffer_1()));
            TextView offer2Value = (TextView) tableView.findViewById(R.id.offer2Value);
            offer2Value.setText(Double.toString(p.getOffer_2()));
            TextView exitStrategy = (TextView) tableView.findViewById(R.id.exitStrategyValue);
            exitStrategy.setText(p.getExit_strategy());
            TextView evaluator = (TextView) tableView.findViewById(R.id.evaluatorValue);
            evaluator.setText(p.getEvaluator());
//            TableLayout repairs = (TableLayout) tableView.findViewById(R.id.RepairTable);
//            TableLayout UnitTable = (TableLayout) tableView.findViewById(R.id.UnitTable);
            return tableView;
        }

        private String getAddress(long addressId){
            ac = new AddressController(getApplicationContext());
            Uri uri = Uri.parse("content://" + pc._provider.getAuthority() + "/" + pc._provider.get_table() + "/" + addressId);
            Address a = (Address) ac.getById(uri);
            return a.getAddress_1();
        }

}
