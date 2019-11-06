package com.alan.microservices.currencyexchangeservice.repository;

import com.alan.microservices.currencyexchangeservice.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    Optional<ExchangeValue> findByFromAndTo(String from, String to);
}
