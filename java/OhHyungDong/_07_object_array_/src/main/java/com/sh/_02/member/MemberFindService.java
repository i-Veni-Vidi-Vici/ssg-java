package com.sh._02.member;
/**
 * <pre>
 *  MemberFindService가 수신 할 수 있는 메세지
 *  - 전체 회원 정보를 읽어와라
 *
 *  알고 있는 것
 *  - MemberRepository
 *
 *  할 수 있는 것
 *  - MemberRepository에게 전체 회원 조회
 * </pre>
 */
public class MemberFindService
{
    private MemberRepository memberRepository = MemberRepository.getInstance();

    public Member[] readMember()
    {
        Member[] members = memberRepository.readMember();

        return members;
    }
}
