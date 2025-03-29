package com.sh.method;

/**
 * <pre>
 *
 *  리턴값
 *- 리턴시에 값을 전달할 수 있다.
 *  - 메소드 선언부에 지정한 타입과 일치하는 값을 작성해야 한다.
 * </pre>
 */
public class App6 {
    public static void main(String[] args) {
        App6 app = new App6();
        String word = app.say();
        System.out.println(word);

        // 숫자 (int) 33을 반환하는 메소드 getNumber를 작성하고, 리턴값을 출력
        int num = app.getNumber();
        System.out.println(num);

    }

    /**
     * 리턴타입 선언부
     * - 리턴할 값의 타입을 지정
     * - 리턴타입과 실제 리턴하는 값의 자료형을 일치시켜야 한다.
     *
     * - void (비었다) 리턴값을 제공하는 않는 리턴타입
     * @return
     */
    public String say() {
        System.out.println("say......................");
        return "말"; // public void 메소드 say() 로 써놓고 왜 값을 return 하니?
        // String이라고 했는데 return값 안 주면 안됨
    }

    public int getNumber() {
        System.out.println("getNumber.................");
        return 33;
    }
}
