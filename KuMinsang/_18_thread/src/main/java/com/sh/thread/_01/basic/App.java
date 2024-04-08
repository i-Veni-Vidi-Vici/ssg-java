package com.sh.thread._01.basic;

/**
 * 싱글 쓰레드 구현
 */
public class App {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        App app = new App();
        app.print('+');
        app.print('-');
    }
    public void print(char ch){
        for(int i = 0; i < 100; i++){
            System.out.print(ch);
        }
    }
}
