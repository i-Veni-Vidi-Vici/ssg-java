/*
table entity relation(table의 확장된 형태)
DBMS RDBMS RelationalDBMS
===================================================================
JOIN
===================================================================
- 두개 이상의 테이블 레코드를 연결해서 Relation을 생성할 수 있다
- 두 테이블의 특정컬럼 기준으로 행과 행을 연결한다

- 가상테이블 relation을 만드는 방법
- 1. join : 레코드와 레코드를 가로로 연결
- 2. union(union all) : 레코드와 레코드를 세로로 연결

*/

# JOIN 구분
-- 1. EQUI JOIN(등가조인) 조인조건에 = 동일비교 연산자를 사용한 경우
-- 2. NON-EQUI JOIN(비등가조인) 조인조건에 = 동일비교 연산자를 사용하지 않은 경우 (>, <, >=, <=, between, like, in)

# EQUI JOIN (내부조인)
-- 1. INNER JOIN (내부조인) - 기준컬럼에 부합하는 행등만 조인한 경우 
-- 2. OUTER JOIN (외부조인)
#   - LEFT OUTER JOIN - 왼쪽테이블 전체와 오른쪽테이블에서는 기준 컬럼에 부합하는 행들만 조인한 경우
#   - RIGHT OUTER JOIN - 오른쪽테이블 전체와 왼쪽테이블에서는 기준 컬럼에 부합하는 행들만 조인한 경우
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
where menu_name = '한우딸기국밥';

select category_name
from tbl_category
where category_code = 4;

-- 만약 이 데이터들이 한 테이블에 있었다면?
select
#     *,
    category_name -- 테이블 별칭 생략 가능하나 되도록 작성한다.
from
    tbl_menu a join tbl_category b
on
    a.category_code = b.category_code -- 테이블 별칭 생략 불가
where menu_name = '한우딸기국밥';

-- table alias
-- table as "alias" -> as "" 생략 가능
-- 조인 테이블에서 컬럼명이 같은 경우 반드시 테이블별칭으로 컬럼을 참조해야 한다.
select
    m.menu_name,
    m.menu_price,
    m.category_code
from
    tbl_menu as m;

/*
-------------------------------------------------------------------
INNER JOIN
-------------------------------------------------------------------
- 좌우테이블에서 조인조건에 부합하는 행들만 연결해서 relation 생성
- 기준컬럼이 null이거나, 상대테이블에 매칭되는 행이 없다면, relation에서 제외된다.**
- inner 키워드는 생략이 가능하다.
*/

select
    count(*) -- 21행
from tbl_menu a inner join tbl_category b
    on a.category_code = b.category_code;

-- tbl_menu(22행)에서 category_code가 null인 22번 찰순대쥬스행이 제외되었다. 21행 사용됨
-- tbl_category(12행)에서 tbl_menu.category_code에서 사용되지 않은 4행 (1, 2, 3, 7)이 제외되었다. -> 7행 사용됨

# using (컬럼)
-- 조인테이블의 기준 컬럼명이 동일한 경우 사용 가능하다.
select
    a.menu_code,
    a.menu_name,
    a.menu_price,
    category_code, -- 별칭없이 동일한 이름의 컬럼 참조
    b.category_name
from tbl_menu a inner join tbl_category b
    using (category_code);

/*
-------------------------------------------------------------------
OUTER JOIN
-------------------------------------------------------------------
- 외부조인, 좌/우측 테이블을 기준으로 조인
- 기준이 된 테이블은 누락되는 행이 없다
- 기준이 된 테이블의 모든 행과 상대 테이블에서 조인 조건에 부합되는 행이 사용된다
*/

# LEFT OUTER JOIN
-- 왼쪽 테이블 기준으로 조인
-- tbl_menu.category_code가 상대테이블 tbl_menu에서 사용되지 않은 4행이 제외되었다.
-- tbl_menu.category_code가 null인 찰순대쥬스행이 추가되었다.

-- 메뉴 조회 (카테고리 없는 메뉴도 포함)
select *
from tbl_menu m left outer join tbl_category c
# on m.category_code = c.category_code;
using (category_code); -- 22행 ( 21행 + 1행(찰순대쥬스))

# RIGHT OUTER JOIN
-- 오른쪽 테이블 기준으로 조인
-- tbl_menu.category_code가 상대테이블 tbl_menu에서 사용되지 않아 제외됐던 4행이 추가되었다.
-- tbl_menu.category_code가 null인 찰순대쥬스행이 제외되었다.

