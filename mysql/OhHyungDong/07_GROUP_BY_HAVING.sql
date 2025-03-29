-- -------------------
-- Group BY
-- -------------------
-- DQL에서 특정컬럼 값에 근거해 행을 그룹핑하는 구문
-- 1개 이상의 컬럼 또는 가상컬럼(계산식)이 기준이 될 수 있다.

-- 카테고리별 메뉴 집계
-- 22 -> 9행
select
    -- menu_name, : group by와 연관이 없는 일반 컬럼은 사용할 수 없다.
    tbl_menu.category_code,
    count(*),
    sum(menu_price),
    avg(menu_price),
    max(menu_price),
    min(menu_price)
from tbl_menu
group by category_code;

-- select에 count(*)이 없을떄는 category_code에서 중복되는 값 제외하고 존재하는 카테코리 코드값들 출력
-- count

select
    tbl_menu.category_code
from tbl_menu;

-- 2개 이상의 컬럼 기준으로 그룹을 지정 가능
-- 2개의 컬럼값을 가지고 그루핑을 진행한다. (이때 칼럼 순서는 상관없다)
-- 21행 -> 21그룹
select
    category_code,
    menu_price,
    count(*)
from
    tbl_menu
group by
    category_code,
    menu_price
order by 1,2;

-- n개의 컬럼 대상으로 distinct한 것처럼 그룹핑이 일어난다. -> distinct를 사용하면 ~
select distinct
    category_code,
    menu_price
from
    tbl_menu

order by 1,2;

-- -------------------
-- HAVING
-- -------------------
-- group by로 정해진 그룹에 대해 조건절을 작성한다.
-- 그룹함수를 사용한 조건은 having절에서만 작성할 수 있다. -> 그룹핑된 컬럼들에 대한 조건
-- group by 없이 HAVING 단독으로 사용불가. => group by의 옵션이라고 생각하자

-- 카테고리 별로 그룹을 나누었을 때 메뉴 개수가 1개보다 많은 그룹을 조회
select
    category_code,
    count(*) cnt_by_category
from
    tbl_menu
group by
    category_code
having
    count(*) >1
order by
    cnt_by_category desc;

# with rollup
-- group by 절의 추가적인 소계를 제공하는 기능 ->

-- 카테고리별 개수 조회
select
    category_code,
    count(*)
from tbl_menu
group by category_code with rollup;
-- group by 전 모든 행을 하나의 그룹으로 봤을때 count(*)를 추가로 제공

-- 카테고리 , 가격으로 그룹 조회
-- with roll up : group by category행 추가, 모든 행 한그룹으로 행 추가
-- with roll up은 group by에 대해 단방향 소계(앞선 컬럼기준)을 제공한다.
-- -> category_code에 대한 소계가 주어진다라는 말과 비슷함.
-- with roll up을 사용시에는 group by의 컬럼 작성순서가 중요하다.
-- -> category_code를 먼저 썼을때는 category_code의 단방향 소계가 추가되고 , menu_price를 먼저 썼을 때는 menu_price의 단방향 소계가 추가된다.

select
    category_code,
    menu_price,

    count(*)
from tbl_menu
group by category_code,
         menu_price with rollup;

# grouping 함수
-- 실제 데이터와 집계데이터(with rollup)를 구분해주는 함수
-- 실제 데이터는 0을 반환
-- 집계 데이터는 1을 반환
select
    if(grouping(category_code) = 0, category_code,''), -- 삼항연산자를 통해서 집계데이터면 빈문자를 찍어주는 if문
#    grouping(category_code),
    count(*)
from tbl_menu
group by category_code with rollup;