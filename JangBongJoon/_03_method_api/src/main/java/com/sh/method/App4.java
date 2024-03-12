package com.sh.method;

public class App4 {
    public static void main(String[] args) {
        /*
        매개변수 지연변수(메서드안에 선언된 변수)로 처리된다
            메서드 블럭안에서 중복선언 할 수 없다.
            변수이므로 값을 변경할 수 있다.
            final 키워드를 사용하면 상수로 사용할 수 있다.
         */
        App4 app = new App4();
        app.printPerson("유관순", 16, "여");
    }

    public void printPerson(String name, int age, String sex) {
        System.out.println(name + age + sex);
    }
}
