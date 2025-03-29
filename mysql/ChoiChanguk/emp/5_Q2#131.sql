select *
from employee;

select @@lc_time_names;
set @@lc_time_names='ko_KR';

# 1. 2020년 12월 25일이 무슨 요일인지 조회하시오.
select
    CASE DAYOFWEEK('2020-12-25')
WHEN 1 THEN '월요일'
WHEN 2 THEN '화요일'
WHEN 3 THEN '수요일'
WHEN 4 THEN '목요일'
WHEN 5 THEN '금요일'
WHEN 6 THEN '토요일'
WHEN 7 THEN '일요일'
END AS 요일;

# 2. 주민번호가 1970년대생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.
SELECT EMP_NAME AS 사원명,EMP_NO AS 주민번호, JOB_CODE AS 부서명, MANAGER_ID AS 직급명
FROM employee
WHERE SUBSTRING(EMP_NO,8,1 ) IN (3,4) && SUBSTRING(EMP_NO,1,2 ) BETWEEN 70 AND 79 && SUBSTRING(EMP_NAME,1,1)='전';

# 3. 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오.
SELECT *
FROM employee
where substring(EMP_NO,8,1) in ('3','4')
order by  EMP_NO desc limit 1;

# 4. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
select EMP_ID as 사번,EMP_NAME as 이름,JOB_CODE as 부서명
from employee
where substring(EMP_NAME,1,3) like '%형%';

# 5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.

SELECT EMP_NAME as 사원명, MANAGER_ID as 직급명 , DEPT_CODE as 부서코드, JOB_CODE as 부서명
FROM employee e left join department d on d.DEPT_ID = e.DEPT_CODE
left join location l on d.LOCATION_ID = l.LOCAL_CODE
where NATIONAL_CODE not like 'KO';

# 6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
select distinct EMP_NAME as 사원명, BONUS, DEPT_TITLE as 부서명, LOCAL_NAME as 근무지역
from employee e left join department d on e.DEPT_CODE = d.DEPT_ID left join location l on d.LOCATION_ID = l.LOCAL_CODE
where BONUS is not null;

# 7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오
select EMP_NAME as 사원명,JOB_NAME as 직급명 , DEPT_TITLE as 부서명, LOCAL_NAME as 근무지
from
    employee e left join department d
    on e.DEPT_CODE = d.DEPT_ID
left join location l
    on d.LOCATION_ID = l.LOCAL_CODE
left join job j on e.JOB_CODE=j.JOB_CODE;

# 8. 급여등급테이블 sal_grade의 등급별 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
select EMP_NAME as 사원명, JOB_NAME as 직급명, SALARY as 급여, (SALARY + SALARY * ifnull(BONUS,0))*12 as 연봉
from
    sal_grade s
         join employee e
                   on s.SAL_LEVEL = e.SAL_LEVEL
          join job j
                   on e.JOB_CODE = j.JOB_CODE

where SALARY + SALARY * ifnull(BONUS,0) > MAX_SAL;

# 9. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.
select EMP_NAME as 이름, JOB_NAME as 부서명, LOCAL_NAME as 지역명, NATIONAL_CODE as 국가명
from employee e
        left join job j
              on e.JOB_CODE = j.JOB_CODE
join department d on e.DEPT_CODE = d.DEPT_ID
join location l on d.LOCATION_ID = l.LOCAL_CODE
where NATIONAL_CODE in ('KO','JP');

# 10. 같은 부서에 근무하는 직원들의 사원명, 부서명, 동료이름을 조회하시오. (self join 사용)
select e1.EMP_NAME as 직원 ,e1.DEPT_CODE as 부서명, e2.EMP_NAME as 동료
from employee e1 inner join employee e2
on e1.DEPT_CODE = e2.DEPT_CODE && e1.EMP_ID != e2.EMP_ID;

#.11 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오.
# 단, join과 in 연산자 사용할 것
select EMP_NAME as 사원명, JOB_NAME as 직급명, SALARY as 급여
from
    employee e join job j
on e.JOB_CODE = j.JOB_CODE
where BONUS is null && JOB_NAME in ('차장','사원');

# 12. 재직중인 직원과 퇴사한 직원의 수를 조회하시오.
select count(if(QUIT_YN='N',1,NULL)) AS 재직,count(if(QUIT_YN='y',1,NULL)) AS 퇴사
from employee;

select *
from employee;

select *
from location;

select *
from department





