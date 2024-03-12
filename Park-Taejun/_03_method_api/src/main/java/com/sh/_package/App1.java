package com.sh._package;

// import문 여기에 작성 - 다른 package의 클래스를 가져다 사용하는 경우
import com.sh.method.Calculator;
// *를 사용하면, 특정패키지의 모든 클래스를 동시 import도 가능함
import com.sh.method.*;
import java.lang.String;


// 자주 사용되는 package java.lang의 클래스 대해서는 compiler가 자동으로 import문을 추가해준다.
import java.lang.String;
public class App1 {
    /**
     * 패키지 (package)
     * 서로 관련있는 클래스의 그룹
     * 파일구조의 디렉토리와 대응된다
     * 클래스 이름은 패키지를 포함한다
     * 동일한 패키지에 동일한 이름의 클래스 존재 x
      */
    public static void main(String[] args){
        App1 app = new App1();
        app. test();

        App1.test2();

        //다른 패키지의 클래스를 호출하는 경우
        //1. 패키지 포함한 풀네임을 작성하여 해결 가능.
        System.out.println(com.sh.method.Calculator.plus(10,20));
        //2. import문 작성 후 사용
        System.out.println(Calculator.plus(20, 30));

        // 같은 패키지에서는 그냥 쓰면되지만 다른 패키지에서는 풀네임이나 임포트문 작성해야함

        //3. 다른 패키지 이지만, import문을 작성하지 않아도 되는 경우 - java. lang 패키지의 클래스인 경우

        String str = "ㅋㅋㅋ;;";

        //method 패키지의 App1 클래스의 a, b, c 메소드를 호출
        //동일한 이름의 클래스를 가져다 쓰는 경우, import문이 아닌 풀네임으로 작성해야함.

        com.sh.method.App1 app1 = new com.sh.method.App1();
        app1. a();
        app1. b();
        app1. b();


    }

    public void test(){
        System.out.println("test");
    }

    public  static void test2() {
        System.out.println("test2");
    }

}
