package com.sh.test.classroom;

public class ClassRoomApp {
    public void test() {
        // 크기가 12인 문자열 배열 선언 및 생성
        String[] names = {"홍길동", "이순신", "유관순", "윤봉길", "장영실", "임꺽정", "장보고", "이태백", "김정희", "대조영", "김유신", "이사부"};

        // 3행 2열 2차원 배열
        String[][] first = new String[3][2];
        String[][] second = new String[3][2];

        // 1분단 배열에 대입
        int index = 0;
        for(int i = 0; i < first.length; i++) {
            for(int j = 0; j < first[i].length; j++) {
                first[i][j] = names[index++];
            }
        }

        // 2분단 배열에 대입
        for(int i = 0; i < second.length; i++) {
            for(int j = 0; j < second[i].length; j++) {
                second[i][j] = names[index++];
            }
        }

//        // 1분단 배열 출력
//        System.out.println("== 1분단 ==");
//        for(int i = 0; i < first.length; i++) {
//            for(int j = 0; j < first[i].length; j++) {
//                System.out.print(first[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//
//        // 2분단 배열 출력
//        System.out.println("== 2분단 ==");
//        for(int i = 0; i < second.length; i++) {
//            for(int j = 0; j < second[i].length; j++) {
//                System.out.print(second[i][j] + " ");
//            }
//            System.out.println();
//        }

        // 1분단 배열 출력
        System.out.println("== 1분단 ==");
        printArray(first);

        System.out.println();

        // 2분단 배열 출력
        System.out.println("== 2분단 ==");
        printArray(second);
    }

    // 배열 출력 메소드
    public void printArray(String[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
