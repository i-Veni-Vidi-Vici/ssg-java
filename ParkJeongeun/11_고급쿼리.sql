-- ====================
-- 고급쿼리
-- ====================

-- --------------------
-- WINDOW FUNCTION
-- --------------------
-- 행과 행 간의 관계를 쉽게 정의하기 위한 함수
-- group by와 같이 데이터를 그룹핑한 결과를 반환하는데, 일반컬럼과 동시에 표현 가능

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
--  - CORR, COVAR_POP, COVAR_SAMP, STDDEV, STDDEV_POP, STDDEV_SAMP, VARIANCE, VAR_POP,
--    VAR_SAMP, REGR_(LINEAR REGRESSION), REGR_SLOPE, REGR_INTERCEPT, REGR_COUNT,
--    REGR_R2, REGR_AVGX, REGR_AVGY, REGR_SXX, REGR_SYY, REGR_SXY

# 문법
-- windown_function(인자) over([partition by][order by][windowing절])
-- 인자 : 윈도우 함수별로 0 ~ n개 작성
-- over절
--  - partition by : group by와 비슷하게 윈도우 함수 내 그룹핑 지정
--  - order by : order by와 비슷하게 윈도우 함수 내 정렬 지원
--  - windowing절 : 대상행 지정

# 순위함수
-- RANK 중복된 행이 있는 경우(중복순위있으면) 개수만큼 건너띄고 다음 순위 부여
-- DENSE_RANK 중복된 행이 있는 경우에도 순위를 건너띄지 않음
-- ROW_NUMBER 중복된 행이 있어도 고유한 순위 부여
select
    menu_name,
    menu_price,
    rank() over (order by menu_price) 'rank',
    dense_rank() over (order by menu_price) 'dense_rank',
    row_number() over (order by menu_price) 'row_number'
from tbl_menu;

# 집계함수
-- SUM, MAX, MIN, AVG, COUNT와 같은 그룹함수의 윈도우함수 버전
-- 일반 컬럼과 동시에 사용 가능
-- over(order by)절을 통해 집계 순서에 따른 값의 추이를 조회 가능
select
    menu_name,
    sum(menu_price) over() 'sum',
    avg(menu_price) over() 'avg',
    count(*) over() 'count',
    max(menu_price) over() 'max',
    min(menu_price) over() 'min'
from tbl_menu;

-- partition by절을 통해 그룹에 대한 집계 조회
select
    menu_name,
    menu_price,
    category_code,
    round(avg(menu_price) over(partition by category_code)) avg_by_category,
    sum(menu_price) over(partition by category_code order by menu_price) sum_by_category
from tbl_menu;

-- 지난 3개월간 제품별 판매수량 누계 조회
with sales
as
(select *
from tbl_sales
union all
select *
from tbl_sales_202403
union all
select *
from tbl_sales_202402)
select
    sale_date,
    prod_name,
    prod_count,
    sum(prod_count) over(partition by prod_name order by sale_date) 제품별누계,
    sum(prod_count) over(order by sale_date, prod_name) 전체제품누계
from sales
order by sale_date;

# 비율함수
-- ratio_to_report
-- 전체 중에 특정 레코드 비율 계산해서 소수점 값으로 반환 (1 = 100%)
-- 결과값의 범위는 0.0 <= n <= 1.0
-- mysql은 지원하지 않음

-- 전체 메뉴 가격 중 현재 메뉴의 비율 조회
select
    menu_name,
    menu_price,
    round(menu_price / sum(menu_price) over(), 2) ratio
from tbl_menu;

# 그룹핑 함수 관련
-- group_concat(컬럼) : 그룹핑된 레코드의 값을 모아서 출력
-- 기본 구분자는 콤마(,). 필요에 의해 separator로 구분자 변경 가능
select
    category_code,
    group_concat(menu_name separator '/'),
    count(*)
from tbl_menu
group by category_code;

-- -----------------------
-- 계층형 쿼리
-- -----------------------
-- Hierarchical Query
-- 기준 컬럼을 가지고 수직적으로 행과 행 연결
-- 조직도, 메뉴, 답변형 게시판, 댓글 등의 처리에 적합 (fractal 구조)
-- mysql에서는 재귀쿼리로써 처리

-- 카테고리 계층 표현
with recursive category_hierarchy (code, name, path) -- recursive 재귀
as (
    # 상위 카테고리 1,2,3 출력
    select
        category_code code,
        category_name name,
        cast(category_code as char(100)) path
    from tbl_category
    where ref_category_code is null

    union all
    # 상위 카테고리 하나당 하위 카테고리들이 join됨
    select
        tc.category_code,
        tc.category_name,
        concat(ch.path, '>', tc.category_code)
    from category_hierarchy ch join tbl_category tc
    on ch.code = tc.ref_category_code
    )
select *
from category_hierarchy
order by path;

-- 사원테이블의 조직도
-- 사번, 사원명
use empdb;

with recursive employee_hierarchy (id, name, level, path) -- 컬럼값
as (

    select
        EMP_ID,
        EMP_NAME,
        1 level, -- 계층으로 사용할 level 컬럼 선언 (기본값은 1)
        cast(EMP_ID as char(100)) path
    from employee
    where
        EMP_ID = 200
#        manager_id is null

    union all

    select
        e.EMP_ID,
        e.EMP_NAME,
        eh.level +1, -- 하위직원 한명 생길때마다 1씩 더하기
        concat(eh.path, '>', e.EMP_ID)
    from employee_hierarchy eh join employee e
                                on eh.id = e.MANAGER_ID
)
select
    concat(space((level - 1) * 5), name, '(', id, ')') 조직도, -- level 1이면 공백0, 2면 공백5, 3이면 10
    level,
    path
from employee_hierarchy
order by path;

-- --------------------
-- 임의의 행 추가
-- --------------------
-- 사원 테이블에서 입사년도별 인원수 조회

-- 사원이 있는 입사년도만 출력됨
select
    year(HIRE_DATE) hire_year,
    count(*)
from employee
group by year(HIRE_DATE)
order by 1;

-- 특정 수의 거듭제곱 이용하여 행 추가
-- 사원이 없는 입사년도도 모두 추가
with
    a as (select 1 union all select 1 union all select 1 union all select 1 union all select 1 union all select 1), -- 6행,
    b as (select 1989 + row_number() over() year from a a1, a a2) -- cross join -- 6 * 6 = 36행 / year는 별칭
select b.year,
       ifnull(e.cnt, 0) cnt
from b left join (
    select
        year(HIRE_DATE) hire_year,
        count(*) cnt
    from employee
    group by year(HIRE_DATE)
    ) e
    on b.year = e.hire_year
where b.year <= year(curdate())
order by 1;