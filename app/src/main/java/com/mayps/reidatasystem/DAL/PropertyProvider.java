package com.mayps.reidatasystem.DAL;

import android.content.UriMatcher;
import android.net.Uri;

import com.mayps.reidatasystem.Utils.Constants;

public class PropertyProvider extends DataProvider {

    private static PropertyProvider sInstance;
    private static String AUTHORITY = "com.mayps.reidatasystem.DAL.PropertyProvider";
    private Uri content_uri = Uri.parse("content://" + AUTHORITY);
    private static String _table = Constants.PROPERTY_TABLE;
    private static String[] _allColumns = Constants.PROPERTY_COLUMNS;
    private UriMatcher uriMatcher  = new UriMatcher(UriMatcher.NO_MATCH);

    private static String _sortColumn = Constants.PROPERTY_SORT_COLUMN;

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

    public static PropertyProvider getInstance(){
        if(sInstance == null){
            sInstance = new PropertyProvider();
        }
        return sInstance;
    }

    public PropertyProvider(){
        super();
        getUriMatcher().addURI(get_content_uri().toString(), getBase_path(), DataProvider.REIDATASYSTEM_ID);
        getUriMatcher().addURI(getAuthority(), getBase_path() + "/#", DataProvider.REIDATASYSTEM_ID);
        sInstance = this;
    }
}
