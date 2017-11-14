package com.apple.store;

import com.mashape.unirest.request.HttpRequest;

import java.util.concurrent.TimeUnit;

import static com.apple.store.Constants.SCHEDULER;

class Task implements Runnable {

    private final String location;
    private final String holder;

    private Task(String location) {
        this.location = location;
        this.holder = String.format("------------ %s ------------\n", location);
    }

    static void findStore(long period, TimeUnit unit, String location) {
        Task task = new Task(location);
        SCHEDULER.scheduleAtFixedRate(task, 0, period, unit);
    }

    @Override
    public void run() {
        HttpRequest request = Request.forLocation(location);
        Response response = Request.parsedResponse(request);
        if (response.isOk()) {
            System.out.print(holder);
            response.printStores();
            System.out.println(holder);
        }
    }

}
