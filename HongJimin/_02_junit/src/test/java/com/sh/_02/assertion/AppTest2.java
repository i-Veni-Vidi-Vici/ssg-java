package com.sh._02.assertion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

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
                .isBetween()
    }
}
