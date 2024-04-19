-- 조인 실습문제2
use empdb;

-- 1. 재직 중이고 휴대폰 마지막 자리가 2인 직원 중 입사일이 가장 최근인 직원 3명의 사원번호, 직원명, 전화번호, 입사일, 퇴직여부를 출력하세요.
select
    *
from (
         select
             EMP_ID 사원번호,
            EMP_NAME 직원명,
            PHONE 전화번호,
            HIRE_DATE 입사일,
            ifnull(QUIT_DATE, '재직중') 퇴직여부
        from
            employee
        where
            QUIT_YN = 'N'
          and
            right(PHONE, 1) = 2
        order by
            4 desc
        limit
            3
     ) t
order by
    t.입사일;

-- 2. 재직 중인 ‘대리’들의 직원명, 직급명, 급여, 사원번호, 이메일, 전화번호, 입사일을 출력하세요.
-- 단, 급여를 기준으로 내림차순 출력하세요.
select
    e.EMP_NAME 직원명,
    j.JOB_NAME 직급명,
    e.SALARY 급여,
    e.EMP_ID 사원번호,
    e.EMAIL 이메일,
    e.PHONE 전화번호,
    e.HIRE_DATE 입사일
from
    employee e join job j
        using (JOB_CODE)
where
    e.QUIT_YN = 'N'
  and
    j.JOB_NAME = '대리';

-- 3. 재직 중인 직원들을 대상으로 부서별 인원, 급여 합계, 급여 평균을 출력하고, 마지막에는 전체 인원과 전체 직원의 급여 합계 및 평균이 출력되도록 하세요.
-- 단, 출력되는 데이터의 헤더는 컬럼명이 아닌 ‘부서명’, ‘인원’, ‘급여합계’, ‘급여평균’으로 출력되도록 하세요
select
    if(grouping(d.DEPT_TITLE) = 0, d.DEPT_TITLE, '전체 인원') 부서명,
    count(*) 인원,
    sum(e.SALARY) 급여합계,
    avg(e.SALARY) 급여평균
from
    employee e left join department d
        on e.DEPT_CODE = d.DEPT_ID
group by
    d.DEPT_TITLE with rollup;

-- 4. 전체 직원의 직원명, 주민등록번호, 전화번호, 부서명, 직급명을 출력하세요.
-- 단, 입사일을 기준으로 오름차순 정렬되도록 출력하세요.
select
    EMP_NAME 직원명,
    EMP_NO 주민등록번호,
    PHONE 전화번호,
    DEPT_TITLE 부서명,
    JOB_NAME 직급명
from
    employee e
        left join department d
            on e.DEPT_CODE = d.DEPT_ID
        left join job j
            using (JOB_CODE)
order by
    e.HIRE_DATE;

-- 5. 전체 직원 중 연결된 관리자가 있는 직원의 인원을 출력하세요.
select
    count(*)
from
    employee
where
    MANAGER_ID is not null;

-- 6. 모든 직원의 직원명과 관리자의 직원명을 출력하세요.
-- 참고. ‘모든 직원’이므로 관리자가 존재하지 않는 직원도 출력되어야 합니다.
select
    ifnull(emp.EMP_NAME, '관리자 없음') 직원명,
    mng.EMP_NAME 관리자
from
    employee emp left join employee mng
        on emp.MANAGER_ID = mng.EMP_ID;

-- 7. 관리자가 존재하는 직원의 직원명, 부서명, 관리자의 직원명, 관리자의 부서명을 출력하세요.
select
    e.EMP_NAME 직원명,
    d.DEPT_TITLE 부서명,
    m.EMP_NAME '관리자의 직원명',
    case m.DEPT_CODE
        when 'D1' then '인사관리부'
        when 'D2' then '회계관리부'
        when 'D3' then '마케팅부'
        when 'D4' then '국내영업부'
        when 'D5' then '해외영업1부'
        when 'D6' then '해외영업2부'
        when 'D7' then '해외영업3부'
        when 'D8' then '기술지원부'
        when 'D9' then '총무부'
        else null
    end '관리자의 부서명'
from
    employee e
        left join employee m
            on e.MANAGER_ID = m.EMP_ID
        left join department d
            on e.DEPT_CODE = d.DEPT_ID
where
    e.MANAGER_ID is not null;

select *
from department;