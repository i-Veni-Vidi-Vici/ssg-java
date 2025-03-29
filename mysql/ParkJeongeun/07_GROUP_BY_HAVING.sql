-- ----------------
-- GROUP BY
-- ----------------
-- DQL에서 특정 컬럼 값에 근거해 행을 그룹핑하는 구문
-- 1개 이상의 컬럼 또는 가상컬럼(계산식)이 기준이 될 수 있음

-- 카테고리별 메뉴 집계
select
#    menu_name, -- group by와 연관이 없는 일반 컬럼은 사용 불가
    category_code,
    count(*),
    sum(menu_price),
    avg(menu_price),
    max(menu_price),
    min(menu_price)
from tbl_menu
group by
    category_code;

-- 2개 이상의 컬럼 기준으로 그룹 지정 가능
-- 2개의 컬럼값을 가지고 그룹핑 진행 (컬럼 순서는 상괎없음)
-- 조회결과 21행 -> 21개 그룹
select
#    menu_name, -- group by와 연관이 없는 일반 컬럼은 사용 불가
    category_code,
    menu_price,
    count(*)
from tbl_menu
group by
    category_code,
    menu_price
order by
    1, 2;

-- n개의 컬럼 대상으로 distinct한 것처럼 그룹핑 일어남
select distinct
    category_code,
    menu_price
from tbl_menu
order by
    1, 2;

-- --------------------
-- HAVING
-- --------------------
-- group by로 정해진 그룹에 대해 조건절 작성
-- 그룹함수를 사용한 조건은 having 절에서만 작성 가능
-- group by없이 having 단독 사용 불가

-- 카테고리별로 그룹을 나눴을때 메뉴 개수가 1개보다 많은 그룹 조회
select
    category_code,
    count(*) cnt
from tbl_menu
group by category_code
having count(*) > 1 -- 다른 카테고리 코드와 중복되지 않은 수를 가진 것
order by cnt;

# with rollup
-- group by절의 추가적인 소계 제공하는 기능

-- 카테고리별 개수 조회
select category_code,
       count(*),
       sum(menu_price),
       avg(menu_price)
from tbl_menu
group by category_code with rollup;


-- group by전 모든 행을 하나의 그룹으로 봤을때, count(*)를 추가로 제공

select
    category_code,
    menu_price,
    count(*)
from tbl_menu
group by
    category_code,
    menu_price;

-- 카테고리, 가격으로 그룹 조회
-- with rollup : group by category행 추가. 모든 행 한그룹으로 행 추가
-- with rollup은 group by 에 대해 단방향 소계(앞선 컬럼 기준) 제공
-- with rollup 사용시 group by의 컬럼 작성 순서 중요
select
    category_code,
    menu_price,
    count(*)
from tbl_menu
group by
    category_code,
    menu_price with rollup;

# grouping 함수
-- 실제 데이터와 집계 데이터(with rollup에 의한 것)를 구분해주는 함수
-- 실제 데이터 0
-- 집계 데이터 1
select
    if(grouping(category_code) = 0, ifnull(category_code, '카테고리없음'), null) category_code,
    count(*)
from tbl_menu
group by category_code with rollup;