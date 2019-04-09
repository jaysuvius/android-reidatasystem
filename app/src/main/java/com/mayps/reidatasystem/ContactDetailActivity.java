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
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.mayps.reidatasystem.Controllers.AddressController;
import com.mayps.reidatasystem.Controllers.ContactController;
import com.mayps.reidatasystem.Models.Address;
import com.mayps.reidatasystem.Models.Contact;

import java.util.List;

public class ContactDetailActivity extends AppCompatActivity {

    private EditText first_name_input;
    private EditText last_name_input;
    private EditText middle_initial_input;
    private Spinner contact_address_spinner;
    private EditText mobile_phone_input;
    private EditText work_phone_input;
    private EditText email_input;
    private CheckBox is_realtor_checkbox;
    private CheckBox is_broker_checkbox;
    private CheckBox is_title_checkbox;
    private EditText licesnseNo;

    private ContactController cc;
    private Contact contact;
    private long id;

    private AddressController ac;
    private Address address;
    private int addressId;
    private List<Address> addresses;
    private ArrayAdapter<Address> addyAdapter;
    private AwesomeValidation validator = new AwesomeValidation(ValidationStyle.BASIC);;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entity_detail, menu);
        getMenuInflater().inflate(R.menu.menu_add_address, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_save:
                saveContact();
                break;
            case R.id.action_new:
                newContact();
                break;
            case R.id.action_delete:
                deleteContact();
                newContact();
                break;
            case R.id.add_address:
                launch_address();
                break;
            case android.R.id.home:
                Intent intent = NavUtils.getParentActivityIntent(this);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                NavUtils.navigateUpTo(this, intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void launch_address(){
            new AlertDialog.Builder(this)
                    .setTitle("Contact must be saved to add address")
                    .setMessage("Save??")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int whichButton) {
                            Toast.makeText(ContactDetailActivity.this, "Save Contact First", Toast.LENGTH_LONG).show();
                            if(saveContact())
                                goToAdressDetailIntent();
                        }
                    })
                    .setNegativeButton(android.R.string.no, null).show();
    }


    private void goToAdressDetailIntent() {
        Intent intent = new Intent(this, AddressDetailActivity.class);
        intent.putExtra("id", 0);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getInputs();

        Bundle extrasBundle = getIntent().getExtras();
        id = 0;
        if (!extrasBundle.isEmpty()) {
            id = extrasBundle.getLong("id");
        }
        cc = new ContactController(getApplicationContext());
        Uri uri = Uri.parse("content://" + cc._provider.getAuthority() + "/" + cc._provider.get_table() + "/" + id);

        contact = (Contact) cc.getById(uri);

        if(contact == null){
            newContact();
        }
        else{
            fetchContact();
        }

    }

    private void getInputs(){
        first_name_input = findViewById(R.id.first_name_input);
        last_name_input = findViewById(R.id.last_name_input);
        middle_initial_input = findViewById(R.id.middle_initial_input);
        contact_address_spinner = findViewById(R.id.contact_address_spinner);
        mobile_phone_input = findViewById(R.id.mobile_phone_input);
        work_phone_input = findViewById((R.id.work_phone_input));
        email_input = findViewById((R.id.email_input));
        validator.addValidation(email_input, Patterns.EMAIL_ADDRESS, "Valid Email Address");
        is_realtor_checkbox = findViewById(R.id.realtor_checkbox);
        is_title_checkbox = findViewById(R.id.title_checkbox);
        is_broker_checkbox = findViewById(R.id.broker_checkbox);
        licesnseNo = findViewById(R.id.license_input);

        validator.addValidation(mobile_phone_input, "^(0|[1-9][0-9]*)$", "Numeric Only");
        validator.addValidation(work_phone_input, "^(0|[1-9][0-9]*)$", "Numeric Only");
    }

    private void newContact(){
        contact = new Contact();
        id = 0;
        first_name_input.setText("");
        last_name_input.setText("");
        middle_initial_input.setText("");
        contact_address_spinner.setSelection(0);
        mobile_phone_input.setText("");
        work_phone_input.setText("");
        is_title_checkbox.setChecked(false);
        is_realtor_checkbox.setChecked(false);
        is_broker_checkbox.setChecked(false);
        licesnseNo.setText("");
    }

    private void fetchContact(){
        id = contact.getId();

        ac = new AddressController(getApplicationContext());
        addresses = ac.getAll();
        addyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, addresses);
        contact_address_spinner.setAdapter(addyAdapter);

        first_name_input.setText(contact.getFirst_name());
        last_name_input.setText(contact.getLast_name());
        middle_initial_input.setText(contact.getMiddle_initial());
        for (int i = 0; i < contact_address_spinner.getCount(); i++){
            if(((Address)contact_address_spinner.getItemAtPosition(i)).getId() == contact.getAddress_id()){
                contact_address_spinner.setSelection(i);
            }
        }
        mobile_phone_input.setText(contact.getMobile_phone());
        work_phone_input.setText(contact.getWork_phone());
        email_input.setText(contact.getEmail_address());
        is_title_checkbox.setChecked(contact.is_title());
        is_realtor_checkbox.setChecked(contact.is_realtor());
        is_broker_checkbox.setChecked(contact.is_broker());
        licesnseNo.setText(contact.getRealtor_license());
    }

    private boolean saveContact(){
        if(validator.validate()){
            contact.setId(id);
            contact.setFirst_name(first_name_input.getText().toString());
            contact.setLast_name(last_name_input.getText().toString());
            contact.setMiddle_initial(middle_initial_input.getText().toString());
            contact.setAddress_id(((Address)contact_address_spinner.getSelectedItem()).getId());
            contact.setMobile_phone(mobile_phone_input.getText().toString());
            contact.setWork_phone(work_phone_input.getText().toString());
            contact.setIs_realtor(is_realtor_checkbox.isChecked());
            contact.setIs_broker(is_broker_checkbox.isChecked());
            contact.setIs_title(is_title_checkbox.isChecked());
            contact.setIs_realtor(is_realtor_checkbox.isChecked());
            contact.setIs_broker(is_broker_checkbox.isChecked());
            contact.setRealtor_license(licesnseNo.getText().toString());
            if(cc.saveContact(contact))
                Toast.makeText(ContactDetailActivity.this, "Saved Contact", Toast.LENGTH_LONG).show();
            id=contact.getId();
            return true;
        }
        else
            return false;
    }

    private void deleteContact(){
        new AlertDialog.Builder(this)
                .setTitle("Confirm")
                .setMessage("Delete?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        contact.setId(id);
                        cc.Delete(contact);
                        newContact();
                        Toast.makeText(ContactDetailActivity.this, "Deleted Contact", Toast.LENGTH_LONG).show();
                    }})
                .setNegativeButton(android.R.string.no, null).show();
    }

    @Override
    public void onResume() {
        super.onResume();

        fetchContact();
    }

}
