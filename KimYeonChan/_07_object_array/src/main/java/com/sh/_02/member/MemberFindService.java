package com.sh._02.member;

/**
 * MemberFindService 가 수신할 수 있는 메세지
 * - 전체 회원 정보를 읽어와라
 * MemberFindService 가 알고 있는 것
 * - MemberRepository
 * MemberCreateService 가 할 수 있는 것
 * - MemberFindService 에게 전체 회원조회 메세지 보내기
 */
public class MemberFindService {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    public Member[] readMember() {
        Member[] members = memberRepository.readMember();
        return members;
    }
}
