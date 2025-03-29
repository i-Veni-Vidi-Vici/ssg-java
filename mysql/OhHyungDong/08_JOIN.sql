-- ========
-- JOIN
-- ========
-- 두개 이상의 테이블 레코드를 연결해서 Relation(가상 테이블)을 생성할 수 있다.
-- 두 테이블의 특정컬럼 기준을 행과 행을 연결한다.
-- Relation(가상 테이블) : 테이블과 테이블을 합쳐서 가상의 테이블을 만들어 낸 것

# 가상테이블 relation을 만드는 방법.
-- 1. join : 레코드와 레코드를 가로로 연결
-- 2. union(union all) : 레코드와 레코드를 세로로 연결

# JOIN 구분
-- 1. EQUI JOIN(등가 조인) : 조인 조건에 = 동일비교 연산자를 사용한 경우
-- 2. NON EQUI JOIN(비등가 조인) : 조인 조건에 = 동일 비교 연산자를 사용하지 않은 경우 (>, <, >=, <= , between, like,in)

# EQUI JOIN 구분
-- 1. INNER JOIN (내부 조인) : 기준 컬럼에 부합하는 행들만 조인 한경우 (null이 있는 행은 조인 안됨)
-- 2. OUTER JOIN (외부 조인)
--      -LEFT OUTER JOIN : 왼쪽 테이블 전체와 오른쪽 테이블에서는 기준 컬럼에 부합하는 행들만 조인한 경우
--      -RIGHT OUTER JOIN : 오른쪽 테이블 전체와 왼쪽 테이블에서는 기준 컬럼에 부합하는 행들만 조인한 경우
-- 3. CROSS JOIN
-- 4. SELF JOIN(자가 조인)
-- 5. MULTIPLE JOIN ( 다중조인 )

# 조인 문법
-- from 좌측 테이블 join 우측 테이블 on 조건절
-- from 좌측 테이블 a join 우측 테이블 b  on  a.컬럼 = b.컬럼 (테이블 별칭 사용)

# 조인 맛보기
-- 한우딸기국밥의 카테고리명 조회
-- 1. 한우 딸기 국밥의 tbl_menu.category_code 조회
-- 2. 1번에 결과를 가지고 tbl_category.categroy_name조회

select category_code
from tbl_menu
where menu_name = '한우딸기국밥';

select tbl_category.category_name
from tbl_category
where category_code = 4;

select
    tbl_menu.menu_name, tbl_category.category_name
from
    tbl_menu join tbl_category
        on tbl_menu.category_code = tbl_category.category_code
where menu_name = '한우딸기국밥';
-- 별칭
select
    a.menu_name, b.category_name -- 테이블 별치잉 생략 가능하나 되도록이면 생략불가
from
    tbl_menu a join tbl_category b
        on a.category_code = b.category_code -- 테이블 별칭 생략 불가 -> 컬럼명이 동일해서
where menu_name = '한우딸기국밥';

-- 테이블 별칭
-- 테이블 as "별칭" -> as "" 생략이 가능 (두 테이블의 칼럼명이 같으면 생략하면 안됨)
-- 조인테이블에서 컬럼명이 같은 경우 반드시 테이블 별칭으로 컬럼을 참조해야한다.
select
    m.menu_price,
    m.menu_name
from
    tbl_menu as m;


-- -------------------------
-- INNER JOIN
-- -------------------------
-- 좌우 테이블에서 조인조건에 부합하는 행들만 연결해서 relation을 생성하게 된다.
-- ** 기준 컬럼이 null이거나, 상대테이블에 매칭되는 행이 없다면, relation에서 제외된다. **
-- inner 키워드는 생략이 가능하다.

-- 메뉴 / 카테고리 정보를 모두 조회(카테고리 없는 메뉴 제외, 메뉴 없는 카테고리도 제외) -> 교집합 느낌
select count(*) -- 21행
from tbl_menu a join tbl_category b
        on a.category_code = b.category_code;

-- tbl_menu(22)에서 category_code가 null인 경우 22번 찰순대쥬스행이 제외됐다. -> 21행이 사용됨.
-- tbl_category(12)에서 tbl_menu.categroy_code에서 사용되지 않은 4행(1,2,3,7)이 제외되었다.

# using(컬럼)
-- 조인테이블의 기준 컬럼명이 동일한 경우 사용가능하다.
select
    category_code -- 별칭없이 동일한 이름의 컬럼을 참조
from
    tbl_menu a join tbl_category b
              using (category_code); -- 동일한 category_code값이 합쳐져서 나온다. on을 사용하면 컬럼이 따로따로 나옴
            # on a.category_code = b.category_code;

-- -------------------
-- OUTER JOIN
-- -------------------
-- 외부조인 , 좌 / 우측 테이블을 기준으로 조인
-- 기준이 된 테이블은 누락되는 행이 없다.
-- 기준이 된 테이블의 모든행과 상대테이블에서 조인조건에 부합되는 행이 사용된다.
select  * from tbl_category;

#LEFT OUTER JOIN
-- 왼쪽 테이블을 기준으로 조인 -> 왼쪽 테이블의 칼럼들은 다 나옴
-- tbl.category.category_code가 상대테이블 tbl_menu에서 사용되지 않은 4행은 제외되었다.
-- code가 null인 찰순대쥬스행이 추가됐다.

-- 메뉴 조회 (카테고리 없는 메뉴도 포함)
select *
from
    tbl_menu m left outer join tbl_category c
       using(category_code);
        -- on m.category_code = c.category_code;

#RIGHT OUTER JOIN
-- 오른쪽 테이블 기준으로 조인 -> 오른쪽 테이블의 칼럼들은 다 나옴
-- tbl.category.category_code가 상대테이블 tbl_menu에서 사용되지 않아 제외됐던 4행이 추가됐다.
-- code가 null인 찰순대쥬스행이 제외됐다.

