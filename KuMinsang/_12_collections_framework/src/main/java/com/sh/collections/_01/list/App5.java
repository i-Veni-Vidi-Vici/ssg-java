package com.sh.collections._01.list;

import java.awt.desktop.QuitEvent;
import java.util.LinkedList;
import java.util.Queue;

public class App5 {


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        App5 app = new App5();
        queue.add(5);
        queue.add(1);
        queue.add(3);
        queue.add(8);
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);

    }


}
