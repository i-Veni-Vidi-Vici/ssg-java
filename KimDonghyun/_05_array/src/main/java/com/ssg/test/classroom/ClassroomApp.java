package com.ssg.test.classroom;

public class ClassroomApp {
    public static void main(String[] args) {
        String student[] = {"홍길동", "이순신", "유관순", "윤봉길", "장영실", "임꺽정", "장보고", "이태백", "김정희", "대조영", "김유신", "이사부"};
        String part1[][] = new String[3][2];
        String part2[][] = new String[3][2];

        int cnt = 0;

        for(int i = 0; i < part1.length; i++) {
            for(int j = 0; j < part1[i].length; j++) {
                part1[i][j] = student[cnt];
                cnt++;
            }
        }

        for(int i = 0; i < part2.length; i++) {
            for(int j = 0; j < part2[i].length; j++) {
                part2[i][j] = student[cnt];
                cnt++;
            }
        }

        System.out.println("== 1분단 ==");
        for(int i = 0; i < part1.length; i++) {
            for(int j = 0; j < part1[i].length; j++) {
                System.out.print(part1[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("== 2분단 ==");
        for(int i = 0; i < part2.length; i++) {
            for(int j = 0; j < part2[i].length; j++) {
                System.out.print(part2[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
