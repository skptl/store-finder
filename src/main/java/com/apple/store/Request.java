package com.apple.store;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;

public class Request {

    static Response parsedResponse(HttpRequest request) {
        try {
            return request.asObject(Response.class).getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return new Response();
    }

    static HttpRequest forLocation(String location) {
        HttpRequest httpRequest = Unirest.get(Constants.API_PICK_UP)
                .header(Constants.HEADER_HOST, Constants.HOST)
                .header(Constants.HEADER_USER_AGENT, Constants.USER_AGENT)
                .queryString(Constants.PARAM_PL, Boolean.TRUE)
                .queryString(Constants.PARAM_LOCATION, location);
        for (int i = 0; i < Constants.AVAILABLE_PARTS.length; i++) {
            httpRequest.queryString(String.format(Constants.PARAM_PARTS, i), Constants.AVAILABLE_PARTS[i]);
        }
        return httpRequest;
    }

}
