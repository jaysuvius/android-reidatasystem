package com.mayps.reidatasystem.Utils;

public class Constants {

    public static String ADDRESS_TABLE = "Addresses";
    public static final String ADDRESS_ID = "_id";
    public static final String ADDRESS_1 = "Address1";
    public static final String ADDRESS_2 = "Address2";
    public static final String ADDRESS_CITY = "City";
    public static final String ADDRESS_STATE = "State";
    public static final String ADDRESS_ZIP = "Zip";
    public static final String ADDRESS_COUNTY = "County";
    public static final String ADDRESS_SORT_COLUMN = "Address1";

    public static String ADDRESS_TABLE_CREATE = "CREATE TABLE " + ADDRESS_TABLE + " (" +
            ADDRESS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ADDRESS_1 +" TEXT, " +
            ADDRESS_2 + " TEXT," +
            ADDRESS_CITY + " TEXT, " +
            ADDRESS_STATE + " TEXT, " +
            ADDRESS_ZIP + " TEXT, " +
            ADDRESS_COUNTY + " TEXT" +
            ")";

    public static String[] ADDRESS_COLUMNS = {ADDRESS_ID, ADDRESS_1, ADDRESS_2, ADDRESS_CITY, ADDRESS_STATE, ADDRESS_ZIP, ADDRESS_COUNTY};
    
    public static String PROPERTY_TABLE = "Properties";
    public static final String PROPERTY_ID = "_id";
    public static final String PROPERTY_NAME = "PropertyName";
    public static final String PROPERTY_ADDRESS_ID = "AddressId";
    public static final String PROPERTY_STYLE = "Style";
    public static final String PROPERTY_SQFT = "SqFt";
    public static final String PROPERTY_LOT_SIZE = "LotSize";
    public static final String PROPERTY_IS_MULTI_UNIT = "IsMultiUnit";
    public static final String PROPERTY_YEAR_BUILT = "YearBuilt";
    public static final String PROPERTY_HOA_FEES = "HoaFees";
    public static final String PROPERTY_IS_OCCUPIED = "IsOccupied";
    public static final String PROPERTY_OWNER_OCCUPIED = "OwnerOccupied";
    public static final String PROPERTY_SPECIAL_FEATURES = "SpecialFeatures";
    public static final String PROPERTY_UPGRADES = "Upgrades";
    public static final String PROPERTY_IS_LISTED = "IsListed";
    public static final String PROPERTY_LISTING_DATE = "ListingDate";
    public static final String PROPERTY_HAS_OTHER_OFFERS = "HasOtherOffers";
    public static final String PROPERTY_OFFER_AMOUNT = "OfferAmount";
    public static final String PROPERTY_REALTOR = "Realtor";
    public static final String PROPERTY_REALTOR_PHONE = "RealtorPhone";
    public static final String PROPERTY_REASON_FOR_SELLING = "ReasonForSelling";
    public static final String PROPERTY_TIME_FRAME = "TimeFrame";
    public static final String PROPERTY_NO_SELL_CONTINGENCY = "NoSellContingency";
    public static final String PROPERTY_MORTGAGE_AMOUNT = "MortgageAmount";
    public static final String PROPERTY_HAS_LIENS = "HasLiens";
    public static final String PROPERTY_HAS_MULTIPLE_MORTGAGES = "HasMultipleMortgages";
    public static final String PROPERTY_IS_PAYMENT_CURRENT = "IsPaymentCurrent";
    public static final String PROPERTY_MONTHS_BEHIND = "MonthsBehind";
    public static final String PROPERTY_AMOUNT_BEHIND = "AmountBehind";
    public static final String PROPERTY_BACK_TAXES = "BackTaxes";
    public static final String PROPERTY_OTHER_LIEN_AMOUNT = "OtherLienAmount";
    public static final String PROPERTY_MONTHLY_PAYMENT = "MonthlyPayment";
    public static final String PROPERTY_TAX_AMOUNT = "TaxAmount";
    public static final String PROPERTY_INSURANCE_AMOUNT = "InsuranceAmount";
    public static final String PROPERTY_FIRST_INTEREST_RATE = "FirstInterestRate";
    public static final String PROPERTY_SECOND_INTEREST_RATE = "SecondInterestRate";
    public static final String PROPERTY_IS_FIXED_RATE = "IsFixedRate";
    public static final String PROPERTY_PAYMENT_PENALTY = "PaymentPenalty";
    public static final String PROPERTY_MORTGAGE_COMPANY_1 = "MortgageCompany1";
    public static final String PROPERTY_MORTGAGE_COMPANY_2 = "MortgageCompany2";
    public static final String PROPERTY_ASKING_PRICE = "AskingPrice";
    public static final String PROPERTY_IS_FLEXIBLE = "IsFlexible";
    public static final String PROPERTY_HOW_PRICE_DERIVED = "HowPriceDerived";
    public static final String PROPERTY_BEST_PRICE_CASH_FAST_CLOSE = "BestPriceCashFastClose";
    public static final String PROPERTY_ABSOLUTE_BOTTOM_PRICE = "AbsoluteBottomPrice";
    public static final String PROPERTY_WILL_SUBJECT_TO = "WillSubjectTo";
    public static final String PROPERTY_CAN_ACCEPT_QUICKLY = "CanAcceptQuickly";
    public static final String PROPERTY_EVALUATOR = "Evaluator";
    public static final String PROPERTY_ARV = "Arv";
    public static final String PROPERTY_AS_IS_VALUE = "AsIsValue";
    public static final String PROPERTY_REPAIR_COST = "RepairCost";
    public static final String PROPERTY_LIKELY_PURCHASE = "LikelyPurchase";
    public static final String PROPERTY_EXIT_STRATEGY = "ExitStrategy";
    public static final String PROPERTY_OFFER_1 = "Offer1";
    public static final String PROPERTY_OFFER_2 = "Offer2";
    public static final String PROPERTY_SORT_COLUMN = "LikelyPurchase";


