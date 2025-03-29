package com.sh._02.member;

/**
 * <pre>
 * < memberCreateService 등 만들고 나서 >
 * MemberManager가 수신하는 메세지
 * - 회원을 저장
 * - 회원을 읽기
 *
 * MemberManager가 알고 있는 것
 * - 회원 저장 서비스 객체
 * - 회원 찾기 서비스 객체
 *
 * MemberManager가 할 수 있는 것에 알고 있는 것 사용 가능
 * - 회원 저장 서비스에게 회원저장 메세지 보내기
 * - 회원 찾기 서비스에게 회원조회 메시지 보내기
 * </pre>
 */

public class MemberManager {
    private MemberCreateService memberCreateService = new MemberCreateService();
    private MemberFindService memberFindService = new MemberFindService();
    private MemberFindByIdService memberFindByIdService = new MemberFindByIdService();

//    private MemberRepository memberRepository = MemberRepository.getInstance(); //위에 두줄 만들고 주석처리

//    // 사용자에게 입력값 받아 저장할때
//    public boolean saveMember(Member member){
//        boolean success = memberRepository.saveMember(member)
//        return success;
//    }

    // 회원정보 모두 명시했을때
//    public boolean saveMember(Member[] members){
//        boolean success = false;
//        for (int i = 0; i < members.length; i++){
//            success = memberRepository.saveMember(members[i]);
//        }
//        return success;
//    }

//    public Member[] readMember(){
//        Member[] members = memberRepository.readMember();
//        return members;
//    }

    public boolean saveMember(Member member){
        boolean success = memberCreateService.saveMember(member);
        return success;
    }
    public Member[] readMember(){
        Member[] members = memberFindService.readMember();
        return members;
    }

    public Member readMemberById(long id) {
        Member member = memberFindByIdService.readMemberById(id);
        return member;
    }
}
