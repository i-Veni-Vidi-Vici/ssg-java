package com.sh.array.sort;


/**
 *
 * <pre>
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        Swap swap = new Swap();
//        swap.test1();
//        swap.test2();

        // 순차정렬
        SequencetialSort sequencetialSort = new SequencetialSort();
//        sequencetialSort.test();
//
//        // 선택정렬 O(n^2)
        SelectionSort selectionSort = new SelectionSort();
//        sequencetialSort.test();


        // 버블정렬 O(n^2)

        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.test();





        // 삽입정렬 O(n^2)

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.test();

    }

}
