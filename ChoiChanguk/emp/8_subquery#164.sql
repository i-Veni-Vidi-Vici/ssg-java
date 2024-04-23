use empdb;

# 1. 부서별 직원 급여의 총합 중 가장 큰 액수를 출력하세요.
select format(concat(max(sal), '원'), 0) as 가장큰_액수
from (select sum(SALARY) sal
      from employee
      group by DEPT_CODE) as a;


# 2. 서브쿼리를 이용하여 영업부인 직원들의 사원번호, 직원명, 부서코드, 급여를 출력하세요.
# --    참고. 영업부인 직원은 부서명에 ‘영업’이 포함된 직원임
select EMP_ID as 사원번호, EMP_NAME as 직원명, DEPT_CODE as 부서코드, format(SALARY,0) as 급여
from employee
where DEPT_CODE in (select DEPT_ID
                   from department
                   where DEPT_TITLE like '%영업%');

# 3. 서브쿼리와 JOIN을 이용하여 영업부인 직원들의 사원번호, 직원명, 부서명, 급여를 출력하세요.

select t.EMP_ID as 사원번호, t.EMP_NAME as 사원이름,t.DEPT_CODE as 부서명, format(t.SALARY,0) as 급여
from (select *
      from employee e left join department d
      on e.DEPT_CODE=d.DEPT_ID
      where d.DEPT_TITLE like '%영업%') as t;

# 4.
-- a. JOIN을 이용하여 부서의 부서코드, 부서명, 해당 부서가 위치한 지역명, 국가명을 추출하는 쿼리를 작성하세요.
select DEPT_ID as 부서코드, DEPT_TITLE as 부서명, LOCAL_NAME as 지역명, NATIONAL_NAME as 국가명
from (department d left join location l
on d.LOCATION_ID=l.LOCAL_CODE) join nation n
on l.NATIONAL_CODE=n.NATIONAL_CODE;

-- b. 위 a에서 작성한 쿼리를 서브쿼리로 활용하여 모든 직원의 사원번호, 직원명, 급여, 부서명, (부서의) 국가명을 출력하세요.
--    단, 국가명 내림차순으로 출력되도록 하세요.
select *
from (select DEPT_ID as 부서코드, DEPT_TITLE as 부서명, LOCAL_NAME as 지역명, NATIONAL_NAME as 국가명
      from (department d left join location l
            on d.LOCATION_ID = l.LOCAL_CODE)
               join nation n
                    on l.NATIONAL_CODE = n.NATIONAL_CODE) as t
order by t.국가명 desc;

-- 5. 러시아에서 발발한 전쟁으로 인해 정신적 피해를 입은 직원들에게 위로금을 전달하려고 합니다.
-- 위로금은 각자의 급여에 해당 직원의 급여 등급에 해당하는 최소 금액을 더한 금액으로 정했습니다.
-- 4에서 작성한 쿼리를 활용하여 해당 부서의 국가가 ‘러시아’인 직원들을 대상으로,
-- 직원의 사원번호, 직원명, 급여, 부서명, 국가명, 위로금을 출력하세요.
-- 단, 위로금의 결과 집합 헤더는 ‘위로금’으로 출력되도록 하고, 위로금 내림차순으로 출력되도록 하세요.
select EMP_ID as 사원번호, EMP_NAME as 직원명, SALARY as 급여, DEPT_ID as 부서명, NATIONAL_NAME as 국가명,
       SALARY+s.MIN_SAL as 위로금, SALARY as 월급, s.MIN_SAL 최저급
from employee e
         left join department d
                   on e.DEPT_CODE = d.DEPT_ID
         left join location l
                   on d.LOCATION_ID = l.LOCAL_CODE
         join nation n
              on l.NATIONAL_CODE = n.NATIONAL_CODE
join sal_grade s
on e.SAL_LEVEL = s.SAL_LEVEL
where n.NATIONAL_NAME = '러시아';

select *
from employee;

select *
from sal_grade



