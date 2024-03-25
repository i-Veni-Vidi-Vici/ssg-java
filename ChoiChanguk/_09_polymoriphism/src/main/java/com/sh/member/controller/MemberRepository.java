package com.sh.member.controller;

import com.sh.member.model.vo.*;

public class MemberRepository {
    private static final int MAX_INDEX=40;
    private static int SilverINDEX=0;
    private static int GoldINDEX=0;
    private static int VipINDEX=0;
    private static int VVipINDEX=0;
    private Silver[] silvers=new Silver[MAX_INDEX];
    private Gold[] golds=new Gold[MAX_INDEX];
    private Vip[] vips=new Vip[MAX_INDEX];
    private VVip[] vvips=new VVip[MAX_INDEX];


    private MemberRepository() {

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
        else {
            vvips[VVipINDEX++]=(VVip)member;
        }
    }

    public void printData()
    {
        for(int i=0;i<SilverINDEX;i++)
        {
            System.out.printf("%s등급회원 %s는 %d");
        }
    }
}
