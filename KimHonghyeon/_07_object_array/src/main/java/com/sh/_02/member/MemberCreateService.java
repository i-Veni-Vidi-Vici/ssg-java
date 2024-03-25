package com.sh._02.member;

public class MemberCreateService {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    public boolean saveMembers(Member member){
        if(!memberRepository.saveMember(member))return false;
        else{return true;}
    }
}
