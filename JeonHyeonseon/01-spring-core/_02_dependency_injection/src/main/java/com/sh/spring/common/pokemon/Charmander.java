package com.sh.spring.common.pokemon;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Primary
 * - 해당 빈 클래스에 직접 작성
 * - @Autowired에 의해서 동일한 여러개의 빈이 검색되는 경우, 우선 바인딩할 빈을 선언
 * - 같은 타입에서 @Primary는 하나만 사용해야 한다.
 */
@Component
//@Primary // 아래와 같은 오류가 발생했을 때 이게 제일 우선이라고 설정해주기
// Unsatisfied dependency expressed through constructor parameter 0
// expected single matching bean but found 3: charmander,pikachu,squirtle
public class Charmander implements Pokemon{
    @Override
    public void attack() {
        System.out.println("🔥🔥🔥 파이리 불꽃 공격 🔥🔥🔥");
    }
}
