-- ================================
-- STORED VIEW
-- ================================
-- 하나 이상의 테이블에서 원하는 데이터를 질의해서 만든 가상테이블
-- 다른 테이블의 데이터를 보여줄뿐, 실제 데이터를 가지고 있는 것은 아니다.
-- 실제로는 inline-view를 저장한 db객체
-- 테이블 데이터를 확장 또는 제한한 뷰를 만들어 사용할 수 있다.

-- 한식뷰를 만들어서 쉽게 접근
create view view_menu_korean
as
select *
from tbl_menu
where category_code =4;

-- 테이블처럼 사용
select *
from view_menu_korean;

-- 실제 데이터가 변경된다면?
insert into tbl_menu
values (null, '식혜맛국밥', 8000, 4, 'Y');

select *
from tbl_menu;


select  *
from view_menu_korean;

-- view 조회
select
    *
from
    information_schema.views; -- view_definition : create view ddl에 사용된 서브쿼리

select * from (select `menudb`.`tbl_menu`.`menu_code` AS `menu_code`,`menudb`.`tbl_menu`.`menu_name` AS `menu_name`,`menudb`.`tbl_menu`.`menu_price` AS `menu_price`,`menudb`.`tbl_menu`.`category_code` AS `category_code`,`menudb`.`tbl_menu`.`orderable_status` AS `orderable_status` from `menudb`.`tbl_menu` where (`menudb`.`tbl_menu`.`category_code` = 4)) v;

# view를 통한 DML처리
-- view 생성시에 그룹함수, distinct, group by를 사용하지 않은 경우에 한해서 DML 사용가능

-- insert
insert into view_menu_korean
values (null, '수정과맛국밥', 5500, 4, 'Y');

select * from view_menu_korean;
select * from tbl_menu;

-- update
update
    view_menu_korean
set menu_price = menu_price + 1000
where menu_code = 102;

-- delete
delete
from view_menu_korean
where menu_code = 102;


select * from view_menu_korean;

# view를 통해 매번 처리해야 하는 복잡한 연산을 저장
-- or replace 없으면 create, 존재하면 replace 처리
create view view_menu_korean2
as
select menu_code,
       menu_name,
       menu_price,
       truncate(menu_price*1.1, 0) menu_sale_price,
       (select category_name from tbl_category where category_code = m.category_code) category_name
from tbl_menu m
where category_code = 4;

select * from view_menu_korean2
order by menu_sale_price desc
limit  3;

-- empdb.employee를 기준으로 일반사원정보 조회하는 뷰 view_emp
-- (사번, 사원명, 전화번호, 이메일, 직급명, 부서명)
drop view view_emp;
create or replace view view_emp
as
select emp_id,
       emp_name,
       PHONE,
       EMAIL,
       (select JOB_NAME from job where JOB_CODE = e.JOB_CODE) job_name,
       IFNULL((select DEPT_TITLE from department where DEPT_ID= e.DEPT_CODE), '없음') dept_title
from employee e;

select * from view_emp;

-- qwerty에게 empdb.view_emp select권한 부여
-- (root 계정)
grant select on view_emp to 'qwerty'@'%';


-- (qwerty 계정)
select *
from view_emp;

-- [42000][1142] SELECT command denied to user 'qwerty'@'localhost' for table 'employee'
select * from employee;










