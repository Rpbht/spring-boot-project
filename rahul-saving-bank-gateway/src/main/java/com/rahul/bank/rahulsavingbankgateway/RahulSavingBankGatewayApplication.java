package com.rahul.bank.rahulsavingbankgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.rahul.bank.rahulsavingbankgateway.filters.RequestFIlter;

@EnableZuulProxy
@SpringBootApplication
public class RahulSavingBankGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(RahulSavingBankGatewayApplication.class, args);
	}
	@Bean
	public RequestFIlter filter(){
		return new RequestFIlter();
	}
	
}
