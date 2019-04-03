package com.mayps.reidatasystem.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mayps.reidatasystem.Models.Property;
import com.mayps.reidatasystem.R;

import java.util.List;

public class PropertyAdapter extends ArrayAdapter<Property> {

    private final Activity context;
    private final List<Property> items;

    public PropertyAdapter(Activity context, List<Property> items) {
        super(context, R.layout.property_layout, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflator = context.getLayoutInflater();
        View rowView = inflator.inflate(R.layout.property_layout, null, true);

        TextView itemName = (TextView) rowView.findViewById(R.id.adapter_property_id);
        TextView areaName = (TextView) rowView.findViewById(R.id.adapter_proptery_name);

        itemName.setText(Long.toString(items.get(position).getId()));
        areaName.setText(items.get(position).getProperty_name());

        return rowView;
    }
}
