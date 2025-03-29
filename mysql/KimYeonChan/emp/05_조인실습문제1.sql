-- 1. 2020년 12월 25일이 무슨 요일인지 조회하시오.
select date_format('2020-12-25', '%a');

-- 2. 주민번호가 1970년대생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.
select EMP_NAME,
       EMP_NO,
       D.DEPT_TITLE,
       J.JOB_NAME
from EMPLOYEE E
         join empdb.DEPARTMENT D on D.DEPT_ID = E.DEPT_CODE
         join empdb.JOB J using (JOB_CODE)
where substring(EMP_NO, 8, 1) in ('2', '4')
  and concat(if(substring(EMP_NO, 8, 1) = '2', '19', '20'), substring(EMP_NO, 1, 2)) between '1970' and '1979'
  and EMP_NAME like '전%';

-- 3. 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오.
select EMP_ID,
       EMP_NAME,
       year(now()) -
       cast(concat(if(substring(EMP_NO, 8, 1) in ('1', '2'), '19', '20'), substring(EMP_NO, 1, 2)) as unsigned) +
       1 as 'AGE',
       d.DEPT_TITLE,
       j.JOB_NAME
from employee e
         join department d on e.DEPT_CODE = d.DEPT_ID
         join job j using (job_code)
order by AGE
limit 1;

-- 4. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
select EMP_ID,
       EMP_NAME,
       DEPT_TITLE
from employee e
         join department d on e.dept_code = d.dept_id
where EMP_NAME like '%형%';

-- 5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.
select E.EMP_NAME,
       J.JOB_NAME,
       D.DEPT_ID,
       D.DEPT_TITLE
from EMPLOYEE E
         left join DEPARTMENT D on E.DEPT_CODE = D.DEPT_ID
         left join JOB J using (JOB_CODE)
where D.LOCATION_ID in ('L2', 'L3');

-- 6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
select E.EMP_NAME,
       E.BONUS,
       D.DEPT_TITLE,
       L.LOCAL_NAME
from EMPLOYEE E
         left join DEPARTMENT D on E.DEPT_CODE = D.DEPT_ID
         left join LOCATION L on D.LOCATION_ID = L.LOCAL_CODE
where E.BONUS is not null;

-- 7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.
select E.EMP_NAME,
       J.JOB_NAME,
       D.DEPT_TITLE,
       L.LOCAL_NAME
from EMPLOYEE E
         left join DEPARTMENT D on E.DEPT_CODE = D.DEPT_ID
         left join JOB J using (JOB_CODE)
         left join LOCATION L on D.LOCATION_ID = L.LOCAL_CODE
where D.DEPT_ID = 'D2';

-- 8. 급여등급테이블 sal_grade의 등급별 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
--     (사원테이블과 급여등급테이블을 SAL_LEVEL컬럼기준으로 동등(등가) 조인할 것)
select E.EMP_NAME,
       J.JOB_NAME,
       E.SALARY,
       truncate((E.SALARY + (E.SALARY * ifnull(E.BONUS, 0))) * 12, 0) as '연봉'
from SAL_GRADE S
         left join EMPLOYEE E using (SAL_LEVEL)
         left join JOB J using (JOB_CODE)
where S.MAX_SAL < E.SALARY;

-- 9. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.
select E.EMP_NAME,
       D.DEPT_TITLE,
       L.LOCAL_NAME,
       N.NATIONAL_NAME
from EMPLOYEE E
         left join DEPARTMENT D on E.DEPT_CODE = D.DEPT_ID
         left join LOCATION L on D.LOCATION_ID = L.LOCAL_CODE
         left join NATION N using (NATIONAL_CODE)
where L.NATIONAL_CODE in ('KO', 'JP');

-- 10. 같은 부서에 근무하는 직원들의 사원명, 부서명, 동료이름을 조회하시오. (self join 사용)
select E1.EMP_NAME,
       D.DEPT_TITLE,
       E2.EMP_NAME
from EMPLOYEE E1
         join DEPARTMENT D on E1.DEPT_CODE = D.DEPT_ID
         join EMPLOYEE E2 using (DEPT_CODE)
where E1.EMP_ID != E2.EMP_ID
order by 1;

-- 11. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오. 단, join과 in 연산자 사용할 것
select E.EMP_NAME,
       J.JOB_NAME,
       format(E.SALARY, 0)
from EMPLOYEE E
         left join JOB J using (JOB_CODE)
where J.JOB_NAME in ('차장', '사원');

-- 12. 재직중인 직원과 퇴사한 직원의 수를 조회하시오.
select if(QUIT_YN = 'N', '재직', '퇴사'),
       count(*)
from EMPLOYEE E1
group by QUIT_YN;

select count(if(QUIT_YN = 'N', 1, null)) 재직자, -- null값이 아닌 레코드 수 센다.
       count(if(QUIT_YN = 'Y', 1, null)) 퇴사자,
       sum(if(QUIT_YN = 'N', 1, null))   재직자, -- null값이 컬럼값을 합계를 구한다.
       sum(if(QUIT_YN = 'Y', 1, null))   퇴사자
from employee;