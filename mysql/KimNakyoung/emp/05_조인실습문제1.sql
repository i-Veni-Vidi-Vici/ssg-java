use empdb;

select * from employee; -- 사원테이블
select * from job; -- 직급테이블
select * from department; -- 부서테이블
select * from location; -- 지역테이블
select * from nation; -- 국가테이블
select * from sal_grade; -- 급여등급테이블

-- 1. 2020년 12월 25일이 무슨 요일인지 조회하시오.

    select DAYNAME('2020-12-25');

select substr(_UTF8'일월화수목금토',DAYOFWEEK('2020-12-25'),1);

-- 2. 주민번호가 1970년대생이면서 성별이 여자이고, 성이 전씨인 직원들의
-- 사원명, 주민번호, 부서명, 직급명을 조회하시오.

select e.EMP_NAME "사원명", e.EMP_NO "주민번호", d.DEPT_TITLE "부서명",j.JOB_NAME "직급명"
from employee e right join department d on e.DEPT_CODE = d.DEPT_ID
            join job j on e.JOB_CODE = j.JOB_CODE
where (substring(EMP_NO, 1,1) = '7') and (substring(e.EMP_NO, 8,1) = 2) and (substring(e.EMP_NAME, 1,1) = '전');


-- 3. 가장 나이가 적은 직원의 사번, 사원명, 나이, 부서명, 직급명을 조회하시오. @@ 모르겠음 ( 강사님 풀이)

--  나이가 가장 적은 사원 조회 쿼리
select
    min(
            truncate(
                    datediff(
                            now(),
                            concat(
                                    if(substr(emp_no, 8, 1) in (1, 2), 19, 20),
                                    left(emp_no, 6)
                            )
                    ) / 365
                , 0)
    ) min_age
from
    employee;

select
    emp_id 사번,
    emp_name 사원명,
    truncate(
            datediff(
                    now(),
                    concat(
                            if(substr(emp_no, 8, 1) in (1, 2), 19, 20),
                            left(emp_no, 6)
                    )
            ) / 365, 0) 나이,
    dept_title 부서명,
    job_name 직급명
from
    employee
        left join department on dept_code = dept_id
        left join job  using(job_code)
order by
    나이
limit 1;


-- 4. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
-- inner join 부서코드 미지정된 사원 제외
-- left outer join 부서코드 미지정된 사원 포함

select e.EMP_ID "사번",e.EMP_NAME "사원명",d.DEPT_TITLE "부서명"
    from employee e left join empdb.department d
        on d.DEPT_ID = e.DEPT_CODE
where e.EMP_NAME like '%형%';

-- 5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하시오.

select e.EMP_NAME "사원명",j.JOB_NAME '직급명',d.DEPT_ID "부서코드",d.DEPT_TITLE "부서명"
from employee e join department d
    on e.DEPT_CODE = d.DEPT_ID
#         join job j on e.JOB_CODE = j.JOB_CODE
                join job j  using(job_code)
where d.DEPT_TITLE like '%해외영업%';

-- 6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.

-- employee DEPT_CODE , department DEPT_ID
select e.EMP_NAME '사원명',e.BONUS '보너스포인트',d.DEPT_TITLE '부서명',l.LOCAL_NAME '근무지역명'
from
    employee e
        join department d
             on e.DEPT_CODE = d.DEPT_ID
        join location l
             on d.LOCATION_ID = l.LOCAL_CODE
        where e.BONUS is not null;

-- 7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오.

select e.EMP_NAME '사원명',j.JOB_NAME '직급명',d.DEPT_TITLE "부서명",l.LOCAL_NAME '근무지역명'
    from employee e
#         join job j on e.JOB_CODE = j.JOB_CODE
        join job j using (job_code)
        join department d on e.DEPT_CODE = d.DEPT_ID
        join location l on d.LOCATION_ID = l.LOCAL_CODE
where d.DEPT_ID = 'D2';

-- 8. 급여등급테이블 sal_grade의 등급별 최대급여(MAX_SAL)보다 많이 받는 직원들의 사원명, 직급명, 급여, 연봉을 조회하시오.
--     (사원테이블과 급여등급테이블을 SAL_LEVEL 컬럼기준으로 동등(등가) 조인할 것) @@ 강사님 풀이

select
    emp_name,
    job_name,
    salary,
    (salary + salary * ifnull(bonus, 0)) * 12 annual_sal,
    max_sal
from
    employee e
        join job j on(e.job_code = j.job_code)
        join sal_grade s using(sal_level)
where
    e.salary > s.max_sal;


-- 9. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하시오.

select * from employee; -- 사원테이블
select * from job; -- 직급테이블
select * from department; -- 부서테이블
select * from location; -- 지역테이블
select * from nation; -- 국가테이블
select * from sal_grade; -- 급여등급테이블

-- employee - 사원명 , department - 부서명
select e.EMP_NAME '사원명' ,d.DEPT_TITLE '부서명' , l.LOCAL_NAME '지역명', n.NATIONAL_NAME '국가명'
from employee e
        left join department d on e.DEPT_CODE = d.DEPT_ID
        left join location l on d.LOCATION_ID = l.LOCAL_CODE
        left join nation n on l.NATIONAL_CODE = n.NATIONAL_CODE
where l.NATIONAL_CODE = 'KO' OR l.NATIONAL_CODE = 'JP';

-- 10. 같은 부서에 근무하는 직원들의 사원명, 부서명, 동료이름을 조회하시오. (self join 사용)
-- @@ 같은 테이블안에 다른 레코드를 참조하는 경우
-- 여기서는 같은 부서원들이랑 연결하고 싶었다. e는 내 테이블 e2는 내 동료테이블
-- 같은 부서 다른 사원아이디 행과 연결
-- 부서코드 미지정 사원은 제외 (inner join)


select *
from
    employee e join employee c
on e.DEPT_CODE = c.DEPT_CODE and e.EMP_ID != c.EMP_ID; --  나는 나랑 붙이지 마라 내 동료만 붙여라

-- -------------------------------------- 정답
select
    e.emp_name 사원명,
    d.dept_title 부서명,
    e2.emp_name 동료사원명
from
    employee e
        join employee e2 on (e.dept_code = e2.dept_code)
        join department d on e.dept_code = d.dept_id
where
    e.emp_id != e2.emp_id
order by 1;


-- 11. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하시오. 단, join과 in 연산자 사용할 것

select e.EMP_NAME '사원명',j.JOB_NAME '직급명',e.SALARY '급여',format(salary, 0) 급여
from employee e left join job j using(job_code)
where bonus is null and job_name in ('차장','사원');

-- 12. 재직중인 직원과 퇴사한 직원의 수를 조회하시오

select * from employee; -- 사원테이블

select
    if(quit_yn = 'N','재직','퇴사') 재직여부,
    count(*) 인원수
from
    employee
group by
    quit_yn;

# 정은님 풀이 전체를 하나의 그룹으로 처리
select
    count(if(QUIT_YN = 'N', 1, null)) 재직자, -- 1 아니여도 같은 풀이 나옴 ( null값이 아닌 레코드수 세는거)
    count(if(QUIT_YN = 'Y', 1, null)) 퇴사자,
    sum(if(QUIT_YN = 'N', 1, null)) 퇴사자, -- 얘는 1 이여야됨 (칼럼값의 합계를 구한다.) -- N이라면 1로 넣어줌
    sum(if(QUIT_YN = 'Y', 1, null)) 퇴사자
from employee;
