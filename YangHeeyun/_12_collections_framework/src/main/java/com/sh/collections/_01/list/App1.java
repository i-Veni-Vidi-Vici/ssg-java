package com.sh.collections._01.list;

import java.time.LocalDate;
import java.util.*;
import java.util.List;

/**
 * <pre>
 * Collection
 * - List
 *      -ArrayList (대표)
 *      -LinkedList
 *
 * ArrayList객체안에는 데이터를 관리할 배열을 가지고 있다.
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
//        ArrayList list1 = new ArrayList();
//        List list2 = new ArrayList();
//        Collection list3 = new ArrayList();

        List<String> list = new ArrayList<>();

        // 요소추가
        list.add("banana");
        list.add("call");
        list.add("eeeeeeee");
        list.add("data");
        list.add("abc"); //<String>을 주었으니 str형 제외 add불가

//        list.add(123);
//        list.add(123.456);
//        list.add(LocalDate.now()); // 타입추론(1.7버전부터 추가된 기능)

        // get(인덱스:int)
        String elem0 = list.get(0); // 리턴타입 String 보장!
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
//        System.out.println(list.get(5)); //  java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4

        // 삽입 add(int, E) int번지에 e삽입
        list.add(2,"ㅋㅋㅋ");

        // 대체 set(int, E)
        list.set(2, "ㅎㅎㅎ");

        // 제거 remove(int)
        list.remove(2);

        // 사전 순서대로 정렬- 기본 오름차순 정렬
        Collections.sort(list); // 원본 리스트 직접 수정

        // 내림차순 정렬
        // 방법1
        Collections.sort(list,Collections.reverseOrder());

        // 1과 비슷한 방법2
        Comparator<String> comparator = Collections.reverseOrder(); // comparator - 정렬기준 객체
        Collections.sort(list,comparator);

        // toString
        System.out.println(list);

        // 저장된 요소의 개수 length가 아니라 size():int
        System.out.println(list.size()); // 5

        // 반복처리
        for(int i=0;i<list.size();i++){
            System.out.println("for - " + i + " - " + list.get(i));
        }

        // 인덱스가 없어도 되는 향상된 for문
        for(String str:list){
            System.out.println("foreach - " + str);
        }

        // iterator객체를 통한 반복처리 (Iterable#interator() - list, set)
        // -hasNext() 다음요소 존재여부
        // - next() 다음요소 반환
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            String next = iter.next();
            System.out.println(next);
        }

        // iterator객체는 요소를 소비한다. 모두 소비후 hasNext()에서는 항상 false를 반환
        while(iter.hasNext()){
            System.out.println("------------------");
            String next = iter.next();
            System.out.println(next);
        }

        // 다른 리스트를 통으로 복사하기
        // new ArrayLsit<>(Collection) - list/set을 그대로 새로운 리스트로 복사할 수 있다.
        List<String> list2 = new ArrayList<>(list);
        System.out.println(list2);
    }
}
