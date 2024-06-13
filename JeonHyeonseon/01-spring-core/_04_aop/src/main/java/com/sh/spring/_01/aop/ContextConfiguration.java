package com.sh.spring._01.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration("contextConfigurationAOP")
@ComponentScan("com.sh.spring")
@EnableAspectJAutoProxy // 이후 모든 AOP설정을 활성화하기 위한 설정. 이게 있어야 aop코드가 돌아간다.
public class ContextConfiguration {
}

