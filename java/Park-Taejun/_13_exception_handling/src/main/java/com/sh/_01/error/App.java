package com.sh._01.error;

/**
 * 에러(Eroor)
 * - 치명적인 오류. try..catch등으로 해결할 수 없는 치명적인 오류.
 * - 프로그램을 재시작하거나ㅡ 소스코드를 수정하는 등으로 해결해야 한다.
 * - VirtualMachineError, OutOfMemoryError, StackOverflowError 등이 있다.
 */
public class App {
    public static void main(String[] args) {
        // OutOfMemoryError 유발
//        long[] arr = new long[Integer.MAX_VALUE]; //Requested array size exceeds VM limit
//        at com.sh._01.error.App.main(App.java:12)

        // StackOverflowError 유발
        new App().test(); //Exception in thread "main" java.lang.StackOverflowError

        System.out.println("프로그램 정상 종료...");
    }

    private void test() {
        System.out.println("call test ...");
        test(); // 재귀호출
    }
}
