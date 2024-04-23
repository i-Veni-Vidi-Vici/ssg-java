-- @DQL종합실습문제
-- 문제1
-- 기술지원부에 속한 사람들의 사람의 이름,부서코드,급여를 출력하시오. 
select 
    emp_name 이름,
    dept_code 부서코드,
    salary 급여
from 
    employee e, department d
where 
    e.dept_code = d.dept_id
    and d.dept_title ='기술지원부';

select
    emp_name 이름,
    dept_code 부서코드,
    salary 급여
from
    employee
where
    dept_code = (select dept_id from department where dept_title ='기술지원부');


-- 문제2
-- 기술지원부에 속한 사람들 중 가장 연봉이 높은 사람의 이름,부서코드,급여를 출력하시오
select
    emp_name 이름,
    dept_code 부서코드,
    (salary + salary * ifnull(bonus, 0)) * 12 연봉
from
    employee
where
    quit_yn = 'n'
    and dept_code = (select dept_id from department where dept_title ='기술지원부')
order by
    연봉 desc
limit
    1;


-- 문제3
-- 매니저가 있는 사원중에 월급이 전체사원 평균을 넘는
-- 사번,이름,매니저이름, 월급을 구하시오. 
-- 1. JOIN을 이용하시오
-- 2. JOIN하지 않고, 스칼라상관쿼리(SELECT)를 이용하기

-- JOIN
select
    a.emp_id 사번,
    a.emp_name 이름,
    b.emp_name 매니져이름,
    a.salary 월급
from
    employee a join employee b
        on a.manager_id = b.emp_id
where
    a.salary > (select avg(salary) from employee);

-- 스칼라서브쿼리(SELECT)
select
    emp_id 사번,
    emp_name 이름,
    (select emp_name from employee where emp_id = e.manager_id) 매니져이름,
    salary 월급
from
    employee e
where
    manager_id is not null
  and
    salary > (select avg(salary) from employee);


-- 문제4
-- 같은 직급의 평균급여보다 같거나 많은 급여를 받는 직원의 이름, 직급코드, 급여, 급여등급 조회
select
    *
from
    employee e
where
    salary >= (
        select
            avg(salary)
        from
            employee
        where
            e.job_code = job_code
    );

-- 문제5
-- 부서별 평균 급여가 3000000 이상인 부서명, 평균 급여 조회
-- 단, 평균 급여는 소수점 버림, 부서명이 없는 경우 '인턴'처리

select
    ifnull((select dept_title from department where dept_id = e.dept_code), '인턴') 부서명,
    format(truncate(avg(salary), 0), 0) 평균급여
from
    employee e
group by
    dept_code
having
    avg(salary) >= 3000000;



-- 문제6
-- 같은 직급의 연봉 평균보다 적게 받는 여자사원의 -- > where
-- 사원명,직급명,부서명,연봉을                  -- > select
-- 이름 오름차순으로 조회하시오                  -- > order by
-- 연봉 계산 => (급여 + (급여 * 보너스)) * 12

--  1. 직급별 연봉평균 inline view와 employee 조인
--  2. 상관subquery
--  3. window함수

select
    *
from (
     select
         emp_name,
         ifnull((select dept_title from department where dept_id = E.dept_code), '인턴') dept_title,
         job_code,
         (select job_name from job where job_code = E.job_code) job_name,
         (salary + salary * ifnull(bonus, 0)) * 12 annual_salary,
         if(substr(emp_no,8,1) in ('2','4'),'여','남') gender
     from
         employee E
     ) E
where
    gender = '여'
  and
    annual_salary < (
        select avg((salary + salary * ifnull(bonus, 0)) * 12)
        from employee
        where job_code = E.job_code
    )
order by
    emp_name;

--  with : inline view를 별칭으로 참조
with my_emp
as (
 select
     emp_name,
     ifnull((select dept_title from department where dept_id = E.dept_code), '인턴') dept_title,
     job_code,
     (select job_name from job where job_code = E.job_code) job_name,
     (salary + salary * ifnull(bonus, 0)) * 12 annual_salary,
     if(substr(emp_no,8,1) in ('2','4'),'여','남') gender
 from
     employee E
)
select
    *
from
    my_emp E
where
    gender = '여'
  and
    annual_salary < (
        select avg((salary + salary * ifnull(bonus, 0)) * 12)
        from employee
        where job_code = E.job_code
    )
order by
    emp_name;

