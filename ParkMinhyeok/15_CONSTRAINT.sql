-- ================================
-- CONSTRAINT
-- ================================
-- 제약조건. 테이블 작성시 각 컬럼에 대해서 값에 대한 제약을 작성할 수 있다.
-- 데이터무결성 보장을 목적으로 한다.
-- 데이터를 입력/수정시에 자동으로 제약조건에 부합하는지 검사

# 구분
-- 1. NOT NULL : null을 허용하지 않음
-- 2. UNIQUE : 중복된값을 허용하지 않음
-- 3. PRIMARY KEY : 기본키, 고유식별컬럼 (NOT NULL, UNIQUE)
-- 4. FOREIGN KEY : 외래키, 참조테이블의 참조컬럼값만 작성 가능
-- 5. CHECK : 지정한 도메인에서만 값 사용 가능


# 제약조건 조회
select
    *
from
    information_schema.TABLE_CONSTRAINTS
where
    CONSTRAINT_SCHEMA = 'empdb'
and TABLE_NAME = 'employee';

show create table empdb.EMPLOYEE;
/*
 CREATE TABLE `EMPLOYEE` (
  `EMP_ID` varchar(3) NOT NULL, -- 컬럼레벨
  `EMP_NAME` varchar(20) NOT NULL,
  `EMP_NO` char(14) NOT NULL,
  `EMAIL` varchar(25) DEFAULT NULL COMMENT '이메일',
  `PHONE` varchar(12) DEFAULT NULL COMMENT '전화번호',
  `DEPT_CODE` varchar(10) DEFAULT NULL COMMENT '부서코드',
  `JOB_CODE` varchar(10) NOT NULL,
  `SAL_LEVEL` char(2) NOT NULL,
  `SALARY` double DEFAULT NULL COMMENT '급여',
  `BONUS` double DEFAULT NULL COMMENT '보너스율',
  `MANAGER_ID` varchar(3) DEFAULT NULL COMMENT '관리자사번',
  `HIRE_DATE` datetime DEFAULT NULL COMMENT '입사일',
  `QUIT_DATE` datetime DEFAULT NULL COMMENT '퇴사일',
  `QUIT_YN` char(1) DEFAULT 'N' COMMENT '재직여부',
  PRIMARY KEY (`EMP_ID`), -- 테이블레벨
  UNIQUE KEY `IDX_EMPLOYEE_EMP_ID_PK` (`EMP_ID`),
  UNIQUE KEY `UQ_EMPLOYEE_EMP_NO` (`EMP_NO`),
  KEY `FK_EMPLOYEE_JOB` (`JOB_CODE`),
  KEY `FK_EMPLOYEE_DEPARTMENT` (`DEPT_CODE`),
  CONSTRAINT `FK_EMPLOYEE_DEPARTMENT` FOREIGN KEY (`DEPT_CODE`) REFERENCES `DEPARTMENT` (`DEPT_ID`),
  CONSTRAINT `FK_EMPLOYEE_JOB` FOREIGN KEY (`JOB_CODE`) REFERENCES `JOB` (`JOB_CODE`),
  CONSTRAINT `CK_EMPLOYEE_QUIT_YN` CHECK ((`QUIT_YN` in (_utf8mb4'Y',_utf8mb4'N')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='사원'
 */

 -- -----------------------------------------------
-- NOT NULL
 -- -----------------------------------------------
-- NULL 값을 허용하지 않는 제약조건
-- 컬럼레벨에만 작성가능하다.

create table if not exists user_notnull (
    user_no int not null,
    user_id varchar(50) not null,
    user_pwd varchar(50) not null,
    user_name varchar(50) not null,
    gender char(1),
    phone char(11) not null,
    email varchar(100)
);
desc user_notnull;

insert into
    user_notnull
values
    (1, 'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'),
    (2, 'sinsa', '1234', '신사임당', '여', '01056785678', 'sinsa@naver.com');
select * from user_notnull;
insert into
    user_notnull
values
    (3, 'leess', null, '이순신', '남', '01012341234', null); -- [23000][1048] Column 'user_pwd' cannot be null

insert into
    user_notnull (user_no, user_id, user_name, gender, phone)
values
    (3, 'leess', '이순신', '남', '01012341234'); -- [HY000][1364] Field 'user_pwd' doesn't have a default value

-- -----------------------------------------
-- UNIQUE
-- -----------------------------------------
-- 중복값을 허용하지 않는 제약조건
-- n개의 컬럼을 묶어서 복합 unique 제약조건도 가능하다.

