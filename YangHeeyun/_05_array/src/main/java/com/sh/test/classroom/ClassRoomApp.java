package com.sh.test.classroom;

public class ClassRoomApp {
    public static void main(String[] args){
        ClassRoomApp cra = new ClassRoomApp();
        cra.test5();
    }

    /**
     * 1. 길이 12의 문자열 배열을 생성하여 12명의 학생들을 출석부 순으로 1차원 배열에 우선 할당하세요.
     * 2. 2열 3행 2차원 배열을 2개 할당하여 각 1분단 2분단이라고 칭합니다. 순차적으로  1분단 부터, 왼쪽부터 오른쪽, 1행에서 아래 행으로 번호 순으로 자리를 배치하고 출력하세요
     * 출석부는 다음과 같습니다.
     * -- 출석부 --        출력예시
     * 1. 홍길동         == 1분단 ==
     * 2. 이순신         홍길동 이순신
     * 3. 유관순         유관순 윤봉길
     * 4. 윤봉길         장영실 임꺽정
     * 5. 장영실
     * 6. 임꺽정         == 2분단 ==
     * 7. 장보고         장보고 이태백
     * 8. 이태백         김정희 대조영
     * 9. 김정희         김유신 이사부
     * 10. 대조영
     * 11. 김유신
     * 12. 이사부
     */
    private void test5() {
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

        String[][] first = new String[3][2];
        String[][] second = new String[3][2];
        int indexNum = 0;
        System.out.println("== 1분단 ==");
        for(int i=0;i<first.length;i++){
            for(int j=0;j<first[i].length;j++){
                first[i][j] = students[indexNum++];
                System.out.print(first[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("== 2분단 ==");
        for(int i=0;i<second.length;i++){
            for(int j=0;j<second[i].length;j++){
                second[i][j] = students[indexNum++];
                System.out.print(second[i][j]+" ");
            }
            System.out.println();
        }
    }

}
