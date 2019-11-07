package com.alan.microservices.currencyconversionservice.controller;


import com.alan.microservices.currencyconversionservice.bean.CurrencyConversionBean;
import com.alan.microservices.currencyconversionservice.service.CurrencyExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@Slf4j
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable("from") String from,
                                                  @PathVariable("to") String to,
                                                  @PathVariable("quantity") BigDecimal quantity){


        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("from", from);
        urlVariables.put("to", to);

        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, urlVariables);
        CurrencyConversionBean response = responseEntity.getBody();

        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(),
                quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());

    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable("from") String from,
                                                  @PathVariable("to") String to,
                                                  @PathVariable("quantity") BigDecimal quantity){

        Optional<CurrencyConversionBean> response = currencyExchangeService.retrieveExchangeValue(from, to);

        log.info("Response from convertCurrencyFeign() = {}", response);

        return new CurrencyConversionBean(response.get().getId(), from, to, response.get().getConversionMultiple(),
                quantity, quantity.multiply(response.get().getConversionMultiple()), response.get().getPort());
    }

}
