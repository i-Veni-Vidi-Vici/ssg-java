package com.sh.collections._01.list.Coparator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue
 * -선형메모리 공간에 데이터를 저장
 * 선입선출 FIFO first in first out의 구조를 가진다.
 * queue 인터페이스 -linkedlist,deque,bockingqueue,blockingdeque,transferquere 구현클래스
 */
public class App5 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        //offer(E) 맨뒤에 요소추가
        queue.offer(3);
        queue.offer(2);
        queue.offer(4);
        queue.offer(5);
        queue.offer(1);
        System.out.println(queue);
        //poll():E 맨앞의 요소제거
        System.out.println(queue.poll());
        System.out.println(queue);
        //peek():E 맨앞의 요소 읽어오기(제거하지 않음)
        System.out.println(queue.peek());
        System.out.println(queue);

    }
}
