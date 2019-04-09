package com.mayps.reidatasystem.Models;

import com.mayps.reidatasystem.Interfaces.iEntity;

public class RepairType extends Entity implements iEntity {

    public String repair_type_description;

    public RepairType(String repair_type_description) {
        this.repair_type_description = repair_type_description;
    }

    public RepairType(long id, String repair_type_description) {
        super.setId(id);
        this.repair_type_description = repair_type_description;
    }

    public String getRepair_type_description() {
        return repair_type_description;
    }

    public void setRepair_type_description(String repair_type_description) {
        this.repair_type_description = repair_type_description;
    }


    @Override
    public String toString() {
        return repair_type_description;
    }
}
