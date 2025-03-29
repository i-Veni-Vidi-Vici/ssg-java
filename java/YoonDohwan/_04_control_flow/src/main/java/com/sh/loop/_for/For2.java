package com.sh.loop._for;

public class For2 {
    public void test1() {
        for(int i=0;i<3;i++){
            System.out.println(i);
            for(int j=1;j<=3;j++){
                System.out.println("\t"+j);
            }
        }
    }
    public void test2(){
        for(int i=2;i<=9;i++){
            System.out.println("\t"+i+"단");
            for(int j=1;j<=9;j++){
                System.out.printf("%d * %d = %d\n",i,j,i*j);
            }
            System.out.println("\n");
        }
    }
    public void test3(){
        for(int dan =2 ; dan<=9; dan++){
            printEachDan(dan);
        }
    }
    public void printEachDan(int dan){
        for(int n=1;n<=9;n++){
            System.out.printf("%d * %d = %d\n",dan,n,dan*n);
        }

    }

    /**
     * 중첩반복문 - 행/열 표현하기
     * -outer loop-> 행
     * -inner loop ->열
     */
    public void test4(){
        //2행 3열
        //행
        for(int row = 0; row <2; row++){
            for(int col = 0; col<3; col++){
                System.out.printf(" (%d,%d )",row,col);
            }
            System.out.println();
        }

    }
    public void test5(){
        for(int row = 0; row<6; row ++){
            for(int col = 0; col<row; col++){
                System.out.print("★");
            }
            System.out.println();
        }
    }
    public void test6() {
        for (int row = 1; row <= 5; row++) {
            if (row % 2 == 1) {
                for (int col = 0; col < 3; col++) {
                    System.out.print("□");
                }
            } else{
                for (int col = 0; col < 1; col++) {
                    System.out.print("□");
                }

            }
            System.out.println();
        }

    }
}
