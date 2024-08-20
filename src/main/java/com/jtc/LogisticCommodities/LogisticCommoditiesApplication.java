package com.jtc.LogisticCommodities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
//@EnableSwagger2
public class LogisticCommoditiesApplication {



	public static void main(String[] args) {
		SpringApplication.run(LogisticCommoditiesApplication.class, args);
	}

}
