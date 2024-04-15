select * from employee; -- 사원테이블
-- 사원아이디, 사원네임, 사원번호, 사원이메일,사원연락처, 사원부서코드, 사원직급코드, ...
select * from job; -- 직급테이블
-- 직급코드, 직급명
select * from department; -- 부서테이블
-- 부서아이디, 부서이름, 지역아이디
select * from location; -- 지역테이블
-- 지역코드, 국가코드, 지역이름
select * from nation; -- 국가테이블
-- 국가코드, 국가이름
select * from sal_grade; -- 급여등급테이블
-- 급여등급, 최소급여, 최대급여

# 1. EMPLOYEE 테이블에서 이름 끝이 연으로 끝나는 사원의 이름을 출력하시오.
select EMP_NAME
from employee
where EMP_NAME like '%연';

# 2. EMPLOYEE 테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호를 출력하시오.
select EMP_NAME, PHONE
from employee
where PHONE not like '010%';

# 3. EMPLOYEE 테이블에서 메일주소 '_'의 앞이 4자이면서, DEPT_CODE가 D9 또는 D5이고 고용일이 90/01/01 ~ 01/12/31이면서, 월급이 270만원 이상인 사원의 전체 정보를 출력하시오.
select *
from employee
where
    EMAIL like '____\_%' ESCAPE '\\'
        and (DEPT_CODE = 'D9' or DEPT_CODE = 'D5')
        and HIRE_DATE between DATE('90/01/01') and DATE('01/12/31')
        and SALARY >= 2700000;

# 4. tbl_escape_watch 테이블에서 description 컬럼에 99.99% 라는 글자가 들어있는 행만 추출하세요.
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
where description like '%99.99\%%' ESCAPE '\\';

# 5. EMPLOYEE 테이블에서 현재 근무중인 사원을 이름 오름차순으로 정렬해서 출력하세요.
select *
from employee
where QUIT_DATE is null
order by EMP_NAME ASC ;

# 6. 사원별 입사일, 퇴사일, 근무기간을 조회하세요. 퇴사자 역시 조회되어야 합니다.
select HIRE_DATE, QUIT_DATE, IF(QUIT_DATE is null, DATEDIFF(now(),HIRE_DATE), DATEDIFF(QUIT_DATE,HIRE_DATE)) AS WORK_DAYS
from employee;