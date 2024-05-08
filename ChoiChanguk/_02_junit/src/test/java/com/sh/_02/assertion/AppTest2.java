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
}
