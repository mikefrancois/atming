package com.mikefrancois.controller;

import com.mikefrancois.repository.ATMs;
import com.mikefrancois.repository.AtmIng;
import com.mikefrancois.service.LocatorService;
import org.apache.camel.Produce;
import org.apache.camel.impl.DefaultProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api")
public class ATMAPIController {


    @Produce(uri="direct:firstRoute")
    DefaultProducerTemplate producerTemplate;

    @Autowired
    LocatorService locatorService;

    @RequestMapping(value = "/cities" , method = GET)
    public ResponseEntity<ATMs> allCities() throws IOException {
        return new ResponseEntity<ATMs>(locatorService.getAllINGATM(), HttpStatus.OK);
    }

    @RequestMapping(value = "/cities/{city}" , method = GET)
    public ResponseEntity<List<AtmIng>> findATMByCity(@PathVariable String city) {
        return new ResponseEntity<List<AtmIng>>(locatorService.lookingForATMbyCity(city), HttpStatus.OK);
    }

}