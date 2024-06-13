package com.sh.spring._01.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration("contextConfigurationAOP")
@ComponentScan("com.sh.spring")
@EnableAspectJAutoProxy // 이게 있어야 AOP 코드들이 돌아간다
public class ContextConfiguration {

}
