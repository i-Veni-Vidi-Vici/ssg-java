package com.sh.collections._01.list;

import java.util.Stack;

/**
 * backwardStack
 * current
 * forwardStack
 * 1. 특정 url 로 이동시 url 은 current 에 대입된다.
 * 2. 특정 url 로 이동시 url 은 backwardStack 에 쌓이고, url 로 이동한다.
 * 3. 특정 url 로 이동시 url forwardStack 이 비어 있지 않다면, 제거한다.
 * 4. 뒤로가기를 누르면, 현재 url 은 forwardStack 에 쌓이고, backwardStack 의 url 을 current 에 대입한다.
 * 5. 앞으로 가기를 누르면, 현재 url 은 backwardStack 에 쌓이고, forwardStack 의 url 을 current 에 대입한다.
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
        app.goToUrl("4. instagram");
        app.status();

        app.backward();
        app.status();
        app.backward();
        app.status();

        app.forward();
        app.status();

        app.goToUrl("5. TicTok");
        app.status();
    }

    public void goToUrl(String url) {
        if (this.current != null)
            this.backwardStack.push(this.current);

        this.current = url;

        if (!this.forwardStack.isEmpty()) {
            this.forwardStack.clear();
        }
    }

    public void backward() {
        if (!backwardStack.isEmpty()) {
            this.forwardStack.push(this.current);
            this.current = backwardStack.pop();
        }
    }

    public void forward() {
        if (!forwardStack.isEmpty()) {
            this.backwardStack.push(this.current);
            this.current = this.forwardStack.pop();
        }
    }

    public void status() {
        System.out.println("뒤로가기: " + this.backwardStack);
        System.out.println("현재: " + this.current);
        System.out.println("앞으로가기: " + this.forwardStack);
        System.out.println();
    }
}
