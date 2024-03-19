package com.ssg.test.multi.dimentional.array;

public class MultiDimentionalArray {

	public static void main(String[] args) {
		MultiDimentionalArray a  = new MultiDimentionalArray();
		a.test1();
		a.test2();
		a.test3();
		a.test4();
	}

	/**
	 * 1 2 3 4
	 * 5 6 7 8
	 * 9 10 11 12
	 * 13 14 15 16
	 *
	 */
	public void test1() {
		int[][] arr = new int[4][4];
		int k = 1;
		for(int i=0;i<arr.length;i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = k++;
			}
		}
		print(arr);
	}

	/**
	 * 1 5 9 13
	 * 2 6 10 14
	 * 3 7 11 15
	 * 4 8 12 16
	 *
	 */
	public void test2() {
		int[][] arr = new int[4][4];
		int k=1;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[j][i] = k++;
			}
		}
		print(arr);
	}

	/**
	 * 4 3 2 1 
	 * 8 7 6 5 
	 * 12 11 10 9 
	 * 16 15 14 13 
	 */
	public void test3() {
		int[][] arr = new int[4][4];
		int k = 1;
		for(int i=0; i< arr.length; i++) {
			for(int j=arr[i].length-1; j>=0; j--) {
				arr[i][j] = k++;
			}
		}
		
		print(arr);
	}

	/**
	 * 16 12 8 4
	 * 15 11 7 3
	 * 14 10 6 2
	 * 13 9 5 1
	 */
	public void test4() {
		int[][] arr = new int[4][4];
		int k = 1;
		for(int i=arr.length-1; i>=0; i--) {
			for(int j=arr[i].length-1; j>=0; j--) {
				arr[j][i] = k++;
			}
		}
		print(arr);
	}


	
	public void print(int[][] arr){
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
