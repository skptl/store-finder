package com.apple.store;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Constants {

    public static final String I_PHONE_X_64_GRAY_VZ ="MQCK2LL/A";
    public static final String I_PHONE_X_256_GRAY_VZ = "MQCN2LL/A";
    public static final String I_PHONE_X_64_SILVER_VZ = "MQCL2LL/A";
    public static final String I_PHONE_X_256_SILVER_VZ = "MQCP2LL/A";

    public static final String I_PHONE_X_64_GRAY_TM = "MQAQ2LL/A";
    public static final String I_PHONE_X_256_GRAY_TM = "MQAU2LL/A";
    public static final String I_PHONE_X_64_SILVER_TM = "MQAR2LL/A";
    public static final String I_PHONE_X_256_SILVER_TM = "MQAV2LL/A";

    public static final String I_PHONE_X_64_GRAY_AT = "MQAJ2LL/A";
    public static final String I_PHONE_X_256_GRAY_AT = "MQAM2LL/A";
    public static final String I_PHONE_X_64_SILVER_AT = "MQAK2LL/A";
    public static final String I_PHONE_X_256_SILVER_AT = "MQAN2LL/A";

    public static final String I_PHONE_X_64_GRAY_SP = "MQCR2LL/A";
    public static final String I_PHONE_X_256_GRAY_SP = "MQCV2LL/A";
    public static final String I_PHONE_X_64_SILVER_SP = "MQCT2LL/A";
    public static final String I_PHONE_X_256_SILVER_SP = "MQCW2LL/A";

    public static final String I_PHONE_X_64_GRAY_UN = "MQA52LL/A";
    public static final String I_PHONE_X_256_GRAY_UN = "MQA82LL/A";
    public static final String I_PHONE_X_64_SILVER_UN = "MQA62LL/A";
    public static final String I_PHONE_X_256_SILVER_UN = "MQA92LL/A";

    public static String[] AVAILABLE_PARTS = {
            I_PHONE_X_64_GRAY_VZ, I_PHONE_X_256_GRAY_VZ, I_PHONE_X_64_SILVER_VZ, I_PHONE_X_256_SILVER_VZ,
            I_PHONE_X_64_GRAY_TM, I_PHONE_X_256_GRAY_TM, I_PHONE_X_64_SILVER_TM, I_PHONE_X_256_SILVER_TM,
            I_PHONE_X_64_GRAY_AT, I_PHONE_X_256_GRAY_AT, I_PHONE_X_64_SILVER_AT, I_PHONE_X_256_SILVER_AT,
            I_PHONE_X_64_GRAY_SP, I_PHONE_X_256_GRAY_SP, I_PHONE_X_64_SILVER_SP, I_PHONE_X_256_SILVER_SP
    };

    public static String[] UN_AVAILABLE_PARTS = {
            I_PHONE_X_64_GRAY_UN, I_PHONE_X_256_GRAY_UN, I_PHONE_X_64_SILVER_UN, I_PHONE_X_256_SILVER_UN
    };

    public static Map<String, String> LOOKUP = new HashMap<>();

    static {
        LOOKUP.put(I_PHONE_X_64_GRAY_VZ, "I_PHONE_X_64_GRAY_VZ");
        LOOKUP.put(I_PHONE_X_256_GRAY_VZ, "I_PHONE_X_256_GRAY_VZ");
        LOOKUP.put(I_PHONE_X_64_SILVER_VZ, "I_PHONE_X_64_SILVER_VZ");
        LOOKUP.put(I_PHONE_X_256_SILVER_VZ, "I_PHONE_X_256_SILVER_VZ");

        LOOKUP.put(I_PHONE_X_64_GRAY_TM, "I_PHONE_X_64_GRAY_TM");
        LOOKUP.put(I_PHONE_X_256_GRAY_TM, "I_PHONE_X_256_GRAY_TM");
        LOOKUP.put(I_PHONE_X_64_SILVER_TM, "I_PHONE_X_64_SILVER_TM");
        LOOKUP.put(I_PHONE_X_256_SILVER_TM, "I_PHONE_X_256_SILVER_TM");

        LOOKUP.put(I_PHONE_X_64_GRAY_AT, "I_PHONE_X_64_GRAY_AT");
        LOOKUP.put(I_PHONE_X_256_GRAY_AT, "I_PHONE_X_256_GRAY_AT");
        LOOKUP.put(I_PHONE_X_64_SILVER_AT, "I_PHONE_X_64_SILVER_AT");
        LOOKUP.put(I_PHONE_X_256_SILVER_AT, "I_PHONE_X_256_SILVER_AT");

        LOOKUP.put(I_PHONE_X_64_GRAY_SP, "I_PHONE_X_64_GRAY_SP");
        LOOKUP.put(I_PHONE_X_256_GRAY_SP, "I_PHONE_X_256_GRAY_SP");
        LOOKUP.put(I_PHONE_X_64_SILVER_SP, "I_PHONE_X_64_SILVER_SP");
        LOOKUP.put(I_PHONE_X_256_SILVER_SP, "I_PHONE_X_256_SILVER_SP");
    }

    public static final Set<Store> STORES = new HashSet<>();

}
