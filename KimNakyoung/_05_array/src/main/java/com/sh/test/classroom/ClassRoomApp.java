package com.sh.test.classroom;

/**
 *
 * 1. 길이 12의 문자열 배열을 생성하여 12명의 학생들을 출석부 순으로 1차원 배열에 우선 할당하세요.
 * 2. 2열 3행 2차원 배열을 2개 할당하여 각 1분단 2분단이라고 칭합니다. 순차적으로  1분단 부터, 왼쪽부터 오른쪽, 1행에서 아래 행으로 번호 순으로 자리를 배치하고 출력하세요
 */
public class ClassRoomApp {
    public static void main(String[] args) {
        ClassRoomApp classRoomApp = new ClassRoomApp();
        classRoomApp.test1();

    }


    public void test1(){
        // 길이 12 문자열 생성
        String[] students = {"홍길동","이순신","유관순","윤봉길","장영실","임꺽정","장보고","이태백","김정희","대조영","김유신","이사부"};
        String[][] team1 = new String[3][2];
        String[][] team2 = new String[3][2];

        int studentIndex = 0;
        for (int i = 0; i < team1.length; i++) {
            for (int j = 0; j < team1[i].length; j++) {
                if(studentIndex < 6) {
                    team1[i][j] = students[studentIndex];
                    // 정원 6명
                }
                studentIndex++;

            }
        }
        for (int i = 0; i < team2.length; i++) {
            for (int j = 0; j < team2[i].length; j++) {
                if(studentIndex >= 6) {
                    team2[i][j] = students[studentIndex];
                    // 정원 6명
                }
                studentIndex++;

            }
        }



        System.out.println("== 1분단 ==");
        print(team1);
        System.out.println();
        System.out.println("== 2분단 ==");
        print(team2);
    }
    // 2차원 배열을 출력하는 print 메서드 추가
    public void print(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


}
