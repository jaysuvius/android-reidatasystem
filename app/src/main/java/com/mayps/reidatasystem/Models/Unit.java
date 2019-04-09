package com.mayps.reidatasystem.Models;

import com.mayps.reidatasystem.Interfaces.iEntity;

public class Unit extends Entity implements iEntity {

    private long property_id;
    private String unit_number;
    private int sq_ft;
    private int bedroom_count;
    private int bathroom_count;
    private double rent_amount;
    private boolean is_occupied;
    private String special_features;

    public Unit(){

    }

    public Unit(long property_id, String unit_number, int sq_ft, int bedroom_count, int bathroom_count, double rent_amount, int is_occupied, String special_features) {
        this.property_id = property_id;
        this.unit_number = unit_number;
        this.sq_ft = sq_ft;
        this.bedroom_count = bedroom_count;
        this.bathroom_count = bathroom_count;
        this.rent_amount = rent_amount;
        this.is_occupied = is_occupied == 1;
        this.special_features = special_features;
    }

    public Unit(long id, long property_id, String unit_number, int sq_ft, int bedroom_count, int bathroom_count, double rent_amount, int is_occupied, String special_features) {
        super.setId(id);
        this.property_id = property_id;
        this.unit_number = unit_number;
        this.sq_ft = sq_ft;
        this.bedroom_count = bedroom_count;
        this.bathroom_count = bathroom_count;
        this.rent_amount = rent_amount;
        this.is_occupied = is_occupied == 1;
        this.special_features = special_features;
    }

    public long getProperty_id() {
        return property_id;
    }

    public void setProperty_id(long property_id) {
        this.property_id = property_id;
    }

    public String getUnit_number() {
        return unit_number;
    }

    public void setUnit_number(String unit_number) {
        this.unit_number = unit_number;
    }

    public int getSq_ft() {
        return sq_ft;
    }

    public void setSq_ft(int sq_ft) {
        this.sq_ft = sq_ft;
    }

    public int getBedroom_count() {
        return bedroom_count;
    }

    public void setBedroom_count(int bedroom_count) {
        this.bedroom_count = bedroom_count;
    }

    public int getBathroom_count() {
        return bathroom_count;
    }

    public void setBathroom_count(int bathroom_count) {
        this.bathroom_count = bathroom_count;
    }

    public double getRent_amount() {
        return rent_amount;
    }

    public void setRent_amount(double rent_amount) {
        this.rent_amount = rent_amount;
    }

    public boolean is_occupied() {
        return is_occupied;
    }

    public void setIs_occupied(boolean is_occupied) {
        this.is_occupied = is_occupied;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }


    @Override
    public String toString() {
        return unit_number;
    }
}
