package com.member.run;

import com.member.model.vo.Gold;
import com.member.model.vo.Silver;
import com.member.model.vo.Vip;
import com.member.model.vo.Vvip;
import com.member.repository.MemberRepository;

public class Run {
    public static void main(String[] args){
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.silverInsert(new Silver("홍길동", "Silver",1000));
        memberRepository.silverInsert(new Silver("김말똥", "Silver",2000));
        memberRepository.silverInsert(new Silver("고길동", "Silver",3000));
        memberRepository.goldInsert(new Gold("김회장", "Gold",1000));
        memberRepository.goldInsert(new Gold("이회장", "Gold",2000));
        memberRepository.goldInsert(new Gold("오회장", "Gold",3000));
        memberRepository.vipInsert(new Vip("이부자", "Vip",10000));
        memberRepository.vvipInsert(new Vvip("김갑부", "Vvip",100000));
        memberRepository.printData();
    }
}
