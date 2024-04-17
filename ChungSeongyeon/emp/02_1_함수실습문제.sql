-- ---------------------------
-- 함수 실습문제 # 113
-- ---------------------------

# 1. 직원명과 이메일 , 이메일 길이를 출력하시오
#
#     ```
#     홍길동 [hong@kh.or.kr](mailto:hong@kh.or.kr) 13
#     ```
select
    concat(EMP_NAME, ' [', EMAIL, '](mailto:', EMAIL, ') ', length(EMAIL)) 출력결과
from employee;

# 2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하시오
#
#     ```
#     노옹철	no_hc
#     정중하	jung_jh
#     ```
select
    EMP_NAME 이름,
    substring_index(EMAIL, '@', 1) 아이디
from employee;

# 3. 60년대에 태어난 직원명과 년생, 보너스 값을 출력하시오 그때 보너스 값이 null인 경우에는 0 이라고 출력 되게 만드시오
#
#     ```
#     선동일	1962	0.3
#     송은희	1963	0
#     ```
select
    EMP_NAME 직원명,
    concat('19', substring(EMP_NO, 1, 2)) 년생,
    ifnull(BONUS, 0) 보너스
from
    employee
where
    substring(EMP_NO, 1, 2) between '60' and '69'
  and substring(EMP_NO, 8, 1) in ('1', '2');

# 4. '010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하시오 (뒤에 단위는 명을 붙이시오)
#
#     ```
#     3명
#     ```
select concat(count(*),'명') 010아님
from employee
where PHONE not like '010%';

# 5. 직원명과 입사년월을 출력하시오. 단, 아래와 같이 출력되도록 만들어 보시오
#
#     ```
#     전형돈	2012년12월
#     전지연	1997년 3월
#     ```
select
    EMP_NAME 직원명,
    concat(year(HIRE_DATE), '년 ', month(HIRE_DATE), '월') 입사년월
from
    employee;

# 6. 직원명과 주민번호를 조회하시오
# 단, 주민번호 9번째 자리부터 끝까지는 '*' 문자로 채워서출력 하시오*
#
#     ```
#     *홍길동 771120-1*****
#     ```
select
    EMP_NAME 직원명,
    concat(substring(EMP_NO, 1, 8), '******') 주민번호
from employee;

# 7. 직원명, 직급코드, 연봉(원) 조회
# 단, 연봉은 ￦57,000,000 으로 표시되게 함.
# (연봉은 보너스포인트가 적용된 1년치 급여)
select
    EMP_NAME 직원명,
    JOB_CODE 직급코드,
    concat('￦', format((SALARY + (SALARY * ifnull(BONUS, 0))), 0)) 연봉
from
    employee;

# 8. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원중에 조회함.
# (사번 사원명 부서코드 입사일)
select
    EMP_ID 사번,
    EMP_NAME 사원명,
    DEPT_CODE 부서코드,
    HIRE_DATE 입사일
from
    employee
where
    year(HIRE_DATE) = 2004
  and DEPT_CODE in ('D5', 'D9');

# 9. 직원명, 입사일, 오늘까지의 근무일수 조회
#     - 주말도 포함 , 소수점 아래는 버림
#     - 퇴사자는 퇴사일-입사일로 계산
select
    EMP_NAME 직원명,
    HIRE_DATE 입사일,
    floor(datediff(if(QUIT_DATE is null, now(), QUIT_DATE), HIRE_DATE) * 5 / 7)
        + (datediff(if(QUIT_DATE is null, now(), QUIT_DATE), HIRE_DATE) mod 7) 근무일수
from
    employee;

select
    EMP_NAME 직원명,
    HIRE_DATE 입사일,
    floor((datediff(ifnull(QUIT_DATE, now()), HIRE_DATE) * 5 / 7)
              + (datediff(ifnull(QUIT_DATE, now()), HIRE_DATE) mod 7)) 근무일수
from
    employee;

