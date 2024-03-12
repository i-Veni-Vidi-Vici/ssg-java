package com.sh._package;
// import문 - 다른 package의 클래스를 가져다 사용하는 경우
import com.sh.method.Calculator;
import com.sh.method.Foo;

/**
 * <pre>
 * 패키지 (package)
 * - 서로 관련있는 클래스의 그룹
 * - 파일구조의 디렉토리(폴더)와 대응된다.
 * - 클랙스의 이름은 패키지를 포함한다.
 * - 동일한 패키지에 동일한 이름의 클래스는 존재하지 않는다.
 * - 도메인(blog.naver.com->com.naver.blog)을 뒤접에서 3레벨 이상 사용 사용하는 것을 권장한다,
 * </pre>
 */

public class App1 {
    public static void main(String[] args){
        //com.sh._package.App1 app1 = new com.sh._package.App1();// 이게 정석으로 쓰는거다
        App1 app1 = new App1();
        app1.test();

        test2();

        //다른 패키지의 클래스를 호출하는 경우
        //1. 패키지 포함한 풀네임을 작성해서 해결 가능
        //2. import문 작성 후 작성
        System.out.println(Calculator.plus(10,20));
        //다른 패키지이지만, import문을 작성하지 않아도 되는 경우 - java.lang패키지의 클래스인 경우
        //ex) String
        //java.lang는 자동으로 import 해준다

        //method 패키지의 App1 클래스의 a,b,c호출
        //동일한 클래스 이름이면, import가 아니라 경로를 써야 한다.
        com.sh.method.App1 app11=new com.sh.method.App1();
        app11.a();

    }

    public void test() {
        System.out.println("🎆🎆🎆test🖼");
    }
    public static void test2() {
        System.out.println("🎆🎆🎆test🖼");
    }
}
