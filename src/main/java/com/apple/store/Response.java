package com.apple.store;

import java.util.Collections;
import java.util.List;

class Response {

    static final String OK = "200";
    Head head;
    Body body;

    boolean isOk() {
        return head != null && OK.equals(head.status);
    }

    boolean notAvailableNearOneStore() {
        return body != null &&
                body.notAvailableNearOneStore != null &&
                !body.notAvailableNearOneStore.isEmpty();
    }

    void printStores() {
        if (notAvailableNearOneStore()) {
            System.out.println(body.notAvailableNearOneStore);
            return;
        }
        for (Store store : body.stores) {
            store.printStore();
        }
    }

    static class Head {
        String status = "";
    }

    static class Body {
        List<Store> stores = Collections.emptyList();
        String notAvailableNearOneStore = "";
    }

}
