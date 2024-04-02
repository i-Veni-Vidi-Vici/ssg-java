package com.sh.collections._01.list;

import java.util.Stack;

/**
 *
 */

public class HistoryApp {
    private Stack<String> backwardStack = new Stack<>(); //뒤로가기stack
    private String current; //현재 url
    private Stack<String> forwardStack = new Stack<>(); // 앞으로 가기 stack

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

        app.backward();;
        app.printStatus();
        app.backward();
        app.printStatus();

        app.forward();
        app.printStatus();




    }

    public void goToUrl(String url){
        // 기존페이지
        if(this.current != null)
            this.backwardStack.push(this.current); // current 가 눌이 아니라면 this.current 를
        this.current = url;
        // 앞으로 가기
        if(!this.forwardStack.isEmpty())
            this.forwardStack.clear();

    }

    public void backward() {
        if (! this.backwardStack.isEmpty()) {
            // 기존 url -> 앞으로가기 stack
            this.forwardStack.push(this.current);
            // 뒤로가기 stack -> current 대입
            this.current = this.backwardStack.pop();
        }
    }

    public void forward(){
        if (!this.forwardStack.isEmpty()) {

            // 현재 url -> 뒤로가기 stack 에 담고
            this.backwardStack.push(this.current);

            // 앞으로가기 stack -> current
            this.current = this.forwardStack.pop();
        }

    }

    public void printStatus(){
        System.out.println("-------------");
        System.out.println("뒤로가기 stack + " + backwardStack);
        System.out.println("현재 url : " + current);
        System.out.println("앞으로가기 stack + " + forwardStack);
        System.out.println("-------------");
    }
}
