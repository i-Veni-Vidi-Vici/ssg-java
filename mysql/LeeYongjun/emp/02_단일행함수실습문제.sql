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
select * from employee;
#1
select
    EMP_ID as 사원번호,
    EMP_NAME as 사원명,
    concat(SUBSTRING(EMP_NO,1,8),'******') as 주민번호,
    SALARY as 연봉
from employee
where instr(EMP_NO,1) =8 or instr(EMP_NO,3) = 8;

#2

select EMP_NAME as 사원명,
       substring_index(EMAIL,'@','1') as 아이디
from employee;

#3
select file_no as 파일번호,
       substring_index(file_path,'\\',-1) as 파일명
from tbl_files