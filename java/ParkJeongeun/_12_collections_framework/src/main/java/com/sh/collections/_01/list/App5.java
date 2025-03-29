package com.sh.collections._01.list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * Queue
 * - 선형메모리 공간에 데이터를 저장
 * - 선입선출 FIFO (First In First Out)의 구조를 가짐
 * - Queue인터페이스 - LinkedList, Deque, BlockingQueue, BlockingDeque, TransferQueue 구현클래스
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // 요소추가 (맨 뒤에 추가) : offer(E)
        queue.offer(3);
        queue.offer(2);
        queue.offer(4);
        queue.offer(5);
        queue.offer(1);
        System.out.println(queue); // [3, 2, 4, 5, 1]

        // Queue인터페이스에서는 List#indexOf 사용할 수 없음
        // Collection#contains는 사용 가능
        System.out.println(queue.contains(2)); // true (큐 안에 2가 있음)
        queue.remove(Integer.valueOf(2)); // 2값 삭제, index가 아닌 Object를 삭제

        // 맨앞의 요소 반환(제거) : poll():E
        System.out.println(queue.poll()); // 3
        System.out.println(queue); // [2, 4, 5, 1]

        // 전체 꺼내기
//        while (!queue.isEmpty()) {
//            System.out.println(queue.poll());
//        }
//        System.out.println(queue.poll()); // null반환, 비어있어도 오류발생X

        // 맨앞의 요소 읽어오기(제거X) : peek():E
        System.out.println(queue.peek()); // 2
        System.out.println(queue); // [2, 4, 5, 1]
    }
}
