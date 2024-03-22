package com.sh._02.member;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * MemberManager가 수신하는 메세지
 * - 회원을 저장하라
 * - 회원을 읽어와라
 *
 * MemberManager가 알고 있는 것
 * - 회원저장서비스 객체
 * - 회원찾기서비스 객체
 *
 * MemberManager가 할 수 있는 것
 * - 회원저장서비스에게 회원저장 메세지 보내기
 * - 회원찾기서비스에게 회원조회 메세지 보내기
 */
public class MemberManager {
    private MemberCreateService memberCreateService = new MemberCreateService();
    private MemberFindService memberFindService= new MemberFindService();
    public boolean saveMember(Member member){
        boolean success = memberCreateService.saveMember(member);

        return success;
    }
    public Member[] readMember() {
        Member[] members = memberFindService.readMember();
        return members;
    }
}
