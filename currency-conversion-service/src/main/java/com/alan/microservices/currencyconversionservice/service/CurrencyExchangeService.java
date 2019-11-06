package com.alan.microservices.currencyconversionservice.service;


import com.alan.microservices.currencyconversionservice.bean.CurrencyConversionBean;
import com.alan.microservices.currencyconversionservice.exceptions.CurrencyExchangeNotFoundException;
import com.alan.microservices.currencyconversionservice.service.proxy.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;


    public Optional<CurrencyConversionBean> retrieveExchangeValue(String from, String to){
        Optional<CurrencyConversionBean> currencyConversionBean = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);

        return currencyConversionBean;
    }
}
