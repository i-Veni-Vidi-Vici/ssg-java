package com.sh.method;

public class App6 {
    public static void main(String[] args){
        App6 app = new App6();
        String word = app.say();
        System.out.println(word);
        System.out.println();
        // 숫자 33을 반환하는 메소드 getNumber를 작성하고, 리턴값을 출력
        int number = app.getNumber();
        System.out.println("number.......\t" + number);
    }

    public int getNumber(){
        return 33;
    }

    /**
     * 리턴타입 선언부
     * - 리턴할 값의 타입을 지정
     * - 리턴 타입과 실제 리턴하는 값의 자료형을 일치시켜야한다.
     *
     * - void 리턴값을 제공하지 않는 리턴타입
     */

    public String say(){
        System.out.print("say......\t");
        return "말";
    }

}
