# 1 2020년 12월 25일이 무슨 요일인지 조회하시오.
select
    case dayofweek('20201225')
        when 1 then '일요일'
        when 2 then '월요일'
        when 3 then '화요일'
        when 4 then '수요일'
        when 5 then '목요일'
        when 6 then '금요일'
        when 7 then '토요일'
    end 'dayofweek(20201225)';

# 2 주민번호가 1970년대생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.
select e.EMP_NAME, e.EMP_NO, d.DEPT_TITLE, j.JOB_NAME
from employee e, department d, job j
where substr(e.EMP_NO, 1, 1) = 7
    and (substr(e.EMP_NO, 8, 1) = 2 or substr(e.EMP_NO, 8, 1) = 4)
    and e.EMP_NAME like '전%'
    and e.DEPT_CODE = d.DEPT_ID
    and e.JOB_CODE = j.JOB_CODE;

# 3 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오.
select e.EMP_ID, e.EMP_NAME,
       case
           when substr(e.EMP_NO, 1, 1) in ('4', '5', '6','7','8','9') then substr(e.EMP_NO, 1, 2) + 1900
           else substr(e.EMP_NO, 1, 2) + 2000
       end 나이, d.DEPT_TITLE, j.JOB_NAME
from employee e left join department d
on e.DEPT_CODE = d.DEPT_ID
left join job j
on e.JOB_CODE = j.JOB_CODE
order by
    case
        when substr(e.EMP_NO, 1, 1) in ('4', '5', '6','7','8','9') then substr(e.EMP_NO, 1, 2) + 1900
        else substr(e.EMP_NO, 1, 2) + 2000
    end desc
limit 1;

# 4 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
select e.EMP_ID, e.EMP_NAME, d.DEPT_TITLE
from employee e, department d
where EMP_NAME like '%형%'
and e.DEPT_CODE = d.DEPT_ID;

# 5 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.
select e.EMP_NAME, j.JOB_NAME, d.DEPT_ID, d.DEPT_TITLE
from employee e left join department d on e.DEPT_CODE = d.DEPT_ID
    left join job j on e.JOB_CODE = j.JOB_CODE
where d.DEPT_TITLE like '해외영업%';

# 6 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
select e.EMP_NAME, e.BONUS, d.DEPT_TITLE, l.LOCAL_NAME
from employee e left join department d on e.DEPT_CODE = d.DEPT_ID
left join location l on d.LOCATION_ID = l.LOCAL_CODE
where BONUS is not null;

# 7 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.
select e.EMP_NAME, j.JOB_NAME, d.DEPT_TITLE, l.LOCAL_NAME
from employee e left join department d on e.DEPT_CODE = d.DEPT_ID
left join job j on e.JOB_CODE = j.JOB_CODE
left join location l on d.LOCATION_ID = l.LOCAL_CODE
where d.DEPT_ID = 'D2';

# 8 급여등급테이블 sal_grade의 등급별 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
select e.EMP_NAME, j.JOB_NAME, e.SALARY, (e.salary + (e.SALARY * ifnull(e.BONUS, 0))) * 12 연봉
from employee e left join sal_grade sg on e.SAL_LEVEL = sg.SAL_LEVEL
left join job j on e.JOB_CODE = j.JOB_CODE
where e.SALARY > sg.MAX_SAL;

# 9 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.
