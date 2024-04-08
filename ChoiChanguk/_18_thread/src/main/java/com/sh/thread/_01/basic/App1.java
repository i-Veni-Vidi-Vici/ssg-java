package com.sh.thread._01.basic;

/**
 * 싱글쓰레드 앱 구현
 */
public class App1 {
    public static void main(String[] args) {
        //main이 출력 = 메인이 아래 메소드를 다 실행한다
        System.out.println(Thread.currentThread().getName());
        App1 app=new App1();
        app.print('+');
        app.print('-');


    }
    public void print(char ch) {
        for (int i=0;i<100;i++)
        {
            System.out.print(ch);
        }
    }
}
