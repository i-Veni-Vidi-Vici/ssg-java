use empdb;
-- 함수 실습문제 #113
-- 1. 직원명과 이메일 , 이메일 길이를 출력하시오
select
    concat(EMP_NAME, ' ', EMAIL, ' ', char_length(EMAIL))
from
    employee;

-- 2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하시오
select
    concat(EMP_NAME, ' ', substring_index(EMAIL, '@', 1))
from employee;

-- 3. 60년대에 태어난 직원명과 년생, 보너스 값을 출력하시오 그때 보너스 값이 null인 경우에는 0 이라고 출력 되게 만드시오
select
    concat(EMP_NAME, '  ', lpad(left(EMP_NO, 2), 4, '19'), ' ', ifnull(BONUS, 0))
from
    employee
where
    left(EMP_NO, 2) between 60 and 69;

-- 4. '010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하시오 (뒤에 단위는 명을 붙이시오)
select
    concat(sum(not left(PHONE, 3) = '010'), '명')
from
    employee;

-- 5. 직원명과 입사년월을 출력하시오. 단, 아래와 같이 출력되도록 만들어 보시오
select
    concat(EMP_NAME, ' ',
           date_format(HIRE_DATE, '%Y년'),
           regexp_replace(date_format(HIRE_DATE, '%m월'), '0', ' '))
from
    employee;

-- 6. 직원명과 주민번호를 조회하시오
-- 단, 주민번호 9번째 자리부터 끝까지는 '' 문자로 채워서출력 하시오
select
    concat(EMP_NAME, ' ', rpad(left(EMP_NO, 8), 14, '*'))
from
    employee;

-- 7. 직원명, 직급코드, 연봉(원) 조회
-- 단, 연봉은 ￦57,000,000 으로 표시되게 함.
-- (연봉은 보너스포인트가 적용된 1년치 급여)
select
    EMP_NAME 직원명,
    JOB_CODE 직급코드,
    concat('￦', format((SALARY + (SALARY * ifnull(BONUS, 0) * 12)), 0)) '연봉(원)'
from
    employee;

-- 8. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원중에 조회함.
-- (사번 사원명 부서코드 입사일)
select
    EMP_ID 사번,
    EMP_NAME 사원명,
    DEPT_CODE 부서코드,
    HIRE_DATE 입사일
from
    employee
where
    DEPT_CODE in ('D5', 'D9')
  and
    left(HIRE_DATE, 4) = '2004';

-- 9. 직원명, 입사일, 오늘까지의 근무일수 조회
--    - 주말도 포함 , 소수점 아래는 버림
--    - 퇴사자는 퇴사일-입사일로 계산
select
    EMP_NAME 직원명,
    HIRE_DATE 입사일,
    datediff(ifnull(QUIT_DATE, now()), HIRE_DATE) 근무일수
from
    employee;

-- 10. 직원명, 부서코드, 생년월일, 나이(만나이) 조회
-- 단, 생년월일은 주민번호에서 추출해서,
-- ㅇㅇㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
-- 나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산함
select
    EMP_NAME 직원명,
    ifnull(DEPT_CODE, '부서코드 없음') 부서코드,
    concat(if(substring(EMP_NO, 8, 1) in (1, 2),
       concat('19', left(EMP_NO, 2)),
       concat('20', left(EMP_NO, 2))), '년 ',
       substring(EMP_NO, 3, 2), '월 ',
       substring(EMP_NO, 5, 2), '일') 생년월일,
    left(now(), 4) - if(substring(EMP_NO, 8, 1) in (1, 2),
                                concat('19', left(EMP_NO, 2)),
                                concat('20', left(EMP_NO, 2)))
                    - if((month(curdate()) >= substr(EMP_NO, 3, 2) &&
                       day(curdate()) >= substr(EMP_NO, 5, 2)), 0, 1) '나이(만나이)'
from
    employee;

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
    case
        when DEPT_CODE = 'D5' then '총무부'
        when DEPT_CODE = 'D6' then '기획부'
        when DEPT_CODE = 'D9' then '영업부'
    end DEPT_CODE
from
    employee
where
    DEPT_CODE in ('D5', 'D6', 'D9')
order by
    DEPT_CODE;