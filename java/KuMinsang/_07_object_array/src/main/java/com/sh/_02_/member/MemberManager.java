package com.sh._02_.member;
import java.util.Scanner;

/**
 * <pre>
 *     MemberManager가 수신하는 메시지
 *     -회원을 저장하라
 *     -회원을 읽어와라
 *     MemberManager가 알고 있는것
 *     - 회원 저장 서비스 객체
 *     - 회원 찾기 서비스 객체
 *     MemberManager가 할수 있는 것
 *     - 회원 저장서비스에게 회원저장 메세지 보내기
 *     -
 *
 * </pre>
 */

public class MemberManager {
    private MemberCreateService memberCreateSevice = new MemberCreateService();
    private MemberFindService memberFindService = new MemberFindService();

    public boolean saveMember(Member member){
        boolean success = false;
        success = memberCreateSevice.saveMember(member);
        return success;
    }
    /*
    public boolean saveMember(Member[] members){
        boolean success = false;
        for(int i =0; i<members.length; i++){
            success = memberRepository.saveMember(members[i]);
        }
        return success;
    }*/

    public Member[] readMember() {
        Member[] members = memberFindService.readMember();
        return members;
    }

    public Member readMember(long id){
        Member member = memberFindService.readMember(id);
        return member;
    }
}