    public static String PROPERTIES_TABLE_CREATE = "CREATE TABLE " + PROPERTY_TABLE + " (" +
            PROPERTY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            PROPERTY_NAME + " TEXT, " +
            PROPERTY_ADDRESS_ID + " INTEGER, " +
            PROPERTY_STYLE + " TEXT, " +
            PROPERTY_SQFT + " INTEGER, " +
            PROPERTY_LOT_SIZE + " INTEGER, " +
            PROPERTY_IS_MULTI_UNIT + " BIT, " +
            PROPERTY_YEAR_BUILT + " INTEGER, " +
            PROPERTY_HOA_FEES + " REAL, " +
            PROPERTY_IS_OCCUPIED + " BIT, " +
            PROPERTY_OWNER_OCCUPIED + " BIT, " +
            PROPERTY_SPECIAL_FEATURES + " TEXT, " +
            PROPERTY_UPGRADES + " TEXT, " +
            PROPERTY_IS_LISTED + " BIT, " +
            PROPERTY_LISTING_DATE + " INTEGER, " +
            PROPERTY_HAS_OTHER_OFFERS + " BIT, " +
            PROPERTY_OFFER_AMOUNT + " REAL, " +
            PROPERTY_REALTOR + " TEXT, " +
            PROPERTY_REALTOR_PHONE + " TEXT, " +
            PROPERTY_REASON_FOR_SELLING + " TEXT, " +
            PROPERTY_TIME_FRAME + " TEXT, " +
            PROPERTY_NO_SELL_CONTINGENCY + " TEXT, " +
            PROPERTY_MORTGAGE_AMOUNT + " REAL, " +
            PROPERTY_HAS_LIENS + " BIT, " +
            PROPERTY_HAS_MULTIPLE_MORTGAGES + " BIT, " +
            PROPERTY_IS_PAYMENT_CURRENT + " BIT, " +
            PROPERTY_MONTHS_BEHIND + " INTEGER, " +
            PROPERTY_AMOUNT_BEHIND + " REAL, " +
            PROPERTY_BACK_TAXES + " REAL, " +
            PROPERTY_OTHER_LIEN_AMOUNT + " REAL, " +
            PROPERTY_MONTHLY_PAYMENT + " REAL, " +
            PROPERTY_TAX_AMOUNT + " REAL, " +
            PROPERTY_INSURANCE_AMOUNT + " REAL, " +
            PROPERTY_FIRST_INTEREST_RATE + " REAL, " +
            PROPERTY_SECOND_INTEREST_RATE + " REAL, " +
            PROPERTY_IS_FIXED_RATE + " BIT, " +
            PROPERTY_PAYMENT_PENALTY + " REAL, " +
            PROPERTY_MORTGAGE_COMPANY_1 + " TEXT, " +
            PROPERTY_MORTGAGE_COMPANY_2 + " TEXT, " +
            PROPERTY_ASKING_PRICE + " REAL, " +
            PROPERTY_IS_FLEXIBLE + " BIT, " +
            PROPERTY_HOW_PRICE_DERIVED + " TEXT, " +
            PROPERTY_BEST_PRICE_CASH_FAST_CLOSE + " REAL, " +
            PROPERTY_ABSOLUTE_BOTTOM_PRICE + " REAL, " +
            PROPERTY_WILL_SUBJECT_TO + " BIT, " +
            PROPERTY_CAN_ACCEPT_QUICKLY + " BIT, " +
            PROPERTY_EVALUATOR + " TEXT, " +
            PROPERTY_ARV + " REAL, " +
            PROPERTY_AS_IS_VALUE + " REAL, " +
            PROPERTY_REPAIR_COST + " REAL, " +
            PROPERTY_LIKELY_PURCHASE + " BIT, " +
            PROPERTY_EXIT_STRATEGY + " TEXT, " +
            PROPERTY_OFFER_1 + " REAL, " +
            PROPERTY_OFFER_2 + " REAL " +
            ")";

