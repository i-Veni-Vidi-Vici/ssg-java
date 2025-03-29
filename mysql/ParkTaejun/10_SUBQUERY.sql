


-- --------------------------------------------
-- 상관 서브쿼리
-- --------------------------------------------
-- 상호연관 서브쿼리.
-- 메인쿼리의 값을 서비쿼리에 전달해서 수행 후에 그 결과를 다시 메인쿼리로 반환하는 방식
-- 메인쿼리의 레코드에 따라 수행 할 서브쿼리가 달라진다.
-- 상관서브쿼리만 단독으로 블럭잡아 실핼할 수 없다.

# 구분
-- 일반서브쿼리 : 단독으로 블럭잡아 실행 가능
-- 상관서브쿼리 : 단독으로 블럭잡아 실행 불가능

-- 카테고리별로 가격이 가장 비싼 메뉴 조회
-- 1. 조인으로 해결

select
    category_code, -- 숫자는 묶였다는걸 의미함
    max(menu_price)
from
    tbl_menu
group by
    category_code;
-- inner join (category_code가 null인 그룹은 제외됨)
select *
from
    tbl_menu m join (select
                         category_code, -- 숫자는 묶였다는걸 의미함
                         max(menu_price) max_menu_price
                     from
                         tbl_menu
                     group by
                         category_code) c
        on m.category_code = c.category_code
    where
        m.menu_price = c.max_menu_price
    order by
        m.category_code;

-- outer join (category_code가 null인 그룹도 포함)

select
    *
from
    tbl_menu m left join (
                    select
                         category_code, -- 숫자는 묶였다는걸 의미함
                         max(menu_price) max_menu_price
                     from
                         tbl_menu
                     group by
                         category_code
                     ) c
                    -- null끼리 동일비교할 수 없으므로, ifnull함수를 이용해서 특정 값으로 변환 후 비교
                    on ifnull(m.category_code, 0) = ifnull(c.category_code,0)
where
    m.menu_price = c.max_menu_price
order by
    m.category_code;

-- 2. 상관서브쿼리로 해결하기
select
    *
from
    tbl_menu m
where
#     menu_price = (카테고리별 최고 비싼금액) -- where절은 한행 한행 where조건을 검사하는 것임
    menu_price = (
    select
        max(menu_price)
    from
        tbl_menu
    where category_code = m.category_code)
    };


select
    *
from
    tbl_menu m
where
    menu_price = (
        select
            max(menu_price)
        from
            tbl_menu
        where category_code = m.category_code
        );
-- 메인 쿼리 where절에서 매행마다 다음 쿼리를 수행한다. 이 행의 category가 전달된다.
select
    max(tbl_menu.menu_price)
    from
        tbl_menu

where
    category_code =11; -- 우항에 메인쿼리 레코드의 category_code가 대입

-- 카테고리별 평균가격볻바 높은 가격 메뉴 조회
-- 메인쿼리 테이블 별칭이 반드시 필요하다.
select *
from
    tbl_menu m -- 별칭 사용
where
#     menu_price > (같은 카테고리의 평균가격);
        menu_price >= (
                select
                    avg(menu_price)
                from
                    tbl_menu
                where
                    category_code = m.category_code
            );
# exists 연산자
-- exists (서브쿼리) 서브쿼리의 조회된 행이 존재하면 true를 반환, 존재하지 않으면 false 반환

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
        tbl_menu.category_code = c.category_code); -- exists 는 존재하면 true를 반환함 -- 0 행이면 false를 반환함


select
    *
from
    tbl_menu
where
    tbl_menu.category_code;

select
    *
from tbl_category;

use empdb;
-- department 실제 부서원이 존재하는 부서만 조회
select
    *
from department d
where
    exists(
        select
            *
        from
            employee
        where
            DEPT_CODE = d.DEPT_ID
    );
-- 부서원이 존재하지 않는 부서를 찾는 것
-- not exists (서브쿼리) 서브쿼리 행이 존재하지 않으면 참!
select
    *
from department d
where
    not exists(
        select
            *
        from
            employee
        where
            DEPT_CODE = d.DEPT_ID
    );
-- not exists를 이용한 최대/최소 행 구하기
-- 가격이 가장 비싼 메뉴 조회
use menudb;

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
-- 실행결과가 하나(스칼라)인 상관서브쿼리, 주로 select절에서 사용한다.

-- 메뉴명, 카테고리명 조회
select
    menu_name,
    (select  category_name from tbl_category where category_code = m.category_code) category_name
from
    tbl_menu m;

-- 카테고리 테이블에서 카테고리명, 상위카테고리명 조회
-- 조인하지 않더라도 원하는 값을 찾아낼 수 있음
select
    category_name,
    (select category_name from tbl_category where category_code = c.ref_category_code) ref_category
from
    tbl_category c;

-- ----------------------------------------
-- 인라인 뷰
-- ----------------------------------------
-- from절에 사용한 서브쿼리를 가리킨다.
-- 마치 하나의 테이블인 것처럼 사용할 수 있다.

# 뷰 구분
-- 1. 인라인 뷰 : 1회용 서브쿼리
-- 2. 저장 뷰 : db 객체 중의 하나로, 뷰를 테이블인 것처럼 재사용 할 수 있다.

-- 인라인 뷰에 있는 것만 사용이 가능함.
select
    카테고리명, -- 인라인뷰에서 별칭을 사용한 경우 별칭으로 다시 참조해야 한다.
    ref_category_name

from (
select category_name 카테고리명,
        (select category_name from tbl_category where category_code = c.ref_category_code) ref_category_name
 from tbl_category c
) t;

-- 메뉴테이블에서 카테고리별로 메뉴개수를 집계했을 때 최대/최소값을 조회

select 
    category_name 카테고리명,
    (
select category_name from tbl_category where category_code
 = main.ref_category_code ) as 상위카테고리
from tbl_category main;


select
    tbl_category.category_code
from tbl_category;

select *
from tbl_category
where category_code;

select * from tbl_category where category_code;


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

-- 인라인뷰에 이름을 지정하고, 이를 참조하는 방식, 인라인뷰를 가상의 테이블로 보기로 했는데 그냥 그 이름만 참조한 것임
with menu
    as (
        select
            *
        from
            tbl_menu
    )
select
    *
from
    menu;


with cnt_by category
as (
    select
    category_code,
     count (*) cnt
    from
    tbl_menu
    group by
    category_code
    )
select
    max(cnt),
    min(cnt)
from
    cnt_by_category