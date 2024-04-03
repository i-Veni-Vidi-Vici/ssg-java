package com.sh.collections._01.list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue
 * - 션형메모리 공간에 데이터를 저장
 * - 선입선출 FIFO First In First Out
 * - Queue 인터페이스
 *      - linkedList
 *      - Deque
 *      - BlockingQueue
 *      - BlockingDeque
 *      - TransferQueue
 */
public class App5 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // offer(E) 맨뒤 요소 추가
        queue.offer(5);
        queue.offer(4);
        queue.offer(3);
        queue.offer(2);
        queue.offer(1);
        System.out.println(queue);

        // peek():E 맨앞의 요소 읽어오기(제거하지 않음)
        System.out.println("peek: " + queue.peek());
        // poll():E 맨 앞의 요소 제거, 비어있어도 오류 발생하지 않음
        System.out.println(queue.poll());
        System.out.println("peek: " + queue.peek());
        System.out.println(queue.poll());
    }
}
