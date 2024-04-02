package com.sh.collections._01.list;

import java.util.Stack;

/**
 * <pre>
 *  - backwardStack
 *  - current
 *  - forwardStack
 *
 * - 요구사항 -
 *  1. 특정 url로 이동시 url은 current에 대입된다.
 *  2. 특정 url로 이동시 기존 url은 backwardSTACK에 쌓이고, url로 이동한다.
 *  3. 특정 url로 이동시 forwardStack이 비어있지 않다면, 제거한다.
 *  4. 뒤조 가기를 누르면, 현재 url은 forwardStack에 쌓이고, backwardStack의 url을 current에 대입한다.
 *  5. 앞으로 가기를 누르면, 현재 url은 backwardStack에 쌓이고, forwardStack에 있는 url을 current에 대입한다.
 * </pre>
 */
public class HistoryApp
{
    private Stack<String> backwardStack = new Stack<>(); //뒤로
    private String current;
    private Stack<String> forwardStack = new Stack<>(); //앞으로

    public static void main(String[] args) {
        HistoryApp app = new HistoryApp();
        app.goToUrl("1. Naver");
        app.printStatus();
        app.goToUrl("2. Youtube");
        app.printStatus();
        app.goToUrl("3. Google");
        app.printStatus();
        app.goToUrl("4. Instagram");
        app.printStatus();

        app.backward();
        app.printStatus();
        app.backward();
        app.printStatus();
        app.forward();
        app.printStatus();

        app.goToUrl("5.Tiktok");
        app.printStatus();
    }

    public void goToUrl(String url){
        //기존 페이지
        if(this.current != null){
            this.backwardStack.push(this.current);
        }
        this.current = url;
        //앞으로 가기
        if(!this.forwardStack.isEmpty()){
            this.forwardStack.clear();
        }
    }

    public void backward(){
        //기존 url -> 앞으로 가기 stack  현재 -> 뒤로 가기 했을 때 -> 현재 사이트를 forwardStack으로 넣고, backward에 저장되어 있는 페이지지를 현재 페이지에 넣기
        if(!this.backwardStack.isEmpty()){
            forwardStack.push(this.current);
            //뒤로 가기 stack -> current
            this.current = this.backwardStack.pop();
        }
    }

    public void forward(){
        if(!this.forwardStack.isEmpty()){
            // 현재 url -> 뒤로 가기 stack
            this.backwardStack.push(this.current);
            // 앞으로 가기 stack -> current
            this.current = this.forwardStack.pop();
        }
    }

    public void printStatus(){
        System.out.println("--------------");
        System.out.println("뒤로 가기 stack : " + backwardStack);
        System.out.println("현재 URL : " + current);
        System.out.println("앞으로 가기 stack : " + forwardStack);
        System.out.println("--------------");
    }
}
