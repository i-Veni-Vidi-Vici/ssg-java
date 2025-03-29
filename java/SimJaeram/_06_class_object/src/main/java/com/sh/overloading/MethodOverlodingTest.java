package com.sh.overloading;

/**
 * <pre>
 *     메소드 오버로딩
 *     - 이름이 같은 메소드가 쌓이게 됨
 *     - 동일한 메소드의 매개변수부를 다르게 작성하는 것
 *     - 매개변수부는 타입, 순서, 개수가 어떻게든 달라야 함
 *     - 매개변수이름, 리턴타입, 접근제한자는 고려하지 않음
 *     - 동일한 기능인데, 매개변수 타입이 여러가지 여러가지여야 할 때 유용
 * </pre>
 */

public class MethodOverlodingTest {
    /**
     * 메소드 시그니쳐
     * - 메소드 선언부
     * - 순서는 접근제한자 리턴타입 메소드명 (매개변수,...) throws 예외 {}
     */
    public void test() {}
    public void test(int i) {}
    public void test(int i, int j) {}
    public void test(String str) {}
    public void test(String str, int i) {}
    public void test(int i, String str) {}
    public void test(int i, int j, int k) {}

    // 매개변수 타입과 개수가 같다. 매개변수이름은 고려하지 않는다.
//    public void test(int m, int n) {}
    // 리턴타입은 고려하지 않는다.
//    public String test() {}
    // 접근제한자는 고려하지 않는다.
//     private void test(String str) {}

}
