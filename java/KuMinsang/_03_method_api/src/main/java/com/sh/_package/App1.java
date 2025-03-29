package com.sh._package;
import com.sh.method.Calculator;
//import com.sh.method.App1;

/**
 * <pre>
 *     패키지(package)
 *     - 서로 관련있는 클래스의 그룹
 *     - 파일 구조의 디렉토리 (폴더)와 대응된다.
 *     - 클래스의 이름은 패키지를 포함한다.
 *     - 동일한 패키지에 동일한 이름의  클래스는 존재할 수 없다.
 *     도메인(blog.naver.com -> com.naver.blog)를 뒤집어서 3레벨 이상 사용하는 것을 권장한다.
 *
 *
 * </pre>
 */

public class App1 {
    public static void main(String[] args) {
        //App1 app = new App1();
        com.sh._package.App1 app = new com.sh._package.App1();
        app.test();

        com.sh._package.App1.test2();

        //다른 패키지의 class를 호출할 경우
        //1. 클래스를 포함한 패키지 풀네임 작성
        com.sh.method.Calculator cal = new com.sh.method.Calculator();
        System.out.println(cal.plus(5, 6));
        //2. import 활용
        System.out.println(Calculator.plus(7, 20));
        //3. 다른 패키지만 import를 하지 않아도 되는 경우
        //- java.lang 패키지의 클래스인 경우
        String str = "ㅋㅋㅋ"; //String에 마우스 커서를 올리면 String 클래스가 java.lang에 포함됨을 알수 있다

        //method 패키지의 App1 클래스의 a, b, c 메소드를 호출
        //동일한 이름의 클래스를 가져다 쓰는 경우 , import문이 아닌 풀네임으로 작성해야 한다.

        com.sh.method.App1 app1 = new com.sh.method.App1();
        app1.c();
        app1.b();
        app1.a();




    }

    public void test(){
        System.out.println("*****test****");
    }

    public static void test2(){
        System.out.println("----test2----");
    }
}