create table if not exists user_unique (
    user_no int not null unique, -- (컬럼레벨) user_no 중복값을 허용하지 않는다.
    user_id varchar(50) not null,
    user_pwd varchar(50) not null,
    user_name varchar(50) not null,
    gender char(1),
    phone char(11) not null, -- unique 걸면 안된다.
    email varchar(100), -- unique
    constraint uq_user_unique_user_id unique(user_id), -- (테이블 레벨)
    constraint uq_user_unique_email unique(email)
);

-- 제약조건 확인
select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA = 'menudb'
        and TABLE_NAME = 'user_unique';

insert into
    user_unique
values
    (1, 'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'),
    (2, 'sinsa', '1234', '신사임당', '여', '01056785678', 'sinsa@naver.com');

select * from user_unique;

insert into
    user_unique
values
    (1, 'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'); -- [23000][1062] Duplicate entry '1' for key 'user_unique.user_no'

insert into
    user_unique
values
    (3, 'gogd', '1234', '고길동', '남', '01012341234', 'gogd@naver.com');

-- unique 제약조건이 걸림 컬럼은 null 을 허용한다.
-- unique 제약조건 컬럼은 null 값을 여러개 허용한다. (ms-sql 은 null 값도 고유하게 취급해 하나만 허용)
insert into
    user_unique
values
    (4, 'leess', '1234', '이순신', '남', '01012341234', null);
insert into
    user_unique
values
    (5, 'nondog', '1234', '논개', '여', '01012341234', null);

-- ---------------------------------------
-- PRIMARY KEY
-- ---------------------------------------
-- 고유식별컬럼을 지정하는 제약조건.
-- 테이블에서 딱 한 행을 구분해 내기 위한 값을 의미
-- 중복을 허용하지 않고, null을 허용하지 않는다.
-- 테이블당 1개의 PK를 허용.
-- n개의 컬럼을 묶어서 복합 PK로 지정이 가능하다.

create table if not exists user_primarykey (
    user_no int not null,
    user_id varchar(50) not null,
    user_pwd varchar(50) not null,
    user_name varchar(50) not null,
    gender char(1),
    phone char(11) not null,
    email varchar(100),
    constraint primary key(user_no),
    constraint uq_user_primarykey_user_id unique(user_id),
    constraint uq_user_primarykey_email unique(email)
);
select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA = 'menudb' and TABLE_NAME = 'user_primarykey';

show create table user_primarykey;

insert into
    user_primarykey
values
    (1, 'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'),
    (2, 'sinsa', '1234', '신사임당', '여', '01056785678', 'sinsa@naver.com');

select * from user_primarykey;

insert into
    user_primarykey
values
#     (1, 'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'); -- [23000][1062] Duplicate entry '1' for key 'user_primarykey.PRIMARY'
#     (null, 'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com');
        (3, 'leess', '1234', '리순신', '남', '01012341234', 'leess@naver.com');

# 복합 기본키
-- n개의 컬럼을 묶어서 고유하게 관리
create table tbl_order_composite_pk (
    prod_no int, -- 상품번호
    user_id varchar(50), -- 회원아이디
    count int default 1,
    order_date datetime default current_timestamp,
    primary key(prod_no, user_id, order_date)
);
select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA = 'menudb' and TABLE_NAME = 'tbl_order_composite_pk';

show create table tbl_order_composite_pk;

insert into
    tbl_order_composite_pk
values
    (100, 'honggd', 5, now());

select * from tbl_order_composite_pk;

insert into
    tbl_order_composite_pk
values
    (200, 'sinsa', 5, now());

-- 복합 pk 컬럼중 하나라도 null 일 수 없다.
insert into
    tbl_order_composite_pk(prod_no, user_id)
values
    (null, 'leess');

-- 조회
select *
from tbl_order_composite_pk
where
#     prod_no = 300 and user_id = 'leess' and order_date = '2024-04-23 11:19:26';
    (prod_no, user_id, order_date) = (300, 'leess', '2024-04-23 11:19:26');

-- 복합기본키 대안
create table tbl_order_composite_pk2 (
    id int auto_increment primary key, -- 식별번호
    prod_no int, -- 상품번호
    user_id varchar(50), -- 회원아이디
    count int default 1,
    order_date datetime default current_timestamp,
    unique (prod_no, user_id, order_date)
);
select *
from information_schema.TABLE_CONSTRAINTS
where TABLE_SCHEMA = 'menudb' and TABLE_NAME = 'tbl_order_composite_pk2';

insert into
    tbl_order_composite_pk2(prod_no, user_id)
values
    (null, 'leess');
select *
from tbl_order_composite_pk2;

select *
from tbl_order_composite_pk2
where id = 1;

