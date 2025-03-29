package com.sh.method;

public class App3 {
    public Integer age = 43;
    public static void main(String[] args){
        App3 app = new App3();
        String userName = "hgd";
        userName = "sina";
        app.age = 45;
        app.printUserName(userName,app.age);
    }
    public void printUserName(String name, Integer age){
        System.out.print("이름은 " +name+ "입니다.");
    }
}
