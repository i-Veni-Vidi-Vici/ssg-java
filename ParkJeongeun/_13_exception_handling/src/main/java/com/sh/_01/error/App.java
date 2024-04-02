package com.sh._01.error;

/**
 * <pre>
 * 에러(Error)
 * - 치명적인 오류
 * - try..catch 등으로 해결할 수 없음
 * - 프로그램을 재시작하거나, 소스코드를 수정하는 등의 방식으로 해결해야 함
 * - VirtualMachineError, OutOfMemoryError, StackOverflowError 등
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // OutOfMemoryError 유발
        long[] arr = new long[Integer.MAX_VALUE]; // Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit

        // StackOverflowError 유발
        new App().test();

        System.out.println("프로그램 정상 종료");
    }

    private void test() {
        System.out.println("call test");
        test(); // 재귀호출
    }
}
