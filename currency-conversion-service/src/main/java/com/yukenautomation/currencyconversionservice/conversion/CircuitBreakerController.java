package com.yukenautomation.currencyconversionservice.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

    //    Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    @Autowired
    private CircuitBreakerService service;

    @GetMapping("/simple")
    public String getSimple() {
        return service.getData();
    }


}
