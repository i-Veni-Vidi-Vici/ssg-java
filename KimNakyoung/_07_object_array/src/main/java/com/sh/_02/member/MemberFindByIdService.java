package com.sh._02.member;

public class MemberFindByIdService {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    public Member readMemberById(long id) {
        Member member = memberRepository.readMemberById(id);
        return member;
    }
}
