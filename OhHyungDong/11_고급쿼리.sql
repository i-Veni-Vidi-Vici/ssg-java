-- =====================
-- 고급 쿼리
-- =====================

-- ----------------
-- WINDOW FUNCTION
-- ----------------
-- 행과 행간의 관계를 쉽게 정의 하기 위한 함수
-- group by와 같이 데이터를 그룹핑해서 그룹핑한 결과를 반환하는데, 일반컬럼과 동시에 표현이 가능하다.

# 구-- 순위관련 함수(Rank Function)
# --  - RANK, DENSE_RANK, ROW_NUMBER
# -- 집계관련 함수(Aggregate Function)
# --  - SUM, MAX, MIN, AVG, COUNT
# --  - SQL Server 경우 Over절 내 order by 지원 못함
# -- 순서관련 함수
# --  - FIRST_VALUE, LAST_VALUE, LAG, LEAD
# --  - ORACLE 만 지원
# -- 비율관련 함수
# --  - CUME_DIST, PERCENT_RANK, NTILE, RATIO_TO_REPORT
# --  - PERCENT_RANK 함수는 ANSI/ISO SQL 표준과 Oracle DBMS에서 지원
# --  - NTILE 함수는 ANSI/ISO SQL 표준에는 없지만, Oracle, SQL Server에서 지원
# --  - RATIO_TO_REPORT 함수는 Oracle에서만 지원(현업에서 유용).
# -- 통계분석 함수
# --  - CORR, COVAR_POP, COVAR_SAMP, STDDEV, STDDEV_POP, STDDEV_SAMP, VARIANCE, VAR_POP, VAR_SAMP, REGR_(LINEAR REGRESSION), REGR_SLOPE, REGR_INTERCEPT, REGR_COUNT, REGR_R2, REGR_AVGX, REGR_AVGY, REGR_SXX, REGR_SYY, REGR_SXY

# 문법
-- window_function(인자) over[partition by] [order by] [windowing]절)
-- 인자 : 윈도우 함수별로 0~n개 작성
-- over절
    -- partition by : group by와 비슷하게 윈도우함수 내 그룹핑 지정
    -- order by : order by와 비슷하게 윈도우 함수 내 정렬
    -- windowing절 : 대상행 지정

# 순위함수
-- rank : 중복된 행이 있는 경우, 개수만큼 건너뛰고 다음 순위 부여
-- dense_rank : 중복된 행이 있는 경우에도 , 순위를 건너뛰지 않음.
-- row_number : 중복된 행이 있어도, 고유한 순위를 부여.

select
    menu_name,
    menu_price,
    rank() over(order by menu_price) 'rank',
    dense_rank() over(order by menu_price) 'rank',
    row_number() over(order by menu_price) 'rank' -- 값이 날라도 다른 순위 부여
from tbl_menu;

# 집게함수
-- sum, min,max,avg,count와 같은 그룹함수의 윈도우 함수 버젼
-- 일반컴럼과 동시에 사용이 가능하다.
-- over(order by)절을 통해 집계 순서에따라 값이 추이를 보고 조회, 누적 데이터 사용 할 때 order by가 용이하다.

select
    sum(menu_price) over() 'sum',-- 그룹함수는 group by없이 사용이 불가하므로 window함수로 사용 가능
    avg(menu_price) over() 'avg',
    count(*) over() 'count',
    max(menu_price) over() 'count',
    min(menu_price) over() 'count'
from tbl_menu;

-- partition by절을 통해 그룹에 대한 집계 조회
select
    menu_name,
    menu_price,
    tbl_menu.category_code,
    round(avg(menu_price) over(partition by category_code)) avg_by_categroy,
    sum(menu_price) over (partition by category_code order by menu_price ) sum_by_category
    -- 가격 싼순으로 가격을 더해 가면서
    from tbl_menu;
