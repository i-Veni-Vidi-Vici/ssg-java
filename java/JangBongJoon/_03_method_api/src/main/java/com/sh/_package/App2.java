package com.sh._package;
/*
import static
일반 import문은 클래스를 지정하는 것이고 static import는 static메소드를 지정한다.
*를 사용하면 특정패키지의 모든 클래스를 동시 import가능하다
 */

import com.sh.method.Calculator;

import static com.sh.method.Calculator.*;

public class App2 {
    public static void main(String[] args) {
        System.out.println(plus(10,20));

    }
}
