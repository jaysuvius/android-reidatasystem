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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.mayps.reidatasystem.Controllers.AddressController;
import com.mayps.reidatasystem.Controllers.UnitController;
import com.mayps.reidatasystem.Models.Address;
import com.mayps.reidatasystem.Models.Unit;

import java.util.List;

public class UnitDetailActivity extends AppCompatActivity {

    private EditText unit_number_input;
    private EditText sq_ft_input;
    private EditText bedroom_count_intput;
    private EditText bathroom_count_input;
    private EditText rent_amount_input;
    private CheckBox is_occupied_input;
    private EditText special_features_input;
    private Unit unit;
    private long id;
    private long propertyId;
    private AwesomeValidation validator = new AwesomeValidation(ValidationStyle.BASIC);
    private UnitController uc;

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
                saveUnit();
                break;
            case R.id.action_new:
                newUnit();
                break;
            case R.id.action_delete:
                deleteUnit();
                newUnit();
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
        setContentView(R.layout.activity_unit_detail);
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

        getInputs();

        uc = new UnitController(getApplicationContext());
        Bundle extrasBundle = getIntent().getExtras();
        id = 0;
        if (!extrasBundle.isEmpty()) {
            id = extrasBundle.getLong("id");
            propertyId = extrasBundle.getLong("propertyId");
        }
        uc = new UnitController(getApplicationContext());
        Uri uri = Uri.parse("content://" + uc._provider.getAuthority() + "/" + uc._provider.get_table() + "/" + id);

        unit = (Unit)uc.getById(uri);

        if(unit == null){
            newUnit();
        }
        else{
            fetchUnit();
        }
    }
    
    private void getInputs(){
         unit_number_input = findViewById(R.id.unit_number_input);
         sq_ft_input = findViewById(R.id.unit_sqft_input);
         validator.addValidation(sq_ft_input, "^(0|[1-9][0-9]*)$", "Numeric");
         bedroom_count_intput = findViewById(R.id.bed_count_input);
         validator.addValidation(bedroom_count_intput, "^(0|[1-9][0-9]*)$", "Numeric");
         bathroom_count_input = findViewById(R.id.bath_count_input);
         validator.addValidation(bathroom_count_input, "^(0|[1-9][0-9]*)$", "Numeric");
         rent_amount_input = findViewById(R.id.rent_amount_input);
         validator.addValidation(rent_amount_input, "^(0|[1-9][0-9]*)$", "Numeric");
         is_occupied_input = findViewById(R.id.is_unit__occupied_checkbox);
         special_features_input = findViewById(R.id.unit_special_features_input);
    }
    
    private void newUnit(){
        unit = new Unit();
        unit.setProperty_id(propertyId);
        unit_number_input.setText("");
        bedroom_count_intput.setText("");
        bathroom_count_input.setText("");
        rent_amount_input.setText("");
        is_occupied_input.setText("");
        special_features_input.setText("");
    }
    
    private void fetchUnit(){
        propertyId = unit.getProperty_id();
        unit_number_input.setText(unit.getUnit_number());
        bedroom_count_intput.setText(unit.getBedroom_count());
        bathroom_count_input.setText(unit.getBathroom_count());
        rent_amount_input.setText(Double.toString(unit.getRent_amount()));
        is_occupied_input.setChecked(unit.is_occupied());
        special_features_input.setText(unit.getSpecial_features());
        
    }

    private void saveUnit() {
        if (validator.validate()) {
            unit.setId(id);
            unit.setProperty_id(propertyId);
            unit.setUnit_number(unit_number_input.getText().toString());
            unit.setBedroom_count(Integer.parseInt(bedroom_count_intput.getText().toString()));
            unit.setBathroom_count(Integer.parseInt(bathroom_count_input.getText().toString()));
            unit.setRent_amount(Double.parseDouble(rent_amount_input.getText().toString()));
            unit.setIs_occupied(is_occupied_input.isChecked());
            unit.setSpecial_features(special_features_input.getText().toString());
            if (uc.saveUnit(unit))
                Toast.makeText(UnitDetailActivity.this, "Saved Unit", Toast.LENGTH_LONG).show();
        }
    }

        private void deleteUnit(){
            new AlertDialog.Builder(this)
                    .setTitle("Confirm")
                    .setMessage("Delete?")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int whichButton) {
                            unit.setId(id);
                            uc.Delete(unit);
                            newUnit();
                            Toast.makeText(UnitDetailActivity.this, "Deleted Unit", Toast.LENGTH_LONG).show();
                        }})
                    .setNegativeButton(android.R.string.no, null).show();
        }

}
