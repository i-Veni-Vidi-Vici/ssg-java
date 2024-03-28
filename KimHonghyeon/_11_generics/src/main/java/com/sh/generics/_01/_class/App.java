package com.sh.generics._01._class;

public class App {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        Box<String> stringBox = new Box<>();

        intBox.setValue(10);
        stringBox.setValue("Hello");

        System.out.println(intBox.getValue());
        System.out.println(stringBox.getValue());
    }
}
