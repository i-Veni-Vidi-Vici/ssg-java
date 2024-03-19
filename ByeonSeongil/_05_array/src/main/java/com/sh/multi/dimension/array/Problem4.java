package com.sh.multi.dimension.array;

public class Problem4 {
    public void test() {
        int[][] numbers = new int[4][4];
        MultiDimensionalArray multiDimensionalArray = new MultiDimensionalArray();

        int count = 1;
        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j>=0 ; j--) {
                numbers[j][i] = count++;
            }
        }

        multiDimensionalArray.print(numbers);
    }
}
