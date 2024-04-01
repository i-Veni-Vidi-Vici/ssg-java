package com.sh._01.error;

/**
 * <pre>
 * 에러(Error)
 * - try..catch등으로 해결할 수 없는 치명적인 오류.
 * - 프로그램을 재시작하거나, 소스코드를 수정하는 등 해결해야 한다.
 * - VirtualMachineError, OutOfMemoryError, StackOverflowError ...
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // OutOfMemoryError 유발
//        long[] arr = new long[Integer.MAX_VALUE]; //java.lang.OutOfMemoryError: Requested array size exceeds VM limit

        // StackOverflowError 유발
//        new App().test(); // java.lang.StackOverflowError


        System.out.println("프로그램 정상 종료...");
    }

    private void test() {
        System.out.println("call test...");
        test(); // 재귀호출
    }

}
