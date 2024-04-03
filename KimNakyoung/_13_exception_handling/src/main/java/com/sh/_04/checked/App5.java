package com.sh._04.checked;


/**
 *
 * <pre>
 * 예외처리 흐름
 * 1. 예외던지기 throw new Exception();
 * 2. 예외제어
 *      a. try...catch
 *      b. 예외처리 위임 : 메소드 throws Exception 이렇게 써주는거임 이 메소드는 예외를 던집니다~ 경고
 *      위임을 했던 위임을 했던 예외는 잡혀야 합니다.
 *
 * 3. 예외처리 없이 main 메소드까지 예외가 던져지면 (jvm에게 예외가 던져지면) 프로그램은 비정상 종료됨!!
 *
 *
 *
 * </pre>
 *
 */
public class App5 {
    // main 메소드에게 가고 이건 jvm에게 가는거임
    // jvm에게 가면 그냥 .. 모르겠다~ 함. 던져버림
    public static void main(String[] args) throws Exception {
        App5 app = new App5();
        app.a();

        System.out.println("프로그램 정상 종료");
    }


    private void a() throws Exception{
        System.out.println("aaaaaaaaaaaa.......");
        b(); // 호출부로 던졌다..........
        // 1. 던저진 예외를 직접 처리 :  try..catcht
        // 2. 예외처리 위임  throws Exception ( 위임한다~) 그럼 어디로 갈까? a(메소드)를 호출한 쪽으로 넘어간다
    }

    private void b() throws Exception{
        System.out.println("bbbbbbbbbbbbb.........");
        // 1. 던져진 예외를 직접 처리하는 경우 (미약하다면)
//        try {
//            if(true) // 항상 예외가 던져짐 폭발물 처리해줘~~ // 예외 발생시실을 알려주고 싶다면
//            {
//                throw new Exception("😀😀😀😀"); // 반드시 예외처리 checked 라서 예외처리 안해주면 에러남
//            }
//        } catch (Exception e) {
//
//        }
        // 2. 예외를 호출부로 던지기
        if(true)
            throw  new Exception("😀😀😀😀😀😀😀"); // 메소드 옆에  throws 해줌. 어디로 던졌을까?


    }
}
