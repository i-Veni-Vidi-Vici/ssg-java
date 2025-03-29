-- 1. 기술지원부에 속한 사람들의 사람의 이름,부서코드,급여를 출력하시오
select
    EMP_NAME 이름,
    DEPT_CODE 부서코드,
    SALARY 급여
from employee
where DEPT_CODE = (
        select DEPT_ID
        from department
        where DEPT_TITLE = '기술지원부'
        );

-- 2. 기술지원부에 속한 사람들 중 가장 연봉이 높은 사람의 이름,부서코드,급여를 출력하시오
# select *
# from employee;
# select *
# from department;
# select
#     EMP_NAME 이름,
#     DEPT_CODE 부서코드,
#     SALARY + (SALARY * ifnull(bonus, 0))  * 12 급여
# from employee
# where DEPT_CODE = (
#     select DEPT_ID
#     from department
#     where DEPT_TITLE = '기술지원부');
#
# select
#     max(ifnull(SALARY * 12, 0))
# from employee
# where DEPT_CODE = 'D8';

-- 3. 매니저가 있는 사원중에 월급이 전체사원 평균보다 많은 사원의 사번,이름, 매니저 이름, 월급을 구하시오.
--    a. JOIN을 이용하시오
--    b. JOIN하지 않고, 스칼라상관쿼리(SELECT)를 이용하기
select e1.EMP_ID, e1.EMP_NAME, e2.EMP_NAME, e1.SALARY
from employee e1
    join employee e2
        on e1.MANAGER_ID = e2.EMP_ID
where e1.SALARY > (select avg(salary) from employee);


-- 4. 같은 직급의 평균급여보다 같거나 많은 급여를 받는 직원의 이름, 직급코드, 급여, 급여등급 조회
select 
    EMP_NAME 이름, 
    JOB_CODE 직급코드, 
    SALARY 급여, 
    SAL_LEVEL 급여등급
from employee e
where JOB_CODE = (select * from job where );
select avg()
from job
where JOB_CODE ;