package com.sh._02.assertion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest2 {
    @DisplayName("문자열 단정문")
    @Test
    public void dummy() {
        String text= "Hello world!";
        assertThat(text)
                .isNotNull() // null 아닌지
                .isNotEmpty() // ""이 아닌지
                .isNotBlank() // " "은 아닌지
                .contains("wo")
                .startsWith("Hell")
                .endsWith("!")
                .isEqualTo("Hello world!");
    }

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

    @DisplayName("List 단정문")
    @Test
    void test3() {
        List<String> list = List.of("a", "b", "c");
        assertThat(list)
                .contains("a")
                .allSatisfy(name -> {
                    assertThat(name.length()).isEqualTo(2);
                })
                .hasSize(3);

    }
}