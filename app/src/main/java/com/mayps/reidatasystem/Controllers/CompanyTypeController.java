package com.mayps.reidatasystem.Controllers;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.mayps.reidatasystem.DAL.CompanyTypeProvider;
import com.mayps.reidatasystem.Models.CompanyType;
import com.mayps.reidatasystem.Models.Entity;
import com.mayps.reidatasystem.Utils.Constants;

public class CompanyTypeController extends AbstractController {

    public CompanyTypeController(Context c){
        super(c, CompanyTypeProvider.getInstance());
    }

    public boolean saveCompanyType(CompanyType entity){
        try{
            Uri uri = Uri.parse("entity://" + _provider.getAuthority() + "/" + _provider.get_table() + "/" + entity.getId());
            CompanyType a = (CompanyType) getById(uri);
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

    protected CompanyType parse(Cursor companyTypeCursor) {
        return new CompanyType(companyTypeCursor.getInt(companyTypeCursor.getColumnIndex(Constants.COMPANY_TYPES_ID)),
                companyTypeCursor.getString(companyTypeCursor.getColumnIndex(Constants.COMPANY_TYPE_DESCRIPTION)));
    }

    @Override
    ContentValues getContentValues(Entity entity) {
        ContentValues cv = new ContentValues();
        CompanyType companyType = (CompanyType) entity;
        cv.put(Constants.COMPANY_TYPE_ID, companyType.getId());
        cv.put(Constants.COMPANY_TYPE_DESCRIPTION, companyType.getCompany_type_description());
        return cv;
    }

    @Override
    ContentValues getInsertValues(Entity entity) {
        ContentValues cv = new ContentValues();
        CompanyType companyType = (CompanyType) entity;
        cv.put(Constants.COMPANY_TYPE_DESCRIPTION, companyType.getCompany_type_description());
        return cv;
    }
}
