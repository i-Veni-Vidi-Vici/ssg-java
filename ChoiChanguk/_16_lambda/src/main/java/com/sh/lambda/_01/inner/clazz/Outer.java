package com.sh.lambda._01.inner.clazz;

/**
 * <pre>
 * 내부클래스
 * - 클래스 안에 선언된 클래스
 * - 외부클래스 안에서만 사용할 목적을 만들어진 클래스
 * - 연관된 클래스를 그룹핑하기 위해서 사용
 * - 내부클래스에서는 외부 클래스의 private 자원도 접근이 가능하다.
 *
 * 종류
 * 1. static 내부클래스  - 클래스 영역에 static자원으로 선언
 * 2. non-static 내부클래스  - 클래스 영역의 non-static자원
 * 3. 지역 내부클래스 - 메소드안에 지역변수처럼 선언
 * </pre>
 */
public class Outer {

    private static int s = 99;
    private int n = 100;


    static class Inner1{
        private static int s1=99;
        private int n1=100;

        public void a() {
            System.out.println(s);
            //System.out.println(n);// static자원은 non-static자원에 접근할 수 없다.
            //외냐 클래스는 이미 메모리에 올라와 있는데
            //n은 아직 메모리가 안올라와 있어서 사용을 못한다
        }
    }

     class Inner2 {
        private static int s2=99;
        private int n2=100;
        public void a() {
            System.out.println(s);
            System.out.println(n);//얘는 왜 되냐?? 메모리에 같이 올라갔기 때문이다

        }
    }

    public void test(){
        // 지역변수를 선언한 것과 같다 --> 일반메소드 처럼 실행이 되는거다
        //우리가 메소드를 쓰면 필드 -> 함수가 되듯이 가니깐 클래스가 컴파일 됏겟지??
        //그럼 아래 클래스 선언이 가능하다
        // Inner3 instance=new Inner3();// 불가
        class Inner3 {
            private static int s3=99;
            private int n3=100;

            public void a() {
                System.out.println("test(method).Inner(class).void a(): "+s);
                System.out.println(n);
            }
        }
        Inner3 instance=new Inner3();
        instance.a();
    }
}
