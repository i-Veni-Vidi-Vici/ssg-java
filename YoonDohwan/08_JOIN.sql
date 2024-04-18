-- =============
-- JOIN
-- =============
-- 두개이상의 테이블 레코드를 연결해서 Relation을 생성할 수 있다.
-- 두 테이블의 특정컬럼 기준으로 행과 행을 연결한다.


-- 가상테이블 relation을 만드는 방법
-- 1.join : 레코드와 레코드를 가로로 연결
-- 2.union(union all): 레콛드와 레코드를 세로로 연결

#JOIN 구분
-- 1.EQUI JOIN(등가조인) 조인조건에 = 동일비교 연산자를 사용한 경우
-- 2.NON-EQUI JOIN(비등가조인)=동일비교 연산자를 사용하지않은 경우

#EQUI JOIN 구분
-- 1.INNER JOIN(내부조인) - 기준컬럼에 부합하는 행들만 조인한 경우
-- 2.OUTER JOIN(외부조인)
-- -left outer join - 왼쪽테이블 전체와 우측테이블에서는 기준컬럼에 부합하는 행들만 조인한 경우
-- -right outer join

-- 3.cross join
-- 4.self join(자가조인)
-- 5.multiple join(다중조인)

#조인문법
-- from 좌측테이블 join 우측테이블 on 좌측테이블.컬럼 = 우측테이블.컬럼(테이블 별칭 사용)


# 조인맛보기
-- 한우딸기국바의 카테고리명조회
-- 1. 한우 딸기국밥의 tbl_menu.category_code 조회
-- 1번의 결과를 가지고 tbl_category.category_name 조회
select
    category_code
from tbl_menu
where menu_name = '한우딸기국밥';

select
    category_name
from tbl_category
where category_code=4;

-- 만약 이 데이터들이 한 테이블에 있었다면?
select
    *
from tbl_menu join tbl_category
 on tbl_menu.category_code = tbl_category.category_code
where
    menu_name='한우딸기국밥';

select * from tbl_menu;
select * from tbl_category;


-- 테이블 별칭
-- 테이블as"별칭" -> as "" 생량이 가능
-- 조인테이블에서 컬럼명이 같은 경우 반드시 테이블별칭으로 컬럼을 참조해야 한다.
select
    m.menu_name,
    m.menu_price,
    m.category_code
from
    tbl_menu m;

-- -------------
-- INNER JOIN
-- -------------
-- 좌우테이블에서 조인조건에 부합하는 행들만 연결해서 relation 생성
-- 기준컬럼이 null이거나, 상대테이블에 매칭되는 행이 없다면, relation에서 제외된다.
-- inner 키워드는 생략이 가능하다.

select
    count(*)
from tbl_menu a inner join tbl_category b
on a.category_code=b.category_code;

-- tbl_menu(22행)에서 category_code가 null인 22번 찰순대쥬스행이 제외되었다.

# USING
select
    a.menu_code,
    a.menu_name,
    a.menu_price,
    category_code,
    b.category_name
from tbl_menu a inner join tbl_category b
using (category_code);


-- -------------------
-- OUTER JOIN
-- -------------------
-- 외부조인. 좌/우측 테이블을 기준으로 조인.
-- 기준이 된 테이블은 누락되는 행이 없다.
-- 기준이 된 테이블의 모든행과 상데테이블에서 조인조건에 부합되는 행이 사용된다.

#LEFT OUTER JOIN
-- 왼쪽 테이블 기준으로 조인
-- tbl_menu.category_code가 null인 찰순대 쥬스행이 추가되었다.

select *
from tbl_menu m left outer join  tbl_category c
    #on m.category_code = c.category_code
    using(category_code);



#RIGHT OUTER JOIN
-- 오른쪽 테이블 기준으로 조인
-- tbl_category.category_code가 상대테이블 tbl_menu에서 사용되지 않아 제외됐던 4행이 추가되었다.
select *
from tbl_menu m right outer join tbl_category c on m.category_code=c.category_code;
# 조인 결과 정리
-- tbl_menu(22행), tbl_category(12행)
-- inner join 21행 : tbl_menu21행(category_code가 null인 행 제외)+tbl_category 8행(상대테이블에 매칭되는 행이 없는 행 제외)
-- left outer join 22행 : tbl_menu 22행(*) + tbl_category 8행(상대테이블에 매칭되는 행이 없는 행 제외)
-- right outer join 25행 : tbl_menu 21행 + tbl_category 12행(*)

-- 두테이블의 inner join 결과를 확인(제외되는 행 확인)
-- 문맥에 따라 외부조인을 활용
-- left,right은 작성된 위치 기준이다.





-- empdb에서 내부/외부조인 확인
use empdb;
-- 사원정보와 부서정보
select * from employee;
select * from department;

-- 내부조인(?행)
select
    *
from employee e join department d
on e.dept_code = d.dept_id;

-- 좌측외부조인
select
    *
from employee e left join department d
                     on e.dept_code = d.dept_id;

-- 우측외부조인
select
    *
from employee e right join department d
                          on e.dept_code = d.dept_id;

-- 사원이 존재하는 부서만 조회
select  distinct
    d.dept_id,
    d.dept_title
from employee e join department d on e.dept_code = d.dept_id;


-- ------------
-- cross join
-- ------------
-- 좌우측 테이블에서 행과행이 만나는 모든 경우의 수를 적용한 조인
-- 조인조건절을 작성하지 않는다.
-- relation행의 수는 좌측테이블행수*우측테이블행수와 같다.

use menudb;


select*
from tbl_menu m cross join tbl_category c;


-- -----------
-- self join
-- -----------
-- 자가 조인,같은 테이블 좌우측에 두고 다른테이블 인양 조인.
-- 같은 테이블안에서 다른 레코드를 참조하고 있을때 자가조인 할수 있다.

select * from tbl_category;

-- 카테고리 조회(상위-하위)
select *
from tbl_category c1 join tbl_category c2
on c1.category_code=c2.ref_category_code; -- c1상위카테고리 -c2하위카테고리

-- self 오른쪽 외부조인
-- 카테고리 조회(하위카테고리는 모두 조회)
select
    *
from
    tbl_category c1 right join tbl_category c2
on c1.category_code = c2.ref_category_code;

-- 사원테이블에서 사원-매니져 조회
use empdb;

select * from employee;
