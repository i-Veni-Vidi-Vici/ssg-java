package com.ssg.test.classroom;

public class ClassRoomApp {
    public static void main(String[] args) {
        String[] students = {"홍길동", "이순신", "유관순", "윤봉길", "장영실", "임꺽정", "장보고", "이태백", "김정희", "대조영", "김유신", "이사부"};
        String[][][] seat = new String[2][3][2]; //2개 3행 2열
        int idx = 0, div = 0, row = 0, col = 0; //인덱스값, 분단, 행, 열
        
        //할당
        for(div = 0; div< seat.length; div++){ // seat.length == 2 ( 분단 2개 )
            System.out.printf("=====  %d분단  =====\n", div+1);

            for(row = 0; row<seat[div].length; row++){ // div 분단 길이만큼 즉 2행
                for(col =0; col<seat[div][row].length; col++){ // div 행 길이만큼 즉 3열
                    seat[div][row][col] = students[idx++]; // 1차원 배열에 있는 값 전달
                    System.out.print(seat[div][row][col] + "\t\t");
                }
                System.out.println();
            }

            System.out.println();
        }

    }
}