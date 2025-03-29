package com.sh._02.assertion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <pre>
 * 단정문
 * - 테스트 예상결과와 실제결과를 비교하는 문장.
 * - 두 결과가 동일하면 테스트 성공!
 * - junit 단정문, hamcrest, truth등 중에서 aseertj를 가장 많이 사용한다.
 * </pre>
 */
class AppTest {
    App app;

    @BeforeEach
    void setUp() {
        this.app = new App();
    }

    @DisplayName("메소드가 양수를 반환한다") // 메소드명보다 우선해서 표현됨.
    @Test
    void 메소드가_양수를_반환한다() {
        int n = app.getNumber();
        assertThat(n).isPositive();
    }

    @DisplayName("getNumber는 1 ~ 100사이의 정수를 반환한다.")
    @Test
    void test2() {
        int n = app.getNumber();
        assertThat(n).isBetween(1, 100);
    }

    @DisplayName("두 수의 합을 반환한다.")
    @Test
    void test3() {
        int a = 10;
        int b = 20;
        int result = app.sum(a, b);
        assertThat(result).isEqualTo(a + b);

        a = 55;
        b = 35;
        result = app.sum(a, b);
        assertThat(result).isEqualTo(a + b);
    }

    @DisplayName("random메소드는 100 ~ 200 사이의 난수를 반환해야한다.")
    @Test
    void test4() {
        int n = app.random();
        assertThat(n)
                .isGreaterThanOrEqualTo(100)
                .isLessThanOrEqualTo(200);
    }
}
