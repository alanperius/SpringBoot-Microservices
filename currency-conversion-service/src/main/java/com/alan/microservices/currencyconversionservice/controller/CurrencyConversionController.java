package com.alan.microservices.currencyconversionservice.controller;


import com.alan.microservices.currencyconversionservice.bean.CurrencyConversionBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable("from") String from,
                                                  @PathVariable("to") String to,
                                                  @PathVariable("quantity") BigDecimal quantity){

        return null;

    }

}
