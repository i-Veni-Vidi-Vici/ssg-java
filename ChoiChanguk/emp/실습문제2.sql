# 1. EMPLOYEE 테이블에서 남자만 사원번호, 사원명, 주민번호, 연봉을 나타내세요.
# 단, 주민번호의 뒷6자리는 `*`처리하세요.
use empdb;
select EMP_ID,
       EMP_NAME as 이름,
       SALARY as 연봉,
       insert(EMP_NO,9,6,'******') as 주민번호

from employee
where substr(EMP_NO,8,1)=1 ||substr(EMP_NO,8,1)=3;

# 2. EMPLOYEE 테이블에서 사원명, 아이디(이메일 @ 앞부분)을 조회하세요.
select EMP_NAME,EMAIL,
       substr(EMAIL,1,position('@'in EMAIL)-1)
#position("검색할문자" in "검색당하는문자") = 위치 반환
from employee;

# 3. 파일경로를 제외하고 파일명만 아래와 같이 출력하세요.
-- 테이블/데이터 설정
create table tbl_files (
                           file_no bigint,
                           file_path varchar(500)
);
-- drop table tbl_files
insert into tbl_files values(1, 'c:\\abc\\deft\\salesinfo.xls');
insert into tbl_files values(2, 'c:\\music.mp3');
insert into tbl_files values(3, 'c:\\documents\\resume.hwp');
commit;
select * from tbl_files;


# substring_index("검색당하는 문자열",'찾는 문자',찾는 문자 기준 앞에서 몇번째)
# 문제 같은 경우 '\\' 기준으로 기존 문자열이 나눠진다 그 후-> 뒤에 있는 문자열 1덩이 문자열을 반환한다
# cast (A as B) A를 B자료형으로 바꾼다
select cast(file_no as CHAR ) as 파일번호,substring_index(file_path,'\\',-1) as 파일이명
from tbl_files