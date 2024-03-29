package com.ssg.api.member.run;

import com.ssg.api.member.model.vo.Member;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Run {
    public static void main(String[] args) {
        String data = "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";
        //회원정보 분리
        String[] datas = data.split("\\|");
        Member[] members = new Member[datas.length];

        //회원객체에 회원정보 입력
        for(int i=0; i<members.length; i++){
            StringTokenizer tokenizer = new StringTokenizer(datas[i], ",");
            members[i] = new Member();
            members[i].setMemberNo(Integer.parseInt(tokenizer.nextToken()));
            members[i].setMemberName(tokenizer.nextToken());
            members[i].setHeight(Integer.parseInt(tokenizer.nextToken()));
            members[i].setWeight(Integer.parseInt(tokenizer.nextToken()));
            String birthstr = tokenizer.nextToken();
            LocalDate localDate = LocalDate.of(Integer.parseInt(birthstr.substring(0,4)), Integer.parseInt(birthstr.substring(4,6)), Integer.parseInt(birthstr.substring(6,8)));
            members[i].setBirth(localDate);

            members[i].information();
        }
        //회원정보 출력



    }
}
