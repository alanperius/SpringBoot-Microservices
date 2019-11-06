package com.alan.microservices.currencyconversionservice.service;


import com.alan.microservices.currencyconversionservice.bean.CurrencyConversionBean;
import com.alan.microservices.currencyconversionservice.service.proxy.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;


    public CurrencyConversionBean retrieveExchangeValue(String from, String to){
        return currencyExchangeServiceProxy.retrieveExchangeValue(from, to);
    }
}
