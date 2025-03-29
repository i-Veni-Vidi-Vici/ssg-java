package com.sh.collections._01.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList 연결리스트
 * - 내부에 배열을 가진 ArrayList와 달리 노드(요소)를 연결해서 데이터를 관리
 * - 저장된 순서를 잘 유지하며, 요소의 추가/수정/삭제에 특화되어 있다.
 * - 사용 방법은 ArrayList와 동일하고, 내부 처리 과정만 다르다.
 *
 */
public class App3 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(200);
        list.add(100);

        list.add(2,250);
        list.remove(4);
        System.out.println(list.contains(100));
        System.out.println(list.indexOf(100));
        System.out.println(list.indexOf(10000));
        // list.clear(); 모든 요소 삭제
        System.out.println(list.isEmpty());

        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()){
            Integer n = iter.next();
            System.out.println(n);
        }
    }
}
