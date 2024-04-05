package com.sh.lambda._01.inner.clazz;

/**
 * <pre>
 * 내부클래스
 *     - 클래스 안에 선언된 클래스
 *     - 외부클래스 안에서만 사용할 목적을 만들어진 클래스
 *     - 연관된 클래스를 그룹핑하기 위해서도 사용한다.
 *     - 내부클래스에서는 외부클래스의 private 자원도 접근이 가능하다.
 *
 *  종류
 *  1. static 내부 클래스 - 클래스 영역의 static 자원
 *  2. non-static 내부클래스 - 클래스 영역의 non-static자원
 *  3. 지역 내부클래스 - 메소드안의 지역변수처럼 선언
 * </pre>
 */

public  class Outer{
    private static int s = 99;

    private int n = 100;

    static class Inner1 {
        private static int s1 = 99;
        private int n1 = 100;

        public void a(){
            System.out.println(s);
//            System.out.println(n); // 출력불가 non static 자원 불가

        }
    }

    class Inner2 {
        private static int s2 = 99;
        private int n2 = 100;

        public void a() {
            System.out.println(s);
            System.out.println(n); // static 자원은 non-static에 호출가능
        }
    }

    public void test(){
//        Inner3 instance = new Inner3(); // 선언전에 사용할 수 없다!


        // 지역변수를 선언한 것과 같다.
        class Inner3 {
            private static int s3 = 99;

            private int n3 = 100;

            public void a() {
                System.out.println(s);
                System.out.println(n);
            }
        }

        Inner3 instance = new Inner3();
        instance.a();
    }
}