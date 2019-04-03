package com.mayps.reidatasystem.Models;

import com.mayps.reidatasystem.Interfaces.iEntity;

import java.util.Date;

public class Property extends Entity implements iEntity {

    private long address_id;
    private String property_name;
    private String style;
    private int sq_ft;
    private int lot_size;
    private boolean is_multi_unit;
    private int year_built;
    private double hoa_fees;
    private boolean is_occupied;
    private boolean is_owner_occupied;
    private String special_features;
    private String upgrades;
    private boolean is_listed;
    private String listing_date;
    private boolean has_other_offers;
    private double offer_amount;
    private String realtor;
    private String realtor_phone;
    private String reason_for_selling;
    private String time_frame;
    private String no_sell_contingency;
    private double mortgage_amount;
    private boolean has_liens;
    private boolean has_multiple_mortgages;
    private boolean is_payment_current;
    private int months_behind;
    private double amount_behind;
    private double back_taxes;
    private double other_lien_amount;
    private double monthly_payment;
    private double tax_amount;
    private double insurance_amount;
    private double first_interest_rate;
    private double second_interest_rate;
    private boolean is_fixed_rate;
    private double payment_penalty;
    private String mortgage_company_1;
    private String getMortgage_company_2;
    private double asking_price;
    private boolean is_flexible;
    private String how_price_derived;
    private double best_price_cash_fast_close;
    private double absolute_bottom_price;
    private boolean will_subject_to;
    private boolean can_accept_quickly;
    private String evaluator;
    private double arv;
    private double repair_cost;
    private boolean likely_purchase;
    private String exit_strategy;
    private double offer_1;
    private double offer_2;

    public Property(long address_id, String property_name, String style, int sq_ft, int lot_size, int is_multi_unit, int year_built, double hoa_fees, int is_occupied,
                    int is_owner_occupied, String special_features, String upgrades, int is_listed, String listing_date, int has_other_offers,
                    double offer_amount, String realtor, String realtor_phone, String reason_for_selling, String time_frame, String no_sell_contingency, 
                    double mortgage_amount, int has_liens, int has_multiple_mortgages, int is_payment_current, int months_behind, double amount_behind, 
                    double back_taxes, double other_lien_amount, double monthly_payment, double tax_amount, double insurance_amount, double first_interest_rate, 
                    double second_interest_rate, int is_fixed_rate, double payment_penalty, String mortgage_company_1, String getMortgage_company_2, double asking_price, 
                    int is_flexible, String how_price_derived, double best_price_cash_fast_close, double absolute_bottom_price, int will_subject_to, 
                    int can_accept_quickly, String evaluator, double arv, double repair_cost, int likely_purchase, String exit_strategy, double offer_1, double offer_2) {
        this.address_id = address_id;
        this.property_name = property_name;
        this.style = style;
        this.sq_ft = sq_ft;
        this.lot_size = lot_size;
        this.is_multi_unit = is_multi_unit == 1;
        this.year_built = year_built;
        this.hoa_fees = hoa_fees;
        this.is_occupied = is_occupied == 1;
        this.is_owner_occupied = is_owner_occupied == 1;
        this.special_features = special_features;
        this.upgrades = upgrades;
        this.is_listed = is_listed == 1;
        this.listing_date = listing_date;
        this.has_other_offers = has_other_offers == 1;
        this.offer_amount = offer_amount;
        this.realtor = realtor;
        this.realtor_phone = realtor_phone;
        this.reason_for_selling = reason_for_selling;
        this.time_frame = time_frame;
        this.no_sell_contingency = no_sell_contingency;
        this.mortgage_amount = mortgage_amount;
        this.has_liens = has_liens == 1;
        this.has_multiple_mortgages = has_multiple_mortgages == 1;
        this.is_payment_current = is_payment_current == 1;
        this.months_behind = months_behind;
        this.amount_behind = amount_behind;
        this.back_taxes = back_taxes;
        this.other_lien_amount = other_lien_amount;
        this.monthly_payment = monthly_payment;
        this.tax_amount = tax_amount;
        this.insurance_amount = insurance_amount;
        this.first_interest_rate = first_interest_rate;
        this.second_interest_rate = second_interest_rate;
        this.is_fixed_rate = is_fixed_rate == 1;
        this.payment_penalty = payment_penalty;
        this.mortgage_company_1 = mortgage_company_1;
        this.getMortgage_company_2 = getMortgage_company_2;
        this.asking_price = asking_price;
        this.is_flexible = is_flexible == 1;
        this.how_price_derived = how_price_derived;
        this.best_price_cash_fast_close = best_price_cash_fast_close;
        this.absolute_bottom_price = absolute_bottom_price;
        this.will_subject_to = will_subject_to == 1;
        this.can_accept_quickly = can_accept_quickly == 1;
        this.evaluator = evaluator;
        this.arv = arv;
        this.repair_cost = repair_cost;
        this.likely_purchase = likely_purchase == 1;
        this.exit_strategy = exit_strategy;
        this.offer_1 = offer_1;
        this.offer_2 = offer_2;
    }

