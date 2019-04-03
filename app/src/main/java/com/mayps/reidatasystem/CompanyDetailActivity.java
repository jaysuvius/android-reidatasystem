package com.mayps.reidatasystem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mayps.reidatasystem.Controllers.AddressController;
import com.mayps.reidatasystem.Controllers.CompanyController;
import com.mayps.reidatasystem.Controllers.CompanyTypeController;
import com.mayps.reidatasystem.Controllers.ContactController;
import com.mayps.reidatasystem.Models.Address;
import com.mayps.reidatasystem.Models.Company;
import com.mayps.reidatasystem.Models.CompanyType;
import com.mayps.reidatasystem.Models.Contact;

import java.util.ArrayList;
import java.util.List;

public class CompanyDetailActivity extends AppCompatActivity {

    private EditText company_name_input;
    private Spinner company_type_spinner;
    private Spinner address_spinner;
    private Spinner contact_spinner;
    private Button select_address_button;
    private TextView address1TextView;
    private Button select_contact_button;
    private TextView contact1Text;
    private EditText phone_input;
    private EditText fax_input;
    private EditText email_input;
    private CompanyController cc;
    private Company company;
    private AddressController ac;
    private Address address;
    private ContactController conc;
    private Contact contact;
    private CompanyTypeController ctc;
    private CompanyType companyType;
    private long id;
    private long addressId;
    private long contactId;
    ArrayAdapter<CompanyType> ctAdapter;
    List<CompanyType> types;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entity_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_save:
                saveCompany();
                break;
            case R.id.action_new:
                newCompany();
                break;
            case R.id.action_delete:
                deleteCompany();
                newCompany();
                break;
            case android.R.id.home:
                Intent intent = NavUtils.getParentActivityIntent(this);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                NavUtils.navigateUpTo(this, intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setup_inputs();

        ctc = new CompanyTypeController(getApplicationContext());
        types = ctc.getAll();

        ctAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, types);

        company_type_spinner.setAdapter(ctAdapter);

        ac = new AddressController(getApplicationContext());
        List<Address> addresses = ac.getAll();
        ArrayAdapter aAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, addresses);

        address_spinner.setAdapter(aAdapter);

        conc = new ContactController(getApplicationContext());
        List<Contact> contacts = conc.getAll();
        ArrayAdapter conAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        contact_spinner.setAdapter(conAdapter);

        cc = new CompanyController(getApplicationContext());

        Bundle extrasBundle = getIntent().getExtras();
        id = 0;
        if (!extrasBundle.isEmpty()) {
            id = extrasBundle.getLong("id");
        }

        Uri uri = Uri.parse("content://" + cc._provider.getAuthority() + "/" + cc._provider.get_table() + "/" + id);

        company = (Company)cc.getById(uri);

        if(company == null){
            newCompany();
        }
        else{
            fetch_company();
        }

    }

    private void setup_inputs(){
        company_name_input = findViewById(R.id.company_name_input);
        company_type_spinner = findViewById(R.id.company_type_spinner);
        address_spinner = findViewById(R.id.address_spinner);
        contact_spinner = findViewById(R.id.contact_spinner);
        select_address_button = findViewById(R.id.select_address_button);
        address1TextView = findViewById(R.id.address1Text);
        select_contact_button = findViewById(R.id.select_contact_button);
        contact1Text = findViewById(R.id.contact1Text);
        phone_input = findViewById(R.id.phone_input);
        fax_input = findViewById(R.id.fax_input);
        email_input = findViewById(R.id.email_input);
    }


    private void fetch_company(){
        id = company.getId();
        company_name_input.setText(company.getCompany_name());
        for (int i = 0; i < company_type_spinner.getCount(); i++){
            if (((CompanyType)company_type_spinner.getItemAtPosition(i)).getId() == company.getCompany_type()){
                company_type_spinner.setSelection(i);
            }
        }
        for(int i = 0;  i< address_spinner.getCount(); i++){
            if (((Address)address_spinner.getItemAtPosition(i)).getId() == company.getAddress_id()){
                address_spinner.setSelection(i);
            }
        }
        for (int i = 0; i < contact_spinner.getCount(); i++){
            if(((Contact)contact_spinner.getItemAtPosition(i)).getId() == company.getPrimary_contact_id()){
                contact_spinner.setSelection(i);
            }
        }
        phone_input.setText(company.getPhone_number());
        fax_input.setText(company.getFax_number());
        email_input.setText(company.getEmail_address());
    }

    private void newCompany(){
        if(company == null) company = new Company();
        company.setId(0);
        company_name_input.setText("");
        company_type_spinner.setSelection(0);
        company.setAddress_id(0);
        company.setPrimary_contact_id(0);
        phone_input.setText("");
        fax_input.setText("");
        email_input.setText("");
    }

    private void saveCompany(){
        company.setId(id);
        company.setCompany_name(company_name_input.getText().toString());
        company.setCompany_type(((CompanyType)company_type_spinner.getSelectedItem()).getId());
        company.setAddress_id(((Address)address_spinner.getSelectedItem()).getId());
        company.setPrimary_contact_id(((Contact)contact_spinner.getSelectedItem()).getId());
        company.setPhone_number(phone_input.getText().toString());
        company.setFax_number(fax_input.getText().toString());
        company.setEmail_address(email_input.getText().toString());
        if(cc.saveCompany(company))
            Toast.makeText(CompanyDetailActivity.this, "Saved Company", Toast.LENGTH_LONG).show();
    }

    private void deleteCompany(){
        new AlertDialog.Builder(this)
                .setTitle("Confirm")
                .setMessage("Delete?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        company.setId(id);
                        cc.Delete(company);
                        newCompany();
                        Toast.makeText(CompanyDetailActivity.this, "Deleted Course", Toast.LENGTH_LONG).show();
                    }})
                .setNegativeButton(android.R.string.no, null).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        fetch_company();
    }


}
