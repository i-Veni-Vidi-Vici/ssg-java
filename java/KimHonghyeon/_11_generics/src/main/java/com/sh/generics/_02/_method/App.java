package com.sh.generics._02._method;

public class App {

    public <T> T process(T arg){
        return arg;
    }
    public static void main(String[] args) {
        App app = new App();
        app.process("Hello");
        app.process(10);
    }
}
