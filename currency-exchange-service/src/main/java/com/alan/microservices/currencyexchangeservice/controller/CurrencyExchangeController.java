package com.alan.microservices.currencyexchangeservice.controller;


import com.alan.microservices.currencyexchangeservice.BO.ExchangeValueBO;
import com.alan.microservices.currencyexchangeservice.entity.ExchangeValue;
import com.alan.microservices.currencyexchangeservice.exceptions.CurrencyExchangeNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@Slf4j
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueBO exchangeValueBO;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from,
                                               @PathVariable("to") String to) {

        Optional<ExchangeValue> exchangeValue = exchangeValueBO.findByFromAndTo(from, to);

        if(exchangeValue == null){
            throw new RuntimeException("error getting exchange");
        }

        if(!exchangeValue.isPresent()){
            throw new CurrencyExchangeNotFoundException("There's no exchange for this values");
        }
        exchangeValue.get().setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        log.info("response from retrieveExchangeValue() = {}", exchangeValue);
        return exchangeValue.get();

    }


}
