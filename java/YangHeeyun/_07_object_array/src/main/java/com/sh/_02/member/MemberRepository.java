package com.sh._02.member;

/**
 * <pre>
 *  MemberRepository가 수신가능한 메세지
 *  - 회원정보를 저장해라
 *  - 회원정보를 읽어와라
 *
 *  MemberRepository가 알고(가지고) 있는것
 *  - Member[]
 *  - 저장가능한 전체회원수
 *  - 현재 저장된 회원수
 *
 *  MemberRepository가 할 수 있는것
 *  - 회원정보를 저장
 *  - 회원정보를 읽어서 제공
 * </pre>
 */

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
    public boolean saveMember(Member member) {
        if(index < MAX_MEMBER) {
            // 회원 추가
            members[index] = member;
            index++;
            return true;
        }
        else {
            // 회원 추가 불가능(저장 회원수 초과)
            return false;
        }
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
                members[i] = this.members[i]; // index, this.members[i]는 멤버리파지토리 전역변수 뜻함
            }
        }
        return members;
    }

    public Member readMemberById(long id) {
        for(int i=0;i<index;i++){
            Member member = members[i];
            if(member.getId() == id){
                return member; // 동일한 id의 회원을 찾으면, 즉시 반환
            }
        }
        return null;
    }
}
