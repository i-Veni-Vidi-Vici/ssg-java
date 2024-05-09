package com.sh._01.lifecycle;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <pre>
 *     JUnit5 구성요소
 *     - JUnit Platform 테스팅을 위한 기본 프레임워크
 *     - JUnit Jupiter 5버전용
 *     - JUnit Vintage 3, 4버전 하위 호환용
 *
 *    ### 테스팅 기본 작성법
 *
 * - 테스트 클래스도 하나의 클래스이다.
 * - 테스트용 메소드에 @Test 어노테이션을 사용
 * - @Test 메소드의 접근제한자는 private일 수 없다.
 * - 여러 개의 @Test 메소드는 실행 순서를 보장하지 않음 (각 테스트 메소드는 독립적이어야 함)
 * - @Test 메소드 실행할 때마다 새로운 테스트 객체가 생성됨
 * </pre>
 */
class AppTest {

    private App app;

    // Fixture(테스트할 대상 또는 테스트에 필요한 객체) 준비
    public AppTest() {
        System.out.println("AppTest 생성자 호출!");
        this.app = new App(); // 테스트할 대상을 매번 새로 만들어야한다.
    }

    /**
     * 각 테스트 전에 실행 메소드
     */
    @BeforeEach
    public void setUp() {
        this.app = new App();
        System.out.println("@BeforeEach");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("@AfterEach");
    }

    /**
     * 모든 테스트메소드 전에 1번 실행
     */
    @BeforeAll
    public static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("@AfterAll");
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