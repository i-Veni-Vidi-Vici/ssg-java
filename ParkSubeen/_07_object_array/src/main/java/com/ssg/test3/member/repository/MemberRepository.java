package com.ssg.test3.member.repository;

import com.ssg.test3.member.model.vo.Gold;
import com.ssg.test3.member.model.vo.Silver;

public class MemberRepository {
    private static final int SMAX_MEMBER = 10;
    private static final int GMAX_MEMBER = 10;
    private Silver[] silvers = new Silver[SMAX_MEMBER];
    private Gold[] golds = new Gold[GMAX_MEMBER];
    private int sIndex;
    private int gIndex;


    public void silverInsert(Silver silver) {
        if(sIndex < SMAX_MEMBER) {
            silvers[sIndex] = silver;
            sIndex++;
        }
    }

    public void goldInsert(Gold gold) {
        if(gIndex < SMAX_MEMBER) {
            golds[gIndex] = gold;
            gIndex++;
        }
    }

    public void printData() {
        System.out.println("--------------------<<회원정보>>-------------------------");
        System.out.println("    이름          등급          포인트         이자포인트");
        System.out.println("--------------------------------------------------------");
        Silver[] silver = null;
        Gold[] gold = null;
        if(sIndex > 0) {
            silver = new Silver[sIndex];

            for(int i = 0; i < silver.length; i++) {
                silver[i] = this.silvers[i];
            }
            for(Silver silverValue : silver) {
//                System.out.print(silverValue.getName());
//                System.out.print(silverValue.getGrade());
//                System.out.print(silverValue.getPoint());
//                System.out.print(silverValue.getEjapoint(silverValue.getPoint()));
                System.out.printf("%s           %s          %d          %.2f\n",
                                silverValue.getName(),
                                silverValue.getGrade(),
                                silverValue.getPoint(),
                                silverValue.getEjapoint(silverValue.getPoint()));
            }
        }
        if(gIndex > 0) {
            gold = new Gold[gIndex];

            for(int i = 0; i < gold.length; i++) {
                gold[i] = this.golds[i];
            }
            for(Gold goldValue : gold) {
                System.out.printf("%s           %s          %d          %.2f\n",
                        goldValue.getName(),
                        goldValue.getGrade(),
                        goldValue.getPoint(),
                        goldValue.getEjapoint(goldValue.getPoint()));
            }
        }
    }
}
