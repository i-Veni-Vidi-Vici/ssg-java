package com.sh.spring.common.pokemon;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Primary
 * - 해당 빈 클래스에 직접 작성
 * - @Autowired에 의해서 동일한 타입의 여러개의 빈이 검색되는 경우, 우선 바인딩할 빈을 선언
 * - 같은 타입에서 @Primary는 하나만 사용해야 한다.
 */
@Component
@Primary // 포켓몬 타입으로 후보가 여러개있을때 해당 클래스가 우선임을 명시하는 primary
public class Charmander implements Pokemon{
    @Override
    public void attack() {
        System.out.println("파이리 불꽃공격~ 🔥🔥🔥");
    }
}
