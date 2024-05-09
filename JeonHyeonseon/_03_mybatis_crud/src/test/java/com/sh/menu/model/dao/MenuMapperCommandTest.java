package com.sh.menu.model.dao;

import com.sh.menu.model.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;

import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

class MenuMapperCommandTest {
    SqlSession sqlSession;
    MenuMapper menuMapper;

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.menuMapper = this.sqlSession.getMapper(MenuMapper.class);
    }

    @AfterEach
    void tearDown() {
        //this.sqlSession.commit(); // 생략해도 SqlSession 해제시 자동커밋된다. (테스트 환경 제외)
        this.sqlSession.rollback();
        this.sqlSession.close();
    }

    @Test
    @Disabled // 해당테스트는 무시
    void insertMenu() {
        // given
        String menuName = "가리비막국수";
        int menuPrice = 13000;
        int categoryCode = 4;
        String orderableStatus = "Y";
        MenuDto menuDto = new MenuDto(0, menuName, menuPrice, categoryCode, orderableStatus);
        // when
        int result = menuMapper.insertMenu(menuDto);
        // then
        assertThat(result).isEqualTo(1);
        // 등록된 행의 pk컬럼 가져오기
        int menuCode = menuDto.getMenuCode();
        assertThat(menuDto.getMenuCode()).isNotZero();
        System.out.println(menuCode);
        // 등록된 행을 조회해서 컬럼값 비교
        MenuDto menuDto2 = menuMapper.findByMenuCode(menuCode);
        assertThat(menuDto2.getMenuCode()).isEqualTo(menuCode);
        assertThat(menuDto2.getMenuName()).isEqualTo(menuName);
        assertThat(menuDto2.getMenuPrice()).isEqualTo(menuPrice);
        assertThat(menuDto2.getCategoryCode()).isEqualTo(categoryCode);
        assertThat(menuDto2.getOrderableStatus()).isEqualTo(orderableStatus);
    }

    @Disabled
    @DisplayName("한건의 메뉴데이터를 수정할 수 있다.")
    @Test
    void updateMenu() {
        // given 임의의 데이터생성
        String menuName = "가리비막국수";
        int menuPrice = 13000;
        int categoryCode = 4;
        String orderableStatus = "Y";
        MenuDto menuDto = new MenuDto(0, menuName, menuPrice, categoryCode, orderableStatus);
        // 새 데이터 입력
        menuMapper.insertMenu(menuDto);
        int menuCode = menuDto.getMenuCode();
        // 수정할 데이터
        String newMenuName = "족발라떼";
        int newMenuPrice = 31000;
        int newCategoryCode = 5;
        String newOrderableStatus = "N";
        menuDto.setMenuName(newMenuName);
        menuDto.setMenuPrice(newMenuPrice);
        menuDto.setCategoryCode(newCategoryCode);
        menuDto.setOrderableStatus(newOrderableStatus);
        // when
        int result = menuMapper.updateMenu(menuDto);
        // then
        assertThat(result).isEqualTo(1);
        // 등록된 행을 조회해서 컬럼값 비교
        MenuDto menuDto2 = menuMapper.findByMenuCode(menuCode);
        assertThat(menuDto2.getMenuCode()).isEqualTo(menuCode);
        assertThat(menuDto2.getMenuName()).isEqualTo(newMenuName);
        assertThat(menuDto2.getMenuPrice()).isEqualTo(newMenuPrice);
        assertThat(menuDto2.getCategoryCode()).isEqualTo(newCategoryCode);
        assertThat(menuDto2.getOrderableStatus()).isEqualTo(newOrderableStatus);
    }

    @Disabled
    @DisplayName("한건의 메뉴데이터를 삭제할 수 있다.")
    @Test
    void deleteMenu() {
        // given 임의의 데이터생성
        String menuName = "가리비막국수";
        int menuPrice = 13000;
        int categoryCode = 4;
        String orderableStatus = "Y";
        MenuDto menuDto = new MenuDto(0, menuName, menuPrice, categoryCode, orderableStatus);
        // 새 데이터 입력
        menuMapper.insertMenu(menuDto);
        int menuCode = menuDto.getMenuCode();
        // when
        int result = menuMapper.deleteMenu(menuCode);
        // then
        assertThat(result).isEqualTo(1);
        assertThat(menuMapper.findByMenuCode(menuCode)).isNull();
    }
}