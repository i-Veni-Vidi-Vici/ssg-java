package com.sh.collections._01.list;

import java.util.Stack;

/**
 * <pre>
 * Stack
 * - 후입선출 LIFO(Last In First Out) 구조의 리스트 객체
 * - 메모리 콜스택, 웹브라우저의 뒤로가기/앞으로가기
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // 요소 추가 : push
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // 가장 위의 요소 읽기(제거X) : peek
        System.out.println("peek: " + stack.peek()); // 5

        // 요소 가져오기(제거) : pop
        // 요소수를 넘어서 가져오려고 하면 EmptyStackException
//        System.out.println(stack.pop()); // 5

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
            System.out.println(stack);
        }

        // 메모리 콜스택
        // - call : 콜스택에 push
        // - return : 콜스택에서 pop
        System.out.println("main");
        App4 app = new App4();
        app.a();
        app.c();
    }

    private void a() {
        System.out.println("a");
        b();
        c();
    }
    private void b() {
        System.out.println("b");
    }
    private void c() {
        System.out.println("c");
    }
}
