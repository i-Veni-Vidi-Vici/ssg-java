package com.sh.test.classroom;

public class ClassRoomApp {
    public static void main(String[] args) {

        String[] names = {"홍길도", "이순신", "유관순", "윤봉길", "장영실",
                "임꺽정","장보고","이태백","김정희","대조영","김유신","이사부"};

        String[][] sitNames=new String[3][2];
        String[][] sitNames1=new String[3][2];

        int cnt=0;


        for(int i=0;i<3;i++)
        {
            for(int j=0;j<2;j++)
            {
                sitNames[i][j]=names[cnt];
                sitNames1[i][j]=names[cnt+6];
                cnt++;
            }
        }
        System.out.println("  ===1분단===");
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<2;j++)
            {
                System.out.printf(" %s", sitNames[i][j]);
            }
            System.out.println();
        }

        System.out.println("  ===2분단===");
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<2;j++)
            {
                System.out.printf(" %s", sitNames1[i][j]);
            }
            System.out.println();
        }
    }
    //문제5


}
