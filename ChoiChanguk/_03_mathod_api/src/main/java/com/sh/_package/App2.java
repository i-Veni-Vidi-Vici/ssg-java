package com.sh._package;

//import com.sh.method.Calculator;
//클래스를 import는 static이 가능한지 아닌지 의문
//그니깐 메소드니깐 static이 가능하다
import static com.sh.method.Calculator.plus;

//*를 사용하면, 특정패키지의 모든 클래스를 동시 import도 가능하다
//ex) import com.sh.method.* 이러면 method 패키지를 임포트 한거다

/**
 * <pre>
 * import static
 * - static import를 사용하면, 클래스명을 생략하고 메소드를 호출 할 수 있음
 * - 일반 import는 클래스를 지정하는 것이고, static import는 static메소드(필드)를 지정한다.
 * </pre>
 */

public class App2 {
    public static void main(String[] args)
    {
        System.out.println(plus(40,30));
    }
}
