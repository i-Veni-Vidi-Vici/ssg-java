package com.sh.collections._01.list;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * <pre>
 *  Collection
 *  - List
 *      - ArrayList (대표)
 *      - LinkedList
 *
 * ArrayLsit 객체 안에는 데이터를 관리할 배열을 가지고 있다.
 *
 * </pre>
 *
 *
 */


public class App1 {
    public static void main(String[] args) {
//        ArrayList list1 = new ArrayList();
//        List list2 = new ArrayList(); // 다형성
//        Collection list3 = new ArrayList(); // 다형성

//        List list = new ArrayList(); // 내부적으로 배열 있음

//        List<String> list = new ArrayList<>();
        List<String> list = new ArrayList<>(); // 이러면 String만 받기 가능
        //요소추가
        list.add("abc");
        list.add("eeeeeeeeeeee");
        list.add("call");
        list.add("banana");
        list.add("data");

//        list.add(123);
//        list.add(123.456);
//        list.add(LocalDate.now());

        // get(인덱스:int)
        System.out.println(list.get(0));

        // toString
        String elem0 = list.get(0); // 리턴타입 String 보장!
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
//        System.out.println(list.get(4));
//        System.out.println(list.get(5)); // 인덱스 벗어남



        // 삽입 add(int,E)
        list.add(2,"ㅋㅋㅋ");

        // 대체 set(int , E)
        list.set(2,"ㅎㅎㅎ");

        //제거 remove(int)
        list.remove(2); // 2번지 요소 삭제

        Collections.sort(list); // 원본 리스트 수정 // 기본 오름차순 정렬

        // 내림차순
        Comparator comparator = Collections.reverseOrder();
        Collections.sort(list,comparator);
//        Collections.sort(list,Collections.reverseOrder());

        //toString
        System.out.println(list);

        //저장된 요소의 개수 size() : int
        System.out.println(list.size()); // 5

        for(int i =0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        //iterator 반복자 객체를 통한 반복처리 (Iterable#iterator() -> list, set)
        // - hasNext() 다음요소 존재여부 반환
        // - next() 다음요소 반환
        Iterator<String> iter = list.iterator();  // 객체 만들고
        // ctrl + alt + V
        // 왜 스트링이에요?
        // List가 스트링이라서

        while ((iter.hasNext())){
            String next = iter.next(); // 다음꺼 있니? 다음꺼 줘봐
            System.out.println(next);
        }


        // iterator객체는 요소를 소비한다. 모두 소비후 hasNext()에서는 항상 false를 반환

        while ((iter.hasNext())){
            System.out.println("------------------");
            String next = iter.next(); // 다음꺼 있니? 다음꺼 줘봐
            System.out.println(next);
        }

        // 다른 리스트를 통으로 복사하기
        // new ArrayList<>(Collection) - list/set을 그대로 새로운 리스트로 복사할 수있다.

        List<String> list2 = new ArrayList<>(list);
        System.out.println(list2);



    }
}
