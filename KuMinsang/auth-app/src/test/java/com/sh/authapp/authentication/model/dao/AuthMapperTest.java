package com.sh.authapp.authentication.model.dao;

import com.sh.authapp.authentication.model.dto.MemberDto;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class AuthMapperTest {

    @Autowired
    private AuthMapper authMapper;

    @DisplayName("인증정보 1개 가져오기")
    @Test
    public void test1() {
        //given
        String userName = "minsoo789";
        //when
        MemberDto member = authMapper.findMemberByUserName(userName);
        //then
        assertThat(member).isNotNull();
        assertThat(member.getUserName()).isEqualTo(userName);
    }
}