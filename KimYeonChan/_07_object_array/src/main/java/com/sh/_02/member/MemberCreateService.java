package com.sh._02.member;

/**
 * MemberCreateService 가 수신할 수 있는 메세지
 * - 회원 1명의 정보를 저장하라.
 * MemberCreateService 가 알고 있는 것
 * - MemberRepository
 * MemberCreateService 가 할 수 있는 것
 * - MemberCreatService 에게 회원저장 메세지 보내기
 */
public class MemberCreateService {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    public boolean saveMember(Member member) {
        boolean success = memberRepository.saveMember(member);
        return success;
    }
}
