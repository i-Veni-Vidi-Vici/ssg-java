package com.sh._02.member;

public class MemberSearchService {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    public Member[] searchMember() {
        Member[] members = memberRepository.searchMember();
        return members;
    }
}
