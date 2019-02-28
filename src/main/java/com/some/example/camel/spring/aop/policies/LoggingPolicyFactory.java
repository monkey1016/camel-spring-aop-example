package com.some.example.camel.spring.aop.policies;

import org.apache.camel.CamelContext;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.spi.RoutePolicy;
import org.apache.camel.spi.RoutePolicyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoggingPolicyFactory implements RoutePolicyFactory {
    @Autowired
    LoggingPolicy loggingPolicy;

    @Override
    public RoutePolicy createRoutePolicy(CamelContext camelContext, String s, RouteDefinition routeDefinition) {
        return loggingPolicy;
    }
}
