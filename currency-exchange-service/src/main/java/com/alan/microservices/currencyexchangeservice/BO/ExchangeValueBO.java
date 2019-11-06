package com.alan.microservices.currencyexchangeservice.BO;

import com.alan.microservices.currencyexchangeservice.entity.ExchangeValue;
import com.alan.microservices.currencyexchangeservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExchangeValueBO {

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    public Optional<ExchangeValue> findByFromAndTo(String from, String to){
        return exchangeValueRepository.findByFromAndTo(from, to);
    }

}
