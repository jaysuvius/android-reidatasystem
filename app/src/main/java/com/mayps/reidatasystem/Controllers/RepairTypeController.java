package com.mayps.reidatasystem.Controllers;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.mayps.reidatasystem.DAL.RepairTypeProvider;
import com.mayps.reidatasystem.Models.RepairType;
import com.mayps.reidatasystem.Models.Entity;
import com.mayps.reidatasystem.Utils.Constants;

public class RepairTypeController extends AbstractController {

    public RepairTypeController(Context c){
        super(c, RepairTypeProvider.getInstance());
    }

    public boolean saveRepairType(RepairType entity){
        try{
            Uri uri = Uri.parse("entity://" + _provider.getAuthority() + "/" + _provider.get_table() + "/" + entity.getId());
            RepairType a = (RepairType) getById(uri);
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

    protected RepairType parse(Cursor repairTypeCursor) {
        return new RepairType(repairTypeCursor.getInt(repairTypeCursor.getColumnIndex(Constants.REPAIR_TYPE_ID)),
                repairTypeCursor.getString(repairTypeCursor.getColumnIndex(Constants.REPAIR_TYPE_DESCRIPTION)));
    }

    @Override
    ContentValues getContentValues(Entity entity) {
        ContentValues cv = new ContentValues();
        RepairType repairType = (RepairType) entity;
        cv.put(Constants.REPAIR_TYPE_ID, repairType.getId());
        cv.put(Constants.REPAIR_TYPE_DESCRIPTION, repairType.getRepair_type_description());
        return cv;
    }

    @Override
    ContentValues getInsertValues(Entity entity) {
        ContentValues cv = new ContentValues();
        RepairType repairType = (RepairType) entity;
        cv.put(Constants.REPAIR_TYPE_DESCRIPTION, repairType.getRepair_type_description());
        return cv;
    }
}
