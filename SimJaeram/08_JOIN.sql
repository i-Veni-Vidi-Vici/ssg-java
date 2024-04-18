-- =============================
-- JOIN
-- =============================

-- 테이블이 합쳐진 것을 릴레이션이라고 함

-- 두 개 이상의 테이블 레코드를 연결해서 Relation(가상 테이블)을 생성할 수 있다.
-- 두 테이블의 특정 컬럼 기준으로 행과 행을 연결한다.

# Relation(가상테이블)을 만드는 방법
-- 1. join // 레코드와 레코드를 가로로 연결
-- 2. union(uinion all) // 레코드와 레코드를 세로로 연결

# JOIN 구분
-- 1. EQUI JOIN (등가조인) // 조인 조건에 동일비교연산자 = 를 사용한 경우
-- 2. NON-EQUI JOIN (비등가조인) // 조인 조건에 동일비교연산자 = 를 사용하지 않은 경우 (>, <, >=, <=, between, like, in)

# EQUI JOIN 구분
-- 1. INNER JOIN (내부조인) // 기준 컬럼에 부합하는 행들만 조인한 경우
-- 2. OUTER JOIN (외부조인)
--      - LEFT OUTER JOIN // 왼쪽 테이블 전체와 오른쪽 테이블에서는 기준 컬럼에 부합하는 행들만 조인한 경우
--      - RIGHT OUTER JOIN // 오른쪽 테이블 전체와 왼쪽 테이블에서는 기준 컬럼에 부합하는 행들만 조인한 경우
-- 3. CROSS JOIN
-- 4. SELF JOIN (자가 조인)
-- 5. MULTIPLE JOIN (다중 조인)

# 조인 문법
-- from 왼쪽 테이블 join 오른쪽 테이블 on 왼쪽 테이블.컬럼 = 오른쪽 테이블.컬럼
-- from 왼쪽 테이블 풀네임 별칭 a join 오른쪽 테이블 풀네임 별칭 b on a.컬럼 = b.컬럼 // 별칭사용하여 간략하게 작성할 수 있음

# 조인 맛보기
-- 조인문법의 inner join에서 inner가 생략됨
-- 한우딸기국밥의 카테고리명 조회
-- 1. 한우딸기국밥의 tbl_menu.category_code 조회
-- 2. 1번의 결과를 가지고 tbl_category.category_name 조회

-- 1.
select
    category_code
from
    tbl_menu
where menu_name = '한우딸기국밥';
-- 2.
select
    category_name
from
    tbl_category
where category_code = 4;

-- 만약 이 데이터들이 한 테이블에 있었다면

select
    category_name -- 테이블 별칭을 생략가능하나 되도록 작성한다.
from
    tbl_menu a join tbl_category b
        on a.category_code = b.category_code -- 테이블 별칭 생략 불가
where
    menu_name = '한우딸기국밥';

-- 테이블 별칭
-- 테이블 as "별칭" -> as "" 생략이 가능
-- 조인테이블에서 컬럼명이 같은 경우 반드시 테이블별칭으로 컬럼을 참조해야 한다. ([23000][1052] Column 'category_code' in on clause is ambiguous)
select
    m.menu_name,
    m.menu_price,
    m.category_code
from
    tbl_menu as m;

-- ---------------------------
-- INNER JOIN
-- ---------------------------
-- 좌우테이블에서 조인조건에 부합하는 행들만 연결해서 relation 생성
-- ** 기준컬럼이 null이거나, 상대 테이블에 매칭되는 행이 없다면, relation에서 제외된다. **
-- inner 키워드는 생략이 가능하다.

-- 메뉴/카테고리정보를 모두 조회 // 카테고리 없는 메뉴 제외, 메뉴 없는 카테고리 제외
select
    count(*) -- 21행
from
    tbl_menu a inner join tbl_category b
    on a.category_code = b.category_code;

-- tbl_menu 22행에서 category_code가 null인 22번 찰순대주스형이 제외되었다. 그래서 21행이 사용됨
-- tbl_category 12행에서는 tbl_menu.category_code에서 사용되지 않은 4행 1, 2, 4, 7이 제외되었다. 그래서 8행이 사용됨

# using (컬럼)
-- 조인테이블의 기준 컬럼명이 동일한 경우 사용 가능하다.
-- inner, outer 조인 둘다에서 사용 가능하다.
select
    a.menu_name,
    a.menu_code,
    a.menu_price,
    category_code, -- 별칭 없이 동일한 이름의 컬럼 참조 가능 // ambigus 에러 발생하지 않음
    b.category_name
