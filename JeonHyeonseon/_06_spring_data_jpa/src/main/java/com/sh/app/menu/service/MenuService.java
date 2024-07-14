package com.sh.app.menu.service;

import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional // 서비스는 무조건 @Transactional 붙여놓기
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    // Pageable을 넘겨버리면 List가 아니라 Page로 반환되어야 한다.
    public Page<Menu> findAll(Pageable pageable) {
        return menuRepository.findAll(pageable);
    }
}
