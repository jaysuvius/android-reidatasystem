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
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.mayps.reidatasystem.Controllers.AddressController;
import com.mayps.reidatasystem.Models.Address;

public class AddressDetailActivity extends AppCompatActivity {

    private EditText address_1_input;
    private EditText address_2_input;
    private EditText city_input;
    private EditText state_input;
    private EditText zip_input;
    private EditText county_input;
    private AddressController ac;
    private Address address;
    private long id;
    private AwesomeValidation validator = new AwesomeValidation(ValidationStyle.BASIC);

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
                saveAddress();
                break;
            case R.id.action_new:
                newAddress();
                break;
            case R.id.action_delete:
                deleteAddress();
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
        setContentView(R.layout.activity_address_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getInputs();

        Bundle extrasBundle = getIntent().getExtras();
        id = 0;
        if (!extrasBundle.isEmpty()) {
            id = extrasBundle.getLong("id");
        }
        ac = new AddressController(getApplicationContext());
        Uri uri = Uri.parse("content://" + ac._provider.getAuthority() + "/" + ac._provider.get_table() + "/" + id);

        address = (Address)ac.getById(uri);

        if(address == null){
            newAddress();
        }
        else{
            fetchAddress();
        }

    }

    private void getInputs(){
        address_1_input = findViewById(R.id.address_1_input);
        address_2_input = findViewById(R.id.address_2_input);
        city_input = findViewById(R.id.city_input);
        state_input = findViewById(R.id.state_input);
        zip_input = findViewById(R.id.zip_input);
        county_input = findViewById((R.id.county_input));

        validator.addValidation(zip_input, "^(0|[1-9][0-9]*)$", "Numeric Required");

    }

    private void newAddress(){
        address = new Address();
        id = 0;
        address_1_input.setText("");
        address_2_input.setText("");
        city_input.setText("");
        state_input.setText("");
        zip_input.setText("");
        county_input.setText("");
    }

    private void fetchAddress(){
        id = address.getId();
        address_1_input.setText(address.getAddress_1());
        address_2_input.setText(address.getAddress_2());
        city_input.setText(address.getCity());
        state_input.setText(address.getState());
        zip_input.setText(address.getZip());
        county_input.setText(address.getCounty());
    }

    private void saveAddress(){
        if(validator.validate()){
            address.setId(id);
            address.setAddress_1(address_1_input.getText().toString());
            address.setAddress_2(address_2_input.getText().toString());
            address.setCity(city_input.getText().toString());
            address.setZip((zip_input.getText().toString()));
            address.setState(state_input.getText().toString());
            address.setCounty(county_input.getText().toString());
            if(ac.saveAddress(address))
                Toast.makeText(AddressDetailActivity.this, "Saved Address", Toast.LENGTH_LONG).show();
            id=address.getId();
        }

    }

    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putLong("id", id);
    }

    private void deleteAddress(){
        new AlertDialog.Builder(this)
                .setTitle("Confirm")
                .setMessage("Delete?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        address.setId(id);
                        ac.Delete(address);
                        finish();
                        Toast.makeText(AddressDetailActivity.this, "Deleted Address", Toast.LENGTH_LONG).show();
                    }})
                .setNegativeButton(android.R.string.no, null).show();
    }

    @Override
    public void onResume() {
        super.onResume();

        fetchAddress();
    }
}
