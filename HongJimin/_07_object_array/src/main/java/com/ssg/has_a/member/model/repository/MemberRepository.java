package com.ssg.has_a.member.model.repository;

import com.ssg.has_a.member.model.vo.Gold;
import com.ssg.has_a.member.model.vo.Silver;
import com.ssg.has_a.member.model.vo.VVip;
import com.ssg.has_a.member.model.vo.Vip;

public class MemberRepository {
    Silver[] silvers = new Silver[10];
    Gold[] golds = new Gold[10];
    Vip[] vips = new Vip[10];
    VVip[] vVips = new VVip[10];

    int silverCount = 0;
    int goldCount = 0;
    int vipCount = 0;
    int vvipCount = 0;
    public void silverInsert(Silver silver) {
        silvers[silverCount] = silver;
        silverCount++;
    }

    public void goldInsert(Gold gold) {
        golds[goldCount] = gold;
        goldCount++;
    }


    //vip, vvip 추가
    public void vipInsert(Vip vip) {
        vips[vipCount] = vip;
        vipCount++;
    }

    public void vvipInsert(VVip vVip) {
        vVips[vvipCount] = vVip;
        vvipCount++;
    }

    public void printData() {
        System.out.print("""
               ---------------------------<<회원정보>>---------------------------
                이름             등급            포인트          이자포인트
               -----------------------------------------------------------------
                """);
       for (int i = 0; i < silverCount; i++) {
           if(silvers[i] ==null) break;

           System.out.println(
                   silvers[i].getName() +"\t\t\t"
                   + silvers[i].getGrade() +"\t\t\t"
                           + silvers[i].getPoint() +"\t\t\t"
                           + silvers[i].getEjapoint());
       }

       for (int i = 0; i < goldCount; i++) {
           if (golds[i] == null) break;
           System.out.println(
                   golds[i].getName() +"\t\t\t"
                   + golds[i].getGrade() +"\t\t\t"
                   + golds[i].getPoint() +"\t\t\t"
                           + golds[i].getEjapoint());
       }

        for (int i = 0; i < vipCount; i++) {
            if (vips[i] == null) break;
            System.out.println(
                    vips[i].getName() +"\t\t\t"
                            + vips[i].getGrade() +"\t\t\t"
                            + vips[i].getPoint() +"\t\t\t"
                            + vips[i].getEjapoint());
        }

        for (int i = 0; i < vvipCount; i++) {
            if (vVips[i] == null) break;
            System.out.println(
                    vVips[i].getName() +"\t\t\t"
                            + vVips[i].getGrade() +"\t\t\t"
                            + vVips[i].getPoint() +"\t\t\t"
                            + vVips[i].getEjapoint());
        }

    }
}
