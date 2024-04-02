package com.sh._01.error;
/**
 * <pre>
 * 에러(Error)
 * - 치명적인 오류. try..catch등으로 해결할 수 없는 치명적인 오류.
 * - 프로그램을 재시작하거나, 소스 코드 수정하는 등 해결해야 한다.
 * - VirtualMachinError. OutOfMemoryError, StackPverFlowError 등이 있다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // OutOfMemoryError 유발
        //long[] arr = new long[Integer.MAX_VALUE];
        //

        // StackOverFlowError 유발
        new App().test();


        System.out.println("프로그램 정상 종료");

    }

    private void test() {
        System.out.println("call test");
        test();
    }
}