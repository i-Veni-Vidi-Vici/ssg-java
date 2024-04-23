-- 1. 기술지원부에 속한 사람들의 사람의 이름,부서코드,급여를 출력하시오 - 🆗
select
    EMP_NAME,
    DEPT_CODE,
    SALARY
from
    employee
where
    DEPT_CODE = (select
                     DEPT_ID
                 from
                     department
                 where
                     DEPT_TITLE = '기술지원부');


-- 2. 기술지원부에 속한 사람들 중 가장 연봉이 높은 사람의 이름,부서코드,급여를 출력하시오 - 🆗
select
    EMP_NAME,
    DEPT_CODE,
    SALARY
from
    employee
where
    DEPT_CODE = (select
                     DEPT_ID
                 from
                     department
                 where
                     DEPT_TITLE = '기술지원부')
order by
    SALARY desc
limit
    1;

-- 3. 매니저가 있는 사원중에 월급이 전체사원 평균보다 많은 사원의 사번,이름,매니저 이름, 월급을 구하시오.
   -- 1. JOIN을 이용하시오
select
    E.EMP_ID,
    E.EMP_NAME,
    M.EMP_NAME,
    E.SALARY
from
    employee E join employee M
        on E.MANAGER_ID = M.EMP_ID
where
    E.SALARY > (select
                     avg(SALARY)
                 from employee)
order by
    M.EMP_NAME,
    E.EMP_NAME;

   -- 2. JOIN하지 않고, 스칼라상관쿼리(SELECT)를 이용하기
select
    EMP_ID,
    EMP_NAME,
    EMP_NAME,
    SALARY
from
    employee
where
    SALARY > (select
                     avg(SALARY)
                 from employee)
    and !isnull(MANAGER_ID)
order by
    EMP_NAME;

-- 4. 같은 직급의 평균급여보다 같거나 많은 급여를 받는 직원의 이름, 직급코드, 급여, 급여등급 조회
select
    EMP_NAME,
    JOB_CODE,
    SALARY,
    SAL_LEVEL
from
    employee
where
    SALARY >=
    (select avg(SALARY)
              from employee);



-- 5. 부서별 평균 급여가 3000000 이상인 부서명, 평균 급여 조회 💖💖💖이따가 다시 풀어보기!!💖💖💖
-- 단, 평균 급여는 소수점 버림, 부서명이 없는 경우 '인턴'처리
select
    DEPT_CODE
from
    employee
where
    SALARY >=3000000
group by
    DEPT_CODE;


-- 6. 직급의 연봉 평균보다 적게 받는 여자사원의 사원명,직급명,부서명,연봉을 이름 오름차순으로 조회하시오
-- `연봉 계산 : (급여 + (급여 * 보너스)) * 12`
select
    EMP_NAME,
    J.JOB_NAME,
    D.DEPT_TITLE,
    (SALARY + (SALARY * BONUS)) * 12
from
    employee E
        join job J
            on E.JOB_CODE = J.JOB_CODE
        join department D
            on E.DEPT_CODE = D.DEPT_ID
where
    (substr(EMP_NO, 8, 1) = '2'
   or
    substr(EMP_NO, 8, 1) = '4')
  and
    (SALARY + (SALARY * BONUS)) * 12 < (select
                                            (SALARY + (SALARY * BONUS)) *12
                                        from
                                            employee
                                        group by
                                            JOB_CODE);


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

select
    book_title
from
    tbl_books
group by
    book_title
having
    count(author) > 1;

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
