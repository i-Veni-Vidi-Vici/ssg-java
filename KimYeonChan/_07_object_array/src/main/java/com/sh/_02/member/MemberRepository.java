package com.sh._02.member;

/**
 * MemberRepository 가 수신 가능한 메세지
 * - 회원정보를 저장해라
 * - 회원정보를 읽어와라
 * MemberRepository 가 알고 있는 것
 * - Member[]
 * - 저장 가능한 전체 회원 수
 * - 현재 저장된 회원 수
 * MemberRepository 가 할 수 있는것
 * - 회원정보를 저장
 * - 회원정보를 읽어서 제공.
 */
public class MemberRepository {
    private static MemberRepository instance;
    private static final int MAX_MEMBER = 10;

    private Member[] members = new Member[MAX_MEMBER];
    private int index; // 저장할 회원 / 저장된 회원 수

    // 외부에서 생성자 호출(객체 생성) 방지
    private MemberRepository() {}

    public static MemberRepository getInstance() {
        if (instance == null) {
            instance = new MemberRepository();
        }
        return instance;
    }

    public boolean saveMember(Member member) {
        if (index < MAX_MEMBER) {
            // 요소 추가 가능
            members[index] = member;
            index++;
            return true;
        } else {
            // 회원 추가 불가 (저장 회원수 초과)
            return false;
        }
    }

    public Member[] readMember() {
        Member[] members = null;
        if (index > 0) {
            members = new Member[index];
            for (int i = 0; i < members.length; i++) {
                members[i] = this.members[i];
            }
        }
        return members;
    }
}
