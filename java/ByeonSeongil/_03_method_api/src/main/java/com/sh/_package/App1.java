package com.sh._package;

// import문 - 다른 package의 클래스를 가져다 사용하는 경우

import com.sh.method.Calculator;
// *를 사용하면, 특정패캐지의 모든 클래스를 동시 impoot 가능
import com.sh.method.*;
// 자주 사용되는 package는 자동으로 import

/**
 * <pre>
 * 패키지 (package)
 * - 서로 관련있는 클래스의 그룹
 * - 파일구조의 디렉토리(폴더)와 대응된다.
 * - 클래스의 이름은 패키지를 포함한다.
 * - 동일한 패키지에 동일한 이름의 클래스는 존재할 수 없다.
 * - 도메인(naver.com -> com.naver)을 뒤집어서 3레벨 이상 사용하는 것을 권장한다.
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        com.sh._package.App1 app = new com.sh._package.App1();
        app.test();

//        App1.test2();
        com.sh._package.App1.test2();

        // 다른 패키지의 클래스를 호출하는 경우
        // 1. 패키지 포함한 풀네임을 작성
        System.out.println(com.sh.method.Calculator.plus(10, 20));

        // 2. import문 작성후 사용
        System.out.println(Calculator.plus(20,30));

        // 3. 다른 패키지이지만, - import 필요없음
        String a ;

        // method 패키지의 App1 클래스의 a,b, c메서드를 호출
        // 동일한 이름의 클래스를 가져다 쓰는 경우, import문이 아닌 풀네임으로 작성해야 한다.
        com.sh.method.App1 app1 = new com.sh.method.App1();

        app1.a();app1.b();

    }

    public void test() {
        System.out.println("😆😆😆 test 😆😆😆");
    }
    public static void test2() {
        System.out.println("😆😆😆 test 😆😆😆");
    }
}
