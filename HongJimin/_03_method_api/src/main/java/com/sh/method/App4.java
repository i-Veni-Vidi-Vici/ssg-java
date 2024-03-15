package com.sh.method;


/**
 * 매개 변수는 지역 변수로 처리됨
 */
public class App4 {
    public static void main(String[] args) {

        App4 app = new App4();
        app.printPerson("유관순", 16, '여');
        app.printPerson("윤봉길", 37, '남');

    }

    public void printPerson(String name, final int age, char sex) {
        name += "🐥";
//        int age = 10; //매개 변수 명으로 중복 선언할 수 없다.
//        age -= final로 선언시, 매개인자를 바꿀 수 없음!

        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age + "세");
        System.out.println("성별 : " + sex);
        System.out.println("");
    }
}
