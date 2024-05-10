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
    void test1() {
        String text = "Helloworld!";
        assertThat(text)
                .isNotNull() // null이 아닌지 체크
                .isNotEmpty() // ""이 아닌지 체크
                .isNotBlank() // "  "이 아닌지 체크
                .contains("ow")
                .startsWith("Hell")
                .endsWith("!")
                .isEqualTo("Helloworld!");
    }
    @DisplayName("날짜/시간 관련 단정문")
    @Test
    void test2() {
        LocalDateTime sometime = LocalDateTime.of(2024, 5, 8, 12, 30);

        assertThat(sometime)
                .hasYear(2024)
                .hasMonth(Month.MAY) // 이넘으로 써야 함
                .hasDayOfMonth(8)
                .hasHour(12)
                .hasMinute(30)
                .isBefore(LocalDateTime.now())
                .isBetween(LocalDateTime.of(2024, 5, 1, 0, 0),
                        LocalDateTime.of(2024, 5, 31, 23, 59, 59));    }

    /**
     * <pre>
     *     satisfy 계열 : 요소 하나씩 추가적으로 단정문이 필요한 경우 사용
     *     - allSatisfy(Consumer) : 하위 단정문을 모두 만족하는지 체크
     *     - anySatisfy(Consumer) : 하위 단정문 중 하나라도 만족하는지 체크
     *     - noneSatisfy(Consuemr) : 하위 단저문 모두 만족하지 않는지 체크
     *
     *     match계열 : 요소 별로 Predicate 검사(true false로 반환하는 검사)가 필요한 경우
     *     - allMatch(Predicate) : 모든 요소가 Predicate의 true를 반환하는지
     *     - anyMatch(Predicate) : 하나의 요소라도 Predicate의 true를 반환하는지
     *     - noneMatch(Predicate) : 모든 요소가 Predicate의 false를 반환하는지
     * </pre>
     */
    @DisplayName("List 단정문")
    @Test
    void test3() {
        List<String> list = List.of("홍길동", "이순신", "신사임당");
        assertThat(list)
                .contains("홍길동", "이순신")
                .allSatisfy((name) -> {
                    assertThat(name.length()).isGreaterThan(0);
                })
                .allMatch((name) -> !name.isEmpty()) // 모든 요소가 비어있지 않은지 검사
                .hasSize(3);
    }

    @DisplayName("Map 단정문")
    @Test
    void test4() {
        Map <String, Integer> map = Map.of("홍길동", 33, "신사임당", 28, "이순신", 44);

        assertThat(map)
                .containsKey("홍길동")
                .containsKeys("홍길동", "신사임당")
                .doesNotContainKey("강감찬")
                .containsValue(33)
                .containsEntry("신사임당", 28) // key, value를 알고 있는 경우
                .contains(MapEntry.entry("홍길동", 13)); //
    }

    @DisplayName("예외 단정문")
    @Test
    void test5() {
        assertThatThrownBy(() -> {
            // 예외가 던져지는 실행문
            throw new RuntimeException("ㅋㅋㅋㅋㅋ");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("ㅋㅋ");
    }
}
