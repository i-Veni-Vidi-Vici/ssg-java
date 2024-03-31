package com.sh.collections._01.list;

import java.util.Stack;

/**
 * <pre>
 * - backwardStack
 * - current
 * - forwardStack
 *
 * 1. 특정 url로 이동시 url은 current에 대입됨
 * 2. 특정 url로 이동시 기존 url은 backwardStack에 쌓이고, url로 이동
 * 3. 특정 url로 이동시 forwardStack이 비어있지않다면, 제거함 (앞으로가기에 무언가가 남아있는데 새로운 url 입력시 앞으로가기에 있던게 사라짐)
 * 4. 뒤로가기를 누르면 현재 url은 forwardStack에 쌓이고, backwardStack의 url을 current에 대입
 * 5. 앞으로가기를 누르면 현재 url은 backwardStack에 쌓이고, forwardStack의 url을 current에 대입
 * </pre>
 */
public class HistoryApp {
    private Stack<String> backwardStack = new Stack<>(); // 뒤로가기 스택
    private String current; // 현재 url
    private Stack<String> forwardStack = new Stack<>(); // 앞으로가기 스택

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

        app.backward();
        app.printStatus();
        app.backward();
        app.printStatus();

        app.forward();
        app.printStatus();

        app.goToUrl("5. tiktok");
        app.printStatus();
    }
    public void goToUrl(String url){
        // 기존페이지
        if (this.current != null){
            this.backwardStack.push(this.current);
        }
        this.current = url;
        // 앞으로가기
        if (!this.forwardStack.isEmpty()){
            this.forwardStack.clear();
        }
    }
    public void backward(){
        if (!this.backwardStack.isEmpty()) {
            // 기존 url -> 앞으로가기 stack
            this.forwardStack.push(this.current);
            // 뒤로가기 stack -> current
            this.current = this.backwardStack.pop();
        }
    }
    public void forward(){
        if (!this.forwardStack.isEmpty()) {
            // 현재 url -> 뒤로가기 stack
            this.backwardStack.push(this.current);
            // 앞으로가기 stack -> current
            this.current = this.forwardStack.pop();
        }
    }
    public void printStatus(){
        System.out.println("----------------------------------");
        System.out.println("뒤로가기 stack : " + backwardStack);
        System.out.println("현재 url : " + current);
        System.out.println("앞으로가기 stack : " + forwardStack);
        System.out.println("----------------------------------");
    }
}
