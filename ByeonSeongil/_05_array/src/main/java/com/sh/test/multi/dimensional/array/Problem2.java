package com.sh.test.multi.dimensional.array;

public class Problem2 {
    public void test() {
        int[][] numbers = new int[4][4];
        MultiDimensionalArray multiDimensionalArray = new MultiDimensionalArray();

        int count =1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                numbers[j][i] = count ++;
            }
        }

        multiDimensionalArray.print(numbers);
    }
}
