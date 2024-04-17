-- -----------------------------------
-- GROUP BY
-- -----------------------------------
-- DQL 에서 특정 컬럼 값에 근거해 행을 그룹핑하는 구문
-- 1개 이상의 컬럼 또는 가상컬럼(계산식)이 기준이 될 수 있다.

-- 카테고리별 메뉴 집계
select
#     menu_name, -- group by와 연관이 없는 일반 컬럼은 사용할 수 없다.
    category_code,
    count(*),
    sum(menu_price),
    avg(menu_price),
    max(menu_price),
    min(menu_price)
from
    tbl_menu
group by
    category_code;




-- 카테고리별로 그룹을 나누었을때 메뉴개수가 1개보다 많은 그룹을 조회
select
    category_code,
    count(*) cnt_by_category
from
    tbl_menu
# where
#   count(*) > 1
group by
    category_code
having count(*) > 1
order by
    cnt_by_category desc;

-- 카테고리별 개수 조회
-- with rollup : group by category행 추가, 모든행 한그룹으로 행 추가
-- with rollup은 groupby에 대해 단방향 소계(앞선 컬럼기준)를 제공한다
-- with rollup 사용시에는 group by의 컬럼 작성순서가 중요하다.
select
    category_code,
    count(*),
    sum(menu_price),
    avg(menu_price)
from
    tbl_menu
group by
    category_code,
    menu_price with rollup;

# grouping 함수
-- 실제데이터와 집계데이터(with rollup)를 구분해주는 함수
-- 실제데이터는 0을 반환
-- 집계데이터 1을 반환
select
    if(grouping(category_code) = 0, ifnull(category_code, '카테고리없음'), null) category_code,
#     grouping(category_code),
    count(*)
from
    tbl_menu
group by
    category_code with rollup;

