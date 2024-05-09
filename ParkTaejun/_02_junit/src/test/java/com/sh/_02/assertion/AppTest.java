package com.sh._02.assertion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    App app;

    @BeforeEach
    void setUp() {
        this.app = new App();

    }

    @DisplayName("메소드가 양수를 반환한다") //메소드명보다 우선해서 현됨.
    @Test
    void 메소드가_양수를_반환한다(){
        int n = app.getNumber();
        assertThat(n).isPositive(); // core.api 사용해야함

    }

    @DisplayName("getNumber 는 1~ 100 사이의 정수를 반환한다")
    @Test
    void test2(){
        int n = app.getNumber();
        assertThat(n).isBetween(1, 100);

    }

    @DisplayName("두 수의 합을 밪환한다.")
    @Test
    void test3() {
        int a = 10;
        int b = 20;

        int result = app.sum(a,b);

        assertThat(result).isEqualTo(a+b);

        a = 55;
        b = 35;
        result = app.sum(a, b);
        assertThat(result).isEqualTo(a + b);
    }

    @DisplayName("random 메소드는 100 ~ 200 사이의 난수를 반환해야한다")
    @Test
    void test4() {
        int n = app.random();
        assertThat(n)
                .isGreaterThanOrEqualTo(100)
                .isLessThanOrEqualTo(200);
    }
}