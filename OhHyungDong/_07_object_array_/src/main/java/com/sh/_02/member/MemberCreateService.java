package com.sh._02.member;

/**
 * <pre>
 *  MemberCreateService가 수신 할 수 있는 메세지
 *  - 회원 정보 저장해라
 *
 *  알고 있는 것
 *  - MemberRepository
 *
 *  할 수 있는 것
 * </pre>
 */
public class MemberCreateService
{
    private MemberRepository memberRepository = MemberRepository.getInstance();

    public boolean saveMember(Member[] member) {
        boolean success = memberRepository.saveMember(member);
        return success;
    }
}
