package com.sh._01.lifecycle;

import org.junit.jupiter.api.*;

/**
 * JUnit 구성 요소
 * - Junit 5 구성요소
 * - JUnit Platform 테스팅을 위한 기본프레임워크
 * - JUnit Jupiter 5 version
 * - Junit Vintage 3,4 version
 *
 * 테스트 기본작성법
 * - 테스트 클래스도 하나의 클래스이다.
 * - 테스트용 메소드에 @Test 어노테이션 사용
 * - @Test 메소드의 접근제한자는 private일 수 없다.
 * - 여러개의 @Test 메소드는 실행순서를 보장하지 않는다.( 각 테스트 메소드는 독립적이어야 한다.)
 * - @Test 메소드 실행할 때마다 새로운 테스트 객체가 생성된다.
 */
public class AppTest {

    //테스트 할 대상 또는 테스트에 필욯한 개게
    private App app;

    public AppTest() {
        System.out.println("AppTest 생성자 호출");
    }

    @Test
    public void testFoo1() {
        this.app = new App();
        System.out.println("testFoo1");
        System.out.println(app);
    }

    /**
     * 각 테스트 전에 실행 메소드
     */
    @BeforeEach
    public void setUp(){
        this.app = new App();
        System.out.println("BeforeEach");
    }

    @AfterEach
    public void EeadDown(){
        System.out.println("AfterEach");
    }

    /**
     * 모든 테스트 메소드 전에 1번실행
     */
    @BeforeAll
    public static void beforeAll(){
        System.out.println("**********@BeforeAll");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("*************@AvfterAloo(");
    }

    @Test
    public void testFoo2() {
        this.app = new App();


        System.out.println("testFoo2");
    }
}
