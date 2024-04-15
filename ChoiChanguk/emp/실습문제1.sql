# 1. root관리자 계정으로 empdb 데이터베이스를 생성하고,  sh 사용자에게 모든 사용권한을 부여합니다.

create schema empdb;
create user 'sh'@'%' identified by 'sh';
grant all privileges on empdb.* to 'sh'@'%'; # 권한부여
show grants for 'sh'@'%'; # 권한 부여확인
show databases;
use empdb;

select * from employee; -- 사원테이블
select * from job; -- 직급테이블
select * from department; -- 부서테이블
select * from location; -- 지역테이블
select * from nation; -- 국가테이블
select * from sal_grade; -- 급여등급테이블

# 1. EMPLOYEE 테이블에서 이름 끝이 연으로 끝나는 사원의 이름을 출력하시오.;
select EMP_NAME
from employee
where EMP_NAME LIKE '%연';

# 2. EMPLOYEE 테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호를 출력하시오.
SELECT EMP_NAME,PHONE
FROM employee
WHERE PHONE NOT LIKE '010%';

# 3. EMPLOYEE 테이블에서 메일주소 '_'의 앞이 4자이면서, DEPT_CODE가 D9 또는 D5이고 고용일이 90/01/01 ~ 01/12/31이면서,
# 월급이 270만원 이상인 사원의 전체 정보를 출력하시오.
SELECT *
FROM employee
WHERE
    EMAIL LIKE '____%' AND (DEPT_CODE = 'D9' || DEPT_CODE = 'D5')
AND HIRE_DATE BETWEEN '1990-01-01' AND '2001-12-31' && SALARY >=2700000;

# 4. tbl_escape_watch 테이블에서 description 컬럼에 99.99% 라는 글자가 들어있는 행만 추출하세요.
SELECT *
FROM tbl_escape_watch
WHERE description LIKE '%99.99\%%';
create table tbl_escape_watch (
                                  watch_name varchar(100)
    ,description varchar(1000)
);
-- drop table tbl_escape_watch;
insert into tbl_escape_watch values('금시계', '순금 99.99% 함유 고급시계');
insert into tbl_escape_watch values('은시계', '고객 만족도 99.99점를 획득한 고급시계');
commit;
select * from tbl_escape_watch;

# 5. EMPLOYEE 테이블에서 현재 근무중인 사원을 이름 오름차순으로 정렬해서 출력하세요.
SELECT EMP_NAME
FROM employee
WHERE QUIT_YN = 'y'
ORDER BY EMP_NAME;

# 6. 사원별 입사일, 퇴사일, 근무기간을 조회하세요. 퇴사자 역시 조회되어야 합니다.
SELECT
    EMP_NAME,
    HIRE_DATE as '입사일',
    ifnull(QUIT_DATE,'근무중') as '퇴사일',
    concat(TIMESTAMPDIFF(day ,HIRE_DATE,ifnull(QUIT_DATE,now())),'일') as '근무기간'
FROM employee;