from tbl_menu a inner join tbl_category b
    using(category_code);
#     on a.category_code = b.category_code;

-- ---------------------------
-- OUTTER JOIN
-- ---------------------------
-- 외부조인. 좌/우측 테이블을 기준으로 조인.
-- 기준이 된 테이블은 누락되는 행이 없다. // 무조건 원래 테이블 행 다 가져다 놓음
-- 기준이 된 테이블의 모든행과 상대테이블에서 조인조건에 부합되는 행이 사용된다. // 부합되는 행이 없는 기준 테이블의 행은 null로 다 채움

# LEFT OUTER JOIN
-- 왼쪽 테이블 기준으로 조인
-- tbl_category.category_code가 상대 테이블 tbl_menu에서 사용되지 않아 제외됐던 4제외되었다.
-- tbl_menu.category_code가 null인 찰순대쥬스행이 추가되었다.

-- 메뉴 조회 // 카테고리 없는 메뉴도 포함
select
    *
from
    tbl_menu m left outer join tbl_category c
        on m.category_code = c.category_code; -- 22(21+1(찰순대쥬스))행
#     using (category_code);

# RIGHT OUTER JOIN
-- 오른쪽 테이블 기준으로 조인
-- tbl_category.category_code가 상대 테이블 tbl_menu에서 사용되지 않아 제외됐던 4행이 추가되었다.
-- tbl_menu.category_code가 null인 찰순대쥬스행은 제외되었다.

-- 카테고리 조회 // 연결된 메뉴 없는 카테고리도 포함
select
    *
from
    tbl_menu m right outer join tbl_category c
        on m.category_code = c.category_code; -- 25(21+4(1, 2, 3, 7))행

# 조인 결과 정리
-- tbl_menu(22행), tbl_category(12행)
-- inner join 21행: tbl_menu 21행(category_code가 null인 행 제외) + tbl_category 8행(상대 테이블에 매칭되는 행이 없는 행 제외)
-- left outer join 22행: tbl_menu 22행(*) + tbl_category 8행(상대 테이블에 매칭되는 행이 없는 행 제외)
-- right outer join 25행: tbl_menu 21행(상대 테이블에 매칭되는 행이 없는 행 제외) + tbl_category 12행(*)

-- 두 테이블의 inner join 결과를 확인 // 제외되는 행 확인
-- 문맥에 따라 외부조인을 활용

-- left, right은 작성된 위치 기준이다.
select
    *
from
    tbl_category c left outer join tbl_menu m
        on c.category_code = m.category_code;

-- outer 키워드 생략 가능하다.
-- 즉, inner join은 join만, outer join은 left join, right join만 작성 가능하다.

-- empdb에서 내부/외부 조인 확인
use empdb;

-- 사원 정보(employee)와 부서정보(department) // 컬럼명이 다르므로 using은 사용할 수 없음

select *
from employee
order by DEPT_CODE; -- 24행 // employee.dept_code

select *
from department; -- 9행 // department.dept_id

-- inner join 22행: employee 22행(dept_code가 null인 2행 제외) + department에서는 6행 사용됨(기준 테이블과 매칭되지 않는 D3, D4, D7행 제외됨)
-- 사원조회 시 부서 지정안된 사원은 제외, 사원 없는 부서도 제외시 inner join 사용
select
    *
from
    employee e inner join department d
        on e.DEPT_CODE = d.DEPT_ID;

-- left outer join 24행: employee 24행(*) + department.dept_id 6행 사용됨(기준 테이블과 매칭되지 않은 D3, D4, D7행 제외됨)
-- 사원 조회 시 부서 지정 안 된 사원도 포함하여 조회시 left outer join 사용
select
    *
from
    employee e left outer join department d
        on e.DEPT_CODE = d.DEPT_ID;

-- right outer join 25행: employee 22행(department_code가 null인 2행 제외됨) + department(*) 9행 (employee 테이블과 매칭되지 않은 3, 4, 7행 사용됨)
-- 부서 조회시 사원 없는 부서도 포함하여 조회시 right outer join 사용
select *
from employee e right outer join department d
    on e.DEPT_CODE = d.DEPT_ID;

-- 사원이 존재하는 부서만 조회
select distinct
    d.DEPT_ID,
    d.DEPT_TITLE
