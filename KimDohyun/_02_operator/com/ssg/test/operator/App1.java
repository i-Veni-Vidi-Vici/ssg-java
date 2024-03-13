package com.ssg.test.operator;

import java.sql.SQLOutput;

public class App1 {



    public static void main(String[] args) {
        int[] koreanScore = {80,95};
        int[] englishScore = {70,80};
        int[] mathScore = {90,100};
        boolean sucessFlag = false;
        if(koreanScore[0]>39 &&  englishScore[0] > 39 && mathScore[0] > 39) sucessFlag = true;
        System.out.println("홍길동 평균 = " + (koreanScore[0] + englishScore[0] + mathScore[0]) / 3);
        if(sucessFlag == true) System.out.println("홍길동 합격");
        else System.out.println("홍길동 불합격");
        sucessFlag = false;

        if(koreanScore[1]>39 &&  englishScore[1] > 39 && mathScore[1] > 39) sucessFlag = true;
        System.out.println("심사임당 평균 = " + (koreanScore[0] + englishScore[0] + mathScore[0]) / 3);
        if(sucessFlag == true) System.out.println("심사임당 합격");
        else System.out.println("심사임당 불합격");

    }

}
