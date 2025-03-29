package com.sh._01.error;

/**
 * <pre>
 * 에러(Error)
 *  - try..catch등으로 해결할 수 없는 치명적인 오류
 *  - 프로그램을 재시작하거나, 소스코드를 수정하는 등으로 해결해야 한다.
 *  - 대표적으로 VirtualMachineError, OutOfMemoryError, StackOverflowError등이 있다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // OutOfMemoryError 유발
//        long[] arr = new long[Integer.MAX_VALUE]; // java.lang.OutOfMemoryError: Requested array size exceeds VM limit

        // StackOverflowError 유발(Stack이 넘쳤다
//        new App().test();  // 메소드 호출 // java.lang.StackOverflowError

        System.out.println("프로그램 정상 종료.");
    }

    private void test() {
        System.out.println("call test..");  // 테스트 메소드 호출
        test(); // 재귀호출
    }
}
