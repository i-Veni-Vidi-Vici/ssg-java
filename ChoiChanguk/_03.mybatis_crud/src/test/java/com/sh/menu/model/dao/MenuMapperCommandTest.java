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
    //위에 속성들을 Fixture라고 한다, 테스트를 위한 속성

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menuDto = new MenuDto();
    }

    @AfterEach
    void tearDown() {
        // 테스트 환경 제외
        //this.sqlSession.commit();// 생략해도 sqlSession 해제 시 자동으로 commit이 된다
        this.sqlSession.rollback();
        this.sqlSession.close();
    }


    @DisplayName("주문 가능한 메뉴 출력")
    @Test
    void findOrderableStatus()
    {
        sqlSession=getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> menuDtos=menuMapper.findOrderableStatus();
        System.out.println(menuDtos);

    }
    @DisplayName("주문 가능한 메뉴 출력")
    @Test
    void findByOrderableCategoryCodeMenu(){
        int catogory_code=4;
        sqlSession=getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> menuDtos=menuMapper.findByOrderableCategoryCodeMenu(catogory_code);
        for(MenuDto menuDto : menuDtos) {
            System.out.printf("%d\t%-15s%s\t%d\t%s\n",
                    menuDto.getMenuCode(),
                    menuDto.getMenuName(),
                    menuDto.getMenuPrice(),
                    menuDto.getCategoryCode(),
                    menuDto.getOrderableStatus()
            );
        }
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
    /**
     * <pre>
     * 요구사항대로 테스트를 작성해야 한다.
     * given-when-then패턴을 적용해서 작성한다
     * 준비   실행   검증 단계로 테스트를 작성
     * </pre>
     */

   
}