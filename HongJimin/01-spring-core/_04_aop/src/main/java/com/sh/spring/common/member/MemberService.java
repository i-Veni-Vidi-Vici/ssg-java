package com.sh.spring.common.member;

import com.sun.source.tree.MemberReferenceTree;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao memberDao;

    public MemberDto getMember(Long id) {
        System.out.println("MemberService#getMember(" + id + ")");
        // @AfterReturning 테스트용 코드
        // if(true) throw new RuntimeException("🎀🎀🎀🎀");
        return memberDao.getMember(id);
    }

    public boolean addMember(MemberDto memberDto) {
        return memberDao.addMember(memberDto);
    }
}
