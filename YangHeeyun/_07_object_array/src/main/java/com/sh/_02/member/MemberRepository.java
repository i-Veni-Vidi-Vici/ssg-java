package com.sh._02.member;

public class MemberRepository {
    private static MemberRepository instance;
    private static final int MAX_MEMBER = 10;

    private Member[] members = new Member[MAX_MEMBER];
    private int index; // 저장할 회원인덱스(저장된 회원수)

    /**
     * private로 한 이유 - 외부에서 생성자호출(객체생성) 방지
     */
    private MemberRepository(){}

    public static MemberRepository getInstance(){
        if(instance == null) {
            instance = new MemberRepository();
        }
        return instance;
    }

//    public boolean saveMember(Member member) {
//        if(index < MAX_MEMBER) {
//            // 회원 추가
//            members[index] = member;
//            index++;
//            return true;
//        }
//        else {
//            // 회원 추가 불가능(저장 회원수 초과)
//            return false;
//        }
//    }
    public boolean saveMember(Member member){
        member
    }


    /**
     * MemberRepository#members를 그대로 반환하지 않고,
     * 저장된 회원수 크기의 새로운 배열에 담아 반환.
     * @return
     */
    public Member[] readMember(){
        Member[] members = null;
        if(index > 0) {
            members = new Member[index];
            for(int i = 0; i < members.length; i++) {
                members[i] = this.members[i];
            }
        }
        return members;
    }
}
