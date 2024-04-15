-- oder by

select
    *
from
    tbl_menu
order by -- 오름차순이 기본 값
#     menu_code desc;
    -- menu_name desc; -- 이름 순 내림차순 정렬

-- 두개 이상의 컬럼에 대해서 정렬 지원
-- 카테고리 코드 오름차순, 가격 내림 차순
-- 우선 카테고리코드 오름차순 적용, 카테고리코드가 같은 경우 두번째 가격 내림차순 적용
	category_code asc,
	menu_price desc;

select
    menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
from
    tbl_menu
order by
    3; -- 컬럼 순서 / menu_price를 기준으로 정렬이 된다

-- 별칭 기준
select
    menu_code 메뉴코드,
    menu_name 메뉴명,
    menu_price 메뉴가격,
    category_code 카테고리번호,
    orderable_status 주문가능여부
from
    tbl_menu
order by
    메뉴가격 desc ;

-- 가상컬럼값 기준
select
    menu_name,
    menu_price,
    category_code,
    menu_price * category_code
from
    tbl_menu
order by
    menu_price* category_code;

-- field(src, val1, val2, val3...) : 일치하는 값의 인덱스 반환
select
    field('A', 'A','B','C'), -- 1
    field('B', 'A','B', 'C'), -- 2
    field('X', 'A','B', 'C'); -- 0 (mysql에서는 존재하지 않는 인덱스

select
    menu_name,
    orderable_status
#     field(orderable_status, 'Y', 'N')
from
    tbl_menu
order by
    field(orderable_status, 'N', 'Y');

-- null 관련
select
    *
from
    tbl_menu
order by
#     category_code desc ;
    category_code is null,
    category_code;