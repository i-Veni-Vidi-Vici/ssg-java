-- =============================
-- SUB-QUERY
-- =============================
-- 하나의 SQL문(메인쿼리) 안에 포함된 또 하나의 SQL문(서브쿼리)
-- 존재하지 않는 값에 근거해서 쿼리를 작성해야 하는 경우 유용하다.
-- 메인쿼리 수행중에 서브쿼리를 만나면, 서브쿼리 우선실행하고 그 결과를 메인쿼리에 반환

# 유형
-- 1. 일반 서브쿼리
        -- 단일행 서브쿼리
        -- 다중행 서브쿼리
-- 2. 상관 서브쿼리
-- 3. 인라인뷰 (파생테이블) // from절에 사용한 서브쿼리, 괄호로 서브 쿼리를 묶고 반드시 별칭을 작성 해야한다.

# 규칙
-- 서브쿼리는 반드시 소괄호를 묶어야 한다.
-- 서브쿼리 내에서는 order by 지원하지 않는다.
-- 서브쿼리의 실행결과(행/컬럼) 수에 따라 사용해야하는 연산자가 다르다. // 여러개면 in 연산자, 1개면 = 연산자

-- ------------------------------
-- 일반 서브쿼리
-- ------------------------------
# 단일행 서브쿼리
-- 서브쿼리의 실행결과가 한 행인 경우
-- 열무김치라떼 메뉴의 카테고리명 조회
-- 1. tbl_menu에서 열무김치라떼의 행을 찾고, category_code 조회 (서브쿼리)
-- 2. tbl_category에서 특정행을 찾고, category_name을 조회 (메인쿼리)

select
    category_code -- 8
from
    tbl_menu
where
    menu_name = '열무김치라떼';

select
    category_name -- 커피
from
    tbl_category
where
    category_code = 8; -- 8을 알고 있다면, 한번에 구할 수 있다.

-- 서브쿼리로 작성
select
    category_name -- 커피
from
    tbl_category
where
    category_code = (
        select
            category_code -- 8
        from
            tbl_menu
        where
            menu_name = '열무김치라떼'
    );

-- 한번 실행된 서브쿼리는 캐싱된다. // caching
-- 매번 똑같은 쿼리를 실행하지 않는다. // 효율적으로 처리

-- 민트미역국과 같은 카테고리의 메뉴 조회
-- 1. tbl_menu에서 민트미역국의 행을 찾고, category_code 조회 (서브쿼리)
-- 2. tbl_menu에서 category_code가 같은행 조회 (메인쿼리)

select
    *
from
    tbl_menu
where
    category_code = (
        select
            category_code
        from
            tbl_menu
        where
            menu_name = '민트미역국'
    );

# 다중행 서브쿼리
-- 서브쿼리의 실행결과가 여러 행인 경우

-- 식사류 카테고리가 1번일때, 모든 식사류 메뉴를 조회
-- 1. 식사류 1번의 하위 카테고리를 조회 (서브쿼리)
-- 2. 카테고리가 1번과 동일한 메뉴 조회 (메인쿼리)

-- 1.
select
    category_code
from
    tbl_category
where
    ref_category_code = 1;

-- 2.

select
    *
from
    tbl_menu
where
    category_code = (
        select
            category_code
        from
            tbl_category
        where
            ref_category_code = 1 -- [21000][1242] Subquery returns more than 1 row
    ); -- 다중행 서브쿼리로 단일행 비교를 하였으므로 오류 발생

select
    *
from
    tbl_menu
where
    category_code in (
        select
            category_code
        from
            tbl_category
        where
            ref_category_code = 1
    );

-- ------------------------------
-- 상관 서브쿼리
-- ------------------------------
-- 상호연관 서브쿼리
-- 메인쿼리의 값을 서브쿼리에 전달해서 수행 후 그 결과를 다시 메인쿼리로 반환하는 방식
-- 메인쿼리의 레코드에 따라 수행할 서브쿼리가 달라진다.
-- 상관서브쿼리만 단독으로 블럭 잡아 실행할 수 없다.

