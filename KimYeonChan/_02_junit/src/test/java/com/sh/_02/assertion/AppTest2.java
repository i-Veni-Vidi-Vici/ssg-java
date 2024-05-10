package com.sh._02.assertion;

import org.assertj.core.data.MapEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AppTest2 {


    @DisplayName("날짜/시간 관련 단정문")
    @Test
    void test2() {
        LocalDateTime sometime = LocalDateTime.of(2024, 5, 8, 12, 30);
        assertThat(sometime)
                .hasYear(2024)
                .hasMonth(Month.MAY)
                .hasDayOfMonth(8)
                .hasMinute(30)
                .isBefore(LocalDateTime.now())
                .isBetween(LocalDateTime.of(2024, 5, 1, 12, 30),
                        LocalDateTime.of(2024, 5, 31, 12, 30));
    }

    /**
     *  <pre>
     *  satisfy 계열: 요소 하나씩 추가적으로 단정문이 필요한 경우
     *  - allSatisfy(consumer): 하위 단정문을 모두 만족하는 지
     *  - anySatisfy(Consumer): 하위 당정문 중 하나라도 만족하는지
     *  - noneSatisfy(Consumer): 하위 단정문 모두 만족하지 않는지
     *  match 계열: 요소 별로 Predicate 검사가 필요한 경우
     *  - allMatch(Predicate): 모든 요소가 Predicate 의 true 를 반환하는지
     *  - anyMatch(Predicate): 하나의 요소라도 Predicate 의 true 를 반환하는지
     *  - noneMatch(Predicate): 모든 요소가 Predicate 의 false 를 반환하는지
     *  </pre>
     */

    @DisplayName("List 단정문")
    @Test
    void test3() {
        List<String> list = List.of("a", "b", "c");
        assertThat(list)
                .contains("a")
                .allSatisfy(name -> {
                    assertThat(name.length()).isGreaterThan(0);
                })
                .allMatch(name -> !name.isEmpty())
                .hasSize(3);

    }

    @DisplayName("Map 단정문")
    @Test
    void test4() {
        Map<String, Integer> map = Map.of("홍길동", 33, "신사임당", 28, "이순신", 44); // Unmodifialbe Map
        assertThat(map)
                .containsKey("홍길동")
                .containsKeys("홍길동", "신사임당")
//                .doseNotContainKey("강감찬")
                .containsValues(33)
                .containsEntry("신사임당", 28)
                .contains(MapEntry.entry("홍길동", 33));
    }

    @DisplayName("예외 단정문")
    @Test
    void test5() {
        assertThatThrownBy(() -> {
            // 예외가 던져지는 실행문
            throw new RuntimeException("ㅋㅋㅋ");
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("ㅋㅋㅋ");

    }
}