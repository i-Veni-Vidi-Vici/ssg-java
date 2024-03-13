package com.sh.method;

public class App6 {
    public static void main (String[] args){
        App6 app = new App6();
        String word = app.say();
        System.out.println(word);
    }
    public String say(){
        int a = 33;
        return String.valueOf(a);
    }
}
