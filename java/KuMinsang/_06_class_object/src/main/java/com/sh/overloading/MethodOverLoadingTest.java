package com.sh.overloading;

/**
 * <pre>
 *     메소드 오버로딩
 *     - 동일한 메소드의 매개변수부를 다르게 작성하는 것.
 *     - 매개변수부는 타입, 순서, 개수가 어떻게든 달라야 한다
 *     - 매개변수 이름, 리턴타입, 접근제한자는 고려하지 않는다
 *     - 동일한 기능인데 매개변수 타입이 여러가여야 할때 유용하다
 * </pre>
 */


public class MethodOverLoadingTest {
    /**
     * 메소드 시그니쳐
     * 메소드 첫 줄을 메소드 시그니쳐라고 부른다
     * - 접근제한자 리턴타입 메소드명(매개변수, ...)throws 예외{}
     */
    public void test(){

    }
    public void test(int i){
    }
    public void test(int i, int j){
    }
    public void test(String string){
    }
    public void test(int i, String str){
    }
    public int test(int i, int j, int k){
        return i+j+k;
    }
    //private void test(String string){}    //위반

}
