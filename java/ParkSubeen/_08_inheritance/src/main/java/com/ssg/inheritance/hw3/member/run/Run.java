package com.ssg.inheritance.hw3.member.run;


import com.ssg.inheritance.hw3.member.model.vo.Silver;
import com.ssg.inheritance.hw3.member.model.vo.Vip;
import com.ssg.inheritance.hw3.member.repository.MemberRepository;
import com.ssg.inheritance.hw3.member.model.vo.Gold;
import com.ssg.inheritance.hw3.member.model.vo.VVip;

public class Run {
    public static void main(String[] args){
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.silverInsert(new Silver("홍길동", "Silver",1000));
        memberRepository.silverInsert(new Silver("김말똥", "Silver",2000));
        memberRepository.silverInsert(new Silver("고길동", "Silver",3000));
        memberRepository.goldInsert(new Gold("김회장", "Gold",1000));
        memberRepository.goldInsert(new Gold("이회장", "Gold",2000));
        memberRepository.goldInsert(new Gold("오회장", "Gold",3000));
        memberRepository.printData();

        MemberRepository m = new MemberRepository();
        // vip 추가
        m.vipInsert(new Vip("이부자", "Vip",10000));
        // vvip 추가
        m.vvipInsert(new VVip("김갑부", "VVip",100000));
        m.printData();
    }
}
