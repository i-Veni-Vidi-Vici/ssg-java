-- =======================================
-- JOIN
-- =======================================
-- 두개 이상의 테이블 레코드를 연결해서 Relation을 생성할 수 있다.
-- 두 테이블의 특정컬럼 기준으로 행과 행을 연결한다.

-- 가상테이블 relation을 만드는 방법
-- 1. join : 레코드와 레코드를 가로로 연결
-- 2. union(union all) : 레코드와 레코드를 세로로 연결

# JOIN 구분
-- 1. EQUI JOIN (등가조인) 조인조건에 = 동일비교 연산자를 사용한 경우

-- 2. NON-EQUI JOIN(비등가조인) 조인조건에 = 동일비교 연산자를 사용하지 않은 경우 (>, <, >=, <=, between)

# EQUI JOIN 구분
-- 1. INNER JOIN (내부조인) - 기준컬럼에 부합하는 행들만 조인한 경우
-- 2. OUTER JOIN (외부조인)
--          - LEFT OUTER JOIN - 왼쪽테이블 전체와 오른쪽테이블애소눈 가쥰콜롬애 부합하는 행들만 조인한 경우
--          - RIGHT OUTER JOIN - 오른쪽테이블 전체와 왼쪽테이블애소눈 가쥰콜롬애 부합하는 행들만 조인한 경우

-- 3. CROSS JOIN
-- 4. SELF JOIN (자가조인)
-- 5. MULTIPLE JOIN (다중조인)


# 조인 문법
-- from 좌측테이블 join 우측테이블 on 좌측테이블.컬럼 = 우측테이블.컬럼
-- from 좌측테이블 a join 우측테이블 b on a.컬럼 = b.컬럼 -> 테이블 별칭을 사용한 결과

# 조인 맛보기
-- 한우딸기국밥 카테고리명 조회
-- tbl_menu.category_code 만 있고 실제 이름은 없음, 그러면 한우딸기국밥의 tbl.menu.category_code 조회
-- 실제이름은 tbl_category.category_name을 조회해야함 1 번의 결과를 가지고 tbl_category.category_name 조회

select
    category_code -- 4를 뱉어줄 것임
from
    tbl_menu
where
    menu_name = '한우딸기국밥';

select
    category_name
from
    tbl_category
where
    category_code =4;

-- 만약 이 데이터들이 한 테이블에 있었다면?

select
    * -- 테이블 별칭 생략해도 되는데 되도록이면 작성
from
    tbl_menu a join tbl_category b
        on a.category_code = b.category_code -- 테이블 별칭 생략 불가
where
    menu_name = '한우딸기국밥';

select * from tbl_menu;
select * from tbl_category;

-- 테이블 별칭
-- 테이블 as "별칭" -> as "" 생략이 가능
-- 조인테이블에서 컬럼명이 같은 경우 반드시 테이블별칭으로 컬럼을 참조해야 한다.
select
    m.menu_name,
    m.menu_price,
    m.category_code
from
    tbl_menu as m;

-- ---------------------------------
-- INNER JOIN
-- ---------------------------------
-- 좌우테이블에서 조인조건에 부합하는 행들만 연결해서 relation 생성
-- 기준컬럼이 null 이거나, 상대 테이블에 매칭되는 행이 없다면, relation에서 제외된다.
-- inner 키워드는 생략이 가능하다.


select
    count(*) -- 숫자를 세어보면 21행이 나옴
from
    tbl_menu a inner join tbl_category b
        on a.category_code = b. category_code;

-- tbl_menu(22행)에서 category_code가 null인 22번 찰순대쥬스행이 제외되었다 -> 21행 사용됨.
-- tbl_category(12행)에서 tbl_menu.category_Code에서 사용되지 않은 4행 (1, 2,3 ,7)이 제외되었다. -> 8행만사용됨 뭐가 제외되었는지 잘 파악해야함.

# using (컬럼)
-- 조인테이블의 기준 컬럼명이 동일한 경우 사용가능하다.
select
    a.menu_code,
    a.menu_name,
    a.menu_price,
    category_code, -- 별칭없이 동일한 이름의 컬럼을 참조
    b.category_code
from
    tbl_menu a inner join tbl_category b
        using (category_code);
#         on a.category_code = b.category_code;

-- ---------------------------------
-- OUTER JOIN
-- ---------------------------------
-- 외부조인. 좌/우측 테이블을 기준으로 조인.
-- 기준이 된 테이블은 누락되는 행이 없다.
-- 기준이 된 테이블의 모든행과 상대테이블에서 조인조건에 부합되는 행이 사용된다.

# LEFT OUTER JOIN
-- 왼쪽 테이블 기준으로 조인
-- tbl_menu.category_code가 null인 찰순대쥬스행이 추가됨
select *
from
    tbl_menu m left outer join tbl_category c
        on m.category_code = c.category_code;
#         using (category_code); -- 22행 ((1행 +

# RIGHT OUTER JOIN
-- 오른쪽 테이블 기준으로 조인
-- tbl_category.category_code가 상대테이블 tbl_menu에서 사용되지 않아 제외됐던 4해ㅐㅇ이 추가되었다
-- tbl_menu.category_code 가 null 인 ㄱ
select
    *
from
    tbl_menu m right outer join tbl_category c
        on m.category_code = c.category_code;

-- --------------------------------------
--

SELECT
    *
FROM
    tbl_category c left out join tbl_menu m
        on c.category;

