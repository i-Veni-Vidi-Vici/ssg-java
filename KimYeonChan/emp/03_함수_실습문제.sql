-- 1. 직원명과 이메일 , 이메일 길이를 출력하시오
select
    EMP_NAME,
    EMAIL,
    length(EMAIL)
from
    EMPLOYEE;

-- 2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하시오
select
    EMP_NAME,
    substring_index(EMAIL, '@', 1)
from
    EMPLOYEE;

-- 3. 60년대에 태어난 직원명과 년생, 보너스 값을 출력하시오 그때 보너스 값이 null인 경우에는 0 이라고 출력 되게 만드시오
select
    EMP_NAME,
    substring(EMP_NO, 1, 2),
    ifnull(BONUS, 0)
from
    EMPLOYEE
where
    substring(EMP_NO, 1, 2) between 60 and 69;

-- 4. '010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하시오 (뒤에 단위는 명을 붙이시오)
select
    concat(count(*), '명')
from
    EMPLOYEE
where
    PHONE not like '010%';

-- 5. 직원명과 입사년월을 출력하시오. 단, 아래와 같이 출력되도록 만들어 보시오
select
    EMP_NAME,
    concat(year(HIRE_DATE), '년', lpad(month(HIRE_DATE), 2, ' '), '월')
from
    EMPLOYEE;

-- 6. 직원명과 주민번호를 조회하시오
    -- 단, 주민번호 9번째 자리부터 끝까지는 '*' 문자로 채워서출력 하시오
select
    EMP_NAME,
    rpad(substring(EMP_NO, 1, 8), 14, '*')
from
    EMPLOYEE;

-- 7. 직원명, 직급코드, 연봉(원) 조회
    -- 단, 연봉은 ￦57,000,000 으로 표시되게 함. (연봉은 보너스포인트가 적용된 1년치 급여)
select
    EMP_NAME,
    concat('₩', format((SALARY + (SALARY * ifnull(BONUS, 0))) * 12, 0))
from
    EMPLOYEE;

-- 8. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원 중에 조회함.
    -- (사번 사원명 부서코드 입사일)
select
    *
from
    EMPLOYEE
where
    (DEPT_CODE in ('D5', 'D9'))
  and
    year(HIRE_DATE) = '2004';

-- 9. 직원명, 입사일, 오늘까지의 근무일수 조회
    -- * 주말도 포함 , 소수점 아래는 버림
    -- * 퇴사자는 퇴사일-입사일로 계산
select
    EMP_NO,
    HIRE_DATE,
    datediff(ifnull(QUIT_DATE, now()), HIRE_DATE)
from
    EMPLOYEE;

-- 10. 직원명, 부서코드, 생년월일, 나이(만나이) 조회
    -- 단, 생년월일은 주민번호에서 추출해서,
    -- yyyy년 mm월 dd일로 출력되게 함.
    -- 나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산함
select
    EMP_NAME,
    DEPT_CODE,
    concat(
        concat(if (substring(EMP_NO, 1, 2) > substring(extract(year from now()), 1, 2), '19', '20'), substring(EMP_NO, 1, 2)), '년',
        substring(EMP_NO, 3, 2), '월',
        substring(EMP_NO, 5, 2), '일'
    ) as 'BIRTHDAY',
    if (
        extract(month from substring(EMP_NO, 3, 2)) > month(now())
        or (
            extract(month from  substring(EMP_NO, 3, 2)) = month(now())
            and
            extract(day from substring(EMP_NO, 5, 2)) >= day(now())
        ),
        year(now()) - cast(concat(if(substring(EMP_NO, 1, 2) > substring(extract(YEAR FROM now()), 1, 2), '19', '20'), substring(EMP_NO, 1, 2)) AS UNSIGNED),
        year(now()) - cast(concat(if(substring(EMP_NO, 1, 2) > substring(extract(YEAR FROM now()), 1, 2), '19', '20'), substring(EMP_NO, 1, 2)) AS UNSIGNED)- 1
    ) as 'AGE'
from
    EMPLOYEE;

-- 11. 직원들의 입사일로 부터 년도만 가지고, 각 년도별 입사인원수를 구하시오.
    -- 아래형식으로 해당년도에 입사한 인원수를 조회하시오. (퇴사자 제외)
    -- 마지막으로 전체직원수도 구하시오 (decode, sum 사용)
select
    count(case extract(year from hire_date) when 1998 then 1 end) "1998",
    count(case extract(year from hire_date) when 1999 then 1 end) "1999",
    count(case extract(year from hire_date) when 2000 then 1 end) "2000",
    count(case extract(year from hire_date) when 2001 then 1 end) "2001",
    count(case extract(year from hire_date) when 2002 then 1 end) "2002",
    count(case extract(year from hire_date) when 2003 then 1 end) "2003",
    count(case extract(year from hire_date) when 2004 then 1 end) "2004",
    count(*) 전체직원수
from
    employee
where
    quit_yn = 'N';

-- 12. 부서코드가 D5이면 총무부, D6이면 기획부, D9이면 영업부로 처리하시오. (case 사용)
    -- 단, 부서코드가 D5, D6, D9 인 직원의 정보만 조회하고, 부서코드 기준으로 오름차순 정렬함.
select
    EMP_NAME,
    case DEPT_CODE
        when 'D5' then '총무부'
        when 'D6' then '기획부'
        when 'D9' then '영업부'
    end as '부서'
from
    EMPLOYEE
where
    DEPT_CODE in ('D5', 'D6', 'D9')
order by
    DEPT_CODE;

select * from EMPLOYEE;
