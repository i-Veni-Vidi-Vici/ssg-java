package com.sh._01_spring_mybatis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
/**
 * PSA
 * 추상화 레이어를 통해 구현체들을 제어하기 때문에 종속적이지 않다
 * ex. logging framework @Slf4j
 *
 * ***************************
 * APPLICATION FAILED TO START
 * ***************************
 *
 * Description:
 *
 * Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
 *
 * Reason: Failed to determine a suitable driver class
 */