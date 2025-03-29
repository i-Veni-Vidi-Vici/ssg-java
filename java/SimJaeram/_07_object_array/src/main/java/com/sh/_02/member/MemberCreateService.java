package com.sh._02.member;

/**
 * <pre>
 *     MemberCreateService가 수신할 수 있는 메세지
 *     - 회원 1명 정보를 저장해라
 *
 *     MemberCreateService가 알고 있는 것
 *     - MemberRepository
 *
 *     MemberCreateService가 할 수 있는 것
 *     - MemberRepository에게 회원 저장 메세지 보내기
 * </pre>
 */
public class MemberCreateService {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    public boolean saveMember(Member member) {
        boolean success = memberRepository.saveMember(member);
        return success;
    }
}
