package com.sh.spring.common.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 이후 @ComponentScan 어노테이션에 의해서 빈으로 자동등록
 */
@Component("memberDao")
public class MemberDao {
    private final Map<Long, MemberDto> memberMap;

    public MemberDao() {
        this.memberMap = new HashMap<>();
        // MemberDao빈 하위에서 관리되는 MemberDto객체는 빈이 아니다.
        this.memberMap.put(1L, new MemberDto(1L, "honggd", "1234", "홍길동"));
        this.memberMap.put(2L, new MemberDto(2L, "sinsa", "1234", "신사임당"));
    }

    public MemberDto getMember(Long id) {
        return this.memberMap.get(id);
    }

    public boolean addMember(MemberDto member) {
        this.memberMap.put(member.getId(), member); // key값과 연결되었던 이전 값 반환
        return true;
    }
}