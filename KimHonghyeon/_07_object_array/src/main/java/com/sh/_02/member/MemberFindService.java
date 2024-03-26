package com.sh._02.member;

public class MemberFindService {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    public Member[] readMember(){
        return memberRepository.readMember();
    }
}
