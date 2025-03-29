use menudb;

create table kb_bank(
    id int primary key,
    name varchar(100) not null,
    balance bigint check(balance>=0)
);

create table ssg_bank(
    id int primary key,
    name varchar(100) not null,
    balance bigint check(balance>=0)
);

insert into kb_bank values (1000, '홍길동', 1000000);
insert into ssg_bank values (2000, '신사임당', 1000000);

start transaction;

update kb_bank
set
    balance = balance-5000
where id=1000;

update ssg_bank
set
    balance = balance+5000
where id=2000;

select *
from kb_bank;
commit;

