package com.ssg.test.classroom;

public class ClassRoomApp {
    public static void main(String[] args) {
        String[] names = new String[]{"홍길동","이순신","유관순","윤봉길","장영실","임꺽정","장보고","이태백","김정희","대조영","김유신","이사부"};
        String[][] Team1 = new String[3][2];
        String[][] Team2 = new String[3][2];

        int k = 0;
        System.out.println("== 1분단 ==");
        for (int i = 0; i < Team1.length; i++){
            for (int j = 0; j < Team1[i].length;j++){
                Team1[i][j] = names[k++];
                System.out.print(Team1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        int l = 6;
        System.out.println("== 2분단 ==");
        for (int i = 0; i < Team2.length; i++){
            for (int j = 0; j < Team2[i].length;j++){
                Team2[i][j] = names[l++];
                System.out.print(Team2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
