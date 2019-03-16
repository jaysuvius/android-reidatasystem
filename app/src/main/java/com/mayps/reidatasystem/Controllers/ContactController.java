package com.mayps.reidatasystem.Controllers;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.mayps.reidatasystem.DAL.ContactProvider;
import com.mayps.reidatasystem.Models.Contact;
import com.mayps.reidatasystem.Models.Entity;
import com.mayps.reidatasystem.Utils.Constants;

public class ContactController extends AbstractController {

    public ContactController(Context c){
        super(c, ContactProvider.getInstance());
    }

    public boolean saveContact(Contact entity){
        try{
            Uri uri = Uri.parse("entity://" + _provider.getAuthority() + "/" + _provider.get_table() + "/" + entity.getId());
            Contact a = (Contact) getById(uri);
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

    protected Contact parse(Cursor contactCursor) {
        return new Contact(contactCursor.getInt(contactCursor.getColumnIndex(Constants.CONTACT_ID)),
                contactCursor.getString(contactCursor.getColumnIndex(Constants.CONTACT_FIRST_NAME)),
                contactCursor.getString(contactCursor.getColumnIndex(Constants.CONTACT_LAST_NAME)),
                contactCursor.getString(contactCursor.getColumnIndex(Constants.CONTACT_MIDDLE_INITIAL)),
                contactCursor.getLong(contactCursor.getColumnIndex(Constants.CONTACT_ADDRESS_ID)),
                contactCursor.getString(contactCursor.getColumnIndex(Constants.CONTACT_HOME_PHONE)),
                contactCursor.getString(contactCursor.getColumnIndex(Constants.CONTACT_MOBILE_PHONE)),
                contactCursor.getString(contactCursor.getColumnIndex(Constants.CONTACT_WORK_PHONE)),
                contactCursor.getString(contactCursor.getColumnIndex(Constants.CONTACT_EMAIL_ADDRESS)),
                contactCursor.getInt(contactCursor.getColumnIndex(Constants.CONTACT_IS_REALTOR)),
                contactCursor.getString(contactCursor.getColumnIndex(Constants.CONTACT_REALTOR_LICENSE)),
                contactCursor.getInt(contactCursor.getColumnIndex(Constants.CONTACT_IS_BROKER)),
                contactCursor.getInt(contactCursor.getColumnIndex(Constants.CONTACT_IS_TITLE)),
                contactCursor.getLong(contactCursor.getColumnIndex(Constants.CONTACT_COMPANY_ID)));
    }

    @Override
    ContentValues getContentValues(Entity entity) {
        ContentValues cv = new ContentValues();
        Contact contact = (Contact) entity;
        cv.put(Constants.CONTACT_ID, contact.getId());
        cv.put(Constants.CONTACT_FIRST_NAME, contact.getFirst_name());
        cv.put(Constants.CONTACT_LAST_NAME, contact.getLast_name());
        cv.put(Constants.CONTACT_MIDDLE_INITIAL, contact.getMiddle_initial());
        cv.put(Constants.CONTACT_ADDRESS_ID, contact.getAddress_id());
        cv.put(Constants.CONTACT_HOME_PHONE, contact.getHome_phone());
        cv.put(Constants.CONTACT_MOBILE_PHONE, contact.getMobile_phone());
        cv.put(Constants.CONTACT_WORK_PHONE, contact.getWork_phone());
        cv.put(Constants.CONTACT_EMAIL_ADDRESS, contact.getEmail_address());
        cv.put(Constants.CONTACT_IS_REALTOR, contact.is_realtor());
        cv.put(Constants.CONTACT_REALTOR_LICENSE, contact.getRealtor_license());
        cv.put(Constants.CONTACT_IS_BROKER, contact.is_broker());
        cv.put(Constants.CONTACT_IS_TITLE, contact.is_title());
        cv.put(Constants.CONTACT_COMPANY_ID, contact.getCompany_id());
        return cv;
    }

    @Override
    ContentValues getInsertValues(Entity entity) {
        ContentValues cv = new ContentValues();
        Contact contact = (Contact) entity;
        cv.put(Constants.CONTACT_FIRST_NAME, contact.getFirst_name());
        cv.put(Constants.CONTACT_LAST_NAME, contact.getLast_name());
        cv.put(Constants.CONTACT_MIDDLE_INITIAL, contact.getMiddle_initial());
        cv.put(Constants.CONTACT_ADDRESS_ID, contact.getAddress_id());
        cv.put(Constants.CONTACT_HOME_PHONE, contact.getHome_phone());
        cv.put(Constants.CONTACT_MOBILE_PHONE, contact.getMobile_phone());
        cv.put(Constants.CONTACT_WORK_PHONE, contact.getWork_phone());
        cv.put(Constants.CONTACT_EMAIL_ADDRESS, contact.getEmail_address());
        cv.put(Constants.CONTACT_IS_REALTOR, contact.is_realtor());
        cv.put(Constants.CONTACT_REALTOR_LICENSE, contact.getRealtor_license());
        cv.put(Constants.CONTACT_IS_BROKER, contact.is_broker());
        cv.put(Constants.CONTACT_IS_TITLE, contact.is_title());
        cv.put(Constants.CONTACT_COMPANY_ID, contact.getCompany_id());
        return cv;
    }
}
