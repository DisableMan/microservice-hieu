package com.hieu.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @GetMapping("calculate02/{num1}/{num2}")
    public int calculate(@PathVariable int  num1, @PathVariable int num2){
        return num1 * num2;
    }
}
