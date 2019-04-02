package com.mayps.reidatasystem.Controllers;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.mayps.reidatasystem.DAL.AddressProvider;
import com.mayps.reidatasystem.Models.Address;
import com.mayps.reidatasystem.Models.Entity;
import com.mayps.reidatasystem.Utils.Constants;

public class AddressController extends AbstractController {

    public AddressController(Context c){
        super(c, AddressProvider.getInstance());
    }

    public boolean saveAddress(Address entity){
        try{
            Uri uri = Uri.parse("entity://" + _provider.getAuthority() + "/" + _provider.get_table() + "/" + entity.getId());
            Address a = (Address) getById(uri);
            if (a == null || entity.getId() == 0){
                Uri rtnVal = Insert(entity);
                entity.setId(ContentUris.parseId(rtnVal));
            }
            else{
                int rtnVal = Update(entity);
            }
            return true;
        }
        catch (Exception ex){
            throw ex;
        }
    }

    protected Address parse(Cursor addressCursor) {
        return new Address(addressCursor.getInt(addressCursor.getColumnIndex(Constants.ADDRESS_ID)),
                addressCursor.getString(addressCursor.getColumnIndex(Constants.ADDRESS_1)),
                addressCursor.getString(addressCursor.getColumnIndex(Constants.ADDRESS_2)),
                addressCursor.getString(addressCursor.getColumnIndex(Constants.ADDRESS_CITY)),
                addressCursor.getString(addressCursor.getColumnIndex(Constants.ADDRESS_STATE)),
                addressCursor.getString(addressCursor.getColumnIndex(Constants.ADDRESS_ZIP)),
                addressCursor.getString(addressCursor.getColumnIndex(Constants.ADDRESS_COUNTY)));
    }

    @Override
    ContentValues getContentValues(Entity entity) {
        ContentValues cv = new ContentValues();
        Address address = (Address) entity;
        cv.put(Constants.ADDRESS_ID, address.getId());
        cv.put(Constants.ADDRESS_1, address.getAddress_1());
        cv.put(Constants.ADDRESS_2, address.getAddress_2());
        cv.put(Constants.ADDRESS_CITY, address.getCity());
        cv.put(Constants.ADDRESS_STATE, address.getState());
        cv.put(Constants.ADDRESS_ZIP, address.getZip());
        cv.put(Constants.ADDRESS_COUNTY, address.getCounty());
        return cv;
    }

    @Override
    ContentValues getInsertValues(Entity entity) {
        ContentValues cv = new ContentValues();
        Address address = (Address) entity;
        cv.put(Constants.ADDRESS_1, address.getAddress_1());
        cv.put(Constants.ADDRESS_2, address.getAddress_2());
        cv.put(Constants.ADDRESS_CITY, address.getCity());
        cv.put(Constants.ADDRESS_STATE, address.getState());
        cv.put(Constants.ADDRESS_ZIP, address.getZip());
        cv.put(Constants.ADDRESS_COUNTY, address.getCounty());
        return cv;
    }
    
}
