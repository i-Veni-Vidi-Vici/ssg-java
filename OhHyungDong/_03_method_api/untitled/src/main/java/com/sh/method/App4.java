package com.sh.method;

/**
 * <pre>
 *  매개변수는 지역변수(메소드 안에 선언된 변수)로 처리된다.
 *  - 메소드 블럭 안에서 중복 선언할 수없다.
 *  - 변수이므로 , 값을 변경할 수 없다.
 *  - final 키워드를 사용하면, 상수로써 사용할 수 있다.
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        App4 app = new App4();

        app.printPerson("유관순", 16, "여");
    }

    public void printPerson(String name, int age, String gender)
    {
        name += "😀";
//        int age = 20 매개변수명으로 중복 선언할 수 없다.
        age -= 1; //매개변수를 final로 설정하면 값을 변경할 수 없다.
        System.out.println("이름은 " + name + " 나이는 " + age + " 성별은 " + gender + "입니다. ");
    }
}
