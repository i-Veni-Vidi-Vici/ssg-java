package com.sh.collections._01.list;

import java.util.Stack;

/**
 * Stack
 *  - 후입선출 last In First Out LIFO 구조의 리스트 객체
 *  - 메모리 콜스택, 웹브라우저의 뒤로가기/앞으로가기
 */
public class App4 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // push : 요소 추가
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // peek : 가장 위의 요소 읽기(제거하지 않음) -> 가져왔지만 제거하지 않음
        System.out.println("peek : " + stack.peek());

        // pop : 요소 가져오기(제거) -> 가져오면서 제거하는 것, 출력해서 이해하기
        System.out.println(stack.pop());
        while(!stack.isEmpty()) {  // 스텍이 비어있지 않다면 반복문 사용
            System.out.println(stack.pop());
        }

        // 메모리 콜스텍
        // call 콜스택에 push되는 것
        // return 콜스택에서 pop되는 것
        System.out.println("main");
        App4 app = new App4();
        app.a();
        app.c();


    }

    private void a() {
        System.out.println("a");
        b(); // a안에서 b호출 사실, this.b();인데 this가 생략된 것이다.
        this.c(); // b();와 같은 의미이다.
    }

    private void c() {
        System.out.println("c");
    }

    private void b() {
        System.out.println("b");
    }
}
