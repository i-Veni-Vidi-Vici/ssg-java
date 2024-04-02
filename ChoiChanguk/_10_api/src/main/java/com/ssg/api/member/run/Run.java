package com.ssg.api.member.run;

import com.ssg.api.member.model.vo.Member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Run {
    public static void main(String[] args) {
        String infor="1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";
        Member[] members=new Member[3];

        String[] tempResult=infor.split("[|]");
        String[] result;


        for(int i=0;i<3;i++)
        {
            result=tempResult[i].split("[,]");
            members[i]=new Member(Integer.parseInt(result[0]),result[1],Integer.parseInt(result[2]),
                    Integer.parseInt(result[3]), LocalDate.parse(result[4],DateTimeFormatter.ofPattern("yyyyMMdd")));
        }

        for(int i=0;i<3;i++)
            System.out.println(members[i].information());;


    }

}
