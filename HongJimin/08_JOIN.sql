-- ---------------------------------------
-- JOIN
-- ---------------------------------------
-- 두 개 이상의 테이블 레코드를 연결해서 Relation(가상 테이블)을 생성할 수 있음
-- 두 테이블의 특정 컬럼 기준으로 행과 행을 연결함
-- 가상 테이블 relation을 만드는 방법
    -- join : 레코드와 레코드를 가로로 연결
    -- union(union all) : 레코드와 레코드를 세로로 연결
-- JOIN 구분
    -- EQUI JOIN(등가조인) : 조인 조건에 = 동일 비교 연산자를 사용한 경우
    -- NON-EQUI JOIN(비등가조인) : 조인 조건에 = 동일 비교 연산자를 사용하지 않은 경우(>, <, >=, <=, between, like)

-- EQUI JOIN
   -- 1. INNER JOIN(내부 조인) - 기준 컬럼에 부합하는 행들만 조인한 경우
   -- 2. OUTER JOIN(외부 조인)
        -- LEFT OUTER JOIN - 왼쪽 테이블 전체와 왼쪽 테이블에서는 기준 컬럼에 부합하는 행들만 조인한 경우
        -- RIGHT OUTER JOIN - 오른쪽 테이블 전체와 오른쪽 테이블에서는 기준 컬럼에 부합하는 행들만 조인한 경우
   -- 3. CROSS JOIN
   -- 4. SELF JOIN(자가조인)
   -- 5. MULIPLE JOIN(다중조인)

# JOIN 문법
-- from 좌측테이블 join 우측 테이블 on 좌측테이블.컬럼 = 우측테이블.컬럼
-- from 좌측테이블  A join 우측 테이블 B on A.컬럼 = B.컬럼 → 테이블 별칭 사용

# JOIN 맛보기
    -- 한우딸기국밥의 카테고리명 조회
    -- 1. 한우 딸기 국밥의 tbl_menu.category_code 조회
    -- 2. 1번의 결과를 가지고 tbl_menu.category_name조회
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

-- 만약 이 데이터들이 한 테이블에 있었다면?!
select
    b.category_name -- ⛳테이블 별칭을 생략가능하지만, 되도록 작성하기!
from
    tbl_menu a join tbl_category b
        on a.category_code = b.category_code
where
    a.menu_name = '한우딸기국밥'; -- ⛳테이블 별칭을 생략가능하지만, 되도록 작성하기!

select
    *
from
    tbl_menu;

select
    *
from
    tbl_category;

-- 테이블 별칭
-- 테이블 as "별칭" -> as ""생략이 가능
-- 조인테이블에서 컬럼명이 같은 경우 반드시 테이블 별칭으로 컬럼을 참조해야 함
select
    m.menu_name,
    m.menu_price,
    m.category_code
from tbl_menu as m;

-- ---------------------------------------
-- INNER JOIN
-- ---------------------------------------
-- 좌우 테이블에서 조인 조건에 부합하는 행들만 연결해서 relation 생성
-- ⛳기준 컬럼이 null이거나, 상대 테이블에 매칭되는 행이 없다면, relation에서 제외됨!
-- inner 키워드는 생략이 가능함
select
    count(*) -- 21행
from tbl_menu a inner join tbl_category b
    on a.category_code = b.category_code;

-- ⛳제외된 행을 찾는 것이 중요!!⛳
-- tbl_menu(22행)에서 category_code 가 null인 22번 찰순대쥬스행이 제외되었다. -> 21행 사용됨
-- tbl_category(12행)에서 tbl_menu.category_code에서 사용되지 않은 4행(1, 2, 3, 7)이 제외됨 -> 8행이 사용됨

#using(컬럼)
-- 조인테이블의 기준컬럼명이 동일한 경우 사용 가능
select
    a.menu_code,
    a.menu_name,
    a.menu_price,
    category_code, -- 별칭없이 동일한 이름의 컬럼을 참조
    b.category_name
from
    tbl_menu a inner join tbl_category b
        using (category_code);
#     on a.category_code = b.category_code;

