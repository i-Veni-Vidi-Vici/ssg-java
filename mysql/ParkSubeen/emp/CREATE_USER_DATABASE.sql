show databases;

create database empdb;

create user 'sh'@'%' identified by 'sh';

grant all privileges on empdb.* to 'sh'@'%';

show grants for 'sh'@'%';