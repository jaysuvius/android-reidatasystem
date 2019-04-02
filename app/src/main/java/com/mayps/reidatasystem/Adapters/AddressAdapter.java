package com.mayps.reidatasystem.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mayps.reidatasystem.Models.Address;
import com.mayps.reidatasystem.Models.Company;
import com.mayps.reidatasystem.R;

import java.util.List;

    public class AddressAdapter extends ArrayAdapter<Address> {

        private final Activity context;
        private final List<Address> items;

        public AddressAdapter(Activity context, List<Address> items) {
            super(context, R.layout.address_layout, items);
            this.context = context;
            this.items = items;
        }

        @Override
        public View getView(final int position, View view, ViewGroup parent) {
            LayoutInflater inflator = context.getLayoutInflater();
            View rowView = inflator.inflate(R.layout.address_layout, null, true);

            TextView itemName = (TextView) rowView.findViewById(R.id.adapter_address_id);
            TextView areaName = (TextView) rowView.findViewById(R.id.adapter_address_1);

            itemName.setText(Long.toString(items.get(position).getId()));
            areaName.setText(items.get(position).getAddress_1());

            return rowView;
        }
}
