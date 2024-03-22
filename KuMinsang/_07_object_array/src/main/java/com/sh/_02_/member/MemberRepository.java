package com.sh._02_.member;

/**
 * <pre>
 *     MemberRepository가 수신 가능한 메시지
 *     - 회원정보를 저장하라
 *     - 회원정보를 읽어와라
 *     MemberRepository가 알고 있는 것
 *     - Member[]
 *     - 저장가능한 전체 회원수
 *     MemberRepository가 할수 있는것
 *     - 회원정보 저장
 *     - 회원정보 반환
 *
 * </pre>
 */

public class MemberRepository {
    private static MemberRepository instance;
    private final int MAX_MEMBER = 10;

    private Member[] members = new Member[MAX_MEMBER];
    private int index; // 저장할 회원 인덱스(저장된 회원수)

    /**
     * 싱글턴 클래스
     * 외부에서 호출 불가한 생성자
     */

    private MemberRepository(){}

    public static MemberRepository getInstance(){  //싱글턴 메소드
        if(instance == null){
            instance = new MemberRepository();
        }
        return instance;
    }

    /**
     * 1. 사용자 입력값으로 Member 객체를 생성
     * 2. MemberManager
     * @param member
     * @return
     */
    public Boolean saveMember(Member member){
        if(index<MAX_MEMBER) {
            //회원추가
            members[index] = member;
            index++;
            return true;
        }else {
            //저장 회원수 초과
            return false;
        }
    }

    public Member[] readMember(){
        Member[] tmpMem = null;
        if(index > 0){
            tmpMem = new Member[index];
            for(int i =0; i<index; i++){
                tmpMem[i] = this.members[i];
            }
        }
        return tmpMem;
    }

}
