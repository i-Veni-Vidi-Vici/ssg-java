package com.sh.method;

/**
 * 매개변수는 지역변수로(메소드 안에 선언된 변수) 처리된다.
 * - 메소드 블럭 안에서 중복 선언 할 수 없다.
 * - 변수이므로, 값을 변경할 수 있다.
 * - final 키워드를 사용하면, 상수로써 사용할 수 있다.
 */
public class App4 {
    public static void main(String[] args) {
        App4 app = new App4();
        app.printPerson("유관순", 16, '여');
        app.printPerson("윤봉길", 37, '남');

    }
    public void printPerson(String name, final int age, char gen)
    {
        name += '★';
        // age -= 1; // final 값 변경 할 수 없다.
        System.out.println("이름 : " + name + " 나이 : "+  age + " 성별 : " + gen);
    }
}
