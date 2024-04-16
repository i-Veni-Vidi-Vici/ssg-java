use empdb;

-- 함수 실습문제 #113
select *
from employee;
# 1
select EMP_NAME, EMAIL, char_length(EMAIL)
from employee;
# 2
select EMP_NAME, substring_index(EMAIL, '@', 1) EMAIL_ID
from employee;
# 3
select EMP_NAME, substr(EMP_NO, 1, 2) BIRTH_YEAR, ifnull(BONUS, 0) BONUS
from employee
where substr(EMP_NO, 1, 1) = 6;
# 4
select concat(count(*), '명') '010이 아닌 사람 수'
from employee
where substr(PHONE, 1, 3) != 010;
# 5
select EMP_NAME,
       IF(substr(DATE_FORMAT(HIRE_DATE, '%Y년%m월'), 6, 1) = 0, CONCAT(YEAR(HIRE_DATE), '년 ', MONTH(HIRE_DATE), '월'), DATE_FORMAT(HIRE_DATE, '%Y년%m월'))
as HIRE_DATE_YM
from employee;
# 6
select EMP_NAME, rpad(substr(emp_no, 1, 8), 14, '*') 주민번호
from employee;
# 7
select EMP_NAME
from employee;
# 8
select *
from employee;
# 9
select *
from employee;
# 10
select *
from employee;
# 11
select *
from employee;
# 12
select *
from employee;