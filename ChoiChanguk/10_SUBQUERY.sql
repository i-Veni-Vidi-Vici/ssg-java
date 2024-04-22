-- ========================================
-- SUBQUERY
-- ========================================
-- 하나의 SQL문(메인붜리) 안에 포함된 또 하나의 SQL문을 서브쿼리라 한다
-- 존재하지 않는 값에 근거해서 쿼리를 작성해야 하는 경우 유용하다
-- 메인쿼리 수행중에 서브쿼리를 만나면, 서브쿼리 우선실행하고 그 결과를 메인쿼리에 반환합니다
-- 1. 일반 서브쿼리
    -- 단일행 서브쿼리
    -- 다중행 서브쿼리
-- 2. 상관 서브쿼리
    -- 스칼라 서브쿼리
-- 3. 인라인뷰(파생테이블)
-- 3. 인라인뷰 (파생테이블) : FROM 절에 사용한 서브쿼리

# 규칙
-- 서브쿼리는 반드시 소괄호로 묶어야 한다.
-- 서브쿼리내에서 order by지원하지 않는다
-- 서브쿼리의 실행결과(행/컬럼) 수에 따라 사용해야 하는 연산자가 다르다

-- ---------------------------------------
-- 일반 서브쿼리
-- ---------------------------------------
# 단일행 서브쿼리
-- 열무김치라떼 메뉴의 카테고리명 조회
-- 1. tbl_menu에서 열무길치라뗴의 행을 찾고, category_code 조회
-- 2. tbl_category에서 특정행을 찾고, category_name조회

select category_code
from tbl_menu
where menu_name='열무김치라떼';

select category_name
from tbl_category
where category_code=8;

-- 서브쿼리로 작성

select category_name
from tbl_category
where category_code=(
    select category_name
    from tbl_category
    where category_code=8
    );

# 단일행 서브쿼리
-- 민트미역국과 같은 카테고리의 메뉴 조회
-- 1. 민트미역국의 카테고리 코드 조회(서브쿼리)
-- 2. 카테고리코드가 1번과 동일한 메뉴 조회(메인쿼리)
select menu_name, category_code
from tbl_menu
where category_code= (
    select category_code
    from tbl_menu
    where menu_name = '민트미역국'
    );


# 다중행 서브쿼리
-- 서브쿼리의 실행결과가 여러행인 경우
-- 식사류 카테고리가 1번일 때, 모든 식사류 메뉴를 출력하세요
-- 1. 식사류 1번의 하위 카테고리를 조회한다
-- 2. 카테고리가 1번과 동일한 메뉴 조회 (메인 쿼리)

# [21000][1242] Subquery returns more than 1 row
select *
from tbl_menu
where category_code in (
    select category_code
    from tbl_category
    where ref_category_code=1
    );

select *
from tbl_menu;

select *
from tbl_category