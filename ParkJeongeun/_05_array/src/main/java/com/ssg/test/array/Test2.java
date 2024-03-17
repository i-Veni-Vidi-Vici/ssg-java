package com.ssg.test.array;

public class Test2 {
    public static void main(String[] args) {
        String[] arr = new String[]{"딸기", "복숭아", "키위", "사과", "바나나"};
        for (int i = 0; i < arr.length; i++){
            if (arr[i].equals("바나나")){
                System.out.println(arr[i]);
            }
        }
    }
}
