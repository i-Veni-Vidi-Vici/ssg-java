package com.ssg.test.array.sort;

public class App {
    public static void main(String[] args) {

        Swap swap=new Swap();
        //swap.test1();
        //swap.test2();

        // 순차정렬
        SequentialSort sequentialSort=new SequentialSort();
        //sequentialSort.test1();

        // 선택정렬
        SelectSort selectSort=new SelectSort();
        //sequentialSort.test1();

        //버블정렬
        BubbleSort bubbleSort= new BubbleSort();
        //bubbleSort.test1();

        //삽입정렬
        InsertionSort insertionSort=new InsertionSort();
        insertionSort.test1();


    }
}
