package com.sh.array.sort;

public class App {
    public static void main(String[] args) {
        Swap swap = new Swap();
//        swap.test1();
//        swap.test2();

        // 순차정렬
        SequentialSort  sequentialSort = new SequentialSort();
//        sequentialSort.sequentialSort();

        // 선택정렬
        SelectionSort selctionsort = new SelectionSort();
        selctionsort.test();

        // 버블정렬
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.test();

        // 삽입정령
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.test();

    }
}
