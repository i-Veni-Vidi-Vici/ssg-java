package com.sh.lambda._01.inner.clazz;

public class Outer {

    private static int s= 99;
    private int n = 100;

    static  class Inner1{
        private static int s1= 99;
        private int n1 =  100;

        public void a(){
            System.out.println(s);
//            System.out.println(n); //static 자원은 non - static 자원에 접근할 수 없다.
        }
    }

    class Inner2{
        private static int s2 = 99;
        private int n1 = 100;

        public void a(){
            System.out.println(n);
        }
    }
    public void test(){
        //Inner3 instance = new Instance(); 선언 전에 사용 불가
        //지역 변수를 선언한 것과 같다.
        //메소드 안에 클래스 생성
        class Inner3 {
            private static int s3 = 99;
            private int n3 =  100;

            public void a(){
                System.out.println(s);
                System.out.println(n);
            }
        }
        Inner3 instance = new Inner3();
        instance.a();
    }
}
