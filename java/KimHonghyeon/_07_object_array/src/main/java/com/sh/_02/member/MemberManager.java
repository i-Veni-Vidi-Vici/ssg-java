package com.sh._02.member;

public class MemberManager {
    private MemberCreateService memberCreateService = new MemberCreateService();
    private MemberFindService memberFindService = new MemberFindService();
    private MemberRepository memberRepository = MemberRepository.getInstance();

    public boolean saveMembers(Member member){
        return memberCreateService.saveMembers(member);
    }

    public Member[] readMember(){
        return memberFindService.readMember();
    }
}
