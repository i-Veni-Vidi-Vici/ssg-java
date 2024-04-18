select
    category_code -- 8
from
    tbl_menu
where
    menu_name = '열무김치라떼';


select
    category_name
from
    tbl_category
where
    category_code = 8;

-- 서브쿼리로 작성
select
    category_name
from
    tbl_category
where
    category_code = (select
                         category_code -- 8
                     from
                         tbl_menu
                     where
                         menu_name = '열무김치라떼'
    );

-- 민트 미역국과 같은 카테고리의 메뉴 조회
select
     menu_name
from
    tbl_menu
where
    category_code = (
        select
            category_code
        from
            tbl_menu
        where
            menu_name = '민트미역국'
    );

# 다중행 서브쿼리
-- 식사류 카테고리 1번일 떄, 모든 식사류 메뉴를 조회
select
    *
from
    tbl_menu
where
    category_code in (select
        c2.category_code
    from
        tbl_category c1 join tbl_category c2 on c1.category_code = c2.ref_category_code
    where
        c1.category_name = '식사'
    );



select * from tbl_menu;
select * from tbl_category;