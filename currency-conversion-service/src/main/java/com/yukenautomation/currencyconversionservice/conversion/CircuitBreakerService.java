package com.yukenautomation.currencyconversionservice.conversion;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CircuitBreakerService {

    @Retry(name = "sample-api", fallbackMethod = "fallBacker")
//    @CircuitBreaker(name = "default", fallbackMethod = "fallBacker")
    public String getData() {

        log.info("Sample API call received");
        ResponseEntity<String> datum = new RestTemplate().getForEntity("http://localhost:810", String.class);
        return datum.getBody();
    }

    public String fallBacker(Exception ex) {
        return "Fallback Method";
    }
}
