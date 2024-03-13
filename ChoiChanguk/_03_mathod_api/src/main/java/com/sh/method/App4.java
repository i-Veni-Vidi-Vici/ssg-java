package com.sh.method;

/**
 * <pre>
 * 매개변수는 지역변수(메소드안에 선언된 변수)로 처리 된다.
 * - 메소드 블럭안에서 중복선언 할 수 없다.
 * - 변수이므로, 값을 변경할 수 있다.
 * - final키워드를 사용하면, 상수로써 사용할 수 있다.
 * </pre>
 */
public class App4 {
    public static void main(String[] args){
        App4 app4=new App4();

        app4.printPerson("유관순",16,'여');
        app4.printPerson("윤봉길",37,'남');
    }

    public void printPerson (String name,int age,char gender)
    {
        //int age=~ // 이건 메소드에 선언이 되어 있어서 중복 선언은 안된다.
        // final을 붙이면 최초값에서 더 이상 변경이 안된다.
        age-=1;
        name=name+"😊";
        System.out.println(name+" "+age+" "+gender);
    }
}
