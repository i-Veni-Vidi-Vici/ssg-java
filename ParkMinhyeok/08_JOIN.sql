-- ========================================
-- JOIN
-- ========================================
-- 두개이상의 테이블 레코드를 연결해서 Relation(가상테이블)을 생성할 수 있다.
-- 두 테이블의 특정 컬럼 기준으로 행과 행을 연결한다.

#  가상테이블 relation 을 만드는 방법
-- 1. join : 레코드와 레코드를 가로로 연결
-- 2. union(union all) : 레코드와 레코드를 세로로 연결

# JOIN 구분
-- 1. EQUI JOiN (등가조인) 조인 조건에 = 동일비교 연산자를 사용한 경우
-- 2. NON-EQUI JOiN (비등가조인) 조인 조건에 = 동일비교 연산자를 사용하지 않은 경우(>, <, >=, <=, between, like)

# EQUI JOIN 구분
-- 1. INNER JOIN (내부조인) - 기준 컬럼에 부합하는 행들만 조인한 경우
-- 2. OUTER JOIN (외부조인)
--      - LEFT OUTER JOIN - 왼쪽테이블 전체와 오른쪽테이블에서는 기준컬럼에 부합하는 행들만 조인한 경우
--      - RIGHT OUTER JOIN - 오른쪽테이블 전체와 왼쪽테이블에서는 기준컬럼에 부합하는 행들만 조인한 경우
-- 3. CROSS JOIN
-- 4. SELF JOIN (자가조인)
-- 3. MULTIPLE JOIN (다중조인)

# 조인 문법
-- from 좌측테이블 join 우측테이블 on 좌측테이블.컬럼 = 우측테이블.컬럼
-- from 좌측테이블 a join 우측테이블 b on a.컬럼 = b.컬럼 (별칭)

# 조인 맛보기
-- 한우딸기국밥의 카테고리명 조회
-- 1. 한우딸기국밥의 tbl_menu.category_code 조회
-- 2. 1번의 결과를 가지고 tbl_category.category_name 조회
select
    category_code -- 4
from
    tbl_menu
where menu_name = '한우딸기국밥';

select
    category_name -- 한식
from
    tbl_category
where category_code = 4;

-- 만약 이 데이터들이 한 테이블에 있었다면?
select
    category_name
from
    tbl_menu a join tbl_category b
        on a.category_code = b.category_code
where
    menu_name = '한우딸기국밥';

-- 테이블 별칭
select
    m.menu_name,
    m.menu_price,
    m.category_code
from
    tbl_menu as m;

-- -----------------------------------------
-- INNER JOIN
-- -----------------------------------------
-- 좌우테이블에서 조인조건에 부합하는 행들만 연결해서 relation 생성
-- **기준컬럼이 null 이거나, 상대테이블에 매칭되는 행이 없다면, relation 에서 제외된다.**
-- inner 키워드는 생략이 가능하다.

-- 메뉴/카테고리정보를 모두 조회 (카테고리 없는 메뉴 제외, 메뉴 없는 카테고리 제외)
select
    *
from
    tbl_menu a inner join tbl_category b
        on a.category_code = b.category_code;

-- tbl_menu(22행)에서 category_code 가 null 인 22번 찰순대쥬스행이 제외되었다. -> 21행 사용됨.
-- tbl_category(12행)에서 tbl_menu.category_code 에서 사용되지 않은 4행 (1, 2, 3, 7)이 제외되었다. -> 8행 사용됨.

# using (컬럼)
-- 조인테이블의 기준컬럼명이 동일한 경우 사용가능하다.
select
    *
from
    tbl_menu a inner join tbl_category b
        using (category_code);

-- -----------------------------------------
-- OUTER JOIN
-- -----------------------------------------
-- 외부조인. 좌/우측 테이블을 기준으로 조인.
-- 기준이 된 테이블은 누락되는 행이 없다.

# LEFT OUTER JOIN
-- 왼쪽 테이블 기준으로 조인
select
    *
from
    tbl_menu m left outer join tbl_category c
        on m.category_code = c.category_code;
#         using(category_code);

# RIGHT OUTER JOIN
-- 오른쪽 테이블 기준으로 조인
-- tbl_category.category_code 가 상대테이블 tbl_menu 에서 사용되지 않아 제외됐던 4행이 추가되었다.
-- tbl.menu.category_code 가 null 인 찰순대쥬스행은 제외되었다.
select
    *
from
    tbl_menu m right outer join tbl_category c
        on m.category_code = c.category_code;

