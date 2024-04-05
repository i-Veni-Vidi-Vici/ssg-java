package com.sh._01.error;

/**
 * <pre>
 * 에러(Error)
 * - try..catch등으로 해결할 수 없는 치명적인 오류
 * - 프로그램을 재시작하거나, 소스코드를 수정하는 등으로 해결해야 한다.
 *  - 안 끄고는 해결이 안된다.
 * - VirtualMachineError, OutOfMemoryError, StackOverflowError등이 있다.
 * - 설치된 JVM의 에러가 있을 수 있다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // OutOfMemoryError 유발
//        long[] arr = new long[Integer.MAX_VALUE]; // java.lang.OutOfMemoryError: Requested array size exceeds VM limit
//         할당된 영역을 초과한다

        // StackOverflowError 유발
//        new App().test();
//        System.out.println("프로그램 정상 종료...");

    }

    private void test() {
        System.out.println("call test...");
        test(); // 재귀호출 test가 test를 호출하고 ...
        // java.lang.StackOverflowError // 해외 유명 개발자 커뮤니티 이름!
        // StackOverflow 말그대로 Stack 공간이 넘쳤다! 이유는 반복적 호출
    }
}
