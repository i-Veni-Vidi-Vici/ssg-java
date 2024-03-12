package com.sh._package;

import java.lang.reflect.Method;

/*
<pre>
패키지
서로 관련있는 클래스의 그룹
파일구조의 디레토리와 대응된다.
클래스의 이름은 패키지를 포함한다.
동일한 패키지에 동일한 이름의 클래는 존재할 수 없다.
</pre>
 */
public class App1 {
    public static void main(String[] args) {
        com.sh.method.App1 app11 = new com.sh.method.App1();
        app11.a();

    }

    public void test() {
        System.out.println("test⚽️⚽️⚽️");
    }

    public static void test2() {
        System.out.println("meetmeetmeet test2 meetmeetmeet");
    }

    //method 패키지의 App1클래스의 a,b,c 메서드를 호출
    //동잃한 이름의 클래스를 가져다 쓰는 경우 import문이 아닌 풀네임으로 작성해야한다.




}
