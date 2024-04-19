-- =======================================
-- SUB-QUERY
-- =======================================
-- 하나의 SQL문(메인쿼리) 안에 포함된 또 하나의 SQL문(서브쿼리)
-- 존재하지 않는 값에 근거해서 쿼리를 작성해야 하는 경우 유용하다.
-- 메인쿼리 수행중에 서브쿼리를 만나면, 서브쿼리 우선실행하고 그 결과를 메인쿼리에 반환하는 구조

# 유형
-- 1. 일반 서브쿼리
-- 단일행 서브쿼리
-- 다중행 서브쿼리
-- 2. 상관 서브쿼리
-- 스칼라 서브쿼리
-- 3. 인라인뷰 (파생테이블) : from절에 사용한 서브쿼리

# 규칙
-- 서브쿼리는 반드시 소괄호를 묶어야 한다.
-- 서브쿼리내에서는 order by 지원하지 않는다.
-- 서브쿼리의 실행결과(행/컬럼) 수에 따라 사용해야하는 연산자가 다르다.

-- -----------------------------------
-- 일반 서브쿼리
-- -----------------------------------
# 단일행 서브쿼리
-- 서브쿼리의 실행결과가 1행인 경우

-- 열무김치라떼 메뉴의 카테고리명 조회
-- 1. tbl_menu에서 열무김치라떼의 행을 찾고, category_code 조회 (서브쿼리)
-- 2. tbl_category에서 특정행을 찾고, category_name 조회 (메인쿼리)
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
    category_code = 8;

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

-- 민트미역국과 같은 카테고리의 메뉴 조회
-- 1. 민트미역국의 카테고리 코드 조회 (서브쿼리)
-- 2. 카테고리코드가 1번과 동일한 메뉴 조회 (메인쿼리)
select
    *
from
    tbl_menu
where
    category_code = (
        select
            category_code -- 4
        from
            tbl_menu
        where
            menu_name = '민트미역국'
    )
  and menu_name != '민트미역국';

# 다중행 서브쿼리
-- 서브쿼리의 실행결과가 여러행인 경우

-- 식사류 카테고리가 1번일때, 모든 식사류 메뉴를 조회
-- 1. 식사류 1번의 하위 카테고리를 조회 (서브쿼리)
-- 2. 카테고리가 1번과 동일한 메뉴 조회 (메인쿼리)

-- [21000][1242] Subquery returns more than 1 row 서브쿼리가 여러행을 반환해서 생긴 오류
select
    *
from
    tbl_menu
where
    category_code in (select
                          c2.category_code
                      from
                          tbl_category c1 join tbl_category c2 on c1.category_code = c2.ref_category_code
                      where
                          c1.category_name = '식사'
    );
-- 상관서브쿼리
-- 카테고리별로 가격이 가장비싼 메뉴 조회
-- 1. 조인으로 해결하기

select
    category_code
    , count(*)
    , max(menu_price)
from
    tbl_menu
group by
    category_code;

-- join으로 처리하기
select
    *
from
    tbl_menu m left join (select
                         category_code
                          , count(*)
                          , max(menu_price) as max_menu_price
                     from
                         tbl_menu
                     group by
                         category_code
                     ) c on m.category_code = c.category_code
 where
     m.menu_price = max_menu_price;

-- 위 코드에서 카테고리코드가 null인 메뉴 중 가장 비싼것 찾기

select
    *
from
    tbl_menu m left join (select
                              category_code
                               , count(*)
                               , max(menu_price) as max_menu_price
                          from
                              tbl_menu
                          group by
                              category_code
    ) c on ifnull(m.category_code, 0) = ifnull(c.category_code, 0)
where
    m.menu_price = max_menu_price
order by
    m.category_code is null,
    m.category_code;

-- 2. 상관 서브쿼리로 처리하기

select
    *
from
    tbl_menu m
where
#     menu_price = (카테고리별 가장 비싼 금액)
    m.menu_price = (select max(menu_price) from tbl_menu where category_code = m.category_code);

--
select
    max(menu_price)
from
    tbl_menu
where
    category_code = 11;

-- 카테고리별 평균가격보다 높은 가격의 메뉴 조회
select
    *
from
    tbl_menu m
where
    m.menu_price > (select avg(menu_price) from tbl_menu where category_code = m.category_code);

# exists 연산자

select
    *
from
    tbl_category c
where
    exists(select * from tbl_menu where category_code = c.category_code);

use empdb;
-- department 실제 부서원이 존재하는 부서만 조회
select distinct DEPT_CODE from employee;
-- department 실제 부서원이 존재하는 부서만 조회
select
    *
from
    department d
where
#     exists(select * from employee where DEPT_CODE = d.DEPT_ID);
    not exists(select * from employee where DEPT_CODE = d.DEPT_ID); -- 유령 부서

-- join으로 처리
select distinct
    d.DEPT_ID,
    d.DEPT_TITLE
from
    department d join employee e on d.DEPT_ID = e.DEPT_CODE;

use menudb;
-- not exists를 이용한 최대 / 최소 행 구하기
-- 가격이 가장 비싼 메뉴 조회

select
    max(menu_price)
from
    tbl_menu;
-- -----------------
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

select
    menu_name,
    (select tbl_category.category_name from tbl_category where category_code = m.category_code) category_name
from
    tbl_menu m;

-- 카테고리 테이블에서 카테고리명, 상위 카테고리명
select
    category_name,
    (select category_name from tbl_category where category_code = c.ref_category_code) ref_category_name
from
    tbl_category c;

-- 인라인 뷰
select
    category_name,
    ref_category_name
from(
    select category_name, (select category_name from tbl_category where category_code = c.ref_category_code) ref_category_name
    from tbl_category c
    ) t;

-- 메뉴테이블에서 카테고리별 메뉴갯수를 집계했을 때 최대 최소 값 조회

select max(num) max, min(num) min
      from (select count(*) num from tbl_menu group by category_code) num_of_category;

#common table expression
-- inline view에 이름을 지정하고, 이를 참조하는 방식


with cnt_by_categoty
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
from
    cnt_by_categoty;