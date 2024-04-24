# 1. EMPLOYEE 테이블에서 직급이 J1을 제외하고, 직급별 사원수 및 평균급여를 출력하세요.
select JOB_CODE,concat(truncate(sum(SALARY)/count(*) ,0),'원')as 평균급여
from employee
group by JOB_CODE
having JOB_CODE != 'j1';

# 2. EMPLOYEE테이블에서 직급이 J1을 제외하고, 입사년도별 인원수를 조회해서, 입사년 기준으로 오름차순 정렬하세요.
select extract(year from HIRE_DATE)as 입사년도,concat(count(HIRE_DATE),'명') as 입사인원
from employee
where JOB_CODE !='j1'
group by extract(year from HIRE_DATE);

# 3. 성별 급여의 평균(정수처리), 급여의 합계, 인원수를 조회한 뒤 인원수로 내림차순을 정렬 하시오.
select
    case substr(EMP_NO, 8, 1)
        when 1 then '남자'
        when 3 then '남자'
        else '여자'
        end as 성별,
    concat(format(avg(SALARY),0),'원') as 평균,
    concat(count(*),'명') as 인원
from employee
group by
    case substr(EMP_NO, 8, 1)
        when 1 then '남자'
        when 3 then '남자'
        else '여자'
    end;

# 4. 직급별 인원수가 3명이상이 직급과 총원을 조회

select JOB_CODE as 직급,count(JOB_CODE) as 총원
from employee
group by JOB_CODE
having count(JOB_CODE)>=3;