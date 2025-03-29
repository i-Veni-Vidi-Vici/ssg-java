package com.sh.method;

public class App6 {
    public static void main(String[] args) {
        App6 app = new App6(); //객체생성
        String word = app.say();
        System.out.println(word);
        app.say();
        int number = 33;
        app.getNumber(number);
    }

    private int  getNumber(int number) {
        return number;
    }

    public String say() {
        System.out.println("say.....");
        return "말";
    }
}
