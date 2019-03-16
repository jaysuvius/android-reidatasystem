package com.mayps.reidatasystem.Controllers;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.mayps.reidatasystem.DAL.UnitProvider;
import com.mayps.reidatasystem.Models.Unit;
import com.mayps.reidatasystem.Models.Entity;
import com.mayps.reidatasystem.Utils.Constants;

public class UnitController extends AbstractController {

    public UnitController(Context c){
        super(c, UnitProvider.getInstance());
    }

    public boolean saveUnit(Unit entity){
        try{
            Uri uri = Uri.parse("entity://" + _provider.getAuthority() + "/" + _provider.get_table() + "/" + entity.getId());
            Unit a = (Unit) getById(uri);
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

    protected Unit parse(Cursor unitCursor) {
        return new Unit(unitCursor.getInt(unitCursor.getColumnIndex(Constants.MULTI_UNIT_ID)),
                unitCursor.getLong(unitCursor.getColumnIndex(Constants.MULTI_UNIT_PROPERTY_ID)),
                unitCursor.getString(unitCursor.getColumnIndex(Constants.MULTI_UNIT_UNIT_NUMBER)),
                unitCursor.getInt(unitCursor.getColumnIndex(Constants.MULTI_UNIT_SQ_FT)),
                unitCursor.getInt(unitCursor.getColumnIndex(Constants.MULTI_UNIT_BEDROOM_COUNT)),
                unitCursor.getInt(unitCursor.getColumnIndex(Constants.MULTI_UNIT_BATHROOM_COUNT)),
                unitCursor.getDouble(unitCursor.getColumnIndex(Constants.MULTI_UNIT_RENT_AMOUNT)),
                unitCursor.getInt(unitCursor.getColumnIndex(Constants.MULTI_UNIT_IS_OCCUPIED)),
                unitCursor.getString(unitCursor.getColumnIndex(Constants.MULTI_UNIT_SPECIAL_FEATURES)));
    }

    @Override
    ContentValues getContentValues(Entity entity) {
        ContentValues cv = new ContentValues();
        Unit unit = (Unit) entity;
        cv.put(Constants.MULTI_UNIT_ID, unit.getId());
        cv.put(Constants.MULTI_UNIT_PROPERTY_ID, unit.getProperty_id());
        cv.put(Constants.MULTI_UNIT_UNIT_NUMBER, unit.getUnit_number());
        cv.put(Constants.MULTI_UNIT_SQ_FT, unit.getSq_ft());
        cv.put(Constants.MULTI_UNIT_BEDROOM_COUNT, unit.getBedroom_count());
        cv.put(Constants.MULTI_UNIT_BATHROOM_COUNT, unit.getBathroom_count());
        cv.put(Constants.MULTI_UNIT_RENT_AMOUNT, unit.getRent_amount());
        cv.put(Constants.MULTI_UNIT_IS_OCCUPIED, unit.is_occupied());
        cv.put(Constants.MULTI_UNIT_SPECIAL_FEATURES, unit.getSpecial_features());
        return cv;
    }

    @Override
    ContentValues getInsertValues(Entity entity) {
        ContentValues cv = new ContentValues();
        Unit unit = (Unit) entity;
        cv.put(Constants.MULTI_UNIT_PROPERTY_ID, unit.getProperty_id());
        cv.put(Constants.MULTI_UNIT_UNIT_NUMBER, unit.getUnit_number());
        cv.put(Constants.MULTI_UNIT_SQ_FT, unit.getSq_ft());
        cv.put(Constants.MULTI_UNIT_BEDROOM_COUNT, unit.getBedroom_count());
        cv.put(Constants.MULTI_UNIT_BATHROOM_COUNT, unit.getBathroom_count());
        cv.put(Constants.MULTI_UNIT_RENT_AMOUNT, unit.getRent_amount());
        cv.put(Constants.MULTI_UNIT_IS_OCCUPIED, unit.is_occupied());
        cv.put(Constants.MULTI_UNIT_SPECIAL_FEATURES, unit.getSpecial_features());
        return cv;
    }
}
