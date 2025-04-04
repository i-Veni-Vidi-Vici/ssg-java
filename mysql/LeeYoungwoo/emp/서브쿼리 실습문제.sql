select * from employee; -- 사원테이블
select * from job; -- 직급테이블
select * from department; -- 부서테이블
select * from location; -- 지역테이블
select * from nation; -- 국가테이블
select * from sal_grade; -- 급여등급테이블

-- 1. 부서별 직원 급여의 총합 중 가장 큰 액수를 출력하세요.
select sum(SALARY)
from employee
group by DEPT_CODE
order by 1 desc
limit 1;

-- 2. 서브쿼리를 이용하여 영업부인 직원들의 사원번호, 직원명, 부서코드, 급여를 출력하세요.
--    참고. 영업부인 직원은 부서명에 ‘영업’이 포함된 직원임
select EMP_ID 사원번호,
       EMP_NAME 직원명,
       DEPT_CODE 부서코드,
       SALARY 급여
from employee e
where DEPT_CODE in (select DEPT_ID
                   from department
                   where DEPT_TITLE like '%영업%');

-- 3. 서브쿼리와 JOIN을 이용하여 영업부인 직원들의 사원번호, 직원명, 부서명, 급여를 출력하세요.
select EMP_ID 사원번호,
       EMP_NAME 직원명,
       DEPT_TITLE 부서명,
       SALARY 급여
from employee e join department d on e.DEPT_CODE = d.DEPT_ID
where DEPT_CODE in (select DEPT_ID
                    from department
                    where DEPT_TITLE like '%영업%');

-- 4-a. JOIN을 이용하여 부서의 부서코드, 부서명, 해당 부서가 위치한 지역명, 국가명을 추출하는 쿼리를 작성하세요.
select d.DEPT_ID 부서코드,
       d.DEPT_TITLE 부서명,
       l.LOCAL_NAME 지역명,
       n.NATIONAL_NAME 국가명
from department d left join location l on d.LOCATION_ID = l.LOCAL_CODE
    left join nation n on l.NATIONAL_CODE = n.NATIONAL_CODE;

-- 4-b. 위 a에서 작성한 쿼리를 서브쿼리로 활용하여 모든 직원의 사원번호, 직원명, 급여, 부서명, (부서의) 국가명을 출력하세요.
--    단, 국가명 내림차순으로 출력되도록 하세요.
with sub
    as ( select d.DEPT_ID 부서코드,
                d.DEPT_TITLE 부서명,
                l.LOCAL_NAME 지역명,
                n.NATIONAL_NAME 국가명
         from department d left join location l on d.LOCATION_ID = l.LOCAL_CODE
                           left join nation n on l.NATIONAL_CODE = n.NATIONAL_CODE)
select e.EMP_ID 사원번호,
       e.EMP_NAME 직원명,
       e.SALARY 급여,
       s.부서명,
       s.국가명
from employee e left join sub s on e.DEPT_CODE = s.부서코드
order by 국가명 desc ;

-- 5. 러시아에서 발발한 전쟁으로 인해 정신적 피해를 입은 직원들에게 위로금을 전달하려고 합니다.
-- 위로금은 각자의 급여에 해당 직원의 급여 등급에 해당하는 최소 금액을 더한 금액으로 정했습니다.
-- 4에서 작성한 쿼리를 활용하여 해당 부서의 국가가 ‘러시아’인 직원들을 대상으로,
-- 직원의 사원번호, 직원명, 급여, 부서명, 국가명, 위로금을 출력하세요.
-- 단, 위로금의 결과 집합 헤더는 ‘위로금’으로 출력되도록 하고, 위로금 내림차순으로 출력되도록 하세요.
with money
         as (with sub
                      as (select d.DEPT_ID       부서코드,
                                 d.DEPT_TITLE    부서명,
                                 l.LOCAL_NAME    지역명,
                                 n.NATIONAL_NAME 국가명
                          from department d
                                   left join location l on d.LOCATION_ID = l.LOCAL_CODE
                                   left join nation n on l.NATIONAL_CODE = n.NATIONAL_CODE)
             select e.EMP_ID   사원번호,
                    e.EMP_NAME 직원명,
                    e.SALARY   급여,
                    s.부서명,
                    s.국가명
             from employee e
                      left join sub s on e.DEPT_CODE = s.부서코드
             where 국가명 = '러시아')
select s.*,
       e.SALARY + (select min(SALARY)
                   from employee
                   where EMP_ID in (with sub
                                             as (select d.DEPT_ID       부서코드,
                                                        d.DEPT_TITLE    부서명,
                                                        l.LOCAL_NAME    지역명,
                                                        n.NATIONAL_NAME 국가명
                                                 from department d
                                                          left join location l on d.LOCATION_ID = l.LOCAL_CODE
                                                          left join nation n on l.NATIONAL_CODE = n.NATIONAL_CODE)
                                    select e.EMP_ID 사원번호
                                    from employee e
                                             left join sub s on e.DEPT_CODE = s.부서코드
                                    where 국가명 = '러시아')
                   group by SAL_LEVEL) 위로금
from employee e
         join money s on e.EMP_ID = s.사원번호
order by 위로금 desc ;

