package com.mayps.reidatasystem.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mayps.reidatasystem.Models.Company;
import com.mayps.reidatasystem.Models.CompanyType;
import com.mayps.reidatasystem.R;

import java.util.List;

public class CompanyTypeAdapter extends ArrayAdapter<CompanyType> {

    private final Activity context;
    private final List<CompanyType> items;

    public CompanyTypeAdapter(Activity context, List<CompanyType> items){
        super(context, R.layout.company_type_layout, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent){
        LayoutInflater inflator =  context.getLayoutInflater();
        View rowView = inflator.inflate(R.layout.company_type_layout, null, true);

        TextView itemName = (TextView) rowView.findViewById(R.id.adapter_company_type_id);
        TextView areaName = (TextView) rowView.findViewById(R.id.adapter_company_type_description);

        itemName.setText(Long.toString(items.get(position).getId()));
        areaName.setText(items.get(position).getCompany_type_description());

        return rowView;
    }
}
