package com.sh._03_spring_crud.menu.model.service;

import com.sh._03_spring_crud.menu.model.dao.MenuMapper;
import com.sh._03_spring_crud.menu.model.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MenuCommandService {
    private final MenuMapper menuMapper;


    public int insertMenu(MenuDto menuDto) {

        return menuMapper.insertMenu(menuDto);
    }
}
