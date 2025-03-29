package com.sh.collections._01.list;

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
        List<Integer> list = new LinkedList<>();
        list.add(0); // auto-boxing
        list.add(1);
        list.add(2);

        list.add(2, 250);

        list.remove(3);

        System.out.println(list.contains(1));
        System.out.println(list.indexOf(1));
        System.out.println(list.isEmpty());

        list.clear();
        System.out.println(list.isEmpty());

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
