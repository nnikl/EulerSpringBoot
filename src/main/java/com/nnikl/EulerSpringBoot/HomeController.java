package com.nnikl.EulerSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;
    @Autowired
    private PayPalPaymentService payPal;
     @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> index(){
         System.out.println("appName: " + appName);
         return ResponseEntity.status(404).body("not found");
    }

    @GetMapping(value="/test/{euler}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> test(@PathVariable(value = "euler") String euler){
        payPal.processPayment(Double.valueOf(euler));
        return ResponseEntity.ok(euler);
    }



}