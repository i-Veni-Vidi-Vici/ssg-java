package com.sh.thread._01.basic;

/**
 * <pre>
 *     ### 싱글 쓰레드 앱 구현
 *      - 현재 쓰레드 출력
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //현재 쓰레드
        System.out.println(Thread.currentThread().getName()); //main
        App app = new App();
        app.print('+');
        app.print('-');
    }

    public void print(char ch) {
        for (int i = 0; i < 100; i++) {
            System.out.print(ch);
        }
    }
}
