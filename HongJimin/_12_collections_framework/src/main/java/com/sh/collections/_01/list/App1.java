package com.sh.collections._01.list;

import java.time.LocalDate;
import java.util.*;

/**
 * <pre>
 *    List 계열
 *  - ArrayList(대표)
 *     - ArrayList 객체 안에는 데이터를 관리할 배열을 가지고 있음
 *  - LinkedList
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
//        ArrayList list1 = new ArrayList();
//        List list2 = new ArrayList(); //다형성
//        Collection list3 = new ArrayList();

        List<String> list = new ArrayList<>();//타입 추론(1.7) 부터 추가된 기능
//        List list = new ArrayList();

        //✨요소 추가 - 너무 중요한 특징✨
        list.add("eeeee");
        list.add("banana");
        list.add("call");
        list.add("abc");
        list.add("data");
//        list.add(123);
//        list.add(123);
//        list.add(123.456);
//        list.add(LocalDate.now());

        //get(인덱스 : int)
        String elem0 = list.get(0); //리턴 타입 String 보장!
        System.out.println(list.get(0));//eeeee
        System.out.println(list.get(1));//banana
        System.out.println(list.get(2));//call
        System.out.println(list.get(3));//abc
        System.out.println(list.get(4));//data
//        System.out.println(list.get(5)); //IndexOutOfBoundsException :Index 5 out of bounds for length 5


        //삽입 add(int, E)
        list.add(2, "ㅋㅋㅋ"); //2번째 인덱스에, 새로운 값을 삽입, 나머지 값들은 인덱스 뒤로 밀림
        System.out.println(list);

        //대체 set(int, E)
        list.set(2, "ㅎㅎㅎ"); //2번째 인덱스 대신 값을 대체함
        System.out.println(list);

        //제거 remove(int)
        list.remove(2);
        System.out.println(list);

        //정렬 - 기본 오름차순 정렬
        Collections.sort(list); //원본 리스트를 직접 수정해줌

        //내림차순 정렬 🆘 어려워융
        Comparator<String> comparator = Collections.reverseOrder(); //정렬 기준 객체
        Collections.sort(list, comparator);

        //toString
        System.out.println(list);

        //저장된 요소의 개수 = size() : int
        System.out.println(list.size()); //5

        //반복 처리
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (String str : list) {
            System.out.println("foreach - " + str);
        }

        //iterator 객체를 통한 반복처리(Iterable#iterator() -> list, set)
        // - hasNext() : 다음 요소 존재 여부 반환
        // - next() : 다음 요소 반환
        Iterator<String> iter = list.iterator();
//        while(iter.hasNext()){ //토큰과 사용이 비슷함!
//            String next = iter.next();
//            System.out.println(next);
//        }

        //iterator 객체는 요소를 소비한다. 모두 소비 후에는 hasNext에서는 항상 false를 반환
        while(iter.hasNext()){ //토큰과 사용이 비슷함!
            System.out.println("----------");
            String next = iter.next();
            System.out.println(next);
        }

        //다른 리스트를 통으로 복사하기
        //new ArrayList<> (Collection) - list/set을 그대로 새로운 리스트로 복사할 수 있음
        List<String> list2 = new ArrayList<>(list);
        System.out.println(list2);
    }
}
