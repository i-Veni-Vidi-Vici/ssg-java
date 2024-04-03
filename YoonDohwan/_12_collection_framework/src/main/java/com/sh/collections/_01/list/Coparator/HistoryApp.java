package com.sh.collections._01.list.Coparator;

import java.util.Stack;

/**
 * -backwardStack a
 * -current b
 * -forwardStack c
 *
 * 1.특정 url로 이동시 url 은 current에 대입된다.
 * 2.특정 url로 이동시 기존 url은 backwardStack에 쌓이고, url로 이동한다.
 * 3.특정 url로 이동시 forwardStack이 비어있지 않다면 제거한다.
 * 4.뒤로가기를 누르면, 현재 url은 forwardstack에 쌓이고, backwardstack의 url을 current대입한다.
 * 5.앞으로 가기를 누르면, 현재 url은 backwardstack에 쌓이고, forwardstack의 url을 current 대입한다.
 *
 */
public class HistoryApp {
    private Stack<String> backwardStack = new Stack<>();

    private Stack<String> forwardStack = new Stack<>();
    private String current;
    public static void main(String[] args) {
    HistoryApp app = new HistoryApp();
        app.goToUrl("1.naver");
        app.printStatus();
        app.goToUrl("2.youtube");
        app.printStatus();
        app.goToUrl("3.google");
        app.printStatus();
        app.goToUrl("4.instagram");
        app.printStatus();
        app.backward();
        app.printStatus();
        app.forward();
        app.printStatus();
        app.backward();
        app.printStatus();
        app.goToUrl("5.TikTok");
        app.printStatus();
    }
    public void goToUrl(String url){
        //기존 페이지 처리
        if(this.current!=null)
            this.backwardStack.push(this.current);
        this.current=url;
        //앞으로가기
        if(!this.forwardStack.isEmpty())
            this.forwardStack.clear();
    }
    public void backward(){
        if (!this.backwardStack.isEmpty()){
        //기존 url -> 앞으로가기 stack
        this.forwardStack.push(this.current);
        //뒤로가기 stack ->current
        this.current = this.backwardStack.pop();}

    }
    public void forward(){
        if (!this.forwardStack.isEmpty()) {
            this.backwardStack.push(this.current);
            this.current = this.forwardStack.pop();
        }

    }
    public void printStatus(){
        System.out.println("------------");
        System.out.println("뒤로가기 stack : "+backwardStack);
        System.out.println("현재 url : "+ current);
        System.out.println("앞으로가기 stack : "+forwardStack);
        System.out.println("-------------");
    }
}
