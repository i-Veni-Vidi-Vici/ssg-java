package com.sh._02_transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // @CompinentScan(@붙은걸 다 빈으로 등록해주는 어노테이션)을 상속하고 있기 때문에 빈을 다 등록해준다
@MapperScan // 현재 패키지 하위의 모든 @Mapper 인터페이스 구현체를 빈으로 등록한다.
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
