package com.some.example.camel.spring.aop.policies;

import org.apache.camel.spi.RoutePolicy;

public interface LoggingPolicy extends RoutePolicy {
    void logEvent(String uri);
}
