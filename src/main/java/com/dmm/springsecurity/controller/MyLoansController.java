package com.dmm.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dilankam date 12/09/2023
 *
 */ 

@RestController
public class MyLoansController {

 @GetMapping("/myLoans")
 public String getLoansDetails(){
  return "Here are the loan details";

 }
}
