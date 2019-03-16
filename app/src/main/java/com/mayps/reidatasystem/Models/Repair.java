package com.mayps.reidatasystem.Models;

import com.mayps.reidatasystem.Interfaces.iEntity;

public class Repair extends Entity implements iEntity {

    private long property_id;
    private long repair_type_id;
    private String repair_description;

    public Repair(long property_id, long repair_type_id, String repair_description) {
        this.property_id = property_id;
        this.repair_type_id = repair_type_id;
        this.repair_description = repair_description;
    }

    public Repair(long id, long property_id, long repair_type_id, String repair_description) {
        super.setId(id);
        this.property_id = property_id;
        this.repair_type_id = repair_type_id;
        this.repair_description = repair_description;
    }

    public long getProperty_id() {
        return property_id;
    }

    public void setProperty_id(long property_id) {
        this.property_id = property_id;
    }

    public long getRepair_type_id() {
        return repair_type_id;
    }

    public void setRepair_type_id(long repair_type_id) {
        this.repair_type_id = repair_type_id;
    }

    public String getRepair_description() {
        return repair_description;
    }

    public void setRepair_description(String repair_description) {
        this.repair_description = repair_description;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "property_id=" + property_id +
                ", repair_type_id=" + repair_type_id +
                ", repair_description=" + repair_description +
                '}';
    }
}
