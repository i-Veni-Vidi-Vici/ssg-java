package com.sh.collections._01.list;

import java.util.LinkedList;
import java.util.Queue;

public class App5 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(3);
        queue.offer(2);
        queue.offer(4);
        queue.offer(5);
        queue.offer(1);
        System.out.println(queue);

        System.out.println(queue.contains(2));
        queue.remove(2); // index가 아닌 object 인자

//        System.out.println(queue.poll());
//        System.out.println(queue);
//        System.out.println(queue.poll());
//        System.out.println(queue);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        System.out.println(queue.poll()); // 비어 있어도 오류 발생 안함



//        System.out.println(queue.peek());
//        System.out.println(queue);


    }
}
