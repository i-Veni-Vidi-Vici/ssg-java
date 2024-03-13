package com.sh.method;

public class App6 {
    public static void main(String[] args){
    App6 app = new App6();
    String word = app.say();
        System.out.println(word);
        int num=app.getNumber();
        System.out.println(num);
    }

    /**
     * 리턴타입 선언부
     * -리턴할 값의 타입을 지정
     * -리턴타입과 실제 리턴하는 값의 자료형을 일치시켜야 한다.
     * -void 리턴값을 제공하지 않는 리턴타입
     * @return
     */
    public String say(){
        System.out.println("say........");
        return "말";
    }
    public int getNumber(){
        return 33;
    }
}
