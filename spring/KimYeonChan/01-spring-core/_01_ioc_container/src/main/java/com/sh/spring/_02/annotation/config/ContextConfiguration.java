package com.sh.spring._02.annotation.config;

import com.sh.spring.common.member.MemberDao;
import com.sh.spring.common.member.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

/**
 * .@ComponentScan(basePackages) 하위에 등록된 @Component 클래스를 빈으로 등록
 */
@Configuration("configurationAnnotation")
@ComponentScan(
        basePackages = "com.sh.spring.common.member", // basePackages(value) 속성
        excludeFilters = {
                // 1. 타입으로 제외
//                @ComponentScan.Filter(
//                        type = FilterType.ASSIGNABLE_TYPE,
//                        classes = {MemberDao.class}
//                )
                // 2. Annotation 으로 제외 (@Component, @Controller, @Service, @Repository)
//                @ComponentScan.Filter(
//                        type = FilterType.ANNOTATION,
//                        classes = Component.class
//                )
                // 3. 정규표현식으로 제외
                @ComponentScan.Filter(
                        type = FilterType.REGEX,
                        pattern = {"com.sh.spring.common.member.*Dao"}
                )
        }
)
public class ContextConfiguration {

}