    public static String[] PROPERTY_COLUMNS = {PROPERTY_ID,
            PROPERTY_ADDRESS_ID,
            PROPERTY_NAME,
            PROPERTY_STYLE,
            PROPERTY_SQFT,
            PROPERTY_LOT_SIZE,
            PROPERTY_IS_MULTI_UNIT,
            PROPERTY_YEAR_BUILT,
            PROPERTY_HOA_FEES,
            PROPERTY_IS_OCCUPIED,
            PROPERTY_OWNER_OCCUPIED,
            PROPERTY_SPECIAL_FEATURES,
            PROPERTY_UPGRADES,
            PROPERTY_IS_LISTED,
            PROPERTY_LISTING_DATE,
            PROPERTY_HAS_OTHER_OFFERS,
            PROPERTY_OFFER_AMOUNT,
            PROPERTY_REALTOR,
            PROPERTY_REALTOR_PHONE,
            PROPERTY_REASON_FOR_SELLING,
            PROPERTY_TIME_FRAME,
            PROPERTY_NO_SELL_CONTINGENCY,
            PROPERTY_MORTGAGE_AMOUNT,
            PROPERTY_HAS_LIENS,
            PROPERTY_HAS_MULTIPLE_MORTGAGES,
            PROPERTY_IS_PAYMENT_CURRENT,
            PROPERTY_MONTHS_BEHIND,
            PROPERTY_AMOUNT_BEHIND,
            PROPERTY_BACK_TAXES,
            PROPERTY_OTHER_LIEN_AMOUNT,
            PROPERTY_MONTHLY_PAYMENT,
            PROPERTY_TAX_AMOUNT,
            PROPERTY_INSURANCE_AMOUNT,
            PROPERTY_FIRST_INTEREST_RATE,
            PROPERTY_SECOND_INTEREST_RATE,
            PROPERTY_IS_FIXED_RATE,
            PROPERTY_PAYMENT_PENALTY,
            PROPERTY_MORTGAGE_COMPANY_1,
            PROPERTY_MORTGAGE_COMPANY_2,
            PROPERTY_ASKING_PRICE,
            PROPERTY_IS_FLEXIBLE,
            PROPERTY_HOW_PRICE_DERIVED,
            PROPERTY_BEST_PRICE_CASH_FAST_CLOSE,
            PROPERTY_ABSOLUTE_BOTTOM_PRICE,
            PROPERTY_WILL_SUBJECT_TO,
            PROPERTY_CAN_ACCEPT_QUICKLY,
            PROPERTY_EVALUATOR,
            PROPERTY_ARV,
            PROPERTY_AS_IS_VALUE,
            PROPERTY_REPAIR_COST,
            PROPERTY_LIKELY_PURCHASE,
            PROPERTY_EXIT_STRATEGY,
            PROPERTY_OFFER_1,
            PROPERTY_OFFER_2 };