    public Property(long id, long address_id, String property_name, String style, int sq_ft, int lot_size, int is_multi_unit, int year_built, double hoa_fees, int is_occupied,
                    int is_owner_occupied, String special_features, String upgrades, int is_listed, String listing_date, int has_other_offers, double offer_amount,
                    String realtor, String realtor_phone, String reason_for_selling, String time_frame, String no_sell_contingency, double mortgage_amount, int has_liens,
                    int has_multiple_mortgages, int is_payment_current, int months_behind, double amount_behind, double back_taxes, double other_lien_amount,
                    double monthly_payment, double tax_amount, double insurance_amount, double first_interest_rate, double second_interest_rate, int is_fixed_rate, 
                    double payment_penalty, String mortgage_company_1, String getMortgage_company_2, double asking_price, int is_flexible, String how_price_derived,
                    double best_price_cash_fast_close, double absolute_bottom_price, int will_subject_to, int can_accept_quickly, String evaluator, double arv, 
                    double repair_cost, int likely_purchase, String exit_strategy, double offer_1, double offer_2) {
        super.setId(id);
        this.address_id = address_id;
        this.property_name = property_name;
        this.style = style;
        this.sq_ft = sq_ft;
        this.lot_size = lot_size;
        this.is_multi_unit = is_multi_unit == 1;
        this.year_built = year_built;
        this.hoa_fees = hoa_fees;
        this.is_occupied = is_occupied == 1;
        this.is_owner_occupied = is_owner_occupied == 1;
        this.special_features = special_features;
        this.upgrades = upgrades;
        this.is_listed = is_listed == 1;
        this.listing_date = listing_date;
        this.has_other_offers = has_other_offers == 1;
        this.offer_amount = offer_amount;
        this.realtor = realtor;
        this.realtor_phone = realtor_phone;
        this.reason_for_selling = reason_for_selling;
        this.time_frame = time_frame;
        this.no_sell_contingency = no_sell_contingency;
        this.mortgage_amount = mortgage_amount;
        this.has_liens = has_liens == 1;
        this.has_multiple_mortgages = has_multiple_mortgages == 1;
        this.is_payment_current = is_payment_current == 1;
        this.months_behind = months_behind;
        this.amount_behind = amount_behind;
        this.back_taxes = back_taxes;
        this.other_lien_amount = other_lien_amount;
        this.monthly_payment = monthly_payment;
        this.tax_amount = tax_amount;
        this.insurance_amount = insurance_amount;
        this.first_interest_rate = first_interest_rate;
        this.second_interest_rate = second_interest_rate;
        this.is_fixed_rate = is_fixed_rate == 1;
        this.payment_penalty = payment_penalty;
        this.mortgage_company_1 = mortgage_company_1;
        this.getMortgage_company_2 = getMortgage_company_2;
        this.asking_price = asking_price;
        this.is_flexible = is_flexible == 1;
        this.how_price_derived = how_price_derived;
        this.best_price_cash_fast_close = best_price_cash_fast_close;
        this.absolute_bottom_price = absolute_bottom_price;
        this.will_subject_to = will_subject_to == 1;
        this.can_accept_quickly = can_accept_quickly == 1;
        this.evaluator = evaluator;
        this.arv = arv;
        this.repair_cost = repair_cost;
        this.likely_purchase = likely_purchase == 1;
        this.exit_strategy = exit_strategy;
        this.offer_1 = offer_1;
        this.offer_2 = offer_2;
    }

