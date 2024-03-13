package com.sh.method;

/**
 * <pre>
 *
 * 리턴값
 * - 리턴시에 값을 전달할 수 있다.
 * - 메소드 선언부에 지정한 타입과 일치하는 값을 작성해야 한다.
 *
 * </pre>
 *
 */
public class App6 {
    public static void main(String[] args) {
        App6 app = new App6();
        String word = app.say();
        System.out.println(word);   // 이 줄을 주석으로 처리해도 실행됨

        // 숫자 33을 반환하는 메소드 getNumber를 작성하고, 리턴값을 출력
        int n = app.getNumber();
        System.out.println(n);
    }

    /**
     * 리턴타입 선언부
     * - 리턴할 값의 타입을 지정
     * - 리턴타입과 실제 리턴하는 값의 자료형을 일치시켜야 한다.
     *
     * - void 리턴값을 제공하지 않는 리턴타입
     * @return
     */
    public String say() {
        System.out.println("say.......");
        return "말"; // 리턴은 항상 마지막에 반환하도록 작성, void가 아니기 때문에 리턴값이 없으면 오류
    }

    public int getNumber() {
        return 33;
    }
}
