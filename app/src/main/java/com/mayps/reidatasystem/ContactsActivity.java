package com.mayps.reidatasystem;

import android.content.Intent;
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
import android.widget.ListView;

import com.mayps.reidatasystem.Adapters.ContactAdapter;
import com.mayps.reidatasystem.Controllers.ContactController;
import com.mayps.reidatasystem.Models.Contact;
import com.mayps.reidatasystem.Models.Company;

import java.util.List;

public class ContactsActivity extends AppCompatActivity {

    private List<Contact> contactes;
    private ListView list;
    private Contact contact;

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
                launch_contact_detail(0);
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
        setContentView(R.layout.activity_contacts);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fetch_contactes();

        list.setOnItemClickListener((arg0, arg1, position, arg3) -> {
            Contact selectedItem = (Contact) arg0.getItemAtPosition(position);
            launch_contact_detail(selectedItem.getId());
        });


    }

    public void fetch_contactes(){

        ContactController ac = new ContactController(getApplicationContext());

        contactes = ac.getAll();

        list = findViewById(R.id.contacts_listview);

        ArrayAdapter<Contact> adapter = new ContactAdapter(ContactsActivity.this, contactes);

        list.setAdapter(adapter);
    }

    public void launch_contact_detail(long id){
        Intent intent = new Intent(this, ContactDetailActivity.class);
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
        fetch_contactes();
    }

}
