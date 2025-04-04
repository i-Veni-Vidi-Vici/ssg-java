select * from employee; -- 사원테이블
select * from job; -- 직급테이블
select * from department; -- 부서테이블
select * from location; -- 지역테이블
select * from nation; -- 국가테이블
select * from sal_grade; -- 급여등급테이블

select
    concat(substring(EMP_NO, 1,8), '******'),
       EMP_NAME,
       EMP_ID,
       SALARY
from
    employee
where instr(EMP_NO, 1) = 8
or instr(EMP_NO, 3) = 8;

select
    EMP_NAME,
    substring_index(EMAIL, '@',1)
from
    employee;

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

select
    file_no 파일번호,
    substring_index(file_path, '\\', -1) 파일명

from
    tbl_files
