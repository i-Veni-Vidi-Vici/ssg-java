package com.sh.array.sort;

public class App {
    public static void main(String[] args) {
        Swap swap = new Swap();
//        swap.test2();

        // 순차 정렬
//        SequentialSort sequentialSort = new SequentialSort();
//        sequentialSort.test();

        // 순차 정렬
//        SelectionSort selectionSort = new SelectionSort();
//        selectionSort.test();
        // 버블 정렬
//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.test();
        // 삽입 정렬
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.test();
    }
}
