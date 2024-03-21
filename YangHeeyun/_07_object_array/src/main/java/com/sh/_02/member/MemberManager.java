package com.sh._02.member;

public class MemberManager {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    public boolean saveMember(Member member){
        boolean success = memberRepository.saveMember(member);
        return success;
    }

//    public boolean saveMember(Member[] members) {
//        boolean success = false;
//        for (int i = 0; i < members.length; i++) {
//            success = memberRepository.saveMember(members[i]);
//        }
//        return success;
//    }

    public Member[] readMember() {
        Member[] members = memberRepository.readMember();
        return members;
    }

}
