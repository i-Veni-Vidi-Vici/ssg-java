package com.sh._02.member;

/**
 * Member Manager가 수신하는 메세지
 *  - 회원 저장해라
 *  - 회원 읽어와라
 *
 *  알고 있는 것
 *  - 회원 저장 서비스 객체
 *  - 회원 찾기 서비스 객체
 *
 *  할 수 있는 것
 *  - 회원 저장 서비스에게 회원 저장 메세지 보내기
 *  - 회원 찾기 서비스에게 회원 조회 메세지 보내기
 */
public class MemberManager
{
    private MemberRepository memberRepository = MemberRepository.getInstance();
    private MemberCreateService memberCreateService = new MemberCreateService();
    private MemberFindService memberFindService = new MemberFindService();

    public boolean saveMember(Member[] member){
        boolean success = memberCreateService.saveMember(member);
        return success;
    }


    public Member[] readMember() {
        Member[] members = memberFindService.readMember();
        return  members;
    }
}
