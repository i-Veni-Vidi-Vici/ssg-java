package com.sh.collections._01.list;
import java.time.LocalDate;
import java.util.*;

/**
 * <pre>
 *     Collection
 *     - List
 *      - ArrayList(대표)
 *      - LinkedList
 *      ArrayList객체 안에는 데이털르 관리할 배열을 가지고 있다.
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
//        List list2 = new ArrayList();
//        Collection list3 = new ArrayList();
        List list = new ArrayList<>();

        //요소 추가
        list.add("123");
        list.add(123);
        list.add(123.456);
        list.add(LocalDate.now());

        System.out.println(list.get(0));

        //삽입 add(int, E)
        System.out.println(list.get(2));
        System.out.println(list.size());
        list.add(2, "zzz"); //123.456이 밀려남
        System.out.println(list.get(2));
        System.out.println(list.size());
        System.out.println(list.get(3));

//        list.remove(2);
//        list.remove(1);
 //       Collections.sort(list); //기본적으로 오름차순 정렬로 작동



    }
}
