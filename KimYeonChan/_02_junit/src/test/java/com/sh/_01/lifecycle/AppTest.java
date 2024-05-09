package com.sh._01.lifecycle;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  <pre>
 *  JUnit5 구성 요소
 *  - JUnit Platform: 테스팅을 위한 기본 프레임 워크
 *  - JUnit Jupiter: 5버전용
 *  - JUint Vintage: 3, 4 버전 하위호환용
 *
 *  테스팅 기본 작성법
 *  - 테스트 클래스도 동일한 하나의 클래스이다.
 *  - 테스트용 메소드에 @Test 어노테이션을 사용
 *  - @Test 메소드의 접근 제한자는 private 일 수 없다.
 *  - 여러개의 @Test 메소드는 실행순서를 보장하지 않는다.(각 테스트 메소드는 독립적이여야 한다.)
 *  - @Test 메소드 실행 할때 마다 새로운 테스트 객체가 생성된다.
 *  </pre>
 */
class AppTest {
    // 테스트 할 대상 또는 테스트에 필요한 객체 준비
    private App app;

    public AppTest() {
        System.out.println("AppTest 생성자 호출!");
    }

    @BeforeEach
    public void setApp() {
        app = new App();
        System.out.println("@BeforeEach");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("@tearDown");
    }

    /**
     * 모든 테스트 메소드 전에 1번 실행
     */
    @BeforeAll
    public static void beforeAll() {
        System.out.println("****** @BeforeAll *****");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("****** @AfterAll ******");
    }

    @Test
    public void testFoo1() {
        System.out.println("testFoo1");
        System.out.println(app);
    }

    @Test
    public void testFoo2() {
        System.out.println("testFoo2");
        System.out.println(app);
    }
}