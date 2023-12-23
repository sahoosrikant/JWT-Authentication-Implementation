package org.example.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
public class TestController {

    //Available for all to access
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public String allAccess(){
        return "Any User Can Read This";
    }

    //Available for only Users

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping(value="/user", method = RequestMethod.GET)
    public String userAccess(){
        return "User Content";
    }

    //Available for all admin
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String adminAccess(){
        return "Admin Content";
    }
}
