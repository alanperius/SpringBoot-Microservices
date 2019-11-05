package com.alan.microservices.currencyexchangeservice.repository;

import com.alan.microservices.currencyexchangeservice.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findAllByFromAndTo(String from, String to);
}
