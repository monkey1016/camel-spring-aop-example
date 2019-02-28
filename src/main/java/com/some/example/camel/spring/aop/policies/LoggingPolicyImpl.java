package com.some.example.camel.spring.aop.policies;

import com.some.example.camel.spring.aop.annotations.LogEvent;
import org.apache.camel.Exchange;
import org.apache.camel.Route;
import org.apache.camel.support.RoutePolicySupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoggingPolicyImpl extends RoutePolicySupport implements LoggingPolicy {
    private static final Logger logger = LoggerFactory.getLogger(LoggingPolicyImpl.class);

    @Autowired
    private LoggingPolicy myself;

    @Override
    @LogEvent
    public void logEvent(String uri) {
        logger.info(uri);
    }

    @Override
    @LogEvent
    public void onExchangeBegin(Route route, Exchange exchange) {
        myself.logEvent("Start: " + route.getEndpoint().getEndpointUri());
    }

    @Override
    @LogEvent
    public void onExchangeDone(Route route, Exchange exchange) {
        myself.logEvent("End: " + route.getEndpoint().getEndpointUri());
    }
}
