package com.sh.method;

/**
 * <pre>
 * 매개변수 지역벼수로 처리된다.
 * - 메소드 블럭 안에서 중복 선언할 수 없다.
 * - 변수이므로, 값을 변경할 수 있다.
 * - final 키워드를 사용하면, 상수로써 사용할 수 있다.
 * </pre>
 */
public class App4 {

    public static void main(String[] args) {
        App4 app4 = new App4();
        app4.printPerson("유관순", 16, '여');
        app4.printPerson("윤봉길", 37, '남');
    }

    public void printPerson(String name, final int age, char gender) {
        name += "\uD83D\uDC4D";
        //int age = 20;     // 매개변수명으로 중복 선언할 수 없다.
        //age -= 1;         // final이므로 값변경 할 수 없다.

        System.out.println("name : " + name + "\nage : " + age + "\ngender : " + gender);
    }
}
