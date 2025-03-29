package com.sh.collections._01.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * ListkedList  연결리스트
 * - 내부에 배열을 가지 AarraysList와 달리 노드(요소)를 연결해서 데이터를 관리
 * - 저장된 순서를 잘 유지하며, 요소의 추가/수정/삭제에 특화되어 있다.
 * - 사용방법은 ArrayList와 동일하고, 내부처리과정만 다르다
 */
public class App3 {
    public static void main(String[] args) {
        List<Integer> list=new LinkedList<>();
        list.add(100);//이건 Integer.valueOf(100)이 넣어진건데 int로 전달 = auto-boxing
        list.add(200);
        list.add(300);
        list.add(400);
        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        list.add(2,250);

        list.remove(4);
        //list.clear();//모든 요소 삭제

        System.out.println(list.contains(100));// 포함여부
        System.out.println(list.indexOf(100));//100이 어느 인덱스에 있나요??
        System.out.println(list.indexOf(1000000));//1000000이 어느 인덱스에 있나요??
        System.out.println(list.isEmpty());//1개이상 false, 없으면// true



        Iterator<Integer>iter=list.iterator();
        while (iter.hasNext())
        {
            Integer n=iter.next();
            System.out.println(n);

        }
    }
}
