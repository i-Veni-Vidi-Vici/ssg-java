package com.sh.overloading;

/**
 * <pre>
 *  메소드 오버로딩
 *  - 동일한 이름을 가지고 있는 메소드를 매개변수부를 다르게 작성하는 것.
 *  - 매개변수 부는 타입, 순서, 개수가 어떻게든 달라야 함.
 *  - 매개변수 이름과 Return값, 접근 제한자는 고려하지 않는다.
 *  - 동일한 기능인데, 매개변수 타입이 여러가지여야 할 때 유용하다.
 *
 * </pre>
 */
public class MethodOverloadingTest
{
    /**
     * 메소드 시그니쳐
     * - 접근 제한자, 리턴 타입, 메소드명(매개변수 명) thorws , 예외{}
     */

    public void test(){}

    public void test(int i) {}
    public void test(int i, int j) {}
    public void test(String s){}
    public void test(String s, int n ){}
    public void test(int n, String s){}
    public void test(double d){}
//    public void test(int m, int n){} // 매개변수부의 매개변수 명은 고려하지 않는다 타입이 달라야 오버라이딩 가능
//    public String test(){} //리턴 타입은 고려하지 않는다.
//    private void test(){} // 접근 제한자도 고려하지 않는다.
}
