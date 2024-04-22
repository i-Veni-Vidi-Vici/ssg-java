-- =======================================
-- 고급쿼리
-- =======================================

-- ---------------------------------------
-- WINDOW FUNCTION
-- ---------------------------------------
-- 행과 행간의 관계를 쉽게 정의하기 위한 함수
-- group by와 같이 데이터를 그룹핑한 결과를 반환하는데, 일반컬럼과 동시에 표현이 가능한다.

# 구분
-- 순위관련 함수(Rank Function)
--  - RANK, DENSE_RANK, ROW_NUMBER
-- 집계관련 함수(Aggregate Function)
--  - SUM, MAX, MIN, AVG, COUNT
--  - SQL Server 경우 Over절 내 order by 지원 못함
-- 순서관련 함수
--  - FIRST_VALUE, LAST_VALUE, LAG, LEAD
--  - ORACLE 만 지원
-- 비율관련 함수
--  - CUME_DIST, PERCENT_RANK, NTILE, RATIO_TO_REPORT
--  - PERCENT_RANK 함수는 ANSI/ISO SQL 표준과 Oracle DBMS에서 지원
--  - NTILE 함수는 ANSI/ISO SQL 표준에는 없지만, Oracle, SQL Server에서 지원
--  - RATIO_TO_REPORT 함수는 Oracle에서만 지원(현업에서 유용).
-- 통계분석 함수
--  - CORR, COVAR_POP, COVAR_SAMP, STDDEV, STDDEV_POP, STDDEV_SAMP, VARIANCE, VAR_POP, VAR_SAMP, REGR_(LINEAR REGRESSION), REGR_SLOPE, REGR_INTERCEPT, REGR_COUNT, REGR_R2, REGR_AVGX, REGR_AVGY, REGR_SXX, REGR_SYY, REGR_SXY

# 문법
-- windown_function(인자) over([partition by] [order by] [windowing절])
-- 인자 : 윈도우함수별로 0~n개 작성
-- over절
-- partition by : group by와 비슷하게 윈도우함수내 그룹핑 지정
-- order by : order by와 비슷하게 윈도우함수내 정렬
-- windowing절 : 대상행 지정


# 순위함수
-- rank 중복된 행이 있는 경우, 개수만큼 건너뛰고 다음 순위 부여.
-- dense_rank 중복된 행이 있는 경우에도, 순위를 건너뛰지 않음.
-- row_number 중복된 행이 있어도 고유한 순위를 부여.

select
    menu_name,
    menu_price,
    rank() over(order by menu_price desc) 'rank',
    dense_rank() over(order by menu_price) 'dense_rank',
    row_number() over(order by menu_price) 'row_number'
from
    tbl_menu;

# 집계함수
-- sum, min, max, avg, count와 같은 그룹함수의 윈도우함수버젼
-- 일반컬럼과 동시에 사용이 가능하다.
-- over(order by)절을 통해 집계 순서에 따른 값의 추이를 조회

select
    menu_name,
    sum(menu_price) over() 'sum',
    avg(menu_price) over() 'avg',
    count(*) over() 'count',
    max(menu_price) over() 'max',
    min(menu_price) over() 'min'
from
    tbl_menu;

-- partition by절을 통해 그룹에 대한 집계 조회
select
    menu_name,
    menu_price,
    category_code,
    round(avg(menu_price) over(partition by category_code)) avg_by_category,
    sum(menu_price) over(partition by category_code order by menu_price) sum_by_category
from
    tbl_menu;

-- 지난 3개워간 제품별 판매수량 누계를 조회
select
    sale_date,
    prod_name,
    prod_count,
    sum(prod_count) over(partition by prod_name order by sale_date) '제품별 누계',
    sum(prod_count) over(order by sale_date, prod_name) '전체 누계'
from
    (select * from tbl_sales_202402
    union all
    select * from tbl_sales_202403
    union all
    select * from tbl_sales) t;

# 비율함수
    -- ratio_to_report
    -- 전체 중에 특정 레코드 비율을 계산해 소수점 값으로 반환(1 = 100%)
    -- 결과 값의 범위는 0.0 ≤ n ≤ 1.0
    -- mysql은 지원하지 않는다.

-- 전체 메뉴 가격 중에 현재 메뉴의 비율 조회
select
    menu_name,
    menu_price,
    round (menu_price / sum(menu_price) over(), 2) ratio
from tbl_menu;

# 그루핑 함수 관련
-- group_concat(컬럼) 그룹핑된 레코드의 값을 모아서 출력
select
    category_code,
    group_concat(menu_name separator '/'),
    count(*)
from
    tbl_menu
group by
    category_code;
-- -----------------------------------
-- 계층형 쿼리
-- -----------------------------------
-- Hierarachial Query
-- 기준 컬럼을 가지고 수직적으로 행과 행을 연결
-- 조직도, 메뉴, 답변형 게시판, 댓글 등의 처리에 적합(fractal 구조)
-- mysql에서는 재귀쿼리로써 처리

-- 카테고리 계층 표현
with recursive category_hierarchy (code, name, path)
as (
    select
        category_code code,
        category_name name,
        cast(category_code as char(100)) path
    from
        tbl_category
    where
        ref_category_code is null

    union all

    select
        tc.category_code,
        tc.category_name,
        concat(ch.path, ' > ', tc.category_code) -- ⛳아주 중요한 역할을 함!⛳
    from
        category_hierarchy ch
            join tbl_category tc
                on ch.code = tc.ref_category_code
    )
select
    *
from category_hierarchy
order by
    path;

-- 사원 테이블의 조직도 생성
-- 사번, 사원명
use empdb;
select *
from employee;
select *
from job;

with recursive emp_chart (id, name, level, path)
as (
    select
        EMP_ID code,
        EMP_NAME name,
        1 level, -- ⛳들여쓰기 하려고 만든거!
        cast(EMP_ID as char(100)) path
    from
        employee
    where
        MANAGER_ID is null

    union all

    select
        e.EMP_ID,
        e.EMP_NAME,
        ec.level +1,
        concat(ec.path, ' > ', e.EMP_ID)
    from
        emp_chart ec
            join employee e
                 on ec.id = e.MANAGER_ID
    )
select
    concat(space((level - 1) * 5),name, '(', id, ')') 조직도
from
    emp_chart
order by
    path;

-- -----------------------------------
-- 임의의 행 추가하기
-- -----------------------------------
-- 사원 테이블에서 입사년도별 인원수 조회
select
    year(HIRE_DATE) hire_year,
    count(*)
from
    employee
group by
    year(HIRE_DATE)
order by
    1;

-- 특정 수의 거듭제곱식으로 행 추가
with
    a as ( select 1 union all select 1 union all select 1),
    b as ( select 1989 + row_number() over() from a a1, a a2, a a3) -- 3 * 3 * 3 -> 크로스 조인한것
select
    *
from b;


with
    a as ( select 1 union all select 1 union all select 1 union all select 1 union all select 1 union all select 1),
    b as (select 1989 + row_number() over() year from a a1, a a2 ) -- 6*6 -> 크로스 조인한 것
select
    b.year,
    ifnull(e.cnt, 0) cnt
from
    b left join (
        select
            year(HIRE_DATE) hire_year,
            count(*) cnt
        from
            employee
        group by
            year(HIRE_DATE)
    )e
        on b.year = e.hire_year
where
    b.year <= year(curdate())
order by
    1;