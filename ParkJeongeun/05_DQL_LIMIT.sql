-- --------------------------------
-- LIMIT
-- --------------------------------
-- LIMIT절은 결과집합에서 반환된 행의 수를 제한하기 위해 사용
-- Top-N분석(순위 추출), 페이징 처리 등에 사용됨

# 문법
-- LIMIT offset, row_count;
-- 1. offset : 건너띌 행 수(생략가능)
-- 2. row_count : 가져올 행 수(필수)

select
    *
from
    tbl_menu
limit
#    0, 3; -- 앞에서부터(0개 건너띄고) 3개 반환
#    3; -- 윗줄과 동일
    1, 3; -- 첫째줄 건너띄고 menu_code 2, 3, 4 행 반환

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
-- 22건 데이터를 한 페이지에 5건씩 노출하는 경우, 5페이지 필요
-- 전체 페이지수 구하기 공식 : 올림(전체 메뉴 수 / 페이지 당 메뉴 수)

-- 가나다순으로 페이징 처리
-- 1페이지
select *
from tbl_menu
order by menu_name
limit 0, 5;
-- 2페이지
select *
from tbl_menu
order by menu_name
limit 5, 5;
-- 3페이지
select *
from tbl_menu
order by menu_name
limit 10, 5;
-- 4페이지
select *
from tbl_menu
order by menu_name
limit 15, 5;
-- 5페이지
select *
from tbl_menu
order by menu_name
limit 20, 2;