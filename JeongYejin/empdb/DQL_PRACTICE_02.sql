use empdb;
# 1. EMPLOYEE 테이블에서 남자만 사원번호, 사원명, 주민번호, 연봉을 나타내세요.
# 단, 주민번호의 뒷6자리는 *처리하세요.
select EMP_ID, EMP_NAME,
#        concat(substring_index(EMP_NO, '-', 1), '-******'),
#        concat(substr(EMP_NO, 1, 8), '******') 주민번호,
       rpad(substr(emp_no, 1, 8), 14, '*') 주민번호,
#        SALARY
       format((salary + (salary * ifnull(bonus, 0))) * 12, 0) 연봉
from employee
where substring(EMP_NO, 8, 1) = 1 || substring(EMP_NO, 8, 1) = 3
;

# 2. EMPLOYEE 테이블에서 사원명, 아이디(이메일 @ 앞부분)을 조회하세요.
select EMP_NAME, substring_index(EMAIL, '@', 1) as ID
from employee;

# 3. 파일경로를 제외하고 파일명만 아래와 같이 출력하세요.
select row_number() over () as 파일번호, substring_index(file_path, '\\', -1) as 파일명
from tbl_files;