package com.sh.authapp.model.dao;

import com.sh.authapp.model.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    MemberDto findByLoginInfo(String username, String password);
}
