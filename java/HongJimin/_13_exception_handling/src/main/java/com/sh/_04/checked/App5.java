package com.sh._04.checked;

/**
 * <pre>
 *     예외처리 흐름
 *     1. 예외 던지기 throw new Exception();
 *     2. 예외 제어
 *      a. 예외 처리 try...catch
 *      b. 예외 처리 위임 : 메소드 throws Exception
 *     3. 예외 처리 없이 main 메소드까지 예외가 던져지면 (jvm에게 예외가 던져지면) 프로그램은 비정상으로 돌아가게 됨
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        App5 app = new App5();
        try {
            app.a();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("프로그램 정상 종료...");
    }

    private void a() throws Exception{
        System.out.println("aaaaaaaaaa....");
        b();
        // 1. 던져진 예외를 직접 처리 try...catch
        // 2. 예외 처리 위임 throws Exception
    }

    private void b() throws Exception{
        System.out.println("bbbbbbbbb.....");
        // 1. 던져진 예외를 직접 처리하는 경우 -> 미약할 때 가능
//        try {
//            if (true)
//                throw new Exception("💣💣💣💣💣");
//        } catch (Exception e) {
//
//        }
        // 2. 예외를 호출부로 던지기 - throws Exception 작성
        if(true)
            throw new Exception("💣💣💣💣💣💣💣💣💣💣💣💣");
    }
}
