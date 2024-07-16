package com.sh.app.member.service;

import com.sh.app.member.dto.MemberRegisterRequestDto;
import com.sh.app.member.dto.MemberUpdateRequestDto;
import com.sh.app.member.entity.Member;
import com.sh.app.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void register(MemberRegisterRequestDto dto) {
        Member member = dto.toMember();
        // 기본권한 설정
        member.setDefaultAuthorities();
    }

    public void update(MemberUpdateRequestDto dto) {
        Member member = memberRepository.findByUsername(dto.getMemberId()).orElseThrow();
        member.changeName(dto.getName());
    }
}
