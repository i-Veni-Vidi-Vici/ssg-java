package com.sh.test.lotto;

public class LottoApp {
    public static void main(String[] args) {
        //로또 오름차순, 중복 x

        int[] arr=new int[50];

        int number;
        int check=0;
        int j=0;
        int temp;

        start:while(true)
        {
            number=(int)(Math.random()*50)+1;

            for(int i=0;i<j;i++)
            {
                if(arr[i]==number)
                    continue start;
            }
            arr[j]=number;
            j++;
            if(j==50)
                break;
        }

        for(int i=0;i<arr.length;i++)
        {
            for(int k=0;k<arr.length-1;k++)
            {
                if(arr[k]>arr[k+1])
                {
                    temp=arr[k];
                    arr[k]=arr[k+1];
                    arr[k+1]=temp;
                }

            }
        }

        for(int i=0;i<50;i++)
        {
            System.out.printf(" %d",arr[i]);
        }
    }

}
