-- ----------------------
-- GROUP BY
-- ----------------------
-- DQL에서 특정 컬럼 값에 근거해 행을 그룹핑하는 구문
-- 1개 이상의 컬럼 또는 가상컬럼(계산식)이 기준이 될 수 있다.

-- 카테고리별 메뉴 집계
-- 22행 -> 9행(9개 그룹)
select
    category_code,
    count(*),
    sum(menu_price),
    avg(menu_price),
    max(menu_price),
    min(menu_price)
from tbl_menu
group by
    category_code;

-- 2개 이상의 컬럼 기준으로 그룹을 지정 가능
-- 2개의 컬럼값을 가지고 그루핑을 진행한다. (이때 컬럼 순서는 상관없다)
-- 21행 -> 21그룹
select
    category_code,
       menu_price,
       count(*)
from tbl_menu
group by category_code,
         menu_price
order by
    1,2;
-- n개의 컬럼 대상으로 distinct한 것 처럼 구룹핑이 일어난다.
select distinct
    category_code,
    menu_price
from tbl_menu
order by
    1,2;
-- ----------------------
-- HAVING
-- ----------------------
-- group by로 정해진 그룹에 대해 조건절을 작성.
-- 그룹 함수를 사용한 조건은 having절에서만 작성할 수 있다.
-- group by 없이 having 단독으로는 사용 불가능하다.

-- 카테고리별로 그룹을 나누었을때 메뉴개수가 1개보다 많은 그룹을 조회
select
    category_code,
    count(*) cnt_by_category
from tbl_menu
group by
    category_code
having
    count(*) > 1
order by
    cnt_by_category desc;

# with rollup
-- group by 절에 추가적인 소계를 제공하는 기능

-- 카테고리별 개수 조회
select
    category_code,
    count(*),
    sum(menu_price),
    avg(menu_price)
from tbl_menu
group by
    category_code with rollup
order by 1,2;
-- group by 전 모든 행을 하나로 봤을때 count(*)를 추가로 제공.
-- with rollup : group by category행추가, 모든행 한그룹으로 행 추가
-- with rollup 사용시에는 group by의 컬럼 작성순서가 중요하다.
select
    category_code,
    menu_price,
    count(*)
from tbl_menu
group by
    category_code,
    menu_price with rollup;

# 그루핑 함수
-- 실제 데이터는 0을 반환
-- 집계 데이터는 1을 반환
select
    if(grouping(category_code)=0, ifnull(category_code, '카테고리 없음') , null) category_code,
    count(*)
from tbl_menu
group by
    category_code with rollup;