package com.ssg.api.string;

import java.util.Scanner;
import java.util.ServiceConfigurationError;

public class StringTest {
    public static void main(String[] args) {
        StringProcess sp=new StringProcess();
        Scanner sc=new Scanner(System.in);

//        System.out.printf("문자를 입력 하세요 : ");
        String result = "eawadasfe";
        System.out.println(sp.preChar(result));

        //System.out.printf("문자열을 입력 하세요 : ");
        String stan="asdfaefadsfaefffasdawff";

        //System.out.printf("찾을 문자를 입력하세요 : ");
        char ch='f';

        int num=sp.charSu(stan,ch);
        System.out.println(num);
    }
}
