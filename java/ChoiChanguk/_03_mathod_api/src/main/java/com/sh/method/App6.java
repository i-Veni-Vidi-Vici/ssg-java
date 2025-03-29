package com.sh.method;

/**
 * <pre>
 * 리턴값
 * - 리턴시에 값을 전달할 수 있다.
 * - 메소드 선언부에 지정한 타입과 일치하는 값을 작성해야 한다.
 * </pre>
 */
public class App6 {
    public static void main(String[] args) {
        App6 app6=new App6();
        String word;
        int num;

        word=app6.say();
        System.out.println("리턴 받은 단어는 "+word);

        //숫자 33을 반환하는 메소드 getNumber를 작성하고, 리턴값을 출력
        num=app6.getNumber();
        System.out.println("리턴 받은 값은 "+num);

    }

    /**
     * 리턴타입을 지정한다
     * 메소드의 매개변수 타입 = return 타입이 같아야 한다
     * 리턴타입과 실제 리턴하는 값의 자료형을 일치시켜야 한다.
     * void 리턴값을 제공하지 않는 타입
     * @return
     */
    public String say() {
        return "말";
    }

    public int getNumber() {
        return 33;
    }
}
