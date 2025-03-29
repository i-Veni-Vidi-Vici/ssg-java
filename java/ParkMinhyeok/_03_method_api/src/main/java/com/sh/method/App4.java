package com.sh.method;

/**
 * 매개변수는 지역변수(메소드안에 선언된 변수)로 처리된다.
 * - 메소드 블럭안에서 중복선언 할 수 없다.
 * - 변수이므로, 값을 변경할 수 있다.
 * - final 키워드를 사용하면, 상수로써 사용할 수 있다.
 */
public class App4 {
    public static void main(String[] args) {
        App4 app = new App4();
        app.printPerson("유관순", 16, '여');
    }
    public void printPerson(String name, int age, char gender) {
        System.out.println("이름: " + name);
        System.out.println("나이: " + age + "세");
        System.out.println("성별: " + gender);
    }
}
