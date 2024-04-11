-- 한줄 주석
# 한줄 주석
/*

 여러줄 주석

 */

-- SQL 문법은 대소문자 구분 X, 데이터부분 O

show databases;


-- 일반 사용자 생성
-- '사용자명'@'접속위치'
-- -%로 지정하면 외부접속 허용한다
-- - localhost로 지정하면 내 컴퓨터에서만 접근 가능
create user 'sh'@'%' identified by 'sh';

show databases;
use mysql;

select * from user;

-- 데이터베이스(테이블 등의 객체가 보관되는 장소) 추가
-- mysql에서는 shema와 database가 같은 의미
create database menudb;
-- create schema menudb;

-- sh사용자에게 menudb를 사용할수 있는 권한 부여
-- 사용자 user와 database(schema)는 별개의 객체
-- 한 사용자 n 개의 db를 사용 가능, 한 db를 n명 사용자가 사용 가능

grant all privileges on menudb.* to 'sh'@'%';

show grants for 'sh'@'%';






