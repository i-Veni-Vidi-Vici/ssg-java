package com.sh.collections._01.list;

import java.util.Stack;

/**
 * <pre>
 *  Statck
 *  - 후입 선출 구조의 리스트 객체
 *  - 메모리 콜스택, 웹브라우져의 뒤로가기 / 앞으로 가기
 * </pre>
 *
 */
public class App4 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        //push 요소 추가
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        //pop 요소 가져오기(제거)
//        System.out.println(stack.pop());
//        while(!stack.isEmpty())
//        {   stack.pop();
//            System.out.println(stack);
//        }
        //peek 가장 위의 요소 읽기 (제거하지 않음)
        System.out.println(stack.peek());

        //메모리 콜스택
        // -call 콜스택에 push
        // -return 콜스택에서 pop
        System.out.println("main");
        App4 app = new App4();
        app.a();
        app.c();
    }

    private void a(){
        System.out.println("A");
        this.b();
        this.c();
    }

    private void c(){
        System.out.println("C");
    }
    private void b(){
        System.out.println("B");
    }

}
