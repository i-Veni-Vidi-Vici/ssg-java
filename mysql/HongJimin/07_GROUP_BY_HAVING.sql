-- ---------------------------------------
-- GROUP BY
-- ---------------------------------------
-- DQL에서 특정 컬럼 값에 근거해 행을 그룹핑하는 구문
-- 1개 이상의 컬럼 또는 가상 컬럼이 기준이 될 수 있음

-- 카테고리별 메뉴 집계
-- 22행 -> 9행(9개의 그룹으로 나뉨)
select
#     menu_name, -- group by와 연관이 없는 일반 컬럼은 사용할 수 없다.
    -- xpression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'menudb.tbl_menu.menu_name' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by

    category_code,
    count(*),
    sum(menu_price), -- 그룹 별로 나눠서 계산해줌
    avg(menu_price),
    max(menu_price),
    min(menu_price)
from
    tbl_menu
group by
    category_code; -- 행을 그룹핑 해줌

-- 2개 이상의 컬럼 기준으로 그룹을 지정 가능
-- 2개의 컬럼값을 가지고 그루핑을 진행한다. (이때 컬럼 순서는 상관 없다)
-- 21행 -> 21그룹
select
#     menu_name, -- group by와 관계없는 컬럼은 작성할 수 없다
    category_code,
    menu_price,
    count(*)
from
    tbl_menu
group by
    category_code,
    menu_price
order by
    1, 2;

-- n개의 컬럼 대상으로 distinct한 것처럼 그룹핑이 일어난다.
select distinct
    category_code,
    menu_price
from
    tbl_menu
order by
    1, 2;

-- ---------------------------------------
-- HAVING
-- ---------------------------------------
-- group by로 정해진 그룹에 대해 조건절을 작성
-- 그룹 함수를 사용한 조건은 having 절에서만 작성할 수 있다.
-- group by 없이 having 단독으로는 사용 불가능하다.

-- 카테고리 별로 그룹을 나누었을 때, 메뉴 개수가 1개보다 많은 그룹을 조회
select
    category_code,
    count(*) cnt_by_category
from
    tbl_menu
# where
#     count(*) > 1, -- ⛳group by가 쓰이면 쓸 수 없음!
group by
    category_code
having
    count(*) > 1
order by
    cnt_by_category desc ;

# with rollup
-- group by절의 추가적인 소계를 제공하는 기능

-- 카테고리별 개수 조회
select
    category_code,
    count(*),
    sum(menu_price),
    avg(menu_price)
from
    tbl_menu
group by
    category_code with rollup;-- group by전 , 모든 행을 하나로 봤을 때 count(*)를 추가로 제공 -> 소계와 같다고 생각하기

-- 카테고리, 가격으로 그룹 조회
-- with rollup : group by category 행 추가, 모든 행 한 그룹으로 행 추가
-- with rollup은 group by에 대해 단방향 소계(앞선 컬럼기준)를 제공한다.
-- with rollup 사용시에는 group by의 컬럼 작성 순서가 중요하다.
select
    category_code,
    menu_price,
    count(*)
from
    tbl_menu
group by
    category_code,
    menu_price with rollup; -- 카테고리 별 행의 개수 소계같은 느낌!

# grouping 함수
-- 실제 데이터와 집계데이터(with rollup)를 구분해주는 함수
-- 실제 데이터는 0을 반환
-- 집계 데이터는 1을 반환
select
    if(grouping(category_code) = 0, category_code, '') category_code,
#     grouping(category_code),
    count(*)
from
    tbl_menu
group by
    category_code with rollup;