package com.sh._package;
// import문 - 다른 package의 클래스를 가져다 사용하는 경우
import com.sh.method.Calculator;
// *를 사용하면, 특정패키지의 모든 클래스를 동시 import도 가능하다.
import com.sh.method.*;

// 자주 사용되는 package java.lang의 클래스에 대해서는 compiler가 자동으로 import문을 추가해준다.
import java.lang.String;

/**
 * <pre>
 * 패키지 (package)
 * - 서로 관련 있는 클래스의 그룹
 * - 파일 주고의 디렉토리와 대응된다.
 * - 클래스의 이름은 패키지를 포함한다.
 * - 동일한 패키지에 동일한 이름의 클래스는 존재할 수 없다.
 * - 도메인을 뒤집처서 3레벨 이상 사용하는 것을 권장한다.
 * - 도메인(blog.naver.com -> com.naver.blog)을 뒤집어서 3레벨 이상 사용하는 것을 권장한다.
 * </pre>
 */
public class App1 {

    public static void main(String[] args) {
        //App1 app1 = new App1();
        com.sh._package.App1 app1 = new com.sh._package.App1();     // 이게 FM 정석
        app1.test();

        // App1.test2();
        com.sh._package.App1.test2();

        // 다른 패키지의 클래스를 호출하는 경우
        // 1. 패키지를 포함한 풀네임을 작성
        System.out.println(com.sh.method.Calculator.plus(10, 20));

        // 2. import문 작성 후 사용
        System.out.println(Calculator.plus(20, 30));

        // 3. 다른 패키지이지만, import문을 작성하지 않아도 되는 경우 - java.lang패키지의 클래스인 경우
        String str = "ㅋㅋㅋ";

        // method 패키지의 App1클래스의 a, b, c 메소드를 호출
        // 동일한 이름의 클래스를 가져다 쓰는 경우, import문이 아닌 풀네임으로 작성해야 한다.
        com.sh.method.App1 app11 = new com.sh.method.App1();
        app11.a();
        app11.b();
        app11.c();
    }

    public void test() {
        System.out.println("--------test--------");
    }

    public static void test2() {
        System.out.println("--------test2---------");
    }
}
