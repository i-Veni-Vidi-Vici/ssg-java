-- 1. 직원명과 이메일 , 이메일 길이를 출력하시오
select
    EMP_NAME 직원명,
    EMAIL 이메일,
    char_length(EMAIL) '이메일 길이'
from
    employee;

-- 2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하시오
select
    EMP_NAME,
    substring_index(EMAIL, '@', 1)
from
    employee;

-- 3. 60년대에 태어난 직원명과 년생, 보너스 값을 출력하시오
--    그때 보너스 값이 null인 경우에는 0 이라고 출력 되게 만드시오
select
    EMP_NAME 직원명,
    concat(19, substring(EMP_NO, 1, 2)) 년생,
    ifnull(BONUS, 0) 보너스
from
    employee
where
    EMP_NO like '6_%';

-- 4. '010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하시오 (뒤에 단위는 명을 붙이시오)
select
    concat(count(PHONE), '명') as '사람수'
from
    employee
where
    not PHONE like '010%';

-- 5. 직원명과 입사년월을 출력하시오. 단, 아래와 같이 출력되도록 만들어 보시오
select
    EMP_NAME 직원명,
    year(HIRE_DATE),
    month(HIRE_DATE),
    date_format(HIRE_DATE, '%Y년%m월') 입사년월
from
    employee;

-- 6. 직원명과 주민번호를 조회하시오
-- 단, 주민번호 9번째 자리부터 끝까지는 '' 문자로 채워서출력 하시오
select
    EMP_NAME 직원명,
    insert(EMP_NO, 9, 6, '******') 주민번호
from
    employee;

-- 7. 직원명, 직급코드, 연봉(원) 조회
-- 단, 연봉은 ￦57,000,000 으로 표시되게 함.
-- (연봉은 보너스포인트가 적용된 1년치 급여)
select
    EMP_NAME 직원명,
    JOB_CODE 직급코드,
#     BONUS,
    concat('￦', format((SALARY * 12) + SALARY * ifnull(BONUS, 0), 0)) '연봉(원)'
from
    employee;

-- 8. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원중에 조회함.
--    (사번 사원명 부서코드 입사일)
select
    EMP_ID 사번,
    EMP_NAME 사원명,
    DEPT_CODE 부서코드,
    HIRE_DATE 입사일
from
    employee
where
    DEPT_CODE in ('D5', 'D9') && year(HIRE_DATE) = 2004;

-- 9. 직원명, 입사일, 오늘까지의 근무일수 조회
--    주말도 포함 , 소수점 아래는 버림
--    퇴사자는 퇴사일-입사일로 계산
select
    EMP_NAME 직원명,
    HIRE_DATE 입사일,
    QUIT_DATE,
    if(QUIT_YN, 'Y', 'N'),
    datediff(now(), if(QUIT_YN, 'Y', 'N')) as '오늘까지의 근무일수'
from
    employee;

-- 10. 직원명, 부서코드, 생년월일, 나이(만나이) 조회
--     단, 생년월일은 주민번호에서 추출해서,
--     ㅇㅇㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
--     나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산함
-- 한국나이 : 현재년도(now()) - 출생년도 + 1
-- 만나이 : 생일기준 truncate(datediff(오늘, 생일) / 365)
select
    EMP_NAME 직원명,
    DEPT_CODE 부서코드,
    EMP_NO,
    concat(substring(EMP_NO, 1, 2) + if(substring(EMP_NO, 1, 1), 1900, 2000), '년',
    substring(EMP_NO, 3, 2), '월',
    substring(EMP_NO, 5, 2), '일') 생년월일,

    truncate(
        datediff(
            now(),
            concat(
                case
                    substring(EMP_NO, 8, 1)
                    when '1' then 1900
                    when '2' then 1900
                    else 2000
                    end + substring(EMP_NO, 1, 2),
                substring(EMP_NO, 3, 2),
                substring(EMP_NO, 5, 2)
            )
        ) / 365
    , 0)
from
    employee;

-- 11. 직원들의 입사일로 부터 년도만 가지고, 각 년도별 입사인원수를 구하시오.
--     아래형식으로 해당년도에 입사한 인원수를 조회하시오. (퇴사자 제외)
--     마지막으로 전체직원수도 구하시오 (decode, sum 사용)
# 1998년 1999년 2000년 2001년 2002년 2003년 2004년 전체직원수
# ----------------------------------------------------------
# 0	     3	    1	     3	    0	     0	   1	     23

-- 세로로 구하기
select
#    EMP_NAME,
    year(HIRE_DATE) year,
    count(HIRE_DATE),
    case
        when count(HIRE_DATE) then '1998'
from
    employee
group by
    year(HIRE_DATE) with rollup; -- 전체 수
# order by
#     year is null,
#     1;

-- 가상컬럼 데이터 준비
select
    EMP_NAME,
    HIRE_DATE
from
    employee;

-- 12. 부서코드가 D5이면 총무부, D6이면 기획부, D9이면 영업부로 처리하시오. (case 사용)
-- 단, 부서코드가 D5, D6, D9 인 직원의 정보만 조회하고, 부서코드 기준으로 오름차순 정렬함.
select
    EMP_NAME,
    DEPT_CODE,
    case
        when DEPT_CODE = 'D5' then '총무부'
        when DEPT_CODE = 'D6' then '기획부'
        when DEPT_CODE = 'D9' then '영업부'
    end as '부서코드'
from
    employee
where
    Dept_code in ('D5', 'D6', 'D9')
order by
    DEPT_CODE;