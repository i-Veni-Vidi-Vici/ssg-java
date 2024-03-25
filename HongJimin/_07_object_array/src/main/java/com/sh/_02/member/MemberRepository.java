package com.sh._02.member;

/**
 * <pre>
 *     MemberRepository가 수신 가능한 메세지
 *     - 회원 정보를 저장해라
 *     - 회원 정보를 읽어와라
 *
 *     MemberRepository가 알고 있는(가지고있는) 것
 *     - Member[]
 *     - 저장 가능한 전체 회원수
 *     - 현재 저장된 회원수
 *
 *     MemberRepository가 할 수 있는 것
 *     - 회원 정보를 저장
 *     - 회원 정보를 읽어서 제공
 *
 *
 * </pre>
 */

public class MemberRepository {
    private static MemberRepository instance;
    private static final int MAX_MEMBER = 10;
    private Member[] members = new Member[MAX_MEMBER];
    private int index; //저장할 회원 인덱스( = 저장된 회원수)


    /**
     * 외부에서 생성자 호출(객체 생성) 방지
     */
    private MemberRepository() {
    }

    public static MemberRepository getInstance() {
        if (instance == null) { //null 을 반환하지 않기 위한 코드
            instance = new MemberRepository();
        }
        return instance;
    }

    public boolean saveMember(Member member) {
        if (index < MAX_MEMBER) { //index는 회원 수-1까지만 가능
            //회원 추가 가능
            members[index] = member;
            index++; //다음 번 saveMember가 호출될 때 들어갈 수 있음, 저장할 때마다 인덱스 증가!
            return true;
        } else {
            //회원 추가 불가능(저장 회원수 초과)
            return false;
        }
    }

    /**
     * MemberRepository#members를 그대로 반환하지 않고,
     * 저장된 회원 수 크기의 새로운 배열에 담아 반환.
     * @return
     */

    public Member[] readMember() {
        Member[] members = null;
        if (index > 0) {
            members = new Member[index]; //대입문으로 바꿔주기
            for (int i = 0; i < members.length; i++) {
                members[i] = this.members[i]; //왼쪽 member와 this.member는 다름을 유의하기!!
            }
        }
        return members;
    }

}
