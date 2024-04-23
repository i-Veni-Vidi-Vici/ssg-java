use empdb;

-- 1
select emp_name, dept_code, salary
from employee
where dept_code = (select dept_id from department where dept_title = '기술지원부');

-- 2
select emp_name, dept_code, salary
from employee
where dept_code = (select dept_id from department where dept_title = '기술지원부')
order by salary desc
limit 1;

-- 3
-- a.
select e1.emp_id, e1.emp_name, e2.emp_name, e1.salary
from employee e1 join employee e2 on e1.manager_id = e2.emp_id
where e1.manager_id is not null
  and
    e1.salary > (
    select avg(salary)
    from employee
    );

-- b.
select emp_id, emp_name, (select emp_name from employee where emp_id = e.manager_id), salary
from employee e
where manager_id is not null
  and
    salary > (
        select avg(salary)
        from employee
    );

-- 4
select emp_name, dept_code, salary, sal_level
from employee e
where salary >= (
    select avg(salary)
    from employee
    group by e.dept_code
    );

-- 5
select ifnull((
    select DEPT_TITLE
    from department
    where DEPT_ID = e.DEPT_CODE
    ), '인턴'), round(avg(SALARY),0)
from employee e
where (
    select avg(SALARY)
    from employee
    group by e.DEPT_CODE
) >= 3000000
group by DEPT_CODE;

-- 6
select EMP_NAME,
       (select JOB_NAME from job where JOB_CODE = e.job_code),
       (select dept_title from department where DEPT_ID = e.DEPT_CODE),
       (SALARY + (SALARY * ifnull(BONUS, 0))) * 12 연봉
from employee e
where (SALARY + (SALARY * ifnull(BONUS, 0))) * 12 < (select avg((SALARY + (SALARY * ifnull(BONUS, 0))) * 12) from employee group by e.DEPT_CODE)
and
    mid(EMP_NO, 8, 1) in (2, 4)
order by EMP_NAME

-- 7
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
-- book_title은 같은데 author는 다른 ...
select *
from tbl_books tb
where exists
    (select 1 from tbl_books tb2
            where tb.author != tb2.author
            and tb.book_title = tb2.book_title);

-- 8
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

with recursive menu_hierarchy(no, menu_name, level, path)
                   as (
        select
            no,
            menu_name,
            1 level,
            cast(no as char(100)) -- 첫줄 시작
        from
            tbl_hierarchy_menu
        where
            parent_no is null
        union all
        select thm.no, thm.menu_name, mh.level + 1, concat(mh.path, '>', thm.no)
        from menu_hierarchy mh join tbl_hierarchy_menu thm on mh.no = thm.parent_no
    )
select concat(space((level - 1) * 5), menu_name) menu_name
from menu_hierarchy
order by path;
