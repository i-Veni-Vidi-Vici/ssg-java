package com.sh.collections._01.list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *     Queue
 *     - 선형 메모리 공간에 데이터를 저장
 *     - 선입선출 First In First Out FIFO의 구조를 가진다.
 *     - Queue 인터페이스를 구현한 클래스 LinkedList, Deque, BlockingQueue, BlockingDeque, TranferQeueu 구현 클래스
 *
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // 맨 뒤에 요소 추가 offer(E)
        queue.offer(3);
        queue.offer(2);
        queue.offer(4);
        queue.offer(5);
        queue.offer(1);
        System.out.println(queue);

        // Queue 인터페이스에서는 List#indexOf 사용할 수 없다.
        // Collection#contains는 사용가능하다.
        System.out.println(queue.contains(2));
        queue.remove(Integer.valueOf(2));               // index가 아닌 Object를 인자로

        // 맨 앞에 요소 가져오기 poll():E, 제거함


        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);

        // peak():E 맨앞의 요소 읽기, 제거하지 않음
        System.out.println(queue.peek());
        System.out.println(queue);

        // 전체 꺼내기
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        System.out.println(queue.peek());           // 요소가 없는데 peek() 호출시 null 리턴
        System.out.println(queue.poll());           // 요소가 없는데 poll() 호출시 null 리턴, 스택과 달리 오류 발생 안함
        System.out.println(queue);
    }
}
