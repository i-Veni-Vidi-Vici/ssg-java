package com.sh.collections._01.list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * Queue
 * - 선형메모리 공간에 데이터를 저장
 * - 선입선출 FIFO First In First Out의 구조를 가진다.
 * - Queue인터페이스 - LinkedList, Deque, BlockingQueue, BlockingDeque, TransferQueue 구현클래스
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // offer(E) 맨뒤에 요소추가
        queue.offer(3);
        queue.offer(2);
        queue.offer(4);
        queue.offer(5);
        queue.offer(1);
        System.out.println(queue);

        // Queue인터페이스에서는 List#indexOf 사용할 수 없다.
        // Collection#contains는 사용가능하다.
        System.out.println(queue.contains(2));
        queue.remove(Integer.valueOf(2)); // index가 아닌 Object를 인자

        // poll():E 맨앞의 요소 제거
//        System.out.println(queue.poll());
//        System.out.println(queue);
//        System.out.println(queue.poll());
//        System.out.println(queue);

        // 전체 꺼내기
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        System.out.println(queue.poll()); // null 비어있어도 오류 발생 안함.

        // peek():E 맨앞의 요소 읽어오기(제거하지 않음)
        System.out.println(queue.peek());
        System.out.println(queue);
    }
}