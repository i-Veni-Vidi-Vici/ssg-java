package com.sh._02.member;

import java.lang.reflect.Member;

public class MemberRepository {
    // singleton 으로 만들어보자
    private static MemberRepository instance;
    private static final int MAX_MEMBER = 10;
    // 저장소 역할이므로
    private Member[] members = new Member[MAX_MEMBER];
    private  int index ; // 저장된 회원 수

    /**
     * 외부에서 생성자호출(객체생성) 방지
     */
    private MemberRepository(){}

    //public 한 객체로 MemberRepository를 외부에 제공
    public MemberRepository getInstance(){
        if(instance == null){
            instance = new MemberRepository();
        }
        return instance;
    }

    public void saveMember(Member member){

    }
    //읽어내는 메소드는 멤버 배열을 줌
    public Member[] readMember(){
        return null;
    }

    // 그러면 멤버 리파지토리에 세이브 멤버 호출 리드 멤버 호출
}
