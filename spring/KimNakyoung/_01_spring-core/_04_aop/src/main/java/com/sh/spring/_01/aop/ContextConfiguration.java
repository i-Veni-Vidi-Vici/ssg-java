package com.sh.spring._01.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration("contextConfigurationAOP")
@ComponentScan("com.sh.spring")
@EnableAspectJAutoProxy // 이설정이 있어야 이후에 AOP 코드들이 돌아감. // 이후 모든 AOP 설정을 활성화 하기 위한 설정
public class ContextConfiguration {

}