# 조인 결과 정리
-- tbl_menu(22행), tvl_category(12행)
-- inner jon 21 행 : tbl_menu 21행(category code가 null인 행 제외) + tbl_category 8행(상대 테이블에 짝궁없으면 제외됨)
-- left outer join 22행 : tbl_menu 22행(*) + tbl_category 8 해
-- right outer join 25 행 : tbl_menu 21행(category code가 null인 행 제외) + tbl_category 12 행 (*)

-- 두테이블의 inner join 결과를 확인(제외되는 행 확인)
-- 문맥에 따라 외부조인을 활용

-- empdb에서 내부/외부조인 확인
use empdb;

-- 사원정보(employee) 와 부서정보(department)
select  * from empdb.employee; -- 24행 employee.dept_code
select  * from  empdb.department; --  9행 department,dept_id

-- 내부조인 (?행)
-- employee (22행) - dept_code가 null 사원 2명 제외
-- DEPARTMENT (6행) - DEPT_ID를 employee.dept_code에서 사용하지 않은 3행 제외( D3, D4, D7)
-- 사원조회 (부서 지정안된 사원은 제외, 사원부서도 제외)

select
        *
    from
        empdb.employee a inner join empdb.department d on a.DEPT_CODE = d.DEPT_ID;
-- 좌측외부조인 (?행)

-- 좌측외부조인 (24행) : 22행 + 2행 (dept_code가 null 행 추가)
-- 사원조회(부서 지정안된 사원도 포함)
select *
from empdb.employee a left join empdb.department d on a.DEPT_CODE = d.DEPT_ID;

--  우측외부조인 (25행) : 22행 + 3행( EMPLOYEE에 DEPT_ID와 매칭되는 행이 없던 3행 추가)
-- 부서조회(유령부서도 포함)

select *
    from empdb.employee a right join empdb.department d on a.DEPT_CODE = d.DEPT_ID;

-- 사원이 존재하는 부서만 조회

select
    d.dept_id,
    d.dept_title
from
    empdb.employee e join empdb.department d on e.DEPT_CODE = d.DEPT_ID;


-- ---------------------------------------
-- CROSS JOIN
-- ---------------------------------------
-- 좌우측 테이블에서 행과 행이 만나는 모든 경우의 수를 적용한 조인
-- 조인조건절을 작성하지 않는다.
-- relation행의 수는 좌측테이블행 수 * 우측테이블행 수와 같다
-- 크로스 조인을 적용할 맥락은 거의 없다.
-- cross 키워드, on 조건절을 생략하면, 내부조인이 아닌 크로스조인으로 처리된다.

use menudb;

-- 264헹 : 22행 * 12행
select *
from
    tbl_menu m cross join tbl_category c;

-- ---------------------------------------
-- SELF JOIN
-- ---------------------------------------
-- 자가조인, 같은 테이블 좌우측에 두고 다른 테이블과 같이 조인하는 것
-- 같은 테이블안에서 다른 레코드를 참조하고 있을때 자가조인 할 수 있다.

SELECT * FROM tbl_category;

-- 카테고리 조회 (상위 - 하위) 식사류의 중식 음료류의 커피
-- SELF 내부조인
-- 언제쓸까???? 카테고리 조회좀 해줘 ! 그런데 (상휘카테고리가 없거나, 하위카테고리가 없으면 제외)
select
#     concat(c1.category_name, ' > ', c2.category_name)
        *
from
    tbl_category c1 join tbl_category c2
    on c1.category_code = c2.ref_category_code; -- c1 상위카테고리 - c2 하위카테고리


-- SELF 왼쪽 외부조인
select
    *
from
    tbl_category c1 LEFT join  tbl_category c2
                                on c1.category_code = c2.ref_category_code; -- 18행 ( 9행 + 9행)
-- 카테고리 조회(상위카테고리는 모두 조회)
select
    *
from
    tbl_category c1 right join  tbl_category c2
        on c1.category_code = c2.ref_category_code;

-- 사원테이블에서 사원-매니져 조회
use empdb;
select * from empdb.employee;

-- 사번 사원명 매니저사번 매니져명 조회
-- 내부조인
-- 내부조인 (e테이블에서 manager_id가 null인 행, m테이블에서는 m.emp_id 상응하는 e.manager_id가 제외됨(관리하는 부하직원이 없는경우))
select
    e.EMP_id,
    e.EMP_NAME,
    e.MANAGER_ID,
    m.EMP_ID,
    m.EMP_NAME
from
    employee e join employee m
        on e.MANAGER_ID = m.EMP_ID; -- 16개

-- 좌측외부조인
-- 사원 - 매니저 조회 (매니져 없는 사원도 조회)
select
    e.EMP_id,
    e.EMP_NAME,
    m.EMP_ID,
    m.EMP_NAME
from
    employee e left join employee m on e.MANAGER_ID = m.EMP_ID;


-- 우측외부조인
-- 매니져-사원 조회 (관리하는 직원이 없는 매니져도 조회) 매니저 입장임
select
    m.EMP_ID,
    m.EMP_NAME,
    e.EMP_id,
        e.EMP_NAME
from
    employee e right join  employee m on e.MANAGER_ID = m.EMP_ID; -- 33행 (16행 +17행)

-- ---------------------------------------
-- MULTIFUL JOIN
-- ---------------------------------------
-- 다중조인, 여러테이블을 조인해 relation을 생성
-- 한번에 두개씩 연달아 조인 처리
-- 사원 - 부서 - 지역
select * from employee;
select * from department;
select * from location;
select *
from
    employee e join department d
        on e.DEPT_CODE = d.DEPT_ID
join location l
    on d.LOCATION_ID = l.LOCAL_CODE
where
    l.LOCAL_NAME = 'EUGS';

select *
from
    employee e
        left join dept_code = d.