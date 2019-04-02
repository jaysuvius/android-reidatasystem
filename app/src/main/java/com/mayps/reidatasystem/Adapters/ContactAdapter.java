package com.mayps.reidatasystem.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mayps.reidatasystem.Models.Address;
import com.mayps.reidatasystem.Models.Contact;
import com.mayps.reidatasystem.R;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    private final Activity context;
    private final List<Contact> items;

    public ContactAdapter(Activity context, List<Contact> items) {
        super(context, R.layout.contact_layout, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflator = context.getLayoutInflater();
        View rowView = inflator.inflate(R.layout.contact_layout, null, true);

        TextView itemName = (TextView) rowView.findViewById(R.id.adapter_contact_id);
        TextView areaName = (TextView) rowView.findViewById(R.id.adapter_contact_name);

        itemName.setText(Long.toString(items.get(position).getId()));
        areaName.setText(items.get(position).getContactName());

        return rowView;
    }
}