package com.sh.spring._01.aop;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration("contextConfigurationAOP")
@ComponentScan("com.sh.spring")
@EnableAspectJAutoProxy// 이후 모든 AOP 설정을 활성화 하기 위한 설ㅁ정
public class ContextConfiguration {

}
