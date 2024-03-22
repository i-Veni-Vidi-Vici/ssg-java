package com.sh._02.member;

public class MemberRepsitory {
    private static MemberRepsitory instance;
    private static final int MAX_MEMBER = 10;
    private Member[] members = new Member[MAX_MEMBER]; // 여러명의 인원 저장해야하므로
    private int index; // 저장할 회원인덱스임과 동시에 저장된 회원수

    /**
     * 외부에서 생성자호출(객체생성) 방지
     */
    private MemberRepsitory() {
    }

    public static MemberRepsitory getInstance() {
        if (instance == null) {
            instance = new MemberRepsitory();
        }
        return instance;
    }

    public boolean saveMember(Member member) {
        if (index < MAX_MEMBER) {
            members[index] = member;
            index++;
            return true;
            //회원 추가 가능
        } else {
            return false;
            //회원 수 초과
        }
        //이건 보이는 것 이므로 public 인덱스가 증가시켜줘야 다음멤버가 들어갈 수 있음
    }

    /**
     * MemberRepsitory#members 를 그대로 반환하지않고.
     * 저장된 회원수 크기의 새로운 배열에 담아 반환
     * @return
     */

    public Member[] readMember() {

        if (index > 0) {
            members = new Member[index];
            for (int i = 0; i < members.length; i++) {
                members[i] = this.members[i];}


        }
        return members = null;



    }

    }