# 10. 직원명, 부서코드, 생년월일, 나이(만나이) 조회
# 단, 생년월일은 주민번호에서 추출해서,
# ㅇㅇㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
# 나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산함
select
    EMP_NAME 직원명,
    DEPT_CODE 부서코드,
    CONCAT(substring(EMP_NO, 1, 2) + if(substring(EMP_NO, 1, 1) = '0', 2000, 1900), '년 ',
           substring(EMP_NO, 3, 2), '월 ',
           substring(EMP_NO, 5, 2), '일') 생년월일,
    year(now()) - (substring(EMP_NO, 1, 2) + if(substring(EMP_NO, 1, 1) = '0', 2000, 1900))
        - if(date_format(now(), '%m%d') < substring(EMP_NO, 3, 4), 1, 0) 나이
from
    employee;

# 11. 직원들의 입사일로 부터 년도만 가지고, 각 년도별 입사인원수를 구하시오.
# 아래형식으로 해당년도에 입사한 인원수를 조회하시오. (퇴사자 제외)
# 마지막으로 전체직원수도 구하시오 (decode, sum 사용)
#
#     ```
#     1998년 1999년 2000년 2001년 2002년 2003년 2004년 전체직원수
#     ----------------------------------------------------------
#     0	     3	    1	     3	    0	     0	   1	     23
#     ```
-- if, sum 사용
select
    sum(if(year(HIRE_DATE) = 1998, 1, 0)) 1998년,
    sum(if(year(HIRE_DATE) = 1999, 1, 0)) 1999년,
    sum(if(year(HIRE_DATE) = 2000, 1, 0)) 2000년,
    sum(if(year(HIRE_DATE) = 2001, 1, 0)) 2001년,
    sum(if(year(HIRE_DATE) = 2002, 1, 0)) 2002년,
    sum(if(year(HIRE_DATE) = 2003, 1, 0)) 2003년,
    sum(if(year(HIRE_DATE) = 2004, 1, 0)) 2004년,
    count(*) 전체직원수
from
    employee
where
    QUIT_YN = 'N';

-- case, sum 사용
select
    sum(case when year(HIRE_DATE) = 1998 then 1 else 0 end) 1998년,
    sum(case when year(HIRE_DATE) = 1999 then 1 else 0 end) 1999년,
    sum(case when year(HIRE_DATE) = 2000 then 1 else 0 end) 2000년,
    sum(case when year(HIRE_DATE) = 2001 then 1 else 0 end) 2001년,
    sum(case when year(HIRE_DATE) = 2002 then 1 else 0 end) 2002년,
    sum(case when year(HIRE_DATE) = 2003 then 1 else 0 end) 2003년,
    sum(case when year(HIRE_DATE) = 2004 then 1 else 0 end) 2004년,
    count(*) 전체직원수
from
    employee
where
    QUIT_YN = 'N';

# 12. 부서코드가 D5이면 총무부, D6이면 기획부, D9이면 영업부로 처리하시오. (case 사용)
# 단, 부서코드가 D5, D6, D9 인 직원의 정보만 조회하고, 부서코드 기준으로 오름차순 정렬함.
select
    EMP_NAME 직원명,
    DEPT_CODE 부서번호,
    case
        when DEPT_CODE = 'D5' then '총무부'
        when DEPT_CODE = 'D6' then '기획부'
        when DEPT_CODE = 'D9' then '영업부'
        end 부서명,
    EMP_ID 사번,
    EMP_NO 주민등록번호,
    EMAIL 이메일,
    PHONE 전화번호,
    JOB_CODE 직급코드,
    SAL_LEVEL 급여등급,
    SALARY 급여,
    BONUS 보너스,
    MANAGER_ID 관리자사번,
    HIRE_DATE 입사일,
    QUIT_DATE 퇴사일,
    QUIT_YN 재직여부
from
    employee
where
    DEPT_CODE in ('D5', 'D6', 'D9')
order by
    DEPT_CODE asc;

