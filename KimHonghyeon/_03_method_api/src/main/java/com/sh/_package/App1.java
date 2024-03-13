package com.sh._package;
import com.sh.method.Calculator;
/**
 * 패키지(package)
 * -서로 관련있는 클래스의 그룹
 * -파일 구조의 디렉토리와 대응된다.
 * -클래스의 이름은 패키지를 포함.
 * -동일한 패키지 내에 동일한 이름의 클래스는 존재할 수 없다.
 * -보통 도메인(blog.naver.com -> com.naver.blog)을 뒤집어 3레벨 이상 패키지 구조를 만든다.
 * -Asterisk(*)을 사용하면 해당 패키지의 모든 클래스를 동시에 import
 */
public class App1 {
    public static void main(String[] args) {
        com.sh._package.App1 app = new com.sh._package.App1();
        app.test();
        com.sh._package.App1.test2();

        //다른패키지의 클래스 호출
        //1.패키지 포함 풀네임 작성
        System.out.println(com.sh.method.Calculator.plus(10,20));
        //2. 패키지 import
        System.out.println(Calculator.plus(10,20));
        //3. 다른 패키지이지만 import하지 않아도 되는 경우: java.lang 패키지의 클래스들
        java.lang.String str = "d";

        //동일한 이름의 클래스를 가져다 쓰는 경우, import문 불가하고 패키지 포함 풀네임 사용해야 함.
        com.sh.method.App1 app2 = new com.sh.method.App1();
        app2.a();
        app2.b();
    }

    public void test(){
        System.out.println("TEST non static");
    }
    public static void test2(){
        System.out.println("TEST static");
    }
}
