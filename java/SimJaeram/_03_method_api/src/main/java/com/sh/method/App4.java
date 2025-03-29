package com.sh.method;

/**
 * 매개변수는 지역변수(메소드 내부에 선언된 변수)로 처리된다.
 * - 메소드 블럭 안에서 중복 선언할 수 없다.
 * - 변수이므로, 값을 변경할 수 있다.
 * - final 키워드를 사용하면, 상수로써 사용할 수 있다.
 */

public class App4 {
    public static void main(String[] args) {
        App4 app = new App4();
        app.printPersion("유관순", 16, '여');
        app.printPersion("윤봉길", 37, '남');
    }

    public void printPersion(String name, final int age, char gender) {
//        int age = 20;     // 매개변수는 지역변수이므로 동일한 함수 내부에서 중복으로 선언할 수 없다.
//        age -= 1;         // 만 나이 적용, final로 선언하면 상수이므로 값을 변경할 수 없다.
        System.out.println("이름은 " + name + "👍, 나이는 " + age + ", 성별은 " + gender + "입니다.");
    }
}
