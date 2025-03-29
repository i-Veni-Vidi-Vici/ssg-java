package com.sh._01.lifecycle;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    // Fixture 테스트 할 대상 또는 테스트에 필요한 객체 준비
    private App app;

    public AppTest() {
        System.out.println("AppTest 생성자 호출!");

    }

    @BeforeEach
    public void setUp(){
        this.app = new App();
        System.out.println("@BeforeEach");

    }

    @AfterEach
    public  void tearDown(){
        System.out.println("@tearDown");
    }
    // 모든 테스트 메소드전에 1번 실행
    @BeforeAll
    public static void beforeAll(){
        System.out.println("*******@All*******");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("*******@afterAll*******");
    }

    @Test
    public void testFoo1(){
        System.out.println("testFoo1");
        System.out.println(app);

    }
    @Test
    public void testFoo2(){
        System.out.println("testFoo2");
        System.out.println(app);
    }

}