-- ------------------------------------------------
-- FOREIGN KEY
-- ------------------------------------------------
-- 외래키, 참조 무결성 지원하기 위한 제약조건
-- 참조테이블에서 제공하는 값만 사용할수 있도록 하는 것.
-- 외래키를 통해서 테이블과 테이블간의 관계가 만들어진다. (Relational DBMS)
-- 참조테이블의 참조컬럼은 PK, UQ 제약조건이 걸려있어야 한다.
-- 제공되는 값외엔 NULL 을 허용한다.

create table user_grade
(
    grade_code int primary key,
    grade_name varchar(100) not null
);
insert into
    user_grade
values
    (10, '일반회원'),
    (20, '우수회원'),
    (30, 'vip회원');
select * from user_grade;

-- drop table user_foreignkey;
create table if not exists user_foreignkey (
       user_no int primary key,
       user_id varchar(50) not null,
       user_pwd varchar(50) not null,
       user_name varchar(50) not null,
       grade_code int,
       gender char(1),
       phone char(11) not null,
       email varchar(100),
       constraint fk_user_foreignkey_grade_code
           foreign key(grade_code)
           references user_grade(grade_code)
#            on update set null -- 부모행 참조컬럼이 수정되면, 자식 fk 컬럼을 null로 변경
#            on delete set null, -- 부모행이 삭제되면, 자식 fk 컬럼을 null로 변경
             on update cascade -- 부모값에 따라 자식값을 변경
             on delete cascade,
           constraint uq_user_foreignkey_user_id unique(user_id),
       constraint uq_user_foreignkey_email unique(email)
);
select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA = 'menudb' and TABLE_NAME = 'user_foreignkey';
show create table user_foreignkey;

insert into
    user_foreignkey
values
    (1, 'honggd', '1234', '홍길동', 10, '남', '01012341234', 'honggd@naver.com'),
    (2, 'sinsa', '1234', '신사임당', 20, '여', '01056785678', 'sinsa@naver.com');
select * from user_foreignkey;

-- [23000][1452] Cannot add or update a child row: a foreign key constraint fails (`menudb`.`user_foreignkey`, CONSTRAINT `fk_user_foreignkey_grade_code` FOREIGN KEY (`grade_code`) REFERENCES `user_grade` (`grade_code`))
insert into
    user_foreignkey
values
    (3, 'leess', '1234', '이순신', 50, '남', '01012341234', 'leess@naver.com');

-- [23000][1452] Cannot add or update a child row: a foreign key constraint fails (`menudb`.`user_foreignkey`, CONSTRAINT `fk_user_foreignkey_grade_code` FOREIGN KEY (`grade_code`) REFERENCES `user_grade` (`grade_code`))
update
    user_foreignkey
set
    grade_code = 50
where user_no = 1;

# 참조하는 자식행이 있는 경우 부모컬럼은 삭제/변경할 수 없다.
-- 1. 참조하는 자식행을 먼저 수정/삭제해야 한다.
-- 2. FK 제약조건에 on update set null 또는 on delete set null 옵션을 줄 수 있다.
-- -- [23000][1452] Cannot add or update a child row: a foreign key constraint fails (`menudb`.`user_foreignkey`, CONSTRAINT `fk_user_foreignkey_grade_code` FOREIGN KEY (`grade_code`) REFERENCES `user_grade` (`grade_code`))
delete from
   user_grade
where
    grade_code = 10;

-- tbl_menu -> tbl_category
show create table tbl_menu; -- 자식 fk 컬럼
show create table tbl_category; -- 부모 pk 컬럼
--   CONSTRAINT `fk_ref_category_code` FOREIGN KEY (`ref_category_code`) REFERENCES `tbl_category` (`category_code`)
-- 자기 참조 (같은 테이블 다른 컬럼을 참조, 상위 카테고리의 category_code 를 하위카테고리에서 ref_category_code 로 참조)

-- employee -> department
show create table empdb.EMPLOYEE;
show create table empdb.DEPARTMENT;

-- ----------------------------------------------
-- CHECK
-- ----------------------------------------------
-- 컬럼값을 도메인(값목록/범위)으로 제한하는 제약조건
create table if not exists user_check (
   user_no int primary key,
   user_id varchar(50) not null,
   user_pwd varchar(50) not null,
   user_name varchar(50) not null,
   gender char(1), -- 성별
   age int, -- 나이
   phone char(11) not null,
   email varchar(100),
   constraint ck_user_check_gender check (gender in ('M', 'F')),
   constraint ck_user_check_age check (age > 0),
   constraint uq_user_check_user_id unique(user_id),
   constraint uq_user_check_email unique(email)
);

select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA = 'menudb' and TABLE_NAME = 'user_check';

insert into
    user_check
