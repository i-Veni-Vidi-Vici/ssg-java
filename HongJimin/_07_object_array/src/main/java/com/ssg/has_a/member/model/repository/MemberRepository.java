package com.ssg.has_a.member.model.repository;

import com.ssg.has_a.member.model.vo.Gold;
import com.ssg.has_a.member.model.vo.Silver;

public class MemberRepository {
    String[] silvers = new String[10];
    String[] golds = new String[10];

    public void silverInsert(Silver silver) {
        for (int i = 0; i < silvers.length; i++) {
//            silvers[i] = String.valueOf(Silver silver);
            silver.getEjapoint();
        }
    }

    public void goldInsert(Gold gold) {
    }

    public void printData() {
        System.out.println("""
                ---------------------------<<회원정보>>---------------------------
                이름              등급             포인트         이자포인트
                -----------------------------------------------------------------
                """);
       for (int i = 0; i < silvers.length; i++) {
           System.out.println();
       }

    }
}
