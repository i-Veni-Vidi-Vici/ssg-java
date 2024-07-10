package com.sh.authapp.authentication.model.service;

import com.sh.authapp.authentication.model.dao.AuthMapper;
import com.sh.authapp.authentication.model.dto.MemberDto;
import groovy.util.logging.Slf4j;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthMapper authMapper;

    public MemberDto authenticateMember(MemberDto memberDto){
        MemberDto member = authMapper.findMemberByUserName(memberDto.getUserName());

        if((member != null) && memberDto.getPassword().equals(member.getPassword()) && memberDto.getUserName().equals(member.getUserName())){
            return member;
        }else{
            return null;
        }
    }
}
