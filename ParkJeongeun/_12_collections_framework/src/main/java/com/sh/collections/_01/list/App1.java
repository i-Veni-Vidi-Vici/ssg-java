package com.sh.collections._01.list;

import java.time.LocalDate;
import java.util.*;

/**
 * <pre>
 * Collection
 * - List
 *   - ArrayList (대표)
 *   - LinkedList
 *
 * ArrayList 객체 안에는 데이터를 관리할 배열을 가지고 있음
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
//        ArrayList list1 = new ArrayList();
//        List list2 = new ArrayList(); // 상위 타입을 지정해서 다형성 구현
//        Collection list3 = new ArrayList(); // 상위 타입을 지정해서 다형성 구현

        List<String> list = new ArrayList<>();

        // 요소 추가
        list.add("abc");
        list.add("banana");
        list.add("call");
        list.add("data");
//        list.add(123); 위 List 객체생성문에 <String> 추가하면 컴파일 오류
//        list.add(LocalDate.now());

        // get(인덱스:int)
        String elem0 = list.get(0); // 리턴타입 String 보장
        System.out.println(list.get(0)); // abc
//        System.out.println(list.get(1)); // 123
//        System.out.println(list.get(2)); // 2024-03-28

        // 삽입 add(int, E) 뒤에꺼 밀림
        list.add(2,"ㅋㅋ");

        // 대체 set(int, E)
        list.set(2, "ㅎㅎ");

        // 제거 remove(int)
        list.remove(2);

        //toString
        System.out.println(list);

        // 정렬 : 기본 오름차순 정렬
        Collections.sort(list); // 원본 리스트를 직접 수정

        // 내림차순
        Comparator<String> comparator = Collections.reverseOrder(); // Comparator 정렬기준객체
        Collections.sort(list, comparator);

        // 저장된 요소의 개수 : size():int
        System.out.println(list.size()); // 4

        // 반복처리
        for (int i= 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        for (String str : list) {
            System.out.println(str);
        }

        // iterator 객체를 통한 반복처리(Iterable#iterator() -> list, set이 사용 가능)
        // - hasNext() 다음 요소 존재 여부 반환
        // - next() 다음 요소 반환
        Iterator<String> iter = list.iterator();
        // iterator 객체는 요소를 소비함, 모두 소비한 후 hasNext()에서는 항상 false 반환
        while (iter.hasNext()) {
            String next = iter.next();
            System.out.println(next);
        }

        // 다른 리스트를 통으로 복사
        // new ArrayList<>(Collection) : list/set을 그대로 새로운 리스트로 복사할 수 있음
        List<String> list2 = new ArrayList<>(list);
        System.out.println(list2);
    }
}
