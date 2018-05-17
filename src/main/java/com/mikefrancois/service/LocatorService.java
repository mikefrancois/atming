package com.mikefrancois.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikefrancois.repository.AtmIng;
import com.mikefrancois.repository.ATMs;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.mikefrancois.utils.JsonReader.readJsonFromUrl;

@Service
public class LocatorService {


    public static final String ING_API = "https://www.ing.nl/api/locator/atms/";

    private final ATMs atms;

    public LocatorService() throws IOException {
        atms = getAllATMDataFromINGAPI();
    }

    private ATMs getAllATMDataFromINGAPI() throws IOException {
        return new ObjectMapper().readValue(
                String.valueOf(readJsonFromUrl(ING_API)), ATMs.class
        );
    }


    public ATMs getAllINGATM() throws IOException {
        return atms;
    }

    public List<AtmIng> lookingForATMbyCity(String city){

        return atms.getAtms().stream()
                .filter(atmIng ->
                        atmIng.getAddress().getCity().equalsIgnoreCase(city)
                )
                .collect(Collectors.toList());
    }
}
