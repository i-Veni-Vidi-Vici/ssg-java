package com.ssg.api.member.run;

import com.ssg.api.member.model.vo.member.Member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Run {

    public static void main(String[] args) {
        Member[] members = new Member[3];

        LocalDate birth1 = LocalDate.parse("19900905",DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDate birth2 = LocalDate.parse("19850818",DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDate birth3 = LocalDate.parse("19810319",DateTimeFormatter.ofPattern("yyyyMMdd"));

        members[0] = new Member(1,"김연아",165,47,birth1);
        members[1] = new Member(2,"양세형",167,60,birth2);
        members[2] = new Member(3,"김래원",180,80,birth3);

        for(Member member : members){
            if(member != null){
                System.out.printf("%d %s %d %d %s ",member.getMemberNo(),
                        member.getMemberName(),member.getHeight(),member.getWeight(),member.getBirth());
            }
        }

    }
}
