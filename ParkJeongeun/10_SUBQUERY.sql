-- =====================
-- SUB-QUERY
-- =====================
-- 하나의 SQL문(메인쿼리) 안에 포함된 또 하나의 SQL문(서브쿼리)
-- 존재하지 않는 값에 근거해서 쿼리를 작성해야 하는 경우 유용
-- 메인쿼리 수행 중에 서브쿼리를 만나면, 서브쿼리를 우선 실행하고 그 결과를 메인쿼리에 반환

# 유형
-- 1. 일반 서브쿼리
    -- 단일행 서브쿼리
    -- 다중행 서브쿼리
-- 2. 상관 서브쿼리
    -- 스칼라 서브쿼리
-- 3. 인라인뷰 (파생테이블) : from절에 사용한 서브쿼리

# 규칙
-- 서브쿼리는 반드시 소괄호를 묶어야 함
-- 서브쿼리 내에서는 order by 지원하지 않음
-- 서브쿼리의 실행결과(행/컬럼) 수에 따라 사용해야하는 연산자 다름

-- ----------------------
-- 일반 서브쿼리
-- ----------------------
# 단일행 서브쿼리
-- 서브쿼리의 실행결과가 1행인 경우
-- where절에서 = 연산자 사용

-- 열무김치라떼 메뉴의 카테고리명 조회
-- 1. tbl_menu에서 열무김치라떼의 행 찾고, category_code 조회 (서브쿼리)
-- 2. tbl_categgory에서 특정 행 찾고, category_name 조회 (메인쿼리)

select category_code -- 8
from tbl_menu
where menu_name = '열무김치라떼';

select category_name -- 커피
from tbl_category
where category_code = 8;

-- 서브쿼리로 작성
select category_name
from tbl_category
where category_code = (select category_code
                       from tbl_menu
                       where menu_name = '열무김치라떼');

-- 민트미역국과 같은 카테고리의 메뉴 조회
select menu_name
from tbl_menu
where category_code = (select category_code
                       from tbl_menu
                       where menu_name = '민트미역국')
    and menu_name != '민트미역국';

# 다중행 서브쿼리
-- 서브쿼리의 실행결과가 여러 행인 경우
-- where절에서 in 연산자 사용

-- 식사류 카테고리가 1번일때, 모든 식사류 메뉴 조회
-- 1. 식사류 1번의 하위 카테고리 조회 (서브쿼리)
-- 2. 카테고리가 1번과 동일한 메뉴 조회 (메인쿼리)

select *
from tbl_menu
where category_code in (select category_code
                       from tbl_category
                       where ref_category_code = (select category_code
                                                  from tbl_category
                                                  where category_name = '식사'));