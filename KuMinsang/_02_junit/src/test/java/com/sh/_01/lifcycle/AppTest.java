package com.sh._01.lifcycle;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 테스팅 기본 작성법
 * 테스트 클래스도 하나의 클래스이다
 * 테스트용 메소드에 @Test 어노테이션을 사용
 * @Test 메소드의 접근제한자는 private일수 없다.
 * 여러개의 @Test메소드는 실행순서를 보장하지 않는다. (각 테스트 메소드는 독립적이야 한다.)
 * @Test 메소드 실행할때마다 새로운 테스트객체가 생성된다.
 *
 */
class AppTest {
    //Fixture(테스트할 대상 또는 테스트에 필요한 객체) 준비
    private App app;

    public AppTest() {
        System.out.println("AppTest 생성자 호출!");
    }

    /**
     * 각 테스트 전에 실행 메소드
     */
    @BeforeEach
    public void setUp() {
        System.out.println("@BeforeEach");
        this.app = new App();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("@tearDown");
    }

    /**
     * 테스트 메소드를 시작할때 단 1번 실행
     */

    @BeforeAll

    public static void setUpClass() {
        System.out.println("@BeforeAll");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("@AfterAll");
    }


}