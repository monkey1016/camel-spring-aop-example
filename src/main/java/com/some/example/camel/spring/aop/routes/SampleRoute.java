package com.some.example.camel.spring.aop.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SampleRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:sample-route")
            .to("log:sample-route");
    }
}
