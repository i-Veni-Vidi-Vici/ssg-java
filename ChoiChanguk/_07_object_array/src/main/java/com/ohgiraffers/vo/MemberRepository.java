package com.ohgiraffers.vo;

public class MemberRepository {
    private Silver[] silvers = new Silver[10];
    private int silverIndex=0;
    private Gold[] golds = new Gold[10];
    private int goldIndex=0;
    private Vip[] vips=new Vip[10];
    private int vipIndex=0;

    private Vvip[] Vvips=new Vvip[10];
    private int VvipIndex=0;

    public void silverInsert(Silver silver)
    {

        silvers[silverIndex]=silver;
        silvers[silverIndex++].getEjapoint();

    }

    public void goldInsert(Gold gold)
    {
        golds[goldIndex]=gold;
        golds[goldIndex++].getEjapoint();
    }

    public void vipInsert(Vip vip)
    {

        vips[vipIndex]=vip;
        vips[vipIndex++].getEjapoint();

    }

    public void VvipInsert(Vvip vvip)
    {

        Vvips[VvipIndex]=vvip;
        Vvips[VvipIndex++].getEjapoint();

    }

    public void printData()
    {
        System.out.printf("----------------<<회원정보>>-----------\n");
        System.out.printf(" 이름      등급     포인트   이자포인트\n");
        System.out.printf("--------------------------------------\n");
        if (silverIndex > 0) {

            for (int i = 0; i < silverIndex; i++) {
                System.out.printf("%-5s%s    %d     %.2f\n", silvers[i].getName(), silvers[i].getGrade(), silvers[i].getPoint(), silvers[i].getEjapoint());
            }
        } else {
            System.out.println("      등록된 silver등급이 없습니다")
            ;
        }
        if (goldIndex > 0) {
            for (int i = 0; i < goldIndex; i++) {
                System.out.printf("%-5s%s      %d     %.2f\n", golds[i].getName(), golds[i].getGrade(), golds[i].getPoint(), golds[i].getEjapoint());
            }
        } else {
            System.out.println("      등록된 gold등급이 없습니다");
        }

        if (vipIndex > 0) {
            for (int i = 0; i < vipIndex; i++) {
                System.out.printf("%-5s%s       %d    %.2f\n", vips[i].getName(), vips[i].getGrade(), vips[i].getPoint(), vips[i].getEjapoint());
            }
        }
        else
            System.out.println("      등록된 vip등급이 없습니다");

        if (VvipIndex>0) {
            for (int i = 0; i < vipIndex; i++) {
                System.out.printf("%-5s%s      %d   %.2f\n", Vvips[i].getName(), Vvips[i].getGrade(), Vvips[i].getPoint(), Vvips[i].getEjapoint());
            }
        }
        else
            System.out.println("      등록된 vvip등급이 없습니다");
    }
}
