package com.sh.authapp.model.service;

import com.sh.authapp.model.dao.MemberMapper;
import com.sh.authapp.model.dto.MemberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class AuthQueryServiceTest {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    @DisplayName("아이디 비밀번호 일치 여부 확인")
    void test1() {
        // given
        String username = "chulsoo123";
        String password = "password1";
        // when
        MemberDto memberDto = memberMapper.findByLoginInfo(username, password);
        // then
        System.out.println(memberDto.toString());
        assertThat(memberDto)
                .isNotNull()
                .satisfies(
                        (_memberDto) -> assertThat(_memberDto.getId()).isPositive(),
                        (_memberDto) -> assertThat(_memberDto.getUsername()).isEqualTo(username),
                        (_memberDto) -> assertThat(_memberDto.getPassword()).isEqualTo(password),
                        (_memberDto) -> assertThat(_memberDto.getEmail()).isNotNull(),
                        (_memberDto) -> assertThat(_memberDto.getCreatedAt()).isNotNull()
                );
    }
}