from
    employee e inner join department d
        on e.DEPT_CODE = d.DEPT_ID;

-- ---------------------------
-- CROSS JOIN
-- ---------------------------
-- 왼쪽 오른쪽 테이블에서 행과 행이 만나는 모든 경우의 수를 적용한 조인
-- 조인조건절을 작성하지 않는다.
-- relation행의 수는 좌측 테이블 행 수 * 우측 테이블 행수와 같다.
-- 크로스 조인을 적용하는 경우는 거의 없다.
-- cross 키워드와 on 조건절을 생략하면, 크로스 조인으로 처리된다. // 내부 조인이 아니다. 내부 조인은 on 조건절이 있어야 한다.
use menudb;

-- 264행: 22행 * 12행
select
    *
from
    tbl_menu m cross join tbl_category c;

-- ---------------------------
-- SELF JOIN
-- ---------------------------
-- 자가조인
-- 같은 테이블을 좌우측에 두고 다른 테이블인 것처럼 조인하는 것
-- 같은 테이블 안에서 다른 레크드를 참조하고 있을때 자가 조인할 수 있다.

select
    *
from
    tbl_category;

-- 카테고리 조회 (상위 > 하위)
-- SELF 내부 조인
-- 카테고리 조회(상위 카테고리 없거나 하위 카테고리 없으면 제외)
select
    concat(c1.category_name, ' > ', c2.category_name)
from
    tbl_category c1 join tbl_category c2
        on c1.category_code = c2.ref_category_code; -- c1이 상위 카테고리, c2를 하위 카테고리

-- SELF 왼쪽 외부 조인
-- 카테고리 조회(상위 카테고리는 모두 조회)
select
    *
from
    tbl_category c1 left join tbl_category c2
    on c1.category_code = c2.ref_category_code; -- 18행 (9+9행)                                                    -- SELF 왼쪽 외부 조인

-- SELF 오른쪽 외부 조인
-- 카테고리 조회(하위 카테고리는 모두 조회)
select
    *
from
    tbl_category c1 right join tbl_category c2
    on c1.category_code = c2.ref_category_code; -- 12행

-- 사원 테이블에서 사원-매니저 조회
use empdb;

select * from employee;

-- 사번 사원명 매니저 사번 매니저명 조회
-- 내부 조인
-- 1. e 테이블에서 manager_id가 null인 행 제외
-- 2. m 테이블에서는 m.emp_id가 상응하는 e.manager_id가 없는 경우 제외(관리하는 부하직원이 없는 경우)
select
    e.EMP_ID,
    e.EMP_NAME,
    e.MANAGER_ID,
    m.EMP_NAME '매니저명'
from
    employee m right join employee e
        on m.EMP_ID = e.MANAGER_ID; -- 16행

-- 좌측외부조인
-- 사원-매니져 조회 (매니져 없는 사원도 조회)
select
    e.emp_id,
    e.emp_name,
    m.emp_id,
    m.emp_name
from
    employee e left join employee m
        on e.manager_id = m.emp_id; -- 24행 (16행 + 8행)

-- 우측외부조인
-- 매니져-사원 조회 (관리하는 직원이 없는 매니져도 조회)
select
    m.emp_id,
    m.emp_name,
    e.emp_id,
    e.emp_name
from
    employee e right join employee m
        on e.manager_id = m.emp_id; -- 33행 (16행 + 17행)


-- ---------------------------
-- MULTIPLE JOIN
-- ---------------------------
-- 다중조인
-- 여러테이블을 조인해 relation을 생성
-- 한번에 두개씩 연달아 조인 처리

-- 사원 - 부서 - 지역
select * from employee;
select * from department;
select * from location;

-- 다중 내부 조인
-- 사원 - 부서 - 지역 조회 (부서지정안된 사원 제외)
select
    *
from
    employee e join department d
        on e.DEPT_CODE = d.DEPT_ID
    join location l
        on d.LOCATION_ID = l.LOCAL_CODE;

-- 사원 - 부서 - 지역 조회 (부서지정 안된 사원 포함)
select
    *
from
    employee e
        left outer join department d
            on e.DEPT_CODE = d.DEPT_ID -- 여기까지는 하동운, 이요리가 포함됨
        join location l
            on d.LOCATION_ID = l.LOCAL_CODE;

select
    *
from
    employee e
        left outer join department d
            on e.DEPT_CODE = d.DEPT_ID
        left outer join location l
            on d.LOCATION_ID = l.LOCAL_CODE;
