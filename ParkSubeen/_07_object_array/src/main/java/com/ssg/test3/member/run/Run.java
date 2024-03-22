package com.ssg.test3.member.run;

import com.ssg.test3.member.model.vo.Gold;
import com.ssg.test3.member.model.vo.Silver;
import com.ssg.test3.member.repository.MemberRepository;

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
    }
}