    public static final String CONTACTS_TABLE = "Contacts";
    public static final String CONTACT_ID = "_id";
    public static final String CONTACT_FIRST_NAME = "FirstName";
    public static final String CONTACT_LAST_NAME= "LastName";
    public static final String CONTACT_MIDDLE_INITIAL= "MiddleInitial";
    public static final String CONTACT_ADDRESS_ID = "AddressId";
    public static final String CONTACT_HOME_PHONE = "HomePhone";
    public static final String CONTACT_MOBILE_PHONE = "MobilePhone";
    public static final String CONTACT_WORK_PHONE = "WorkPhone";
    public static final String CONTACT_EMAIL_ADDRESS= "EmailAddress";
    public static final String CONTACT_IS_REALTOR = "IsRealtor";
    public static final String CONTACT_REALTOR_LICENSE = "RealtorLicense";
    public static final String CONTACT_IS_BROKER = "IsBroker";
    public static final String CONTACT_IS_TITLE = "IsTitle";
    public static final String CONTACT_COMPANY_ID = "CompanyId";
    public static final String CONTACT_SORT_COLUMN = "LastName";


    public static String CONTACTS_TABLE_CREATE = "CREATE TABLE " + CONTACTS_TABLE + " (" +
            CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CONTACT_FIRST_NAME + " TEXT, " +
            CONTACT_LAST_NAME  + " TEXT, " +
            CONTACT_MIDDLE_INITIAL + " TEXT," +
            CONTACT_ADDRESS_ID + " TEXT, " +
            CONTACT_HOME_PHONE + " TEXT, " +
            CONTACT_MOBILE_PHONE + " TEXT, " +
            CONTACT_WORK_PHONE + " TEXT, " +
            CONTACT_EMAIL_ADDRESS + " TEXT, " +
            CONTACT_IS_REALTOR + " BIT, " +
            CONTACT_REALTOR_LICENSE + " TEXT, " +
            CONTACT_IS_BROKER + " BIT, " +
            CONTACT_IS_TITLE + " BIT, " +
            CONTACT_COMPANY_ID + " INTEGER " +
            ")";

    public static String[] CONTACT_COLUMNS = {CONTACT_ID,
            CONTACT_FIRST_NAME,
            CONTACT_LAST_NAME,
            CONTACT_MIDDLE_INITIAL,
            CONTACT_ADDRESS_ID,
            CONTACT_HOME_PHONE,
            CONTACT_MOBILE_PHONE,
            CONTACT_WORK_PHONE,
            CONTACT_EMAIL_ADDRESS,
            CONTACT_IS_REALTOR,
            CONTACT_REALTOR_LICENSE,
            CONTACT_IS_BROKER,
            CONTACT_IS_TITLE,
            CONTACT_COMPANY_ID };

    public static final String REPAIRS_TABLE = "Repair";
    public static final String REPAIR_ID = "_id";
    public static final String REPAIR_PROPERTY_ID = "PropertyId";
    public static final String REPAIR_REPAIR_TYPE_ID = "RepairTypeId";
    public static final String REPAIR_OTHER_DESCRIPTION = "RepairDescription";
    public static final String REPAIR_SORT_COLUMN = "RepairDescription";



