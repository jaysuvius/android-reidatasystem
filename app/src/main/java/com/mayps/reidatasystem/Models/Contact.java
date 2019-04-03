package com.mayps.reidatasystem.Models;

import com.mayps.reidatasystem.Interfaces.iEntity;

public class Contact extends Entity implements iEntity {

    private String first_name;
    private String last_name;
    private String middle_initial;
    private long address_id;
    private String home_phone;
    private String mobile_phone;
    private String work_phone;
    private String email_address;
    private boolean is_realtor;
    private String realtor_license;
    private boolean is_broker;
    private boolean is_title;
    private long company_id;

    public Contact(){

    }

    public Contact(String first_name, String last_name, String middle_initial, long address_id, String home_phone, String mobile_phone, String work_phone, String email_address, int is_realtor, String realtor_license, int is_broker, int is_title, long company_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_initial = middle_initial;
        this.address_id = address_id;
        this.home_phone = home_phone;
        this.mobile_phone = mobile_phone;
        this.work_phone = work_phone;
        this.email_address = email_address;
        this.is_realtor = is_realtor == 1;
        this.realtor_license = realtor_license;
        this.is_broker = is_broker == 1;
        this.is_title = is_title == 1;
        this.company_id = company_id;
    }

    public Contact(long id, String first_name, String last_name, String middle_initial, long address_id, String home_phone, String mobile_phone, String work_phone, String email_address, int is_realtor, String realtor_license, int is_broker, int is_title, long company_id) {
        super.setId(id);
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_initial = middle_initial;
        this.address_id = address_id;
        this.home_phone = home_phone;
        this.mobile_phone = mobile_phone;
        this.work_phone = work_phone;
        this.email_address = email_address;
        this.is_realtor = is_realtor == 1;
        this.realtor_license = realtor_license;
        this.is_broker = is_broker == 1;
        this.is_title = is_title == 1;
        this.company_id = company_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_initial() {
        return middle_initial;
    }

    public void setMiddle_initial(String middle_initial) {
        this.middle_initial = middle_initial;
    }

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getWork_phone() {
        return work_phone;
    }

    public void setWork_phone(String work_phone) {
        this.work_phone = work_phone;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public boolean is_realtor() {
        return is_realtor;
    }

    public void setIs_realtor(boolean is_realtor) {
        this.is_realtor = is_realtor;
    }

    public String getRealtor_license() {
        return realtor_license;
    }

    public void setRealtor_license(String realtor_license) {
        this.realtor_license = realtor_license;
    }

    public boolean is_broker() {
        return is_broker;
    }

    public void setIs_broker(boolean is_broker) {
        this.is_broker = is_broker;
    }

    public boolean is_title() {
        return is_title;
    }

    public void setIs_title(boolean is_title) {
        this.is_title = is_title;
    }

    public long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(long company_id) {
        this.company_id = company_id;
    }

    public String getContactName(){
        return this.first_name + " " + this.getLast_name();
    }


    @Override
    public String toString() {
        return first_name + ' ' + last_name + ' ' +  middle_initial;
    }
}
