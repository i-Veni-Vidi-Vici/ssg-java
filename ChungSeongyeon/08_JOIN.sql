-- ================================
-- JOIN
-- ================================
-- 두개이상의 테이블 레코드를 연결해서 Relation(가상테이블)을 생성할 수 있다.
-- 두 테이블의 특정컬럼 기준으로 행과 행을 연결한다.

# 가상테이블 relation을 만드는 방법
-- 1. join : 레코드와 레코드를 가로로 연결
-- 2. union(union all) : 레코드와 레코드를 세로로 연결

# JOIN 구분
-- 1. EQUI JOIN (등가조인) 조인조건에 = 동일비교 연산자를 사용한 경우
-- 2. NON-EQUI JOIN (비등가조인) 조인조건에 = 동일비교 연산자를 사용하지 않은 경우 (>, <, >=, <=, between, like, in)

# EQUI JOIN 구분
-- 1. INNER JOIN (내부조인) - 기준컬럼에 부합하는 행들만 조인한 경우
-- 2. OUTER JOIN (외부조인)
--      - LEFT OUTER JOIN - 왼쪽테이블 전체와 오른쪽테이블에서는 기준컬럼에 부합하는 행들만 조인한 경우
--      - RIGHT OUTER JOIN - 오른쪽테이블 전체와 왼쪽테이블에서는 기준컬럼에 부합하는 행들만 조인한 경우
-- 3. CROSS JOIN
-- 4. SELF JOIN (자가조인)
-- 5. MULTIPLE JOIN (다중조인)

# 조인 문법
-- from 좌측테이블 join 우측테이블 on 좌측테이블.컬럼 = 우측테이블.컬럼
-- from 좌측테이블 a join 우측테이블 b on a.컬럼 = b.컬럼 (테이블 별칭 사용)

# 조인 맛보기
-- 한우딸기국밥의 카테고리명 조회
-- 1. 한우딸기국밥의 tbl_menu.category_code 조회
-- 2. 1번의 결과를 가지고 tbl_category.category_name 조회
select
    category_code -- 4
from
    tbl_menu
where
    menu_name = '한우딸기국밥';

select
    category_name -- 한식
from
    tbl_category
where
    category_code = 4;

-- 만약 이 데이터들이 한 테이블에 있었다면?
select
    b.category_name -- 테이블 별칭을 생략가능하나 되도록 작성한다.
from
    tbl_menu a join tbl_category b
        on a.category_code = b.category_code -- 테이블 별칭 생략 불가
where
    a.menu_name = '한우딸기국밥';

select * from tbl_menu;
select * from tbl_category;

-- 테이블 별칭
-- 테이블 as "별칭" -> as "" 생략이 가능
-- 조인테이블에서 컬럼명이 같은 경우 반드시 테이블별칭으로 컬럼을 참조해야 한다. ([23000][1052] Column 'category_code' in on clause is ambiguous)
select
    m.menu_name,
    m.menu_price,
    m.category_code
from
    tbl_menu as m;

-- --------------------------------
-- INNER JOIN
-- --------------------------------
-- 좌우테이블에서 조인조건에 부합하는 행들만 연결해서 relation 생성
-- **기준컬럼이 null이거나, 상대테이블에 매칭되는 행이 없다면, relation에서 제외된다.**
-- inner 키워드는 생략이 가능하다.

-- 메뉴/카테고리정보를 모두 조회 (카테고리 없는 메뉴 제외, 메뉴 없는 카테고리 제외)
select
    count(*) -- 21행
from
    tbl_menu a inner join tbl_category b
        on a.category_code = b.category_code;

-- tbl_menu(22행)에서 category_code가 null인 22번 찰순대쥬스행이 제외되었다. -> 21행 사용됨.
-- tbl_category(12행)에서 tbl_menu.category_code에서 사용되지 않은 4행 (1, 2, 3, 7)이 제외되었다. -> 8행 사용됨.

