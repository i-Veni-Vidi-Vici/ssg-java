package com.sh._01.error;

/**
 *
 * <pre>
 * 에러(error)
 * - try .. catch 등으로 해결할 수없는 치명적인 오류.
 * - 프로그램을 재시작하거나, 소스코드 수정하는 등 해결 (안 끄고 해결 못함)
 * - VirtualMachineError( jvm 이슈 가능성 높) , OutOfMemoryError, stackOverFlowError등이 있다.
 *
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        //  OutOfMemoryError
//        long[] arr = new long[Integer.MAX_VALUE];
//        System.out.println("프로그램 정상 종료...");

        //StackOVerflowError 유발
        new App().test(); // java.lang.StackOVerflowError

    }

    private void test() {
        System.out.println("Call test...");
        test(); // 재귀호출
    }
}
