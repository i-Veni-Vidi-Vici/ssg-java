package com.sh.method;

/**
 * <pre>
 * 리턴값
 * - 리턴시에 값을 전달할 수 있다.
 * - 메소드 선언부에 지정한 타입과 일치하는 값을 작성하고, 불일치시 명시적으로 값을 작성해야 한다.
 * </pre>
 */

public class App6 {
    public static void main(String[] args) {
        App6 app = new App6();
        String word = app.say(); // 출력문까지 word에 들어간다?
        System.out.println();
        System.out.println(word); // 주석처리해도 출력문이 나온다.
        System.out.println();

        // 숫자 33을 반환하는 메소드 getNumber를 작성하고, 리턴값을 출력
        int num = app.getNumber();
        System.out.println();
        System.out.println(num);
    }

    /**
     * 리턴타입 선언부
     * - 리턴할 값의 타입을 지정
     * - 리턴타입과 실제 리턴하는 값의 자료형을 일치시켜야 한다.
     *
     * - void 리턴값을 제공하지 않는 리턴타입
     */
    public String say() {
        //Cannot return a value from a method with "void" result type.
        System.out.println("say......");
        return "말";
    }

    public int getNumber() {
        System.out.println("wow");
        return 33;
    }
}
