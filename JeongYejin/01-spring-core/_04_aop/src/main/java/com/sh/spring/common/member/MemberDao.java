package com.sh.spring.common.member;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDao {
    private Map<Long, MemberDto> memberMap;

    public MemberDao() {
        this.memberMap = new HashMap<>();
        this.memberMap.put(1L, new MemberDto(1L, "honggd", "1234", "홍길동"));
        this.memberMap.put(2L, new MemberDto(2L, "sinsa", "1234", "신사임당"));
    }
    public MemberDto getMember(Long id) {
        System.out.println("MemberDao#getMember(" + id + ")");
        return this.memberMap.get(id);
    }

    public boolean addMember(MemberDto member) {
        this.memberMap.put(member.getId(), member);
        return true;
    }
}
