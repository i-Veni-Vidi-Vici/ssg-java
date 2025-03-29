package multi.dimention;

import java.util.Scanner;

/**
 * <pre>
 *     가변배열
 *     - 2차원 배열은 자료형이 같은 1차원 배열의 묶음이다
 *     - 이때 배열의 크기가 꼭 같을 필요는 없다
 *     - 2차원 배열의 크기가 다른 경우 이를 가변배열, 같은 경우 정변배열이라 부른다.
 *
 * </pre>
 *
 */
public class JaggedArray {
    public void test1(){

    }

    /**
     * 사용자로부터 행수를 입력 받아서 다음과 같이 출력 (적절한 크기의 가변배열을 생성)
     * 1
     * 2  3
     * 4  5  6
     * 7  8  9  10
     * 11 12 13 14 15
     */
    public void test2(){

        Scanner sc = new Scanner(System.in);
        System.out.print("몇행 이온지? : ");
        int row = sc.nextInt();
        int [][] arr = new int[row][];
        for(int i = 0; i<row; i++){
            arr[i] = new int[i+1];
        }

        int cnt = 1;
        for(int i = 0; i<row; i++){
            for(int j =0; j<=i; j++){
                arr[i][j] = cnt++;
                System.out.print(arr[i][j] + " ");
                if(cnt<=10)
                    System.out.print(" ");
            }
            System.out.println();
        }


    }
}
