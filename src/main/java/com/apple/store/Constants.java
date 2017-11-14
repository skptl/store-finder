package com.apple.store;

import com.mashape.unirest.http.Unirest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class Constants {

    private static final String I_PHONE_X_64_GRAY_VZ      = "MQCK2LL/A";
    private static final String I_PHONE_X_64_SILVER_VZ    = "MQCL2LL/A";
    private static final String I_PHONE_X_256_GRAY_VZ     = "MQCN2LL/A";
    private static final String I_PHONE_X_256_SILVER_VZ   = "MQCP2LL/A";

    private static final String I_PHONE_X_64_GRAY_TM      = "MQAQ2LL/A";
    private static final String I_PHONE_X_64_SILVER_TM    = "MQAR2LL/A";
    private static final String I_PHONE_X_256_GRAY_TM     = "MQAU2LL/A";
    private static final String I_PHONE_X_256_SILVER_TM   = "MQAV2LL/A";

    private static final String I_PHONE_X_64_GRAY_AT      = "MQAJ2LL/A";
    private static final String I_PHONE_X_64_SILVER_AT    = "MQAK2LL/A";
    private static final String I_PHONE_X_256_GRAY_AT     = "MQAM2LL/A";
    private static final String I_PHONE_X_256_SILVER_AT   = "MQAN2LL/A";

    private static final String I_PHONE_X_64_GRAY_SP      = "MQCR2LL/A";
    private static final String I_PHONE_X_64_SILVER_SP    = "MQCT2LL/A";
    private static final String I_PHONE_X_256_GRAY_SP     = "MQCV2LL/A";
    private static final String I_PHONE_X_256_SILVER_SP   = "MQCW2LL/A";

    private static final String I_PHONE_X_64_GRAY_UN      = "MQA52LL/A";
    private static final String I_PHONE_X_256_GRAY_UN     = "MQA82LL/A";
    private static final String I_PHONE_X_64_SILVER_UN    = "MQA62LL/A";
    private static final String I_PHONE_X_256_SILVER_UN   = "MQA92LL/A";

    static final String API_PICK_UP = "https://www.apple.com/shop/retail/pickup-message";

    static final String PARAM_PL = "pl";
    static final String PARAM_PARTS = "parts.%d";
    static final String PARAM_LOCATION = "location";

    static final String HEADER_USER_AGENT = "User-Agent";
    static final String HEADER_HOST = "Host";

    static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:56.0) Gecko/20100101 Firefox/56.0";
    static final String HOST = "www.apple.com";

    static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    static final ScheduledExecutorService SCHEDULER = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
    static final Map<String, String> CARRIER_LOOKUP = new HashMap<>();

    static String[] AVAILABLE_PARTS = {
            I_PHONE_X_64_GRAY_VZ,   I_PHONE_X_256_GRAY_VZ,
            I_PHONE_X_64_SILVER_VZ, I_PHONE_X_256_SILVER_VZ,
            I_PHONE_X_64_GRAY_TM,   I_PHONE_X_256_GRAY_TM,
            I_PHONE_X_64_SILVER_TM, I_PHONE_X_256_SILVER_TM,
            I_PHONE_X_64_GRAY_AT,   I_PHONE_X_256_GRAY_AT,
            I_PHONE_X_64_SILVER_AT, I_PHONE_X_256_SILVER_AT,
            I_PHONE_X_64_GRAY_SP,   I_PHONE_X_256_GRAY_SP,
            I_PHONE_X_64_SILVER_SP, I_PHONE_X_256_SILVER_SP,
            I_PHONE_X_64_GRAY_UN,   I_PHONE_X_256_GRAY_UN,
            I_PHONE_X_64_SILVER_UN, I_PHONE_X_256_SILVER_UN
    };

    static {
        CARRIER_LOOKUP.put(I_PHONE_X_64_GRAY_VZ, "Verizon");
        CARRIER_LOOKUP.put(I_PHONE_X_256_GRAY_VZ, "Verizon");
        CARRIER_LOOKUP.put(I_PHONE_X_64_SILVER_VZ, "Verizon");
        CARRIER_LOOKUP.put(I_PHONE_X_256_SILVER_VZ, "Verizon");

        CARRIER_LOOKUP.put(I_PHONE_X_64_GRAY_TM, "T-Mobile");
        CARRIER_LOOKUP.put(I_PHONE_X_256_GRAY_TM, "T-Mobile");
        CARRIER_LOOKUP.put(I_PHONE_X_64_SILVER_TM, "T-Mobile");
        CARRIER_LOOKUP.put(I_PHONE_X_256_SILVER_TM, "T-Mobile");

        CARRIER_LOOKUP.put(I_PHONE_X_64_GRAY_AT, "AT&T");
        CARRIER_LOOKUP.put(I_PHONE_X_256_GRAY_AT, "AT & T");
        CARRIER_LOOKUP.put(I_PHONE_X_64_SILVER_AT, "AT & T");
        CARRIER_LOOKUP.put(I_PHONE_X_256_SILVER_AT, "AT & T");

        CARRIER_LOOKUP.put(I_PHONE_X_64_GRAY_SP, "Sprint");
        CARRIER_LOOKUP.put(I_PHONE_X_256_GRAY_SP, "Sprint");
        CARRIER_LOOKUP.put(I_PHONE_X_64_SILVER_SP, "Sprint");
        CARRIER_LOOKUP.put(I_PHONE_X_256_SILVER_SP, "Sprint");

        CARRIER_LOOKUP.put(I_PHONE_X_64_GRAY_UN, "Unlocked");
        CARRIER_LOOKUP.put(I_PHONE_X_256_GRAY_UN, "Unlocked");
        CARRIER_LOOKUP.put(I_PHONE_X_64_SILVER_UN, "Unlocked");
        CARRIER_LOOKUP.put(I_PHONE_X_256_SILVER_UN, "Unlocked");

        Unirest.setObjectMapper(Mapper.instance());
    }

}
