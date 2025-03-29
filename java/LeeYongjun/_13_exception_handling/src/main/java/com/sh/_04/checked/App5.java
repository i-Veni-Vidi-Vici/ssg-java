package com.sh._04.checked;

/**
 * <pre>
 * 예외처리 흐름
 * 1. 예외던지기 throw new Exception();
 * 2. 예외제어
 *  a. 예외처리 try..catch
 *  b. 예외처리 위임 : 메소드 throws Exception
 *  3. 예외처리 없이 main메소드까지 예외가 던져지면(jvm에게 예외가 던져지면) 프로그램은 비정상 종료된다.
 * </pre>
 */
public class App5 {
    public static void main(String[] args)  {
        App5 app = new App5();
        try {
            app.a();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("프로그램 정상 종료...");
    }

    private void a() throws Exception {
        System.out.println("aaaaaaaa..a.a.a.a.a.");
        b();
    }

    private void b() throws Exception {
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbb.b.b.b.");
        // 1. 던져진 예외를 직접 처리하는 경우
        if(true)
            try {
                throw new Exception("🚗🚗🚗🚗🚗🚗🚗🚗");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        // 2. 예외를 호출부로 던지기
        if(true)
                throw new Exception("🚗🚗🚗🚗🚗🚗🚗🚗");

    }
}
