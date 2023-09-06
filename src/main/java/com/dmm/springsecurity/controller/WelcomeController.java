package com.dmm.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dilankam date 06/09/2023
 */

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(){
            return "welcome to the spring security";
    }
}
