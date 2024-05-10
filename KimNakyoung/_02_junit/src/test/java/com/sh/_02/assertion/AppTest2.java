package com.sh._02.assertion;

import net.bytebuddy.asm.Advice;
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
                .isNotNull() // null이 아닌지
                .isNotEmpty() // ""이 아닌지
                .isNotBlank() // "  "은 아닌지
                .contains("ow")
                .startsWith("Hell")
                .endsWith("!")
                .isEqualTo("Helloworld!");

    }

//    @DisplayName("날짜/시간관련 단정문")
//    @Test
//    public void dum() {
//    }

    @DisplayName("날짜/시간관련 단정문")
    @Test
    void test2() {
        LocalDateTime sometime = LocalDateTime.of(2024,5,8,12,30);

        assertThat(sometime)
                .hasYear(2024)
                .hasMonth(Month.MAY) // 이넘으로 써라
                .hasDayOfMonth(8)
                .hasHour(12)
                .hasMinute(30)
                .isBefore(LocalDateTime.now())
                .isBetween(LocalDateTime.of(2024,5,1,0,0),
                        LocalDateTime.of(2024,5,31,23,59,59));
        // 1 ~ 10 startclusive 는 1에서 10일 인데 1,10 포함
        // 1~ 10 end

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
                .allMatch((name) -> !name.isEmpty())
                .hasSize(3);
    }

    @DisplayName("Map 단정문")
    @Test
    void test4() {
        Map<String, Integer> map = Map.of("홍길동", 33, "신사임당", 28, "이순신", 44);

        // assert that map contains key "홍길동" 단정한다 맴은 홍길동으로 키를 가지고있다
        assertThat(map)
                .containsKey("홍길동")
                .containsKeys("홍길동", "신사임당")
                .doesNotContainKey("강감찬")
                .containsValue(33)
                .containsEntry("신사임당", 28)
                .contains(MapEntry.entry("홍길동", 13));
    }

    @DisplayName("예외 단정문")
    @Test
    void test5() {
        assertThatThrownBy(() -> {
            // 예외가 던져지는 실행문
            throw new RuntimeException("ㅋㅋㅋㅋ"); // 안 던져 지면 오류가 나는
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("ㅋㅋ");

    }


}