-- 카테고리를 조회 (연결된 메뉴가 없는 카테고리도 포함)
select *
from tbl_menu m right join tbl_category c
    on m.category_code = c.category_code; -- 25행 ( 21행 + 4행(식사,음료,디저트,퓨전)

# 조인 결과 정리
-- tbl_menu(22행), tbl_category(12행)
-- inner join 21행 : tbl_menu 21행(category_code가 null인 행 제외) + tbl_category 8행(상대 테이블에 매칭되는 행이 없는 행 제외)
-- left outer join 22행 : tbl_menu 22행(*) + tbl_category 8행(상대테이블에 매칭되는 행이 없는 행 제거)
-- right outer join 25행 : tbl_menu 21행(categoroy_code가 null인 행 제외) + tbl_category 12행(*)

-- 두 테이블의 innne 결과를 확인(제외되는 행 확인)
-- 문맥에 따라 외부조인을 활용

-- left, right은 작성된 위치 기준이다.
select *
from tbl_category c left join tbl_menu m
on c.category_code = m.category_code;

select *
from tbl_menu m left join tbl_category c
on c.category_code = m.category_code;

-- empdb에서 내부/외부조인 확인
use empdb;
-- 사원정보(employee)와 부서정보(department)
select * from employee; -- DEPT_CODE 2개 NULL
select * from department;
-- 내부조인 (22행)
select *
from employee e join department d
on e.DEPT_CODE = d.DEPT_ID; -- NULL 없음

-- 좌측외부조인 (24행)
select *
from employee e left join department d -- d가 e 기준으로 합쳐진다 null 2개
on e.DEPT_CODE = d.DEPT_ID;

select *
from department d right join employee e -- d가 e 기준으로 합쳐진다 null 2개
on e.DEPT_CODE = d.DEPT_ID;

-- 우측외부조인 (25행)
select *
from employee e right join department d -- e에는 없는 D3! e가 d 기준으로 합쳐진다 null 3개
on e.DEPT_CODE = d.DEPT_ID;

select *
from department d left join employee e -- e에는 없는 D3! e가 d 기준으로 합쳐진다 null 3개
on e.DEPT_CODE = d.DEPT_ID;

-- 사원이 존재하는 부서만 조회
select distinct
    d.DEPT_ID,
    d.DEPT_TITLE
from employee e join department d
on e.DEPT_CODE = d.DEPT_ID;

/*
-------------------------------------------------------------------
CROSS JOIN
-------------------------------------------------------------------
- 좌우측 테이블에서 행과 행이 만나는 모든 경우의 수를 적용한 조인
- 조인조건절을 작성하지 않는다.
- relation행의 수는 좌측테이블행수 * 우측테이블행수와 같다
- 크로스 조인을 적용할 맥락은 거의 없다 ...
- cross 키워드, on 조건절을 생략하면, 내부조인이 아닌 크로스조인으로 처리된다
*/

use menudb;

select *
from tbl_menu m cross join tbl_category c; -- 22 * 12 = 264 rows

select *
from tbl_menu m join tbl_category c;

/*
-------------------------------------------------------------------
SELF JOIN
-------------------------------------------------------------------
- 자가조인, 같은 테이블 좌우측에 두고 다른 테이블인 양 조인
- 같은 테이블 안에서 다른 레코드를 참조하고 있을 때 자가조인 할 수 있다.
*/

select * from tbl_category;

-- 카테고리 조회 (상위 - 하위)
-- SELF 내부조인
-- 카테고리 조회 (상위카테고리 없거나, 하위카테고리가 없으면 제외)
select
    -- concat(c1.category_code, c2.ref_category_code)
    *
from tbl_category c1 join tbl_category c2
    on c1.category_code = c2.ref_category_code; -- c1 상위카테고리 - c2 하위카테고리

-- SELF 왼쪽 외부조인
select * -- 18 rows
from tbl_category c1 left join tbl_category c2
on c1.category_code = c2.ref_category_code;

-- SELF 오른쪽 외부조인
-- 카테고리 조회(하위카테고리는 모두 조회)
select * -- 12 rows
from tbl_category c1 right join tbl_category c2
on c1.category_code = c2.ref_category_code;

-- 사원테이블에서 사원-매니저 조회
use empdb;
select *
from empdb.employee;

-- 사번 사원명 매니져사번 매니져명 조회
-- 내부조인 16 rows
select e1.EMP_ID 사번, e1.EMP_NAME 사원명, e1.MANAGER_ID 매니져사번, e2.EMP_NAME 매니져명
from employee e1 join employee e2
on e1.MANAGER_ID = e2.EMP_ID;
-- 외부조인 24 rows 사원기준
select e1.EMP_ID 사번, e1.EMP_NAME 사원명, e1.MANAGER_ID 매니져사번, e2.EMP_NAME 매니져명
from employee e1 left join employee e2
on e1.MANAGER_ID = e2.EMP_ID;
-- 외부조인 33 rows 매니저기준
select e2.EMP_ID 매니져사번, e2.EMP_NAME 매니져명, e1.EMP_ID 사번, e1.EMP_NAME 사원명
from employee e1 right join employee e2
on e1.MANAGER_ID = e2.EMP_ID;

/*
-------------------------------------------------------------------
MULTIPLE JOIN
-------------------------------------------------------------------
- 다중조인. 여러테이블을 조인해 relation을 생성
- 한번에 두개씩 연달아 조인 처리

- 사원 - 부서 - 지역
*/
select * from employee;
select * from department;
select * from location;

-- 다중내부조인
-- 사원-부서-지역조회 (부서지정안된 사원 제외)
select *
from
    employee e join department d
        on e.DEPT_CODE = d.DEPT_ID
    join location l
        on d.LOCATION_ID = l.LOCAL_CODE
where
    l.LOCAL_NAME = 'EU';

-- 사원-부서-지역조회 (부서지정안된 사원 포함)
select *
from
    employee e left join department d
                         on e.DEPT_CODE = d.DEPT_ID
               left join location l
                         on d.LOCATION_ID = l.LOCAL_CODE;