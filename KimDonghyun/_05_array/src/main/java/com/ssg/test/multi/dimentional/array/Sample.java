package com.ssg.test.multi.dimentional.array;

import java.util.Arrays;
import java.util.Scanner;

public class Sample {

	public static void main(String[] args) {
		Sample s = new Sample();
		s.exercise1();
		s.exercise2();
	}

	/**
	 * 
     * 1. 3행짜리5열 2차원배열 선언 및 생성
     * 2. 1~100사이의 임의의 정수를 모든 방에 기록함
     * 3. 열의 값이 5의 배수인 경우만 값(행,열) 출력함
	 * 
	 */
	private void exercise1() {
		
		int[][] arr = new int[3][5];
		
		//값쓰기 및 5의 배수 검사
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int)(Math.random()*100)+1;

				if(arr[i][j] % 5 == 0){
						System.out.printf("%d(%d, %d)%n", arr[i][j], i, j);
				}
			}
		}
	}

	/**
	 * 1. 4행4열 2차원배열 선언 및 생성
	 * 2. 0행0열부터 2행2열까지 1부터 100사이의 임의의 정수값 기록해 넣음
	 * 3. 아래의 내용처럼 처리함
     * 
     * <li> 	0열	1열	2열	3열</li>	
     * <li>0행	값	값	값 	0행 값들의 합계</li>
     * <li>1행	값	값	값	1행 값들의 합계</li>
     * <li>2행	값	값	값	2행 값들의 합계</li>
     * <li>3행	0열합계	1열합계	2열합계	</li>
	 * 
	 * 
	 */
	private void exercise2() {
		int[][] arr = new int[4][4];
		int col0Sum = 0;
		int col1Sum = 0;
		int col2Sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			//행마다 초기화되어야 하므로, inner loop이전에 작성
			int rowSum = 0;
			
			for(int j=0; j<arr[i].length; j++) {
				//0 1 2행인 경우
				if(i != arr.length-1) {
					int rnd = (int)(Math.random()*100)+1;
					//0 1 2열인 경우
					if(j != arr[i].length-1) {
						arr[i][j] = rnd;
						rowSum += rnd;
						//세로합을 위한 처리
						switch(j) {
						case 0: col0Sum += rnd; break;
						case 1: col1Sum += rnd; break;
						case 2: col2Sum += rnd; break;
						}
						
					}
					//3열인 경우 합계대입
					else {
						arr[i][j] = rowSum;
					}
				}
				//3행인 경우
				else {
					switch(j) {
					case 0: arr[i][j] = col0Sum; break;
					case 1: arr[i][j] = col1Sum; break;
					case 2: arr[i][j] = col2Sum; break;
					}
				}
				//System.out.printf("%d ", arr[i][j]);
			}
			//System.out.println();
		}
	
		//값읽기
		String header = "\t0열\t1열\t2열\t3열\n"
					  + "-----------------------------------------------------------";
		System.out.println(header);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i+"행\t");
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
