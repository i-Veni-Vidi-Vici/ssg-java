package com.sh.spring.common.pokemon;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Primary
 * - 해당 Bean 클래스에 직접 작성
 * - @Autowired에 의해서 동일한 타입의 여러개의 Bean이 검색되는 경우, 우선 바인딩할 Bean을 선언
 * - 같은 타입에서 @Primary는 하나만 사용해야 한다.
 */
@Component
//@Primary
public class Pikachu implements Pokemon{
    @Override
    public void attack() {
        System.out.println("피카츄~ ⚡⚡⚡");
    }
}
