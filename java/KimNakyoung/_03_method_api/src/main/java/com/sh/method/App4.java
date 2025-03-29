package com.sh.method;

/**
 * 매개변수 지역변수(메소드안에 선언된 변수)로 처리된다.
 * - 메소드 블럭안에서 중복선언 할 수 없다.
 * - 변수이므로, 값을 변경할 수 있다.
 * - final키워드를 사용하면, 상수로써 사용할 수 있다.
 */

public class App4 {
    public static void main(String[] args) {
        App4 app = new App4();
        app.printPerson("유관순", 16 , '여'); // 바로 쓰기 가능
        app.printPerson("윤봉길",37,'남');

    }
    // fingal -> 상수 최초값 대입 하면 변경 불가능
    public void printPerson(String name, final int age, char gender) {
        // 이미 변수 선언함.


        name += "^^";
        // int age = 20; // 매개변수명으로 중복 선언할 수 없다. 이미 선언했기 때문에
//        age -= 1; // 만나이.............. // final 값변경 할 수 없다.

        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age + "세") ;
        System.out.println("성별 : " + gender);

    }
}
