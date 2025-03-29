package com.sh.collections._01.list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * Queue
 * - 선형메모리 고악ㄴ에 데이터를 저장
 * - 선입선출 FIFO
 * - Queue인터페이스 - LinkedList, Deque, BlockingQueue, BLockingDeque, TransferQueue 구현 클래스
 * -
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        Queue<Integer>queue=new LinkedList<>();

        //offer(E) 맨뒤에 요소추가
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(7);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        System.out.println("현재  : "+queue);

        //poll():E 맨앞의 요소 제거
        queue.poll();;
        System.out.println("제거 후 : " +queue);

        //전체 꺼내기
//        while(!queue.isEmpty())
//        {
//            System.out.println("poll : "+queue.poll());
//        }
//        System.out.println(queue);


        //peek():E 맨앞의 요소 읽어오기 (제거하지 않음)
        System.out.println("peek : "+queue.peek());
        System.out.println("peek 후 : "+queue);

        //null = 비어 있어도 오류 발생 안함

        // Queue 인터페이스에서는 List#indexOf 사용할 수 없다.
        // Collection#contains는 사용가능 하다
        System.out.println(queue.contains(7));// 큐 안에 포함이 되어 있는가
        queue.remove(7);// 인덱스가 아닌 오브젝트를 지운다 즉 요소를 지운다// 중간에 잇는걸 지울 수 있다
        System.out.println(queue);


    }
}
