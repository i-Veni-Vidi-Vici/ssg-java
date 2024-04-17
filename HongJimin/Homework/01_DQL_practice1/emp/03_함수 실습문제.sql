show databases;

-- 1. 직원명과 이메일 , 이메일 길이를 출력하시오
select
    EMP_NAME,
    EMAIL,
    length(EMAIL) 이메일길이
from
    employee;

-- 2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하시오
select
    EMP_NAME,
    SUBSTRING_INDEX(EMAIL, '@', 1)
from
    employee;

-- 3. 60년대에 태어난 직원명과 년생, 보너스 값을 출력하시오 그때 보너스 값이 null인 경우에는 0 이라고 출력 되게 만드시오
select
    EMP_NAME,
    EMP_NO,
    if( BONUS = null, '0', SALARY)
from
    employee
where
    EMP_NO like '6%';

-- 4. '010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하시오 (뒤에 단위는 명을 붙이시오)
select
    concat(count(*), '명')

from
    employee
where
    PHONE not like '010%';

-- 5. 직원명과 입사년월을 출력하시오. 단, 아래와 같이 출력되도록 만들어 보시오
select
    EMP_NAME,
    date_format(HIRE_DATE, '%Y년 %m월')
from
    employee;

-- 6. 직원명과 주민번호를 조회하시오
-- 단, 주민번호 9번째 자리부터 끝까지는 '' 문자로 채워서출력 하시오
select
    EMP_NAME,
    insert(EMP_NO, 9,6, '******')
from
    employee;

-- 7. 직원명, 직급코드, 연봉(원) 조회
-- 단, 연봉은 ￦57,000,000 으로 표시되게 함.
-- (연봉은 보너스포인트가 적용된 1년치 급여)
select
    EMP_NAME 직원명,
    DEPT_CODE 직급코드,
    concat('￦', format(SALARY , 0)) 연봉
from
    employee;

-- 8. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원중에 조회함.
-- (사번 사원명 부서코드 입사일)
select
    EMP_ID,
    EMP_NAME,
    JOB_CODE,
    HIRE_DATE
from
    employee
where
    JOB_CODE = 'D5';
#     JOB_CODE = 'D9');
# or
#   and
#     HIRE_DATE like '2024%';


select *
from employee
