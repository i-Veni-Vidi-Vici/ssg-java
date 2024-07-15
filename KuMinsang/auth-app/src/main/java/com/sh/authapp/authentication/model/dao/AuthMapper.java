package com.sh.authapp.authentication.model.dao;

import com.sh.authapp.authentication.model.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {
    MemberDto findMemberByUserName(String userName);
}
