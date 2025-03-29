package com.sh.collections._01.list.Coparator;

import java.util.Stack;

/**
 * stack
 * 후입선출 last in First out lifo 구조의 리스트 객체
 * 메모리  올스택, 웹브라우저의 뒤로가기.앞으로가기
 *
 */
public class App4 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        //push 요소추가
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        //pop 요소 가져오기
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


        //peek 가장위의 요소 읽기
        System.out.println(stack);

        //메모리 풀스택
        //-call 콜스택에 push
        //-return 콜스택에 pop
        App4 app = new App4();
        app.a();
        app.c();



    }
    private void a(){
        System.out.println("a");
    }
    private void c(){
        System.out.println("c");
    }

}
