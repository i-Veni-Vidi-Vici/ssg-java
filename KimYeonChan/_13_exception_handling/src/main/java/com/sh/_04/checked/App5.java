package com.sh._04.checked;

/**
 * <pre>
 *     예외 처리 호출
 *      1. 예외 던지기 throw new Exception()
 *      2. 에외 제어
 *          a. 예외 처리 try..catch
 *          b. 예외 처리 위임: 메소드 throws Exception
 *      3. 예외 처리 없이 main 메소드까지 던져지면 (jvm 에게 예외가 던져지면) 프로그램은 비정상 종료
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        App5 app5 = new App5();
        try {
            app5.a();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("프로그램 정상 종료");
    }

    private void a() throws Exception {
        System.out.println("Aa.");
        // 1. 던져진 예외를 직접 처리 try..catch
        // 2. 예외 처리 위임 throws Exception
        b();
    }

    private void b() throws Exception{
        System.out.println("Bb..");
        // 1. 던진 예외를 직접 처리하는 경우
//        try {
//            if (true)
//                throw new Exception("bomb");
//        } catch (Exception e) {
//            System.out.println("beep");
//        }
        // 2. 예외를 호출부로 던지기
        if (true)
            throw new Exception("bomb");
    }
}