-- empdb에서 내부/외부조인 확인
use empdb;
-- 사원정보(employee)와 부서정보(department)
select * from EMPLOYEE; -- 24행 employee.dept_code
select * from DEPARTMENT; -- 9행 department.dept_id

-- 내부조인 (22행)
-- employee (22행) - dept_code 가 null 사원 2명 제외
-- department (6행) - dept_id를 employee.dept_code 에서 사용하지 않은 3행 제외(D3, D4, D7)
select
    *
from
    EMPLOYEE e inner join DEPARTMENT d
        on e.DEPT_CODE = d.DEPT_ID; -- 22행

-- 좌측외부조인
select
    *
from
    EMPLOYEE e left outer join DEPARTMENT d
        on e.DEPT_CODE = d.DEPT_ID;

-- 우측외부조인
select
    *
from
    EMPLOYEE e right outer join DEPARTMENT d
        on e.DEPT_CODE = d.DEPT_ID;

-- 사원이 존재하는 부서만 조회
select distinct
    d.DEPT_ID,
    d.DEPT_TITLE
from
    EMPLOYEE e join DEPARTMENT d
        on e.DEPT_CODE = d.DEPT_ID;

-- -----------------------------------------
-- CROSS JOIN
-- -----------------------------------------
-- 좌우측 테이블에서 행과 행이 만나는 모든 경우의 수를 적용한 조인
-- 조인조건절 작성하지 않는다.
-- relation 행의 수는 좌측테이블행수 * 우측테이블행수와 같다.
-- 크로스 조인을 적용할 맥락은 거의 없다.
-- cross 키워드와 on 조건절을 생략하면, 내부조인이 아닌 크로스조인으로 처리된다

use menudb;

-- 264행 : 22행 * 12행
select
    *
from
    tbl_menu m cross join tbl_category c;

-- -----------------------------------------
-- SELF JOIN
-- -----------------------------------------
-- 자가조인, 같은 테이블 좌우측에 두고 다른 테이블인양 조인.
-- 같은 테이블안에서 다른 레코드를 참조하고 있을때 자가조인 할 수 있다.

select * from tbl_category;

-- 카테고리 조회 (상위 - 하위)
select
    concat(c1.category_name, ' > ', c2.category_name)
from
    tbl_category c1 join tbl_category c2
        on c1.category_code = c2.ref_category_code;

-- 사원테이블에서 사원-매니져 조회
use empdb;
select * from EMPLOYEE;

-- 사번 사원명 매니져사번 매니져명 조회
-- 내부조인
-- 1. e 테이블에서 manager_id가 null 인 행이 제외
-- 2. m 테이블에서 관리하는 사원이 null 인 행이 제외
select
    emp.EMP_ID 사번, emp.EMP_NAME 사원명,
    manager.EMP_ID 매니져사번, manager.EMP_NAME 매니져명
from
    EMPLOYEE emp join EMPLOYEE manager
        on emp.MANAGER_ID = manager.EMP_ID;

-- 좌측외부조인
-- 사원-조회 (매니져 없는 사원도 조회)
select
    emp.EMP_ID 사번, emp.EMP_NAME 사원명,
    manager.EMP_ID 매니져사번, manager.EMP_NAME 매니져명
from
    EMPLOYEE emp left join EMPLOYEE manager
      on emp.MANAGER_ID = manager.EMP_ID; -- 24행(16행 + 8행)

-- 우측외부조인
-- 매니져-사원 조회 (관리하는 직원이 없는 매니져도 조회)
select
    emp.EMP_ID 사번, emp.EMP_NAME 사원명,
    manager.EMP_ID 매니져사번, manager.EMP_NAME 매니져명
from
    EMPLOYEE emp right join EMPLOYEE manager
       on emp.MANAGER_ID = manager.EMP_ID; -- 33행(16행 + 17행)

-- -----------------------------------------
-- MULTIPLE JOIN
-- -----------------------------------------
-- 다중조인, 여러테이블을 조인해 relation 을 생성
-- 한번에 두개씩 연달아 조인 처리

-- 사원 - 부서 - 지역
select * from EMPLOYEE;
select * from DEPARTMENT;
select * from LOCATION;

select
    *
from
    EMPLOYEE e join DEPARTMENT d
        on e.DEPT_CODE = d.DEPT_ID
             join LOCATION l
                on d.LOCATION_ID = l.LOCAL_CODE;

-- 사원-부서-지역조회(부서지정 안 된 사원 포함)
select
    *
from
    EMPLOYEE e left join DEPARTMENT d
                    on e.DEPT_CODE = d.DEPT_ID
               left join LOCATION l
                    on d.LOCATION_ID = l.LOCAL_CODE;