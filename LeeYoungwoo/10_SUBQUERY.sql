-- =================================
-- SUB-QUERY
-- =================================
-- 하나의 SQL문(메인쿼리) 안에 포함된 또 하나의 SQL문(서브쿼리)
-- 존재하지 않는 값에 근거해서 쿼리를 작성해야 하는 경우 유용하다.
-- 메인쿼리 수행중에 서브쿼리를 만나면, 서브쿼리를 우선실행하고 그 결과를 메인쿼리에 반환하는 구조

# 유형
-- 1. 일반 서브쿼리
    -- 단일행 서브쿼리
    -- 다중행 서브쿼리
-- 2. 상관 서브쿼리
    -- 스칼라 서브쿼리
-- 3. 인라인뷰 (파생테이블) : from절에 사용한 서브쿼리

# 규칙
-- 서브쿼리는 반드시 소괄호로 묶어야 한다.
-- 서브쿼리내에서는 order by 지원하지 않는다.
-- 서브쿼리의 실행결과(행/컬럼) 수에 따라 사용해야하는 연산자가 다르다.

-- ------------------------------------
-- 일반 서브쿼리
-- ------------------------------------
# 단일행 서브쿼리
-- 열무김치라떼 메뉴의 카테고리명을 조회
-- 1. tbl_menu에서 열무김치라떼의 행을 찾고, category_code를 조회 (서브쿼리)
-- 2. tbl_category에서 특정행을 찾고, category_name을 조회 (메인쿼리)

select category_code -- 8
from tbl_menu
where menu_name = '열무김치라떼';

select category_name
from tbl_category
where category_code = 8;

-- 서브쿼리로 작성
select category_name
from tbl_category
where category_code = (select category_code -- 8
                       from tbl_menu
                       where menu_name = '열무김치라떼'); -- 8번이라는 값만 알면 한번에 구할 수 있으므로 () 자리에 위의 쿼리를 넣음

-- 민트미역국과 같은 카테고리의 메뉴 조회
select category_code
from tbl_menu
where menu_name = '민트미역국';

select *
from tbl_menu
where category_code = (select category_code
                       from tbl_menu
                       where menu_name = '민트미역국') and menu_name != '민트미역국';

# 다중행 서브쿼리
-- 서브쿼리의 실행결과가 여러행인 경우

-- 식사류 카테고리가 1번일 때, 모든 식사류 메뉴를 조회
-- 1. 식사류 1번의 하위 카테고리를 조회(서브)
-- 2. 카테고리가 1번과 동일한 메뉴 조회(메인)

-- [21000][1242] Subquery returns more than 1 row : 서브쿼리가 여러행을 반환해서 생기는 오류
select *
from tbl_menu
where category_code in (select category_code
                       from tbl_category
                       where ref_category_code = 1); -- 다중행 서브쿼리 이므로 '=' 말고 'in' 사용해야됨

-- ---------------------------------------
-- 상관 서브쿼리
-- ---------------------------------------
-- 상호연관 서브쿼리.
-- 메인쿼리의 값을 서브쿼리에 전달해서 수행후에 그 결과를 다시 메인쿼리로 반환하는 방식
-- 메인쿼리의 레코드에 따라 수행할 서브쿼리가 달라진다.
-- 상관서브쿼리만 단독으로 블럭잡아 실행할 수 없다.

# 구분
-- 일반서브쿼리 : 단독으로 블럭잡아 실행 가능
-- 상관서브쿼리 : 단독으로 블럭잡아 실행 불가

-- 카테고리별로 가격이 가장 비싼 메뉴 조회
-- 1. 조인으로 해결하기
select category_code,
       max(menu_price)
from tbl_menu
group by category_code;

-- inner join (category_code가 null인 그룹 제외)
select m.*
from tbl_menu m join (
    select category_code,
           max(menu_price) max_menu_price
    from tbl_menu
    group by category_code
    ) c
    on m.category_code = c.category_code
where m.menu_price = c.max_menu_price;

