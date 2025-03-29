package com.sh.collections._01.list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * Queue
 * - 선형메모리 공간에 데이터를 저장
 * - 선입선출 FIFO First In First Out 구조를 가진다.
 * - Queue 인터페이스 - LinkedList(제일 많이 쓰고 일반적), Deque, BlockingQueue, BlockingDeque, TransferQueue 구현클래스
 * [입구][ ][ ][ ][ ][ ][출구]
 *
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
        System.out.println(queue); // 리스트처럼 차곡차곡 쌓임

        // Queue 인터페이스에서는 indexOf 사용할 수 없다.
        // Collection#contains는 사용 가능.
        // Queue는 인터페이스. Collection을 상속하고 있기 때문에 contains 사용 가능.
        System.out.println(queue.contains(2));
        queue.remove(2); // index가 아니라 object를 인자로 함. queue.remove(Integer.valueOf(2));

        // poll():E 맨앞의 요소제거
//        System.out.println(queue.poll()); // 3
//        System.out.println(queue); // 3이 제거된 상태임 [2, 4, 5, 1]
//        System.out.println(queue.poll()); // 2
//        System.out.println(queue); // [4, 5, 1]

        // 전체 꺼내기
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        System.out.println(queue.poll()); // 결과: null | 비어있어도 오류 발생 X... 스택은 오류발생, 큐는 오류발생안함.

        // peek():E 맨앞의 요소 읽어오기(제거하지 않음)
        System.out.println(queue.peek()); // 4
        System.out.println(queue); // [4, 5, 1]


    }
}
