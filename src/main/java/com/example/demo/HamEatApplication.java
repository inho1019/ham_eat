package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo","ham.*"})
@EntityScan("ham.bean")//엔티티 스캔
@EnableJpaRepositories("ham.dao")//리파지토리 위치 지정
public class HamEatApplication {

	public static void main(String[] args) {
		SpringApplication.run(HamEatApplication.class, args);
	}

}
