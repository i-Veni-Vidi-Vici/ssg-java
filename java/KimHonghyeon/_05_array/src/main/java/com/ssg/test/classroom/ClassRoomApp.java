package com.ssg.test.classroom;

public class ClassRoomApp {
    public static void main(String[] args) {
        String[] students = {"홍길동", "이순신", "유관순", "윤봉길", "장영실", "임꺽정", "장보고", "이태백", "김정희", "대조영", "김유신", "이사부"};
        String[][][] seat = new String[2][3][2];
        int idx = 0;
        //할당
        for(int division = 0; division< seat.length; division++){
            for(int row = 0; row<seat[division].length; row++){
                for(int col =0; col<seat[division][row].length; col++){
                    seat[division][row][col] = students[idx++];
                }
            }
        }
        //출력
        for(int division = 0; division< seat.length; division++){
            System.out.printf("======%d분단======\n", division+1);
            for(int row = 0; row<seat[division].length; row++){
                for(int col =0; col<seat[division][row].length; col++){
                    System.out.print(seat[division][row][col] + " ");
                }
                System.out.println();
            }
        }
    }
}
