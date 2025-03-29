package com.ssg.api.member.model.vo.member;

import java.time.LocalDate;

public class Member {
    private int memberNo;
    private String memberName;
    int height, weight;
    private LocalDate birth;

    public String info(){
        return "No: " + this.memberNo + " name: " + this.memberName + " height: " + this.height +
                " weight: " + this.weight + " birth " + this.birth;
    }

    public Member(int memberNo, String memberName, int height, int weight, String birth) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.height = height;
        this.weight = weight;
        int birht_year = Integer.parseInt(birth.substring(0,4));
        int birht_month = Integer.parseInt(birth.substring(4,6));
        int birht_day = Integer.parseInt(birth.substring(6,8));
        this.birth = LocalDate.of(birht_year,birht_month, birht_day);
    }
}
