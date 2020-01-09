package com.vellechokre.util;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public abstract class ApplicationConstant {

    public static final String BRANCH_ID = "x_branch_id";

    public final static String BASE_URL_SMS = "http://sms.adityahosting.com/api/sendhttp.php";

    public final static String AUTH_KEY = "authkey";

    public final static String AUTH_KEY_VALUE = "194440AUTmUj5Qd6o5a646f0a";

    public final static String MOBILE = "mobiles";

    public final static String SENDER_ID = "sender";

    public final static String SENDER_ID_VALUE = "DEVDNT";

    public final static String ROUTE = "route";

    public final static String ROUTE_VALUE = "4";

    public final static String MESSAGE = "message";

    public final static String ADDRESS_SMS =
            "DevClinic address is -176, Sardar Vallabhbhai Patel Rd, k.K.Nagar, Ghatlodiya, Nirnay Nagar, Ahmedabad, Gujarat 360061 ";

    public final static String WELCOME_SMS =
            "May we extend our sincere thanks for the opportunity to meet your dental health needs. We look forward to a continued relationship with you.";

    public final static String APPOINTMENT_REMINDER_SMS =
            "Gental reminder that you have appointment with DevDental today at-";

    public final static String BIRTHDAY_WISH_SMS = "dev dental clinic wishes you happy birthday";

    public final static String DATA_FETCH_SUCCESS = "Data fetched successfully.";

    public final static String DATA_SAVE_SUCCESS = "Data saved successfully.";

    public static final String CONTENT_DISPOSITION = "Content-disposition";

    public static final String ATTACHEMENT_FILENAME = "attachment;filename=";

    public static final String HYPHEN = "-";

    public static final String INVOICE_TYPE = "type";

    public static final String DATE_FORMAT = "ddMMMyy";

    public static final String DATE_FORMAT_UTC_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static final String TIME_ZONE_IST = "IST";

    public static final String DEFAULT_TIME_ZONE = "UTC";

    /*
     * Pdf action Constant starts from here
     */
    public static final String WITH_DETAIL = "withDetail";

    public static final String WITHOUT_DETAIL = "withoutDetail";

    public static final String WITH_DETAIL_WITHOUT_LETTER_HEAD = "withDetailWithoutLetterHead";

    public static final String WITHOUT_DETAIL_WITHOUT__LETTER_HEAD =
            "withoutDetailWithoutLetterHead";

    public static final String PAYMENT_PROCEDURE = "paymentProcedure";

    public static final String CREDIT_NOTE_PDF_LETTER_HEAD = "creditNotePdfWithLetterHead";

    public static final String CREDIT_NOTE_PDF_WITHOUT_LETTER_HEAD =
            "creditNotePdfWithoutLetterHead";

    public static final String SET_SIGNATURE = "SET_SIGNATURE";
}
