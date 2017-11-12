package com.apple.store;

import java.util.List;

public class Response {

    static class Head {
        public String status;
    }

    static class Body {
        List<Store> stores;
        public String notAvailableNearOneStore;
    }

    public Head head;
    public Body body;

    public boolean isOk() {
        return head != null && "200".equals(head.status);
    }
}
