package com.apple.store;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.concurrent.TimeUnit;

public class StoreFinder {

    static final int PERIOD = 1;  // period to poll stores
    static final TimeUnit UNIT = TimeUnit.MINUTES;  // unit for period
    static final String[] LOCATIONS = {
            "Palo Alto, CA",
            "San Francisco, CA",
            "Monterey, CA",
            "Gilroy, CA",
            "Portland, OR",
            "Raleigh, NC",
            "New York, NY"
    };

    public static void main(String[] args) throws UnirestException {
        for (String location : LOCATIONS) {
            Task.findStore(PERIOD, UNIT, location);
        }
    }

}
