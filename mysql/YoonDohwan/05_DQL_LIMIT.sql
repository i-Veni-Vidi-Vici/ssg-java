-- --------------
-- LIMIT
-- --------------
-- LIMIT절은 결과집합에서 반환된 행의 수를 제한하기 위해 사용한다.
-- TOP-N분석, 페이징처리등에 사용된다.

#문법
-- LIMIT offset, row_count;
-- 1.offset 건너뛸 행수(생략가능)
-- 2.row_count 가져올 행수(필수)

select
    *
from
    tbl_menu
limit 0,3;

-- 가격이 제일 비싼 메뉴 5개 조회
select
    *
from tbl_menu
order by
    menu_price desc
limit 0,5;

# 페이징처리
-- 22건 데이터를 한 페이지에 5건씩 노출하는 경우, 필요한 페이지는 5페이지이다.

-- 가나다순으로 페이징처리
-- 1페이지
    select *
    from tbl_menu
    order by menu_name
    limit
    0,5;
-- 2페이지
select *
from tbl_menu
order by menu_name
limit
    5,10;
-- 3페이지
select *
from tbl_menu
order by menu_name
limit
    10,15;
-- 4페이지
select *
from tbl_menu
order by menu_name
limit
    15,20;
-- 5페이지
select *
from tbl_menu
order by menu_name
limit
    20,22;
