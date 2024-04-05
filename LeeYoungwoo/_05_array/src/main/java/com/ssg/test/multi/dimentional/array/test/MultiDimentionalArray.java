package com.ssg.test.multi.dimentional.array.test;

import java.util.Arrays;
import java.util.Random;

public class MultiDimentionalArray {
    public static void main(String[] args) {
        MultiDimentionalArray m = new MultiDimentionalArray();
//        m.test1();
//        m.test2();
//        m.test3();
//        m.test4();
//        m.test5();
        m.test6();

    }

    public void test1() {
        int[][] arr = new int[4][4];
        int sum = 1;
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sum++;
            }
        }
        print(arr);
    }

    public void test2() {
        int[][] arr = new int[4][4];
        int sum = 1;
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++) {
                arr[j][i] = sum++;
            }
        }
        print(arr);
    }

    public void test3() {
        int[][] arr = new int[4][4];
        int sum = 1;
        for(int i = 0; i < arr.length; i++){
            for(int j = arr[i].length - 1; j >= 0; j--){
                arr[i][j] = sum++;
            }
        }
        print(arr);
    }

    public void test4() {
        int[][] arr = new int[4][4];
        int sum = 1;
        for(int i = 3; i >= 0; i--) {
            for(int j = arr[i].length - 1; j >= 0; j--) {
                arr[j][i] = sum++;
            }
        }
        print(arr);
    }

    public void print(int[][] arr){
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void print2(String[][] arr){
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void test5() {
        // 출석부 배열 생성
        String[] arr = {"홍길동", "이순신", "유관순", "윤봉길", "장영실", "임꺽정",
                "장보고", "이태백", "김정희", "대조영", "김유신", "이사부"};

        // 1분단 배열 생성 및 값 할당
        System.out.println("==1분단==");
        String[][] _1stArr = new String[3][2];
        int m = 0; // arr의 0번째 인덱스 값부터 뽑아 1분단 배열에 넣기 위해 변수 생성
        for(int i = 0; i < _1stArr.length; i++){
            for(int j = 0; j <_1stArr[i].length; j++){
                _1stArr[i][j] = arr[m++];
            }
        }
        print2(_1stArr);

        // 2분단 배열 생성 및 값 할당
        System.out.println("==2분단==");
        String[][] _2stArr = new String[3][2];
        int n = 6; // arr의 6번째 인덱스 값부터 뽑아 2분단 배열에 넣기 위해 변수 생성
        for(int i = 0; i < _2stArr.length; i++){
            for(int j = 0; j <_2stArr[i].length; j++){
                _2stArr[i][j] = arr[n++];
            }
        }
        print2(_2stArr);
    }

    /**
     * 로또 번호 자동 생성기 프로그램을 작성하세요.
     * 단, 중복 값이 있으면 안되고, 오름차순으로 정렬하여 출력하세요.
     *  Random클래스 사용 혹은 Math.random() 사용합니다.
     */
    public void test6() {
        Random rnd = new Random();
        int[] lottoArr = new int[6];

        System.out.println("로또 번호 자동 생성 프로그램...");
        int num;
        for(int i = 0; i < lottoArr.length; i++){
            lottoArr[i] = rnd.nextInt(1,46);
            if(lottoArr[i] == lottoArr[i + 1]) {
                // 다시 뽑기
            }

            System.out.print(lottoArr[i] + " ");
            // 이제 중복을 없애고 오름차순 정렬 해야됨
            // -> 오름차순 정렬하면서 비교할 값 두개가 같으면 젤 첫번째 for문으로 돌아오는 거 만들기
        }

    }
}

