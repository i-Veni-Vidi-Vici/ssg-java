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

-- ---------------------------------------
-- 상관 서브쿼리
-- ---------------------------------------
-- 상호연관 서브쿼리
-- 메인쿼리의 값을 서브쿼리에 전달해서 수행 후에 그 결과를 다시 메인 쿼리로 반환하는 방식
-- 메인쿼리의 레코드에 따라 수행할 서브쿼리가 달라짐
-- 상관서브쿼리만 단독으로 블럭잡아 실행할 수 없다.

# 구분
    -- 일반 서브쿼리 : 단독으로 블럭잡아 실행 가능
    -- 상관 서브쿼리 : 단독으로 블럭잡아 실행 불가

-- 카테고리 별로 가격이 가장 비싼 메뉴 조회
-- 1. 조인으로 해결하기
select
    category_code,
    max(menu_price)
from tbl_menu
group by
    category_code;

-- inner join (category_code가 null인 그룹 제외)
select *
from tbl_menu m join (
    select
        category_code,
        max(menu_price) max_menu_price
    from tbl_menu
    group by
        category_code
    ) c
    on m.category_code = c.category_code
where m.menu_price = c.max_menu_price
order by
    m.category_code;

-- outer join(category_code가 null인 그룹도 포함)
select *
from tbl_menu m left join (
    select
        category_code,
        max(menu_price) max_menu_price
    from tbl_menu
    group by
        category_code
    ) c
        -- null끼리는 동일비교가 없으므로, ifnull함수를 이용해 특정 값으로 변환후 비교
        on ifnull(m.category_code,0) = ifnull(c.category_code, 0)
where m.menu_price = c.max_menu_price
order by
    m.category_code;

-- 2. 상관서브쿼리로 해결하기
select
    *
from
    tbl_menu m
where
#     menu_price = (카테고리별 최고 비싼금액);
menu_price = (
    select
        max(menu_price)
    from
        tbl_menu
    where
        category_code = m.category_code
);

-- 메인 쿼리 where절에서 매행마다 다음 쿼리를 수행한다. 이 행의 category가 전달된다.
select
    max(menu_price)
from
    tbl_menu
where
    category_code = 11; -- 우항에 메인쿼리 레코드의 category_code가 대입

-- 카테고리별 평균가격보다 높은 가격의 메뉴 조회
-- 메인쿼리 테이블 별칭이 반드시 필요하다
select
    menu_name
from tbl_menu m
where
#     menu_price  > (같은 카테고리의 평균 가격)
    menu_price >= (select
                      avg(menu_price)
                  from
                      tbl_menu c
                  where
                      category_code = m.category_code
                  );

# exists 연산자
-- exists (서브쿼리) : 서브쿼리의 조회된 행이 존재하면 true, 존재하지 않으면 false

-- 메뉴가 있는 카테고리 조회
select
    *
from
    tbl_category c
where
    exists(
        select
            *
        from
            tbl_menu
        where
            category_code = c.category_code
        ); -- 행이 true이면 반환

-- department 테이블에서 실제 부서원이 존재하는 부서만 조회
select
    DEPT_TITLE
from
    department D
where
    exists(
        select
            *
        from employee
        where
            DEPT_CODE = D.DEPT_ID
    );

-- department 테이블에서 유령 부서만 조회
-- exists(서브쿼리) 서브쿼리 행이 존재하면 참!
-- not exists(서브쿼리) 서브쿼리 행이 존재하지 않으면 참!
select
    DEPT_TITLE
from
    department D
where
    !exists(
        select
            *
        from employee
        where
            DEPT_CODE = D.DEPT_ID
    );
select * from employee;

-- not exists를 이용한 최대/최소 행 구하기
-- 가격이 가장 비싼 메뉴 조회
select
    *
from
    tbl_menu m
where
    not exists(
        select
            1
        from
            tbl_menu
        where
            menu_price > m.menu_price
    );

# 스칼라 서브쿼리
-- 실행결과가 하나(스칼라)인 상관 서브쿼리 . 주로 select절에서 사용

-- 메뉴명, 카테고리명 조회
select
    menu_name,
    (select category_name from tbl_category where category_code =m.category_code) category_name
from tbl_menu m;

-- 카테고리테이블에서 카테고리명, 상위 카테고리명 조회
select * from tbl_category c;
select
    category_name,
    (select category_name from tbl_category where category_code= c.ref_category_code)
from tbl_category c;

-- -----------------------------------
-- 인라인 뷰
-- -----------------------------------
-- from절에 사용한 서브쿼리를 가리킨다.
-- 마치 하나의 테이블인 것처럼 사용할 수 있다.

# 뷰 구분
-- 1. 인라인 뷰 : 1회용 서브쿼리
-- 2. 저장 뷰 : db객체중의 하나로, 뷰를 테이블처럼 재사용 가능
select
    -- category_code, -- [42S22][1054] Unknown column 'category_code' in 'field list'
    -- category_name, -- 인라인 뷰에서 별칭을 사용한 경우 별칭으로 참조해야 함
    카테고리명,
    ref_category_name
from (
         select
             category_name 카테고리명,
             (select category_name from tbl_category where category_code = c.ref_category_code) ref_category_name
         from
             tbl_category c
     ) t;

select
    menu_code, menu_name, price
from (
    select menu_code, menu_name, menu_price price from tbl_menu
     ) t;

-- 메뉴테이블에서 카테고리별 메뉴 개수를 집계했을 때 최대/최소값 조회
select
    max(cnt),
    min(cnt)
from (
    select
        category_code,
        count(*) cnt
    from
        tbl_menu
    group by
        category_code
     ) t;

# common table expression
-- 인라인 뷰에 이름을 지정하고, 이를 참조하는 방식

with menu -- ⛳테이블 이름 지정
as (
    select
        *
    from
        tbl_menu
    )
select
    *
from menu;

with cnt_by_category
as ( select
         category_code,
         count(*) cnt
     from
         tbl_menu
     group by
         category_code
)
select
    max(cnt),
    min(cnt)
from
    cnt_by_category;