package com.sh._02.assertion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest2 {

    @DisplayName("문자열 단정문")
    @Test
    void test1() {
        String text = "Helloworld!";

        assertThat(text)
                .isNotNull() // null이 아닌지
                .isNotEmpty() // ""이 아닌지
                .isNotBlank() // "   "은 아닌지
                .contains("ow") // ow가 포함되는지
                .startsWith("Hell") // Hell로 시작하는지
                .endsWith("!") // !로 끝나는지
                .isEqualTo("Helloworld!"); // Helloworld와 같은지
    }

    @DisplayName("날짜/시간관련 단정문")
    @Test
    void test2() {
        LocalDateTime sometime = LocalDateTime.of(2024, 5, 8, 12, 30);

        assertThat(sometime)
                .hasYear(2024)
                .hasMonth(Month.MAY)
                .hasDayOfMonth(8)
                .hasHour(12)
                .hasMinute(30)
                .isBefore(LocalDateTime.now())
//                .isAfter(LocalDateTime.now())
                .isBetween(LocalDateTime.of(2024, 5, 1, 0 , 0),
                            LocalDateTime.of(2024, 5, 31, 23, 59, 59));
    }

    @DisplayName("List 단정문")
    @Test
    void test3() {
        List<String> list = List.of("홍길동", "이순신", "신사임당");
        assertThat(list)
                .contains("홍길동", "이순신") // 괄호 안의 값을 포함하고 있는가
                .allSatisfy((name) -> {
                    assertThat(name.length()).isGreaterThan(0);
                })
                .hasSize(3); // 길이가 3인가
    }
}
