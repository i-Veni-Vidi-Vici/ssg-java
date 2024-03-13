package com.sh.method;

/**
 * 리턴
 * 호출된 메소드의 실행이 완료되면, 호출부로 돌아가는 것을 의미함
 * 모든 호출된 메소드는 리턴한다
 *모든 메소드 마지막엔 return이 작성되어야하고 이를 생략하더라도 컴파일러가 실행
 *
 *
 *
 *
 *
 * \
 * 리턴값
 * 리턴시에 값을 전달할 수 있다.
 * 메소드 선언부에 지정한 타입과 일치하는 값을 작성해야 한다.
 */
public class App5 {
    public static void main(String[] args){
        App5 app = new App5();
        app.a();
        System.out.println("main");


    }
    public void a(){

        System.out.println("a");
        b();
        return;// aㅁ

    }
    public void b(){
        System.out.println("b");
    }
}
