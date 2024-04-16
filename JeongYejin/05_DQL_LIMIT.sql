/**
----------------------------------------------------------------
  LIMIT
----------------------------------------------------------------
  - LIMIT절은 결과집합에서 반환된 행의 수를 제한하기 위해 사용한다.
  - TOP-N 분석, 페이징처리 등에 사용된다.

  문법
  - LIMIT offset, row_count;
  - 1. offset 건너뛸 행수 (생랼가능)
  - 2. row_count 가져올 행수 (필수)

 */

select *
from tbl_menu
limit
#     0, 3; -- 1, 2, 3
#     3; -- 1, 2, 3
#     1, 3; -- 2, 3, 4
    2, 5;

-- 가격이 제일 비싼 메뉴 5개 조회
select *
from tbl_menu
order by menu_price desc
limit 5;

# 페이징처리
-- 22건 데이터를 한 페이지에 5건씩 노출, 필요한 페이지는 5페이지이다.
-- 전체페이지수 구하기 공식 : 올림 (전체 메뉴수 / 페이지당 메뉴수)

-- 가나다순으로 페이징처리
-- 1페이지
select *
from tbl_menu
order by menu_name
limit 0,5;
-- 2페이지
select *
from tbl_menu
order by menu_name
limit 5,5;
-- 3페이지
select *
from tbl_menu
order by menu_name
limit 10,5;
-- 4페이지
select *
from tbl_menu
order by menu_name
limit 15,5;
-- 5페이지
select *
from tbl_menu
order by menu_name
limit 20,5;

