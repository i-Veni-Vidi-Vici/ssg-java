-- 1. 직원명과 이메일 , 이메일 길이를 출력하시오
select
    emp_name,
    email,
    length(email)
from
    employee;
-- 2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하시오
select
    emp_name,
    substring_index(email,'@',1)
from
    employee;

-- 3. 60년대에 태어난 직원명과 년생, 보너스 값을 출력하시오 그때 보너스 값이 null인 경우에는 0 이라고 출력 되게 만드시오
select
    emp_name,
    concat('19',substring(emp_no,1,2),'년생'),
    ifnull(bonus,0)
from
    employee
where
    emp_no like '6%';


-- 4. '010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하시오 (뒤에 단위는 명을 붙이시오)
select
    concat(count(*),'명')
from
    employee
where
    phone not like '010%';

-- 5. 직원명과 입사년월을 출력하시오. 단, 아래와 같이 출력되도록 만들어 보시오
/*
전형돈	2012년12월
전지연	1997년 3월
 */
select
    emp_name,
    date_format(HIRE_DATE,'%Y년 %m월')
from
    employee;

-- 6. 직원명과 주민번호를 조회하시오. 단, 주민번호 9번째 자리부터 끝까지는 '' 문자로 채워서출력 하시오
select
    select emp_name 직원명,
    insert(emp_no,9,6,'') 주민번호
from
    employee

-- 7. 직원명, 직급코드, 연봉(원) 조회. 단, 연봉은 ￦57,000,000 으로 표시되게 함. (연봉은 보너스포인트가 적용된 1년치 급여)
select
    emp_name 직원명,
    job_code 직급코드,
    format(salary * 12 * bonus,0)
from
    employee

-- 8. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원중에 조회함. (사번 사원명 부서코드 입사일)
select
    emp_ID 사번,
    emp_name 사원명,
    DEPT_CODE 부서코드,
    HIRE_DATE 입사일
from
    employee
where
    (DEPT_CODE = 'D5' or DEPT_CODE = 'D9')
    and
    substring_index(HIRE_DATE,'-',1) = '2004';

-- 9. 직원명, 입사일, 오늘까지의 근무일수 조회.
-- 주말도 포함 , 소수점 아래는 버림. 퇴사자는 퇴사일-입사일로 계산
select
    EMP_NAME 직원명,
    HIRE_DATE 입사일,
    case QUIT_YN
        when 'Y' then datediff(date(QUIT_DATE),date(HIRE_DATE))
        when 'N' then datediff(date(now()),date(HIRE_DATE))
    end 오늘까지의근무일수
from
    employee;

-- 10. 직원명, 부서코드, 생년월일, 나이(만나이) 조회.
-- ㅇㅇㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함. 나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산함
-- 한국나이 : 현재년도 - 출생년도 + 1
-- 만나이 : 생일기준  truncate((오늘, 생일) / 365) 버림
select
    EMP_NAME 직원명,
    DEPT_CODE 부서코드,
    concat(
        case substr(emp_no,8,1)
            when '1' then 1900
            when '2' then 1900
            else 2000
        end + substr(emp_no,1,2),'년',
            + substr(emp_no,3,2),'월',
            + substr(emp_no,5,2),'일'
    ) 생년월일,
    truncate(datediff(now(),
        concat(
            case substr(emp_no,8,1)
                when '1' then 1900
                when '2' then 1900
                else 2000
            end + substr(emp_no,1,2),
                + substr(emp_no,3,2),
                + substr(emp_no,5,2))
        ) /365
    ,0) 만나이
from
    employee;

/*
11. 직원들의 입사일로 부터 년도만 가지고, 각 년도별 입사인원수를 구하시오.
아래형식으로 해당년도에 입사한 인원수를 조회하시오. (퇴사자 제외)

1998년 1999년 2000년 2001년 2002년 2003년 2004년 전체직원수
----------------------------------------------------------
0	     3	    1	     3	    0	     0	   1	     23
마지막으로 전체직원수도 구하시오 (Count or Sum)
 */
-- 가상컬럼 생성해서 데이터 준비
select
    emp_name,
    hire_date,
    case extract(year from hire_date) when 1998 then 1 end "1998",
    case extract(year from hire_date) when 1999 then 1 end "1999",
    case extract(year from hire_date) when 2000 then 1 end "2000",
    case extract(year from hire_date) when 2001 then 1 end "2001",
    case extract(year from hire_date) when 2002 then 1 end "2002",
    case extract(year from hire_date) when 2003 then 1 end "2003",
    case extract(year from hire_date) when 2004 then 1 end "2004"
from
    employee;

-- count는 null이 아닌 값만 센다
-- 해당조건을 만족하면 해당row에 값 1을 준다. (null이 아닌 어떤 값이라도 좋다.)
-- 설명 : count변수(특정컬럼을 센다)가 하나 있고, 매행마다, null이 아니라면 +1 count해줌.

select
    count(CASE extract(year from  HIRE_DATE) when 1998 then 1 end )"1998",
    count(CASE extract(year from  HIRE_DATE) when 1999 then 1 end )"1999",
    count(CASE extract(year from  HIRE_DATE) when 2000 then 1 end )"2000",
    count(CASE extract(year from  HIRE_DATE) when 2001 then 1 end )"2001",
    count(CASE extract(year from  HIRE_DATE) when 2002 then 1 end )"2002",
    count(CASE extract(year from  HIRE_DATE) when 2003 then 1 end )"2003",
    count(CASE extract(year from  HIRE_DATE) when 2004 then 1 end )"2004",
    count(*) 전체직원수
from
    employee
where
    QUIT_YN != 'Y';

-- 12. 부서코드가 D5이면 총무부, D6이면 기획부, D9이면 영업부로 처리하시오. (case 사용)
-- 단, 부서코드가 D5, D6, D9 인 직원의 정보만 조회하고, 부서코드 기준으로 오름차순 정렬함.
select
    emp_name,
    case DEPT_CODE
        when 'D5' then '총무부'
        when 'D6' then '기획부'
        when 'D9' then '영업부'
    end 부서
from
    employee
where
    DEPT_CODE in ('D5','D6','D9')
order by
    DEPT_CODE;