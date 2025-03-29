package com.sh.menu.dao;

import com.sh.menu.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;

import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

class MenuMapperCommandTest {
    //Fixture : 테스트 할 때 필요한 대상(MenuMapper) + 테스트 할 때 도움이되는 대상(SqlSession)
    SqlSession sqlSession;
    MenuMapper menuMapper;

    @BeforeEach
    void setUp() {
        /**
         * 공통적으로 들어가는 코드 객체 생성할 때마다 동작하도록 BeforeEach에 설정
         */
        sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
    }

    @AfterEach
    void tearDown() {
        // commit code를 생략해도 SqlSession 해제시 자동 commit된다.(테스트 환경 제외)
        // commit이 되지 않으면 다른 클라이언트가 요청 할 때 테이블 자체가 Lock이 걸려서 이용하지 못하기 떄문에
        this.sqlSession.commit();
        this.sqlSession.close();
    }

    @Test
    @Disabled // 해당 테스트 무시
    void insertMenu() {
        //given
        //MenuDto menuDto = new MenuDto() : 이렇게 변수를 설정하면 검증하는 과정에서 힘듦.
        String menuName = "가리비 막국수";
        int menuPrice = 13000;
        int categoryCdoe = 4;
        String orderableStatus = "Y";
        MenuDto menuDto = new MenuDto(0, menuName, menuPrice, categoryCdoe, orderableStatus);
        //when
        int result = menuMapper.insertMenu(menuDto);
        //then
        assertThat(result).isEqualTo(1);

        //등록된 행의 pk컬럼을 가져오기
        int menuCode = menuDto.getMenuCode();
        assertThat(menuDto.getMenuCode()).isNotZero();
        System.out.println(menuCode);

        // 등록된 행을 조회해서 컬럼값을 비교
        MenuDto menuDto2 = menuMapper.findByMenuCode(menuCode);
        assertThat(menuDto2.getMenuCode()).isEqualTo(menuCode);
        assertThat(menuDto2.getMenuName()).isEqualTo(menuName);
        assertThat(menuDto2.getMenuPrice()).isEqualTo(menuPrice);
        assertThat(menuDto2.getCategoryCode()).isEqualTo(categoryCdoe);
        assertThat(menuDto2.getOrderableStatus()).isEqualTo(orderableStatus);

    }
    @Disabled
    @Test
    @DisplayName("한 건의 메뉴 데이터를 수정할 수 있다.")
    void updateMenu () {
        //given
        String menuName = "가리비 막국수";
        int menuPrice = 13000;
        int categoryCdoe = 4;
        String orderableStatus = "Y";
        MenuDto menuDto = new MenuDto(0, menuName, menuPrice, categoryCdoe, orderableStatus);
        //새 데이터 입력
        menuMapper.insertMenu(menuDto);
        int menuCode = menuDto.getMenuCode();

        //수정 할 데이터
        String newMenuName = "족발라떼";
        int newMenuPrice = 3100;
        int newCategoryCode = 5;
        String newOrderableStatus = "N";
        menuDto.setMenuName(newMenuName);
        menuDto.setMenuPrice(newMenuPrice);
        menuDto.setCategoryCode(newCategoryCode);
        menuDto.setOrderableStatus(newOrderableStatus);

        //when
        int result = menuMapper.updateMenu(menuDto);

        //then

        //등록된 행을 조회해서 컬럼값 비교
        assertThat(result).isEqualTo(1);
        MenuDto menuDto2 = menuMapper.findByMenuCode(menuCode);
        assertThat(menuDto2.getMenuCode()).isEqualTo(menuCode);
        assertThat(menuDto2.getMenuName()).isEqualTo(newMenuName);
        assertThat(menuDto2.getMenuPrice()).isEqualTo(newMenuPrice);
        assertThat(menuDto2.getCategoryCode()).isEqualTo(newCategoryCode);
        assertThat(menuDto2.getOrderableStatus()).isEqualTo(newOrderableStatus);

    }
    @Disabled
    @Test
    @DisplayName("한건의 데이터를 삭제할 수 있다.") // 해당 테스트 무시
    void deletMenu() {
        //given
        String menuName = "가리비 막국수";
        int menuPrice = 13000;
        int categoryCdoe = 4;
        String orderableStatus = "Y";
        MenuDto menuDto = new MenuDto(0, menuName, menuPrice, categoryCdoe, orderableStatus);

        //새 데잍 ㅓ입력
        menuMapper.insertMenu(menuDto);
        int menuCode = menuDto.getMenuCode();

        int result = menuMapper.deleteMenu(menuCode);

        //then
        assertThat(result).isEqualTo(1);
        assertThat(menuMapper.findByMenuCode(menuCode)).isNull();
    }




}
