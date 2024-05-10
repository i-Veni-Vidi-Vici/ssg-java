package com.sh.menu.model.dao;

import com.sh.menu.model.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;

import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

class MenuMapperCommandTest {
    SqlSession sqlSession; // 테스트에 도움이 되는 대상
    MenuMapper menuMapper; // 테스트에 도움이 되는 대상


    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.menuMapper = this.sqlSession.getMapper(MenuMapper.class);
    }

    @AfterEach
    void tearDown() {
//        this.sqlSession.commit(); // 생략해도 SqlSession 해제 시 자동 커밋된다.
        this.sqlSession.rollback();
        this.sqlSession.close();
    }

    @Disabled // 해당 테스트는 무시
    @Test
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
        int menuCode =menuDto.getMenuCode();
        assertThat(menuCode).isNotZero();

        // 등록된 행을 조회해서 컬럼값 비교
        MenuDto menuDto2 = menuMapper.findByMenuCode(menuCode);
        assertThat(menuDto2.getMenuCode()).isEqualTo(menuCode);
        assertThat(menuDto2.getMenuName()).isEqualTo(menuName);
        assertThat(menuDto2.getMenuPrice()).isEqualTo(menuPrice);
        assertThat(menuDto2.getCategoryCode()).isEqualTo(categoryCode);
        assertThat(menuDto2.getOrderableStatus()).isEqualTo(orderableStatus);
    }

    @DisplayName("한건의 메뉴데이터를 수정할 수 있다.")
    @Test
    void updateMenu() {
        // given 임의의 데이터를 생성
        String menuName = "가리비막국수";
        int menuPrice = 13000;
        int categoryCode = 4;
        String orderableStatus = "Y";
        MenuDto menuDto = new MenuDto(0, menuName, menuPrice, categoryCode, orderableStatus);

        //새 데이터 입력
        menuMapper.insertMenu(menuDto);
        int menuCode = menuDto.getMenuCode();

        // 수정할 데이터
        String newMenuName = "족발라떼";
        int newMenuPrice = 3100;
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
    @DisplayName("한건의 메뉴 데이터를 삭제할 수 있다.")
    @Test
    void deleteMenu() {
        // given 임의의 데이터를 생성
        String menuName = "가리비막국수";
        int menuPrice = 13000;
        int categoryCode = 4;
        String orderableStatus = "Y";
        MenuDto menuDto = new MenuDto(0, menuName, menuPrice, categoryCode, orderableStatus);

        //새 데이터 입력
        menuMapper.insertMenu(menuDto);
        int menuCode = menuDto.getMenuCode();

        // when
        int result = menuMapper.deleteMenu(menuCode);

        // then
        assertThat(result).isEqualTo(1);
        assertThat(menuMapper.findByMenuCode(menuCode)).isNull();

    }
}