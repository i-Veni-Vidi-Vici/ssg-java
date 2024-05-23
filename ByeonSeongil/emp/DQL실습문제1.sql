select * from employee; -- 사원테이블
select * from job; -- 직급테이블
select * from department; -- 부서테이블
select * from location; -- 지역테이블
select * from nation; -- 국가테이블
select * from sal_grade; -- 급여등급테이블

-- 1
select EMP_NAME
from employee
where EMP_NAME like '%연';

-- 2
select EMP_NAME, PHONE
from employee
where PHONE not like '010%';

select *
from employee
where EMAIL like '____%' and DEPT_CODE in('D9', 'D5')
and HIRE_DATE between '1990-01-01' and '2001-12-01' and SALARY >=2700000


-- 테이블 및 데이터 등록후 문제풀이
create table tbl_escape_watch (
                                  watch_name varchar(100)
    ,description varchar(1000)
);
-- drop table tbl_escape_watch;
insert into tbl_escape_watch values('금시계', '순금 99.99% 함유 고급시계');
insert into tbl_escape_watch values('은시계', '고객 만족도 99.99점를 획득한 고급시계');
commit;
select * from tbl_escape_watch;

select * from tbl_escape_watch
where description like '%99.99\%%';

select *
from employee
order by EMP_NAME;

select HIRE_DATE, QUIT_DATE,dayofyear (now()-HIRE_DATE)
from employee

