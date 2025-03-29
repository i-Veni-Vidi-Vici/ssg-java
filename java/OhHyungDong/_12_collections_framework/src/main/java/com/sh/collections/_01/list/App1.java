package com.sh.collections._01.list;

import java.sql.Array;
import java.time.LocalDate;
import java.util.*;

/**
 * <pre>
 * Collection
 * - List(순서가 필요할 때, 저장한 순서를 그대로 유지 )
 *      - ArryaList (대표)
 *      - LinkedList
 *ArrayList 객체 안에는 데이터를 관리할 배열을 가지고 있다.
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
//        ArrayList list1 = new ArrayList<>();
//        List list2 = new ArrayList();
//        Collection list3 = new ArrayList();

        List<String> list = new ArrayList<>();

        list.add("abc");
        list.add("banana");
        list.add("call");
        list.add("data");
        list.add("eeeeee");

        //get(int : 인덱스)
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        //add(int, E) 삽입
        list.add(2, "zzz");

        //대체 set(int, E)
        list.set(2, "ㅎㅎㅎ");

        //제거 remove(int)
        list.remove(2);

        //정렬 - 기본 오름차순 정렬
        Collections.sort(list); //원본 리스트를 직접 수정

        //정렬 -내림차순 정렬
        Comparator<String> comparator = Collections.reverseOrder(); //Comparator : 정렬 기준 객체
        Collections.sort(list,comparator);

        //저장된 요소의 개수 size() :
        //반복처리
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

        //iterator 객체를 통한 반복처리(Iterable#interator() -> list, set)
        // -hasNext() 다음 요소 존재 엽 반환
        // -next(), 다음요소 반환
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
        //iterator객체는 요소를 소비한다. 모두 소비후 hasNext()에서는 항상 false를 반환
        while(iterator.hasNext()){
            System.out.println("================");
            String next = iterator.next();
            System.out.println(next);
        }
        //다른 리스트를 통해 통으로 복사하기
        //new ArryalList<>(Collection) - list / set을 그대로 새로운 리스트로 복사 할 수 있다.
        List<String> list2 = new ArrayList<>( );
        System.out.println(list2);

        //toString
        System.out.println(list);

    }
}
