package com.sh.authapp.authentication.model.service;

import com.sh.authapp.authentication.model.dao.AuthMapper;
import com.sh.authapp.authentication.model.dto.MemberDto;
import groovy.util.logging.Slf4j;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.mock.web.MockHttpSession;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class AuthenticationServiceTest {

    @Autowired
    AuthMapper authMapper;

    @DisplayName("인증 서비스 성공")
    @Test
    public void test1() {
        //given
        MemberDto member = MemberDto.builder()
                .userName("minsoo789")
                .password("password3")
                .build();
        //when
        AuthenticationService authenticationService = new AuthenticationService(authMapper);
        MemberDto resultMember = authenticationService.authenticateMember(member);

        //then
        assertThat(resultMember).isNotNull();
        assertThat(resultMember.getName()).isEqualTo("박민수");
        System.out.println(resultMember);
    }

    @DisplayName("인증 서비스 실패")
    @Test
    public void test2() {
        //given
        MemberDto member = MemberDto.builder()
                .userName("minsoo789")
                .password("password")
                .build();
        //when
        AuthenticationService authenticationService = new AuthenticationService(authMapper);
        MemberDto resultMember = authenticationService.authenticateMember(member);

        //then
        assertThat(resultMember).isNull();
    }

}