package com.alan.microservices.currencyexchangeservice.BO;

import com.alan.microservices.currencyexchangeservice.entity.ExchangeValue;
import com.alan.microservices.currencyexchangeservice.repository.ExchangeValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeValueBO {

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    public ExchangeValue findByFromAndTo(String from, String to){
        return exchangeValueRepository.findAllByFromAndTo(from, to);
    }

}
