package com.sh._03_spring_crud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@MapperScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
