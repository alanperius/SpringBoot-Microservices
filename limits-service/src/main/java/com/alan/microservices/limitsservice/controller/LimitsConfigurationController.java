package com.alan.microservices.limitsservice.controller;

import com.alan.microservices.limitsservice.Configuration;
import com.alan.microservices.limitsservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;


    @GetMapping("/limits")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
    public LimitConfiguration retrieveLimitsFromConfigurations() {
        log.info("Calling retrieveLimitsFromConfiguration");
        LimitConfiguration limitConfiguration = new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
        if(limitConfiguration.getMaximum() > 100){
            throw new RuntimeException("testing Hystrix fallback... ");
        }
        return limitConfiguration;
    }

    public LimitConfiguration fallbackRetrieveConfiguration() {
        log.info("----------------------------------------------------------------------------------------------------");
        return new LimitConfiguration(10, 5);
    }

}
