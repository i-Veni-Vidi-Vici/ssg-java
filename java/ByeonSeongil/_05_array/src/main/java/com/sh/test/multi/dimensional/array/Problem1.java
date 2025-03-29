package com.sh.test.multi.dimensional.array;

public class Problem1 {
    public void test() {
        int[][] numbers = new int[4][4];
        MultiDimensionalArray multiDimensionalArray = new MultiDimensionalArray();

        int count =1;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = count++;
            }
        }

        multiDimensionalArray.print(numbers);

    }
}