-- ---------------------------------------
-- OUTER JOIN
-- ---------------------------------------
-- 외부 조인. 좌/우측 테이블을 기준으로 조인
-- 기준이 된 테이블은 누락되는 행이 없다.
-- 기준이 된 테이블의 모든 행과 상대 테이블에서 조인 조건에 부합되는 행이 사용됨

# LEFT OUTER JOIN
-- 왼쪽 테이블 기준으로 조인
-- tbl_menu.category_code가 상대 테이블 tbl_menu에서 사용되지 않은 4행은 제외됨
-- tbl_menu.category_code가 NULL인 찰순대쥬스행이 추가됨!
select *
from tbl_menu m left outer join tbl_category c
    on m.category_code = c.category_code;
#     using (category_code); -- 22행(21행 + 1행(찰순대쥬스))

# RIGHT OUTER JOIN
-- 오른쪽 테이블 기준으로 조인
-- tbl_menu.category_code가 상대 테이블 tbl_menu에서 사용되지 않아 제외되엇던 4행이 추가됨
-- ⛳tbl_menu.category_code가 NULL인 찰순대쥬스행이 제외됨!
select
    *
from tbl_menu m right outer join tbl_category c
    on m.category_code = c.category_code; -- 25행(21행 + 4행(식사, 음료, 디저트, 퓨전)

# 조인 결과 정리
-- tbl_menu(22행), tbl_category(12행)
-- inner join (21행) : tbl_menu 21행(tbl_category가 null인 행 제외) + tbl_category 8행(상대 테이블에 매칭되는 행이 없는 행 제외)
-- left outer join (22행): tbl_menu 22행(*) + tbl_category 8행(상대 테이블에 매칭되는 행이 없는 행 제외)
-- right outer join (25행) : tbl_menu 21행(tbl_category가 null인 행 제외) + tbl_category 12행 (*)

-- 두 테이블의 inner join 결과를 확인 (제외되는 행 확인)
-- 문맥에 따라 외부 조인을 활용

-- left, right은 작성된 위치 기준이다.
select
    *
from tbl_category c left outer join tbl_menu m
    on c.category_code = m.category_code;

-- empdb에서 내부/외부조인 확인
use empdb;
-- 사원 정보(employee)와 부서 정보(department)
select * from employee; -- employee.dept_code
select * from department;-- department.DEPT_ID

-- 내부 조인(22행)
-- employee(22행) - dept code가 null 사원 2명 제외
-- department(6행) - DEPT_ID를 employee.dept_code에서 사용하지 않은 3행 제외 (D3, D4, D7)
-- 사원 조회(부서 지정안된 사원은 제외, 사원 부서도 제외)
select
    *
from employee e inner join department d
    on e.DEPT_CODE = d.DEPT_ID;

-- 좌측 외부 조인(24행) : 22행 + 2행 (dept_code가 null 행 추가)
-- 사원조회(부서 지정 안된 사원도 포함)
select
    *
from employee e left outer join department d
    on e.DEPT_CODE = d.DEPT_ID;

-- 우측 외부 조인(25행)
-- 사원이 존재하는 부서만 조회
select
    *
from employee e right outer join department d
    on e.DEPT_CODE = d.DEPT_ID;

-- 사원이 존재하는 부서만 조회
select distinct
    d.DEPT_ID,
    d.DEPT_TITLE
from employee e join department d
    on e.DEPT_CODE = d.DEPT_ID;

-- ---------------------------------------
-- CROSS JOIN
-- ---------------------------------------
-- 좌우측 테이블에서 행과 행이 만나는 모든 경우의 수를 적용한 조인
-- 조인 조건절을 작성하지 않음
-- relation 행의 수는 좌측 테이블 행수 * 우측 테이블 행수와 같다
-- CROSS JOIN을 적용할 맥락은 거의 없음!

use menudb;

-- 264행 = 22행 * 12행
select *
from
    tbl_menu m cross join menudb.tbl_category c;

-- ---------------------------------------
-- SELF JOIN
-- ---------------------------------------
-- 자가 조인 → 같은 테이블을 좌우측에 두고, 다른 테이블인 양 조인
-- 같은 테이블 안에서 다른 레코드를 참조하고 있을 때, 자가 조인 할 수 있음
SELECT * FROM tbl_category;

-- 카테고리 조회(상위 > 하위)
-- SELF 내부 조인
-- 카테고리 조회(상위 카테고리 없거나, 하위 카테고리나 없으면 제외)
SELECT
    CONCAT(C1.category_name, ' > ', C2.category_name)
FROM
    tbl_category C1 JOIN tbl_category C2
        ON C1.category_code = C2.ref_category_code; -- C1 상위 카테고리 - C2 하위 카테고리

-- SELF 왼쪽 외부 조인
-- 카테고리 조회(상위 카테고리는 모두 조회)
SELECT
    *
FROM
    tbl_category C1  LEFT JOIN tbl_category C2
        ON C1.category_code = C2.ref_category_code; -- 18행 (9행 + 9행)

-- SELF 오른쪽 외부 조인
-- 카테고리 조회(하위 카테고리는 모두 조회)
SELECT
    *
FROM
    tbl_category C1 RIGHT JOIN tbl_category C2
        ON C1.category_code = C2.ref_category_code; -- 12행 (9행 + 3행)

-- 사원 테이블에서 사원 - 매니저 조회
USE empdb;
SELECT * FROM employee;

-- 사번 사원명 매니저사번 매니저명 조회
-- 내부 조인
-- 1. E 테이블에서 MANAGER_ID가 NULL인 행
-- 2. M테이블에서는 M.EMP_ID가 상응하는 E.MANAGER_iD가 없는 경우 제외(관리하는 부하 직원이 없는 경우)
SELECT
    E.EMP_ID,
    E.EMP_NAME,
    E.MANAGER_ID,
    M.EMP_ID,
    M.EMP_NAME
FROM
    employee E JOIN employee M
        ON E.MANAGER_ID = M.EMP_ID; -- 16행

-- 좌측 외부 조인
-- 사원 - 매니저 조회(매니저 없는 사원도 조회)
SELECT
    E.EMP_ID,
    E.EMP_NAME,
    M.EMP_ID,
    M.EMP_NAME
FROM
    employee E LEFT JOIN employee M
        ON E.MANAGER_ID = M.EMP_ID; -- 24행(16행 + 8행(MANAGER_ID가 NULL인 행))

-- 우측 외부 조인
-- 매니저 - 사원 조회(관리하는 직원이 없는 매니저도 조회)
SELECT
    E.EMP_ID,
    E.EMP_NAME,
    M.EMP_ID,
    M.EMP_NAME
FROM
    employee E RIGHT JOIN employee M
        ON E.MANAGER_ID = M.EMP_ID; -- 33행(16행 + 17행(EMP_ID가 NULL인 행))

-- --------------------------------
-- MULTIPLE JOIN
-- --------------------------------
-- 다중조인. 여러테이블을 조인해 relation을 생성.
-- 한번에 두개씩 연달아 조인 처리

-- 다중 내부 조인
-- 사원 - 부서 - 지역조회(부서 지정)
-- 어느 사원이 어떤 부서, 어떤지역에 근무하는지 보고 싶을 때
select * from employee;
select * from department;
select * from location;

-- 어느 사원이 어떤 부서, 어떤지역에 근무하는지 보고 싶을 때
select *
from
    employee e
        join department d
            on e.DEPT_CODE = d.DEPT_ID -- ⛳하나의 테이블로 봄!
        join location l
            on d.LOCATION_ID = l.LOCAL_CODE
where
    l.LOCAL_NAME = 'EU';

-- MULTIPLE LEFT JOIN
-- ⛳💖💖중요!!💖💖⛳
-- 사원 - 부서 - 지역조회(부서 지정 안된 사원 포함)
select *
from
    employee e
        left join department d
             on e.DEPT_CODE = d.DEPT_ID
        left join location l
             on d.LOCATION_ID = l.LOCAL_CODE
