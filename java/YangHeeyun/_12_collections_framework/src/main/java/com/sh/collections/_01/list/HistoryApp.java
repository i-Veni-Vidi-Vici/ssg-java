package com.sh.collections._01.list;

import java.util.Stack;

/**
 * <pre>
 * backwardStack
 * currnet a -> b
 * forwardStack
 *
 * 1.특정 url로 이동시 url은 current에 대입된다.
 * 2.특정 url로 이동시 기존 url은 backwarStack에 쌓이고, url로 이동한다.
 * 3.특정 url로 이동시 forwardStack이 비어이지 않다면, 제거한다.
 * 4.뒤로가기를 누르면, 현재 url은 forwardStack에 쌓이고, backwardStack url을 currnet대입
 * 5.앞으로 가기를 누르면, 현재 url은 backwardStack에 쌓이고, forwardStack url을 currnet대입
 *
 * </pre>
 */
public class HistoryApp {
    private Stack<String> backwardStack = new Stack<>(); // 뒤로가기 stack
    private String current; // 현재 url
    private Stack<String> forwardStack = new Stack<>(); // 앞으로 가기 stack

    public static void main(String[] args) {
        HistoryApp app = new HistoryApp();
        app.goToUrl("1.naver");
        app.goToUrl("2. youtube");
        app.goToUrl("3. google");
        app.goToUrl("4. instagram");

        app.backward();
        app.printStatus();
        app.backward();
        app.printStatus();

        app.forward();
        app.printStatus();

        app.goToUrl("5. tiktok");
        app.printStatus();
    }

    private void printStatus() {
        System.out.println("-----------");
        System.out.println("뒤로가기 stack : " + backwardStack);
        System.out.println("현재 url : " + current);
        System.out.println("앞으로가기 stack : " + forwardStack);
    }

    public void goToUrl(String url) {
        //기존페이지
        if (this.current != null)
            this.backwardStack.push(this.current);
        this.current = url;
        // 앞으로 가기
        if (!this.forwardStack.isEmpty()) {
            this.forwardStack.clear();
        }
    }

    public void backward() {
        if (!this.backwardStack.isEmpty()) {
            // 기존 url -> 앞으로가기 stack
            this.forwardStack.push(this.current);
            // 뒤로가기 stack -> current
            this.current = this.backwardStack.pop();
        }
    }

    private void forward() {
        if(!this.forwardStack.isEmpty()){
            // 현재 url -> 뒤로가기 stack
            this.backwardStack.push(this.current);
            // 앞으로가기 stack -> current
            this.current = this.forwardStack.pop();
        }
    }

}
