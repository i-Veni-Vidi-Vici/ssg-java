package com.sh._04.checked;

/**
 * <pre>
 *     예외처리 호출
 *     1. 예외던지기 throw new Exception();
 *     2. 예외제어
 *      a. 예외처리 try..catch
 *      b. 예외처리 위임: 메소드 throws Exception
 *     3. 예외처리 없이 main 메소드까지 예외가 던져지면 (jvm에게 예외가 던져지면) 프로그램은 비정상 종료된다
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        App5 app = new App5();
        app.a();

        System.out.println("프로그램 정상 종료...");
    }
    private void a(){
        System.out.println("aaaaaaaa....");
        b();
    }
    private void b(){
        System.out.println("bbbbbbbbbb....");
    }
}
