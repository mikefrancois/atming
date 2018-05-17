package com.mikefrancois.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ui")
public class ATMWebUIController {
 
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello() {
        return "login";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage() {
        return "user";
    }

    @RequestMapping(value = "/user/cities" , method = RequestMethod.GET)
    public String userAuthenticatedPage() {
        return "ingatm";
    }
}