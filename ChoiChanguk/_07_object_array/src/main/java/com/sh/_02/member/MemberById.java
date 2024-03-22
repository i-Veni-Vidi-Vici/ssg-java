package com.sh._02.member;

public class MemberById {

    private MemberRepository memberRepository= MemberRepository.getInstance();
    public Member findId(long id) {
        return memberRepository.findId(id);
    }

}
