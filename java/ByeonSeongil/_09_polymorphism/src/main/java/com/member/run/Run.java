package com.member.run;

import com.member.model.vo.Gold;
import com.member.model.vo.Rubby;
import com.member.model.vo.Silver;
import com.member.model.vo.VVip;
import com.member.model.vo.Vip;
import com.member.repository.MemberRepository;

public class Run {
    public static void main(String[] args) {
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.insertMember(new Silver("홍길동", "Silver",1000));
        memberRepository.insertMember(new Silver("고길동", "Silver",2000));
        memberRepository.insertMember(new Silver("홍동민", "Silver",3000));
        memberRepository.insertMember(new Gold("김회장", "Gold",1000));
        memberRepository.insertMember(new Gold("이회장", "Gold",2000));
        memberRepository.insertMember(new Gold("오회장", "Gold",3000));
        memberRepository.insertMember(new Vip("이순신", "Vip",10000));
        memberRepository.insertMember(new VVip("신사임당", "VVip",100000));
        memberRepository.insertMember(new Rubby("세종", "Ruby",500000));
        memberRepository.printData();
        memberRepository.printBuyInfo(10000);

    }
}
