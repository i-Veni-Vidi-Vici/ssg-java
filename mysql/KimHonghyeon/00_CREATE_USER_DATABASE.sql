-- 한줄 주석
-- 한줄 주석
  /*
여러줄 주석
일부 주석
  */
-- 일반 사용자 생성
-- sql 문법은 대소문자 구분X But data부분의 대소문자는 정확히 구분
-- '사용자명'@'접속위치' -> 접속위치를 %로 지정하면 외부접속 허용
-- 접속위치를 localhost로 지정하면 내 컴퓨터에서만 접근 가능
use mysql;
show databases;
create user 'sh'@'%' identified by 'sh';
select * from user;
-- 데이터베이스(테이블 등의 객체가 보관되는 장소) 추가
-- mysql에서는 schema와 database가 같은 의미로 사용된다.
create schema menudb;
show databases;
grant all privileges on menudb.* to 'sh'@'%';
show grants for 'sh'@'%';