show tables;
select * from tbl_sales;
-- 지난 3개월간 제품별 판매수량 누계를 조회
select t.prod_name,
       t. prod_count,
       t.sale_date,
       sum(prod_count) over (partition by prod_name order by sale_date) as 제품별누계,
       sum(prod_count) over (order by sale_date, prod_name) '전체제품누계'
from (select * from tbl_sales
        union
      select * from tbl_sales_202403
             union
     select * from tbl_sales_202402
     )as t;

# 비율 함수
-- ratio_to_report
-- 전체중에 특정레코드 비율을 계산해서 소수점 값으로 반환(1 = 100%)
-- 결과값의 범위는 0.0 <= n <= 1.0이다
-- mysql은 지원하지 않는다.

-- 전체 메뉴 가격중에 현재 메뉴의 비율 조회
select
    menu_name,
    menu_price,
    round(menu_price / sum(menu_price) over(),2) ratio
from tbl_menu

# 그룹핑 함수관련
-- group_concat(컬럼) 그룹핑된 레코드의 값을 모아서 출력

select
    category_code,
    group_concat(menu_name separator '/'),
    count(*)
from tbl_menu
group by
    category_code;

-- ----------------------------
-- 계층형 쿼리
-- ----------------------------
-- Hierarachial Query
-- 기준컬럼을 가지고 수직적으로 행과 행을 연결
-- 조직도, 메뉴, 답변형 게시판등의 댓글등의 처리에 적합하다.
-- mysql에는 재귀커리로써 처리

-- 카테고리 계층 표현
-- recursive에서 union을 하면 테이블이 세로로 붙는것이 아닌 테이블이 행별로 붙음 -> 계층적 구조 형성
with recursive categroy_hierarchy(code, name, path)
as(
    select
        category_code code,
        category_name name,
        cast(category_code as char(100)) path
    from tbl_category
    where
        ref_category_code is null
    union all
    select
        tc.category_code,
        tc.category_name,
        concat(ch.path, '>', tc.category_code)
    from categroy_hierarchy ch
        join tbl_category tc
            on ch.code = tc.ref_category_code
)
select
    *
from categroy_hierarchy
order by path;

-- 사원테이블에 조직도 생성
use empdb;
-- 사번 / 사원명
show tables;
select * from employee;

with recursive employee_hierarchy(id, name,level, path) -- no, name , path 보일 컬럼값
as(
    -- 매니저가 없는 사원들 출력
    select emp_id ,
           emp_name ,
           1 level,
           cast(emp_id as char(1000)) path
    from employee e
    where emp_id = 200# MANAGER_ID is null
    --
    union all
    -- 밑에 붙여야 할 행
    select e.emp_id,
           e.emp_name,
           eh.level + 1,
           concat(eh.path, '>',e.emp_id)
    from employee_hierarchy eh
        join employee e
        on eh.id = e.MANAGER_ID
)select
    concat(space((level-1)*5),name, '(',id,')') 조직도,
    level,
    path
from employee_hierarchy
order by path;

-- ---------------
-- 임의의 행 추가 하기
-- ---------------
-- 사원 테이블에서 입사년도별 인원수 조회
select
    year(hire_date) hire_year,
    count(*)
from EMPLOYEE
group by year(hire_date)
order by 1;
with
    a as (select 1 union all select 1 union all select 1 union all select 1 union all select 1 union all select 1),
    b as (select 1989 + row_number() over() year from a a1, a a2) -- 6 * 6
select
    b.year,
    ifnull(e.cnt, 0) cnt
from
    b left join (
        select
            year(hire_date) hire_year,
            count(*) cnt
        from
            employee
        group by
            year(hire_date)
    ) e
                on b.year = e.hire_year
where
    b.year <= year(curdate())
order by
    1;
-- 거듭제곱식으로 행추가
with
    a as(select 1 union all select 1 union all select 1 ),
    b as(select 1989 + row_number() over() from a a1, a a2, a a3) -- a를 cross join
select *
from b;

