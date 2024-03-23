package com.ssg.test.member.repository;

import com.ssg.test.member.model.vo.Gold;
import com.ssg.test.member.model.vo.Silver;
import com.ssg.test.member.model.vo.VVip;
import com.ssg.test.member.model.vo.Vip;

public class MemberRepository {
    private static final int MAX_MEMBER = 10;
    private Silver silver[] = new Silver[MAX_MEMBER];
    private Gold gold[] = new Gold[MAX_MEMBER];
    private Vip vip[] = new Vip[MAX_MEMBER];
    private VVip vvip[] = new VVip[MAX_MEMBER];

    private int indexSilver = 0;  // Silver 배열 인덱스
    private int indexGold = 0;  // Gold 배열 인덱스
    private int indexVip = 0;  // Vip 배열 인덱스
    private int indexVVip = 0;  // VVip 배열 인덱스

    public void silverInsert(Silver s) {
        silver[indexSilver] = new Silver(s.getName(), s.getGrade(), s.getPoint());
        indexSilver++;
    }

    public void goldInsert(Gold g) {
        gold[indexGold] = new Gold(g.getName(), g.getGrade(), g.getPoint());
        indexGold++;
    }

    public void vipInsert(Vip v) {
        vip[indexVip] = new Vip(v.getName(), v.getGrade(), v.getPoint());
        indexVip++;
    }

    public void vvipInsert(VVip vv) {
        vvip[indexVVip] = new VVip(vv.getName(), vv.getGrade(), vv.getPoint());
        indexVVip++;
    }

    public void printData() {
        String inform = """
        ---------------------------<<회원정보>>---------------------------
        이름             등급            포인트           이자포인트
        -----------------------------------------------------------------
        """;

        System.out.print(inform);
        for(int i=0; i<indexSilver; i++)
            System.out.printf("%s\t\t\t%s\t\t\t%d\t\t\t%.2f\n", silver[i].getName(), silver[i].getGrade(), silver[i].getPoint(), silver[i].getEjapoint());

        for(int i=0; i<indexGold; i++)
            System.out.printf("%s\t\t\t%s\t\t\t%d\t\t\t%.2f\n", gold[i].getName(), gold[i].getGrade(), gold[i].getPoint(), gold[i].getEjapoint());

        for(int i=0; i<indexVip; i++)
            System.out.printf("%s\t\t\t%s\t\t\t\t%d\t\t\t%.2f\n", vip[i].getName(), vip[i].getGrade(), vip[i].getPoint(), vip[i].getEjapoint());

        for(int i=0; i<indexVVip; i++)
            System.out.printf("%s\t\t\t%s\t\t\t%d\t\t\t%.2f\n", vvip[i].getName(), vvip[i].getGrade(), vvip[i].getPoint(), vvip[i].getEjapoint());
    }
}
