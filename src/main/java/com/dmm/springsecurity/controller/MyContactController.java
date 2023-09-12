package com.dmm.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dilankam date 12/09/2023
 *
 */ 

 
 @RestController
 public class MyContactController {

  @GetMapping("/contact")
  public String saveContactDetails(){
  return "Contact details updated";
  }
}
