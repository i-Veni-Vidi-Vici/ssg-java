package com.sh.spring.common.pokemon;

import org.springframework.stereotype.Component;

/**
 * @primary
 * - 해당 빈 클래스에 직접 작성
 * - @AutoWired에 의해서 동일한 타입의 여러개의 빈이 검색되는 경우, 우선 바인딩할 빈을 선언
 * - 같은 타입에서 @Primary는 하나만 사용해야 한다
 */
@Component
public class Charmander implements Pokemon{
    @Override
    public void attack() {
        System.out.println("파이리 불꽃 공격🧯🧯🧯");
    }
}
