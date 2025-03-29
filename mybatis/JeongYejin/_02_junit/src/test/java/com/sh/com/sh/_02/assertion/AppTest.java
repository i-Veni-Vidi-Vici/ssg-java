package com.sh.com.sh._02.assertion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <pre>
 * 단정문
 * - 테스트 예상결과와 실제결과를 비교하는 문장
 * - 두 결과가 동일하면 테스트 성공!
 * - junit 단정문, hamcrest, truth 등 중에서 assertj를 가장 많이 사용한다.
 * </pre>
 */
class AppTest {

    App app;

    @BeforeEach
    void setUp() {
        this.app = new App();
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("메소드가 양수를 반환한다")
    @Test
    void 메소드가_양수를_반환한다() {
        int n = app.getNumber();
        assertThat(n).isPositive();
        // org.assertj.core.api
    }

    @DisplayName("getNumber는 1~100사이의 정수를 반환한다")
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

        assertThat(result).isEqualTo(30);
    }

    @DisplayName("random메소드는 100 ~ 200 사이의 난수를 반환해야 한다.")
    @Test
    void test4() {
        int result = app.random();
        assertThat(result).isBetween(100, 200);
        assertThat(result).isGreaterThan(100)
                .isLessThanOrEqualTo(200);
    }
}