# 구분
-- 일반서브쿼리 // 단독으로 블럭 잡아 실행 가능
-- 상관서브쿼리 // 단독으로 블럭 잡아 실행 불가

-- 카테고리별로 가격이 가장 비싼 메뉴 조회
-- 1. 조인으로 해결하기
select
    category_code,
    max(menu_price)
from
    tbl_menu
group by
    category_code;

-- inner join (category_code가 null인 그룹 제외)
select
    m.*
from
    tbl_menu m join (
        select
            category_code,
            max(menu_price) max_menu_price
        from
            tbl_menu
        group by
            category_code
    ) c
    on m.category_code = c.category_code
where
    m.menu_price = c.max_menu_price
order by
    m.category_code;

-- outer join (category_code가 null인 그룹 제외)
select
    m.*
from
    tbl_menu m left join (
        select
            category_code,
            max(menu_price) max_menu_price
        from
            tbl_menu
        group by
            category_code -- group by하면 category_code가 null인 그룹도 있다.
    ) c
    on ifnull(m.category_code, 0) = ifnull(c.category_code, 0) -- inner join이므로 매칭되지 않는 행이 있으므로 여기에서 null 그룹이 제외된다.
    -- null끼리의 연산은 불가, is null 연산자는 다른 카테고리 코드 비교 연산에는 적용하지 못하므로 ifnull() 함수 이용한다.
    -- null끼리 동일비교 할 수 없으므로, ifnull 함수를 이용해서 특정 값으로 변환 후 비교
where
    m.menu_price = c.max_menu_price
order by
    m.category_code;

-- 2. 상관서브쿼리로 해결하기
select
    *
from
    tbl_menu m
where
#     menu_price = (카테고리별 최고 비싼 금액);
    menu_price = (
        select
            max(menu_price)
        from
            tbl_menu
        where
            category_code = m.category_code
    );

-- 메인쿼리 where절에서 매행마다 다음 쿼리를 수행한다. 이 행의 category가 전달된다.
select
    max(menu_price)
from
    tbl_menu
where
    category_code = 11; -- 우항에 메인쿼리 레코드의 category_code가 대입

-- 카테고리별 평균가격보다 높은 가격의 메뉴 조회
-- 메인쿼리 테이블 별칭이 반드시 필요하다

select
    *
from
    tbl_menu m
where
#     menu_price > (카테고리별 평균가격)
    menu_price > (
        select
            avg(menu_price)
        from
            tbl_menu
        where
            category_code = m.category_code
    );

select
    category_code,
    avg(menu_price) avg_menu_price
from
    tbl_menu
group by
    category_code;

select
    avg(menu_price)
from
    tbl_menu
where
    category_code = 5;

# exists 연산자
-- exists (서브쿼리) // 서브쿼리에서 조회된 행이 존재하면 true, 존재하지 않으면 false 리턴

-- 메뉴가 있는 카테고리 조회

select
    *
from
    tbl_category
where
    exists(select * from tbl_menu where category_code = 100); -- false 리턴, 메인쿼리의 각행도 매번 false와 조건비교하므로 메인쿼리 resultset도 0행이된다.


select
    *
from
    tbl_category c
where
    exists(
        select
            *
        from
            tbl_menu
        where
            category_code = c.category_code
    );

select
    *
from
    tbl_menu
where
    category_code = 1 -- 메인쿼리에서 1이 전달

use empdb;
-- department 테이블에서 실제 부서원이 존재하는 부서만 조회

select
    *
from
    department d
where
     exists(
        select
            *
        from
            employee
        where
            DEPT_CODE = d.DEPT_ID
    );


-- department 테이블에서 실제 부서원이 존재하는 부서만 조회
-- exists(서브쿼리) // 서브쿼리 행이 존재하면 참
-- not exists(서브쿼리) // 서브쿼리 행이 존재하지 않으면 참
select
    *
