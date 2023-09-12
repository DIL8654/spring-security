package com.dmm.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dilankam date 12/09/2023
 */

@RestController
public class MyBalanceController {

    @GetMapping("/myBalance")
    public String getBalanceDetails(){
        return "Here are the balance details";
    }

}
