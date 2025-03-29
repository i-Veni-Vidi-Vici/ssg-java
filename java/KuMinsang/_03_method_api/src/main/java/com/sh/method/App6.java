package com.sh.method;
/**
 * <pre>
 *  *     리턴값
 *  *     - 리턴시에 값을 전달할 수 있다.
 *  *     - 메소드 선언부에 지정한 타입과 일치하는 값을 작성해야 한다.
 * </pre>
 * */

/**
 * 리턴타입 실습
 */
public class App6 {
    public static void main(String[] args) {
        App6 app = new App6();
        System.out.println(app.say());

        //숫자 33을 반환하는 메소드 getNumber를 작성하고 리턴 값을 출력
        System.out.println(app.getNumber());
    }
    public String say(){
        return "말";
    }

    private int getNumber(){
        return 33;
    }

}
