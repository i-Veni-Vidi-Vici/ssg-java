package com.sh.spring._02.annotation.config;

import com.sh.spring.common.member.MemberDao;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @ComponentScan(basePackages) 하위에 등록된 @Component 클래스를 빈으로 등록
 */
@Configuration("configurationAnnotation")
//@ComponentScan("com.sh.spring.common.member") // basePackages(value)속성이 필요하다
@ComponentScan(
        value = "com.sh.spring.common.member",
        excludeFilters = { //제외하는거다
//                // 1. 타입으로 제외
//                @ComponentScan.Filter(
//                        type = FilterType.ASSIGNABLE_TYPE,
//                        classes = {MemberDao.class}
//
//                )

//                // 2. Annotaion으로 제외 (@Component, @Controller, @Service, @Repository)
//                @ComponentScan.Filter(
//                        type = FilterType.ANNOTATION,
//                        classes = Comparable.class
//                )
                // 3. 정규표현식으로 제외
                @ComponentScan.Filter(
                        type = FilterType.REGEX,
                        pattern = {"com.sh.app.common.member.*Dao"}
                )
        }

)
public class ContextConfiguration {


}
