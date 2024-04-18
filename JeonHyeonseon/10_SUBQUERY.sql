-- ==================================
-- SUB-QUERY
-- ==================================
-- 하나의 SQL문(메인쿼리) 안에 포함된 또 하나의 SQL문(서브쿼리)
-- 존재하지 않는 값에 근거해서 쿼리를 작성해야 하는 경우 유용하다.
-- 메인쿼리 수행중에 서브쿼리를 만나면, 서브쿼리를 우선실행하고 그 결과를 메인쿼릴에 반환하는 구조

# 유형
-- 1. 일반 서브쿼리
    -- 단일행 서브쿼리
    -- 다중행 서브쿼리
-- 2. 상관 서브쿼리
    -- 스칼라 서브쿼리
-- 3. 인라인뷰 (파생테이블) : from절에 사용한 서브쿼리

# 규칙
-- 서브쿼리는 반드시 소괄호를 묶어야 한다.
-- 서브쿼리 내에서는 order by를 지원하지 않는다.
-- 서브쿼리의 실행결과(행/컬럼) 수에 따라 사용해야 하는 연산자가 다르다. -> 값이 하나인 경우 =, 값이 여러개인 경우 in 사용

-- ---------------------------------
-- 일반 서브쿼리
-- ---------------------------------
# 단일행 서브쿼리
-- 서브쿼리의 실행결과가 1행인 경우

-- 열무김치라떼 메뉴의 카테고리명 조회
-- 1. tbl_menu에서 열무김치라떼의 행을 찾고, category_code 조회 (서브쿼리)
-- 2. tbl_category에서 특정행을 찾고, category_name 조회 (메인쿼리)
select
    category_code -- 8
from
    tbl_menu
where
    menu_name = '열무김치라떼';

select
    category_name -- 커피
from
    tbl_category
where
    category_code = 8;

-- 값이 하나인 경우, = 사용(서브쿼리의 실행결과(행/컬럼) 수에 따라 사용해야 하는 연산자가 다르다.)
-- 서브쿼리로 작성
select
    category_name -- 커피
from
    tbl_category
where
    category_code = (
        select
            category_code -- 8
        from
            tbl_menu
        where
            menu_name = '열무김치라떼'
    );

-- 민트미역국과 같은 카테고리의 메뉴 조회
-- 1. 민트미역국의 카테고리 코드 조회 -> tbl_menu에서 민트미역국의 행을 찾고, category_code 조회(서브쿼리)
-- 2. 카테고리코드가 1번과 동일한 메뉴 조회 -> tbl_category에서 특정행을 찾고, category_name 조회(메인쿼리)
select
    category_code -- 4
from
    tbl_menu
where
    menu_name = '민트미역국';

-- 카테고리코드가 4인 행만 나옴
select
    *
from
    tbl_menu
where
    category_code = 4;

-- 결과
select
    *
from
    tbl_menu
where
    category_code = (
        select
            category_code
        from
            tbl_menu
        where
            menu_name = '민트미역국'
    )
    and menu_name != '민트미역국';

# 다중행 서브쿼리
-- 서브쿼리의 실행결과가 여러행인 경우
-- in 사용(서브쿼리의 실행결과(행/컬럼) 수에 따라 사용해야 하는 연산자가 다르다.)

-- 식사률 카테고리가 1번일때, 모든 식사류 메뉴를 조회
-- 1. 식사류 1번의 하위 카테고리를 조회 (서브쿼리)
-- 2. 카테고리가 1번과 동일한 메뉴 조회 (메인쿼리)

-- [21000][1242] Subquery returns more than 1 row 서브쿼리가 여러행을 반환해서 생긴 오류
select
    category_code
from
    tbl_category
where
    ref_category_code = 1;

select
    *
from
    tbl_menu
where
    category_code in (
#         4, 5, 6, 7
        select
            category_code
        from
            tbl_category
        where
            ref_category_code = (
                select
                    category_code
                from
                    tbl_category
                where
                    category_name='식사'
            )
        );