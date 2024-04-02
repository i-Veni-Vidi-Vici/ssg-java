package com.sh.collections._01.list;

import java.util.Stack;

/**
 * Stack
 * - 후입선출 Last In First Out LIFO 구조의 리스트 객체
 * - 메모리 콜스택, 웹브라우저의 뒤로가기 / 앞으로가기
 */
public class App4 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

//        System.out.println(stack. pop());
//        System.out.println(stack. pop());
//        System.out.println(stack. pop());
//        System.out.println(stack. pop());

        System.out.println("peek : " + stack.peek());

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
            System.out.println(stack);
        }


        // 마지막에 들어간 놈이 5 이므로

        // 메모리 콜스택
        System.out.println("main");
        App4 app = new App4();
        app.a();
        app.c();

    }

    private void a(){
        System.out.println("a");
        this.b();
        this.c();
    }

    private void b(){
        System.out.println("b");
    }

    private void c(){
        System.out.println("c");
    }
}
