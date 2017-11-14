package com.apple.store;

import java.util.*;

class Store {

    final Set<Part> availability = new HashSet<>();
    boolean isSomethingAvailable = false;
    String storeNumber = "";
    String storeEmail = "";
    String phoneNumber = "";
    Map<String, Part> partsAvailability;
    Address address;
    StoreHours storeHours;

    boolean isSomethingAvailable() {
        for (Part part : partsAvailability.values()) {
            if (Part.AVAILABLE.equals(part.pickupDisplay)) {
                availability.add(part);
            }
        }
        return isSomethingAvailable = availability.size() > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return storeEmail.equals(store.storeEmail);
    }

    @Override
    public int hashCode() {
        return storeEmail.hashCode();
    }

    @Override
    public String toString() {
        String addressFormat = "%s - %s, %s, %s";
        return String.format(addressFormat,
                isSomethingAvailable() ? "X" : "0",
                address.address,
                address.address2,
                address.postalCode);
    }

    public void printStore() {
        if (!isSomethingAvailable()) {
            return;
        }
        for (Store.Part part : availability) {
            System.out.println(part);
        }
    }

    static class Address {
        String address = "";
        String address2 = "";
        String postalCode = "";
    }

    static class StoreHours {
        List<Hours> hours = Collections.emptyList();
        String storeHoursText = "";

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (Hours hour : hours) {
                builder.append("     - ");
                builder.append(hour.toString());
                builder.append('\n');
            }
            return builder.toString();
        }
    }

    static class Hours {
        String storeTimings = "";
        String storeDays = "";

        @Override
        public String toString() {
            return String.format("%s %s", storeDays, storeTimings);
        }
    }

    static class Part {

        static final String UNAVAILABLE = "unavailable";
        static final String AVAILABLE = "available";
        String purchaseOption = "";
        String storePickupQuote = "";
        boolean storeSelectionEnabled;
        String partNumber = "";
        String pickupDisplay = "";
        String storePickupProductTitle = "";

        @Override
        public String toString() {
            return String.format("\t+ %s - %s - %s",
                    partNumber,
                    Constants.CARRIER_LOOKUP.get(partNumber),
                    storePickupProductTitle);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Part part = (Part) o;
            return partNumber.equals(part.partNumber);
        }

        @Override
        public int hashCode() {
            return partNumber.hashCode();
        }
    }

}
