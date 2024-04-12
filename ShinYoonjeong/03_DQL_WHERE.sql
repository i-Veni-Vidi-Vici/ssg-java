use menudb;

-- -----------------------
-- WHERE
-- -----------------------

-- DQL에서 특정행을 필터링하기 위한 조건절 작성.
-- 조건절 내용에 따라 각 행별로 연산을 수행 후 결과가 참인 행만 ResultSet에 포함된다.

# WHERE 연산자
-- = 같은가?
-- != ^= <> 같지 않은가?
-- > < >= <=
-- between and 범위연산 (이상 ~ 이하)
-- like 문자열 패턴 연산
-- is null 널 여부 검사
-- in (값, 값, ...) 값 목록에 포함 여부

-- and && 그리고
-- or || 또는
-- not ! 부정(반전)

-- 주문 가능한 메뉴 조회
select
    *
from
    tbl_menu
where
    orderable_status = 'Y';
-- 메뉴가격이 13000원 인 메뉴코드, 메뉴명, 가격
select
    menu_code,menu_name,menu_price
from tbl_menu
where
    menu_price = 13000;
select
    menu_code,
    menu_name,
    orderable_status
from
    tbl_menu
where
#    orderable_status != 'Y';
#    orderable_status <> 'Y';
#    orderable_status = 'N';
#    orderable_status = 'n'; -- 비교 수행시 대소문자 구분 없이 처리
    binary orderable_status ='n';

-- 크기 비교
-- 10000원 이하 메뉴만 조회
select *
from tbl_menu
where menu_price <= 10000;
-- 20000원이 넘는 메뉴만 조회
select *
from tbl_menu
where menu_price > 20000;

-- 카테고리 코드가 10번이면서 주문 가능한 메뉴 조회
select
    *
from
    tbl_menu
where
    category_code=10
#and
&&
    orderable_status = 'Y';

-- 카테고리 코드가 10번 또는 주문 가능한 메뉴 조회
select
    *
from
    tbl_menu
where
    category_code=10
#||
        or
    orderable_status = 'Y';
-- 카테고리 코드가 4번 또는 가격이 9000원 이면서 메뉴 번호가 10번 보다 큰 메뉴 조회
-- and, or를 나열할때, and 연산자가 우선 순위가 높다.
select
    *
from
    tbl_menu
where
    (category_code=4 or menu_price = 9000)
and
    menu_code >10;
# betweeen 연산자
-- between 값1 and 값2 이상 값2 이하
-- 숫자/문자/날짜 시간에 대해 모두 사용가능
-- 숫자, 사전 등재순, 과거~미래 순서에 따라 범위를 지정
select
    *
from
    tbl_menu
where menu_price between 10000 and 250000;
select
    *
from
    tbl_menu
where
    menu_price >= 10000
and
    menu_price <= 250000;
select *
from tbl_menu
where
    menu_name between '가' and '마';

-- 부정 표현 not !
select
    *
from
    tbl_menu
where not menu_price between 10000 and 250000;
# !(menu_price between 10000 and 250000);

select
    *
from
    tbl_menu
where
    menu_price<10000
or
    menu_price>25000;

# LIKE 문자열 패턴 연산자
-- 비교하려면 컬럼값이 특정패턴을 만족하면 true를 반환하는 연산자.

-- wildcard란? 다른 문자로 대체 가능한 특수한 의미를 가진 문자.
-- 1. % 0개 이상의 문자열을 의미.
-- 2. _ 1개의 문자를 의미. ___ 3글자

-- '마늘'이란 말이 들어간 메뉴 조회
select
    *
from tbl_menu
where
--    menu_name = '마늘'; -- 정확히 마늘 조회
    menu_name like '%마늘%'; -- 마늘을 포함 조회
#    menu_name like '마늘%'; -- 마늘로 시작하는지 조회
#    menu_name like '%마늘'; -- 마늘로 끝나는지 조회
#    menu_name like '_마늘%'; -- 마늘 앞에 한글자가 반드시 존재하고, 마늘 다음에는 0개 이상의 문자열이 존재하는지

-- 쥬스 메뉴만 조회
select
    *
from tbl_menu
where
    menu_name like '%쥬스%';

-- 저번에 먹었던 뭐무뭐 쥬스 조회
select *
from tbl_menu
where
    menu_name like '___쥬스%';


-- 5000원 보다 비싼 10번 카테고리의 '갈치'가 들어간 메뉴 조회
select *
from tbl_menu
where
    category_code =10
and
    menu_price>5000
and
    menu_name like '%갈치%';

-- 마늘이 안들어간 메뉴 조회
select *
from tbl_menu
where !(menu_name like '%마늘%');

-- null 비교 - 카테고리 번호가 null인 메뉴 조회
select *
from tbl_menu
# where category_code =null; -- null값 연산 불가
where category_code is null;

-- 카테고리가 null이 아닌 메뉴 조회
select
    *
from
    tbl_menu
where
    not category_code is null;

-- null처리함수(null은 동등비교할 수 없으므로, 다른 값으로 대체후에 비교)
-- ifnull(nullableValue, value if null)
select ifnull('안녕', '잘가'), ifnull(null, '잘가');

select *
from tbl_menu
where
    ifnull(category_code,0) = 0;

-- null과의 연산
select 1+null, 1-null, 1*null, 1/null;

-- in 연산자
-- in(값1, 값2,...)
-- 해당 컬럼값이 in값목록 중에 있으면 true를 반환
-- 카테고리 4번, 5번, 6번 메뉴만 조회
select *
from tbl_menu
where category_code in(4,5,6);

-- 부정 4, 5, 6번이 아닌경우
select *
from tbl_menu
where not category_code in (4,5,6);
select *
from tbl_menu
where category_code != 4
and category_code != 5
and category_code != 6;