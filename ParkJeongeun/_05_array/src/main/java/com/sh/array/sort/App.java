package com.sh.array.sort;

public class App {
    public static void main(String[] args) {
        Swap swap = new Swap();
//        swap.test();
//        swap.test2();

        // 순차정렬
        SequentialSort sequentialSort = new SequentialSort();
//        sequentialSort.test();

        // 선택정렬
        SelectionSort selectionSort = new SelectionSort();
//        selectionSort.test();

        // 버블정렬

        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.test();

        // 삽입정렬
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.test();
    }
}
