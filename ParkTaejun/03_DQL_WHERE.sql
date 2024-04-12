use menudb;

-- ------------------------------
-- WHERE
-- ------------------------------
-- DQL에서 특정행을 필터링하기 위한 조건절 작성.
-- 조건절 내용에 따라 각 행별로 연산을 수행 후 결과가 참인 행만 ResultSet에 포함된다.

# WHERE 연산자
-- 자바에서는 ==, DB에서는 = 같은가?
-- !=  <> 같지 않은가?
-- > < >= <=
-- between and 범위연산 (이상~이하)
-- like 문자열 패턴연산
-- is null 널 여부 검사
-- in (값, 값, ...) 값목록에 포함여부 검사

-- and && 그리고
-- or || 또는
-- not ! 부정(반전) 연산자

-- 주문가능한 메뉴 조회
select
    menu_name,
    category_code,
    orderable_status
from
    tbl_menu
where
    orderable_status ='Y'; # 한번에 한행


-- 메뉴가격이 13000원인 메뉴조회
select menu_code, menu_name, menu_price

from
    tbl_menu
where
    menu_price = 13000;

-- 주문 불가능한 메뉴 조회 (미뉴코드 , 메뉴명 , 주문가능여부)
select
    menu_name


from
    tbl_menu
where
#     orderable_status != 'Y'
#     orderable_status <> ;
#     roderabnle_status = 'N';
#     orderable_status = 'n';-- 비교수행시 대소문자 구분없이 처리함
    binary  orderable_status = 'n';

-- 크기비교
-- 10000원 이하 메뉴만 조회
select *
from
    tbl_menu
where
    menu_price <= 10000 ;
-- 20000원이 넘는 메뉴만 조회

select *
from
    tbl_menu
where
    menu_price > 20000;

-- 카테고리코드가 10번이면서 주문 가능한 메뉴 조회

select
    *
    from
        tbl_menu
where
    category_code = 10
#     and
    &&
    orderable_status = 'Y';

-- 카테고리코드가 10 번 또는 주문가능한 메뉴 조회

select
    *
    from
        tbl_menu
where
    category_code = 10
#     or
    ||
    orderable_status = 'Y';

-- 카테고리코드가 4 번 또는 가격이 9000원 이면서 , 메뉴번호가 10번 보다 큰 메뉴 조회
-- and, or를 나열할 때, and 연산자가 우선순위가 높음 마치 괄호가 묶여있는 것 처럼 계산됨

select
    *
    from
        tbl_menu
where
    (category_code =4
or
    menu_price = 9000)
and
    menu_code > 10;

# between 연산자
-- between 값1 and 값2 : 값1 이상 값2 이하
-- 숫자/문자/날짜시간에 대해 모두 사용 가능함
-- 숫자 범위, 사전등재순, 과거~미래 순서에 따라 범위를 지정

select
    *
from
    tbl_menu
where
#     menu_price between  10000 and 25000;
    menu_price >= 10000
and
    menu_price <= 25000;

select
    *
from
    tbl_menu
where
    menu_name between '가' and '마';

-- 반전
select
    *
from
    tbl_menu
where
   -- not 위치 자유로움
#     !(menu_price between  10000 and 25000); -- not 위치 자유로움
#     !(menu_price between  10000 and 25000); -- not 위치 자유로움
    menu_price < 10000
    or
    menu_price > 25000;

# LIKE 문자열 패턴 연산자
-- 비교하려는 컬럼값이 특정패턴을 만족하면 TRUE를 반환하는 연산자

-- wildcard란? 다른 문자로 대체가능한 특수한 의미를 가진 문자
-- 1. %0개 이상의 문자열을 의미
-- 2. _ 1개의 문자르 의미. ___ 3글자

-- '마늘'이란 말이 들어간 메뉴를 조회
select
    *
    from
        tbl_menu
where

#     menu_name = '마늘'; -- 정확히 마늘 조회
#     menu_name like '%마늘%'; -- 마늘을 포함 조회/
#         menu_name like '마늘%' -- 마늘로시작하는지 조회
#       menu_name like '%마늘'; -- 마늘로 끝나는지..
#         menu_name like  '_마늘%'; -- 마늘앞에 한글자가 반드시 존재하고, 마늘 다음에는 0개 이상의 문자열이 존재하는지

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
            menu_name like '___쥬스%';
-- 5000원보다 비싼 10번 카테고리의 '갈치'가 들어간 메뉴 조회
select
    *
from
    tbl_menu
where
    menu_price > 5000
    and
    category_code = 10
    and
    menu_name like '%갈치%';

-- 마늘이 안들어간 메뉴 조회
select
    *
from
    tbl_menu
where
    menu_name not like '%마늘%';

-- null 비교 - 카테고리번호가 null인 메뉴 조회

select
    *
    from
        tbl_menu
where
#     category_code = null; null 값 연산 불가
        category_code is null; -- null 값을 찾을 때는 = null 이 아니라 is null

-- 카테고리가 null이 아닌 메뉴 조회
select
    *
from
    tbl_menu
where
#     category_code is not null;
    not category_code is null;

-- null 처리함수(null은 동등비교할 수 없으므로, 다른 값으로 대체 후에 비교)
-- ifnull(nullableValue, value if null)
select ifnull('안녕', '잘가'), ifnull(null, '잘가');

select
    *
from
    tbl_menu
where
    ifnull(category_code, 0) = 0;

-- in연산자
-- in값1,값 2, ...)
-- 해당 커럼값이 in 값목록 중에 있으면 true를 반환
-- 카테고리 4번, 5번, 6번 메뉴 조회
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
    category_code >=3
and
    category_code <=6;

-- 부정 4, 5, 6 번이 아닌 경우
select
    *

from
    tbl_menu
where
    category_code not in (4,5,6);

select
    *
from
    tbl_menu
where
    category_code !=4
and
    category_code != 5
and
    category_code != 6;