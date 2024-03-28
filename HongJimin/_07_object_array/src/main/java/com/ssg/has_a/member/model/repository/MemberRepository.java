package com.ssg.has_a.member.model.repository;

import com.ssg.has_a.member.model.vo.Gold;
import com.ssg.has_a.member.model.vo.Silver;

public class MemberRepository {
    Silver[] silvers = new Silver[10];
    Gold[] golds = new Gold[10];

    public void silverInsert(Silver silver) {

        for (int i = 0; i < silvers.length; i++) {
            silvers[i] = silver;
        }
    }

    public void goldInsert(Gold gold) {
        for(int i = 0; i < golds.length; i++) {
            golds[i] = gold;
        }
    }

    public void printData() {
        System.out.print("""
                ---------------------------<<회원정보>>---------------------------
                이름              등급             포인트         이자포인트
                -----------------------------------------------------------------
                """);
       for (int i = 0; i < silvers.length; i++) {
           if(silvers[i] ==null) break;

           System.out.println(
                   silvers[i].getName() +"\t"
                   + silvers[i].getGrade() +"\t"
                           + silvers[i].getPoint() +"\t"
                           + silvers[i].getEjapoint());
       }

       for (int i = 0; i < golds.length; i++) {
           System.out.println(
                   golds[i].getName() +"\t"
                   + golds[i].getGrade() +"\t"
                   + golds[i].getPoint() +"\t"
                           + golds[i].getEjapoint());
       }

    }
}
