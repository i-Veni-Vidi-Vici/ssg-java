package com.sh._04.checked;

/**
 * 예외처리 흐름
 * 1. 예외던지기 throw new Exception();
 * 2. 예외제어
 * - 예외처리 try-catch
 * - 예외처리 위임 : 메소드 throws Exception
 * 3. 예외처리 없이 main메소드까지 예외가 던져지면 (jvm에게 예외가 던져지면) 프로그램은 비정상 종료됨
 *
 */
public class App5 {
    public static void main(String[] args){
        App5 app = new App5();
        // main에서까지 메소드에서 예외처리 위임하면 프로그램 비정상 종료 -> try-catch
        try {
            app.a();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("프로그램 정상 종료");
}

    private void a() throws Exception{
        System.out.println("aaaaaaaaaaa");
        b();
        // 1. 던져진 예외를 직접 처리 try-catch
        // 2. 예외처리 위임 throws Exception - 여기서는 이거 채택
    }

    private void b() throws Exception {
        System.out.println("bbbbbbbbbbb");
        // 1. 던져진 예외를 직접 처리 (메소드 선언부에 throws 작성X)
//        try {
//            if(true)
//                throw new Exception("🎇🎇🎇");
//        } catch (Exception e){
//
//        }

        // 2. 예외를 호출부로 던지기 -> 호출부에서 처리
        if(true)
            throw new Exception("🎇🎇🎇");

    }
}
