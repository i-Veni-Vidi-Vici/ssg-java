package com.sh.collections._01.list;

import java.time.LocalDate;
import java.util.*;

/**
 * <pre>
 * Collection
 *  - List
 *      - ArrayList ( 대표 ) - 흔하게 사용
 *      - LinkedList
 *
 * ArrayList객체안에는 데이터를 관리할 배열을 가지고 있다.
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
//        ArrayList list1 = new ArrayList();
//        // 다형성 적용
//        List list2 = new ArrayList();  // 자주 사용함
//        Collection list3 = new ArrayList();

//        List<String> list = new ArrayList<String>();
        List<String> list = new ArrayList<>();  // 타입추론(1.7) 위의 줄과 모두 다 가능하다.

        // 요소추가
        list.add("eeeeeee");
        list.add("banana");
        list.add("call");
        list.add("abc"); // string만 받음
        list.add("data");
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
//        System.out.println(list.get(5)); // IndexOutOfBoundsException: Index 4 out of bounds for length 4

        // 삽입 add(int, E)  // E는 요소이다.
        list.add(2, "ㅋㅋㅋ");

        // 대체 set(int, E)
        list.set(2, "ㅎㅎㅎ"); // 2번지의 요소를 ㅎㅎㅎ로 바꿔주세요 라는 의미

        // 제거 remove(int)
        list.remove(2);

        // 정렬 -> 기본 오름차순 정렬(메소드 호출로 정렬 가능)
        Collections.sort(list); // 원본 리스트 수정

        // 정렬 -> 내림차순
        Comparator comparator = Collections.reverseOrder();  // 정렬기준객체
        Collections.sort(list, comparator);

        // toString
        System.out.println(list);

        // 저장된 요소의 개수 size();int
        System.out.println(list.size());
        // 반복처리
        for(int i = 0; i < list.size(); i++) {
            System.out.println("for - " + i + " " + list.get(i));
        }

        for(String str : list) {  // list를 꺼냈을 때 담을 변수는 str, str는 알아서 작성하면 된다.
            System.out.println("foreach -" + str); // 인덱스 없이 반복문 가능
        }

        // iterator객체를 통한 반복처리(Iterable#iterator() -> list, set이 모두 사용 가능)
        // - hasNext() 다음요소 존재여부
        // - next() 다음요소 반환
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()) {
            String next = iter.next();
            System.out.println(next);
        }
        // iterator객체는 요소를 소비한다. 모두 소비후에는 hasNext()에서는 항상 false를 반환
        while(iter.hasNext()) {
            System.out.println("-----------");
            String next = iter.next();
            System.out.println(next);
        }

        // 다른 리스트를 통으로 복사하기
        // new ArrayList<>(Collection) - list/set을 그대로 새로운 리스트로 복사할 수 있다.
        List<String> list2 = new ArrayList<>(list);
        System.out.println(list2);
    }
}
