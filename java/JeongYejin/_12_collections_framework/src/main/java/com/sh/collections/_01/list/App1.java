package com.sh.collections._01.list;

import java.util.*;

/**
 * <pre>
 * Collection
 *  - List
 *      - ArrayList (대표)
 *      - LinkedList
 *
 * ArrayList 객체 안에는 데이터를 관리할 배열을 가지고 있다.
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
//        ArrayList list1 = new ArrayList();
//        List list2 = new ArrayList();
//        Collection list3 = new ArrayList();
//        List list4 = new ArrayList();
//        List<String> list5 = new ArrayList<String>();

        List<String> list = new ArrayList<>(); // 타입추론 (1.7)

        // 요소 추가
        list.add("abc");
        list.add("banana");
        list.add("call");
        list.add("data");
        list.add("eeeeeeeee");
//        list.add(123);
//        list.add(123.456);
//        list.add(LocalDate.now());

        String elem0 = list.get(0); // 리턴타입 String 보장!
        // get (인덱스:int)
        System.out.println(list.get(0));
//        System.out.println(list.get(6)); // java.lang.IndexOutOfBoundsException

        // 삽입 add(int, E) int 번지에 끼워넣기!
        list.add(2, "ㅋㅋㅋ");

        // 대체 set(int, E)
        list.set(2, "ㅎㅎㅎ");

        // 제거 remove(int)
        list.remove(2);

        // 정렬 - 기본 오름차순 정렬
        Collections.sort(list); // 원본 리스트 수정

        // 내림차순
        // Comparator 정렬 기준 객체
        Comparator<String> comparator = Collections.reverseOrder();
        Collections.sort(list, comparator);

        // toString
        System.out.println(list);

        // 저장된 요소의 개수 size():int
        // 반복처리
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        // iterator 객체를 통한 반복처리 (Iterable#iterator() -> list, set)
        // - hasNext() 다음요소 존재여부 반환
        // - next() 다음요소 반환
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) { // 다음 거 있니? "소비적" (tokenizer와 비슷)
            String next = iter.next();
            System.out.println(next);
        } // iter 객체는 요소를 다 썼기 때문에 비어있음
        // iterator 객체는 요소를 소비한다. 모두 소비 후 hasNext() 에서는 항상 false를 반환한다.
        while (iter.hasNext()) {
            String next = iter.next();
            System.out.println(next);
        }

        // 다른 리스트를 통으로 복사하기
        // new ArrayList<>(Collection) - list/set을 그대로 새로운 리스트로 복사할 수 있다.
        List<String> list2 = new ArrayList<>(list);
        System.out.println(list2);
    }
}
