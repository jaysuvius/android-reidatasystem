package com.mayps.reidatasystem.Controllers;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.mayps.reidatasystem.DAL.PropertyProvider;
import com.mayps.reidatasystem.Models.Property;
import com.mayps.reidatasystem.Models.Entity;
import com.mayps.reidatasystem.Utils.Constants;

public class PropertyController extends AbstractController {

    public PropertyController(Context c){
        super(c, PropertyProvider.getInstance());
    }

    public boolean saveProperty(Property entity){
        try{
            Uri uri = Uri.parse("entity://" + _provider.getAuthority() + "/" + _provider.get_table() + "/" + entity.getId());
            Property a = (Property) getById(uri);
            if (a == null || entity.getId() == 0){
                Uri rtnVal = Insert(entity);
                entity.setId(ContentUris.parseId(rtnVal));
            }
            else{
                int rtnVal = Update(entity);
            }
            return true;
        }
        catch (Exception ex){
            throw ex;
        }
    }

    protected Property parse(Cursor propertyCursor) {
        return new Property(propertyCursor.getLong(propertyCursor.getColumnIndex(Constants.PROPERTY_ID)),
                propertyCursor.getLong(propertyCursor.getColumnIndex(Constants.PROPERTY_ADDRESS_ID)),
                propertyCursor.getString(propertyCursor.getColumnIndex(Constants.PROPERTY_STYLE)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_SQFT)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_LOT_SIZE)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_IS_MULTI_UNIT)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_YEAR_BUILT)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_HOA_FEES)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_IS_OCCUPIED)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_OWNER_OCCUPIED)),
                propertyCursor.getString(propertyCursor.getColumnIndex(Constants.PROPERTY_SPECIAL_FEATURES)),
                propertyCursor.getString(propertyCursor.getColumnIndex(Constants.PROPERTY_UPGRADES)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_IS_LISTED)),
                propertyCursor.getString(propertyCursor.getColumnIndex(Constants.PROPERTY_LISTING_DATE)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_HAS_OTHER_OFFERS)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_OFFER_AMOUNT)),
                propertyCursor.getString(propertyCursor.getColumnIndex(Constants.PROPERTY_REALTOR)),
                propertyCursor.getString(propertyCursor.getColumnIndex(Constants.PROPERTY_REALTOR_PHONE)),
                propertyCursor.getString(propertyCursor.getColumnIndex(Constants.PROPERTY_REASON_FOR_SELLING)),
                propertyCursor.getString(propertyCursor.getColumnIndex(Constants.PROPERTY_TIME_FRAME)),
                propertyCursor.getString(propertyCursor.getColumnIndex(Constants.PROPERTY_NO_SELL_CONTINGENCY)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_MORTGAGE_AMOUNT)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_HAS_LIENS)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_HAS_MULTIPLE_MORTGAGES)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_IS_PAYMENT_CURRENT)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_MONTHS_BEHIND)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_AMOUNT_BEHIND)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_BACK_TAXES)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_OTHER_LIEN_AMOUNT)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_MONTHLY_PAYMENT)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_TAX_AMOUNT)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_INSURANCE_AMOUNT)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_FIRST_INTEREST_RATE)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_SECOND_INTEREST_RATE)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_IS_FIXED_RATE)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_PAYMENT_PENALTY)),
                propertyCursor.getString(propertyCursor.getColumnIndex(Constants.PROPERTY_MORTGAGE_COMPANY_1)),
                propertyCursor.getString(propertyCursor.getColumnIndex(Constants.PROPERTY_MORTGAGE_COMPANY_2)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_ASKING_PRICE)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_IS_FLEXIBLE)),
                propertyCursor.getString(propertyCursor.getColumnIndex(Constants.PROPERTY_HOW_PRICE_DERIVED)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_BEST_PRICE_CASH_FAST_CLOSE)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_ABSOLUTE_BOTTOM_PRICE)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_WILL_SUBJECT_TO)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_CAN_ACCEPT_QUICKLY)),
                propertyCursor.getString(propertyCursor.getColumnIndex(Constants.PROPERTY_EVALUATOR)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_ARV)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_REPAIR_COST)),
                propertyCursor.getInt(propertyCursor.getColumnIndex(Constants.PROPERTY_LIKELY_PURCHASE)),
                propertyCursor.getString(propertyCursor.getColumnIndex(Constants.PROPERTY_EXIT_STRATEGY)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_OFFER_1)),
                propertyCursor.getDouble(propertyCursor.getColumnIndex(Constants.PROPERTY_OFFER_2)));
    }

    @Override
    ContentValues getContentValues(Entity entity) {
        ContentValues cv = new ContentValues();
        Property property = (Property) entity;
        cv.put(Constants.PROPERTY_ID, property.getId());
        cv.put(Constants.PROPERTY_ADDRESS_ID, property.getAddress_id());
        cv.put(Constants.PROPERTY_STYLE, property.getStyle());
        cv.put(Constants.PROPERTY_SQFT, property.getSq_ft());
        cv.put(Constants.PROPERTY_LOT_SIZE, property.getLot_size());
        cv.put(Constants.PROPERTY_IS_MULTI_UNIT, property.isIs_multi_unit());
        cv.put(Constants.PROPERTY_YEAR_BUILT, property.getYear_built());
        cv.put(Constants.PROPERTY_HOA_FEES, property.getHoa_fees());
        cv.put(Constants.PROPERTY_IS_OCCUPIED, property.isIs_occupied());
        cv.put(Constants.PROPERTY_OWNER_OCCUPIED, property.isIs_owner_occupied());
        cv.put(Constants.PROPERTY_SPECIAL_FEATURES, property.getSpecial_features());
        cv.put(Constants.PROPERTY_UPGRADES, property.getUpgrades());
        cv.put(Constants.PROPERTY_IS_LISTED, property.isIs_listed());
        cv.put(Constants.PROPERTY_LISTING_DATE, property.getListing_date());
        cv.put(Constants.PROPERTY_HAS_OTHER_OFFERS, property.isHas_other_offers());
        cv.put(Constants.PROPERTY_OFFER_AMOUNT, property.getOffer_amount());
        cv.put(Constants.PROPERTY_REALTOR, property.getRealtor());
        cv.put(Constants.PROPERTY_REALTOR_PHONE, property.getRealtor_phone());
        cv.put(Constants.PROPERTY_REASON_FOR_SELLING, property.getReason_for_selling());
        cv.put(Constants.PROPERTY_TIME_FRAME, property.getTime_frame());
        cv.put(Constants.PROPERTY_NO_SELL_CONTINGENCY, property.getNo_sell_contingency());
        cv.put(Constants.PROPERTY_MORTGAGE_AMOUNT, property.getMortgage_amount());
        cv.put(Constants.PROPERTY_HAS_LIENS, property.isHas_liens());
        cv.put(Constants.PROPERTY_HAS_MULTIPLE_MORTGAGES, property.isHas_multiple_mortgages());
        cv.put(Constants.PROPERTY_IS_PAYMENT_CURRENT, property.isIs_payment_current());
        cv.put(Constants.PROPERTY_MONTHS_BEHIND, property.getMonths_behind());
        cv.put(Constants.PROPERTY_AMOUNT_BEHIND, property.getAmount_behind());
        cv.put(Constants.PROPERTY_BACK_TAXES, property.getBack_taxes());
        cv.put(Constants.PROPERTY_OTHER_LIEN_AMOUNT, property.getOther_lien_amount());
        cv.put(Constants.PROPERTY_MONTHLY_PAYMENT, property.getMonthly_payment());
        cv.put(Constants.PROPERTY_TAX_AMOUNT, property.getTax_amount());
        cv.put(Constants.PROPERTY_INSURANCE_AMOUNT, property.getInsurance_amount());
        cv.put(Constants.PROPERTY_FIRST_INTEREST_RATE, property.getFirst_interest_rate());
        cv.put(Constants.PROPERTY_SECOND_INTEREST_RATE, property.getSecond_interest_rate());
        cv.put(Constants.PROPERTY_IS_FIXED_RATE, property.isIs_fixed_rate());
        cv.put(Constants.PROPERTY_PAYMENT_PENALTY, property.getPayment_penalty());
        cv.put(Constants.PROPERTY_MORTGAGE_COMPANY_1, property.getMortgage_company_1());
        cv.put(Constants.PROPERTY_MORTGAGE_COMPANY_2, property.getGetMortgage_company_2());
        cv.put(Constants.PROPERTY_ASKING_PRICE, property.getAsking_price());
        cv.put(Constants.PROPERTY_IS_FLEXIBLE, property.isIs_flexible());
        cv.put(Constants.PROPERTY_HOW_PRICE_DERIVED, property.getHow_price_derived());
        cv.put(Constants.PROPERTY_BEST_PRICE_CASH_FAST_CLOSE, property.getBest_price_cash_fast_close());
        cv.put(Constants.PROPERTY_ABSOLUTE_BOTTOM_PRICE, property.getAbsolute_bottom_price());
        cv.put(Constants.PROPERTY_WILL_SUBJECT_TO, property.isWill_subject_to());
        cv.put(Constants.PROPERTY_CAN_ACCEPT_QUICKLY, property.isCan_accept_quickly());
        cv.put(Constants.PROPERTY_EVALUATOR, property.getEvaluator());
        cv.put(Constants.PROPERTY_ARV, property.getArv());
        cv.put(Constants.PROPERTY_REPAIR_COST, property.getRepair_cost());
        cv.put(Constants.PROPERTY_LIKELY_PURCHASE, property.isLikely_purchase());
        cv.put(Constants.PROPERTY_EXIT_STRATEGY, property.getExit_strategy());
        cv.put(Constants.PROPERTY_OFFER_1, property.getOffer_1());
        cv.put(Constants.PROPERTY_OFFER_2, property.getOffer_2());
        return cv;
    }

    @Override
    ContentValues getInsertValues(Entity entity) {
        ContentValues cv = new ContentValues();
        Property property = (Property) entity;
        cv.put(Constants.PROPERTY_ADDRESS_ID, property.getAddress_id());
        cv.put(Constants.PROPERTY_STYLE, property.getStyle());
        cv.put(Constants.PROPERTY_SQFT, property.getSq_ft());
        cv.put(Constants.PROPERTY_LOT_SIZE, property.getLot_size());
        cv.put(Constants.PROPERTY_IS_MULTI_UNIT, property.isIs_multi_unit());
        cv.put(Constants.PROPERTY_YEAR_BUILT, property.getYear_built());
        cv.put(Constants.PROPERTY_HOA_FEES, property.getHoa_fees());
        cv.put(Constants.PROPERTY_IS_OCCUPIED, property.isIs_occupied());
        cv.put(Constants.PROPERTY_OWNER_OCCUPIED, property.isIs_owner_occupied());
        cv.put(Constants.PROPERTY_SPECIAL_FEATURES, property.getSpecial_features());
        cv.put(Constants.PROPERTY_UPGRADES, property.getUpgrades());
        cv.put(Constants.PROPERTY_IS_LISTED, property.isIs_listed());
        cv.put(Constants.PROPERTY_LISTING_DATE, property.getListing_date());
        cv.put(Constants.PROPERTY_HAS_OTHER_OFFERS, property.isHas_other_offers());
        cv.put(Constants.PROPERTY_OFFER_AMOUNT, property.getOffer_amount());
        cv.put(Constants.PROPERTY_REALTOR, property.getRealtor());
        cv.put(Constants.PROPERTY_REALTOR_PHONE, property.getRealtor_phone());
        cv.put(Constants.PROPERTY_REASON_FOR_SELLING, property.getReason_for_selling());
        cv.put(Constants.PROPERTY_TIME_FRAME, property.getTime_frame());
        cv.put(Constants.PROPERTY_NO_SELL_CONTINGENCY, property.getNo_sell_contingency());
        cv.put(Constants.PROPERTY_MORTGAGE_AMOUNT, property.getMortgage_amount());
        cv.put(Constants.PROPERTY_HAS_LIENS, property.isHas_liens());
        cv.put(Constants.PROPERTY_HAS_MULTIPLE_MORTGAGES, property.isHas_multiple_mortgages());
        cv.put(Constants.PROPERTY_IS_PAYMENT_CURRENT, property.isIs_payment_current());
        cv.put(Constants.PROPERTY_MONTHS_BEHIND, property.getMonths_behind());
        cv.put(Constants.PROPERTY_AMOUNT_BEHIND, property.getAmount_behind());
        cv.put(Constants.PROPERTY_BACK_TAXES, property.getBack_taxes());
        cv.put(Constants.PROPERTY_OTHER_LIEN_AMOUNT, property.getOther_lien_amount());
        cv.put(Constants.PROPERTY_MONTHLY_PAYMENT, property.getMonthly_payment());
        cv.put(Constants.PROPERTY_TAX_AMOUNT, property.getTax_amount());
        cv.put(Constants.PROPERTY_INSURANCE_AMOUNT, property.getInsurance_amount());
        cv.put(Constants.PROPERTY_FIRST_INTEREST_RATE, property.getFirst_interest_rate());
        cv.put(Constants.PROPERTY_SECOND_INTEREST_RATE, property.getSecond_interest_rate());
        cv.put(Constants.PROPERTY_IS_FIXED_RATE, property.isIs_fixed_rate());
        cv.put(Constants.PROPERTY_PAYMENT_PENALTY, property.getPayment_penalty());
        cv.put(Constants.PROPERTY_MORTGAGE_COMPANY_1, property.getMortgage_company_1());
        cv.put(Constants.PROPERTY_MORTGAGE_COMPANY_2, property.getGetMortgage_company_2());
        cv.put(Constants.PROPERTY_ASKING_PRICE, property.getAsking_price());
        cv.put(Constants.PROPERTY_IS_FLEXIBLE, property.isIs_flexible());
        cv.put(Constants.PROPERTY_HOW_PRICE_DERIVED, property.getHow_price_derived());
        cv.put(Constants.PROPERTY_BEST_PRICE_CASH_FAST_CLOSE, property.getBest_price_cash_fast_close());
        cv.put(Constants.PROPERTY_ABSOLUTE_BOTTOM_PRICE, property.getAbsolute_bottom_price());
        cv.put(Constants.PROPERTY_WILL_SUBJECT_TO, property.isWill_subject_to());
        cv.put(Constants.PROPERTY_CAN_ACCEPT_QUICKLY, property.isCan_accept_quickly());
        cv.put(Constants.PROPERTY_EVALUATOR, property.getEvaluator());
        cv.put(Constants.PROPERTY_ARV, property.getArv());
        cv.put(Constants.PROPERTY_REPAIR_COST, property.getRepair_cost());
        cv.put(Constants.PROPERTY_LIKELY_PURCHASE, property.isLikely_purchase());
        cv.put(Constants.PROPERTY_EXIT_STRATEGY, property.getExit_strategy());
        cv.put(Constants.PROPERTY_OFFER_1, property.getOffer_1());
        cv.put(Constants.PROPERTY_OFFER_2, property.getOffer_2());
        return cv;
    }
}
