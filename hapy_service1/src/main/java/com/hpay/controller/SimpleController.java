package com.hpay.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hpay-service1")
public class SimpleController {

	@GetMapping(value = "/get-data")
	public Mono<String> getData(ServerHttpRequest request, ServerHttpResponse response) {
		System.out.println("Inside hpay-service1 getData method");
		HttpHeaders headers = request.getHeaders();
		
		headers.forEach((k,v)->{
			System.out.println(k + " : " + v);
		});
		
		ResponseCookie.ResponseCookieBuilder builder = ResponseCookie.from("hpay-service1-cookie", "hpayservice1CookieValue");
		ResponseCookie cookie = builder.build();
		response.addCookie(cookie);
		Mono<String> data = Mono.just("Hello from Reactive hpay-service1getData method!!");
		return data;
	}
}