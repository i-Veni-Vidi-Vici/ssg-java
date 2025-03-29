package com.sh._02.member;

/**
 * <pre>
 * MemberCreateService가 수신하는 메시지
 * - 한명의 회원 정보를 저장해라
 *
 * MemberCreateService가 알고 있는 것
 * - MemberRepository
 *
 * MemberCreateService가 할 수 있는 것
 * - MemberRepository에게 회원저장 메시지 보내기
 * </pre>
 */
public class MemberCreateService {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    public boolean saveMember(Member member) {
        boolean success = memberRepository.saveMember(member);
        return success;
    }
}
