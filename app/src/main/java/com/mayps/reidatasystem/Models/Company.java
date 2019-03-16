package com.mayps.reidatasystem.Models;

import com.mayps.reidatasystem.Interfaces.iEntity;

public class Company extends Entity implements iEntity {

    private String company_name;
    private long company_type;
    private long address_id;
    private long primary_contact_id;
    private String phone_number;
    private String fax_number;
    private String email_address;

    public Company(){}

    public Company(String company_name, long company_type, long address_id, long primary_contact_id, String phone_number, String fax_number, String email_address) {
        this.company_name = company_name;
        this.company_type = company_type;
        this.address_id = address_id;
        this.primary_contact_id = primary_contact_id;
        this.phone_number = phone_number;
        this.fax_number = fax_number;
        this.email_address = email_address;
    }

    public Company(long id, String company_name, long company_type, long address_id, long primary_contact_id, String phone_number, String fax_number, String email_address) {
        super.setId(id);
        this.company_name = company_name;
        this.company_type = company_type;
        this.address_id = address_id;
        this.primary_contact_id = primary_contact_id;
        this.phone_number = phone_number;
        this.fax_number = fax_number;
        this.email_address = email_address;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public long getCompany_type() {
        return company_type;
    }

    public void setCompany_type(long company_type) {
        this.company_type = company_type;
    }

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public long getPrimary_contact_id() {
        return primary_contact_id;
    }

    public void setPrimary_contact_id(long primary_contact_id) {
        this.primary_contact_id = primary_contact_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getFax_number() {
        return fax_number;
    }

    public void setFax_number(String fax_number) {
        this.fax_number = fax_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }


    @Override
    public String toString() {
        return "Company{" +
                "company_name='" + company_name + '\'' +
                ", company_type=" + company_type +
                ", address_id=" + address_id +
                ", primary_contact_id=" + primary_contact_id +
                ", phone_number='" + phone_number + '\'' +
                ", fax_number='" + fax_number + '\'' +
                ", email_address='" + email_address + '\'' +
                '}';
    }
}
