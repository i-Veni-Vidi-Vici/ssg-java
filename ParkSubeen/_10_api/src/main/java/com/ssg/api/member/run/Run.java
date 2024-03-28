package com.ssg.api.member.run;

import com.ssg.api.member.model.vo.Member;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Run {
    public static void main(String[] args) {
        String mem = "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";
        StringTokenizer member = new StringTokenizer(mem, "|");
        Member[] memberList = new Member[member.countTokens()];

        for(int i = 0; i < memberList.length; i++) {
            String[] str = member.nextToken().split(",");
            memberList[i] = new Member(str);
            System.out.println(memberList[i].information());
        }
    }
}
