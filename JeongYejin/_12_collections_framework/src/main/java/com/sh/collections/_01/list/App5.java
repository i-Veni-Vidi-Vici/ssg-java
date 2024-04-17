package com.sh.collections._01.list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * Queue
 * - 선형메모리 공간에 데이터를 저장
 * - 선입선출 FIFO First In First Out의 구조를 가진다.
 * - Queue 인터페이스 - LinkedList, Deque, BlockingQueue, BlockingDeque, TransferQueue 구현클래스
 * - LinkedList 사용률 가장 높음
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

        // Queue 인터페이스에서는 indexOf 사용할 수 없다.
        // Collection#contains는 사용가능하다.
        System.out.println(queue.contains(2));
        queue.remove(2); // index가 아닌 Object를 인자
        System.out.println(queue);
        queue.remove(Integer.valueOf(5));
        System.out.println(queue);
        queue.add(4);
        System.out.println("4추가? " + queue);

        // poll():E 맨앞의 요소 제거
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);

        // Peek():E 맨앞의 요소 읽어오기(제거X)
        System.out.println(queue.peek());
        System.out.println("제거?" + queue);

        queue.clear();
        System.out.println(queue);

        // 전체 꺼내기
        // 스택은 null일때 꺼내려하면 오류나는데 큐는 안남
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
            System.out.println(queue);
        }
        System.out.println(queue.poll());

    }
}
