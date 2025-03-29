use menudb;

create table product1(
    id int primary key,
    name varchar(100),
    created_at datetime
);

select
    TABLE_COMMENT
from information_schema.TABLES
where
    TABLE_SCHEMA='menudb';

select
    COLUMN_NAME,
    COLUMN_COMMENT
from information_schema.columns
where
    TABLE_SCHEMA='menudb' and TABLE_NAME='product1';

create table product2(
    id int primary key auto_increment comment '상품식별번호',
    name varchar(100) not null comment '상품명',
    created_at datetime default (current_timestamp) comment '등록일시'
);
drop table product2;
desc product2;

insert into product2(name)
values ('메머드커피');
insert into product2(name)
values ('더벤티커피');
insert into product2(name)
values ('마우스');
select *
from product2;
delete from product2
where name='마우스';
insert into product2(name)
values ('모니터');

select
    last_insert_id();


create table product3(
    id int primary key,
    name varchar(100),
    created_at datetime
);
alter table product3
add price int default 1000 not null comment '가격' after name;
desc product3;

alter table product3
drop price;

alter table product3
change name prod_name varchar(10);

alter table product3
modify prod_name varchar(100) default '상품명X' not null after price;
desc product3;

alter table product3
modify prod_name varchar(100) default '상품명X' not null after price;
drop table if exists product3;
desc product3;

create table product5(
    id int auto_increment primary key,
    name varchar(100) not null,
    created_at datetime default (current_timestamp)
);
insert into
    product5(name)
values ('졸려죽겠다'), ('피곤하다');
select *
from product5 ;
