select * from employee; -- 사원테이블
select * from job; -- 직급테이블
select * from department; -- 부서테이블
select * from location; -- 지역테이블
select * from nation; -- 국가테이블
select * from sal_grade; -- 급여등급테이블

-- 1. 직원명과 이메일 , 이메일 길이를 출력하시오
select EMP_NAME,
       EMAIL,
       char_length(EMAIL)
from employee;

-- 2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하시오
select EMP_NAME,
       substring_index(EMAIL, '@', 1)
from employee;

-- 3. 60년대에 태어난 직원명과 년생, 보너스 값을 출력하시오 그때 보너스 값이 null인 경우에는 0 이라고 출력 되게 만드시오
select EMP_NAME,
       concat('19', substring(EMP_NO, 1, 2)),
       ifnull(BONUS, 0)
#        cast(substring(EMP_NO, 1, 2) as signed integer ) between 60 and 69
from employee
where cast(substring(EMP_NO, 1, 2) as signed integer ) between 60 and 69;

-- 4. '010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하시오 (뒤에 단위는 명을 붙이시오)
select
    concat(sum(substring(PHONE, 1, 3) != 010), '명')
from employee;

select concat(count(*), '명')
from employee
where substring(PHONE, 1, 3) != 010;

-- 5. 직원명과 입사년월을 출력하시오. 단, 아래와 같이 출력되도록 만들어 보시오
select EMP_NAME,
       if(substring(date_format(HIRE_DATE, '%Y년%m월'), -3, 1) = 0,
          replace(date_format(HIRE_DATE, '%Y년%m월'), '년0' ,'년 '),
          date_format(HIRE_DATE, '%Y년%m월'))
from employee;

-- 6. 직원명과 주민번호를 조회하시오. 단, 주민번호 9번째 자리부터 끝까지는 '' 문자로 채워서출력 하시오
select EMP_NAME,
       replace(EMP_NO, substring(EMP_NO, 9, 6), '******')
from employee;

-- 7. 직원명, 직급코드, 연봉(원) 조회.
-- 단, 연봉은 ￦57,000,000 으로 표시되게 함. (연봉은 보너스포인트가 적용된 1년치 급여)
select EMP_NAME 직원명,
       JOB_CODE 직급코드,
#        (SALARY * 12) + (SALARY * ifnull(BONUS, 0)),
       concat('￦', format((SALARY * 12) + (SALARY * ifnull(BONUS, 0)), 0))
from employee;