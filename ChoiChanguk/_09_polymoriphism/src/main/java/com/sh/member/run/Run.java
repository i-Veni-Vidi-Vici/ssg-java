package com.sh.member.run;

import com.sh.member.controller.MemberRepository;
import com.sh.member.model.vo.*;

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
        memberRepository.insertMember(new Ruby("세종:","Ruby",50000));
        memberRepository.printData();

        memberRepository.printBuyInfo(10000);
        
    }
}
