-- -----------------------------
-- ORDER BY
-- -----------------------------
-- ResultSet 행에 대한 정렬을 지정하는 구문
-- DQL에 Select구문 다음에 실행.
-- 문자/숫자/날짜시간에 대해 오름차순(ASC)/내림차순(DESC) 정렬 작성
-- 컬럼명, 컬럼순서, 별칭으로 지정 가능

select
    *
from
    tbl_menu
order by
    menu_code desc;

-- 두개이상의 컬럼에 대해서 정렬 지원
-- 카테고리코드 오름차순, 가격 내림차순
-- 우선 카테고리코드 오름차순 적용, 카테고리코드가 같은 경우 두번째 가격 내림차순

select
    *
from
    tbl_menu
order by
    category_code asc,
    menu_price desc;

-- select 절의 컬럼순서로 지정가능
select
    menu_name,
    menu_code,
    menu_price,
    category_code,
    orderable_status
from
    tbl_menu
order by
    2;

-- 별칭으로 컬럼지정
select
    menu_name 메뉴명,
    menu_code 메뉴코드,
    menu_price 메뉴가격,
    category_code 메뉴카테고리,
    orderable_status 주문가능여부
from
    tbl_menu
order by
    메뉴가격 desc;

-- 가상컬럼값 기준
select
    menu_name,
    menu_price,
    category_code,
    menu_price* category_code
from
    tbl_menu
order by
    menu_price * category_code;

-- 특정컬럼값을 변환해서 기준으로 사용
-- field(src,val1,val2,val3,.....) : 일치하는 값의 인덱스 반환
select
    field('A','A','B','C'), -- 1
    field('B','A','B','C'), -- 2
    field('X','A','B','C'); -- 0 (mysql에서는 존재하지 않는 인덱스)

select
    menu_name,
    orderable_status,
    field(orderable_status,'Y','N')
from
    tbl_menu
order by
    field(orderable_status,'Y','N');

-- null관련
-- 오름차순 정렬에서 NULL값은 기본적으로 맨 위에 온다.
-- 내림차순 정렬에서 NULL값은 기본적으로 맨 아래에 온다.
select
    *
from
    tbl_menu
order by
    category_code is null asc, -- is null asc에서는 null값이 가장 밑에 온다.
    category_code;


select
    *
from
    tbl_menu
order by
    category_code is null desc, -- is null desc에서는 null값이 가장 먼저 나온다.
    category_code desc;



