package com.sh._02.assertion;

import org.assertj.core.data.MapEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;


public class AppTest2 {

    @DisplayName("문자열 단정문")
    @Test
    public void test1() {
        String test="cstangga";
        assertThat(test)
                .isNotEmpty()
                .isNotNull()
                .contains("asdf");
    }

    @DisplayName("날싸/시간관련 단정문")
    @Test

    public void test2() {
        LocalDateTime sometime=LocalDateTime.of(2024,5,8,12,10);
        assertThat(sometime)
                .hasYear(2024)
                .hasMonth(Month.MAY)
                .isBefore(LocalDateTime.now())// 현재보다 이전이니??
                .isAfter(LocalDateTime.of(2023,5,5,12,40));
    }

    /**
     * <pre>
     * satisfy 계열 : 요소하나씩 추가적으로 단정문이 필요한 경우
     *  - allSatisfy(Consumer) : 하위 단정문이 모두 만족하는지
     *  - anySatisfy(Consumer) : 하위 단정문 하나라도 만족하는지
     *  - nonSatisfy(Consumer) : 하위 단전문 모두 만족하지 않는지
     * match계열 : 요소별로 Predicate검사가 필요한 경우
     *  - allMatch(Predicate) : 모든 요소가 Predicate의 true를 반환하는지
     *  - anyMatch(Predicate) : 하나의 요소라도 Predicate의 ture를 반환하는지
     *  - nonMatch(Predicate) : 모든 요소가 Predicate의 false를 반환하는지
     * </pre>
     */

    @DisplayName("List 단정문")
    @Test
    public void test3() {
        List<String> list=List.of("홍길동","신사임당","이순신");
        assertThat(list)
                .contains("홍길동","이순신")
                .allSatisfy((name) ->{
                    assertThat(name.length()).isGreaterThan(2);
                } );
    }

    @DisplayName("Map 단정문")
    @Test

    public void test4() {
        Map<String, Integer> map= Map.of("홍길동",33,"신사임당",28,"이순신",44);
        assertThat(map)
                .containsKey("홍길동")
                .contains(MapEntry.entry("홍길동",13));
    }

    @DisplayName("예외 단정문")
    @Test

    public void test5() {
        assertThatThrownBy(()->{
           throw new RuntimeException("예외입니다");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("예외입니다");
    }
}

