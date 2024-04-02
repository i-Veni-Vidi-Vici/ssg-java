package com.sh.collections._01.list;

import java.util.Stack;

/**
 * <pre>
 * - backwardStack
 * - current
 * - farwarStack
 *
 * 1. 특정 url로 이동시 url은 current에 대입된다
 * 2. 특정 url로 이동시 기존 url은 backwardStack에 쌓이고, url로 이동한다
 * 3. 특정 url로 이동시 forwardStack이 비어있지 않다면, 제거한다.
 * 4. 뒤로가기로 누르면, 현재 url은 forwardStack에 쌓이고, backwardStack에 있는 url을 current에 대입한다.
 * 5. 앞으로 가기 -> 현재 url은 backwardStack에에 쌓이고, current는 forwardStack에 쌓인다
 * </pre>
 */
public class HistoryApp {
    private Stack<String> backwardStack = new Stack<>();// 뒤
    private String current; // 현재
    private Stack<String >forwardStack=new Stack<>();// 앞

    public static void main(String[] args) {
        HistoryApp app=new HistoryApp();
        app.goToUrl("1. naver.com");
        app.printStatus();
        app.goToUrl("2. youtube.com");
        app.printStatus();
        app.goToUrl("3. google.com");
        app.printStatus();
        app.goToUrl("4. instagram.com");
        app.Backward();
        app.Forward();

        app.printStatus();
    }

    public void goToUrl(String url) {
        //기존 페이지
        if(this.current!=null)
            this.backwardStack.push(this.current);
        this.current=url;

        //앞으로 가기
        if(!this.forwardStack.isEmpty())
            this.backwardStack.clear();;

    }
    public void Backward() {
        //기존 url -> 앞으로 가기
        if(!this.backwardStack.isEmpty())
            this.forwardStack.push(this.current);

        //뒤로가기 stack-> 현재로
        this.current=this.forwardStack.pop();
    }
    public void Forward(){

        if(!this.forwardStack.isEmpty())
            //현재 -> 뒤로가기 stack
            this.backwardStack.push(this.current);

        //앞으로 stack -> 현재
        this.current = forwardStack.pop();

    }
    public void printStatus() {
        System.out.println("---------------------------");
        System.out.println("뒤로가기 stack : "+backwardStack);
        System.out.println("현재 url : "+current);
        System.out.println("앞으로 가기 stack : "+forwardStack);
        System.out.println("---------------------------");


    }
}
