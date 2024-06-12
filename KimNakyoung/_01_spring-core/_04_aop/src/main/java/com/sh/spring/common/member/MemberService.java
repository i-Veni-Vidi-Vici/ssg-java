package com.sh.spring.common.member;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao memberDao;

    public MemberDto getMember(Long id) {
        System.out.println("MemberService#getMember(" + id + ")");
        //@AfterReturning 테스트용 코드 이거 테스트할 때 사용하세요~
//        if(true) throw new RuntimeException("🍖🍖🍖"); // 예외가 발생하면 얘를 실행한다. // 예외처리를 한건 아님 그냥 예외 발생시 이거 실행한다~
        return memberDao.getMember(id);
    }

    public boolean addMember(MemberDto memberDto) {

        return memberDao.addMember(memberDto);
    }
}
