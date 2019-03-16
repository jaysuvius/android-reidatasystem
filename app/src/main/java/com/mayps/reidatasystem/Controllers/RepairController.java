package com.mayps.reidatasystem.Controllers;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.mayps.reidatasystem.DAL.RepairProvider;
import com.mayps.reidatasystem.Models.Repair;
import com.mayps.reidatasystem.Models.Entity;
import com.mayps.reidatasystem.Utils.Constants;

public class RepairController extends AbstractController {

    public RepairController(Context c){
        super(c, RepairProvider.getInstance());
    }

    public boolean saveRepair(Repair entity){
        try{
            Uri uri = Uri.parse("entity://" + _provider.getAuthority() + "/" + _provider.get_table() + "/" + entity.getId());
            Repair a = (Repair) getById(uri);
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

    protected Repair parse(Cursor repairCursor) {
        return new Repair(repairCursor.getInt(repairCursor.getColumnIndex(Constants.REPAIR_ID)),
                repairCursor.getLong(repairCursor.getColumnIndex(Constants.REPAIR_PROPERTY_ID)),
                repairCursor.getLong(repairCursor.getColumnIndex(Constants.REPAIR_TYPE_ID)),
                repairCursor.getString(repairCursor.getColumnIndex(Constants.REPAIR_OTHER_DESCRIPTION)));
    }

    @Override
    ContentValues getContentValues(Entity entity) {
        ContentValues cv = new ContentValues();
        Repair repair = (Repair) entity;
        cv.put(Constants.REPAIR_ID, repair.getId());
        cv.put(Constants.REPAIR_PROPERTY_ID, repair.getProperty_id());
        cv.put(Constants.REPAIR_TYPE_ID, repair.getRepair_type_id());
        cv.put(Constants.REPAIR_OTHER_DESCRIPTION, repair.getRepair_description());
        return cv;
    }

    @Override
    ContentValues getInsertValues(Entity entity) {
        ContentValues cv = new ContentValues();
        Repair repair = (Repair) entity;
        cv.put(Constants.REPAIR_PROPERTY_ID, repair.getProperty_id());
        cv.put(Constants.REPAIR_TYPE_ID, repair.getRepair_type_id());
        cv.put(Constants.REPAIR_OTHER_DESCRIPTION, repair.getRepair_description());
        return cv;
    }
}
