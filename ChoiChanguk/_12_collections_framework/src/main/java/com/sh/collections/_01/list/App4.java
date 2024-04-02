package com.sh.collections._01.list;

import java.util.Stack;

/**
 * Stack
 * - 후입선출 Last In First Out 구조의 리스트 객체
 * - 메모리 콜스택, 웹브라우저의 뒤로가기 / 앞으로 가기
 */
public class App4 {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();

        //push로 요소 추가
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("push : "+stack);

        //pop으로 가장 위에 요소 읽기(제거)
        //pop하기전 비어있으면 안됨, 있으면 pop진행
        if(!stack.isEmpty())
            stack.pop();

        System.out.println("pop  : "+stack);

        //peek = 마지막 요소를 읽기만 한다
        System.out.println("peek : "+stack.peek());

        //메모리 콜스택
        // - call 풀스택에 push
        // - return 콜스택에서 pop

        System.out.println("main");
        App4 app4=new App4();
        app4.a();
        app4.c();

    }
    public void a() {
        System.out.println("a");
        this.b();
        this.c();
    }

    private void b() {
        System.out.println("b");
    }

    private void c() {
        System.out.println("c");
    }
}
