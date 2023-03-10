package com.example.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayMicroservice {

	public static void main(String[] args) {
		SpringApplication.run(GatewayMicroservice.class, args);
	}

	@Bean
	RouteLocator staticRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r->r.path("/customers/**").uri("http://localhost:8081"))
				.route(r->r.path("/products/**").uri("http://localhost:8084"))
				.build();

	}

//	@Bean
//	DiscoveryClientRouteDefinitionLocator dynamicRoutes(
//			DiscoveryLocatorProperties dlp, ReactiveDiscoveryClient rdc) {
//		return new DiscoveryClientRouteDefinitionLocator( rdc, dlp);
//	}

}
