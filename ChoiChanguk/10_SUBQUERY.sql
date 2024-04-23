-- ========================================
-- SUBQUERY
-- ========================================
# 하나의 SQL문(메인쿼리) 안에 포함된 또 하나의 SQL문을 서브쿼리라 한다
# 존재하지 않는 값에 근거해서 쿼리를 작성해야 하는 경우 유용하다
# 메인쿼리 수행중에 서브쿼리를 만나면, 서브쿼리 우선실행하고 그 결과를 메인쿼리에 반환합니다
# 1. 일반 서브쿼리
#     단일행 서브쿼리
#     다중행 서브쿼리
# 2. 상관 서브쿼리
#     스칼라 서브쿼리
# 3. 인라인뷰(파생테이블)
# 4. 인라인뷰 (파생테이블) : FROM 절에 사용한 서브쿼리

# 규칙
# 서브쿼리는 반드시 소괄호로 묶어야 한다.
# 서브쿼리내에서 order by지원하지 않는다
# 서브쿼리의 실행결과(행/컬럼) 수에 따라 사용해야 하는 연산자가 다르다

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

-- ------------------------------------------
-- 상관 서브쿼리
-- ------------------------------------------
-- 상호연관 서브쿼리
-- 메인쿼비 값을 서브쿼리에 전달해서, 수행후에 그 결과를 다시 메인쿼리로 반환하는 방식
-- 메인쿼리의 레코드에 따라 수행할 서브쿼리가 달리진다
-- 상관서브쿼리만 단독으로 블럭잡아서 실행할 수 없다

#구분
-- 일반서브쿼리 : 단독으로 블럭잡아 실행 가능
-- 상관서브쿼리 : 단독으로 블럭잡아 실행 불가

-- 카테고리별로 가격이 가장 비싼 메뉴 조회
-- 1. 조인으로 해결하기
select category_code as 카테고리,count(category_code) as 수량, max(menu_price) as 비싼물품
from tbl_menu
group by category_code;


-- inner join (category_code가 null인 그룹 제외)
select *
from tbl_menu m
         left join (
         select category_code as 카테고리,
                count(category_code) as 수량,
                max(menu_price) as 비싼물품
               from tbl_menu
               group by category_code
               ) c
              on m.category_code = c.카테고리
where m.menu_price = c.비싼물품;


-- outer join (category_code가 null인 그룹도 포함)

select m.*
from tbl_menu m
         left join (select
                        category_code        as 카테고리,
                        count(category_code) as 수량,
                        max(menu_price)      as 비싼물품
                    from tbl_menu
                    group by category_code
                    ) c
                   on ifnull(m.category_code,0) = ifnull(c.카테고리,0)
#                   null과 null은 비교가 안되기 때문에 ifnull같은걸로 비교를 해준다
where m.menu_price = c.비싼물품;

-- 2. 상관서브쿼리로 해결하기
select *
from
    tbl_menu a
where menu_price = (
    /*
    for(int i=0;i<tbl_menu.category_code;i++)
        {
            if(menu_price= select(max(menu_price))
                if(category_code=a.category_code)
    }
    */
    /*카테고리별 최고 비싼 금액*/
# 지금 for(tbl menu a)문안에
    # if where( if where) 이렇게 쓴 느낌이다
    # 그러니깐 바깥쪽에 있는 카테고리 번호를를 안쪽에 있는 where안에 넣어서 나온 값을 기준으로 max값을 반환하고
    # 그 카테고리 번호의 가격과 반환된 max값을 비교한다
    select max(menu_price)
    from tbl_menu
    where category_code=a.category_code);

-- 메인 쿼리 where절에서 매행마다 다음 쿼리를 수행한다. 이 행의 category가 전달된다

-- 카테고리별 가격>평균가격의 메뉴 조회
-- 메인쿼리 테이블 별칭이 반드시 필요하다

select category_code as 카테고리,menu_name as 메뉴이름,menu_price as 가격
from tbl_menu as main
where menu_price>=(
    select avg(menu_price) as 평균가격
        from tbl_menu a
        where category_code = main.category_code
    );

# exists 연산자
-- exists (서브쿼리) 서브쿼리 조회딘 행이 존재하면 true, 존재하지 않으면 false

-- 메뉴가 있는 카테고리 조회
select a.category_code
from tbl_category a
# if와 같은 느낌이다
where exists(select * from tbl_menu b where category_code=a.category_code);

use empdb;
-- department 테이블에서 실제 부서원이 존재하는 부서만 조회
select *
from department d
where exists(select *
             from employee
             where DEPT_CODE = d.DEPT_ID);

# 유령 부서 출력
# 지금 여기서는 안에 값이
# 부정이면, true     긍정이면, false
# select * 에서 *을 1로 바꿔도 된다
select *
from department d
where !exists(select 1
             from employee
             where DEPT_CODE = d.DEPT_ID);

select 1
from department;

select *
from employee;
use menudb;
-- not exists를 이용한 최대/최소 행 구하기
-- 가격이 가장 비싼 메뉴 조회
select *
from tbl_menu m
where not exists(
    select 1
    from tbl_menu
    where menu_price > m.menu_price
);

# 스칼라 서브쿼리
-- 스칼라결과가 하나(스칼라)인 상관서브쿼리. 주로 select절에서 사용한다.
-- 메인 select에서 딱 하나의 행만 나온다
-- 메뉴명, 카테고리명 조회
select menu_name, (select category_name from tbl_category where category_code=m.category_code) as category
from tbl_menu m;

-- 카테고리 테이블에서 카테고리명, 상위카테고리명 조회
select category_name as 카테고리명,
       (select category_name from tbl_category where category_code =main.ref_category_code ) as 상위카테고리
from tbl_category main;

-- -------------------------------------
-- 인라인 뷰
-- -------------------------------------
-- from절에 사용한 서브쿼리를 가리킨다
-- 마치 하나의 테이블인 것처럼 사용할 수 있다.

# 뷰 구분
-- 1. 인라인 뷰 : 1회용 서브쿼리
-- 2. 저장 뷰 : db객체중에 하나로, 뷰를 테이블처럼 재사용 가능


select ifnull(t.상위카테고리,'상위카테고리없음') as 별칭쓴경우
# 인라인뷰에서 카테고리 별칭을 쓴 경우, 별칭으로 써야 한다
from # 이걸 테이블로 인식을 한다
(select category_name                                                                      as 카테고리명,
        (
        select
             category_name
         from
             tbl_category
         where
             category_code = c.ref_category_code
         )as  상위카테고리
 from tbl_category c
 ) t;

-- 메뉴테이블에서 카테고리별로 메뉴개수를 집계했을 때, 최대/최소 값을 조회해 보자
select max(t.카운트), min(t.카운트)
from (
    select count(*) 카운트
           from tbl_menu
           group by category_code
     ) as t;

#common table expression
-- 인라인뷰를 이름을 지정하고, 이를 참조하는 방식

#as이후부터 이름을 붙힌다 = 즉 c언어서 구조체같은 느낌이다
with menu
as (
    select *
    from tbl_menu
    )
select *
from menu;

with abcd
         as (
        select count(*) 카운트
        from tbl_menu
        group by category_code
    )
select max(카운트),min(카운트)
from abcd;