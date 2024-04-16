-- ================================
-- GROUP BY
-- ================================
-- DQL에서 특정컬럼 값에 근거해 행을 그룹핑하는 구문
-- 1개 이상의 컬럼 또는 가상 컬림(계산식)이 기준이 될 수 있다.

-- 카테고리별 메뉴 집계
select category_code 코드,
       count(*) count

from tbl_menu
group by category_code;# 지금 여기는 카테고리 별로 묶은걸 기준으로 select한다
;
-- 2개이상의 컬럼 기준으로 그룹을 지정 가능
-- 2개의 컬럼값을 가지고 그루핑을 진행한다 (이때 칼럼 순서는 상관없다)

-- 여기서 select에서는 그룹에 없는 요소는 작성을 못한다
select
    category_code,
    menu_price,
count('*')
from
    tbl_menu
group by
    category_code, menu_price
order by 1;

-- --------------------------------
-- HAVING
-- --------------------------------
-- group by로 정해진 그룹에 대해 조건절을 작성합니다
-- 그룹함수를 사용한 조건은 having절에서만 작성할 수 잇다

-- 카테고리별로 그룹을 나누었을때 네뮤개수가 1개보다 많은 그룹을 조회

select category_code,
       count(*) cnt
from tbl_menu
group by
    category_code
having count(*)>1
order by cnt;

select category_code
    from tbl_menu;

# with rollup
-- group by절의 추가적인 소계를 제공하는 기능

-- 카테고리별 개수 조회
select category_code,
       count(*) 묶인개수,
       sum(menu_price),
       avg(menu_price)
from tbl_menu
group by category_code with rollup;
# group by전 모든 행을 하나로 봤을때 count(*)를 추가로 제공.

-- 카테고리, 가격으로 그룹 조회
-- with rollup : group by category행 추가, 모든 행 한그룹으로 행 추가
-- with rollup은 group by에 대해 단방향 소계(앞선 컬럼기준)를 제공한다
-- with rollup 사용시에는 group by의 컬럼 작성순서가 중요하다



select category_code 카테고리,
       menu_price 가격,
       count(*) 묶인_개수,
       sum(menu_price) 총합
from tbl_menu
group by category_code,
         menu_price with rollup
order by category_code;

# grouping 함수
-- 실제데이터와 집계데이터(with rollup)를 구분해주는 함수
-- 실제데이터는 0을 반환
-- 집계데이터는 1을 반환
select if(grouping(category_code)=0,ifnull(category_code,'카테고리없음'),''),
       #grouping(category_code),
       count(*) 묶인개수
from tbl_menu
group by category_code with rollup;