    public static String REPAIRS_TABLE_CREATE = "CREATE TABLE " + REPAIRS_TABLE + " (" +
            REPAIR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            REPAIR_PROPERTY_ID + " INTEGER, " +
            REPAIR_REPAIR_TYPE_ID  + " INTEGER, " +
            REPAIR_OTHER_DESCRIPTION + " TEXT " +
            ")";

    public static String[] REPAIR_COLUMNS = {REPAIR_ID,
            REPAIR_PROPERTY_ID,
            REPAIR_REPAIR_TYPE_ID,
            REPAIR_OTHER_DESCRIPTION };
    
    public static String COMPANIES_TABLE = "Companies";
    public static final String COMPANY_ID = "_id";
    public static final String COMPANY_NAME = "Name";
    public static final String COMPANY_TYPE_ID = "TypeId";
    public static final String COMPANY_ADDRESS_ID = "AddressId";
    public static final String COMPANY_PRIMARY_CONTACT_ID = "PrimaryContactId";
    public static final String COMPANY_PHONE_NUMBER = "PhoneNumber";
    public static final String COMPANY_FAX_NUMBER = "FaxNumber";
    public static final String COMPANY_EMAIL_ADDRESS = "EmailAddress";
    public static final String COMPANY_SORT_COLUMN = "Name";



    public static String COMPANIES_TABLE_CREATE = "CREATE TABLE " + COMPANIES_TABLE + " (" +
            COMPANY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COMPANY_NAME + " INTEGER, " +
            COMPANY_TYPE_ID  + " TEXT, " +
            COMPANY_ADDRESS_ID + " TEXT, " +
            COMPANY_PRIMARY_CONTACT_ID + " INTEGER, " +
            COMPANY_PHONE_NUMBER + " TEXT, " +
            COMPANY_FAX_NUMBER + " TEXT, " +
            COMPANY_EMAIL_ADDRESS + " REAL " +
            ")";

    public static String[] COMPANY_COLUMNS = {COMPANY_ID,
            COMPANY_ID,
            COMPANY_NAME,
            COMPANY_TYPE_ID,
            COMPANY_ADDRESS_ID,
            COMPANY_PRIMARY_CONTACT_ID,
            COMPANY_PHONE_NUMBER,
            COMPANY_FAX_NUMBER,
            COMPANY_EMAIL_ADDRESS };

    public static String MULTI_UNITS_TABLE = "MultiUnits";
    public static final String MULTI_UNIT_ID = "_id";
    public static final String MULTI_UNIT_PROPERTY_ID = "PropertyId";
    public static final String MULTI_UNIT_UNIT_NUMBER = "UnitNumber";
    public static final String MULTI_UNIT_SQ_FT = "SqFt";
    public static final String MULTI_UNIT_BEDROOM_COUNT = "BedroomCount";
    public static final String MULTI_UNIT_BATHROOM_COUNT = "BathroomCount";
    public static final String MULTI_UNIT_RENT_AMOUNT = "RentAmount";
    public static final String MULTI_UNIT_IS_OCCUPIED= "IsOccupied";
    public static final String MULTI_UNIT_SPECIAL_FEATURES = "SpecialFeatures";
    public static final String MULTI_UNIT_SORT_COLUMN = "UnitNumber";



    public static String MULTI_UNITS_TABLE_CREATE = "CREATE TABLE " + MULTI_UNITS_TABLE + " (" +
            MULTI_UNIT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            MULTI_UNIT_PROPERTY_ID + " INTEGER, " +
            MULTI_UNIT_UNIT_NUMBER  + " TEXT, " +
            MULTI_UNIT_SQ_FT + " INTEGER, " +
            MULTI_UNIT_BEDROOM_COUNT + " INTEGER, " +
            MULTI_UNIT_BATHROOM_COUNT + " INTEGER, " +
            MULTI_UNIT_RENT_AMOUNT + " REAL, " +
            MULTI_UNIT_IS_OCCUPIED + " BIT, " +
            MULTI_UNIT_SPECIAL_FEATURES + " TEXT " +
            ")";

