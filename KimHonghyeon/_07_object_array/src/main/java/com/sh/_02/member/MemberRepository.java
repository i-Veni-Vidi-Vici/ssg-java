package com.sh._02.member;

public class MemberRepository {
    private static MemberRepository instance;
    public static final int MAX_MEMBER = 10;
    private int index=0;
    private Member[] members = new Member[MAX_MEMBER];
    private MemberRepository(){};

    public static MemberRepository getInstance(){
        if(instance==null){
            instance = new MemberRepository();
        }
        return instance;
    }

    public boolean saveMember(Member member){
        if(index>=MAX_MEMBER) return false;
        else{
            members[index++] = member;
            return true;
        }
    }
    public Member[] readMember(){
        Member[] members = null;
        if(index>=1){
            members = new Member[index];
            for(int i = 0; i<index; i++){
                members[i] = this.members[i];
            }
        }
        return members;
    }

}
