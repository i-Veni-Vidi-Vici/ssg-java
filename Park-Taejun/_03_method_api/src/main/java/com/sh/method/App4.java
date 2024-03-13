package com.sh.method;

/**
 * 매개변수는 지역변수로 처리된다.
 * 메소드 블럭 안에서 중보선언 할 수 없다.
 * 변수이므로, 값을 변경할 수 있다.
 * final키워드를 사용하면, 상수로써 사용할 수 있다.
 */

public class App4 {
    public static void main(String [] args){
        App4 app = new App4(); //객체를 만듦
        app.printPerson("유관순", 16,'여' ); //이러게 호출하고 싶음

        app.printPerson("윤봉길", 37,'남' );

    }
    //메소드 선언
    public  void printPerson(String name ,final int age  ,char gender ){
        name += "🤞";
        // int age =20; // 매개변수명으로 중복 선언할 수 없다.
        //age -= 1;

        System.out.println("이름 : " + name);
        System.out.println("나이 :" + age + "세");
        System.out.println("성별 : " + gender);

    }
}
