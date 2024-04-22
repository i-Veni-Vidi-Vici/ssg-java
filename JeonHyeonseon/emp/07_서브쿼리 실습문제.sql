-- 1. 부서별 직원 급여의 총합 중 가장 큰 액수를 출력하세요.
select
    max(sum_salary)
from(
    select
        DEPT_CODE,
        sum(SALARY) sum_salary
    from
        employee
    where
        DEPT_CODE is not null
    group by
        DEPT_CODE) t;

-- 2. 서브쿼리를 이용하여 영업부인 직원들의 사원번호, 직원명, 부서코드, 급여를 출력하세요.
--    참고. 영업부인 직원은 부서명에 ‘영업’이 포함된 직원임
select
    EMP_ID 사원번호,
    EMP_NAME 직원명,
    DEPT_CODE 부서코드,
    SALARY 급여
from
    employee
where
    DEPT_CODE in (
        select DEPT_ID
        from department
        where DEPT_TITLE like '%영업%'
        );

-- 3. 서브쿼리와 JOIN을 이용하여 영업부인 직원들의 사원번호, 직원명, 부서명, 급여를 출력하세요.
select
    EMP_ID 사원번호,
    EMP_NAME 직원명,
    d.DEPT_TITLE 부서명,
    SALARY 급여
from employee e join department d
    on e.DEPT_CODE = d.DEPT_ID
where DEPT_CODE in (
    select DEPT_ID
    from department
    where DEPT_TITLE like '%영업%'
    );

-- 4.
-- a. JOIN을 이용하여 부서의 부서코드, 부서명, 해당 부서가 위치한 지역명, 국가명을 추출하는 쿼리를 작성하세요.
select *
from department d join location l
        on d.LOCATION_ID = l.LOCAL_CODE
    join nation n
        on d.LOCATION_ID = n.NATIONAL_NAME;

select *
from department;
select *
from nation;
select *
from location;