-- 카테고리를 조회 (연결된 메뉴가 없는 카테고리도 포함)
select *
    from
        tbl_menu m right outer join tbl_category c
            on m.category_code = c.category_code; -- 25행 ( 21  + 4 (식사,음료,디저트,퓨전))

-- 조인 결과 정리
-- tbl_menu : 22행 , tbl_category : 12행
-- inner join : 21행 -> tbl_menu 21(category_code = null인 행 제외) + tbl_categroy 8(상대 테이블에 매칭되는 행이 없는 행 제외)
-- left join : 22행 -> tbl_menu 22(*) + tbl_categroy 8(상대 테이블에 매칭되는 행이 없는 행 제외)
-- right join : 25행 : tbl_menu 21 + tbl_categroy 12(*)

-- 두 테이블의 inner join 결과를 확인(제외되는 행이 있는지 확인)
-- 문맥에 따라 외부조인을 활용

-- left, right 작성 된 위치 기준
select *
from tbl_category c left outer join tbl_menu m
                                    on c.category_code = m.category_code;

-- emp에서 내부 / 외부조인 확인
use empdb;
select * from employee;
select * from department;
-- 사원정보(employee)와 부서정보(department)


-- 내부조인
-- 사원조회 ( 부서 지정 안된 사원은 제외, 사원부서도 제외)
select e.emp_name,
       d.dept_id,
       d.dept_title
from employee e join department d
                     on e.dept_code = d.dept_id;
-- dept-id = null값 제외

-- 좌측조인 - 24행
-- 사원조회 ( 부서 지정 안된 사원은 제외, 사원부서도 제외)
select e.emp_name,
       d.dept_id,
       d.dept_title
from employee e left join department d
    on e.dept_code = d.dept_id;
-- dept-id = null값 포함

-- 우측 조인 - 25
--  부서 조회  - 유령부서 조회
select *
from employee e right join department d
             on e.dept_code = d.dept_id;

-- 사원이 존재하는 부서만 조회
select distinct
    d.dept_id,
    d.dept_title
from employee e  join department d
                        on e.dept_code = d.dept_id;

-- ---------------
-- CROSS JOIN
-- ---------------
-- 좌우측 테이블에서 행과 행이 만나는 모든 경우의 수를 적용한 조인
-- 조인 조건절을 작성하지 않는다.
-- relation 행의 수는 좌측테이블 행 수 * 우측테이블 행수와 같다.
-- 크로스 조인을 적용할 맥락은 거의 없다.
-- cross 키워드, on 조건절을 생략하면 의도핮 ㅣ않아도, cross조인으로 군자훈다.

-- tbl menu : 22, tbl_categroy = 12
use menudb;
-- 264행
select *
from tbl_menu m cross join tbl_category c;

-- ---------------
-- self JOIN
-- ---------------
-- 자가조인, 같은 테이블을 좌우측에 두고 다른 테이블인아요 조인
-- 같은 테이브 안에서 다른 레코드를 참조하고 있을때 자가조인 할 수 있다.

-- 카테고리 조회(상위 > 하위)
-- self 내부조인
-- 카테고리 조회(상위 카테고리 없거나, 하위카테고리 없으면 제외)

-- self 내부조인
    select *
    from tbl_category c1 join tbl_category c2
        on c1.category_code = c2.ref_category_code;

-- self 왼쪽 자가조인

-- self 오른쪽 자가 조인

-- 사번 사원명 매니져 사번 , 매니저명 조회
-- 내부조인(e1 manager_id가 null인행,
-- m테이블에서는 m.emp_id가 상응하는 e.manager_id가 없는 경우 제외 (관리하는 부하직원이 없는 경우)
select e1.emp_id 사번,
       e1.emp_name 사원,
       e2.emp_id'매니저 사번',
       e2.emp_name '매니저 사원'
From employee e1  join employee e2
    on e1.manager_id = e2.emp_id;

select e1.emp_id 사번,
       e1.emp_name 사원,
       e2.emp_id'매니저 사번',
       e2.emp_name '매니저 사원'
From employee e1  join employee e2
                       on e1.emp_id = e2.manager_id;

select * from employee;

-- 좌측 외부조인
-- 사원 - 매니저 조회 (매니저 없는 사원도 조회
select e1.emp_id 사번,
       e1.emp_name 사원,
       e2.emp_id'매니저 사번',
       e2.emp_name '매니저 사원'
From employee e1  left join employee e2
                       on e1.manager_id = e2.emp_id;

-- 우측 외부조인
-- 매니저 사원 조회 (관리하는 직원이 없는 매니저도 조회)
select
       e2.emp_id'매니저 사번',
       e2.emp_name '매니저 사원',
        e1.emp_id 사번,
        e1.emp_name 사원
From employee e1  right join employee e2
                on e1.manager_id = e2.emp_id;


-- =============
-- MULTIPLE JOIN
-- =============
-- 다중조인. 여러테이블을 조인해 relation을 생성
-- 한번에 두개씩 연달아 조인을 처리함.

-- 사원 - 부서 - 지역
select * from employee;
select * from department;
select * from location;


-- 다중 내부 조인
-- 사원 - 부서 - 지역조회 (부서 지정 안된 사원 제외) 첫번째 조인에서 제거됨.
select *
from
    employee e
        join department d
            on e.dept_code=d.dept_id
        join location l
            on d.location_id =  l.local_code;

-- 다중 왼쪽 외부 조인
-- 사원 - 부서 - 지역조회
-- 부서 지정 안된 사원까지 다 출력
select *
from
    employee e
        left join department d
             on e.dept_code=d.dept_id
        left join location l
             on d.location_id =  l.local_code;