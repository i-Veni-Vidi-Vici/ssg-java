package com.sh._01.error;

import java.util.List;

/**
 * 에러(Error)
 * - try..catch등으로 해결할 수 없는 치명적인 오류.
 * - 프로그램을 재시작하거나 소스코드 수정하는 등올 해결해야 한다
 * - VirualMachineError, OutOfMemoryError, StackOverFlowError등이 있다.
 */
public class App1 {
    public static void main(String[] args) {
        // OutOfMemoryError 유발
        //long[] arr=new long[Integer.MAX_VALUE];
        //java.lang.OutOfMemoryError : Requested array size exceeds VM limit

        // StackOverFlowError 유발
        new App1().test();//일회용 메소드

        System.out.println("프로그램 정상 종료");
    }

    private void test() {
        System.out.println("call test....");
        test();//재귀호출
    }

}
