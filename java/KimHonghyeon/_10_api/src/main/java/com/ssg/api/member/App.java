package com.ssg.api.member;

import com.ssg.api.member.model.vo.member.Member;

public class App {
    public static void main(String[] args) {
        String memberInfo = "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";
        String[] memberStr = memberInfo.split("[|]");
        Member[] memberArr = new Member[memberStr.length];
        for(int i = 0; i< memberArr.length; i++){
            String[] newMemberStr = memberStr[i].split(",");
            memberArr[i] = new Member(Integer.parseInt(newMemberStr[0]), newMemberStr[1], Integer.parseInt(newMemberStr[2]), Integer.parseInt(newMemberStr[3]), newMemberStr[4]);
        }
        for(int i =0; i<memberArr.length; i++){
            System.out.println(memberArr[i].info());
        }
    }
}
