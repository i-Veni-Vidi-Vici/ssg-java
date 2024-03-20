package com.sh.test.classroom;

public class ClassRoomApp {
    public void test() {
        String[] students = {"홍길동", "이순신", "유관순", "윤봉길",
                "장영실", "임꺽정", "장보고", "이태백",
                "김정희", "대조영", "김유신", "이사부"};

        String[][] oneSection = new String[3][2];
        String[][] twoSection = new String[3][2];

        int index1 = 0;
        int index2 = students.length/2;
        for (int i = 0; i < oneSection.length; i++) {
            for (int j = 0; j < oneSection[i].length; j++) {
                oneSection[i][j] = students[index1++];
                twoSection[i][j] = students[index2++];
            }
        }

        for (int i = 0; i < oneSection.length; i++) {
            for (int j = 0; j < oneSection[j].length; j++) {
                System.out.print(oneSection[i][j]);
            }
            System.out.println();
        }

        System.out.println("=========================");

        for (int i = 0; i < twoSection.length; i++) {
            for (int j = 0; j < twoSection[j].length; j++) {
                System.out.print(twoSection[i][j]);
            }
            System.out.println();
        }



    }
}
