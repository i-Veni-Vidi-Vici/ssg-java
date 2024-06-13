package com.sh.spring._02.annotationconfig;

import com.sh.spring.common.member.MemberDao;
import com.sh.spring.common.member.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

/**
 * @ComponentScan(basePackages) 하위에 등록된 @Component클래스를 반으로 등록
 */
@Configuration("ConfigurationAnnotation")
//@ComponentScan(basePackages = "com.sh.spring.common.member") // basePackages(value)속성
@ComponentScan(
        basePackages = "com.sh.spring.common.member",
        excludeFilters = {
                // 1. 타입으로 제외
//                @ComponentScan.Filter(
//                        type = FilterType.ASSIGNABLE_TYPE,
//                        classes = {MemberDao.class}
//                )
                // 2. Annotation으로 제외
//                @ComponentScan.Filter(
//                        type = FilterType.ANNOTATION,
//                        classes = Component.class
//                )
                // 3. 정규표현식으로 제외
//                @ComponentScan.Filter(
//                        type = FilterType.REGEX,
//                        pattern = {"com.sh.spring.common.member.*"}
//                )
        }
)
public class ContextConfiguration {
    @Bean("member")
    public MemberDto memberDto(){
        return new MemberDto(1L,"honggd","1234","홍길동");
    }
}
