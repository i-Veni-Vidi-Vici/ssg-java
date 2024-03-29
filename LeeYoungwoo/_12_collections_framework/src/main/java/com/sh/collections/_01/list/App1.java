package com.sh.collections._01.list;

import java.time.LocalDate;
import java.util.*;

/**
 * <pre>
 * Collections
 * - List
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

//        List<String> list = new ArrayList<String>();
        List<String> list = new ArrayList<>(); // 타입추론

        // 요소추가
        list.add("abc");
        list.add("banana");
        list.add("call");
        list.add("data");
        list.add("eeeeeee");

//        list.add(123);
//        list.add(123);
//        list.add(123.456);
//        list.add(LocalDate.now());

        // get(인덱스:int)
        String elem0 = list.get(0); // 리턴타입 String 보장!
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));

//        System.out.println(list.get(5)); 인덱스 오류

        // 삽입 add(int, E)
        list.add(2, "ㅋㅋㅋㅋ");

        // 대체 set(int, E)
        list.set(2, "ㅎㅎㅎㅎ");

        // 제거 remove(int)
        list.remove(2);

        // 정렬 - 기본 오름차순 정렬
        Collections.sort(list); // 원본 리스트 수정

        // 내림차순
        Comparator<String> comparator = Collections.reverseOrder();
        Collections.sort(list, comparator);

        // toString
        System.out.println(list);

        // 저장된 요소의 갯수 size():int
        System.out.println(list.size());
        // 반복처리
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // iterator 객체를 통한 반복처리 (iterable#iterator() -> list, set)
        // - hasNext() 다음요소 존재여부 반환
        // - next() 다음요소 반환
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()) {
            String next = iter.next();
            System.out.println(next);
        }
        // iterator 객체는 요소를 소비한다. 모두 소비 후 hasNext()에서는 항상 false를 반환
        while(iter.hasNext()) {
            System.out.println("~~~~~~~~~~~~~");
            String next = iter.next();
            System.out.println(next);
        }

        // 다른 리스트를 통으로 복사하기
        // new ArrayList<>(Collection) - list/set을 그대로 새로운 리스트로 복사가능
        List<String> list2 = new ArrayList<>(list);
        System.out.println(list2);
    }
}
