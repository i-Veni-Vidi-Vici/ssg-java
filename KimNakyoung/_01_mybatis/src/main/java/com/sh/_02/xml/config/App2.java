package com.sh._02.xml.config;
import com.sh._02.xml.config.MenuDto;
import com.sh._02.xml.config.MenuMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSesstion;

public class App2 {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml"; // resources폴더 하위경로

            SqlSession sqlSession = getSqlSesstion(); // 세션가져옴

            MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
            MenuDto menuDto = menuMapper.findByMenuCode(1);
            System.out.println(menuDto);

            List<MenuDto> list = menuMapper.findAll();
            System.out.println(list);




            sqlSession.close();

            // mvc 구조에서는 서비스단


    }
}
