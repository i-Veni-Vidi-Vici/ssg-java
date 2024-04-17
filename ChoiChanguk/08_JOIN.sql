-- ===================================
-- JOIN
-- ===================================
-- 두 개이상의 테이블 레코드를 연결해서 Relation(가상 테이블)을 생성할 수 있다.
-- 두 테이블의 특정컬럼 기준으로 행과 행을 연결한다.

-- 가상테이블 ralation을 만드는 방법
-- 1. join : 레코드와 레코드를 가로로 연결
-- 2. union(union all) : 레코드와 레코드를 세로로 연결

# JOIN 구분
/*
1. EQUI JOIN (등가조인) 조인조건에 = 동일비교 연산자를 사용한 경우
2. NON-EQUI JOIN (비등가조인) 조인조건에 = 동일비교 연산자를 사용하지 않은 경우
    (>,<,>=,<=,BETWEEN ...)
*/

# 1. EQUI JOIN 구분
-- 1. INNER JOIN (내부조인) - 기준컬럼에 부합하는 행들만 조인한 경우
-- 2. OUTTER JOIN -
--      LEFT JOIN - 왼쪽테이블 전체 + 기준에 부합하는 오른쪽 행들
--      RIGHT JOIN - 오른쪽테이블 전체 + 기준에 부합하는 왼쪽 행들
-- 3. CROSS JOIN
-- 4. SELF JOIN (자가조인)
-- 5. MULTIPLE JOIN (다중조인)

# 조인 문법
-- from 좌측테이블 join 우측테이블 on 좌측테이블.컬럼 = 우측테이블.컬럼
-- from 좌측테이블 as a join 우측테이블 as b on a.컬럼 = b.컬럼 - 별칭을 사용

# 조인 맛보기
-- 한우딸기국밥의 카테고리명 조회
-- 1. tbl_menu.category_code
-- 2. tbl_category.category_name

select category_code
from tbl_menu
where menu_name = '한우딸기국밥';

select *
from tbl_menu;

select menu_name, b.category_code,a.menu_name-- 테이블 별칭을 생략해도 되지만 되도록 작성한다
from tbl_menu a join tbl_category b
                     on a.category_code = b.category_code -- 테이블 별칭 생략 불가
# on category_code = category_code -- 테이블 별칭 생략 불가
order by category_code;
select *
from tbl_category;

select *
from tbl_menu;

-- 테이블 별칭
-- 테이블 as "별칭" -> as "" 생략 가능
-- 조인테이블에서 컬럼명이 같은 경우 반드시 테이블별칭을 컬럼에 참조해야 한다

select m.menu_name,
       m.menu_price,
       m.category_code
from tbl_menu m;

-- ---------------------------------------------
-- INNER JOIN
-- ---------------------------------------------
-- 좌우테이블에서 조인조건에 부합하는 행들만 연결해서 relation 생성
-- 기준컬럼이 null이거나, 상대테이블에 매칭되는 행이 없다면, relation에서 제외된다
--  기준은 있으나 매칭되는게 없어서 표시되지 않는다
-- inner 키워드는 생략이 가능하다
select count(*)
from
    tbl_menu a inner join tbl_category b
on a.category_code = b.category_code;
-- tbl_menu(22행) 에서 category_code가 null인 22번 찰순대쥬스행이 제외되었다 -> 21행 사용됨

select *
from tbl_menu join tbl_category
    using (category_code); # 이경우 테이블 안에 컬럼명이 같아서 쓴다
# on tbl_menu.category_code = tbl_category.category_code;
;
-- ------------------------------------
-- OUTER JOIN
-- ------------------------------------
-- 외부조인, 좌/우측 테이블을 기준으로 조인.
-- 기준이 된 테이블은 누락되는 행이 없다
-- 기준이 된 테이블의 모든행과 상대테이블에서 조인조건에 부합되는 행이 사용된다

# on m.category_code = c.category_code

# LEFT OUTER JOIN
-- 왼쪽 테이블 기준
SELECT *
from tbl_menu m left join tbl_category c
using (category_code);


# RIGHT OUTER JOIN
-- 오른쪽 테이블 기준
select *
from
    tbl_menu m right outer join tbl_category c
 on m.category_code = c.category_code

-- empdb에서 내부/외부조인 확인
use empdb;

-- 사원정보(employee)와 부서정보(department)

-- 내부조인
select *
from employee e join department d
-- left

-- right