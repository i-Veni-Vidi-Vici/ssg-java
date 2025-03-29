package com.sh.array;

import java.util.Scanner;

public class Array2 {

    /**
     *
     *
     *배열
     * 관련있고 동일한 자료형의 데이터를 처리하는데 적합
     * 점수데이터 이름데이터 등
     */



    public void test1(){
        // 국어 90, 영어 85, 수학 55 -> 총점/평균
        int[] scores = new int[] {90, 85, 55};

//        int[] scores = new int[3];
//        scores[0] =

        //총점 - 각번지수의 점수를 sum 변수에 누적한다.
        int sum = 0;
//        sum += scores[0];
//        sum += scores[1];
//        sum += scores[2];

        for(int i = 0; i < scores.length; i ++){
            sum += scores[i];

        }
        System.out.println("총점 = " + sum);
        double avg = (double) sum / scores. length;
        System.out.printf("평균 : %.1f " , avg); // printf 로 반올림처리 가능함 .1f면 첫째 .2f면 둘째
    }

    /**
     * 학생 3명의 자바 점수를 입력받고, 평균점수를 출력
     * -int [] 사용
     */
    public void test2(){
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[3];
        int sum = 0;
        //배열의 크기는 처음에 반드시 지정되어야 함. 배열 할당시에 지정해야하고, 변경할 수 없다.
        //int[] scores = new int [] 이렇게 비워둘 순 없음
    for(int i = 0; i < scores.length; i++){
        System.out.println("학생" + (i + 1) + "점수 입력 :");
        scores[i] = sc.nextInt();
        sum += scores[i];
    }



        double avg = (int)sum / scores.length;
        System.out.println("평균은 점수는 %.1f입니다 \n"+  sum/ 3.0);
    }


public void test3(){
        char[] alphabets = new char[26];  //배열 선언, 배열객체 할당
//        alphabets[0] = 'a';
//        alphabets[1] = 'b';
//        alphabets[2] = 'c';
//        alphabets[3] = 'd';
//        alphabets[4] = 'e';
//       //...
//        alphabets[25] = 'z';

    // 값대입
    for(int i = 0; i < alphabets.length; i++){  //알파벳을 배열에 할당
        alphabets[i] = (char) (i + 'a'); // if( i !=0) sout print(", ") 위에다 해도됨 , 여기서 (i + a)가 정수형이므로 문자형으로 형변환하여 배열에 할당하기 위해 (char ) 사용함
//규칙이 있기 때문에 가능
    }
    // 값조회
    for (int i = 0; i < alphabets.length; i ++){
        System.out.print(alphabets[i]);
        if(i != alphabets.length - 1){
            System.out.print(", ");
        }

    }
}


}

