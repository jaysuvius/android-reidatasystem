package com.mayps.reidatasystem.Models;

import com.mayps.reidatasystem.Interfaces.iEntity;

public class CompanyType extends Entity implements iEntity {

    private String company_type_description;

    public CompanyType(String company_type_description) {
        this.company_type_description = company_type_description;
    }

    public CompanyType(long id, String company_type_description) {
        super.setId(id);
        this.company_type_description = company_type_description;
    }


    public String getCompany_type_description() {
        return company_type_description;
    }

    public void setCompany_type_description(String company_type_description) {
        this.company_type_description = company_type_description;
    }


    @Override
    public String toString() {
        return company_type_description;
    }
}
