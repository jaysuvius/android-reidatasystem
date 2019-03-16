package com.mayps.reidatasystem.Controllers;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.mayps.reidatasystem.DAL.CompanyProvider;
import com.mayps.reidatasystem.Models.Company;
import com.mayps.reidatasystem.Models.Entity;
import com.mayps.reidatasystem.Utils.Constants;

public class CompanyController extends AbstractController {

    public CompanyController(Context c){
        super(c, CompanyProvider.getInstance());
    }

    public boolean saveCompany(Company entity){
        try{
            Uri uri = Uri.parse("entity://" + _provider.getAuthority() + "/" + _provider.get_table() + "/" + entity.getId());
            Company a = (Company) getById(uri);
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

    protected Company parse(Cursor companyCursor) {
        return new Company(companyCursor.getInt(companyCursor.getColumnIndex(Constants.COMPANY_ID)),
                companyCursor.getString(companyCursor.getColumnIndex(Constants.COMPANY_NAME)),
                companyCursor.getLong(companyCursor.getColumnIndex(Constants.COMPANY_TYPE_ID)),
                companyCursor.getLong(companyCursor.getColumnIndex(Constants.COMPANY_ADDRESS_ID)),
                companyCursor.getLong(companyCursor.getColumnIndex(Constants.COMPANY_PRIMARY_CONTACT_ID)),
                companyCursor.getString(companyCursor.getColumnIndex(Constants.COMPANY_PHONE_NUMBER)),
                companyCursor.getString(companyCursor.getColumnIndex(Constants.COMPANY_FAX_NUMBER)),
                companyCursor.getString(companyCursor.getColumnIndex(Constants.COMPANY_EMAIL_ADDRESS)));
    }

    @Override
    ContentValues getContentValues(Entity entity) {
        ContentValues cv = new ContentValues();
        Company company = (Company) entity;
        cv.put(Constants.COMPANY_ID, company.getId());
        cv.put(Constants.COMPANY_NAME, company.getCompany_name());
        cv.put(Constants.COMPANY_TYPE_ID, company.getCompany_type());
        cv.put(Constants.COMPANY_ADDRESS_ID, company.getAddress_id());
        cv.put(Constants.COMPANY_PRIMARY_CONTACT_ID, company.getPrimary_contact_id());
        cv.put(Constants.COMPANY_PHONE_NUMBER, company.getPhone_number());
        cv.put(Constants.COMPANY_FAX_NUMBER, company.getFax_number());
        cv.put(Constants.COMPANY_EMAIL_ADDRESS, company.getEmail_address());
        return cv;
    }

    @Override
    ContentValues getInsertValues(Entity entity) {
        ContentValues cv = new ContentValues();
        Company company = (Company) entity;
        cv.put(Constants.COMPANY_NAME, company.getCompany_name());
        cv.put(Constants.COMPANY_TYPE_ID, company.getCompany_type());
        cv.put(Constants.COMPANY_ADDRESS_ID, company.getAddress_id());
        cv.put(Constants.COMPANY_PRIMARY_CONTACT_ID, company.getPrimary_contact_id());
        cv.put(Constants.COMPANY_PHONE_NUMBER, company.getPhone_number());
        cv.put(Constants.COMPANY_FAX_NUMBER, company.getFax_number());
        cv.put(Constants.COMPANY_EMAIL_ADDRESS, company.getEmail_address());
        return cv;
    }

}
