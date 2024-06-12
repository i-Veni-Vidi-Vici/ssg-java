package com.sh.spring.common.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao memberDao;

    public MemberDto getMember(Long id) {
        System.out.println("MemberService#getMember(" + id + ")");
        return memberDao.getMember(id);
    }

    public boolean addMember(MemberDto memberDto) {
        return memberDao.addMember(memberDto);
    }
}
