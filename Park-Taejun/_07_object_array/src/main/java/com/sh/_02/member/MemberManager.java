package com.sh._02.member;

public class MemberManager {
    //실제 저장소에 왔다갔다 해야함
    private MemberRepsitory memberRepsitory = MemberRepsitory.getInstance(); //얘가 멤버 리파지토리를 알고 있는 것으로 하자

    public boolean saveMember(Member [] members){
        boolean success = false;
        for(int i = 0; i < members.length; i++){
            //블럭안에 boolean 선언하면 안됨
            success = memberRepsitory.saveMember(members[i]); // saveMember에 하나씩 전달
        }
        return false;
    }

    public Member[] readMember() {
        Member[] members = null;
        return null;
    }
}
