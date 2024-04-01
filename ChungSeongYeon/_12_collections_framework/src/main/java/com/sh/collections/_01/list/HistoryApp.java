package com.sh.collections._01.list;

import java.util.Stack;

/**
 * <pre>
 * - backwardStack
 * - cureent a
 * - forwardStack c , b
 *
 * 1. 특정 url로 이동시 url은 current에 대입된다.
 * 2. 특정 url로 이동시 기존 url은 backwardStack에 쌓이고, url로 이동한다.
 * 3. 특정 url로 이동시 forwardStack이 비어있지 않다면, 제거한다.
 * 4. 뒤로가기를 누르면, 현재 url은 forwardStack에 쌓이고(push), backwardStack의 url을 current에 대입한다.
 * 5. 앞으로 가기를 누르면, 현재 url은 backwardStack에 쌓이고, forwardStack의 url을 current에 대입한다.
 * </pre>
 */

public class HistoryApp {
    private Stack<String> backwardStack = new Stack<>(); // 뒤로가기 stack
    private String current; // 현재 url
    private Stack<String> forwardStack = new Stack<>(); // 앞으로가기 stack

    public static void main(String[] args) {
        HistoryApp app = new HistoryApp();
        app.goToUrl("1. naver");
        app.printStatus();
        app.goToUrl("2. youtube");
        app.printStatus();
        app.goToUrl("3. google");
        app.printStatus();
        app.goToUrl("4. instagram");
        app.printStatus();

        app.backward(); // 뒤로가기를 하게 되면 현재 url은 앞으로가기로, 뒤로가기에서는 현재url로
        app.printStatus();
        app.backward();
        app.printStatus();

        app.forward();
        app.printStatus();

        app.goToUrl("5. tiktok");
        app.printStatus();
    }

    public void goToUrl(String url){ // 특정 url로 향하는 메소드
        // 기존페이지가 있었다면 backwardStack에 this.current를 push해줘야함.
        if(this.current != null)
            this.backwardStack.push(this.current);
        this.current = url; // 현재 url이 넘어온 url
        // 앞으로 가기 스택이 있었다면 날려줘야 함.
        if(!this.forwardStack.isEmpty())
            this.forwardStack.clear();
    }

    public void backward(){
        if(!this.backwardStack.isEmpty()) {

            // 기존 url -< 앞으로 가기 stack
            this.forwardStack.push(this.current);

            // 뒤로가기 stack -> current
            this.current = this.backwardStack.pop();  // 이 모든 건 backwardStack이 있어야 됌. 그래서 if(backward 안비어있다고) 안에 넣어줘야 함

        }
    }
    public void forward(){
        if(!this.forwardStack.isEmpty()){
            // 현재 url -> 뒤로가기 stack
            this.backwardStack.push(this.current);
            // 앞으로 가기 stack -> current
            this.current = this.forwardStack.pop();
        }
    }

    public void printStatus(){
        System.out.println("-------------------");
        System.out.println("뒤로가기 stack : " + backwardStack);
        System.out.println("현재 url : " + current);
        System.out.println("앞으로가기 stack : " + forwardStack);
        System.out.println("-------------------");
    }
}
