-- ========================
-- WHERE
-- ========================
-- DQL에서 특정 행을 필터링하기 위한 조건절 작성
-- 조건절 내용에 따라 각 행별로 연산을 수행 후 결과가 참인 행만 ResultSet에 포함된다
select
    menu_name,
    menu_price,
    category_code
from
    tbl_menu
where
    orderable_status = 'Y';

-- 메뉴 가격이 13000원인것 조회

select
    menu_name,
    menu_price,
    category_code
from
    tbl_menu
where
    menu_price = 13000;

-- 주문 불가능한 메뉴 조회(메뉴코드, 메뉴명, 주문가능여부)
select
    menu_name,
    menu_price,
    menu_code
from
    tbl_menu
where
    -- orderable_status = 'N';
    -- orderable_status <> 'Y';
    -- orderable_status != 'Y';
    binary orderable_status = 'n';  -- binary는 대소문자 구분함

-- 20000원이 넘는 메뉴만 조회
select
    *
from
    tbl_menu
where
    menu_price > 20000;

-- 10000원 미만 메뉴만 조회
select
    *
from
    tbl_menu

where
    menu_price < 10000;

-- 카테고리 코드가 10버닝면서 주문가능한 메뉴 조회
select
    *
from
    tbl_menu
where
    category_code = 10
  and
    orderable_status = 'Y';

 -- 카테고리코드가 10번 또는 주문 가능한 메뉴 조회

select
     *
from
    tbl_menu
 where
     category_code = 10
    -- or
     ||
     orderable_status = 'Y';

-- 카테고리 코드가 4번 또는 가격이 9000원 이면서 메뉴번호가 10번보다 큰 메뉴
-- and 와 or를 나열하면 and 연산자 우선순위가 더 높음
select
    *
from
    tbl_menu
where
    (category_code = 4 or menu_price = 9000)
  and
    menu_code > 10;

#between 연산자
-- between 값1 and 값2 : 값1 이상 값2 이하
-- 숫자 / 문자/ 날짜 시간에 대해 모두 사용 가능
-- 숫자 범위, 사전 등재순, 과거~미래
select
    *
from
    tbl_menu
where
    menu_price >= 10000
  and
    menu_price <= 25000;
    -- menu_price between 10000 and 25000;

-- 메뉴명을 사전 등재순으로 필터링
select
    *
from
    tbl_menu
where
    menu_name between '가' and '마';

-- 부정표현 not !
select
    *
from
    tbl_menu
where
    -- menu_price not between 10000 and 25000;
    -- not menu_price between 10000 and 25000;
    -- !(menu_price between 10000 and 25000);
    menu_price>25000 or menu_price<10000;

# Like 문자열 패턴 연산자
-- 비교하려는 컬럼 값이 특정패턴을 만족하면 true를 반환하는 연산자.
-- wildcard란? 다른 문자로 대체 가능한 특수한 의미를 가진 문자

-- 마늘 이란 말이 들어간 메뉴 조회
select
    *
from
    tbl_menu
where
    menu_name like '%마늘%';

-- 쥬스 메뉴만 조회
select
    *
from
    tbl_menu
where
    menu_name like '%쥬스%';

-- 저번에 먹었던 ㅇㅇㅇ 쥬스 조회

select
    *
from
    tbl_menu
where
    menu_name like '___쥬스%';

-- 5000원 보다 비싼 10번 카테고리의 '갈치' 가 들어간 메뉴 조회
select
    *
from
    tbl_menu
where
    menu_name like '%갈치%'
    and
    menu_price > 5000
    and
    category_code = 10;

-- 마늘이 안들어간 메뉴
select
    *
from
    tbl_menu
where
    not menu_name like '%마늘%';

-- null 비교 - 카테고리 번호가 null인 메뉴 조회
select
    *
from
    tbl_menu
where
    category_code IS NULL;

-- not과 IS NULL의 혼용
select
    *
from
    tbl_menu
where
    category_code IS NOT NULL;

-- ifnull
select ifnull('안녕', '잘가') , ifnull(null, '잘가');

select
    *
from
    tbl_menu
where
    ifnull(category_code, 0) = 0;

-- in 연산자
select
    *
from
    tbl_menu
where
    category_code in (4, 5, 6);

-- and or 만 써서 같은 코드 작성
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

-- in 부정
select
    *
from
    tbl_menu
where
    category_code not in (4,5,6);

-- not
select
    *
from
    tbl_menu
where
    !(category_code = 4 or category_code = 5 or category_code = 6);
