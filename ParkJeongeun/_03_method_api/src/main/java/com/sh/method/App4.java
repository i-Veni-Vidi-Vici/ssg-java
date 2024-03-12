package com.sh.method;

/**
 * <pre>
 * 매개변수는 지역변수로 처리됨
 * - 메소드 블럭 안에서 중복선언 할 수 없음
 * - 변수이므로 값을 변경할 수 있음
 * - final 키워드를 사용하면 상수로써 사용할 수 있음
 *
 * </pre>
 */

public class App4 {
    public static void main(String[] args) {
        App4 app = new App4();
        app.printPerson("유관순", 16, '여');
        app.printPerson("윤봉길", 37, '남');
    }

    public void printPerson (String name, final int age, char gender) {
        name += "👍";
//        int age = 20; 매개변수명으로 중복 선언 X
//        age -= 1; // final 작성하면 값 변경 할 수 없음
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age + "세");
        System.out.println("성별 : " + gender);
    }

}
