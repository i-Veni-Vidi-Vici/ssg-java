
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

use menudb;

select
    menu_name,
    sum(menu_price) over() 'sum',
    count(*) over() 'total',
    avg(menu_price) over() 'average'
from tbl_menu;

select
    menu_name,
    menu_price,
    avg(menu_price) over(partition by category_code)
from tbl_menu;

select
    sale_date created_at,
    prod_name 상품명,
    prod_count 판매량,
    sum(prod_count) over(partition by prod_name order by sale_date) 제품별누계,
    sum(prod_count) over(order by sale_date, prod_name) 전체제품누계
from (select * from tbl_sales_202402 union select * from tbl_sales_202403 union select * from tbl_sales) total;

select
    menu_name,
    menu_price,
    round(menu_price/ sum(menu_price) over(), 2)
from tbl_menu;

select
    category_code,
    group_concat(menu_name),
    count(*)
from tbl_menu
group by category_code;

with recursive category_hierarchy(code, name, path)
as(
    select
        category_code code,
        category_name name,
        cast(category_code as char(100)) path
    from tbl_category
    where ref_category_code is null

    union all

    select
        tc.category_code,
        tc.category_name,
        concat(ch.path, '>', tc.category_code)
    from category_hierarchy ch
        join tbl_category tc on ch.code = tc.ref_category_code
    )
select *
from category_hierarchy
order by path;

use empdb;

with recursive hierarchy_manager(name, id,level,path)
as(
    select
        EMP_NAME name,
        EMP_ID id,
        1 level,
        cast(EMP_ID as char(100)) path
    from employee
    where MANAGER_ID is null

    union all

    select
        emp.EMP_NAME,
        emp.EMP_ID,
        mng.level+1,
        concat(path,'>', emp.EMP_ID)
    from employee emp join hierarchy_manager mng on EMP.MANAGER_ID= mng.id
    )
select
    concat(space((level-1)*5),name, '(', id, ')') 조직도
from hierarchy_manager
order by path;

with
    a as(select 1 union all select 1 union all select 1),
    b as(select row_number() over () from a a1, a a2, a a3)
select
    *
from
    b;

with
    6years as (select 1 union all select 1 union all select 1 union all select 1 union all select 1 union all select 1),
    36years as (select 1989+row_number() over () from (6years y1 cross join 6years y2))
select
    year(HIRE_DATE) hire_date,
    count(*) count
from
    employee
group by
    year(HIRE_DATE)
order by
    year(HIRE_DATE);