values
    (1, 'honggd', '1234', '홍길동', 'M', 20, '01012341234', 'honggd@naver.com'),
    (2, 'sinsa', '1234', '신사임당', 'F', 40, '01056785678', 'sinsa@naver.com');
select * from user_check;

insert into
    user_check
values
#     (3, 'leess', '1234', '이순신', '남', 20, '01012341234', 'leess@naver.com'); -- [HY000][3819] Check constraint 'ck_user_check_gender' is violated.
    (3, 'leess', '1234', '이순신', '남', 20, '01012341234', 'leess@naver.com'); -- 소문자 m허용

insert into
    user_check
values
    (4, 'nondog', '1234', '논개', 'F', -1, '01012341234', 'nondog@naver.com'); -- [HY000][3819] Check constraint 'ck_user_check_age' is violated.

update
    user_check
set
    age = age - 20
where
    user_no = 1; -- [HY000][3819] Check constraint 'ck_user_check_age' is violated.

-- 대소문자 구분이 필요한 경우
create table if not exists user_check (
    user_no int primary key,
    user_id varchar(50) not null,
    user_pwd varchar(50) not null,
    user_name varchar(50) not null,
    gender char(1), -- 성별
    age int, -- 나이
    phone char(11) not null,
    email varchar(100),
    constraint ck_user_check_gender check (binary gender in ('M', 'F')), -- 대소문자 구분이 필요한 경우
    constraint ck_user_check_age check (age > 0),
    constraint uq_user_check_user_id unique(user_id),
constraint uq_user_check_email unique(email)
);

# default
-- 컬럼값이 주어지지 않았을 경우 대입되는 기본값
-- date 타입 : 기본값 current_date
-- datetime 타입 : 기본값 current_time, current_timestamp, now() 사용
-- 날짜/시간 관련 default 값은 괄호를 꼭 감싸준다.
create table tbl_rent (
    rent_id int auto_increment primary key,
    contractor_name varchar(50) default '익명',
    car_name varchar(50),
    rent_date date default (current_date),
    rent_time time default (current_time),
    created_at datetime default (current_timestamp)
);

desc tbl_rent;
insert into
    tbl_rent(car_name)
values
    ('그랜져');
select * from tbl_rent;

insert into
    tbl_rent
values (
        null, '홍길동', '소나타', default, default, default
       );

# auto_increment
-- primary key 가 지정된 정수형컬럼에서 사용할 수 있다.
-- 중복되지 않는 숫자를 발급.
-- 특정숫자값을 직접 지정가능하다. 해당 숫자는 auto_increment 가 건너뛰게 된다.
-- truncate table 을 통해서 reset 할 수 있다.

create table if not exists product2 (
    id int auto_increment primary key comment '상품식별번호',
    name varchar(10) not null comment '상품명',
    created_at datetime default (current_timestamp) comment '등록일시'
) comment = '상품테이블2';
desc product2;

insert into
    product2 (name)
values (
        '일양전구'
       );
select * from product2;
delete
from product2
where id = 3; -- 3번을 삭제하면, 다시는 3번을 발행하지 않는다.

-- 마지막 발급된 번호 가져오기
select last_insert_id();

-- ---------------------------------------
-- ALTER
-- ---------------------------------------
-- 테이블객체를 수정하는 DDL 문
-- 컬럼을 추가/수정/삭제/이름변경 할 수 있다.
-- 제약조건을 추가/삭제 할 수 있다.

# 서브 명령어 구분
-- add : 컬럼/제약조건 추가
-- drop : 컬럼/제약조건 삭제
-- modify : 컬럼 자료형/not null/auto_increment/순서 변경
-- change : 컬럼명 변경
-- rename : 테이블명 변경

create table product3 (
  id int,
  name varchar(10),
  created_at datetime
);

desc product3;

-- 컬럼 추가
alter table product3
add price int default 1000 not null comment '가격' after name; -- 자료형 기본값 not null comment 순서(first | after 컬럼명)

-- 컬럼 삭제
alter table product3
drop price;

-- 컬럼명 변경 (자료형 필수)
alter table product3
change name prod_name varchar(10);

-- 컬럼 자료형/기본값/not null 변경
alter table product3
modify prod_name varchar(100) default '상품명 없음' not null after price;

-- 제약조건 추가
alter table product3
add primary key(id);

-- auto_increment 추가는 modify 사용
alter table product3
modify id int auto_increment;

-- 제약조건 제거
-- auto_increment 가 적용되어 있을때, PK는 제거할 수 없다.
alter table product3
drop primary key;

alter table product3
modify id int;

desc product3;

-- alter 문은 여러개 서브명령어를 동시에 사용가능
alter table product3
# add point tinyint

alter
# add expires at date not null

