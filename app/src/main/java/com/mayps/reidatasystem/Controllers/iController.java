package com.mayps.reidatasystem.Controllers;

import android.net.Uri;

import com.mayps.reidatasystem.Models.Entity;

import java.util.List;

public interface iController<T extends Entity> {

    List<T> getAll();
    List<T> getByFields(String selection, String[] selectionArgs);
    T getById(Uri uri);
    Uri Insert(T entity);
    int Update(T entity);
    int Delete(T entity);
}
