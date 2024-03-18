package com.sh.array.sort;

public class App {
    public static void main(String[] args) {
        Swap swap = new Swap();
        // swap.test1();
        // swap.test2();

        // 순차 정렬
        SequentialSort sequentialSort = new SequentialSort();
        // sequentialSort.test1();

        // 선택 정렬
        SelectionSort selectionSort = new SelectionSort();
        // selectionSort.test1();

        // 버블 정렬
        BubbleSort bubblesort = new BubbleSort();
        // bubblesort.test1();

        // 삽입 정렬
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.test1();
    }
}
