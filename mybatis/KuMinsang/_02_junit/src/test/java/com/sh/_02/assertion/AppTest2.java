package com.sh._02.assertion;

import org.assertj.core.data.MapEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AppTest2 {

    @DisplayName("문자열 단정문")
    @Test
    void test(){
        String text = "HelloWorld!";
        assertThat(text)
                .isNotNull()    //null이 아닌지
                .isNotEmpty()   // ""이 아닌지
                .isNotBlank()  // " "이 아닌지
                .contains("oW")
                .startsWith("HelloWorld")
                .endsWith("!")
                .isEqualTo("HelloWorld!");
    }

    @DisplayName("날짜/ 시간과련 단정문")
    @Test
    void test2(){
        LocalDateTime sometime = LocalDateTime.of(2024,5,8,12,30);

        assertThat(sometime)
                .hasYear(2024)
                .hasMonth(Month.MAY)
                .hasDayOfMonth(8)
                .hasHour(12)
                .hasMinute(30)
                .isBefore(LocalDateTime.now())
                .isBetween(LocalDateTime.of(2024,5,1,0,0),
                        LocalDateTime.of(2024,5,31,23,59));
    }

    /**
     * satisfy계열 : 요소 하나씩 추가적으로 단정문이 필요한 경우
     * - allSatisfy(Consumer) : 하위 단정문을 모두 만족하는지
     * - anySatisfy(Consumer) : 하위 단정문중 하나라도 만족하는지
     * - noneSatisfy(Consumer) : 하위 단정문 모두 만족하지 안흔ㄴ지
     * match 계열 : 요소별로 Predicate 검사가 필요한 경우
     * - allMatch(Predicate) : 모든 요소가 Predicate의 true 조건을 만족하는지
     * - anyMatch(Predicate) : 일부 요소가 Predicate의 true 조건을 만족하는지
     * - noneMatch(Predicate) : 모든 요소가 Predicate의 false 조건을 만족하는지
     */

    @DisplayName("List 단정문")
    @Test
    void test3(){
        List<String> list = List.of("홍길동", "이순신", "신사임당");
        assertThat(list)
                .contains("홍길동", "이순신")
                .allSatisfy((name)->{
                    assertThat(name.length()).isGreaterThan(0);
                })
                .allMatch((name)-> !name.isEmpty())
                .hasSize(3);


    }

    @DisplayName("Map 단정문")
    @Test
    void test4(){
        //변경할수 없는 맵 생성
        Map<String, Integer> map = Map.of("홍길동", 33, "신사임당", 28, "이순신", 44);
        assertThat(map)
                .containsKey("홍길동")
                .containsKeys("홍길동", "신사임당")
                .doesNotContainKey("고주몽")
                .containsValue(33)
                .containsEntry("이순신", 44)
                .contains(MapEntry.entry("신사임당", 28));
    }

    @DisplayName("예외 단정문")
    @Test
    void test5(){
        assertThatThrownBy(()->{
            throw new RuntimeException("goodspeed");
//            throw new Exception("goodspeed");
        }).isInstanceOf(Exception.class)
                .hasMessage("goodspeed");
    }
}
