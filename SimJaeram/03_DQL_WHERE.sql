use menudb;
-- -----------------------------------
-- WHERE
-- -----------------------------------
-- DQL에서 특정행을 필터링하기 위한 조건절 작성.
-- 조건절 내용에 따라 각행별로 연산을 수행후 결과가 참인 행만 ResultSet에 포함된다.
-- 각 한 행씩 검사, true인 것만 ResultSet에 추가

# WHERE 연산자
-- =  같은가? // 자바에서처럼 ==로 동등비교연산 하지 않는다. SQL에서는 대입 연산자가 아니다.
-- != <> 같지않은가?
-- > < >= <=
-- between and 범위연산 (이상 ~ 이하)
-- like 문자열 패턴연산
-- is null 널 여부 검사
-- in (값, 값, ...) 값목록에 포함여부

-- and && 그리고
-- or || 또는
-- not ! 부정(반전)

-- 주문가능한 메뉴 조회
-- * asterisk

select
    *
from
    tbl_menu
where
    orderable_status = 'Y'; -- 22 rows에서 18 rows로

desc tbl_menu;

select
    menu_name,
    category_code,
    orderable_status
from
    tbl_menu
where
    orderable_status = 'Y'; -- 22 rows에서 18 rows로

-- 메뉴 가격이 13,000원인 메뉴 조회(메뉴코드, 메뉴명, 가격)

select
    menu_code,
    menu_name,
    menu_price
from
    tbl_menu
where
    menu_price = 13000;

-- 주문 불가능한 메뉴 조회 (메뉴코드, 메뉴명, 주문가능여부)
select
    menu_code,
    menu_name,
    orderable_status
from
    tbl_menu
where
#     orderable_status != 'Y';
#     orderable_status <> 'Y';
    orderable_status = 'n'; -- windows는 대소문자 구분 없이, 리눅스는 대소문자 구분함

show variables like 'lower_case_table_names'; -- 1

-- 크기비교
-- 10000원 이하 메뉴만 조회
select
    *
from
    tbl_menu
where
    menu_price <= 10000;

-- 20000원이 넘는 메뉴만 조회
select
    *
from
    tbl_menu
where menu_price > 20000;

-- 카테고리 코드가 10번 이고, 주문 가능한 메뉴

select
    *
from
    tbl_menu
where
    category_code = 10
# and &&
        &&
    orderable_status = 'Y';

-- 카테고리 코드가 10번 또는 주문 가능한 메뉴

select
    *
from
    tbl_menu
where
    category_code = 10
# or ||
        ||
    orderable_status = 'Y';

-- 카테고리 코드가 4번 또는 가격이 9,000원이면서 메뉴 번호가 10번보다 큰 메뉴 조회
-- and, or를 나열할 때, and 연산자가 우선순위가 높다.
select
    *
from
    tbl_menu
where
    (category_code = 4 or menu_price = 9000)
&&
    menu_code > 10;

select
    *
from
    tbl_menu
where
    category_code = 4
   or
    (menu_price = 9000 and menu_code > 10);

# between 연산자
-- between 값1 and 값2 : 값1 이상 값2 이하
-- 숫자/문자/날짜/시간에 대해 모두 사용가능 // 범위이므로
-- 문자 범위는 사전등재순, 날짜/시간은 과거~미래 순서에 따라 범위를 지정

select
    *
from
        tbl_menu
where
    menu_price between 10000 and 25000;

select
    *
from
        tbl_menu
where
    (menu_price >= 10000)
  and
    (menu_price <= 25000);

-- 부정표현 not !
select
    *
from
    tbl_menu
where
#     menu_price not between 10000 and 25000;
#     not menu_price between 10000 and 25000;
!(menu_price between 10000 and 25000);

--
select
    *
from
    tbl_menu
where
    menu_price < 10000
    ||
    menu_price > 25000;

# LIKE 문자열 패턴 연산자
-- 비교하려는 컬럼값이 특정패턴을 만족하면 true를 반환하는 연산자.

-- wildcard란? 다른 문자로 대체가능한 특수한 의미를 가진 문자
-- 1. % 0개이상의 문자열을 의미
-- 2. _ 1개의 문자를 의미 ___은 3글자

-- '마늘'이란 말이 들어간 메뉴조회
select
    *
from
    tbl_menu
where
--     menu_name = '마늘'; -- 정확히 마늘 조회
#     menu_name like '%마늘%'; -- 마늘을 포함 조회
#     menu_name like '마늘%'; -- 마늘로 시작하는지 조회
#     menu_name like '%마늘'; -- 마늘로 끝나는지 조회
menu_name like '_마늘%'; -- 마늘앞에 한글자가 반드시 존재하고, 마늘 다음에는 0개이상의 문자열 존재하는지

-- 쥬스 메뉴만 조회

select
    *
from
    tbl_menu
where
    menu_name like '%쥬스%';

-- 저번에 먹었던 뭐뭐뭐 쥬스 조회

select
    *
from
    tbl_menu
where
    menu_name like '___쥬스'; -- ___%쥬스는 앞에 3글자 이상

-- 5000원보다 비싼 10번 카테고리의 '갈치'가 들어간 메뉴 조회
select
    *
from
    tbl_menu
where
    (menu_price > 5000) and (category_code = 10) and (menu_name like '%갈치%');

select *
from tbl_menu;

-- 마늘 들어간 메뉴 조회
select
    *
from
    tbl_menu
where
    (menu_name like '%마늘%');

-- 마늘 들어간 메뉴 조회
select
    *
from
    tbl_menu
where
    !(menu_name like '%마늘%');
#     not (menu_name like '%마늘%'); -- not 연산자의 위치는 자유롭다.
#     menu_name not like '%마늘%');

select
*
from
    tbl_menu
where
# category_code = null; -- null 값은 연산 불가, 이렇게 해도 조회가 안됨
category_code is null; -- null 값을 찾을 때는 is null 연산자를 사용해야한다.

-- 카테고리가 null이 아닌 메뉴 조회
select
    *
from
    tbl_menu
where
#     category_code is not null;
    not category_code is null;

-- null 처리 함수 // null을 찾을 때는 동등비교 연산이 안되므로, 다른 값으로 대체 후 비교
-- ifnull(nullableValue, value if null) // null인지 찾을 값, null이 아니라면 원본 값 그대로 쓰인다, null일 때 대체할 값
select ifnull('안녕', '잘가'), ifnull(null, '잘가');

select
    *
from
    tbl_menu
where
    ifnull(category_code, 0) = 0;

-- null과의 연산
select 1 + null, 1 - null, 1 * null, 1 / null; -- 문법 오류는 발생하지 않는다. null은 연산이 불가하더라도

-- in 연산자
-- in(값1, 값2, ...)
-- 해당 컬럼 값이 in 값 목록 중에 있으면 true를 반환
-- 카테고리 4번, 5번, 6번 메뉴만 조회
select
    *
from
    tbl_menu
where
    category_code in(4, 5, 6);

select
    *
from
    tbl_menu
where

-- 카테고리 4, 5, 6번이 아닌 경우
select
    *
from
    tbl_menu
where
#     category_code not in(4, 5, 6);
    not category_code in(4, 5, 6);


select
    *
from
    tbl_menu
where
#     not (category_code = 4 or category_code = 5 or category_code = 6);
    (category_code != 4 and category_code != 5 and category_code != 6);
