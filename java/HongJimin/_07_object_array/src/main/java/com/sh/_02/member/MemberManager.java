package com.sh._02.member;

/**
 * MemberManager가 수신하는 메세지
 * - 회원을 저장하라
 * - 회원을 읽어와라
 *
 * MemberManager가 알고 있는 것
 * - 회원 저장 서비스 객체
 * - 회원 찾기 서비스 객체
 *
 * MemberManager가 할 수 있는 것
 * - 회원 저장 서비스에게 회원 저장 메세지 보내기
 * - 회원 찾기 서비스에게 회원 조회 메세지 보내기
 *
 */
public class MemberManager {
    private MemberCreateService memberCreateService = new MemberCreateService();
    private MemberFindService memberFindService =new MemberFindService();



    public boolean saveMember(Member member) {
        boolean success = memberCreateService.saveMember(member);
        return success;
    }


    public Member[] readMember() { //회원 정보를 다시 들고 와야 함
        Member[] members = memberFindService.readMember();
        return members;
    }
}
