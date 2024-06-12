package com.sh.spring.common.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
//    @Autowired
    private final MemberDao memberDao;

    public MemberDto getMember(Long id) {
        System.out.println("MemberService getMember(" + id + ")");
        // @AfterRunning test 코드
//        if (true) throw new RuntimeException("오류!!오류!!!!");
        return memberDao.getMember(id);
    }

    public boolean addMember(MemberDto memberDto) {
        return memberDao.addMember(memberDto);
    }
}
