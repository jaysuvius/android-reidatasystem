package com.mayps.reidatasystem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.mayps.reidatasystem.Controllers.RepairController;
import com.mayps.reidatasystem.Models.Repair;

import java.util.List;

public class RepairsActivity extends AppCompatActivity {

    private List<Repair> repairs;
    private ListView list;
    EditText searchRepairsEditText;
    private long property_id;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.entity_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add:
                launch_repair_detail(0);
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
        setContentView(R.layout.activity_repairs);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fetch_repairs();

        list.setOnItemClickListener((arg0, arg1, position, arg3) -> {
            Repair selectedItem = (Repair) arg0.getItemAtPosition(position);
            launch_repair_detail(selectedItem.getId());
            property_id = selectedItem.getProperty_id();
        });

    }

    public void fetch_repairs(){

        RepairController rc = new RepairController(getApplicationContext());

        Bundle extrasBundle = getIntent().getExtras();
        if (!extrasBundle.isEmpty()) {
            property_id = extrasBundle.getLong("propertyId");
        }

        Uri uri = Uri.parse("content://" + rc._provider.getAuthority() + "/" + rc._provider.get_table() + "/" + property_id);
        repairs = rc.getByPropertyId(uri);

        list = findViewById(R.id.repairsListview);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, repairs);
        list.setAdapter(adapter);


        searchRepairsEditText = findViewById(R.id.searchRepairsEditText);

        searchRepairsEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void launch_repair_detail(long id){
        Intent intent = new Intent(this, RepairDetailActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("propertyId", property_id);
        startActivity(intent);
    }

    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        //savedInstanceState.putLong("id", repair_layout.getId());
    }

    @Override
    public void onResume() {
        super.onResume();
        fetch_repairs();
    }
}
