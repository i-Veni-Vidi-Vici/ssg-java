package com.ssg.member.repository;

import com.ssg.member.model.Gold;
import com.ssg.member.model.Silver;
import com.ssg.member.model.VVip;
import com.ssg.member.model.Vip;

public class MemberRepository {
    public static final int MAX_INDEX = 10;
    Silver[] silvers = new Silver[MAX_INDEX];
    Gold[] golds = new Gold[MAX_INDEX];

    Vip[] vips = new Vip[MAX_INDEX];

    VVip[] vvips = new VVip[MAX_INDEX];

    int silverIndex = 0;
    int goldIndex = 0;

    int vipIndex = 0;
    int vvipIndex = 0;

    public void silverInsert(Silver silver) {
        if (silverIndex < MAX_INDEX) {
            this.silvers[silverIndex] = silver;
            silverIndex++;
        } else {
            System.out.println("더이상 추가할 수 없습니다!");
        }
    }


    public void goldInsert(Gold gold) {
        if (goldIndex < MAX_INDEX) {
            this.golds[goldIndex] = gold;
            goldIndex++;
        } else {
            System.out.println("더이상 추가할 수 없습니다!");
        }
    }

    public void vipInsert(Vip vip) {
        if (vipIndex < MAX_INDEX) {
            this.vips[vipIndex] = vip;
            vipIndex++;
        } else {
            System.out.println("더이상 추가할 수 없습니다!");
        }
    }

    public void vvipInsert(VVip vvip) {
        if (vvipIndex < MAX_INDEX) {
            this.vvips[vvipIndex] = vvip;
            vvipIndex++;
        } else {
            System.out.println("더이상 추가할 수 없습니다!");
        }
    }


    public void printData() {
        System.out.println("""
                ---------------------------<<회원정보>>---------------------------
                       이름       등급         포인트     이자포인트
                -----------------------------------------------------------------
                """);
        for (int i = 0; i < silverIndex; i++) {
            if (silvers[i] != null) {
                System.out.printf("%10s %10s %10d %10.2f", silvers[i].getName(), silvers[i].getGrade(), silvers[i].getPoint(), silvers[i].getEjapoint());
                System.out.println();
            }
        }
        for (int i = 0; i < goldIndex; i++) {
            if (golds[i] != null) {
                System.out.printf("%10s %10s %10d %10.2f", golds[i].getName(), golds[i].getGrade(), golds[i].getPoint(), golds[i].getEjapoint());
                System.out.println();
            }
        }
        for (int i = 0; i < vipIndex; i++) {
            if (vips[i] != null) {
                System.out.printf("%10s %10s %10d %10.2f", vips[i].getName(), vips[i].getGrade(), vips[i].getPoint(), vips[i].getEjapoint());
                System.out.println();
            }
        }
        for (int i = 0; i < vvipIndex; i++) {
            if (vvips[i] != null) {
                System.out.printf("%10s %10s %10d %10.2f", vvips[i].getName(), vvips[i].getGrade(), vvips[i].getPoint(), vvips[i].getEjapoint());
                System.out.println();
            }
        }
    }
}


