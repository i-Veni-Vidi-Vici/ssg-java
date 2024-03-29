package com.sh.collections._01.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     LinkedList 연결리스트
 *     - 내부에 배열을 가진 ArrayList와 달리 노드(요소)를 연결해서 데이터를 관리
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(Integer.valueOf(100)); //Integer 전달
        list.add(200);//int 전달(auto-boxing처리)
        list.add(300);
        list.add(200);
        list.add(100);

        list.add(2, 250);

        list.remove(4); //200삭제

        System.out.println(list.contains(100));//true
        System.out.println(list.indexOf(100)); //0(첫번째 요소 인덱스 반환)
        System.out.println(list.indexOf(10000)); //-1(존재 하지 하지 않을 때)
        System.out.println(list.isEmpty());//false - 요소가 1개 이상/ true 요소 0개

        list.clear(); //모든 요소 삭제
        System.out.println(list.isEmpty());//true - true 요소 0개

        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            Integer n = iter.next();
            System.out.println(n);
        }

    }
}