from
    department d
where
     not exists(
        select
            *
        from
            employee
        where
            DEPT_CODE = d.DEPT_ID
    );


-- 행이 존재하는지는 1만 조회해도 되므로, 내용은 중요하지 않으므로 1을 select하여 사용한다. 보통
select
    *
from
    department d
where
     exists(
        select
            1
        from
            employee
        where
            DEPT_CODE = d.DEPT_ID
    );

-- not exists를 이용한 최대/최소 행 구하기
-- 가격이 가장 비싼 메뉴 조회
use menudb;

select
    max(menu_price)
from
    tbl_menu; -- 가장 비싼 가격을 조회하는 것이 아닌, 메뉴를 조회

select
    *
from
    tbl_menu m
where
    not exists(
        select
            1
        from
            tbl_menu
        where
            menu_price > m.menu_price
    );

select *
from tbl_menu
where menu_price > 4500; -- 4500원 보다 비싼 메뉴 조회, 행 여러개 조회됨;

-- 가격이 가장 싼 메뉴 조회

select
    min(menu_price)
from
    tbl_menu; -- 가장 싼 가격을 조회하는 것이 아닌, 메뉴를 조회

select
    *
from
    tbl_menu m
where
    not exists(
        select
            1
        from
            tbl_menu
        where
            menu_price < m.menu_price
    );

# 스칼라 서브쿼리
-- 값이 한개면 스칼라, 여러개면 벡터
-- 실행결과가 하나(스칼라)인 상관서브쿼리. 주로 select 절에서 사용한다.
-- 컬럼이 여러개거나 행이 여러개면 안된다.

-- 메뉴명, 카테고리명 조회
select
    menu_name,
    (select category_name from tbl_category where category_code = m.category_code) category_name
from
    tbl_menu m;

-- 카테고리테이블에서 카테고리명, 상위카테고리명 조회
select
    category_name,
    -- 상위 카테고리명 조회
    (select category_name from tbl_category where category_code = c.ref_category_code) ref_category_name
from
    tbl_category c;

-- ------------------------------
-- 인라인 뷰
-- ------------------------------
-- from절에 사용한 서브쿼리를 가리킨다.
-- 마치 하나의 테이블인 것처럼 사용할 수 있다.

# 뷰 구분
-- 1. 인라인 뷰 // 1회용 서브쿼리
-- 2. 저장 뷰 // db 객체 중의 하나로, 뷰를 테이블처럼 재사용 가능

select
#     category_code, -- [42S22][1054] Unknown column 'category_code' in 'field list
                    -- 현재 category_name과 ref_category_name 컬럼만 있다.
#     category_name , -- 인라인뷰에서 별칭을 사용한 경우 별칭으로 참조해야 한다.
    카테고리명,
    ref_category_name
from (
    select
        category_name 카테고리명,
        -- 상위 카테고리명 조회
        (select category_name from tbl_category where category_code = c.ref_category_code) ref_category_name
    from
        tbl_category c
) t;

-- 메뉴테이블에서 카테고리별 메뉴 개수를 집계했을때 최대/최솟값 조회
-- 인라인뷰?

select
    category_code,
    count(*) 메뉴개수
from
    tbl_menu
group by
    category_code;

select
    max(메뉴개수),
    min(메뉴개수)
from (
    select
        category_code,
        count(*) 메뉴개수
    from
        tbl_menu
    group by
        category_code
) t;

# common table expression
-- 인라인뷰에 이름을 지정하고, 이를 참조하는 방식

with menu
as (
    select
        *
    from
        tbl_menu
)
select
    *
from
    menu; -- menu라는 이름으로 바로 참조 가능

-- 위 쿼리를 아래와 같이 간략하게 작성 가능
with cnt_by_category
as (
        select
            category_code,
            count(*) cnt
        from
            tbl_menu
        group by
            category_code
)
select
    max(cnt),
    min(cnt)
from cnt_by_category;