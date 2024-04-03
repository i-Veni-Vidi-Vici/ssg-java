package com.sh._01.error;

/**
 * <Pre>
 * 에러 (Error)
 * - try..catch등으로 해결할 수 없는 치명적인 오류.
 * - 프로그램을 재시작하거나, 소스코드 수정하는 등 해결해야 한다.
 * - VirtualMachineError, OutOfMemoryError, StackOverflowError 등이 있다.
 * </Pre>
 */
public class App {
    public static void main(String[] args) {
        // OutofMemoryError 유발
//        long[] arr = new long[Integer.MAX_VALUE];

        // StackOverflowError 유발
//        new App().test();

        System.out.println("프로그램 정상 종료...");
    }

    private void test() {
        System.out.println("call test...");
        test(); // 재귀호출
    }
}
