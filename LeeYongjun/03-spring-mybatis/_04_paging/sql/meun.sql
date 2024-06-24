-- 페이징 쿼리 테스트
-- 전체메뉴가 61개(orderable_status = 'Y)일떄, 한페이지당 10개씩 노출한다.
-- 1페이지 1~10 -> limit 0, 10
-- 2페이지 10~20 -> limit 10, 10
-- 3페이지 20~30 -> limit 20, 10
-- 4페이지 30~40 -> limit 30, 10
-- 5페이지 40~50 -> limit 40, 10
-- 6페이지 50~60 -> limit 50, 10
-- 7페이지 60~70 -> limit 60, 10
select
    *
from tbl_menu m left join tbl_category c
            on m.category_code = c.category_code
where
    orderable_status
                = 'Y'
limit

    60, 10; -- 7페이지 (마지막페이지)