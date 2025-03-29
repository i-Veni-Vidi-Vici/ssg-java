package com.sh._02_handler_method;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// resources = 실행에 필요한 설정파일, application.yaml
// - view단 파일
// 	 - static한 파일 있는 그대로를 보여주는 html, ex)js, css, html(고정적), 이미지
// 	 - templates = 동적으로 관리될 view단 파일

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
