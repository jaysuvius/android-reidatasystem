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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mayps.reidatasystem.Controllers.ContactController;
import com.mayps.reidatasystem.Models.Address;
import com.mayps.reidatasystem.Models.Contact;

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

    private ContactController ac;
    private Contact contact;
    private long id;

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
                saveContact();
                break;
            case R.id.action_new:
                newContact();
                break;
            case R.id.action_delete:
                deleteContact();
                newContact();
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
        ac = new ContactController(getApplicationContext());
        Uri uri = Uri.parse("content://" + ac._provider.getAuthority() + "/" + ac._provider.get_table() + "/" + id);

        contact = (Contact)ac.getById(uri);

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
        is_realtor_checkbox = findViewById(R.id.realtor_checkbox);
        is_title_checkbox = findViewById(R.id.title_checkbox);
        is_broker_checkbox = findViewById(R.id.broker_checkbox);
        licesnseNo = findViewById(R.id.license_input);
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
        first_name_input.setText(contact.getFirst_name());
        last_name_input.setText(contact.getLast_name());
        middle_initial_input.setText(contact.getMiddle_initial());
        //contact_address_spinner.setSelection()
        mobile_phone_input.setText(contact.getMobile_phone());
        work_phone_input.setText(contact.getWork_phone());
        is_title_checkbox.setChecked(contact.is_title());
        is_realtor_checkbox.setChecked(contact.is_realtor());
        is_broker_checkbox.setChecked(contact.is_broker());
        licesnseNo.setText(contact.getRealtor_license());
    }

    private void saveContact(){
        contact.setId(id);
        contact.setFirst_name(first_name_input.getText().toString());
        contact.setLast_name(last_name_input.getText().toString());
        contact.setMiddle_initial(middle_initial_input.getText().toString());
       /// contact.setAddress_id(Long.toString(((Address)contact_address_spinner.getSelectedItemId()).getId()));
        contact.setMobile_phone(mobile_phone_input.getText().toString());
        contact.setWork_phone(work_phone_input.getText().toString());
        contact.setIs_realtor(is_realtor_checkbox.isChecked());
        contact.setIs_broker(is_broker_checkbox.isChecked());
        is_title_checkbox.setChecked(false);
        is_realtor_checkbox.setChecked(false);
        licesnseNo.setText("");
        ac.saveContact(contact);
    }

    private void deleteContact(){
        new AlertDialog.Builder(this)
                .setTitle("Confirm")
                .setMessage("Delete?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        contact.setId(id);
                        ac.Delete(contact);
                        newContact();
                        Toast.makeText(ContactDetailActivity.this, "Deleted Contact", Toast.LENGTH_LONG).show();
                    }})
                .setNegativeButton(android.R.string.no, null).show();
    }

    @Override
    public void onResume() {
        super.onResume();

        //fetchContact();
    }

}
