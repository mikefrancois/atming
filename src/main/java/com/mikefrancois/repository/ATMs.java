package com.mikefrancois.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ATMs {

    @JsonProperty("atms")
    List<AtmIng> atms;

    public List<AtmIng> getAtms() {
        return atms;
    }

    public void setAtms(List<AtmIng> atms) {
        this.atms = atms;
    }

    @Override
    public String toString() {
        return "ATMs{" +
                "atms=" + atms +
                '}';
    }
}
