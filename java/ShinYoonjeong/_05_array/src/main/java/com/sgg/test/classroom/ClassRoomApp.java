package com.sgg.test.classroom;

import java.util.Arrays;

public class ClassRoomApp {
    public void test()
    {
        String[] arr = {"홍길동","이순신", "유관순", "윤봉길",
    "장영실", "임꺽정", "장보고", "이태백", "김정희", "대조영", "김유신", "이사부"};
        String[][] arr1 = new String[3][2];
        String[][] arr2 = new String[3][2];
        for(int i=0;i<arr1.length;i++)
        {
            for(int j=0;j<arr1[i].length;j++)
            {
                arr1[i][j]=arr[i*2+j];
            }
        }
        for(int i=0;i<arr2.length;i++)
        {
            for(int j=0;j<arr2[i].length;j++)
            {
                arr2[i][j]=arr[(i+1)*2+j+4];
            }
        }
        System.out.println("===1분단===");
        for (String[] row : arr1) {
            for (String student : row) {
                System.out.print(student + " ");
            }
            System.out.println();
        }
        System.out.println("===2분단===");
        for (String[] row : arr2) {
            for (String student : row) {
                System.out.print(student + " ");
            }
            System.out.println();
        }





    }
}
