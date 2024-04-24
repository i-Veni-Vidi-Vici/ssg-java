use empdb;

-- 1. 2020년 12월 25일이 무슨 요일인지 조회하시오.
select @@lc_time_names;
set @@lc_time_names = 'ko_KR';
select date_format('2020/12/25', '%W') 요일;

-- a. 주민번호가 1970년대생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.
select e.EMP_NAME 사원명, e.EMP_NO 주민번호, d.DEPT_TITLE 부서명, j.JOB_NAME 직급명
from employee e join department d on e.DEPT_CODE = d.DEPT_ID
                join job j using (JOB_CODE)
where substring(e.EMP_NO, 1, 1) = '7' and substring(e.EMP_NO, 8, 1) = '2' and e.EMP_NAME like '전%';

-- 2. 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오.
select e.EMP_ID 사번, e.EMP_NAME 사원명,
       year(now()) - concat(if(substring(e.EMP_NO, 8, 1) in ('1', '2'), '19', '20'), left(e.EMP_NO, 2))
           - if(substring(e.EMP_NO, 3, 2) <= month(now()) and substring(e.EMP_NO, 5, 2) <= day(now()), 0, 1) 나이,
       d.DEPT_TITLE 부서명, j.JOB_NAME 직급명
from employee e join department d on e.DEPT_CODE = d.DEPT_ID
                join job j using (JOB_CODE)
order by 나이
limit 1;


-- 3. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
select e.EMP_ID 사번, e.EMP_NAME 사원명, d.DEPT_TITLE 부서명
from employee e join department d on e.DEPT_CODE = d.DEPT_ID
where e.EMP_NAME like '%형%';

-- 4. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.
select e.EMP_NAME 사원명, j.JOB_NAME 직급명, e.DEPT_CODE 부서코드, d.DEPT_TITLE 부서명
from employee e join department d on e.DEPT_CODE = d.DEPT_ID
                join job j using (JOB_CODE)
where d.DEPT_TITLE like '해외영업_부'
order by 부서명, 사원명;

-- 5. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
select e.EMP_NAME 사원명, e.BONUS 보너스포인트, d.DEPT_TITLE 부서명, l.LOCAL_NAME 근무지역명
from employee e left join department d on e.DEPT_CODE = d.DEPT_ID
                left join location l on d.LOCATION_ID = l.LOCAL_CODE
where e.BONUS is not null
order by 사원명;

-- 6. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.
select e.EMP_NAME 사원명, j.JOB_NAME 직급명, d.DEPT_TITLE 부서명, l.LOCAL_NAME 근무지역명
from employee e join department d on e.DEPT_CODE = d.DEPT_ID
                join job j using (JOB_CODE)
                join location l on d.LOCATION_ID = l.LOCAL_CODE
where e.DEPT_CODE = 'D2'
order by 사원명;

-- 7. 급여등급테이블 sal_grade의 등급별 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
-- 사원테이블과 급여등급테이블을 SAL_LEVEL컬럼기준으로 동등(등가) 조인할 것
select e.EMP_NAME 사원명, j.JOB_NAME 직급명, e.SAL_LEVEL 급여등급, format(e.SALARY, 0) 급여, format((e.SALARY + e.SALARY * ifnull(e.BONUS, 0) ) * 12, 0) 연봉
from employee e join sal_grade s using (SAL_LEVEL) join job j using (JOB_CODE)
where e.SALARY > s.MAX_SAL;

-- 8. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.
select e.EMP_NAME 사원명, d.DEPT_TITLE 부서명, l.LOCAL_NAME 지역명, n.NATIONAL_NAME 국가명
from employee e left join department d on e.DEPT_CODE = d.DEPT_ID
                left join location l on d.LOCATION_ID = l.LOCAL_CODE
                left join nation n using (NATIONAL_CODE)
where n.NATIONAL_CODE = 'KO' or n.NATIONAL_CODE = 'JP'
order by 국가명;

-- 9. 같은 부서에 근무하는 직원들의 사원명, 부서명, 동료이름을 조회하시오. (self join 사용)
select distinct e.EMP_NAME 사원명, d.DEPT_TITLE 부서명, co.EMP_NAME 동료명
from employee e join department d on e.DEPT_CODE = d.DEPT_ID
                join employee co using (DEPT_CODE)
where e.EMP_NAME != co.EMP_NAME
order by 사원명, 동료명;

-- 10. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오. 단, join과 in 연산자 사용할 것
select e.EMP_NAME 사원명, j.JOB_NAME 직급명, format(e.SALARY, 0) 급여
from employee e join job j using (JOB_CODE)
where e.BONUS is null and j.JOB_NAME in ('차장', '사원')
order by 직급명 desc, 사원명;

-- 11. 재직중인 직원과 퇴사한 직원의 수를 조회하시오.
select if(QUIT_YN = 'N', '재직', '퇴사') 재직여부, count(*) 직원수
from employee
group by QUIT_YN;