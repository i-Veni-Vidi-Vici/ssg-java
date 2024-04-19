-- 1. root계정 chundb생성
create database chundb;
show databases;
-- 2. sh계정이 chundb 접근 가능하도록 권한 부여
grant all privileges on chundb.* to'sh'@'%';
show grants for 'sh'@'%';
-- 3. sh계정으로 스키마 chundb 선택 후, chundb.sql 전체실행
-- 4. 쿼리를 통해 table 구조 파악
use chundb;
select * from TB_DEPARTMENT; --  학과테이블
select * from TB_STUDENT; -- 학생테이블
select * from TB_PROFESSOR; -- 교수테이블
select * from TB_CLASS; -- 수업테이블
select * from TB_CLASS_PROFESSOR; -- 수업교수테이블
select * from TB_GRADE; -- 학점테이블
-- -----------------------------------------------------------
