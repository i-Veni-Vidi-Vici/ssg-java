package com.sh.spring.common.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // autowired안해도 적용된다, 지금 이 상황은 생성자가 하나 이기 때문에 가능하다
public class MemberService {
    private final MemberDao memberDao;

    public MemberDto getMember(Long id){
        System.out.println("MemberService#getMember("+id+")");
        //if(true) throw new RuntimeException("🏎🏎🏎"); // @AfterReturing 테스트용 코드
        return memberDao.getMember(id);
    }

    public boolean addMember(MemberDto memberDto)
    {
        return memberDao.addMember(memberDto);
    }
}
