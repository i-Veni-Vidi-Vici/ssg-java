package com.sh.app.menu.service;

import com.sh.app.menu.dto.MenuCategoryResponseDto;
import com.sh.app.menu.dto.MenuRegistRequestDto;
import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public Page<Menu> findAll(Pageable pageable) {
        return menuRepository.findAll(pageable);
    }

    public MenuCategoryResponseDto findByMenuCode(Long menuCode) {
        return menuRepository.findMenuAndCategory(menuCode);
    }

    public void regist(MenuRegistRequestDto dto) {
        Menu menu = dto.toMenu();
        menuRepository.save(menu);
    }
}