# using (컬럼)
-- 조인테이블의 기준컬럼명이 동일한 경우 사용가능하다.
select
    a.menu_code,
    a.menu_name,
    a.menu_price,
    category_code, -- 별칭없이 동일한 이름의 컬럼을 참조
    b.category_name
from
    tbl_menu a inner join tbl_category b
        using (category_code);
#         on a.category_code = b.category_code;

-- --------------------------------
-- OUTER JOIN
-- --------------------------------
-- 외부조인. 좌/우측 테이블을 기준으로 조인.
-- 기준이 된 테이블은 누락되는 행이 없다.
-- 기준이 된 테이블의 모든행과 상대테이블에서 조인조건에 부합되는 행이 사용된다.

# LEFT OUTER JOIN
-- 왼쪽 테이블 기준으로 조인
-- tbl_menu.category_code가 null인 찰순대쥬스행이 추가되었다.
-- tbl_category.category_code가 상대테이블 tbl_menu에서 사용되지 않은 4행은 제외되었다.

-- 메뉴 조회 (카테고리 없는 메뉴도 포함)
select
    *
from
    tbl_menu m left outer join tbl_category c
        on m.category_code = c.category_code;
#         using (category_code); -- 22행 (21행 + 1행(찰순대쥬스))

# RIGHT OUTER JOIN
-- 오른쪽 테이블 기준으로 조인
-- tbl_category.category_code가 상대테이블 tbl_menu에서 사용되지 않아 제외됐던 4행이 추가되었다.
-- tbl_menu.category_code가 null인 찰순대쥬스행은 제외되었다.

-- 카테고리를 조회 (연결된 메뉴가 없는 카테고리도 포함)
select
    *
from
    tbl_menu m right outer join tbl_category c
        on m.category_code = c.category_code; -- 25행 (21행 + 4행(식사,음료,디저트,퓨전))

# 조인 결과 정리
-- tbl_menu(22행), tbl_category(12행)
-- inner join 21행 : tbl_menu 21행(category_code가 null인 행 제외) + tbl_category 8행(상대테이블에 매칭되는 행이 없는 행 제외)
-- left outer join 22행 : tbl_menu 22행(*) + tbl_category 8행(상대테이블에 매칭되는 행이 없는 행 제외)
-- right outer join 25행 : tbl_menu 21행(category_code가 null인 행 제외) + tbl_category 12행(*)

-- 두테이블의 inner join 결과를 확인(제외되는 행 확인)
-- 문맥에 따라 외부조인을 활용

-- left, right은 작성된 위치 기준이다.
select
    *
from
    tbl_category c left join tbl_menu m
        on c.category_code = m.category_code;

-- empdb에서 내부/외부조인 확인
use empdb;
-- 사원정보(employee)와 부서정보(department)
select * from employee; -- 24행 employee.dept_code
select * from department; -- 9행 department.dept_id

-- 내부조인 (22행)
-- employee (22행) - dept_code가 null사원 2명 제외
-- department (6행) - dept_id를 employee.dept_code에서 사용하지 않은 3행 제외 (D3, D4, D7)
-- 사원조회 (부서 지정안된 사원은 제외, 사원부서도 제외)
select
    *
from
    employee e join department d
        on e.dept_code = d.dept_id; -- 22행

-- 좌측외부조인 (24행) : 22행 + 2행 (dept_code가 null행 추가)
-- 사원조회(부서 지정안된 사원도 포함)
select
    *
from
    employee e left join department d
        on e.dept_code = d.dept_id;

-- 우측외부조인 (25행) : 22행 + 3행 (employee에 dept_id와 매칭되는 행이 없던 3행 추가)
-- 부서조회(유령부서도 포함)
select
    *
from
    employee e right join department d
        on e.dept_code = d.dept_id;

-- 사원이 존재하는 부서만 조회
select distinct
    d.dept_id,
    d.dept_title
from
    employee e join department d
        on e.dept_code = d.dept_id;


