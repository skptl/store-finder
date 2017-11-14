package com.apple.store;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.ObjectMapper;

class Mapper implements ObjectMapper {

    static Mapper instance() {
        return new Mapper();
    }

    private final Gson gson = new GsonBuilder().create();
    @Override
    public <T> T readValue(String value, Class<T> valueType) {
        return gson.fromJson(value, valueType);
    }
    @Override
    public String writeValue(Object value) {
        return gson.toJson(value);
    }
}
