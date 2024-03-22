package com.sh._02_.member;

/**
 * <pre>
 *     MemberCreateSevice가 수신할 수있는 메시지
 *     - 회원정보 1명을 저장하라
 *     MemberCreateSevice가 알고 있는것
 *     - MemberRepository
 *     MemberCreateSevice가 할수 있는것
 *      - MemberRepository에게 회원저장 메시지 보내기
 *
 * </pre>
 */
public class MemberCreateService {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    public boolean saveMember(Member member){
        Boolean success = memberRepository.saveMember(member);
        return success;
    }
}
