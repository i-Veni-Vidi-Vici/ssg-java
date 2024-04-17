-- --------------------
-- GROUP BY
-- --------------------
-- DQL에서 특정컬럼 값에 근거해 행을 그룹핑하는 구문
-- 1개이상의 컬럼 또는 가상컬럼이 기준이 될 수 있다.

-- 카테고리별 메뉴 집계
select
    category_code,
    menu_price,
    count(*)
from tbl_menu
group by
    category_code,
    menu_price
order by
    1,2;

-- -----------
-- Having
-- -----------
-- group by로 정해진 그룹에 대해 조건절을 작성.
-- 그룹함수를 사용한 조건은 having 절에서만 작성할 수 있다.
-- group by 없이 having 단독으로는 사용불가능하다.
-- 카테고리별로 그룹을 나누었을때 메뉴개수가 1개보다 많은 그룹을 조회
select
    category_code,
    count(*)
from tbl_menu
group by
    category_code
having
    count(*)>1
order by
    count(*) desc;

# with rollup
-- group by 절의 추가적인 소계를 제공하는 기능

select
    category_code,
    count(*)
    from tbl_menu
group by
    category_code with rollup;
-- group by전 모든 행을 하나로 봣을때 count(*)를 추가로 제공.


#grouping 함수
-- 실제 데이터와 집계데이터(with rollup)를 구분해주는 함수
-- 실제데이터는 0을 반환
-- 집계데이터는 1을 반환
select
    category_code,
    count(*)
    from tbl_menu
group by
    category_code with rollup ;