use menudb;
-- ----------------------------------------
-- WHERE
-- ----------------------------------------
-- DQL 에서 특정행을 필터링하기 위한 조건절 작성.
-- 조건절 내용에 따라 각행별로 연산을 수행후 결과가 참인 행만 ResultSet 에 포함된다.

# WHERE 연산자
-- = 같은가?
-- != <> 같지 않은가?
-- > < >= <=
-- between and 범위연산 (이상 ~ 이하)
-- like 문자열 패턴연산
-- is null 널 여부 검사
-- in (값, 값, ...) 값 목록에 포함여부 검사

-- and && 그리고
-- or || 또는
-- not ! 부정(반전)

-- 주문 가능한 메뉴 조회
select
    *
from
    tbl_menu
where orderable_status = 'Y';

-- 메뉴가격이 13000원인 메뉴조회
select
    *
from
    tbl_menu
where menu_price = 13000;

-- 주문 불가능한 메뉴 조회(메뉴코드, 메뉴명, 주문가능여부)
select
    menu_code, menu_name, orderable_status
from
    tbl_menu
# where orderable_status = 'N';
# where orderable_status != 'Y';
# where orderable_status <> 'Y';
# where orderable_status = 'n'; -- 비교수행시 대소문자 구분없이 처리
where binary orderable_status = 'n'; -- 비교수행시 대소문자 구분없이 처리 (binary 포함시 더 정확히 수행)

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
where
    menu_price > 20000;

-- 카테고리 코드가 10번이면서 주문가능한 메뉴 조회
select
    *
from
    tbl_menu
where
    category_code = 10
and
    orderable_status = 'Y';

-- 카테고리 코드가 10번 또는 주문가능한 메뉴 조회
select
    *
from
    tbl_menu
where
    category_code = 10
  or
    orderable_status = 'Y';

-- 카테고리 코드가 4번 또는 가격이 9000이면서 메뉴번호가 10번 보다 큰 메뉴 조회
-- and, or를 나열할때 , and 연산자가 우선순위가 높다.
select
    *
from
    tbl_menu
where
    (category_code = 4 or menu_price = 9000)
    and
    menu_code > 10;

# between 연산자
-- between 값1 and 값2 : 값1 이상 값2 이하
-- 숫자/문자/날짜시간에 대해 모두 사용가능
-- 숫자 범위, 사전등재순 과거 미래 순서에 따라 다름
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
    menu_price >= 10000 and menu_price <= 25000;

select
    *
from
    tbl_menu
where
    menu_name between '가' and '마';

select
    *
from
    tbl_menu
where
#     menu_price not between 10000 and 25000;
#     not menu_price between 10000 and 25000;
    !(menu_price between 10000 and 25000);

select
    *
from
    tbl_menu
where
    menu_price < 10000
    or
    menu_price > 25000;

# LIKE 문자열 패턴 연산자
-- 비교하려는 컬럼값이 특정패턴을 만족하면 true 를 반환하는 연산자.

-- wildcard 란? 다른 문자로 대체가능한 특수한 의미를 가진 문자
-- 1. % 0개 이상의 문자열을 의미
-- 2. _ 1개의 문자를 의미 ex) ___ 3글자

select
    *
from
    tbl_menu
where
--     menu_name = '마늘' -- 정확히 마늘 조회
#     menu_name like '%마늘%'; -- 마늘을 포함 조회
#     menu_name like '마늘%'; -- 마늘로 시작하는지 조회
#     menu_name like '%마늘'; -- 마늘로 끝나는지 조회
    menu_name like '_마늘%'; -- 마늘앞에 한글자가 반드시 존재하고, 마늘 다음에는 0개 이상의 문자열이 존재하는지

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
    menu_name like '___쥬스';

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
    menu_name not like "%마늘%";

-- null 비교 - 카테고리번호가 null 인 메뉴 조회
select
    *
from
    tbl_menu
where
#     category_code = null; -- null 값 연산 불가
    category_code is null;

-- null 비교 - 카테고리번호가 null 이 아닌 메뉴 조회
select
    *
from
    tbl_menu
where
#     category_code = null; -- null 값 연산 불가
#     category_code is not null;
    not category_code is null;

-- null 처리함수(null은 동등비교할 수 없으므로, 다른 값으로 대체후에 비교)
-- ifnull(nullableValue, value if null)
select ifnull('안녕', '잘가'), ifnull(null, '잘가');

select
    *
from
    tbl_menu
where
    ifnull(category_code, 0) = 0;

-- null 과이 연산
select 1 + null, 1 - null, 1 * null;

-- in 연산자
-- in(값1, 값2, ...)
-- 해당 컬럼값이 in 값 목록 중에 있으면 true 를 반환
-- 카테고리 4번, 5번, 6번 메뉴만 조회
select
    *
from
    tbl_menu
where
    category_code in (4, 5, 6);

select
    *
from
    tbl_menu
where
    category_code = 4
or
    category_code = 5
or
    category_code = 6;

-- 부정
select
    *
from
    tbl_menu
where
    category_code not in (4, 5, 6);

select
    *
from
    tbl_menu
where
    category_code != 4
   and
    category_code != 5
   and
    category_code != 6;
