#1. root계정 chundb생성
#2. sh계정이 chundb 접근 가능하도록 권한 부여
#3. sh계정으로 chundb.sql 전체 실행
#4. 쿼리를 통해 teble구조 파악
create schema chundb;
grant all privileges on chundb.* to 'sh'@'%';
-- sh사용자에게 부여된 권한 확인
show grants for 'sh'@'%';

select * from TB_DEPARTMENT;
select * from TB_STUDENT;
select * from TB_PROFESSOR;
select * from TB_CLASS;
select * from TB_CLASS_PROFESSOR;
select * from TB_GRADE;

