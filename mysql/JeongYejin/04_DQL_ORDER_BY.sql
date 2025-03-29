/**
----------------------------------------------------------------
  ORDER BY
----------------------------------------------------------------
 - ResultSet 행에 대한 정렬을 지정하는 구문
 - DQL에 Select구문 다음에 실행
 - 문자/숫자/날짜시간에 대해 오름차순(ASC)/내림차순(DESC) 정렬 작성
 */

select *
from tbl_menu
order by
#     menu_code;
#     menu_code desc; -- 내림차순
#     menu_name asc; -- 오름차순
    menu_name desc;

-- 두개 이상의 컬럼에 대해서 정렬 지원
-- 카테고리코드 오름차순, 가격 내림차순
-- 우선 카테고리코드 오름차순 적용, 카테고리코드가 같은 경우 두번째 가격 내림차순

select
    *
from
    tbl_menu
order by
    category_code asc,
    menu_price desc;

select
    menu_name, -- 1
    menu_code, -- 2
    category_code, -- 3
    menu_price, -- 4
    orderable_status -- 5
from
    tbl_menu
order by
    1; -- select절의 컬럼순서 (table순서X)

select
    menu_name 메뉴명,
    menu_code 메뉴코드,
    category_code 카테고리번호,
    menu_price 메뉴가격,
    orderable_status 주문가능여부
from
    tbl_menu
order by
    메뉴코드 desc; -- 별칭으로 컬럼지정

select
    menu_price,
    category_code,
    menu_price * category_code
from
    tbl_menu
order by
    menu_price * category_code; -- 가상 컬럼으로 정렬 가능

-- 특정컬럼값을 변환해서 기준으로 사용
-- field(src, val1, val2, val3, ...) : 일치하는 값의 인덱스 반환
select
    field('A', 'A', 'B', 'C'), -- 1
    field('B', 'A', 'B', 'C'), -- 2
    field('X', 'A', 'B', 'C'); -- 0 (mysql에서는 존재하지 않는 인덱스 -> 부재를 뜻함)

select
    menu_name,
    orderable_status,
    field(orderable_status, 'Y', 'N') -- orderable_status가 'Y'면 1, 'N'이면 2
from
    tbl_menu
order by
    field(orderable_status, 'N', 'Y'); -- orderable_status가 'N'이면 1로(menu_name) 정렬,
    -- 'Y'면 2로 (orderable_status) 정렬

-- null관련
-- 오름차순(asc) 정렬에서 NULL값은 기본적으로 맨 위에 온다.
-- is null 오름차순(asc) 정렬에서 NULL값은 맨 아래에 온다.
-- 내림차순(desc) 정렬에서 NULL값은 기본적으로 맨 아래에 온다.
-- is null 내림차순(desc) 정렬에서 NULL값은 맨 위에 온다.
select *
from tbl_menu
order by
#     category_code desc;
    category_code is null, -- is null에서는 1인데 기본이 오른차순이라서 null값이 가장 밑에 온다.
    -- false -> 0 true -> 1
#     category_code is null asc, -- is null asc에서는 null값이 1이니까 0->1 가장 아래에 온다.
#     category_code is null desc, -- is null desc에서는 null값이 1이니까 1->0 가장 위에 온다.
    category_code desc;
