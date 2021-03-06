package com.mayps.reidatasystem.DAL;

import android.content.UriMatcher;
import android.net.Uri;

import com.mayps.reidatasystem.Utils.Constants;

public class RepairTypeProvider extends DataProvider {

    private static RepairTypeProvider sInstance;
    private static String AUTHORITY = "com.mayps.reidatasystem.DAL.RepairTypeProvider";
    private Uri content_uri = Uri.parse("content://" + AUTHORITY);
    private static String _table = Constants.REPAIR_TYPES_TABLE;
    private static String[] _allColumns = Constants.REPAIR_TYPE_COLUMNS;
    private UriMatcher uriMatcher  = new UriMatcher(UriMatcher.NO_MATCH);

    private static String _sortColumn = Constants.REPAIR_TYPE_SORT_COLUMN;

    @Override
    public String getBase_path(){
        return _table;
    }

    @Override
    public Uri get_content_uri(){
        return content_uri;
    }
    @Override
    public String getAuthority(){
        return AUTHORITY;
    }
    @Override
    public String get_table(){
        return _table;
    }
    @Override
    public String[] get_allColumns(){
        return _allColumns;
    }
    @Override
    public String get_sortColumn(){
        return _sortColumn;
    }
    @Override
    public UriMatcher getUriMatcher(){return uriMatcher; }

    public static RepairTypeProvider getInstance(){
        if(sInstance == null){
            sInstance = new RepairTypeProvider();
        }
        return sInstance;
    }

    public RepairTypeProvider(){
        super();
        getUriMatcher().addURI(get_content_uri().toString(), getBase_path(), DataProvider.REIDATASYSTEM_ID);
        getUriMatcher().addURI(getAuthority(), getBase_path() + "/#", DataProvider.REIDATASYSTEM_ID);
        sInstance = this;
    }
}
