package com.mayps.reidatasystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button companies_button = findViewById(R.id.companies_button);
        companies_button.setOnClickListener(view -> launch_companies_activity(view));

        final Button contacts_button = findViewById(R.id.contacts_button);
        contacts_button.setOnClickListener(view -> launch_contacts_activity(view));

        final Button properties_button = findViewById(R.id.properties_button);
        properties_button.setOnClickListener(view -> launch_properties_activity(view));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void launch_companies_activity(View view){
        Intent intent = new Intent(this, CompaniesActivity.class);
        startActivity(intent);
    }

    public void launch_contacts_activity(View view){

    }

    public void launch_properties_activity(View view){

    }

}
