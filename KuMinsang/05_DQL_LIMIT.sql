-- ---
-- LIMIT
-- ---

select
    *
from
    tbl_menu
 limit  0, 3;

-- 가격이 제일 비싼 메뉴 5개 조회
select
    *
from
    tbl_menu
order by
    menu_price desc
limit 0, 5;

-- 페이지 처리
-- 1페이지
select
    *
from
    tbl_menu
order by
    menu_name
limit 0, 5;

-- 2페이지
select
    *
from
    tbl_menu
order by
    menu_name
limit 5, 5;

-- 3페이지
select
    *
from
    tbl_menu
order by
    menu_name
limit 10, 5;

-- 4페이지
select
    *
from
    tbl_menu
order by
    menu_name
limit 15, 5;

-- 5페이지
select
    *
from
    tbl_menu
order by
    menu_name
limit 20, 5;

