package com.mayps.reidatasystem.DAL;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mayps.reidatasystem.Utils.*;

public class DbOpenHelper extends SQLiteOpenHelper {
    //Constants for db name and version
    private static final String DATABASE_NAME = "TermManager.db";
    private static final int DATABASE_VERSION = 1;

    //Constants for identifying table and columns

    public DbOpenHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.ADDRESS_TABLE_CREATE);
        db.execSQL(Constants.COMPANIES_TABLE_CREATE);
        db.execSQL(Constants.CONTACTS_TABLE_CREATE);
        db.execSQL(Constants.PROPERTIES_TABLE_CREATE);
        db.execSQL(Constants.IMAGES_TABLE_CREATE);
        db.execSQL(Constants.REPAIRS_TABLE_CREATE);
        db.execSQL(Constants.REPAIR_TYPES_TABLE_CREATE);
        db.execSQL(Constants.MULTI_UNITS_TABLE_CREATE);
        db.execSQL(Constants.COMPANY_TYPES_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.ADDRESS_TABLE);
        db.execSQL(Constants.ADDRESS_TABLE_CREATE);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.PROPERTY_TABLE);
        db.execSQL(Constants.PROPERTIES_TABLE_CREATE);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.CONTACTS_TABLE);
        db.execSQL(Constants.CONTACTS_TABLE_CREATE);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.COMPANIES_TABLE);
        db.execSQL(Constants.REPAIRS_TABLE_CREATE);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.REPAIRS_TABLE);
        db.execSQL(Constants.COMPANIES_TABLE_CREATE);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.REPAIR_TYPES_TABLE);
        db.execSQL(Constants.REPAIR_TYPES_TABLE_CREATE);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.COMPANY_TYPES_TABLE);
        db.execSQL(Constants.COMPANY_TYPES_TABLE_CREATE);


        db.execSQL("DROP TABLE IF EXISTS " + Constants.IMAGES_TABLE);
        db.execSQL(Constants.IMAGES_TABLE_CREATE);


    }

}