-- outer join (category_code가 null인 그룹도 포함)
select m.*
from tbl_menu m left join (
    select category_code,
           max(menu_price) max_menu_price
    from tbl_menu
    group by category_code
    ) c
    -- null끼리 동일비교X -> ifnull함수 이용해서 null을 특정 값으로 변환 후 비교
     on ifnull(m.category_code, 0) = ifnull(c.category_code, 0)
where m.menu_price = c.max_menu_price;

-- 2. 상관서브쿼리로 해결하기
select *
from tbl_menu m
where
    # menu_price = (카테고리별 최고 비싼금액);
    menu_price = (select max(menu_price)
                    from tbl_menu
                    where category_code = m.category_code);

-- 메인쿼리 where절에서 매항마다 다음 쿼리를 수행한다. 이 행의 category가 전달된다.
select max(menu_price)
from tbl_menu
where category_code = 11; -- 우항에 메인쿼리 레코드의 category_code가 대입된다.

-- 카테고리별 평균가격보다 높은 가격의 메뉴 조회
-- 메인쿼리 테이블 별칭이 반드시 필요하다.
select m.*
from tbl_menu m
where menu_price > (select avg(menu_price)
                    from tbl_menu
                    where category_code = m.category_code);

# exists 연산자
-- exists (서브쿼리) : 서브쿼리의 조회된 행이 존재하면 true, 존재하지 않으면 false

-- 메뉴가 있는 카테고리 조회
select *
from tbl_category c
where exists(select *
             from tbl_menu
             where category_code = c.category_code);

use empdb;
-- department 테이블에서 실제 부서원이 존재하는 부서만 조회
select *
from department d
where exists(select *
             from employee
             where DEPT_CODE = d.DEPT_ID);

-- department 테이블에서 실제 부서원이 존재하지 않는 부서만 조회
select *
from department d
where not exists(select 1 -- 값이 있기만 하면 되기 때문에(true) * 안쓰고 아무거나 써도 상관없음
             from employee
             where DEPT_CODE = d.DEPT_ID);

-- not exists를 이용한 최대/최소 행 구하기
-- 가격이 가장 비싼 메뉴 조회
use menudb;
select *
from tbl_menu m
where not exists(select 1
                 from tbl_menu
                 where menu_price > m.menu_price);

# 스칼라 서브쿼리
-- 실행결과가 하나(스칼라)인 상관서브쿼리. 주로 select절에서 사용한다.

-- 메뉴명, 카테고리명 조회
select menu_name,
       (select category_name from tbl_category where category_code= m.category_code) category_name
from tbl_menu m;

-- 카테고리 테이블에서 카테고리명, 상위 카테고리명 조회
select *
from tbl_category;
select category_name,
       (select category_name from tbl_category where category_code = c.ref_category_code) ref_category_code
from tbl_category c;

-- ---------------------------------------
-- 인라인 뷰
-- ---------------------------------------
-- from절에 사용한 서브쿼리를 말한다.
-- 마치 하나의 테이블인것처럼 사용할 수 있다.

# 뷰 구분
-- 1. 인라인 뷰 : 1회용 서브쿼리
-- 2. 저장 뷰 : db객체중의 하나로, 뷰를 테이블처럼 재사용 가능
select
#     category_code -- [42S22][1054] Unknown column 'category_code' in 'field list'
    카테고리명,
    ref_category_name
from (select category_name 카테고리명,
             (select category_name from tbl_category where category_code = c.ref_category_code) ref_category_name
      from tbl_category c) t;

-- 메뉴테이블에서 카테고리별 메뉴개수를 집계했을 때 최대/최소값 조회
select max(갯수),
       min(갯수)
from (select category_code,
             count(*) 갯수
      from tbl_menu
      group by category_code) t;

# common table expression
-- 인라인뷰에 이름을 지정하고, 이를 참조하는 방식

with menu
    as (
        select *
        from tbl_menu
    )
select *
from menu;

with cnt_by_category
    as (select category_code,
                count(*) 갯수
         from tbl_menu
         group by category_code)
select max(갯수),
       min(갯수)
from cnt_by_category;