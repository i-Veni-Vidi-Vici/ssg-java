package com.sh._package;

// import문 - 다른 package의 클래스를 가져다 사용하는 경우
import com.sh.method.Calculator;

/**
 * <h3>패키지 (package)</h3>
 * <pre>
 *     - 서로 관련있는 클래스의 그룹
 *     - 파일 구조의 디렉토리와 대응된다.
 *     - 클래스의 이름은 패키지를 포함한다.
 *     - 동일한 패키지에 동일한 이름의 클래스는 존재할 수 없다.
 *     - 도메인(blog.naver.com -> com.naver.blog)을 뒤집어서 3레벨 이상 사용하는 것을 권장한다.
 * </pre>
 *
 */
public class App1 {
    public static void main(String[] args){
        //App1 app = new App1();
        com.sh._package.App1 app = new com.sh._package.App1();
        app.test();

        com.sh._package.App1.test2();

        // 다른 패키지의 클래스를 호출하는 경우
        // 1. 패키지를 포함한 풀네임을 작성
        System.out.println(com.sh.method.Calculator.plus(10,20));
        // 2. import문 작성 후 사용
        System.out.println(Calculator.plus(20,30));
        // 3. 다른 패키지이지만, import문을 작성하지 않아도 되는 경우 -> java.lang 패키지의 클래스인 경우
        String str = "ABC";
    }

    public void test(){
        System.out.println("🥝🥝🥝 test 🥝🥝🥝");
    }

    public static void test2(){
        System.out.println("🍖🍖🍖 test 🍖🍖🍖");
    }

}
