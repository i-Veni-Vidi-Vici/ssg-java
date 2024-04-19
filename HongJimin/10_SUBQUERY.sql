-- ---------------------------------------
-- SUB-QUERY
-- ---------------------------------------
-- 하나의 SQL문(메인쿼리) 안에 포함된 또 하나의 SQL문(서브쿼리)
-- 존재하지 않는 값에 근거해 쿼리를 작성해야 하는 경우 유용함
-- 메인 쿼리 수행 중에 서브 쿼리를 만나면, 서브 쿼리 우선 실행하고 그 결과를 메인 쿼리에 반환하는 구조

-- ⛳유형
    -- 일반 서브 쿼리
        -- 단일행 서브 쿼리
        -- 다중행 서브 쿼리
    -- 상관 서브 쿼리
        -- 스칼라 서브쿼리
    -- 인라인뷰(파생 테이블) : from절에 사용한 서브 쿼리

-- ⛳규칙
    -- 서브 쿼리는 반드시 소괄호를 묶어야 함
    -- 서브 쿼리 내에서는 order by를 지원하지 않음
    -- 서브쿼리의 실행 결과 (행/컬럼) 수에 따라 사용 해야 하는 연산자가 다름

-- ---------------------------------------
-- 일반 SUB-QUERY
-- ---------------------------------------
# 단일행 서브 쿼리
-- 열무김치라떼 메뉴의 카테고리명 조회
  -- 1. tbl_menu에서 열무김치라떼의 행을 찾고, category_code조회
  -- 2. tbl_category에서 특정행을 찾고, category_name조회

select
    category_code -- 8
from tbl_menu
where
    menu_name = '열무김치라떼';

select
    category_name -- 커피
from
    tbl_category
where
    category_code = 8;

-- 서브 쿼리로 작성
select
    category_name -- 커피
from
    tbl_category
where
    category_code = (
        select
            category_code -- 8
        from tbl_menu
        where
            menu_name = '열무김치라떼'
        );


-- 민트미역국과 같은 카테고리의 메뉴 조회
-- 1. 민트미역국의 카테고리 코드 조회 (서브쿼리)
-- 2. 카테고리코드가 1번과 동일한 메뉴 조회 (메인쿼리)
select
    *
from
    tbl_menu
where
    category_code = (
        select
            category_code -- 4
        from
            tbl_menu
        where
            menu_name = '민트미역국'
    )
  and menu_name != '민트미역국';

# 다중행 서브쿼리
-- 서브쿼리의 실행결과가 여러행인 경우

-- 식사류 카테고리가 1번일 때, 모든 식사류 메뉴를 조회
-- 1. 식사류 1번의 하위 카테고리를 조회(서브쿼리)
-- 2. 카테고리가 1번과 동일한 메뉴 조회(메인쿼리)

-- ⛳Subquery returns more than 1 row : 서브쿼리가 여러 행을 반환해서 생기는 오류
select  *
from tbl_menu
where
    category_code in ( -- ⛳괄호 안의 부분이 서브 쿼리에 해당!
        select
            category_code
        from
            tbl_category
        where
            ref_category_code = 1
    );

select  *
from tbl_menu
where
    category_code in ( -- ⛳괄호 안의 부분이 다중행 서브 쿼리
        select
            category_code
        from
            tbl_category
        where
            ref_category_code = ( -- ⛳여기 괄호는 단일행 서브쿼리
                select
                    category_code
                from
                    tbl_category
                where
                    category_name='식사')
    );
