# 1. 직원명과 이메일 , 이메일 길이를 출력하시오
select EMP_NAME as 이름,
       EMAIL as 이메일,
       char_length(EMAIL) as 이메일_길이
from employee;

# 2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하시오
select EMP_NAME as 이름,
       substring_index(EMAIL,'@',1) as 메일_아이디
from employee;

# 3. 60년대에 태어난 직원명과 년생, 보너스 값을 출력하시오 그때 보너스 값이 null인 경우에는 0 이라고 출력 되게 만드시오
select EMP_NAME as 이름, concat('19',substring(EMP_NO,1,2),'년생') as 년생, ifnull(BONUS,0) as 보너스
from employee
where substring(EMP_NO,1,2) between 60 and 69;

# 4. 010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하시오 (뒤에 단위는 명을 붙이시오)
select concat(count(*),'명') as 010_안쓰는_사람
from employee
where substring(PHONE, 1, 3) not like '010';

# 5. 직원명과 입사년월을 출력하시오. 단, 아래와 같이 출력되도록 만들어 보시오
#
#     ```
#     전형돈	2012년12월
#     전지연	1997년 3월
#     ```
select EMP_NAME,date_format(HIRE_DATE,'%Y년%c월') as 입사년
from employee;

# 6. 직원명과 주민번호를 조회하시오
# 단, 주민번호 9번째 자리부터 끝까지는 '' 문자로 채워서출력 하시오
select EMP_NAME as 이름, insert(EMP_NO,9,6,'******') as 주민번호
from employee;

# 7. 직원명, 직급코드, 연봉(원) 조회
#단, 연봉은 ￦57,000,000 으로 표시되게 함.
#(연봉은 보너스포인트가 적용된 1년치 급여)
select EMP_NAME as 이름, JOB_CODE as 직급코드, concat(SALARY+(SALARY*ifnull(BONUS,0)),'원') as 연봉
from employee;

# 8.  부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원중에 조회함.
# (사번 사원명 부서코드 입사일)
select MANAGER_ID as 사원명,EMP_NAME as 이름, DEPT_CODE as 부서코드,HIRE_DATE as 입사일
from employee
where (DEPT_CODE = 'D5' || DEPT_CODE = 'D9') && substring(HIRE_DATE,3,2)='04';

# 9. 직원명, 입사일, 오늘까지의 근무일수 조회
#     - 주말도 포함 , 소수점 아래는 버림
#     - 퇴사자는 퇴사일-입사일로 계산
select EMP_NAME as 이름, date_format(HIRE_DATE,'%Y-%m-%d') as 입사일, datediff(ifnull(QUIT_DATE,now()),HIRE_DATE) as 근무일수
from employee;

# 10. 직원명, 부서코드, 생년월일, 나이(만나이) 조회
# 단, 생년월일은 주민번호에서 추출해서,
# ㅇㅇㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
# 나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산함

select EMP_NAME as 이름, DEPT_CODE as 코드,
case
    when substring(EMP_NO,8,1) in ('1','2')
        then concat('19',date_format(substring(EMP_NO,1,6),'%y년 %m월 %d일'))
    else date_format(substring(EMP_NO,1,6),'%Y년 %m월 %d일')
end as 생년월일,
case
    when substring(EMP_NO,8,1) in ('1','2')
        then round(datediff(now(),concat('19',date_format(substring(EMP_NO,1,6),'%y-%m-%d')))/365)
    else round(datediff(now(),date_format(substring(EMP_NO,1,6),'%Y-%m-%d'))/365,0)
end as 만_나이
from employee;

# 11. 직원들의 입사일로 부터 년도만 가지고, 각 년도별 입사인원수를 구하시오.
# 아래형식으로 해당년도에 입사한 인원수를 조회하시오. (퇴사자 제외)
# 마지막으로 전체직원수도 구하시오 (decode, sum 사용)

select
    year(HIRE_DATE) as 입사년도,
    concat(count(HIRE_DATE),'명') as 인원
from employee
group by year(HIRE_DATE) with rollup ;

# 12. 부서코드가 D5이면 총무부, D6이면 기획부, D9이면 영업부로 처리하시오. (case 사용)
# 단, 부서코드가 D5, D6, D9 인 직원의 정보만 조회하고, 부서코드 기준으로 오름차순 정렬함.
select
from employee;

select *
from employee;
