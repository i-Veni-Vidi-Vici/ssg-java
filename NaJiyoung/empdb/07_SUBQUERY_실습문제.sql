use empdb;

-- 1. 부서별 직원 급여의 총합 중 가장 큰 액수를 출력하세요.
select format(max(sal_sum), 0)
from (
        select sum(SALARY) sal_sum
        from employee
        group by DEPT_CODE
    ) e;

-- 2. 서브쿼리를 이용하여 영업부인 직원들의 사원번호, 직원명, 부서코드, 급여를 출력하세요.
--    참고. 영업부인 직원은 부서명에 ‘영업’이 포함된 직원임
select EMP_ID 사원번호, EMP_NAME 직원명, DEPT_CODE 부서코드, SALARY 급여
from employee
where DEPT_CODE in (
        select DEPT_ID
        from department
        where DEPT_TITLE like '%영업%'
     );

-- 3. 서브쿼리와 JOIN을 이용하여 영업부인 직원들의 사원번호, 직원명, 부서명, 급여를 출력하세요.
select e.EMP_ID 사원번호, e.EMP_NAME 직원명, d.DEPT_TITLE 부서명, e.SALARY 급여
from employee e join (
        select DEPT_ID, DEPT_TITLE
        from department
        where DEPT_TITLE like '%영업%'
    ) d
        on e.DEPT_CODE = d.DEPT_ID;

-- 4.
-- a. JOIN을 이용하여 부서의 부서코드, 부서명, 해당 부서가 위치한 지역명, 국가명을 추출하는 쿼리를 작성하세요.
-- b. 위 a에서 작성한 쿼리를 서브쿼리로 활용하여 모든 직원의 사원번호, 직원명, 급여, 부서명, (부서의) 국가명을 출력하세요.
--    단, 국가명 내림차순으로 출력되도록 하세요.
select e.EMP_ID 사원번호, e.EMP_NAME 직원명, format(e.SALARY, 0) 급여, t.DEPT_TITLE 부서명, t.NATIONAL_NAME 국가명
from employee e left join (
    select d.DEPT_ID, d.DEPT_TITLE, l.LOCAL_NAME, n.NATIONAL_NAME
    from department d
             join location l on d.LOCATION_ID = l.LOCAL_CODE
             join nation n using (NATIONAL_CODE)
) t
    on e.DEPT_CODE = t.DEPT_ID
order by 국가명 desc;

-- 5. 러시아에서 발발한 전쟁으로 인해 정신적 피해를 입은 직원들에게 위로금을 전달하려고 합니다.
-- 위로금은 각자의 급여에 해당 직원의 급여 등급에 해당하는 최소 금액을 더한 금액으로 정했습니다.
-- 4에서 작성한 쿼리를 활용하여 해당 부서의 국가가 ‘러시아’인 직원들을 대상으로,
-- 직원의 사원번호, 직원명, 급여, 부서명, 국가명, 위로금을 출력하세요.
-- 단, 위로금의 결과 집합 헤더는 ‘위로금’으로 출력되도록 하고, 위로금 내림차순으로 출력되도록 하세요.
select e.EMP_ID 사원번호, e.EMP_NAME 직원명, format(e.SALARY, 0) 급여, t.DEPT_TITLE 부서명, t.NATIONAL_NAME 국가명,
       format(e.SALARY + sg.MIN_SAL, 0) 위로금
from employee e left join (
    select d.DEPT_ID, d.DEPT_TITLE, l.LOCAL_NAME, n.NATIONAL_NAME
    from department d
             join location l on d.LOCATION_ID = l.LOCAL_CODE
             join nation n using (NATIONAL_CODE)
) t on e.DEPT_CODE = t.DEPT_ID
                left join sal_grade sg using (SAL_LEVEL)
where t.NATIONAL_NAME = '러시아'
order by 위로금 desc;