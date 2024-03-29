package com.sh.collections._01.list;

import java.time.LocalDate;
import java.util.*;

/**
 * <pre>
 *     Collection
 *     - List // interface
 *          - ArrayList (대표)
 *          - LinkedList
 *
 *      ArrayList 객체 안에는 데이터를 관리할 배열을 가지고 있다. // 뾰족한 수가 있는 것이 아니다.
 *
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
//        ArrayList list1 = new ArrayList();
//        List list2 = new ArrayList();
//        Collection list3 = new ArrayList();

//        List<String> list = new ArrayList<String>();
        List<String> list = new ArrayList<>();              // 타입 추론 (1.7)

        // 요소 추가
        list.add("eeeeeeeeeeee");
        list.add("data");
        list.add("add");
        list.add("call");
        list.add("banana");
//        list.add(123);
//        list.add(123.456);
//        list.add(LocalDate.now());

        // get(인덱스)
        String elem0 = list.get(0);                       // 리턴타입 String 보장!
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
//        System.out.println(list.get(5));                // java.lang.IndexOutOfBoundsException

        // 삽입 add(int 인덱스, E 요소)                      // 끼워넣는 것
        list.add(2, "ㅋㅋㅋㅋㅋㅋㅋㅋ");

        // 대체 set(int, E)
        list.set(2, "ㅎㅎㅎㅎㅎ");                           // 인덱스 2번째에 있는 요소를 "ㅎㅎㅎㅎ"로 변견ㅇ

        // 제거 remove(int)
        list.remove(2);                               // 인덱스 2번째에 있는 요소를 삭제

        // 정렬 sort();                                       // 원본 리스트 수정
        // 기본적으로 오름차순 정렬
        Collections.sort(list);

        // 내림차순 정렬
        Comparator<String> comparator = Collections.reverseOrder(); // 정렬 기준 객체
        Collections.sort(list, comparator);

        // toString
        System.out.println(list);

        // 저장된 요소의 개수 size():int
        System.out.println(list.size());                            // 5


        // 반복처리
        for(int i = 0; i < list.size(); i++) {
            System.out.println("for - " + i + " - " + list.get(i));
        }

        for(String str : list) {
            System.out.println("foreach - " + str);
        }

        // iterator 객체를 통한 반복처리 (Interable#iterator() list, set 모두 사용 가능한 메소드)
        // - hasNext() 다음요소 존재여부
        // - next() 다음요소 반환
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()) {
            String next = iter.next();
            System.out.println(next);
        }
        // iterator 객체는 요소를 소비한다. 모두 소비 후 hasNext() 에서는 항상 false를 반환
        while(iter.hasNext()) {
            System.out.println("-------------------------");
            String next = iter.next();
            System.out.println(next);
        }

        // 다른 리스트를 통으로 복사하기, 인자로
        // new ArrayList<>(Collection) - list/set을 그대로 새로운 리스트로 복사할 수 있다.
        List<String> list2 = new ArrayList<>(list);
        System.out.println(list2);
    }
}
