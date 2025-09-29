package com.fancycalc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/calc/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/calc/subtract")
    public int subtract(@RequestParam int a, @RequestParam int b) {
        return a - b;
    }

    @GetMapping("/calc/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b) {
        return a * b;
    }

    @GetMapping("/calc/divide")
    public int divide(@RequestParam int a, @RequestParam int b) {
        return b != 0 ? a / b : 0;
    }
}
