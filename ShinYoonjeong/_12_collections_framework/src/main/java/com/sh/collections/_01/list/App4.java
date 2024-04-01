package com.sh.collections._01.list;

import java.util.Stack;

/**
 * Stack
 * - 후입선출 Last In First Out LIFO 구조의 리스트 객체
 * - 메모리 콜스택, 웹브라우저의 뒤로 가기/앞으로 가기
 */
public class App4 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // push 요소 추가
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // pop 요소 가져오기(제거)
        //System.out.println(stack.pop());
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
            System.out.println(stack);
        }

        // peek 가장 위의 요소 읽기(제거하지 않음)
        System.out.println(stack);

        // 메모리 콜스택
        // - call 콜스택에 push
        // - return
        System.out.println("main");
        App4 app = new App4();
        app.a();
        app.c();



    }

    private void c() {
        System.out.println("c");
    }

    private void a() {
        System.out.println("a");
        this.b();
        this.c();
    }

    private void b() {
        System.out.println("b");
    }
}
