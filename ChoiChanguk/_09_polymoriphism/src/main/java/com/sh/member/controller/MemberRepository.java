package com.sh.member.controller;

import com.sh.member.model.vo.*;

public class MemberRepository{
    private static final int MAX_INDEX=40;
    private static int SilverINDEX=0;
    private static int GoldINDEX=0;
    private static int VipINDEX=0;
    private static int VVipINDEX=0;
    private Silver[] silvers=new Silver[MAX_INDEX];
    private Gold[] golds=new Gold[MAX_INDEX];
    private Vip[] vips=new Vip[MAX_INDEX];
    private VVip[] vvips=new VVip[MAX_INDEX];
    private Ruby[] rubys=new Ruby[MAX_INDEX];
    private static int RubyINDEX=0;


    public void MemberRepository() {

    }

    public void insertMember(Member member)
    {
        if(member.getGrade().equals("Silver"))
        {
            silvers[SilverINDEX++]=(Silver) member;
        }
        else if(member.getGrade().equals("Gold"))
        {
            golds[GoldINDEX++]=(Gold) member;
        }
        else if(member.getGrade().equals("Vip"))
        {
            vips[VipINDEX++]=(Vip) member;
        }
        else if(member.getGrade().equals("VVip")){
            vvips[VVipINDEX++]=(VVip)member;
        }
        else rubys[RubyINDEX++]=(Ruby) member;
    }

    public void printData()
    {
        String str= """
                ----------------------정보출력-----------------------
               이름     등급   포인트 이자포인트""";
        System.out.println(str);
        for(int i=0;i<SilverINDEX;i++)
        {
            System.out.printf("%-8s%-5s%d  %.2f\n",silvers[i].getGrade(),silvers[i].getName(),silvers[i].getPoint(),silvers[i].eJapoint());
        }
        for(int i=0;i<GoldINDEX;i++)
        {
            System.out.printf("%-8s%-5s%d  %.2f\n",golds[i].getGrade(),golds[i].getName(),golds[i].getPoint(),golds[i].eJapoint());
        }
        for(int i=0;i<VipINDEX;i++)
        {
            System.out.printf("%-8s%-5s%d  %.2f\n",vips[i].getGrade(),vips[i].getName(),vips[i].getPoint(),vips[i].eJapoint());
        }
        for(int i=0;i<VVipINDEX;i++)
        {
            System.out.printf("%-8s%-6s%d  %.2f\n",vvips[i].getGrade(),vvips[i].getName(),vvips[i].getPoint(),vvips[i].eJapoint());
        }
        for(int i=0;i<RubyINDEX;i++)
        {
            System.out.printf("%-8s%-6s%d  %.2f\n",rubys[i].getGrade(),rubys[i].getName(),rubys[i].getPoint(),rubys[i].eJapoint());
        }
        System.out.println("----------------------------------------------------");
    }

    //silver등급회원 홍길동은 10000원 상품을 9800원에 구매합니다.
    public void printBuyInfo(int price)
    {
        for(int i=0;i<SilverINDEX;i++)
        {
            System.out.printf("%-5s등급회원  %-4s는(은)  %d원 상품을  %d원에 구매합니다\n",silvers[i].getGrade(),silvers[i].getName(),price,silvers[i].buy(price));
        }
        for(int i=0;i<GoldINDEX;i++)
        {
            System.out.printf("%-6s등급회원  %-4s는(은)  %d원 상품을  %d원에 구매합니다\n",golds[i].getGrade(),golds[i].getName(),price,golds[i].buy(price));
        }
        for(int i=0;i<VipINDEX;i++)
        {
            System.out.printf("%-6s등급회원  %-4s는(은)  %d원 상품을  %d원에 구매합니다\n",vips[i].getGrade(),vips[i].getName(),price,vips[i].buy(price));
        }
        for(int i=0;i<VVipINDEX;i++)
        {
            System.out.printf("%-6s등급회원  %-4s는(은)  %d원 상품을  %d원에 구매합니다\n",vvips[i].getGrade(),vvips[i].getName(),price,vvips[i].buy(price));
        }
        for(int i=0;i<RubyINDEX;i++)
        {
            System.out.printf("%-6s등급회원  %-4s는(은)  %d원 상품을  %d원에 구매합니다\n",rubys[i].getGrade(),rubys[i].getName(),price,rubys[i].buy(price));
        }
    }

}
