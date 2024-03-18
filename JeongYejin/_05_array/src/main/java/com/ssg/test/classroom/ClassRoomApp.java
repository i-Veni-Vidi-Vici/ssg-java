package com.ssg.test.classroom;

public class ClassRoomApp {
    public static void main(String[] args) {
        String[] students = new String[12];

        students[0] = "홍길동";
        students[1] = "이순신";
        students[2] = "유관순";
        students[3] = "윤봉길";
        students[4] = "장영실";
        students[5] = "임꺽정";
        students[6] = "장보고";
        students[7] = "이태백";
        students[8] = "김정희";
        students[9] = "대조영";
        students[10] = "김유신";
        students[11] = "이사부";

        String[][] firstDivide = new String[3][2];
        String[][] secondDivide = new String[3][2];
        int no = 0;
        System.out.println("== 1분단 ==");
        for (int i = 0; i < firstDivide.length; i++) {
            for (int j = 0; j < firstDivide[i].length; j++) {
                firstDivide[i][j] = students[no++];
                System.out.print(firstDivide[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("== 2분단 ==");
        for (int i = 0; i < secondDivide.length; i++) {
            for (int j = 0; j < secondDivide[i].length; j++) {
                secondDivide[i][j] = students[no++];
                System.out.print(secondDivide[i][j] + " ");
            }
            System.out.println();
        }
    }
}
