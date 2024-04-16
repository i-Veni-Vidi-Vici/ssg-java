-- ---------------------------------------
-- LIMIT
-- ---------------------------------------
-- 결과 집합에서 반환된 행의 수를 제한하기 위해 사용
-- Top-N 분석(가장 많은 것, 적은 것 등), 페이징 처리(검색 결과가 많을 때, 여러 페이지로 나누는 것) 등에 사용됨

# 문법
-- LIMIT offset, row_count;
-- offset : 건너뛸 행의 수(생략 가능)
-- row_count : 가져올 행의 수(필수)

select
    *
from
    tbl_menu
limit
#     0, 3; -- 1, 2, 3
#     3; -- 1, 2, 3
    1, 3; -- 2, 3, 4

-- 가격이 제일 비싼 메뉴 5개 조회
select
    *
from
    tbl_menu
order by
    menu_price desc
limit
    5;

# 페이징 처리
-- 22건의 데이터를 한 페이지에 5건 씩 노출하는 경우, 필요한 페이지는? 5 페이지다.
-- 전체 페이지수 구하기 공식 : 올림(전체 메뉴수 / 페이지당 메뉴수)
-- 올림(22 / 5) -> 5페이지
-- 1 페이지 1 ~ 5
-- 2 페이지 6 ~ 10
-- 3 페이지 11 ~ 15
-- 4 페이지 16 ~ 20
-- 5 페이지 21 ~ 25(22까지만 표시)

-- 가나다순으로 페이징 처리
-- 1 페이지
select
    *
from
    tbl_menu
order by
    menu_name
limit
    0, 5;

-- 2 페이지
select
    *
from
    tbl_menu
order by
    menu_name
limit
    5, 5;

-- 3 페이지
select
    *
from
    tbl_menu
order by
    menu_name
limit
    10, 5;

-- 4 페이지
select
    *
from
    tbl_menu
order by
    menu_name
limit
    15, 5;

-- 5 페이지
select
    *
from
    tbl_menu
order by
    menu_name
limit
    20, 2;