    public Property(){}

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getSq_ft() {
        return sq_ft;
    }

    public void setSq_ft(int sq_ft) {
        this.sq_ft = sq_ft;
    }

    public int getLot_size() {
        return lot_size;
    }

    public void setLot_size(int lot_size) {
        this.lot_size = lot_size;
    }

    public boolean isIs_multi_unit() {
        return is_multi_unit;
    }

    public void setIs_multi_unit(boolean is_multi_unit) {
        this.is_multi_unit = is_multi_unit;
    }

    public int getYear_built() {
        return year_built;
    }

    public void setYear_built(int year_built) {
        this.year_built = year_built;
    }

    public double getHoa_fees() {
        return hoa_fees;
    }

    public void setHoa_fees(double hoa_fees) {
        this.hoa_fees = hoa_fees;
    }

    public boolean isIs_occupied() {
        return is_occupied;
    }

    public void setIs_occupied(boolean is_occupied) {
        this.is_occupied = is_occupied;
    }

    public boolean isIs_owner_occupied() {
        return is_owner_occupied;
    }

    public void setIs_owner_occupied(boolean is_owner_occupied) {
        this.is_owner_occupied = is_owner_occupied;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }

    public String getUpgrades() {
        return upgrades;
    }

    public void setUpgrades(String upgrades) {
        this.upgrades = upgrades;
    }

    public boolean isIs_listed() {
        return is_listed;
    }

    public void setIs_listed(boolean is_listed) {
        this.is_listed = is_listed;
    }

    public String getListing_date() {
        return listing_date;
    }

    public void setListing_date(String listing_date) {
        this.listing_date = listing_date;
    }

    public boolean isHas_other_offers() {
        return has_other_offers;
    }

    public void setHas_other_offers(boolean has_other_offers) {
        this.has_other_offers = has_other_offers;
    }

    public double getOffer_amount() {
        return offer_amount;
    }

    public void setOffer_amount(double offer_amount) {
        this.offer_amount = offer_amount;
    }

    public String getRealtor() {
        return realtor;
    }

    public void setRealtor(String realtor) {
        this.realtor = realtor;
    }

    public String getRealtor_phone() {
        return realtor_phone;
    }

    public void setRealtor_phone(String realtor_phone) {
        this.realtor_phone = realtor_phone;
    }

    public String getReason_for_selling() {
        return reason_for_selling;
    }

    public void setReason_for_selling(String reason_for_selling) {
        this.reason_for_selling = reason_for_selling;
    }

    public String getTime_frame() {
        return time_frame;
    }

    public void setTime_frame(String time_frame) {
        this.time_frame = time_frame;
    }

    public String getNo_sell_contingency() {
        return no_sell_contingency;
    }

    public void setNo_sell_contingency(String no_sell_contingency) {
        this.no_sell_contingency = no_sell_contingency;
    }

    public double getMortgage_amount() {
        return mortgage_amount;
    }

    public void setMortgage_amount(double mortgage_amount) {
        this.mortgage_amount = mortgage_amount;
    }

    public boolean isHas_liens() {
        return has_liens;
    }

    public void setHas_liens(boolean has_liens) {
        this.has_liens = has_liens;
    }

    public boolean isHas_multiple_mortgages() {
        return has_multiple_mortgages;
    }

