package com.mayps.reidatasystem.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mayps.reidatasystem.Models.Company;
import com.mayps.reidatasystem.R;

import java.lang.reflect.Array;
import java.util.List;

public class CompanyAdapter extends ArrayAdapter<Company> {

    private final Activity context;
    private final List<Company> items;

    public CompanyAdapter(Activity context, List<Company> items){
        super(context, R.layout.company_layout, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent){
        LayoutInflater inflator =  context.getLayoutInflater();
        View rowView = inflator.inflate(R.layout.company_layout, null, true);

        TextView itemName = (TextView) rowView.findViewById(R.id.company_id);
        TextView areaName = (TextView) rowView.findViewById(R.id.company_name);

        itemName.setText(Long.toString(items.get(position).getId()));
        areaName.setText(items.get(position).getCompany_name());

        return rowView;
    }
}
