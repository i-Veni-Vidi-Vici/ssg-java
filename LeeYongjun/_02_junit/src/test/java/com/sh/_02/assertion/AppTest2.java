package com.sh._02.assertion;

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
                .isNotNull() // null이 아닌지
                .isNotEmpty() // ""이 아닌지
                .isNotBlank() // "  "은 아닌지
                .contains("ow")
                .startsWith("Hell")
                .endsWith("!")
                .isEqualTo("Helloworld!");
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
                .isBetween(LocalDateTime.of(2024, 5, 1, 0, 0),
                            LocalDateTime.of(2024, 5, 31, 23, 59, 59));
    }

    @DisplayName("List 단정문")
    @Test
    void test3() {
        List<String> list = List.of("홍길동", "이순신", "신사임당");
        assertThat(list)
                .contains("홍길동", "이순신")
                .allSatisfy((name) -> {
                    assertThat(name.length()).isGreaterThan(0);
                })
                .hasSize(3);
    }

    @DisplayName("Map 단정문")
    @Test
    void test4(){
        Map<String,Integer>map = Map.of("홍길동",33,"신사임당",28,"이순신",44);
        assertThat(map)
                .containsKey("홍길동")
                .containsKeys("홍길동","신사임당")
                .doesNotContainKey("강감찬");
    }

    @DisplayName("예외 단정문")
    @Test
    void test5(){
        assertThatThrownBy(() -> {
            // 예외가 던져지는 실행문
            throw new RuntimeException("ㅋㅋㅋㅋ");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("ㅋㅋ");
    }
}
