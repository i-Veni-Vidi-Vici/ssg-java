package com.ssg.test.multi.dimentional.array.test;

public class Sample {
    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.exercise1();
        sample.exercise2();
    }

    public void exercise1(){
        int[][] arr = new int[3][5];
        for(int i= 0; i< arr.length;i++){
            for(int j =0; j<arr[i].length; j++){
                arr[i][j] = (int)(Math.random()*100)+1;
            }
        }
        for(int i= 0; i< arr.length;i++){
            for(int j =0; j<arr[i].length; j++){
                if(arr[i][j]%5==0) System.out.println(arr[i][j] + " ( " + i + " , "+j+" )");
            }
        }
        System.out.println();

    }

    public void exercise2(){
        int[][] arr = new int[4][4];
        for(int i =0; i<arr.length; i++){
            for(int j =0; j<arr[i].length; j++){
                if(i== arr.length-1 && j== arr[i].length-1)break;
                else if(j==arr[i].length-1){
                    int sum=0;
                    for(int t = 0; t< arr[i].length-1; t++){
                        sum += arr[i][t];
                    }
                    arr[i][j] = sum;
                } else if(i==arr.length-1){
                    int sum=0;
                    for(int t = 0; t< arr.length-1; t++){
                        sum += arr[t][j];
                    }
                    arr[i][j] = sum;

                } else{
                    arr[i][j] = (int)(Math.random()*100)+1;
                }
            }

        }

        for(int i =0; i< arr.length; i++){
            for(int j=0; j< arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
