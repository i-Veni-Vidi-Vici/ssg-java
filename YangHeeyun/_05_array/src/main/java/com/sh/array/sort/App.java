package com.sh.array.sort;

import javax.swing.text.DefaultEditorKit;

public class App {
    public static void main(String[] args) {
        Swap swap = new Swap();
//        swap.test1();
//        swap.test2();

        // 순차정렬
//        SequentialSotrt sequentianSort = new SequentialSotrt();
//        sequentianSort.test();

        // 선택정렬
//        SelectionSort selectionSort = new SelectionSort();
//        selectionSort.test();
        //
//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.test();
        // 삽입정렬
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.test();

    }
}
