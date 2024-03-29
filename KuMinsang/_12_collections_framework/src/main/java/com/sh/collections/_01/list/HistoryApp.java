package com.sh.collections._01.list;

import java.util.Stack;

/**
 * <pre>
 *     -backwordStack
 *     -current
 *     -forwardStack
 *
 *     1. 특정 url로 이동시
 *     2. 특정 url로 이동시
 *     3. 특정 url로 이동시
 *
 * </pre>
 */
public class HistoryApp {
    private Stack<String> backwardStack = new Stack<>();
    private String current;
    private Stack<String> forwardStack = new Stack<>();

    public static void main(String[] args) {
        HistoryApp app = new HistoryApp();
        app.goToUrl("1. naver");
        app.goToUrl("2. youtube");
        app.goToUrl("3. google");
        app.goToUrl("4. yahoo");
        app.printStatus();
        app.backward();
        
        app.printStatus();app.backward();
        app.printStatus();

        app.forward();
        app.printStatus();
    }

    public void goToUrl(String url){
        if(this.current != null)
            this.backwardStack.push(this.current);
        this.current = url;
        if(!this.forwardStack.isEmpty())
            this.backwardStack.clear();
    }

    public void backward(){
        if(!this.backwardStack.isEmpty()) {
            //기존 url -> 앞으로 가기 stack
            this.forwardStack.push(this.current);
            //뒤로가기 stack -> current
            this.current = this.backwardStack.pop();
        }
    }

    public void forward(){
        if(!this.forwardStack.isEmpty()){
            //현재 url -> 뒤로가기  stack
            this.backwardStack.push(this.current);
            //앞으로가기 stack -> current
            this.current=this.forwardStack.pop();
        }

    }
    public void printStatus(){
        System.out.println("~~~~~~~~~~~~~~~~~");
        System.out.println("뒤로가기 stack : " + backwardStack);
        System.out.println("현재 url : " + current);
        System.out.println("앞으로가기 stack : " + forwardStack);
        System.out.println("~~~~~~~~~~~~~~~~~");
    }
}
