package com.ssg.test.operator;

import java.sql.SQLOutput;

public class App2 {

    public static void print(String[] table){

        for(int i = 0; i < 4; ++i ){
            if(i==2){
                if(table[i].equals("M")) System.out.print("남자");
                else{
                    if(table[i].equals("M")) System.out.print("여자");
                }
            }
            else System.out.print(table[i]+" ");

        }
        System.out.println(" ");
    }


    public static void main(String[] args) {
        System.out.println("이 름  전화번호   성별  주소");

        System.out.println("----------------------------------------");

        String[] gildongTable = {"홍길동","01012341234","M","서울시 서초구 방배동"};

        String[] sinsaTable = {"신사임당","01044443333","F","경기도 남양주시 별내면"};
        print(gildongTable);
        print(sinsaTable);
    }

}
