package com.ohgiraffers.vo;

public class Run {
    public static void main(String[] args) {
        MemberRepository memberRepository=new MemberRepository();
        memberRepository.silverInsert(new Silver("홍길동","Silver",1000));
        memberRepository.silverInsert(new Silver("김말똥","Silver",2000));
        memberRepository.silverInsert(new Silver("고길동","Silver",3000));

        memberRepository.goldInsert(new Gold("김회장","Gold",1000));
        memberRepository.goldInsert(new Gold("홍길동","Gold",2000));
        memberRepository.goldInsert(new Gold("홍길동","Gold",3000));

        //memberRepository.vipInsert(new Vip("이부자","vip",10000));
        //memberRepository.VvipInsert(new Vvip("이부자","vvip",100000));

        memberRepository.printData();
    }
}
