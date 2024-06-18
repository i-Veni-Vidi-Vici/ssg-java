-- ✨계정 생성하는 sql✨
create user 'sh'@'%' identified by 'sh';
create database menudb;
grant all privileges on menudb.* to 'sh'@'%';

select user, host from mysql.user;
show grants for 'sh'@'%';