    public void setHas_multiple_mortgages(boolean has_multiple_mortgages) {
        this.has_multiple_mortgages = has_multiple_mortgages;
    }

    public boolean isIs_payment_current() {
        return is_payment_current;
    }

    public void setIs_payment_current(boolean is_payment_current) {
        this.is_payment_current = is_payment_current;
    }

    public int getMonths_behind() {
        return months_behind;
    }

    public void setMonths_behind(int months_behind) {
        this.months_behind = months_behind;
    }

    public double getAmount_behind() {
        return amount_behind;
    }

    public void setAmount_behind(double amount_behind) {
        this.amount_behind = amount_behind;
    }

    public double getBack_taxes() {
        return back_taxes;
    }

    public void setBack_taxes(double back_taxes) {
        this.back_taxes = back_taxes;
    }

    public double getOther_lien_amount() {
        return other_lien_amount;
    }

    public void setOther_lien_amount(double other_lien_amount) {
        this.other_lien_amount = other_lien_amount;
    }

    public double getMonthly_payment() {
        return monthly_payment;
    }

    public void setMonthly_payment(double monthly_payment) {
        this.monthly_payment = monthly_payment;
    }

    public double getTax_amount() {
        return tax_amount;
    }

    public void setTax_amount(double tax_amount) {
        this.tax_amount = tax_amount;
    }

    public double getInsurance_amount() {
        return insurance_amount;
    }

    public void setInsurance_amount(double insurance_amount) {
        this.insurance_amount = insurance_amount;
    }

    public double getFirst_interest_rate() {
        return first_interest_rate;
    }

    public void setFirst_interest_rate(double first_interest_rate) {
        this.first_interest_rate = first_interest_rate;
    }

    public double getSecond_interest_rate() {
        return second_interest_rate;
    }

    public void setSecond_interest_rate(double second_interest_rate) {
        this.second_interest_rate = second_interest_rate;
    }

    public boolean isIs_fixed_rate() {
        return is_fixed_rate;
    }

    public void setIs_fixed_rate(boolean is_fixed_rate) {
        this.is_fixed_rate = is_fixed_rate;
    }

    public double getPayment_penalty() {
        return payment_penalty;
    }

    public void setPayment_penalty(double payment_penalty) {
        this.payment_penalty = payment_penalty;
    }

    public String getMortgage_company_1() {
        return mortgage_company_1;
    }

    public void setMortgage_company_1(String mortgage_company_1) {
        this.mortgage_company_1 = mortgage_company_1;
    }

    public String getGetMortgage_company_2() {
        return getMortgage_company_2;
    }

    public void setGetMortgage_company_2(String getMortgage_company_2) {
        this.getMortgage_company_2 = getMortgage_company_2;
    }

    public double getAsking_price() {
        return asking_price;
    }

    public void setAsking_price(double asking_price) {
        this.asking_price = asking_price;
    }

    public boolean isIs_flexible() {
        return is_flexible;
    }

    public void setIs_flexible(boolean is_flexible) {
        this.is_flexible = is_flexible;
    }

    public String getHow_price_derived() {
        return how_price_derived;
    }

    public void setHow_price_derived(String how_price_derived) {
        this.how_price_derived = how_price_derived;
    }

    public double getBest_price_cash_fast_close() {
        return best_price_cash_fast_close;
    }

    public void setBest_price_cash_fast_close(double best_price_cash_fast_close) {
        this.best_price_cash_fast_close = best_price_cash_fast_close;
    }

    public double getAbsolute_bottom_price() {
        return absolute_bottom_price;
    }

    public void setAbsolute_bottom_price(double absolute_bottom_price) {
        this.absolute_bottom_price = absolute_bottom_price;
    }

    public boolean isWill_subject_to() {
        return will_subject_to;
    }

    public void setWill_subject_to(boolean will_subject_to) {
        this.will_subject_to = will_subject_to;
    }

