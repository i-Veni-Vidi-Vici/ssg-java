package com.sh.array.sort;

public class App {
    public static void main(String[] args) {
        Swap swap = new Swap();
        //swap.test1();
        //swap.test2();

        //순차정렬
        SequentialSort seqSort = new SequentialSort();
        //seqSort.test();
        //버블정렬
        BubbleSort bs = new BubbleSort();
        //bs.test();
        //삽입정렬

        InsertionSort is = new InsertionSort();
        is.test();
    }
}
