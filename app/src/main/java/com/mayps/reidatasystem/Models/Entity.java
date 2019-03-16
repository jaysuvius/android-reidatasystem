package com.mayps.reidatasystem.Models;

public abstract class Entity implements com.mayps.reidatasystem.Interfaces.iEntity {

    protected long _id;

    @Override
    public long getId(){
        return _id;
    }
    public void setId(long id){
        _id = id;
    }



}
