# 1. 재직 중이고 휴대폰 마지막 자리가 2인 직원 중 입사일이 가장 최근인 직원 3명의 사원번호, 직원명, 전화번호, 입사일, 퇴직여부를 출력하세요.
select *
from (select DEPT_CODE as 사원번호,
             EMP_NAME as 직원명,
             PHONE as 전화번호,
             date_format(HIRE_DATE,'%Y-%m-%d') as 입사일,
             ifnull(QUIT_DATE, '재직중') as 재직여부
      from employee
      where QUIT_YN = 'N') as cond
where substring(전화번호,-1,1)=2
order by 입사일 desc limit 2;

select *
from employee;

# 2. 재직 중인 ‘대리’들의 직원명, 직급명, 급여, 사원번호, 이메일, 전화번호, 입사일을 출력하세요.
# 단, 급여를 기준으로 내림차순 출력하세요.
select EMP_NAME                           as 직원명,
       j1.JOB_NAME                        as 직급명,
       SALARY                             as 급여,
       EMP_ID                             as 사원번호,
       EMAIL                              as 이메일,
       PHONE                              as 전화번호,
       date_format(HIRE_DATE, '%Y-%m-%d') as 입사일
from employee e1
         left join job j1 on e1.JOB_CODE = j1.JOB_CODE
where j1.JOB_NAME = '대리'
  and QUIT_DATE is null;


# 3. 재직 중인 직원들을 대상으로 부서별 인원, 급여 합계, 급여 평균을 출력하고, 마지막에는 전체 인원과 전체 직원의 급여 합계 및 평균이 출력되도록 하세요.
# 단, 출력되는 데이터의 헤더는 컬럼명이 아닌 ‘부서명’, ‘인원’, ‘급여합계’, ‘급여평균’으로 출력되도록 하세요
select DEPT_TITLE as 부서명, concat(count(DEPT_CODE),'명') as 인원, concat(format(sum(SALARY),0),'원') as 급여합계,concat(format(avg(SALARY),0),'원') as 급여평균
from employee e join department d on d.DEPT_ID = e.DEPT_CODE
where QUIT_YN='n'
group by DEPT_CODE,DEPT_TITLE ;

# 4. 전체 직원의 직원명, 주민등록번호, 전화번호, 부서명, 직급명을 출력하세요.
# 단, 입사일을 기준으로 오름차순 정렬되도록 출력하세요.
select EMP_NAME as 이름,EMP_NO as 주민번호,PHONE as 전화번호,DEPT_TITLE as 부서명, JOB_NAME as 직급명
from employee left join department d on d.DEPT_ID = employee.DEPT_CODE
join job j on employee.JOB_CODE = j.JOB_CODE
order by HIRE_DATE;

# 5. 전체 직원 중 연결된 관리자가 있는 직원의 인원을 출력하세요.
select concat(count(*),'명') as 인원
from employee e1 join employee e2 on e1.EMP_ID=e2.MANAGER_ID;

select count(MANAGER_ID)
from employee;
# 6. 모든 직원의 직원명과 관리자의 직원명을 출력하세요.
# 참고. ‘모든 직원’이므로 관리자가 존재하지 않는 직원도 출력되어야 합니다.
select e1.EMP_name 직원명,
       ifnull(e2.EMP_NAME,'관리자없음') 관리자
from employee e1 left join employee e2 on e1.MANAGER_ID=e2.EMP_ID ; # 나의 매니저이신 분의 manager.id = emp.id와 같으신 분입니다
;
select EMP_ID, MANAGER_ID
from employee;
# 7. 관리자가 존재하는 직원의 직원명, 부서명, 관리자의 직원명, 관리자의 부서명을 출력하세요.
select e1.EMP_NAME as 직원명,
       d1.DEPT_TITLE as 부서명,
       e2.EMP_NAME as 관리자이름,
       d2.DEPT_TITLE as 부서명
from (employee e1 join department d1 on e1.DEPT_CODE = d1.DEPT_ID)
         join
    (employee e2 join department d2 on e2.DEPT_CODE = d2.DEPT_ID)
              on e1.MANAGER_ID = e2.EMP_ID ;
