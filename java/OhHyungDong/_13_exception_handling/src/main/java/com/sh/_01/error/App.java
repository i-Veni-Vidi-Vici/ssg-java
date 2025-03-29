package com.sh._01.error;

/**
 * <pre>
 *  Error
 *   - try.. catch등으로 해결할 수 없는 치명적인 오류
 *   - 프로그램을 재시작하거나, 소스코드 수정하는 등 해결해야 한다.
 *   - VirtualMachineError, OutOfMemoryError, StackOverflowError등이 있다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //OutOfMemoryError 유발
        //long[] arr = new long[Integer.MAX_VALUE]; //java.lang.OutOfMemoryError: Requested array size exceeds VM limit

        //StackOverflowError 유발
        new App().test();

        System.out.println("프로그램 정상종료 ");
    }

    private void test(){
        System.out.println("call test..."); //java.lang.StackOverflowError-> call Stack으로 저장한 저장공간이 넘쳤을 때 StackOverflow현상이 발생
        test();// 재귀호출
    }
}
