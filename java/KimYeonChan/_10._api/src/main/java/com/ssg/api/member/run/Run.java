package com.ssg.api.member.run;

import com.ssg.api.member.model.vo.Member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

public class Run {
    public static void main(String[] args) {
        String csvData = "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";
        StringTokenizer membersData = new StringTokenizer(csvData, "|");
        while (membersData.hasMoreTokens()) {
            StringTokenizer memberData = new StringTokenizer(membersData.nextToken(), ",");
            int memberNo = Integer.parseInt(memberData.nextToken());
            String memberName = memberData.nextToken();
            int height = Integer.parseInt(memberData.nextToken());
            int weight = Integer.parseInt(memberData.nextToken());
            LocalDate birth = LocalDate.parse(memberData.nextToken(), DateTimeFormatter.ofPattern("yyyyMMdd"));

            Member member = new Member(memberNo, memberName, height, weight, birth);
            System.out.println(member.information());
        }

    }
}
