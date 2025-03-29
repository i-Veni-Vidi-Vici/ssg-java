package com.sh._02.member;

/**
 * <pre>
 * MemberRepository가 수신가능한 메세지
 * - 회원정보를 저장해라
 * - 회원정보를 읽어와라
 *
 * MemberRepository가 알고 있는(가지고) 것.
 * - Member[]
 * - 저장가능한 전체회원수
 * - 현재 저장된 회원수
 *
 * MemberRepository가 할 수 있는것
 * - 회원정보를 저장
 * - 회원정보를 읽어서 제공
 *
 * </pre>
 */
public class MemberRepository {
    private static MemberRepository instance;
    private static final int MAX_MEMBER = 10;

    private Member[] members = new Member[MAX_MEMBER];
    private int index; // 저장할 회원인덱스인 동시에 저장된 회원수

    /**
     * 외부에서 생성자호출(객체생성) 방지
     */
    private MemberRepository(){}  // 생성자 호출

    public static MemberRepository getInstance() {  //getInstance 앞에는 static이 무조건 있어야 한다.
        if(instance == null) {
            instance = new MemberRepository();
        }
        return instance;
    }

    public boolean saveMember(Member member) {
        if(index < MAX_MEMBER) {
            // 회원 추가 가능
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
     * 저장된 회원수 크기의 새로운 배열에 담아 반환한다.
     * @return
     */
    public Member[] readMember(){
        Member[] members = new Member[index];
        if(index > 0) {
            members = new Member[index];
            for(int i = 0; i < members.length; i++) {
                members[i] = this.members[i];  // 41줄에 있는 members와 45줄에 있는 members는 다르다.
            }
        }
        return members;
    }

}
