package com.mayps.reidatasystem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.print.PrintAttributes;
import android.print.pdf.PrintedPdfDocument;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.mayps.reidatasystem.Controllers.AddressController;
import com.mayps.reidatasystem.Controllers.PropertyController;
import com.mayps.reidatasystem.Models.Address;
import com.mayps.reidatasystem.Models.Property;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PropertyDetailActivity extends AppCompatActivity {

    private EditText property_name_input;
    private EditText style_input;
    private EditText sqft_input;
    private EditText lot_size_input;
    private EditText year_built_input;
    private CheckBox multi_checkbox;
    private CheckBox is_occupied_checkbox;

    private CheckBox owner_occupied_checkbox;
    private EditText special_features_input;
    private EditText upgrades_input;
    private CheckBox is_listed_checkbox;
    private EditText listing_date_input;
    private CheckBox other_offers_checkbox;
    private EditText offer_amount_input;
    private EditText realtor_input;
    private EditText realtor_phone_input;
    private EditText reason_selling_input;
    private EditText time_frame_input;
    private EditText no_sell_cont_input;
    private EditText mortgage_amount_input;
    private CheckBox has_liens_checkbox;
    private CheckBox multiple_mortgages_checkbox;
    private CheckBox payment_current_checkbox;
    private EditText months_behind_input;
    private EditText amount_behind_input;
    private EditText back_taxes_input;
    private EditText other_lien_input;
    private EditText monthly_payment_input;
    private EditText tax_amount_input;
    private EditText insurance_amount_input;
    private CheckBox fixed_interest_checkbox;
    private EditText interest_1_input;
    private EditText interest_2_input;
    private EditText payment_penalty_input;
    private EditText mortgage_company_1_input;
    private EditText mortgage_company_2_input;
    private EditText asking_price_input;
    private CheckBox flexible_checkbox;
    private EditText price_derived_input;
    private EditText best_price_fast_close_input;
    private EditText bottom_price_input;
    private CheckBox subject_to_checkbox;
    private CheckBox accept_quickly_checkbox;
    private EditText evaluator_input;
    private EditText arv_input;
    private EditText repair_cost_input;
    private CheckBox likely_purchase_checkbox;
    private EditText exit_strategy_input;
    private EditText offer_1_input;
    private EditText offer_2_input;
    private Spinner property_address_spinner;
    private AddressController ac;
    private List<Address> addresses;
    ArrayAdapter<Address> addyAdapter;
    PropertyController pc;
    Property property;
    long id = 0;
    AwesomeValidation validator = new AwesomeValidation(ValidationStyle.BASIC);

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entity_detail, menu);
        getMenuInflater().inflate(R.menu.menu_add_address, menu);
        getMenuInflater().inflate(R.menu.menu_property_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_save:
                save_property();
                break;
            case R.id.action_new:
                new_property();
                break;
            case R.id.action_delete:
                delete_property();
                new_property();
                break;
            case R.id.add_address:
                launch_address();
                break;
            case R.id.view_repairs:
                launch_repair_intent();
                break;
            case R.id.view_units:
                launch_unit_intent();
                break;
            case R.id.gen_report:
                gen_report();
                break;
            case android.R.id.home:
                Intent intent = NavUtils.getParentActivityIntent(this);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                NavUtils.navigateUpTo(this, intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void gen_report(){
        String extstoragedir = Environment.getExternalStorageDirectory().toString();
        File fol = new File(extstoragedir, "pdf");
        File folder=new File(fol,"pdf");
        if(!folder.exists()) {
            boolean bool = folder.mkdir();
        }
        try{
            final File file = new File(folder, "report.pdf");
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);

            PrintAttributes.Builder att = new PrintAttributes.Builder();
            att.setColorMode(PrintAttributes.COLOR_MODE_COLOR);
            PrintedPdfDocument document = new PrintedPdfDocument(this, att.build());
            PdfDocument.Page page = document.startPage(0);

            View content = findViewById(android.R.id.content);
            content.draw(page.getCanvas());

            document.finishPage(page);

            document.writeTo(fOut);
        }catch (IOException e){
            Log.i("error",e.getLocalizedMessage());
        }
    }

    private void launch_repairs(){
        Intent intent = new Intent(this, RepairsActivity.class);
        intent.putExtra("id", 0);
        intent.putExtra("propertyId", id);
        startActivity(intent);
    }

    private void launch_repair_intent(){
        new AlertDialog.Builder(this)
                .setTitle("Property must be saved to add repairs")
                .setMessage("Save??")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(PropertyDetailActivity.this, "Save Property First", Toast.LENGTH_LONG).show();
                        if(save_property())
                            launch_repairs();
                    }
                })
                .setNegativeButton(android.R.string.no, null).show();
    }

    private void launch_units(){
        Intent intent = new Intent(this, UnitsActivity.class);
        intent.putExtra("id", 0);
        intent.putExtra("propertyId", id);
        startActivity(intent);
    }

    private void launch_unit_intent(){
        new AlertDialog.Builder(this)
                .setTitle("Property must be saved to add units")
                .setMessage("Save??")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(PropertyDetailActivity.this, "Save Property First", Toast.LENGTH_LONG).show();
                        if(save_property())
                            launch_units();
                    }
                })
                .setNegativeButton(android.R.string.no, null).show();
    }

    private void goToAddressDetailIntent() {
        Intent intent = new Intent(this, AddressDetailActivity.class);
        intent.putExtra("id", 0);
        startActivity(intent);
    }

    private void launch_address(){
        new AlertDialog.Builder(this)
                .setTitle("Company must be saved to add address")
                .setMessage("Save??")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(PropertyDetailActivity.this, "Save Contact First", Toast.LENGTH_LONG).show();
                        if(save_property())
                            goToAddressDetailIntent();
                    }
                })
                .setNegativeButton(android.R.string.no, null).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getInputs();


        Bundle extrasBundle = getIntent().getExtras();
        id = 0;
        if (!extrasBundle.isEmpty()) {
            id = extrasBundle.getLong("id");

            pc = new PropertyController(getApplicationContext());
            Uri uri = Uri.parse("content://" + pc._provider.getAuthority() + "/" + pc._provider.get_table() + "/" + id);
            property = (Property) pc.getById(uri);
            if (property == null) {
                new_property();
            } else fetch_property();
        }
    }

    protected  void getInputs(){
        property_name_input = findViewById(R.id.property_name_input);
        property_address_spinner = findViewById(R.id.property_address_spinner);
        style_input = findViewById(R.id.style_input);
        sqft_input = findViewById(R.id.sqft_input);
        lot_size_input = findViewById(R.id.lot_size_input);
        validator.addValidation(lot_size_input, "^(0|[1-9][0-9]*)$", "Numeric");
        year_built_input = findViewById(R.id.year_built_input);
        validator.addValidation(year_built_input, "^(0|[1-9][0-9]*)$", "Numeric");
        multi_checkbox = findViewById(R.id.multi_checkbox);
        is_occupied_checkbox = findViewById(R.id.is_occupied_checkbox);
        owner_occupied_checkbox = findViewById(R.id.owner_occupied_checkbox);
        special_features_input = findViewById(R.id.special_features_input);
        upgrades_input = findViewById(R.id.upgrades_input);
        is_listed_checkbox = findViewById(R.id.is_listed_checkbox);
        listing_date_input = findViewById(R.id.listing_date_input);
        other_offers_checkbox = findViewById(R.id.other_offers_checkbox);
        offer_amount_input = findViewById(R.id.offer_amount_input);
        validator.addValidation(offer_amount_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        realtor_input = findViewById(R.id.realtor_input);
        realtor_phone_input = findViewById(R.id.realtor_phone_input);
        validator.addValidation(realtor_phone_input, "^(0|[1-9][0-9]*)$", "Numeric");
        reason_selling_input = findViewById(R.id.reason_selling_input);
        time_frame_input = findViewById(R.id.time_frame_input);
        no_sell_cont_input = findViewById(R.id.no_sell_cont_input);
        mortgage_amount_input = findViewById(R.id.mortgage_amount_input);
        validator.addValidation(mortgage_amount_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        has_liens_checkbox = findViewById(R.id.has_liens_checkbox);
        multiple_mortgages_checkbox = findViewById(R.id.multiple_mortgages_checkbox);
        payment_current_checkbox = findViewById(R.id.payment_current_checkbox);
        months_behind_input = findViewById(R.id.months_behind_input);
        validator.addValidation(months_behind_input, "^(0|[1-9][0-9]*)$", "Numeric");
        amount_behind_input = findViewById(R.id.amount_behind_input);
        back_taxes_input = findViewById(R.id.back_taxes_input);
        validator.addValidation(amount_behind_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        other_lien_input = findViewById(R.id.other_lien_input);
        validator.addValidation(other_lien_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        monthly_payment_input = findViewById(R.id.monthly_payment_input);
        validator.addValidation(monthly_payment_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        tax_amount_input = findViewById(R.id.tax_amount_input);
        validator.addValidation(tax_amount_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        insurance_amount_input = findViewById(R.id.insurance_amount_input);
        validator.addValidation(insurance_amount_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        fixed_interest_checkbox = findViewById(R.id.fixed_interest_checkbox);
        interest_1_input = findViewById(R.id.interest_1_input);
        validator.addValidation(interest_1_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        interest_2_input = findViewById(R.id.interest_2_input);
        validator.addValidation(interest_2_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        payment_penalty_input = findViewById(R.id.payment_penalty_input);
        validator.addValidation(payment_penalty_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        mortgage_company_1_input = findViewById(R.id.mortgage_company_1_input);
        mortgage_company_2_input = findViewById(R.id.mortgage_company_2_input);
        asking_price_input = findViewById(R.id.asking_price_input);
        validator.addValidation(asking_price_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        flexible_checkbox = findViewById(R.id.flexible_checkbox);
        price_derived_input = findViewById(R.id.price_derived_input);
        validator.addValidation(price_derived_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        best_price_fast_close_input = findViewById(R.id.best_price_fast_close_input);
        validator.addValidation(best_price_fast_close_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        bottom_price_input = findViewById(R.id.bottom_price_input);
        validator.addValidation(bottom_price_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        subject_to_checkbox = findViewById(R.id.subject_to_checkbox);
        accept_quickly_checkbox = findViewById(R.id.accept_quickly_checkbox);
        evaluator_input = findViewById(R.id.evaluator_input);
        arv_input = findViewById(R.id.arv_input);
        validator.addValidation(arv_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        repair_cost_input = findViewById(R.id.repair_cost_input);
        validator.addValidation(repair_cost_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        likely_purchase_checkbox = findViewById(R.id.likely_purchase_checkbox);
        exit_strategy_input = findViewById(R.id.exit_strategy_input);
        offer_1_input = findViewById(R.id.offer_1_input);
        validator.addValidation(offer_1_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
        offer_2_input = findViewById(R.id.offer_2_input);
        validator.addValidation(offer_2_input, "^[1-9]\\d*(\\.\\d+)?$", "Numeric");
    }

    public void fetch_property(){
        ac = new AddressController(getApplicationContext());
        addresses = ac.getAll();
        addyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, addresses);
        property_address_spinner.setAdapter(addyAdapter);
        property_name_input.setText(property.getProperty_name());
        for(int i = 0; i < property_address_spinner.getCount(); i++){
            if(((Address)property_address_spinner.getItemAtPosition(i)).getId() == property.getAddress_id()){
                property_address_spinner.setSelection(i);
            }
        }
        style_input.setText(property.getStyle());
        sqft_input.setText(Integer.toString(property.getSq_ft()));
        lot_size_input.setText(Integer.toString(property.getLot_size()));
        year_built_input.setText(Integer.toString(property.getYear_built()));
        multi_checkbox.setChecked(property.isIs_multi_unit());
        is_occupied_checkbox.setChecked(property.isIs_occupied());
        owner_occupied_checkbox.setChecked(property.isIs_owner_occupied());
        special_features_input.setText(property.getSpecial_features());
        upgrades_input.setText(property.getUpgrades());
        is_listed_checkbox.setChecked(property.isIs_listed());
        listing_date_input.setText(property.getListing_date());
        other_offers_checkbox.setChecked(property.isHas_other_offers());
        offer_amount_input.setText(Double.toString(property.getOffer_amount()));
        realtor_input.setText(property.getRealtor());
        realtor_phone_input.setText(property.getRealtor_phone());
        reason_selling_input.setText(property.getReason_for_selling());
        time_frame_input.setText(property.getTime_frame());
        no_sell_cont_input.setText(property.getNo_sell_contingency());
        mortgage_amount_input.setText(Double.toString(property.getMortgage_amount()));
        has_liens_checkbox.setChecked(property.isHas_liens());
        multiple_mortgages_checkbox.setChecked(property.isHas_multiple_mortgages());
        payment_current_checkbox.setChecked(property.isIs_payment_current());
        months_behind_input.setText(Integer.toString(property.getMonths_behind()));
        amount_behind_input.setText(Double.toString(property.getAmount_behind()));
        back_taxes_input.setText(Double.toString(property.getBack_taxes()));
        other_lien_input.setText(Double.toString(property.getOther_lien_amount()));
        monthly_payment_input.setText(Double.toString(property.getMonthly_payment()));
        tax_amount_input.setText(Double.toString(property.getTax_amount()));
        insurance_amount_input.setText(Double.toString(property.getInsurance_amount()));
        fixed_interest_checkbox.setChecked(property.isIs_fixed_rate());
        interest_1_input.setText(Double.toString(property.getFirst_interest_rate()));
        interest_2_input.setText(Double.toString(property.getSecond_interest_rate()));
        payment_penalty_input.setText(Double.toString(property.getPayment_penalty()));
        mortgage_company_1_input.setText(property.getMortgage_company_1());
        mortgage_company_2_input.setText(property.getGetMortgage_company_2());
        asking_price_input.setText(Double.toString(property.getAsking_price()));
        flexible_checkbox.setChecked(property.isIs_flexible());
        price_derived_input.setText(property.getHow_price_derived());
        best_price_fast_close_input.setText(Double.toString(property.getBest_price_cash_fast_close()));
        bottom_price_input.setText(Double.toString(property.getAbsolute_bottom_price()));
        subject_to_checkbox.setChecked(property.isWill_subject_to());
        accept_quickly_checkbox.setChecked(property.isCan_accept_quickly());
        evaluator_input.setText(property.getEvaluator());
        arv_input.setText(Double.toString(property.getArv()));
        repair_cost_input.setText(Double.toString(property.getRepair_cost()));
        likely_purchase_checkbox.setChecked(property.isLikely_purchase());
        exit_strategy_input.setText(property.getExit_strategy());
        offer_1_input.setText(Double.toString(property.getOffer_1()));
        offer_2_input.setText(Double.toString(property.getOffer_2()));
    }

    public void new_property(){
        property = new Property();
        property.setId(0);
        id=0;
        property_name_input.setText("");
        property_address_spinner.setSelection(0);
        style_input.setText("");
        sqft_input.setText("");
        lot_size_input.setText("");
        year_built_input.setText("");
        multi_checkbox.setChecked(false);
        is_occupied_checkbox.setChecked(false);
        owner_occupied_checkbox.setChecked(false);
        special_features_input.setText("");
        upgrades_input.setText("");
        is_listed_checkbox.setChecked(false);
        listing_date_input.setText("");
        other_offers_checkbox.setChecked(false);
        offer_amount_input.setText("");
        realtor_input.setText("");
        realtor_phone_input.setText("");
        reason_selling_input.setText("");
        time_frame_input.setText("");
        no_sell_cont_input.setText("");
        mortgage_amount_input.setText("");
        has_liens_checkbox.setChecked(false);
        multiple_mortgages_checkbox.setChecked(false);
        payment_current_checkbox.setChecked(false);
        months_behind_input.setText("");
        amount_behind_input.setText("");
        back_taxes_input.setText("");
        other_lien_input.setText("");
        monthly_payment_input.setText("");
        tax_amount_input.setText("");
        insurance_amount_input.setText("");
        fixed_interest_checkbox.setText("");
        interest_1_input.setText("");
        interest_2_input.setText("");
        payment_penalty_input.setText("");
        mortgage_company_1_input.setText("");
        mortgage_company_2_input.setText("");
        asking_price_input.setText("");
        flexible_checkbox.setChecked(false);
        price_derived_input.setText("");
        best_price_fast_close_input.setText("");
        bottom_price_input.setText("");
        subject_to_checkbox.setChecked(false);
        accept_quickly_checkbox.setChecked(false);
        evaluator_input.setText("");
        arv_input.setText("");
        repair_cost_input.setText("");
        likely_purchase_checkbox.setChecked(false);
        exit_strategy_input.setText("");
        offer_1_input.setText("");
        offer_2_input.setText("");
    }
    
    public boolean save_property(){
        if(validator.validate()){
            property.setProperty_name(property_name_input.getText().toString());
            property.setAddress_id(((Address)property_address_spinner.getSelectedItem()).getId());
            property.setStyle(style_input.getText().toString());
            property.setSq_ft(Integer.parseInt(sqft_input.getText().toString()));
            property.setLot_size(Integer.parseInt(lot_size_input.getText().toString()));
            property.setYear_built(Integer.parseInt(year_built_input.getText().toString()));
            property.setIs_multi_unit(multi_checkbox.isChecked());
            property.setIs_occupied(is_occupied_checkbox.isChecked());
            property.setIs_owner_occupied(owner_occupied_checkbox.isChecked());
            property.setSpecial_features(special_features_input.getText().toString());
            property.setUpgrades(upgrades_input.getText().toString());
            property.setIs_listed(is_listed_checkbox.isChecked());
            property.setListing_date(listing_date_input.getText().toString());
            property.setHas_other_offers(other_offers_checkbox.isChecked());
            property.setOffer_amount(Double.parseDouble(offer_amount_input.getText().toString()));
            property.setRealtor(realtor_input.getText().toString());
            property.setRealtor_phone(realtor_phone_input.getText().toString());
            property.setReason_for_selling(reason_selling_input.getText().toString());
            property.setTime_frame(time_frame_input.getText().toString());
            property.setNo_sell_contingency(no_sell_cont_input.getText().toString());
            property.setMortgage_amount(Double.parseDouble(mortgage_amount_input.getText().toString()));
            property.setHas_liens(has_liens_checkbox.isChecked());
            property.setHas_multiple_mortgages(multiple_mortgages_checkbox.isChecked());
            property.setIs_payment_current(payment_current_checkbox.isChecked());
            property.setMonths_behind(Integer.parseInt(months_behind_input.getText().toString()));
            property.setAmount_behind(Double.parseDouble(amount_behind_input.getText().toString()));
            property.setBack_taxes(Double.parseDouble(back_taxes_input.getText().toString()));
            property.setOther_lien_amount(Double.parseDouble(other_lien_input.getText().toString()));
            property.setMonthly_payment(Double.parseDouble(monthly_payment_input.getText().toString()));
            property.setTax_amount(Double.parseDouble(tax_amount_input.getText().toString()));
            property.setInsurance_amount(Double.parseDouble(insurance_amount_input.getText().toString()));
            property.setIs_fixed_rate(fixed_interest_checkbox.isChecked());
            property.setFirst_interest_rate(Double.parseDouble(interest_1_input.getText().toString()));
            property.setSecond_interest_rate(Double.parseDouble(interest_2_input.getText().toString()));
            property.setPayment_penalty(Double.parseDouble(payment_penalty_input.getText().toString()));
            property.setMortgage_company_1(mortgage_company_1_input.getText().toString());
            property.setGetMortgage_company_2(mortgage_company_2_input.getText().toString());
            property.setAsking_price(Double.parseDouble(asking_price_input.getText().toString()));
            property.setIs_flexible(flexible_checkbox.isChecked());
            property.setHow_price_derived(price_derived_input.getText().toString());
            property.setBest_price_cash_fast_close(Double.parseDouble(best_price_fast_close_input.getText().toString()));
            property.setAbsolute_bottom_price(Double.parseDouble(bottom_price_input.getText().toString()));
            property.setWill_subject_to(subject_to_checkbox.isChecked());
            property.setCan_accept_quickly(accept_quickly_checkbox.isChecked());
            property.setEvaluator(evaluator_input.getText().toString());
            property.setArv(Double.parseDouble(arv_input.getText().toString()));
            property.setRepair_cost(Double.parseDouble(repair_cost_input.getText().toString()));
            property.setLikely_purchase(likely_purchase_checkbox.isChecked());
            property.setExit_strategy(exit_strategy_input.getText().toString());
            property.setOffer_1(Double.parseDouble(offer_1_input.getText().toString()));
            property.setOffer_2(Double.parseDouble(offer_2_input.getText().toString()));
            if(pc.saveProperty(property)){
                Toast.makeText(PropertyDetailActivity.this, "Saved Property", Toast.LENGTH_LONG).show();
                id=property.getId();
            }
            return true;
        }
        else{
            return false;
        }
    }

    public void delete_property(){
        new AlertDialog.Builder(this)
                .setTitle("Confirm")
                .setMessage("Delete?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        property.setId(id);
                        pc.Delete(property);
                        new_property();
                        Toast.makeText(PropertyDetailActivity.this, "Deleted Property", Toast.LENGTH_LONG).show();
                    }})
                .setNegativeButton(android.R.string.no, null).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        fetch_property();
    }


}
