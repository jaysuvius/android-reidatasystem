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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.mayps.reidatasystem.Controllers.RepairController;
import com.mayps.reidatasystem.Controllers.RepairTypeController;
import com.mayps.reidatasystem.Models.Repair;
import com.mayps.reidatasystem.Models.RepairType;

import java.util.List;

public class RepairDetailActivity extends AppCompatActivity {

    private Spinner repair_type_spinner;
    private EditText repair_description_input;
    private Repair repair;
    private long id;
    private long propertyId;
    private AwesomeValidation validator = new AwesomeValidation(ValidationStyle.BASIC);
    private RepairController rc;
    private RepairTypeController rtc;

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
                saveRepair();
                break;
            case R.id.action_new:
                newRepair();
                break;
            case R.id.action_delete:
                deleteRepair();
                newRepair();
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
        setContentView(R.layout.activity_repair_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getInputs();

        Bundle extrasBundle = getIntent().getExtras();
        id = 0;
        if (!extrasBundle.isEmpty()) {
            id = extrasBundle.getLong("id");
            propertyId = extrasBundle.getLong("propertyId");
        }
        rc = new RepairController(getApplicationContext());
        Uri uri = Uri.parse("content://" + rc._provider.getAuthority() + "/" + rc._provider.get_table() + "/" + id);

        repair = (Repair)rc.getById(uri);

        if(repair == null){
            newRepair();
        }
        else{
            fetchRepair();
        }
    }

    private void getInputs(){
        repair_type_spinner = findViewById(R.id.repair_type_spinner);
        repair_description_input = findViewById(R.id.repair_description_input);
        rtc = new RepairTypeController(getApplicationContext());
        List<RepairType> types = rtc.getAll();
        ArrayAdapter<RepairType> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, types);
        repair_type_spinner.setAdapter(typeAdapter);
    }

    private void newRepair(){
        repair = new Repair();
        id = 0;
        repair.setId(0);
        repair.setProperty_id(propertyId);
        repair_type_spinner.setSelection(0);
        repair_description_input.setText("");
    }

    private void fetchRepair(){
        id = repair.getId();
        propertyId = repair.getProperty_id();
        repair_description_input.setText(repair.getRepair_description());
        for (int i =0; i<repair_type_spinner.getCount(); i++){
            if(((RepairType)repair_type_spinner.getItemAtPosition(i)).getId() == repair.getProperty_id()){
                repair_type_spinner.setSelection(i);
            }
        }

    }

    private void saveRepair() {
        if (validator.validate()) {
            repair.setId(id);
            repair.setProperty_id(propertyId);
            repair.setRepair_description(repair_description_input.getText().toString());
            repair.setRepair_type_id(((RepairType)repair_type_spinner.getSelectedItem()).getId());
            if (rc.saveRepair(repair))
                Toast.makeText(RepairDetailActivity.this, "Saved Repair", Toast.LENGTH_LONG).show();
            id=repair.getId();
        }
    }

    private void deleteRepair(){
        new AlertDialog.Builder(this)
                .setTitle("Confirm")
                .setMessage("Delete?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        repair.setId(id);
                        rc.Delete(repair);
                        newRepair();
                        Toast.makeText(RepairDetailActivity.this, "Deleted Repair", Toast.LENGTH_LONG).show();
                    }})
                .setNegativeButton(android.R.string.no, null).show();
    }

}
