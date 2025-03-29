package com.sh._05.collection;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        list.forEach(System.out::println);
        //List#removeIf(Predicate<T>)
        list.removeIf((n)->n==20);
        System.out.println(list);


    }
}