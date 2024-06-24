package com.sh._04_paging.menu.model.service;

import com.sh._04_paging.menu.model.dao.MenuMapper;
import com.sh._04_paging.menu.model.dto.MenuDto;
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
