package com.sh._static;

public class App {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        counter1.increaseCount();
        counter2.increaseCount();
        System.out.println(counter1.getCount());
        System.out.println(counter2.getCount());

        counter1.increaseSCount();
        counter2.increaseSCount();
        System.out.println(counter1.getScount());
        System.out.println(counter2.getScount());
    }
}
