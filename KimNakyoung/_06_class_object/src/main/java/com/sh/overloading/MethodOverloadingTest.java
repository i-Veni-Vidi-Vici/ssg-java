package com.sh.overloading;

/**
 * <pre>
 *
 *  메소드 오버로딩
 *  - 동일한 메소드의 매개변수부를 다르게 작성하는 것.
 *  - 매개변수부는 타입, 순서, 개수가 어떻게든 달라야 한다.
 *  - 매개변수이름, 리턴타입, 접근제한자는 고려하지 않는다.
 *  - ~~동일한 기능인데, 매개변수 타입이 여러가지여야 할 때 유용하다.~~ 이럴때 쓰세요
 *
 * </pre>
 *
 */
public class MethodOverloadingTest {

    /**
     * 메소드 시그니쳐
     * - 접근제한자 리턴타입 메소드명(매개변수명, ...) throws 예외 {}
     */

    public void test() {

    }


    public void test(int i){}

    public void test(int i, int j){}

//    public void test(int m, int n){} // 타입!!!!!!을 보는거지 매개변수명을 안봄!!!!!!!

    public void test(String str){}
    public void test(String str, int i){}
    public void test(int i, String str){} // 매개변수 순서도 구별함!!

    public void test(boolean a){};

//    public String test() {} ; // 리턴타입 고려하지 않는다!!!!

//    private void test(String str) {} // 접근제한자도 안본다!!!!!!!



}
