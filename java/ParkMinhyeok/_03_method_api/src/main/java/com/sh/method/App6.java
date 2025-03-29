package com.sh.method;

public class App6 {
    public static void main(String[] args) {
        App6 app = new App6();
        String word = app.say();
        System.out.println(word);

        int num = app.getNumber();
        System.out.println(num);
    }
    public String say() {
        System.out.println("say.......");
        return "말";
    }
    public int getNumber() {
        return 33;
    }
}
