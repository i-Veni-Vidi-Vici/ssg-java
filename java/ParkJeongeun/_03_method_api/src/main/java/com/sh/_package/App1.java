package com.sh._package;
// import문 : 다른 package의 클래스를 가져다 사용하는 경우
import com.sh.method.Calculator;
// *를 사용하면 특정 패키지의 모든 클래스를 동시 import 가능
import com.sh.method.*;

// 자주 사용되는 package java.lang의 클래스에 대해서는 컴파일러가 자동으로 import문 추가
import java.lang.String;

/**
 * <pre>
 * 패키지 (package)
 * - 서로 관련있는 클래스의 그룹
 * - 파일구조의 디렉토리(폴더)와 대응됨
 * - 클래스의 이름은 패키지를 포함
 * - 동일한 패키지에 동일한 이름의 클래스는 존재할 수 없음
 * - 도메인을 뒤집어서(blog.naver.com -> com.naver.blog) 3레벨 이상 사용하는 것을 권장
 * </pre>
 */

public class App1 {
    public static void main(String[] args) {
//        App1 app = new App1(); // 약식
        com.sh._package.App1 app = new com.sh._package.App1(); // 원래 문장 (클래스 이름은 패키지를 포함)
        app.test();

//        App1.test2(); // 약식
        com.sh._package.App1.test2(); // 원래 문장 (클래스 이름은 패키지를 포함)

        // 다른 패키지의 클래스를 호출하는 경우
        // 1. 패키지 포함한 풀네임 작성
        System.out.println(com.sh.method.Calculator.plus(10, 20));
        // 2. import문 작성 후 사용
        System.out.println(Calculator.plus(20, 30));
        // 3. 다른 패키지이지만 import문을 작성하지 않아도 되는 경우 : java.lang 패키지의 클래스인 경우
        String str = "ㅋㅋㅋ"; // 원래 맨위에 import java.lang.String; 작성해야함

        // method 패키지의 App1 클래스의 a, b, c 메소드 호출
        // 동일한 이름의 클래스를 가져다 쓰는 경우 import 문이 아닌 풀네임으로 작성해야함
//        App1 app1 = new App1(); method 패키지가 아닌 현재 패키지의 App1 호출 -> import문으로 작성X
        com.sh.method.App1 app1 = new com.sh.method.App1();
        app1.a();
        app1.b();
        app1.c();
    }

    public void test() {
        System.out.println("🥝🥝🥝 test 🥝🥝🥝");
    }

    public static void test2() {
        System.out.println("🍉🍉🍉 test2 🍉🍉🍉");
    }
}
