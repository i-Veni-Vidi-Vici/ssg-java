package com.ssg.test.classroom;

import java.sql.SQLOutput;
import java.util.Arrays;

public class ClassRoomApp {
    public static void main(String[] args) {
        ClassRoomApp classRoomApp = new ClassRoomApp();
        classRoomApp.test5();
    }

    public void test5() {
        String[] studentList = {"홍길동", "이순신", "유관순", "윤봉길", "장영실", "임꺽정",
                                "장보고", "이태백", "김정희", "대조영", "김유신", "이사부"};
        String[][] class1 = new String[3][2];
        String[][] class2 = new String[3][2];


        int num = 0;
        // 1분단
        System.out.println("== 1분단 ==");
        for(int row = 0; row < class1.length; row++) {
            for(int col = 0; col < class1[row].length; col++) {
                class1[row][col] = studentList[num];
                num++;
                System.out.print(class1[row][col] + " ");
            }
            System.out.println();
        }

        // 2분단
        System.out.println("\n== 2분단 ==");
        for(int row = 0; row < class2.length; row++) {
            for(int col = 0; col < class2[row].length; col++) {
                class2[row][col] = studentList[num];
                num++;
                System.out.print(class2[row][col] + " ");
            }
            System.out.println();
        }
    }
}
