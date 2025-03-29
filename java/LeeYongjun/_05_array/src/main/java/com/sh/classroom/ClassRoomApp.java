package com.sh.classroom;

public class ClassRoomApp {
    public static void main(String[] args) {
        String[] names = {"홍길도", "이순신", "유관순", "윤봉길", "장영실",
                "임꺽정","장보고","이태백","김정희","대조영","김유신","이사부"};

        String[][] seat1 = new String[3][2];
        String[][] seat2 = new String[3][2];

        int count = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++){
                seat1[i][j] = names[count];
                seat2[i][j] = names[count + 6];
                count++;
            }
        }
        System.out.println("==1분단==");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++){
                System.out.print(seat1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("==2분단==");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++){
                System.out.print(seat2[i][j] + " ");
            }
            System.out.println();
        }

    }
}
