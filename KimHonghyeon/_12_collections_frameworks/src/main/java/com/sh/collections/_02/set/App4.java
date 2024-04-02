package com.sh.collections._02.set;

import java.util.Set;
import java.util.TreeSet;

public class App4 {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        while(numbers.size()<6){
            numbers.add((int)(Math.random()*45)+1);
        }

        System.out.println(numbers);
    }
}
