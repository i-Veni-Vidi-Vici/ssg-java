package com.sh.app.menu.service;

import com.sh.app.menu.dto.*;
import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public Page<MenuListResponseDto> findAll(String q, Pageable pageable) {
        // Page객체에는 content의 요소를 순회하면서 각 요소를 DTO로 변환할수 있는 map메소드를 제공.
        Page<Menu> menuPage = q != null ?
                menuRepository.findByMenuNameContaining(q, pageable) :
                menuRepository.findAll(pageable);
        return menuPage.map(MenuListResponseDto::fromMenu);
    }

    public MenuCategoryResponseDto findByMenuCode(Long menuCode) {
        return menuRepository.findMenuAndCategory(menuCode);
    }

    public void regist(MenuRegistRequestDto dto) {
        Menu menu = dto.toMenu();
        menu = menuRepository.save(menu);
    }

    public MenuDetailResponseDto findById(Long menuCode) {
        return MenuDetailResponseDto.fromMenu(menuRepository.findById(menuCode).orElseThrow());
    }

    public void update(MenuUpdateRequestDto dto) {
        // 엔티티 조회
        Menu menu = menuRepository.findById(dto.getMenuCode()).orElseThrow();
        // 엔티티 수정 (엔티니의 내부 수정은 엔티티 객체의 책임이어야 한다.)
        menu.update(dto);
        // 트랜잭션 종료시 flush & commit (경우에 따라 save를 명시적으로 호출해야 할수도 있다.)
    }

    /**
     * <pre>
     * 삭제처리는 두가지 방식으로 진행할 수 있다.
     * - 조회한 entity를 삭제 
     * - id값으로 삭제요청
     * </pre>
     *
     * @param menuCode
     */
    public void delete(Long menuCode) {
        // 삭제1
//        Menu menu = menuRepository.findById(menuCode).orElseThrow();
//        menuRepository.delete(menu);
        // 삭제2
        menuRepository.deleteById(menuCode);
    }
}
