package com.sh._01.lifecycle;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * <pre>
 *  Juint5 구성요소
 *  - JUint Platform 태스팅을 위한 기본 프레임워크
 *  - Juint Jupiter 5 버젼용
 *  - Juint Vintage 3,4 버젼 하위호환용
 *
 *  테스팅 기본작성법
 *  - 테스트클래스도 하나의 클래스이다.
 *  - 테스트용메소드에 @Test 어노테이션을 사용
 *  - @Test 메소드의 접근제한자는 private일 수 없다.
 *  - 여러개의 @Test메소드는 실행순서를 보장하지 않는다. ( 각 테스트 메소드는 !독립적!이어야 한다.)
 *  - @Test메소드 실행할 때 !마다! 새로운 테스트 객체가 생성된다.
 *
 * </pre>
 *
 *
 */





class AppTest {


        // Fixture(테스트 할 대상 또는 테스트에 필요한 객체) 준비

        private  App app;

        public AppTest() {
                System.out.println("AppTest 생성자 호출!");
        }

        /**
         * 각 테스트 전에 실행 메소드
         *
         */

        @BeforeEach
        public void setUp(){
                this.app = new App();
                System.out.println("#BeforeEach");
        }

        // BeforeEach안에서 만든거라서  이제 객체 생성 하나씩 안써줘도 됨

        /**
         *
         * 각 테스트 후에 실행 메소드
         *
         */

        @AfterEach
        public void teatDown(){
                System.out.println("@AfterEach");
        }

        /**
         * 모든 테스트메소드 전에 1번 실행
         *
         */

        @BeforeAll
        public static void beforeAll() {
                System.out.println("@BeforeAll");
        }

        /**
         *
         * 모든 테스트 메소드 후에 한번 실행
         *
         */

        @AfterAll
        public static void afterAll() {
                System.out.println("@AfterAll");
        }


        @Test
        public void testFoo1(){
//                this.app = new App(); // 텍스트 할 대상 매번 만듦 ( BefroeEach에서 만듦)
                System.out.println("testFoo1");
                System.out.println(app);


        }




        @Test
        public void testFoo2(){
//                this.app = new App();
                System.out.println("testFoo2");
                System.out.println(app);


        }

}