package com.sh._04.checked;

/**
 * <pre>
 * 예외처리 흐름
 * 1. 예외던지기 throw new Exception();
 * 2. 예외제어
 *  - 예외처리 바로 한다
 *  - 예외처리 위임 -> 떠넘기기 느낌이다 : 매소드 throws Exception
 * 3. 예외처리 없이  main메소드 까지 예외가 던져지면(jvm에게 예외가 던져지면)프로그램은 비정상 종료
 * </pre>
 */

public class App5 {
    public static void main(String[] args) {
        App5 app5=new App5();
        try {
            app5.a();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("프로그램 정상 종료");


    }

    private void a() throws Exception{
        System.out.println("aaaaaaaaaaaa");
        b();
        //1. 던져진 예외를 직접 처리 하던지try~catch 하던지
        //2. 예외처리 위임 throws Exception

        //private void a() throws Exception 이 뜻은 b에서 받은 예외를 나를 호출한 애한테 던진다
        // 만약 main에서도 throws Excepiton을 한다면 자바 jvm한테 던지는거다
    }

    private void b() throws Exception {
        System.out.println("bbbbbbbbbbbbbb");
//        if(true)
//        {
//            try // 이건 던져진 예외를 직접처리하는 경우
//            {
//                throw new Exception("폭탄폭탄폭탄폭탄폭탄폭탄폭탄");// checked 예외 무조검 try, catch 해야됨
//                //runtimeError 이면 빨간줄 안뜸
//            }
//            catch (Exception e)
//            {
//                //예외는 던저졌다 그러나 예외처리가 되었다
//                //하지만 a는 예외인지 모른다
//            }
//
//
//        }


        if(true)//예외를 던져버린다
        {
            throw new Exception("폭탄폭탄폭탄폭탄폭탄폭탄폭탄");
        }
    }
}
