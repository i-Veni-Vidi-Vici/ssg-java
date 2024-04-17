# 1. 2020년 12월 25일이 무슨 요일인지 조회하시오.
select
    case
        when dayofweek('2020/12/25') = 0 then '일요일'
        when dayofweek('2020/12/25') = 1 then '월요일'
        when dayofweek('2020/12/25') = 2 then '화요일'
        when dayofweek('2020/12/25') = 3 then '수요일'
        when dayofweek('2020/12/25') = 4 then '목요일'
        when dayofweek('2020/12/25') = 5 then '금요일'
        when dayofweek('2020/12/25') = 6 then '토요일'
    end;

# 2. 주민번호가 1970년대생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오.
select
    e.EMP_NAME 사원명,
    e. EMP_NO 주민번호,
    d.DEPT_TITLE 부서명,
    j.JOB_NAME 직급명
from
    employee e join department d on e.DEPT_CODE = d.DEPT_ID
    join job j on e.JOB_CODE = j.JOB_CODE
where
    substring(e.EMP_NO, 1, 1) = 7
    and substring(e.EMP_NO,8,1) =2
    and substring(e.EMP_NAME, 1, 1) = '전';

# 3. 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오.
select
    e.EMP_ID 사번,
    e.EMP_NAME 이름,
    year(curdate()) - (if(substr(EMP_NO,8,1) in (1,2), 1900, 2000) + substring(EMP_NO, 1, 2))
    - if((month(curdate())>= substring(EMP_NO, 3, 2)) && (day(curdate()) >= substring(EMP_NO,5, 2)), 0 , 1 ) as 나이,
    d.DEPT_TITLE 부서명,
    j.JOB_NAME 직급
from
    employee e left join department d on e.DEPT_CODE = d.DEPT_ID
    left join job j on e.JOB_CODE = j.JOB_CODE
order by 나이
limit 1;

# 4. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
select
    e.EMP_ID 사번,
    e.EMP_NAME 사원명,
    d.DEPT_TITLE 부서명
from
    employee e left join department d on e.DEPT_CODE = d.DEPT_ID
where
    e.EMP_NAME like '%형%';

# 5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.
select
    e.EMP_NAME 사원명,
    j.JOB_NAME 직급,
    e.DEPT_CODE 부서코드,
    d.DEPT_TITLE 부서명
from
    employee e join department d on e.DEPT_CODE = d.DEPT_ID
    left join job j on e.JOB_CODE = j.JOB_CODE
 where
     d.DEPT_TITLE in ('해외영업1부', '해외영업2부');

# 6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
select
    e.EMP_NAME 사원명,
    e.BONUS 보너스포인트,
    d.DEPT_TITLE 부서명,
    l.LOCAL_NAME 근무지역
from
    employee e left join department d on e.DEPT_CODE = d.DEPT_ID
    left join location l on d.LOCATION_ID = l.LOCAL_CODE
where
    e.BONUS is not null;

# 7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.
select
    e.EMP_NAME,
    job.JOB_NAME,
    d.DEPT_TITLE,
    l.LOCAL_NAME
from
    employee e join department d on d.DEPT_ID = e.DEPT_CODE
    left join job on e.JOB_CODE = job.JOB_CODE
    left join location l on d.LOCATION_ID = LOCAL_CODE
where
    e.DEPT_CODE = 'D2';

# 8. 급여등급테이블 sal_grade의 등급별 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
#     (사원테이블과 급여등급테이블을 SAL_LEVEL컬럼기준으로 동등(등가) 조인할 것)
select
    e.EMP_NAME 이름,
    j.JOB_NAME 직급,
    format(e.SALARY, 0) 급여,
    format( (e.SALARY + e.SALARY * ifnull(e.BONUS, 0)) * 12 , 0) 연봉
from
    employee e join sal_grade s on e.SAL_LEVEL = s.SAL_LEVEL
    left join job j on e.JOB_CODE = j.JOB_CODE
where
    s.MAX_SAL < e.SALARY;

# 9. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.
select
    e.EMP_NAME 이름,
    d.DEPT_TITLE 부서,
    l.LOCAL_NAME 지역,
    n.NATIONAL_NAME
from
    employee e join department d on e.DEPT_CODE = d.DEPT_ID
    join location l on l.LOCAL_CODE = d.LOCATION_ID
    join nation n on l.NATIONAL_CODE = n.NATIONAL_CODE
where
    n.NATIONAL_CODE in ('KO', 'JP');

# 10. 같은 부서에 근무하는 직원들의 사원명, 부서명, 동료이름을 조회하시오. (self join 사용)
select
    e1.EMP_NAME 이름,
    d.DEPT_TITLE 부서명,
    e2.EMP_NAME 동료
from
    employee e1 join employee e2 on e1.DEPT_CODE = e2.DEPT_CODE
    left join department d on e1.DEPT_CODE = d.DEPT_ID
where
    e1.EMP_NAME != e2.EMP_NAME;

# 11. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오. 단, join과 in 연산자 사용할 것
select
    e.EMP_NAME 이름,
    j.JOB_NAME 직급,
    e.SALARY 급여
from
    employee e join job j on e.JOB_CODE = j.JOB_CODE
where
    e.BONUS is null
  and j.JOB_NAME in ('차장' , '사원');

# 12. 재직중인 직원과 퇴사한 직원의 수를 조회하시오.
select
    if(QUIT_DATE is null, '재직자', '퇴사자') as 재직현황,
    count(*)
from
    employee
group by
    재직현황