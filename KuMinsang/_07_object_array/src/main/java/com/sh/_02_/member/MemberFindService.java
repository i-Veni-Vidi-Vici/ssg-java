package com.sh._02_.member;

/**
 * <pre>
 *     MemberFindSevice가 수신할 수있는 메시지
 *     - 전체 회원 정보를 읽어와라
 *     MemberFindSevice가 알고 있는것
 *     - MemberRepository
 *     MemberFindSevice가 할수 있는것
 *      - MemberRepository에게 회원 조회 메시지 보내기
 *
 * </pre>
 */

public class MemberFindService {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    public Member[] readMember(){
        Member[] members = memberRepository.readMember();
        return members;
    }
}
