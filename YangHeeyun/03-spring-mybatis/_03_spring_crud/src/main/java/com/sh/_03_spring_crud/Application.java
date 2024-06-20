package com.sh._03_spring_crud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan // 현재 클라스 하위에 모든 mapper를 bean으로 등록해주세요s
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
