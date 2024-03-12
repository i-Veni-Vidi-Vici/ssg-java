package com.sh.method;

/**
 * <pre>
 * 매개변수 지역변수로 처리된다.
 * - 메소드 블럭안에서 중복선언 할 수 없다.
 * - 변수이므로, 값을 변경할 수 있다.
 * - final 키워드를 사용하면, 상수로"서 사용할 수 있다.
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        App4 app = new App4();
        app.printPerson("유관순",16,'여');
        app.printPerson("윤봉길",37,'남');
    }
    public void printPerson(String name, int age, char gender){
        name +="엄지척";
        // int age = 20; 매개변수명으로 중복 선언할 수 없다.
        age -= 1; // final 값변경 할 수 없다.
        System.out.println("이름은 " + name);
        System.out.println("나이는 " + age + "세");
        System.out.println("성별은 " + gender);
    }
}
