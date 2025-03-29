package com.sh.collections._01.list;

import java.util.Stack;

public class HistoryApp {

    private Stack<String> backwardStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();
    private String currentURL;

    public static void main(String[] args) {
        HistoryApp app = new HistoryApp();
        app.goToURL("1.Youtube");
        app.printStatus();
        app.goToURL("2.FaceBook");
        app.printStatus();
        app.goToURL("3.Naver");
        app.printStatus();
        app.goToURL("4.Instagram");
        app.printStatus();

        app.backward();
        app.printStatus();
        app.backward();
        app.printStatus();

        app.forward();
        app.printStatus();
        app.forward();
        app.printStatus();
        app.goToURL("3.Naver");
        app.printStatus();

    }
    public void goToURL(String URL){
        if(currentURL!=null){
            this.backwardStack.push(currentURL);
        }
        this.currentURL = URL;
        while(!forwardStack.isEmpty()){
            forwardStack.pop();
        }
    }
    public void backward(){
        if(!backwardStack.isEmpty()){
            if(currentURL!=null){
                this.forwardStack.push(currentURL);
            }
            currentURL = backwardStack.pop();
        }
    }
    public void forward(){
        if(!forwardStack.isEmpty()){
            if(currentURL!=null){
                backwardStack.push(currentURL);
            }
            currentURL = forwardStack.pop();
        }
    }
    public void printStatus(){
        System.out.println("==================");
        System.out.println("뒤로가기 stack : " + this.backwardStack);
        System.out.println("현재 URL : " + this.currentURL);
        System.out.println("앞으로가기 stack : " + this.forwardStack);
        System.out.println("==================");
    }
}