    public static String[] MULTI_UNIT_COLUMNS = {MULTI_UNIT_ID,
            MULTI_UNIT_ID,
            MULTI_UNIT_PROPERTY_ID,
            MULTI_UNIT_UNIT_NUMBER,
            MULTI_UNIT_SQ_FT,
            MULTI_UNIT_BATHROOM_COUNT,
            MULTI_UNIT_RENT_AMOUNT,
            MULTI_UNIT_IS_OCCUPIED,
            MULTI_UNIT_SPECIAL_FEATURES };


    public static String REPAIR_TYPES_TABLE = "RepairTypes";
    public static final String REPAIR_TYPE_ID = "_id";
    public static final String REPAIR_TYPE_DESCRIPTION = "RepairTypeDescription";
    public static final String REPAIR_TYPE_SORT_COLUMN = "RepairTypeDescription";

    public static String REPAIR_TYPES_TABLE_CREATE = "CREATE TABLE " + REPAIR_TYPES_TABLE + " (" +
            REPAIR_TYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            REPAIR_TYPE_DESCRIPTION +" TEXT " +
            ")";

    public static String[] REPAIR_TYPE_COLUMNS = {REPAIR_TYPE_ID, REPAIR_TYPE_DESCRIPTION};

    public static String COMPANY_TYPES_TABLE = "CompanyTypes";
    public static final String COMPANY_TYPES_ID = "_id";
    public static final String COMPANY_TYPE_DESCRIPTION = "CompanyTypeDescription";
    public static final String COMPANY_TYPE_SORT_COLUMN = "CompanyTypeDescription";

    public static String COMPANY_TYPES_TABLE_CREATE = "CREATE TABLE " + COMPANY_TYPES_TABLE + " (" +
            COMPANY_TYPES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COMPANY_TYPE_DESCRIPTION +" TEXT " +
            ")";

    public static String[] COMPANY_TYPE_COLUMNS = {COMPANY_TYPES_ID, COMPANY_TYPE_DESCRIPTION};



    public static String IMAGES_TABLE = "Images";
    public static final String IMAGE_ID = "_id";
    public static final String IMAGE_COURSE_ID = "CourseId";
    public static final String IMAGE_ASSESSMENT_ID = "AssessmentId";
    public static final String IMAGE = "Image";
    public static final String IMAGE_SORT_COLUMN = "_id";

    public static String IMAGES_TABLE_CREATE = "CREATE TABLE " + IMAGES_TABLE + " (" +
            IMAGE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            IMAGE_COURSE_ID +" INTEGER, " +
            IMAGE_ASSESSMENT_ID +" INTEGER, " +
            IMAGE + " BLOB" +
            ")";

    public static String[] IMAGE_COLUMNS = {IMAGE_ID, IMAGE_COURSE_ID, IMAGE_ASSESSMENT_ID, IMAGE};

    public static String INSERT_COMPANY_TYPES = "INSERT INTO " + COMPANY_TYPES_TABLE + " (" + COMPANY_TYPE_DESCRIPTION + ") VALUES ('Realtor'), ('Broker'), ('Title'), ('Contractor'), ('PML'), ('Hard Money'), ('Bank'), ('Mortgage')";

    public static String INSERT_REPAIR_TYPES = "INSERT INTO " + REPAIR_TYPES_TABLE + " (" + REPAIR_TYPE_DESCRIPTION + ") VALUES ('Roof'), ('Gutters'), ('Finish'), ('Masonry'), ('Painting'), ('Windows'), ('Garage'), ('Landscaping'), ('Concrete/Asphalt'), ('Decks'), ('Pergola'), ('Fence'), ('Pool'), ('Septic')";


}
