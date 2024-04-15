-- 한 줄 주석
# 한 줄  주석
/* 일부 주석  */
/*
    여러 줄 주석
 */


-- SQL 문법은 대소문자를 구분하지 않는다. 다만 데이터 부분의 대소문자는 정확히 구분
-- 일반 사용자 생성
show databases;
create user 'sh'@'%' identified  by 'sh';

-- 사용자 확인
show databases;
use mysql;


select * from user;

create database menudb;

grant all privileges on menudb.* to 'sh'@'%';

show grants for 'sh'@'%';