    public boolean isCan_accept_quickly() {
        return can_accept_quickly;
    }

    public void setCan_accept_quickly(boolean can_accept_quickly) {
        this.can_accept_quickly = can_accept_quickly;
    }

    public String getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(String evaluator) {
        this.evaluator = evaluator;
    }

    public double getArv() {
        return arv;
    }

    public void setArv(double arv) {
        this.arv = arv;
    }

    public double getRepair_cost() {
        return repair_cost;
    }

    public void setRepair_cost(double repair_cost) {
        this.repair_cost = repair_cost;
    }

    public boolean isLikely_purchase() {
        return likely_purchase;
    }

    public void setLikely_purchase(boolean likely_purchase) {
        this.likely_purchase = likely_purchase;
    }

    public String getExit_strategy() {
        return exit_strategy;
    }

    public void setExit_strategy(String exit_strategy) {
        this.exit_strategy = exit_strategy;
    }

    public double getOffer_1() {
        return offer_1;
    }

    public void setOffer_1(double offer_1) {
        this.offer_1 = offer_1;
    }

    public double getOffer_2() {
        return offer_2;
    }

    public void setOffer_2(double offer_2) {
        this.offer_2 = offer_2;
    }


    @Override
    public String toString() {
        return "Property{" +
                "address_id=" + address_id +
                ", style='" + style + '\'' +
                ", sq_ft=" + sq_ft +
                ", lot_size=" + lot_size +
                ", is_multi_unit=" + is_multi_unit +
                ", year_built=" + year_built +
                ", hoa_fees=" + hoa_fees +
                ", is_occupied=" + is_occupied +
                ", is_owner_occupied=" + is_owner_occupied +
                ", special_features='" + special_features + '\'' +
                ", upgrades='" + upgrades + '\'' +
                ", is_listed=" + is_listed +
                ", listing_date=" + listing_date +
                ", has_other_offers=" + has_other_offers +
                ", offer_amount=" + offer_amount +
                ", realtor='" + realtor + '\'' +
                ", realtor_phone='" + realtor_phone + '\'' +
                ", reason_for_selling='" + reason_for_selling + '\'' +
                ", time_frame='" + time_frame + '\'' +
                ", no_sell_contingency='" + no_sell_contingency + '\'' +
                ", mortgage_amount=" + mortgage_amount +
                ", has_liens=" + has_liens +
                ", has_multiple_mortgages=" + has_multiple_mortgages +
                ", is_payment_current=" + is_payment_current +
                ", months_behind=" + months_behind +
                ", amount_behind=" + amount_behind +
                ", back_taxes=" + back_taxes +
                ", other_lien_amount=" + other_lien_amount +
                ", monthly_payment=" + monthly_payment +
                ", tax_amount=" + tax_amount +
                ", insurance_amount=" + insurance_amount +
                ", first_interest_rate=" + first_interest_rate +
                ", second_interest_rate=" + second_interest_rate +
                ", is_fixed_rate=" + is_fixed_rate +
                ", payment_penalty=" + payment_penalty +
                ", mortgage_company_1='" + mortgage_company_1 + '\'' +
                ", getMortgage_company_2='" + getMortgage_company_2 + '\'' +
                ", asking_price=" + asking_price +
                ", is_flexible=" + is_flexible +
                ", how_price_derived='" + how_price_derived + '\'' +
                ", best_price_cash_fast_close=" + best_price_cash_fast_close +
                ", absolute_bottom_price=" + absolute_bottom_price +
                ", will_subject_to=" + will_subject_to +
                ", can_accept_quickly=" + can_accept_quickly +
                ", evaluator='" + evaluator + '\'' +
                ", arv=" + arv +
                ", repair_cost=" + repair_cost +
                ", likely_purchase=" + likely_purchase +
                ", exit_strategy='" + exit_strategy + '\'' +
                ", offer_1=" + offer_1 +
                ", offer_2=" + offer_2 +
                '}';
    }
}
