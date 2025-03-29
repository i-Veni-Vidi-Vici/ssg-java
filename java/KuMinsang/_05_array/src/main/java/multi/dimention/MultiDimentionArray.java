package multi.dimention;

public class MultiDimentionArray {
    public void test2() {
        int[][] arr = new int[3][2];

        arr[0][0] = 100;
        arr[0][1] = 200;
        arr[1][0] = 300;
        arr[1][1] = 400;
        arr[2][0] = 500;
        arr[2][1] = 600;

        //값 출력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++)
                System.out.println(arr[i][j]);
        }

    }   //end of test2()

    /**
     * 학생들의 점수 데이터가 다음과 같을 때 출력?
     */
    public void test3() {
        int[][] score = new int[3][4];
        score[0][0] = 90;
        score[0][1] = 70;
        score[0][2] = 55;
        score[0][3] = 80;
        score[1][0] = 100;
        score[1][1] = 95;
        score[1][2] = 100;
        score[1][3] = 50;
        score[2][0] = 80;
        score[2][1] = 75;
        score[2][2] = 90;
        score[2][3] = 99;

        System.out.println("  국  영  수  자  ");

        for(int i=0; i<3; i++){
            System.out.print((char)('A'+i));
            for(int j=0; j<4; j++){
                System.out.print(" "+score[i][j]+" ");
            }
            System.out.println();
        }

    }

    public void test4(){
        //배열변수 선언 + 1차원 배열 할당 + 2차원배열 할당 + 2차원배열의 인덱스별 값대입
        int[][] nums = {
                {1,2,3},
                {4,5,6}
        };
    }
}
