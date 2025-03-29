-- ----------------
-- GROUP BY
-- ----------------
-- DQL에서 특정컬럼 값에 근거해 행을 그룸핑하는 구문
-- 1개이상의 컬럼 또는 가상컬럼(계산식)이 기준이 될수 있다.

-- 카테고리별 메뉴 집계
-- 2개이상의 컬럼 기준으로 그룹을 지정 가능
-- 2개의 컬럼값을 가지고 그루핑을 진행한다. (이때 컬럼 순서는 상관없다)
-- 21행 -> 21그룹

select
    category_code,
    menu_price,
    count(*) -- 21 21개의 그룹
from
    tbl_menu
group by
    category_code,
    menu_price
order by
    1,2;

# ctrl + shift + /

-- ----------------------
-- HABING
-- ----------------------
-- group by로 정해진 그룹에 대해 조건절을 작성.
-- 그룹함수를 사용한 조건은 having절에서만 작성할 수 있다.
-- group by 없이 having 단독으로는 사용불가능하다.

-- 카테고리별로 그룹을 나누었을때 메뉴개수가 1개보다 많은 그룸을 조회
select
    category_code,
    count(*) cnt_by_category
from
    tbl_menu
# where
#     count(*) > 1 # 집계호출은 여기서 못함
group by
    category_code # 그룹지으면 일반 칼럼 안되서 select * 아니면 안됨
having
    count(*) > 1
order by
    cnt_by_category desc; # 별칭가능

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
    category_code with rollup ;

-- group by 전 모든 행을 하나로 봤을때 count(*)를 추가로 제공.

-- 카테고리,가격으로 그룹조회
-- with rollup : gruop by category행 추가, 모든 행 한그룹으로 행 추가
-- with rollup은 group by에 대해 단방향 소계(앞선 컬럼기준)를 제공한다.
-- with rollup 사용시에는 group by의 컬럼 작성순서가 중요하다.

select
    category_code,
    menu_price,
    count(*)
from
    tbl_menu
group by
    category_code,
    menu_price with rollup; # category_code 종류 중간합계

select
    category_code,
    menu_price,
    count(*)
from
    tbl_menu
group by
    menu_price,
    category_code with rollup; # menu_price 종류 중간합계

# grouping 함수
-- 실제데이터와 집계데이터(with rollup)를 구분해주는 함수
-- 실제데이터는 0을 반환
-- 집계데이터는 1을 반환

select
    if(grouping(category_code) = 0, ifnull(category_code, '카테고리없음'),'') categoy_code,
#     grouping(category_code),
    count(*)
from
    tbl_menu
group by
    category_code with rollup ;
