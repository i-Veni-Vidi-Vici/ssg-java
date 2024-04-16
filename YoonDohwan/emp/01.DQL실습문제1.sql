show databases;
create database empdb;
grant all privileges on empdb.* to 'sh'@'%';

show grants for 'sh'@'%';

select * from EMPLOYEE;
select * from job;
select * from DEPARTMENT;
select * from LOCATION;
select * from nation;
select * from sal_grade;

select
    *
    from EMPLOYEE
where
emp_name like '%연';

select
    *
    from EMPLOYEE


