package com.hieu.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CalculatorController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("calculate/{num1}/{num2}")
    public int calculate(@PathVariable int  num1, @PathVariable int num2){
        int num3 = restTemplate.getForObject("http://calculator2/calculate02/"+num1+"/"+num2, Integer.class);
        return num3;
    }
}
