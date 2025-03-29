package com.sh.test.classroom;

/**
 * 1. 길이 12의 문자열 배열을 생성하여 12명의 학생들을 출석부 순으로 1차원 배열에 우선 할당하세요.
 * 2. 2열 3행 2차원 배열을 2개 할당하여 각 1분단 2분단이라고 칭합니다.
 * 순차적으로  1분단 부터, 왼쪽부터 오른쪽, 1행에서 아래 행으로 번호 순으로 자리를 배치하고 출력하세요
 */
public class ClassRoomApp {
    public static void main(String[] args) {
        String[] arr = {"홍길동","이순신", "유관순","윤봉길","장영실", "임꺽정", "장보고", "이태백","김정희","대조영","김유신","이사부"};
        String[][] group1 = new String[3][2];
        String[][] group2 = new String[3][2];

        //1분단 복사
        for(int i =0 ; i<group1.length;i++){
            System.arraycopy(arr, i*2, group1[i], 0, 2);
            System.arraycopy(arr, 6+i*2, group2[i], 0, 2);
        }

        System.out.println("====1분단=====");
        for(int i = 0; i<group1.length; i++){
            for(int j=0; j<group1[i].length; j++)
                System.out.print(group1[i][j] + " ");
            System.out.println();
        }
        System.out.println("====2분단=====");
        for(int i = 0; i<group1.length; i++){
            for(int j=0; j<group1[i].length; j++)
                System.out.print(group2[i][j] + " ");
            System.out.println();
        }




    }
}
