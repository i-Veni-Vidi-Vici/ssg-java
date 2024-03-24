package com.ssg.emp;

public class MemberRepository {
    private Silver[] silvers = new Silver[10];
    private int silverIndex=0;
    private Gold[] golds = new Gold[10];
    private int goldIndex=0;
    private Vip[] vips=new Vip[10];
    private int vipIndex=0;

    private Vip[] Vvips=new Vip[10];
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
        for(int i=0;i<silverIndex;i++)
        {
            System.out.printf("%s    %s    %d     %.2f\n",silvers[i].getName(),silvers[i].getGrade(),silvers[i].getPoint(),silvers[i].getEjapoint());
        }
        for(int i=0;i<goldIndex;i++)
        {
            System.out.printf("%s    %s      %d     %.2f\n",golds[i].getName(),golds[i].getGrade(),golds[i].getPoint(),golds[i].getEjapoint());
        }
    }
}
