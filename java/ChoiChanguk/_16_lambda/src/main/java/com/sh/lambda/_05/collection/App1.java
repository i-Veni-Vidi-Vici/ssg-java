package com.sh.lambda._05.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 람다를 인자로 하는 list메소드
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        //List#ForEach(Consumer<T>)
        list.forEach((n)->{
            System.out.println(n);
        });
    }
}
