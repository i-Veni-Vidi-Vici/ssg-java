-- ===================
-- DQL
-- ===================
-- Data Query language 데이터 질의 언어
-- DML 하위로 분류된다. CRUD 중 READ를 담당.
-- 참조하는 테이블의 데이터를 검색/조회하는 명령
-- 조회결과를 0행 이상의 ResultSet(결과 집합)을 반환한다
-- 조회할 테이블, 특정행, 특정 컬럼, 정렬방식등을 결정할 수 있다

#
select
    *
-- menu_code, menu_name category_code, menu_price, orderable_status
from
    tbl_menu;
# SELECT 산술연산
select
    menu_name, tbl_menu.menu_price, menu_price*1.1
from
    tbl_menu;

-- 5칙연산
select
    6 + 4,
    6 - 4,
    6 * 4,
    6 / 4,  -- 1.50000
    6 div 4,-- 1 몫만 구해줌
    6 % 4,
    6 mod 4;

select
    menu_name as "메뉴명",
    menu_price as "가격",
    category_code '카테코리 코드',
    category_code '카테코리+코드'
from
    tbl_menu;

select
    menu_name,
    menu_price,
    '원' 단위
from
    tbl_menu;

# SELECT DISTINCT
select distinct
    category_code
from
    tbl_menu;

-- null도 하나의 값처럼 취급해 중복을 제거한다
select distinct
    ref_category_code
from
    tbl_category;

-- n개의 컬럼에 대해 distinct 처리
select distinct
    category_code,
    orderable_status
from
    tbl_menu;

-- concat
select
    menu_name,
--    menu_price + '원' -- +는 항상 산술연산을 의미. 숫자로 변경 불가한 문자열은 0으로 처리됨
    menu_price,
    concat('$', menu_price, '원')
from
    tbl_menu