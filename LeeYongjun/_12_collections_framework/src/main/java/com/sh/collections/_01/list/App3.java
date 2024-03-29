package com.sh.collections._01.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 * LinkedList 연결리스트
 * - 내부에 배열을 가진 ArrayList와 달리 노드(요소)를 연결해서 데이터를 관리
 * - 저장된 순서를 잘 유지하며, 요소의 추가/수정/삭제에 특화되어 있다.
 * - 사용방법은 ArrayList와 동일하고, 내부처리과정만 다르다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        List<Integer>list = new LinkedList<>();
        list.add(Integer.valueOf(100)); // Integer 전달
        list.add(200); // int 전달 (auto-boxing처리)
        list.add(300);
        list.add(200);
        list.add(100);

        list.add(2,250);

        list.remove(4);

        System.out.println(list.contains(100)); // true 포함여부
        System.out.println(list.indexOf(100)); // 0 (첫번째 요소 인덱스 반환)
        System.out.println(list.indexOf(10000)); // -1

        //list.clear();
        System.out.println(list.isEmpty()); // false 요소가 1개이상 , true 요소가 0개

        Iterator<Integer>iter = list.iterator();
        while (iter.hasNext()){
            Integer n = iter.next();
            System.out.println(n);
        }
    }
}
