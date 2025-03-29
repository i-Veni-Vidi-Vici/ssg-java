package com.sh._02.member;

public class MemberRepository {
    private static MemberRepository instance;
    private static final int MAX_MEMBER = 10;
    private Member[] memebers = new Member[MAX_MEMBER];
    private int index; // 저장할 회원 인덱스 (저장된 회원수)

    /**
     * 외부에서 생성자호출(객체생성) 방지
     */
    private MemberRepository() {

    }
    public static MemberRepository getInstance() {
        if (instance == null) {
            instance = new MemberRepository();
        }
        return instance;
    }
    public boolean saveMember(Member member) {
        if (index < MAX_MEMBER) {
            // 회원 추가 가능
            memebers[index] = member;
            index++;
            return true;
        } else {
            return false;
        }
    }
    public Member[] readMember() {
        return null;
    }
}
