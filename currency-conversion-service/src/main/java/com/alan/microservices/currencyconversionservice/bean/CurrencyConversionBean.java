package com.alan.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversionBean {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalAmount;
    private Integer port;

}
