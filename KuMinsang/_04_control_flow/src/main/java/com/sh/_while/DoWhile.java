package com.sh._while;

import java.util.Scanner;

public class DoWhile {
    public void test(){
        Scanner sc = new Scanner(System.in);
        String str;
        do{
            System.out.println("문자열을 입력하세요. (중지하려면 exit) : ");
            str = sc.nextLine();
            System.out.println("> " + str);
        }while(!str.equals("exit"));

    }
}
