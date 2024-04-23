use empdb;
# 1. 기술지원부에 속한 사람들의 사람의 이름,부서코드,급여를 출력하시오
select
    EMP_NAME 이름,
    DEPT_CODE 부서코드,
    SALARY 급여
from
    employee
where
    DEPT_CODE = (select DEPT_ID
                 from department
                 where DEPT_TITLE = '기술지원부');

# 2. 기술지원부에 속한 사람들 중 가장 연봉이 높은 사람의 이름,부서코드,급여를 출력하시오
-- 기술지원부 = D8

select
    EMP_NAME 이름,
    DEPT_CODE 부서코드,
    SALARY 급여
from
    employee
where
    DEPT_CODE = (select DEPT_ID
                 from department
                 where DEPT_TITLE = '기술지원부')
    and SALARY = (select max(SALARY)
                  from employee
                  where DEPT_CODE = 'D8'
                  group by DEPT_CODE)


# 3. 매니저가 있는 사원중에 월급이 전체사원 평균보다 많은 사원의 사번,이름,매니저 이름, 월급을 구하시오.
#     1. JOIN을 이용하시오
#     2. JOIN하지 않고, 스칼라상관쿼리(SELECT)를 이용하기
-- 1번
select
    e.EMP_ID ID,
    e.EMP_NAME 이름,
    m.EMP_NAME 매니저이름,
    e.SALARY 월급
from
    employee e join employee m on e.MANAGER_ID = m.EMP_ID
where
    e.MANAGER_ID is not null
    and e.SALARY > (select avg(SALARY) from employee);

-- 2번
select
    e.EMP_ID ID,
    e.EMP_NAME 이름,
    (select EMP_NAME from employee where EMP_ID = e.MANAGER_ID ) 매니저이름,
    e.SALARY 월급
from
    employee e
where
    MANAGER_ID is not null
  and SALARY > (select avg(SALARY) from employee);

# 4. 같은 직급의 평균급여보다 같거나 많은 급여를 받는 직원의 이름, 직급코드, 급여, 급여등급 조회
select
    e.EMP_NAME 이름,
    e.JOB_CODE 직급코드,
    e.SALARY 급여,
    e.SAL_LEVEL 급여등급
from
    employee e
where
    SALARY >= (select avg(SALARY) from employee where JOB_CODE = e.JOB_CODE group by JOB_CODE)

# 5. 부서별 평균 급여가 3000000 이상인 부서명, 평균 급여 조회
# 단, 평균 급여는 소수점 버림, 부서명이 없는 경우 '인턴'처리
select
    DEPT_TITLE 부서명,
    truncate(t1.avgsal,0) 평균급여
from
    department d join (select DEPT_CODE , avg(SALARY) avgsal
                       from employee
                       group by DEPT_CODE
                       having avg(SALARY) > 3000000) t1
        on d.DEPT_ID = t1.DEPT_CODE;

# 6. 직급의 연봉 평균보다 적게 받는 여자사원의 사원명,직급명,부서명,연봉을 이름 오름차순으로 조회하시오
# `연봉 계산 : (급여 + (급여 * 보너스)) * 12`

select
    e.EMP_NAME 사원명,
    (select JOB_NAME from job where job_code = e.job_code) 직급,
    (select DEPT_TITLE from department where e.DEPT_CODE = DEPT_ID) 부서,
    (e.SALARY + (e.SALARY * ifnull(e.BONUS, 0)))*12 연봉
from
    employee e
where
    (SALARY + (SALARY * ifnull(BONUS, 0)))*12 < (select avg((SALARY + (SALARY * ifnull(e.BONUS, 0)))*12 ) from employee where e.JOB_CODE = JOB_CODE group by JOB_CODE)
    and substring(e.EMP_NO, 8, 1) in (2, 4)
order by EMP_NAME;

# 7. 다음 도서목록테이블을 생성하고, 공저인 도서만 출력하세요.
#     (공저 : 두명이상의 작가가 함께 쓴 도서)
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
    book_title 제목,
    count(*) 저자수
from
    tbl_books
group by
    book_title
having
    count(*) > 1;

# 8.다음 계층형 메뉴 데이터를 생성하고, 다음과 같이 출력하세요.
create table tbl_hierarchy_menu(
                                   no int primary key,
                                   menu_name varchar(100),
                                   parent_no int
);
-- drop table tbl_hierarchy_menu;
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

show tables;

with recursive menu_hierarchy(no, menu_name, level, path)
                    as(
        select
            no,
            menu_name,
            1 level,
            cast(no as char(100)) path
        from
            tbl_hierarchy_menu
        where
            parent_no is null
        union all
        select
            m.no,
            m.menu_name,
            mh.level +1,
            concat(mh.path, '>', m.no)
        from
            tbl_hierarchy_menu m join menu_hierarchy mh
                on m.parent_no = mh.no
    )
select
    concat(space((level-1)*5),menu_name)
from
    menu_hierarchy
order by path