-- --------------------------------
-- CROSS JOIN
-- --------------------------------
-- 좌우측 테이블에서 행과 행이 만나는 모든 경우의 수를 적용한 조인
-- 조인조건절을 작성하지 않는다.
-- relation행의 수는 좌측테이블행수 * 우측테이블행수와 같다.
-- 크로스 조인을 적용할 맥락은 거의 없다.
-- cross 키워드, on조건절을 생략하면, 내부조인이 아닌 크로스조인으로 처리된다.

use menudb;

-- 264행 : 22행 * 12행
select
    *
from
    tbl_menu m cross join tbl_category c;

-- --------------------------------
-- SELF JOIN
-- --------------------------------
-- 자가조인, 같은 테이블 좌우측에 두고 다른 테이블인양 조인.
-- 같은 테이블안에서 다른 레코드를 참조하고 있을때 자가조인 할수 있다.

select * from tbl_category;

-- 카테고리 조회 (상위 > 하위)
-- SELF 내부조인
-- 카테고리 조회(상위카테고리 없거나, 하위카테고리나 없으면 제외)
select
    -- concat(c1.category_name, ' > ', c2.category_name)
    *
from
    tbl_category c1 join tbl_category c2
        on c1.category_code = c2.ref_category_code; -- c1 상위카테고리 - c2 하위카테고리

-- SELF 왼쪽 외부조인
-- 카테고리 조회(상위카테고리는 모두 조회)
select
    *
from
    tbl_category c1 left join tbl_category c2
        on c1.category_code = c2.ref_category_code; -- 18행 (9행 + 9행)

-- SELF 오른쪽 외부조인
-- 카테고리 조회(하위카테고리는 모두 조회)
select
    *
from
    tbl_category c1 right join tbl_category c2
        on c1.category_code = c2.ref_category_code; -- 12행 (9행 + 3행)

-- 사원테이블에서 사원-매니저 조회
use empdb;
select * from employee;

-- 사번 사원명 매니저사번 매니저명 조회
-- 내부조인 (manager_id가 null인 행)
-- 1. e테이블에서 manager_id가 null인 행이 제외
-- 2. m테이블에서는 m.emp_id가 상응하는 e.manager_id가 없는 경우 제외(관리하는 부하직원이 없는 경우)
select e.EMP_ID 사번,
       e.EMP_NAME 사원명,
#        e.MANAGER_ID,
       m.EMP_ID 매니저사번,
       m.EMP_NAME 매니저명
from employee e join employee m
    on e.MANAGER_ID = m.EMP_ID; -- 16행

-- 좌측외부조인
-- 사원-매니저 조회 (매니저 없는 사원도 조회)
select e.EMP_ID 사번,
       e.EMP_NAME 사원명,
       m.EMP_ID 매니저사번,
       m.EMP_NAME 매니저명
from employee e left join employee m
    on e.MANAGER_ID = m.EMP_ID; -- 24행(16 + 8)

-- 우측외부조인
-- 사원-매니저 조회 (관리하는 직원이 없는 매니저도 조회)
select m.EMP_ID 매니저사번,
       m.EMP_NAME 매니저명,
       e.EMP_ID 사번,
       e.EMP_NAME 사원명
from employee e right join employee m
    on e.MANAGER_ID = m.EMP_ID; -- 33행(16 + 17)

-- ---------------------------
-- MULTIPLE JOIN
-- ---------------------------
-- 다중조인. 여러 테이블을 조인해 relation을 생성.
-- 한번에 두개씩 연달아 조인 처리

-- 사원-부서-지역
select * from employee;
select * from department;
select * from location;

-- 다중내부조인
-- 사원-부서-지역조회(부서지정 안된 사원)
select *
from employee e
    join department d
        on e.DEPT_CODE = d.DEPT_ID
    join location l
        on d.LOCATION_ID = l.LOCAL_CODE;

-- 사원-부서-지역조회(부서지정 안된 사원 포함)
select *
from employee e
         left join department d
              on e.DEPT_CODE = d.DEPT_ID
         left join location l
              on d.LOCATION_ID = l.LOCAL_CODE;
-- left join 다음 join 한번 더 할 때 그냥 join말고 left join를 연달아 써줘야 하동운, 이오리 가 null인 값들을 가진 채 보여짐.

 