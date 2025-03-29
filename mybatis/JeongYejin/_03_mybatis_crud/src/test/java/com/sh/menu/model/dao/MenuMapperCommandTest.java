package com.sh.menu.model.dao;

import com.sh.menu.model.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;

import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

class MenuMapperCommandTest {

    // Fixture
    SqlSession sqlSession;
    // 테스트 하는 데 도움이 되는 대상
    MenuMapper menuMapper;
    // 테스트 대상

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.menuMapper = sqlSession.getMapper(MenuMapper.class);
    }

    @AfterEach
    void tearDown() {
//        this.sqlSession.commit(); // 생략해도 자동 커밋된다
        // 런 중에는 락이 걸려서 외부에서 접근이 불가능하기 때문에
        // SqlSession 해제시 자동 커밋된다
        this.sqlSession.rollback();
        // rollback()을 해도 DML은 한번이라도 테스트하면 행이 안 남아도 auto-increment는 증가된다
        this.sqlSession.close();
    }

    @Disabled // 해당 테스트는 무시
    @Test
    void insertMenu() {
        // given
        int menuCode = 0;
        String menuName = "가리비막국수";
        int menuPrice = 13000;
        int categoryCode = 4;
        String orderableStatus = "Y";
        MenuDto menuDto = new MenuDto(menuCode, menuName, menuPrice, categoryCode, orderableStatus);
        // when
        int result = menuMapper.insertMenu(menuDto);
        // then
        assertThat(result).isEqualTo(1);
        // 등록된 행을 조회해서 컬럼값 비교
        // lastinsertid
//        MenuDto menuDto2 = menuMapper.findByMenuCode();
        // 등록된 행의 pk컬럼 가져오기
        menuCode = menuDto.getMenuCode();
        assertThat(menuCode).isNotZero();

        // 등록된 행을 조회해서 컬럼값 비교
        MenuDto menuDto2 = menuMapper.findByMenuCode(menuCode);
        assertThat(menuDto2.getMenuCode()).isEqualTo(menuCode);
        assertThat(menuDto2.getMenuName()).isEqualTo(menuName);
        assertThat(menuDto2.getMenuPrice()).isEqualTo(menuPrice);
        assertThat(menuDto2.getCategoryCode()).isEqualTo(categoryCode);
        assertThat(menuDto2.getOrderableStatus()).isEqualTo(orderableStatus);
        System.out.println(menuCode);
    }

    @DisplayName("한건의 메뉴데이터를 수정할 수 있다.")
    @Test
    void updateMenu() {
        // given
        int menuCode = 28;
        String menuName = "가리비막국수";
        int menuPrice = 13000;
        int categoryCode = 4;
        String orderableStatus = "Y";
        MenuDto menuDto = new MenuDto(menuCode, menuName, menuPrice, categoryCode, orderableStatus);
        // 새 데이터 입력
        menuMapper.insertMenu(menuDto);
//        menuCode = menuDto.getMenuCode();
        // 수정할 데이터
        String newMenuName = "족발라떼";
        int newMenuPrice = 13000;
        int newCategoryCode = 8;
        String newOrderableStatus = "Y";
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
        assertThat(menuDto2.getMenuName()).isEqualTo(newMenuName);
        assertThat(menuDto2.getMenuPrice()).isEqualTo(newMenuPrice);
        assertThat(menuDto2.getCategoryCode()).isEqualTo(newCategoryCode);
        assertThat(menuDto2.getOrderableStatus()).isEqualTo(newOrderableStatus);
        System.out.println(menuCode);
    }

    @DisplayName("한건의 메뉴데이터를 삭제할 수 있다.")
    @Test
    void deleteMenu() {
        // given
        int menuCode = 28;
        String menuName = "가리비막국수";
        int menuPrice = 13000;
        int categoryCode = 4;
        String orderableStatus = "Y";
        MenuDto menuDto = new MenuDto(menuCode, menuName, menuPrice, categoryCode, orderableStatus);
        // 새 데이터 입력
        menuMapper.insertMenu(menuDto);
        menuCode = menuDto.getMenuCode();
        // when
        int result = menuMapper.deleteMenu(menuCode);

        // then
        assertThat(result).isEqualTo(1);
        assertThat(menuMapper.findByMenuCode(menuCode)).isNull();
    }
}