package com.hpay.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hpay-service2")
public class SimpleController {
	@GetMapping(value = "/get-data")
	public Mono<String> getData(ServerHttpRequest request, ServerHttpResponse response) {
		System.out.println("Inside hpay-service2 getData method");
		HttpHeaders headers = request.getHeaders();
		
		headers.forEach((k,v)->{
			System.out.println(k + " : " + v);
		});
		Mono<String> data = Mono.just("Hello from Reactive hpay-service2 getData method!!");
		return data;
	}
}
