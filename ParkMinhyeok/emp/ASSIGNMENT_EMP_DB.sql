create database empdb;
grant all privileges on empdb.* to 'sh'@'%';
show grants for 'sh'@'%';

use empdb;

select * from employee; -- 사원테이블
select * from job; -- 직급테이블
select * from department; -- 부서테이블
select * from location; -- 지역테이블
select * from nation; -- 국가테이블
select * from sal_grade; -- 급여등급테이블

-- 1. EMPLOYEE 테이블에서 이름 끝이 `연`으로 끝나는 사원의 이름을 출력하시오.
select EMPLOYEE.EMP_NAME
from EMPLOYEE
where EMP_NAME like '%연';

-- 2.EMPLOYEE 테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호를 출력하시오.
select EMP_NAME, PHONE
from EMPLOYEE
where PHONE not like '010%';

-- 3.EMPLOYEE 테이블에서 메일주소 '_'의 앞이 4자이면서, DEPT_CODE가 D9 또는 D5이고 고용일이 90/01/01 ~ 01/12/31이면서, 월급이 270만원 이상인 사원의 전체 정보를 출력하시오.
select *
from EMPLOYEE
where EMAIL like '____\_%' and (DEPT_CODE = 'D9' or DEPT_CODE = 'D5') and (HIRE_DATE between '1990-01-01' and '2001-12-31') and SALARY >= 2700000;

-- 4.tbl_escape_watch 테이블에서 description 컬럼에 99.99% 라는 글자가 들어있는 행만 추출하세요
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

select *
from tbl_escape_watch
where description like '%99.99\%%';

-- 5.EMPLOYEE 테이블에서 현재 근무중인 사원을 이름 오름차순으로 정렬해서 출력하세요.
select EMP_NAME, QUIT_YN
from EMPLOYEE
where QUIT_YN != 'Y'
order by EMP_NAME;

-- 6.사원별 입사일, 퇴사일, 근무기간을 조회하세요. 퇴사자 역시 조회되어야 합니다.
select EMP_NAME, HIRE_DATE, QUIT_DATE,
       datediff(ifnull(QUIT_DATE, now()), HIRE_DATE) as "WORKING_PERIOD"
from EMPLOYEE;
