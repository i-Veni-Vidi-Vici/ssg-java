package com.member.repository;

import com.member.model.vo.Gold;
import com.member.model.vo.Silver;
import com.member.model.vo.VVip;
import com.member.model.vo.Vip;

public class MemberRepository {
    private Silver[] silvers = new Silver[10];
    private Gold[] golds = new Gold[10];
    private Vip[] vips = new Vip[10];
    private VVip[] vVips = new VVip[10];

    private int sIndex ;
    private int  gIndex;

    private int vIndex;
    private int vvIndex;


    public void silverInsert(Silver silver) {
        silvers[sIndex++] = silver;
    }

    public void goldInsert(Gold gold) {
        golds[gIndex++] = gold;
    }

    public void vipInsert(Vip vip) {
        vips[vIndex++] = vip;
    }

    public void vvipInsert(VVip vVip) {
        vVips[vvIndex++] = vVip;
    }


    public void printData() {
        System.out.println("---------------------------<<회원정보>>---------------------------");
        System.out.println("이름              등급             포인트         이자포인트");
        System.out.println("-----------------------------------------------------------------");
        for (Silver silver : silvers) {
            if (silver == null) {
                break;
            }
            System.out.printf("%-14s %-16s %-13d %.2f\n",silver.getName(),silver.getGrade(),silver.getPoint(),silver.getEjapoint());
        }

        for (Gold gold : golds) {
            if (gold == null) {
                break;
            }
            System.out.printf("%-14s %-16s %-13d %.2f\n",gold.getName(),gold.getGrade(),gold.getPoint(),gold.getEjapoint());
        }

        for (Vip vip : vips) {
            if (vip == null) {
                break;
            }
            System.out.printf("%-14s %-16s %-13d %.2f\n",vip.getName(),vip.getGrade(),vip.getPoint(),vip.getEjapoint());
        }

        for (VVip vvip : vVips) {
            if (vvip == null) {
                break;
            }
            System.out.printf("%-14s %-16s %-13d %.2f\n",vvip.getName(),vvip.getGrade(),vvip.getPoint(),vvip.getEjapoint());
        }
    }

}
