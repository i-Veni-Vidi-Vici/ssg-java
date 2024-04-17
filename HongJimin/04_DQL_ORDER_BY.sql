-- ---------------------------------------
-- ORDER BY
-- ---------------------------------------
-- ResultSet 행에 대한 정렬을 지정하는 구문
-- DQL에 Select 구문 다음에 실행
-- 문자/숫자/날짜 시간(과거 ~ 미래)에 대해 오름차순(ASC)/내림차순(DESC) 정렬 작성
-- 컬럼명, 컬럼순서, 별칭으로 지정 가능

select
    *
from
    tbl_menu
order by
#     menu_code; -- asc 오름차순 기본값
#     menu_code desc; -- 내림차순
#     menu_name asc; -- 오름차순
    menu_name desc ; -- 내림차순

-- 두개 이상의 컬럼에 대해 정렬 지원
-- 카테고리 코드 오름차순, 가격 내림차순
-- 우선 카테고리 코드 오름차순 적용, 카테고리 코드가 같은 경우 가격 내림차순 적용
select
    *
from
    tbl_menu
order by
    category_code asc,
    menu_price desc;

-- select 절의 컬럼 순서로 지정 가능
select
#     *
    menu_name,
    menu_code
    menu_price,
    category_code,
    orderable_status
from
    tbl_menu
order by
    2; -- 컬럼 순서, 위의 적힌 순서에 맞게 분류됨/ ⛳테이블의 적힌 순서가 아님!

-- 별칭으로 컬럼 지정
select
    menu_name 메뉴코드,
    menu_code 메뉴명,
    menu_price 메뉴가격,
    category_code 카테고리번호,
    orderable_status 주문가능여부
from
    tbl_menu
order by
    메뉴가격 DESC;

-- 가상컬럼값 기준
select
    menu_name,
    menu_price,
    category_code,
    menu_price * category_code
from
    tbl_menu
order by
    menu_price * category_code; -- ⛳존재하지 않는 컬럼을 만들어서 정렬도 가능함!

-- 특정 컬럼값을 변환해서 기준으로 사용
-- field(src, val1, val2, val3, ....) : 일치하는 값의 인덱스 반환
select
    field('A', 'A', 'B', 'C'), -- 1
    field('B', 'A', 'B', 'C'), -- 2
    field('X', 'A', 'B', 'C'); -- 0 (mysql에서는 존재하지 않는 인덱스)

select
    menu_name,
    orderable_status,
    field(orderable_status, 'Y', 'N') -- 1 또는 2를 반환함
from
    tbl_menu
order by
    field(orderable_status, 'N', 'Y');

-- null 관련
-- 오름차순 정렬에서 NULL값은 기본적으로 맨 위에 온다.
-- 내림차순 정렬에서 NULL값은 기본적으로 맨 아래에 온다.
select
    *
from
    tbl_menu
order by
    category_code desc;

-- 카테고리 오름차순, null값을 맨밑으로 보내기
select
    *
from
    tbl_menu
order by
    category_code is null asc,  -- is null asc에서는 null값이 가장 밑에 온다.
    category_code;

-- 카테고리 내림차순, null값을 맨위로 보내기
select
    *
from
    tbl_menu
order by
    category_code is null desc, -- is null desc에서는 null값이 가장 먼저 나온다.
    category_code desc;

