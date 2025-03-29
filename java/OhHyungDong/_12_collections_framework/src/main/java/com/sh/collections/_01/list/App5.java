package com.sh.collections._01.list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *  Queue
 *  - 선형 메모리(연속된 메모리)에 공간에 데이터를 저장
 *  - 선입선출(FISRST IN FIRST OUT)의 구조를 가진다.
 *  - Queue 인터페이스 - 구현 클래스 : LinkedList, Deque, BlockingQueue, TransferQueue 등
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        //offer() : 요소 추가 - 맨 뒤에
        queue.offer(3);
        queue.offer(2);
        queue.offer(4);
        queue.offer(5);
        queue.offer(1);
        System.out.println(queue);

        //Queue에서는 List#indexOf 사용불가
        //Collection#contains 는 사용 가능하다.

        //poll() : 요소 가져오기 (맨 앞에 요소 제거)
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);

        //전체꺼내기
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        System.out.println(queue.poll()); //null비어있어도 오류 발생 안함

        //peek() : 맨 앞의 요소 읽어오기 (제거하지 않음)
        System.out.println(queue.peek());

    }
}
