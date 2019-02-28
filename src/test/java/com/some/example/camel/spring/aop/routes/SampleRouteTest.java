package com.some.example.camel.spring.aop.routes;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
public class SampleRouteTest {

    @EndpointInject(uri = "direct:sample-route")
    private ProducerTemplate producerTemplate;

    @EndpointInject(uri = "mock:log:sample-route")
    private MockEndpoint mockEndpoint;

    @Test
    public void testAspect() throws InterruptedException {
        producerTemplate.sendBody("Test Message");

        mockEndpoint.assertIsSatisfied();
    }
}
