package com.sh._04.checked;

public class App5 {
    public static void main (String[] args) {
        App5 app = new App5();
        try {
            app.a();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void a() throws Exception{
        System.out.println("aaaaaaaaaa");
        b();
        // 1. 던져진 예외를 직접 처리 try..catch
        // 2. 예외처리 위임 throws Exception
    }

    public void b() throws Exception{
        System.out.println("bbbbbbbbbbb");
        // 1, 던져진 예외를 직접 처리하는 경우
//        try {
//            if (true)
//                throw new Exception("exception");
//        } catch (Exception e) {
//
//        }
        // 2. 예외를 호출부로 던지기 - throws Exception 작성
        if (true)
            throw new Exception("exception");
    }
}
