-- --------------------------------------------
-- ORDER BY
-- --------------------------------------------
-- ResultSet 행에 대한 정렬을 지정하는 구문
-- DQL에 Select구문 다음에 실행
-- 문자/숫자/날짜시간에 대해 오름차순(ASC)/내림차순(DESC) 정렬 작성
-- 컬럼명, 컬럼숫자, 별칭으로 지정 가능
use menudb;
select
    *
from
    tbl_menu
order by
#   menu_code; asc 오름차순 기본값
#   menu_code desc; -- 내림차순
    tbl_menu.menu_name;

-- 두 개이상의 컬럼에 대해서 정렬 지원
-- 카테고리코드 오름차순, 가격 내림차순
-- 우선 카테고리코드 오름차순 적용, 카테고리코드가 같은 경우 두 번째 가격 내림차순

select *
from
    tbl_menu
order by
    category_code,
    menu_price desc ;

-- select 절의 컬럼순서로 지정가능
select
    menu_code 코드,
    menu_name 메뉴이름,
    menu_price 가격,
    category_code 카테고리코드,
    orderable_status 주문가능여부
from
    tbl_menu
order by
    2;# 컬럼순서, 테이블 선언순서와는 다르다, select절에 순서 기준으로 한다

select
    menu_code 코드,
    menu_name 메뉴이름,
    menu_price 가격,
    category_code 카테고리코드,
    orderable_status 주문가능여부,
    menu_price * tbl_menu.category_code
from
    tbl_menu
order by
    menu_price * tbl_menu.category_code;

-- 특정컬럼값을 변환해서 기준으로 사용
-- field(source, value1, value2, ....) : 일치하는 값의 인덱스 반환
select
    field('a','a','c','d') 'a',-- 이 경우 1번지에 있는 것과 같다
    field('b','b','c','d') 'b',-- 이 경우 1번지에 있는 것과 같다
    field('c','b','c','d') 'c',-- 이 경우 2번지에 있는 것과 같다
    field('d','b','c','d') 'd',-- 이 경우 3번지에 있는 것과 같다
    field('e','b','c','d') 'e'-- 이 경우 0번지 = 존재하지 않는 인덱스이다
from
    menudb.tbl_menu;

select
    menu_name 이름,
    orderable_status 주문가능여부,
    field(orderable_status,'y','n') field
from tbl_menu
order by
    field(orderable_status,'y','n');

-- null 관련
-- 오름차순 정렬에서 null값은 기본적으로 맨 위에 온다
-- 내림차순 정렬에서 null값은 기본적으로 맨 아래에 온다.
select *
from
    tbl_menu
order by
    category_code;


# ----------------- false = 0, true = 1 암묵적인 변환 룰

select *
from tbl_menu
order by
#     category_code is null,-- is null  asc에서는 null값이 가낭 밑에 온다
#     category_code;
    category_code is null desc,
    category_code desc ;

-- 카테고리 오름차순, 널값은 맨 아래
select
    category_code
from tbl_menu
order by
#     category_code is null,-- is null  asc에서는 null값이 가낭 밑에 온다
#     category_code;
category_code is null asc,
category_code asc ;

-- 카테고리 내림, 널값은 맨 위로
select
    category_code
from tbl_menu
order by
#     category_code is null,-- is null  asc에서는 null값이 가낭 밑에 온다
#     category_code;
category_code is null desc ,
category_code desc ;

