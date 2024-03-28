package com.sh.collections._01.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     LinkedList 연결리스트
 *
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        List<Integer>list = new LinkedList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        list.add(200);
        list.add(100);

        list.add(2,250);
        list.remove(4);
        System.out.println(list.contains(100)); //true포함여부
        System.out.println(list.indexOf(100));  //0(첫번째 요소 인덱스 qksghks)
        System.out.println(list.indexOf(10000));    // -1

        list.clear();   //리스트의 모든 요소 삭제

        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            Integer n = iter.next();
            System.out.println(n);
        }


    }
}
