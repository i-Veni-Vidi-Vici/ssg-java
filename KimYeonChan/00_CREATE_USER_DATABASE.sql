-- 한줄 주석
# 한줄 주석
/* 일부 주석 */
/*
    여러줄 주석
*/

-- SQL 문법은 대소문자를 구분하지 않는다. 다만 데이터 부분의 대소문자는 정확히 구분한다.

-- 일반사용자 생성
-- - '사용자명'@'접속위치' %로 지정하면 외부 접속을 허용한다.
-- - localhost 로 지정하면 내 컴퓨터에서만 접근 가능하다.
create user 'sh'@'%' identified by 'sh';

-- 사용자 확인
show databases;
use mysql;
select * from user;

-- 데이터베이스(테이블 등의 객체가 보관되는 장소) 추가
-- mysql 에서는 schema 와 database 가 같은 의미로 사용된다.
create database menudb;
# create schema menudb;

-- sh 사용자에게 menudb를 사용할 수 있는 권한을 부여한다.
-- 사용자와 user 와 database(schema)는 별개의 객체이다.
-- 한 사용자가 n개의 db를 사용할 수 도 있고, 한 db를 여러명의 사용자가 제어할 수 있다.
grant all privileges on menudb.* to 'sh'@'%';

-- sh 사용자에게 부여된 권한 확인
show grants for 'sh'@'%';