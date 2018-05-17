package com.mikefrancois.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtmIng {
    @JsonProperty("address")
    Address address;
    @JsonProperty("distance")
    String distance;
    @JsonProperty("type")
    Type type;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AtmIng{" +
                "address=" + address +
                ", distance='" + distance + '\'' +
                ", type=" + type +
                '}';
    }
}
