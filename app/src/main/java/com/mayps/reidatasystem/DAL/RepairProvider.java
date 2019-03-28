package com.mayps.reidatasystem.DAL;

import android.content.UriMatcher;
import android.net.Uri;

import com.mayps.reidatasystem.Utils.Constants;

public class RepairProvider extends DataProvider {
    private static RepairProvider sInstance;
    private static String AUTHORITY = "com.mayps.reidatasystem.DAL.RepairProvider";
    private Uri content_uri = Uri.parse("content://" + AUTHORITY);
    private static String _table = Constants.REPAIRS_TABLE;
    private static String[] _allColumns = Constants.REPAIR_COLUMNS;
    private UriMatcher uriMatcher  = new UriMatcher(UriMatcher.NO_MATCH);

    private static String _sortColumn = Constants.REPAIR_SORT_COLUMN;

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

    public static RepairProvider getInstance(){
        if(sInstance == null){
            sInstance = new RepairProvider();
        }
        return sInstance;
    }

    public RepairProvider(){
        super();
        getUriMatcher().addURI(get_content_uri().toString(), getBase_path(), DataProvider.REIDATASYSTEM_ID);
        getUriMatcher().addURI(getAuthority(), getBase_path() + "/#", DataProvider.REIDATASYSTEM_ID);
        sInstance = this;
    }
}
