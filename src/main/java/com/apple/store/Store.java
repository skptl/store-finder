package com.apple.store;

import java.util.*;

public class Store {

    static class Address {
        public String address = "";
        public String address2 = "";
        public String postalCode = "";
    }

    static class StoreHours {
        public List<Hours> hours = Collections.emptyList();
        public String storeHoursText = "";

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
        public String storeTimings = "";
        public String storeDays = "";

        @Override
        public String toString() {
            return String.format("%s %s", storeDays, storeTimings);
        }
    }

    static class Part {

        public static final String UNAVAILABLE ="unavailable";
        public static final String AVAILABLE ="available";

        public String purchaseOption = "";
        public String storePickupQuote = "";
        public boolean storeSelectionEnabled;
        public String partNumber = "";
        public final String partCarrier = "";
        public final String partCapacity = "";
        public final String partColor = "";
        public String pickupDisplay = "";
        public String storePickupProductTitle = "";

        @Override
        public String toString() {
            return String.format("\t+ %s - %s - %s",
                    partNumber,
                    storePickupProductTitle,
                    Constants.LOOKUP.get(partNumber));
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

    public final Set<Part> availability = new HashSet<>();
    public boolean isSomethingAvailable = false;

    public String storeNumber = "";
    public String storeEmail = "";
    public String phoneNumber = "";
    public Map<String, Part> partsAvailability;
    public Address address;
    public StoreHours storeHours;

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
                address.postalCode) ;
    }

}
