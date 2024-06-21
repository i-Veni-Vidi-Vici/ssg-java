package com.sh.authapp.model.service;

import com.sh.authapp.model.dao.MemberMapper;
import com.sh.authapp.model.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthQueryService {
    private final MemberMapper memberMapper;

    public MemberDto findByLoginInfo(String username, String password) {
        return memberMapper.findByLoginInfo(username, password);
    }
}
