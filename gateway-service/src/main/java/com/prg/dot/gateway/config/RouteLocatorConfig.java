package com.prg.dot.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                //Apache Active MQ standalone server.
                //This routes to Active MQ 5.16.0
                .route(r -> r.path("/stomp/**")
                        .filters(f -> f
                                .rewritePath("/stomp/?(?<segment>.*)", "/$\\{segment}")
                                .addRequestHeader("Sec-WebSocket-Protocol", "v10.stomp, v11.stomp")
                        )
                        .uri("ws://localhost:61614"))

                //Custom web socket service
//                .route(r -> r.path("/websocket/**")
//                        .filters(f -> f.rewritePath("/websocket/(?<remains>.*)", "/${remains}")
//                                .hystrix(c -> c.setName("hystrix").setFallbackUri("forward:/fallback/websocket")))
//                        .uri("lb://WEBSOCKET-SERVICE/")
//                        .id("websocket-service"))
                .build();
    }
}
