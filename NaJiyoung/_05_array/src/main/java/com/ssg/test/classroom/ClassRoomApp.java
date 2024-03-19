package com.ssg.test.classroom;

public class ClassRoomApp {
    public static void main(String[] args) {
        ClassRoomApp classRoom = new ClassRoomApp();
        classRoom.test();
    }

    public void test() {
        // 출석부
        String[] attendance = new String[]
        {"홍길동", "이순신", "유관순", "윤봉길", "장영실", "임꺽정", "장보고", "이태백", "김정희", "대조영", "김유신", "이사부"};
        String[][] division1 = new String[3][2];    // 1분단
        String[][] division2 = new String[3][2];    // 2분단

        System.out.println("== 1분단 ==");
        int n = 0;  // String 0번째 인덱스부터 시작
        for(int i=0; i<division1.length; i++) {
            for(int j=0; j<division1[i].length; j++) {
                division1[i][j] = attendance[n++];
                System.out.print(division1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("== 2분단 ==");
        n = 6;  // String 6번째 인덱스부터 시작
        for(int i=0; i<division2.length; i++) {
            for(int j=0; j<division2[i].length; j++) {
                division2[i][j] = attendance[n++];
                System.out.print(division2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
