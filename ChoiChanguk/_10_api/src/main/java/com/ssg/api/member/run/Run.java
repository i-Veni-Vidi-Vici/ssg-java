package com.ssg.api.member.run;

import com.ssg.api.member.model.vo.Member;

import java.util.Arrays;

public class Run {
    public static void main(String[] args) {
        String infor="1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";
        Member[] members=new Member[3];

        String[] tempResult=infor.split("[|]");
        String[] result=new String[3];
        System.out.println(tempResult.toString());

        for(int i=0;i<3;i++)
        {
            members[i]=new Member(tempResult[i].split("[,]"));
        }

        for(int i=0;i<tempResult.length;i++)
            System.out.println(tempResult[i]);


    }

}
