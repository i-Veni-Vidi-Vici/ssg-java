package com.sh.test.classroom;

public class ClassRoomApp {
    public static void main(String[] args) {
        String[] name = new String[12];
        name[0] = "홍길동";
        name[1] = "이순신";
        name[2] = "유관순";
        name[3] = "윤봉길";
        name[4] = "장영실";
        name[5] = "임꺽정";

        name[6] = "장보고";
        name[7] = "이태백";
        name[8] = "김정희";
        name[9] = "대조영";
        name[10] = "김유신";
        name[11] = "이사부";

        String[][] arr = new String[6][2];
        int k = 0;
        System.out.println(" ==1분단 ==");
        for(int i =0; i<arr.length; i++) // i : 0-5 ->
        {
            for(int j = 0; j<arr[i].length; j++){
                arr[i][j] = name[k++];  //0 0 = 0 01 = 1
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
            if(i==2) System.out.println("== 2분단 ==");

        }



    }
}
