select * from employee; -- 사원테이블
select * from job; -- 직급테이블
select * from department; -- 부서테이블
select * from location; -- 지역테이블
select * from nation; -- 국가테이블
select * from sal_grade; -- 급여등급테이블
-- ----------------------------------------------------------------------
-- 1. 기술지원부에 속한 사람들의 사람의 이름,부서코드,급여를 출력하시오
select EMP_NAME 이름,
       DEPT_CODE 부서코드,
       SALARY 급여
from employee e left join department d on e.DEPT_CODE = d.DEPT_ID
where DEPT_TITLE = '기술지원부';

-- 2. 기술지원부에 속한 사람들 중 가장 연봉이 높은 사람의 이름,부서코드,급여를 출력하시오
select EMP_NAME 이름,
       DEPT_CODE 부서코드,
       SALARY 급여
from employee e join department d on e.DEPT_CODE = d.DEPT_ID
where d.DEPT_TITLE = '기술지원부'
order by if(isnull(e.BONUS),SALARY * 12 , (SALARY + (SALARY * BONUS)) * 12) desc
limit 1;

-- 3. 매니저가 있는 사원중에 월급이 전체사원 평균보다 많은 사원의 사번,이름,매니저 이름, 월급을 구하시오.
 -- a. JOIN을 이용하시오
select e1.EMP_ID 사번,
       e1.EMP_NAME 이름,
       e2.EMP_NAME '매니저 이름',
       e1.SALARY 월급
from employee e1 left join employee e2 on e1.MANAGER_ID = e2.EMP_ID
where not isnull(e1.MANAGER_ID) and e1.SALARY > (select avg(SALARY)
                                                 from employee);

 -- b. JOIN하지 않고, 스칼라상관쿼리(SELECT)를 이용하기
select *
from employee e
where not isnull(MANAGER_ID) and MANAGER_ID in (select EMP_ID from employee);

-- 4. 같은 직급의 평균급여보다 같거나 많은 급여를 받는 직원의 이름, 직급코드, 급여, 급여등급 조회
with avg_salary
    as (select JOB_CODE,
               avg(SALARY) 평균급여
        from employee
        group by JOB_CODE)
select EMP_NAME 이름,
       e.JOB_CODE 직급코드,
       SALARY 급여,
       SAL_LEVEL 급여등급
from employee e join avg_salary s on e.JOB_CODE = s.JOB_CODE
where e.SALARY > 평균급여;

-- 5. 부서별 평균 급여가 3000000 이상인 부서명, 평균 급여 조회
-- 단, 평균 급여는 소수점 버림, 부서명이 없는 경우 '인턴'처리
with dept_avg_salary
    as (select
            ifnull(DEPT_TITLE, '인턴') 부서명,
               truncate(avg(SALARY), 0) 평균급여

        from employee e left join department d on e.DEPT_CODE = d.DEPT_ID
        group by DEPT_CODE)
select *
from dept_avg_salary
where 평균급여 >= 3000000 ;

-- 6. 직급의 연봉 평균보다 적게 받는 여자사원의 사원명,직급명,부서명,연봉을 이름 오름차순으로 조회하시오
with job_avg
    as (select JOB_CODE,
               avg(if(isnull(BONUS),SALARY * 12 , (SALARY + (SALARY * BONUS)) * 12)) 연봉평균
        from employee
        group by JOB_CODE)
select e.EMP_NAME 사원명,
       j.JOB_NAME 직급명,
       d.DEPT_TITLE 부서명,
       if(isnull(BONUS),SALARY * 12 , (SALARY + (SALARY * BONUS)) * 12) 연봉
from employee e left join job j on e.JOB_CODE = j.JOB_CODE left join department d on e.DEPT_CODE = d.DEPT_ID left join job_avg ja on e.JOB_CODE = ja.JOB_CODE
where substring(EMP_NO, 8, 1) in (2, 4) and if(isnull(BONUS),SALARY * 12 , (SALARY + (SALARY * BONUS)) * 12) < ja.연봉평균
order by 1;

-- 7. 다음 도서목록테이블을 생성하고, 공저인 도서만 출력하세요.
-- (공저 : 두명이상의 작가가 함께 쓴 도서)
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
-- ---------------------------------------------------------
select distinct
    b1.book_title 공저도서
from tbl_books b1 join tbl_books b2 on b1.book_title = b2.book_title
where b1.book_title = b2.book_title and b1.author != b2.author;

-- 8. 다음 계층형 메뉴 데이터를 생성하고, 다음과 같이 출력하세요.
create table tbl_hierarchy_menu(
                                   no int primary key,
                                   menu_name varchar(100),
                                   parent_no int
);
-- drop table tbl_hierarchy_menu;
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