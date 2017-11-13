package com.apple.store;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;

import static com.apple.store.Constants.STORES;

public class StoreFinder {

    private static final String API_PICK_UP = "https://www.apple.com/shop/retail/pickup-message";

    private static final String PARAM_PL = "pl";
    private static final String PARAM_PARTS = "parts.%d";
    private static final String PARAM_LOCATION = "location";

    private static final String HEADER_USER_AGENT = "User-Agent";
    private static final String HEADER_HOST = "Host";

    private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:56.0) Gecko/20100101 Firefox/56.0";
    private static final String HOST = "www.apple.com";

    private static final String[] LOCATIONS = { "Palo Alto, CA", "San Francisco, CA", "Monterey, CA", "Gilroy, CA" };


    public static void main(String[] args) throws UnirestException {
        for (String location : LOCATIONS) {
            HttpResponse<JsonNode> httpResponse = requestForLocation(location).asJson();
            Response response = parsedResponse(httpResponse);
            if (response.isOk()) {
                STORES.addAll(response.body.stores);
            }
        }
        for (Store store : STORES) {
            System.out.println(store);
            if (store.isSomethingAvailable) {
                for (Store.Part part : store.availability) {
                    System.out.println(part);
                }
            }
        }
    }

    private static HttpRequest requestForLocation(String location) {
        HttpRequest httpRequest = Unirest.get(API_PICK_UP)
                .header(HEADER_HOST, HOST)
                .header(HEADER_USER_AGENT, USER_AGENT)
                .queryString(PARAM_PL, Boolean.TRUE)
                .queryString(PARAM_LOCATION, location);
        for (int i = 0; i<Constants.AVAILABLE_PARTS.length; i++) {
            httpRequest.queryString(String.format(PARAM_PARTS, i), Constants.AVAILABLE_PARTS[i]);
        }
        return httpRequest;
    }

    private static Response parsedResponse(HttpResponse<JsonNode> httpResponse) {
        String jsonString = httpResponse.getBody().toString();
        Gson gson = new GsonBuilder()
                .create();
        return gson.fromJson(jsonString, Response.class);
    }

}