-- window function 사용
with my_emp
as
(
    select 
        emp_name,
        ifnull((select dept_title from department where dept_id = E.dept_code), '인턴') dept_title, 
        (select job_name from job where job_code = E.job_code) job_name,
        (salary + salary * ifnull(bonus, 0)) * 12 annual_salary,
        if(substr(emp_no,8,1) in ('2','4'),'여','남') gender,
        avg((salary + salary * ifnull(bonus, 0)) * 12) over(partition by job_code) avg_annual_salary_by_job_code
    from 
        employee E
)
select
    *
from
    my_emp E
where
    gender = '여'
  and
    annual_salary < avg_annual_salary_by_job_code
order by
    emp_name;


-- 문제7
-- 다음 도서목록테이블을 생성하고, 공저인 도서만 출력하세요.
create table tbl_books (
   book_title varchar(50),
   author varchar(50),
   loyalty int(5)
);
start transaction;
insert into tbl_books values ('반지나라 해리포터', '박나라', 200);
insert into tbl_books values ('대화가 필요해', '선동일', 500);
insert into tbl_books values ('나무', '임시환', 300);
insert into tbl_books values ('별의 하루', '송종기', 200);
insert into tbl_books values ('별의 하루', '윤은해', 400);
insert into tbl_books values ('개미', '장쯔위', 100);
insert into tbl_books values ('아지랑이 피우기', '이오리', 200);
insert into tbl_books values ('아지랑이 피우기', '전지연', 100);
insert into tbl_books values ('삼국지', '노옹철', 200);
insert into tbl_books values ('별의 하루', '대북혼', 300);
commit;
select * from tbl_books;

-- 7.1.상관서브쿼리 사용
select
    *
from
    tbl_books A
where
    book_title in (
        select
            book_title
        from
            tbl_books B
        where
            book_title = A.book_title
            and author != A.author
    );

-- 7.2.group by, having, count(*)
select
    book_title,
    count(*)
from
    tbl_books
group by
    book_title
having
    count(*) > 1;

-- 7.3.상관서브쿼리와 exists( ) 사용
select
    *
from
    tbl_books A
where
    exists (
        select
            1
        from
            tbl_books B
        where
            book_title = A.book_title
            and author != A.author);

-- 7.4.조인 사용
select
    distinct  a.book_title
from
    tbl_books A join tbl_books B
        on A.book_title = B.book_title and A.author != B.author;

-- 8.
create table tbl_hierarchy_menu(
   no int primary key,
   menu_name varchar(100),
   parent_no int
);
-- drop table tbl_menu;
start transaction;
insert into tbl_hierarchy_menu values(1, '주메뉴1', null);
insert into tbl_hierarchy_menu values(2, '주메뉴2', null);
insert into tbl_hierarchy_menu values(3, '주메뉴3', null);
insert into tbl_hierarchy_menu values(11, '서브메뉴1-A', 1);
insert into tbl_hierarchy_menu values(12, '서브메뉴1-B', 1);
insert into tbl_hierarchy_menu values(21, '서브메뉴2-A', 2);
insert into tbl_hierarchy_menu values(31, '서브메뉴3-A', 3);
insert into tbl_hierarchy_menu values(32, '서브메뉴3-B', 3);
insert into tbl_hierarchy_menu values(111, '상세메뉴1-A-가', 11);
insert into tbl_hierarchy_menu values(112, '상세메뉴1-A-나', 11);
insert into tbl_hierarchy_menu values(121, '상세메뉴1-B-가', 12);
insert into tbl_hierarchy_menu values(211, '상세메뉴2-A-가', 21);
insert into tbl_hierarchy_menu values(311, '상세메뉴3-A-가', 31);
insert into tbl_hierarchy_menu values(321, '상세메뉴3-B-가', 32);

select * from tbl_hierarchy_menu;

WITH RECURSIVE view_hierarchy_menu(no, menu_name, level, path) as (
    select
        no,
        menu_name,
        0 level,
        cast(no as char(200)) path
    from
        tbl_hierarchy_menu
    where
        parent_no is null
    union all
    select
        t.no,
        t.menu_name,
        v.level + 1,
        CONCAT(v.path, ' > ', t.no)
    from
        view_hierarchy_menu v
            join tbl_hierarchy_menu t
                 on v.no = t.parent_no
)
select
    concat(space(level * 5), menu_name) menu_name
from
    view_hierarchy_menu
order by
    path;