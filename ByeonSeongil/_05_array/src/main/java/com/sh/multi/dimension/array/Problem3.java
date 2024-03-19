package com.sh.multi.dimension.array;

public class Problem3 {
    public void test() {
        int[][] numbers = new int[4][4];
        MultiDimensionalArray multiDimensionalArray = new MultiDimensionalArray();
        int count = 1;

        for (int i = 0; i <4; i++) {
            for (int j = 3; j >=0; j--) {
                numbers[i][j] = count ++;
            }
        }

        multiDimensionalArray.print(numbers);
    }
}
