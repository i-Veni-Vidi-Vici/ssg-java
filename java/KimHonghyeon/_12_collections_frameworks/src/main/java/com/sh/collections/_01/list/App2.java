package com.sh.collections._01.list;

import java.util.*;

public class App2 {
    public static void main(String[] args) {
        List<Integer> list =new LinkedList<>();
        list.add(10);
        list.add(120);
        list.add(39);
        for(int i : list){
            System.out.println(i);
        }
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            int i = iter.next();
            System.out.println(i);

        }
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        Collections.sort(list,comparator);
        iter = list.iterator();
        while(iter.hasNext()){
            int i = iter.next();
            System.out.println(i);

        }
    }
}
