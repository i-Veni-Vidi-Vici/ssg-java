-- ==============================
-- 고급쿼리
-- ==============================

-- ------------------------------
-- WINDOW FUNCTION (OS와는 관계가 없다)
-- ------------------------------
-- 행과 행간의 관계를 쉽게 정의하기 위한 함수
-- GROUP BY와 같이 데이터를 그룹핑한 결과를 반환하는데, 일반컬럼과 동시에 표현이 가능하다.

# 구분
# 순위관련 함수(Rank Function)
#  - RANK, DENSE_RANK, ROW_NUMBER
# 집계관련 함수(Aggregate Function)
#  - SUM, MAX, MIN, AVG, COUNT
#  - SQL Server 경우 Over절 내 order by 지원 못함
# 순서관련 함수
#  - FIRST_VALUE, LAST_VALUE, LAG, LEAD
#  - ORACLE 만 지원
# 비율관련 함수
#  - CUME_DIST, PERCENT_RANK, NTILE, RATIO_TO_REPORT
#  - PERCENT_RANK 함수는 ANSI/ISO SQL 표준과 Oracle DBMS에서 지원
#  - NTILE 함수는 ANSI/ISO SQL 표준에는 없지만, Oracle, SQL Server에서 지원
#  - RATIO_TO_REPORT 함수는 Oracle에서만 지원(현업에서 유용).
# 통계분석 함수
#  - CORR, COVAR_POP, COVAR_SAMP, STDDEV, STDDEV_POP, STDDEV_SAMP, VARIANCE, VAR_POP, VAR_SAMP, REGR_(LINEAR REGRESSION), REGR_SLOPE, REGR_INTERCEPT, REGR_COUNT, REGR_R2, REGR_AVGX, REGR_AVGY, REGR_SXX, REGR_SYY, REGR_SXY
#
# 문법
# window_function(인자) over([partition by][order by][windowing절])
# 이자 : 윈도우함수별로 0-n개 작성
# over절
#     partition by : group by와 비슷하게 윈도우함수내 그룹핑 지정
#     order by : order by와 비슷하게 윈도우 함수 내 정렬을 지원
#     windowing절 : 대상행 지정
#
# 순위함수
# rank 중복된 행이 있는 경우, 개수만큼 다음 순위 부려 ex) 12333678
# dense rank 중복된 행이 있는 경우에도, 순위를 건너뛰지 않음. ex) 12334567
# row-number 중복된 행이 있어도 고유한 순위를 부여
use menudb;
select
    menu_name as 메뉴이름,
    menu_price as 가격,
    rank() over (order by menu_price) as rank순위,
    dense_rank() over (order by menu_price) as dense순위,
    row_number() over (order by menu_price) as row_number순위
from
    tbl_menu;

# 집계함수
-- sum, min, max, avg, count와 같은 그룹함수의 윈도우함수버전
-- 일반커럼과 동시에 사용이 가능하다
-- over(order by)절을 통해 집계 순서에 따른 값의 추이를 조회

select
    menu_name,
    sum(menu_price) over() 'sum',
    avg(menu_price) over() 'avg',
    max(menu_price) over() 'max',
    min(menu_price) over() 'min',
    count(*) over() 'count'
from
    tbl_menu;

-- partition by절을 통해 그룹에 대한 집계 조회
select
    category_code as 카테고리,
    menu_name as 메뉴이름,
    menu_price as 가격,
    round(avg(menu_price)) over (partition by category_code ) as 그루별avg, # 카테고리별로 각각 구해진다
    sum(menu_price) over (partition by category_code order by  menu_price) as 그룹별sum # 카테고리별로 각각 구해진다
    from tbl_menu;

-- 지난 3개월간 제품별 판매수량 누계를 조회
# 지금 여기서는 누계를 할꺼야 근데 나누는 조건은 prod_name 이고, 정렬은 날짜, 이름으로 할꺼야
select
    prod_name as 제품이름,prod_count as 판매량,
    sum(prod_count) over(partition by prod_name order by sale_date   ) as 제품별누계,
    sum(prod_count) over( order by sale_date,prod_name ) as 전체누계,
    sale_date as 날짜
from (select *
      from tbl_sales
      union all
      select *
      from tbl_sales_202402
      union all
      select *
      from tbl_sales_202403)
    as product;
select *
from tbl_sales;

# 비율함수
-- ratio_to_report
-- 전체중에 특정레코드 비율을 계산해서 소수점 값으로 반환
-- 결과값의 범위는 0.0<=n<=1.0
-- mysql은 지원하지 않음

-- 전체 메뉴 가격중에 현재 매뉴의 비율조회를 해라
select menu_name as 메뉴이름,
       menu_price as 가격,
       round(menu_price /sum(menu_price) over (),2) ratio
from tbl_menu;

# 그룹핑 함수관련
-- group_concat(컬럼) 그룹핑된 레코드의 값을 모아서 출력
select
    category_code,group_concat(menu_name separator '/'),
    count(*)
from tbl_menu
group by category_code;

-- -----------------------------------
-- 계층형 쿼리
-- -----------------------------------
-- Hierarachical query
-- 기준컬럼을 가지고 수직적으로 행과 행을 연결
-- 조직도, 메뉴, 답변형게시판, 댓글등의 처리에 적합
-- mysql에서는 재귀커리로써 처리가 가능하다

-- 카레고리 계층 표현
with recursive category_hierarchy (code, name, path)
    as (
    select
        category_code as code,
        category_name as name,
        cast(category_code as char(100))as path
    from
        tbl_category
    where
        ref_category_code is null
    union all
    select
        tc.category_code,
        tc.category_name,
        concat(ch.path,'>',tc.category_code)
    from category_hierarchy ch
    join tbl_category tc on ch.code=tc.ref_category_code
)
select *
from category_hierarchy
order by path;

use empdb;

with recursive employee_hierarchy (id,name,level, path)
as(
    #union all 기준으로 위는 root행
    select
        EMP_ID,
        EMP_NAME,
        1 level,
        cast(EMP_ID as char(100)) path
    from
        employee
    where
        EMP_ID=200
        #MANAGER_ID is null
    # 여기가 루트 조건이니 아래있는 애가 manager_id를 조건으로 쓴다
    # null값이 되면 더 이상 작동을 안한다

    union all

    select
        e.EMP_ID as id,
        e.EMP_NAME as 이름,
        eh.level+1,
        concat(eh.path,'>',eh.id) # 상위에서 '>' 하위 ch.id를 붙인다
    from
        employee_hierarchy eh join employee e
    on eh.id=e.MANAGER_ID
    )

select
    concat(space((level-1)*5),name,'(',id,')')as 조직도,
    level,
    path
from employee_hierarchy
order by path;

-- -------------------------------------
-- 임의의 행 추가하기
-- -------------------------------------
-- 사원테이블에서 입사년도별 인원수 조회
-- 특정수의 거듭제곱식으로 행추가가 가능하다
with a as ( select 1 union all select  1 union all select 1 ),
     b as (select row_number() over () from a a1, a a2, a a3)
select *
from
    b;

with a as ( select 1 union all select  1 union all select 1 union select 1 union all select  1 union all select 1 ),
     b as (select 1989+ row_number() over () year from a a1, a a2)
select b.year,
       ifnull(e.cnt,0) cnt
from
    b left join (
        select
            year(HIRE_DATE) hire_year,
            count(*) cnt
        from
            employee
        group by
            year(HIRE_DATE)
    ) e
        on b.year=e.hire_year
where b.year<=year(curdate())
order by 1;