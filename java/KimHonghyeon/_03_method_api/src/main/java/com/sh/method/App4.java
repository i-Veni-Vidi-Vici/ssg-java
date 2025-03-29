package com.sh.method;

public class App4 {
    public static void main(String[] args) {
        App4 app =new App4();
        app.printPerson("유관순", 16, '여');
    }
    public void printPerson(String name, int age, char gender){
        //메소드 안에서 매개변수 이름으로 지역변수 중복선언 불가.
        name += '♪';
        age -=1;
        System.out.println("이름: " + name + " 나이: " + age + " 성별 " + gender);
    }
}
