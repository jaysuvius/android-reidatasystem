package com.mayps.reidatasystem.DAL;

import android.content.UriMatcher;
import android.net.Uri;

import com.mayps.reidatasystem.Utils.Constants;

public class AddressProvider extends DataProvider {

    private static AddressProvider sInstance;
    private static String AUTHORITY = "com.mayps.reidatasystem.DAL.AddressProvider";
    private Uri content_uri = Uri.parse("content://" + AUTHORITY);
    private static String _table = Constants.ADDRESS_TABLE;
    private static String[] _allColumns = Constants.ADDRESS_COLUMNS;
    private UriMatcher uriMatcher  = new UriMatcher(UriMatcher.NO_MATCH);

    private static String _sortColumn = Constants.ADDRESS_SORT_COLUMN;

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

    public static AddressProvider getInstance(){
        if(sInstance == null){
            sInstance = new AddressProvider();
        }
        return sInstance;
    }

    public AddressProvider(){
        super();
        getUriMatcher().addURI(get_content_uri().toString(), getBase_path(), DataProvider.REIDATASYSTEM_ID);
        getUriMatcher().addURI(getAuthority(), getBase_path() + "/#", DataProvider.REIDATASYSTEM_ID);
        sInstance = this;
    }
}
