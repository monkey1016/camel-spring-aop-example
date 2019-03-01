# Spring AOP in Apache Camel
A simple example of how to use Spring AOP within Apache Camel, specifically for Route Policies.

## Overview
Because Spring AOP only activates pointcuts on the proxy object, it's necessary to create interfaces even if there
exists only one implementation. The interface is what must be referenced in the Policy Factory. If a nested method is
called, and also must activate a pointcut, it's necessary to include a reference to the interface within itself. Though
we know it refers to the same object, again the proxy must be used.