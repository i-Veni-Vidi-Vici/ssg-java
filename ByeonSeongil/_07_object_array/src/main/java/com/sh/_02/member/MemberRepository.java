package com.sh._02.member;

import java.util.Arrays;

/**
 * <pre>
 *  MemberRepository가 수신가능한 메세지
 *  - 회원정보를 저장해라
 *  - 회원정보를 읽어와라
 *
 *  MemberRepository가 알고 있는(가지고) 것
 *  - Member[]
 *  - 저장가능한 전체 회원수
 *  - 현재 저장된 회원수
 *
 * MemberRepository가 하 수 있는 것
 * - 회원 정보 저장
 * - 회원 정보 읽기
 * </pre>
 */
public class MemberRepository {
    private static MemberRepository instance;
    private static  final int MAX_MEMBER = 10;

    private Member[] members = new Member[MAX_MEMBER];
    private int index; // 저장할 회원인덱스(저장된 회원수)
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
            members[index++] = member;
            return true;
        }

        return false;
    }

    /**
     * MemberRepository#members를 그대로 반환하지 않고,
     * 저장된 회원수 크기의 새로운 배열에 담아 반환
     * @return
     */
    public Member[] readMember() {
//        Member[] members = null;
//        if (index > 0) {
//            members = new Member[index];
//            for (int i = 0; i < members.length; i++) {
//                members[i] = this.members[i];
//            }
//        }
        return Arrays.copyOf(members,members.length);

    }

}
