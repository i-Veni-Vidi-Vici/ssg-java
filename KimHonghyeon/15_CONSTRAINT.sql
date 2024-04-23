use empdb;

select *
from information_schema.TABLE_CONSTRAINTS
where
    CONSTRAINT_SCHEMA = 'empdb'
    and TABLE_NAME='employee';

create table if not exists user_notnull(
    user_no int not null,
    user_id varchar(50) not null,
    user_pwd varchar(50) not null,
    user_name varchar(50) not null,
    gender char(1),
    phone char(11) not null,
    email varchar(100)

);

drop table user_notnull;
desc user_notnull;

insert into user_notnull
values(1,'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'),
      (2,'sinsa', '1134', '신사임당', '여', '01011141234', 'sinsa@naver.com');

create table if not exists user_notnull(
    user_no int not null unique,
    user_id varchar(50) not null unique,
    user_pwd varchar(50) not null,
    user_name varchar(50) not null,
    gender char(1),
    phone char(11) not null,
    email varchar(100),
    constraint uq_user_notnull_email unique(email)
);
drop table user_notnull;
desc user_notnull;

select *
from information_schema.TABLE_CONSTRAINTS
where
    CONSTRAINT_SCHEMA='empdb'
    and TABLE_NAME='user_notnull';

insert into user_notnull
values(1,'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'),
      (2,'sinsa', '1134', '신사임당', '여', '01011141234', 'sinsa@naver.com');

select *
from user_notnull;
insert into user_notnull
values(1,'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com');

create table if not exists user_primary_key(
    user_no int,
    user_id varchar(50) not null unique,
    user_pwd varchar(50) not null,
    user_name varchar(50) not null,
    gender char(1),
    phone char(11) not null,
    email varchar(100),
    constraint uq_user_notnull_email unique(email),
    constraint pk_user_primary_key_user_no primary key(user_no),
    constraint uq_user_primary_key_user_id unique(user_id)
);

drop table user_primary_key;

select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA='empdb' and TABLE_NAME='user_primary_key';

insert into user_primary_key
values(1,'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'),
      (2,'sinsa', '1134', '신사임당', '여', '01011141234', 'sinsa@naver.com');

insert into user_primary_key
values(null,'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com');

use menudb;

create table tbl_order_composite_pk(
    prod_no int,
    user_id varchar(50),
    count int default 1,
    order_date datetime default current_timestamp,
    primary key(prod_no,user_id, order_date)
);

select
    *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA='menudb' and TABLE_NAME='tbl_order_composite_pk';

insert into tbl_order_composite_pk
values(100,'honggd',5,now()),
(100,'sinsa',3,now());

select *
from tbl_order_composite_pk;

select *
from tbl_order_composite_pk
where prod_no=100 and user_id='honggd' and order_date='2024-04-23 11:18:15';

create table tbl_order_composite_pk2(
    id int auto_increment primary key,
                                       prod_no int,
                                       user_id varchar(50),
                                       count int default 1,
                                       order_date datetime default current_timestamp,
                                       unique(prod_no,user_id, order_date)
);

insert into tbl_order_composite_pk2
(prod_no, user_id, count, order_date)
values(100,'honggd',5,now()),
      (100,'sinsa',3,now());

select *
from tbl_order_composite_pk2
where id=2;

create table user_grade(
    grade_code int primary key,
    grade_name varchar(100) not null
);

insert into
    user_grade
values
    (10,'일반회원'),
    (20,'우수회원'),
    (30, 'VIP회원');

create table if not exists user_foreign_key(
    user_no int primary key,
    user_id varchar(50) not null unique,
    user_pwd varchar(50) not null,
    user_name varchar(50) not null,
    grade_code int,
    gender char(1),
    phone char(11) not null,
    email varchar(100),
    constraint uq_user_foreign_email unique(email),
    constraint uq_user_foreign_key_user_id unique(user_id),
    constraint fk_user_foreign_key_grade_code foreign key(grade_code) references user_grade(grade_code) on update set null on delete set null
);

select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA = 'menudb' and TABLE_NAME='user_foreign_key';

insert into user_foreign_key
values(1,'honggd', '1234', '홍길동', 10,'남', '01012341234', 'honggd@naver.com'),
      (2,'sinsa', '1134', '신사임당',20 ,'여', '01011141234', 'sinsa@naver.com');

insert into user_foreign_key
values(2,'leess', '1234', '홍길동', 20,'남', '01012341234', 'lss@naver.com');

update user_foreign_key
set grade_code =50
where user_no=1;

select *
from user_foreign_key;

delete from user_foreign_key
where grade_code =20;

drop table user_grade;
drop table user_foreign_key;

create table user_grade(
    grade_code int primary key,
    grade_name varchar(100) not null
);

insert into
    user_grade
values
    (10,'일반회원'),
    (20,'우수회원'),
    (30, 'VIP회원');

show create table empdb.employee;
show create table empdb.department;
drop table user_check;
create table if not exists user_check(
user_no int primary key,
user_id varchar(50) not null unique,
user_pwd varchar(50) not null,
user_name varchar(50) not null,
age int not null ,
grade_code int,
gender char(1),
phone char(11) not null,
email varchar(100),
constraint uq_user_check_email unique(email),
constraint uq_user_check_user_id unique(user_id),
constraint ck_user_check_gender check(gender in ('M', 'F')),
constraint ck_user_check_age check(age>0),
constraint fk_user_check_grade_code foreign key(grade_code) references user_grade(grade_code) on update set null on delete set null
);
insert into user_check
values(1,'honggd', '1234', '홍길동', 20,10,'M', '01012341234', 'honggd@naver.com'),
      (2,'sinsa', '1134', '신사임당',40,20,'F', '01011141234', 'sinsa@naver.com');

select *
from user_check;

create table tbl_rent(
    rent_id int auto_increment primary key,
    contractor_name varchar(50) default '익명',
    car_name varchar(50),
    rent_date date default (current_date),
    rent_time time default (current_time),
    created_at datetime default current_timestamp
);

desc tbl_rent;

insert into tbl_rent(car_name)
values ('Avante');
select *
from tbl_rent;