package com.ssg.inheritance.hw3.member.repository;


import com.ssg.inheritance.hw3.member.model.vo.Gold;
import com.ssg.inheritance.hw3.member.model.vo.Silver;
import com.ssg.inheritance.hw3.member.model.vo.VVip;
import com.ssg.inheritance.hw3.member.model.vo.Vip;

public class MemberRepository {
    private static final int SMAX_MEMBER = 10;
    private static final int GMAX_MEMBER = 10;
    private static final int VMAX_MEMBER = 10;
    private static final int VVMAX_MEMBER = 10;
    private Silver[] silvers = new Silver[SMAX_MEMBER];
    private Gold[] golds = new Gold[GMAX_MEMBER];
    private Vip[] vips = new Vip[VMAX_MEMBER];
    private VVip[] vvips = new VVip[VVMAX_MEMBER];

    // 다음에 추가할 회원인덱스(지금까지 저장한 회원수)
    private int sIndex;
    private int gIndex;
    private int vIndex;
    private int vvIndex;


    public void silverInsert(Silver silver) {
        if(sIndex < SMAX_MEMBER) {
            silvers[sIndex] = silver;
            sIndex++;
        }
    }

    public void goldInsert(Gold gold) {
        if(gIndex < GMAX_MEMBER) {
            golds[gIndex] = gold;
            gIndex++;
        }
    }

    public void vipInsert(Vip vip) {
        if(vIndex < VMAX_MEMBER) {
            vips[vIndex] = vip;
            vIndex++;
        }
    }

    public void vvipInsert(VVip vVip) {
        if(vvIndex < VVMAX_MEMBER) {
            vvips[vvIndex] = vVip;
            vvIndex++;
        }
    }

    public void printData() {
        System.out.println("--------------------<<회원정보>>-------------------------");
        System.out.println("    이름          등급          포인트         이자포인트");
        System.out.println("--------------------------------------------------------");
        Silver[] silver = null;
        Gold[] gold = null;
        Vip[] vip = null;
        VVip[] vvip = null;
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
        if(vIndex >= 0) {
            vip = new Vip[vIndex];

            for(int i = 0; i < vip.length; i++) {
                vip[i] = this.vips[i];
            }
            for(Vip vipValue : vip) {
                System.out.printf("%s           %s          %d          %.2f\n",
                        vipValue.getName(),
                        vipValue.getGrade(),
                        vipValue.getPoint(),
                        vipValue.getEjapoint(vipValue.getPoint()));
            }
        }
        if(vvIndex >= 0) {
            vvip = new VVip[vvIndex];

            for(int i = 0; i < vvip.length; i++) {
                vvip[i] = this.vvips[i];
            }
            for(VVip vvipValue : vvip) {
                System.out.printf("%s           %s          %d          %.2f\n",
                        vvipValue.getName(),
                        vvipValue.getGrade(),
                        vvipValue.getPoint(),
                        vvipValue.getEjapoint(vvipValue.getPoint()));
            }
        }
    }


}
