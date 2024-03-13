package com.sh.method;

/**
 * 리턴값
 * - 리턴시에 값을 전달할 수 있다.
 * - 메소드 선운부에 지정한 타입과 일치하는 값을 작성해야 한다.
 */
public class App6 {
    public static void main(String[] args) {
        App6 app = new App6();
        String word = app.say();
        System.out.println(word);

        // 숫자 33을 반환하는 메소드 getNumber 를 작성하고, 리턴값을 출력
        int num = app.getNumber();
        System.out.println(num);
    }

    public String say() {
        System.out.println("say...");
        return "말";
    }

    public int getNumber() {
        return 33;
    }
}
