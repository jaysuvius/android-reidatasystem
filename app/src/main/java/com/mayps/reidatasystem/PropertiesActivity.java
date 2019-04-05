package com.mayps.reidatasystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.mayps.reidatasystem.Controllers.PropertyController;
import com.mayps.reidatasystem.Models.Property;

import java.util.List;

public class PropertiesActivity extends AppCompatActivity {


    private List<Property> properties;
    private ListView list;
    private Property property;
    private EditText searchPropertiesEditText;

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
                launch_property_detail(0);
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
        setContentView(R.layout.activity_properties);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fetch_properties();

        list.setOnItemClickListener((arg0, arg1, position, arg3) -> {
            Property selectedItem = (Property) arg0.getItemAtPosition(position);
            launch_property_detail(selectedItem.getId());
        });

    }

    public void fetch_properties(){

        PropertyController ac = new PropertyController(getApplicationContext());

        properties = ac.getAll();

        list = findViewById(R.id.properties_listview);

        ArrayAdapter<Property> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, properties);

        list.setAdapter(adapter);

        searchPropertiesEditText = findViewById(R.id.searchPropertiesEditText);

        searchPropertiesEditText.addTextChangedListener(new TextWatcher() {
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

    public void launch_property_detail(long id){
        Intent intent = new Intent(this, PropertyDetailActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        //savedInstanceState.putLong("id", company_layout.getId());
    }

    @Override
    public void onResume() {
        super.onResume();
        fetch_properties();
    }
}
