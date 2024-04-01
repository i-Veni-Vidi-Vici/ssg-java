package com.sh._04.checked;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int hour=sc.nextInt();
        int min=sc.nextInt();
        if(hour==0) {
            if (min > 45) {
                min += hour * 60 - 45;
                hour = min / 60;
                min -= hour * 60;
                System.out.printf("%d %d", hour, min);
            }
            else {
                hour = 24;
                min += hour * 60 - 45;
                hour = min / 60;
                min -= hour * 60;
                System.out.printf("%d %d", hour, min);

            }
        }
        else
        {
            min+=hour*60-45;
            hour=min/60;
            min-=hour*60;
            System.out.printf("%d %d",hour,min);
        }
    }
}
