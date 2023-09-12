package com.dmm.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dilankam date 12/09/2023
 */

@RestController
public class MyAccountController {

    @GetMapping("/myAccount")
    public String getAccountDetails(){
        return "Here are the account details";
    }
}
