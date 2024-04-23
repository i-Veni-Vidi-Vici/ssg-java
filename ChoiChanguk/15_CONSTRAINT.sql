-- ========================================
-- CONSTRAINT
-- ========================================
-- 제약 조건. 테이플 작성시 각 컬럼에 대해서 값에 대한 제약을 작성할 수 있다.
-- 데이터무결성 보장을 목적으로 한다
-- 데이터를 입력/수정시에 자동으로 제약조건에 부합하는지 검사

# 구분
-- 1. NOT NULL : null을 허용하지 않음
-- 2. UNIQUE : 중복된 값을 허용하지 않음
-- 3. PRIMARY KEY : 기본키, 고유식별컬럼 (NOT NULL, UNIQUE)
-- 4. FOREIGN KEY : 외래키, 참조테이플의 참조컬럼값만 작성 가능
-- 5. CHECK : 지정한 도메인에서만 값 사용 가능

# 제약조건 조회
SELECT *
from
    information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA='menudb'
and TABLE_NAME='tbl_menu';

-- ddl을 통해 확인
show create table empdb.job;
/*

*/

-- ----------------------------------------
-- NOT NULL
-- ----------------------------------------
-- NULL값을 허용하지 않는 제약조건
-- 컬럼레벨에만 작성가능하다.

create table if not exists user_notnull(
    user_no int not null ,
    user_id varchar(10) not null,
    user_pwd varchar(50) not null ,
    user_name varchar(50) not null ,
    gender char(1),
    phone char(11) not null ,
    email varchar(100)
);
drop table user_nutnull;
desc user_nutnull;

insert into
user_notnull
values
    (1,'honggd','1234','홍길동','남','01012344567','hongged@naver.com'),
 (2,'sinsa','1234','신사임당','여','01047784467','sinsa@naver.com');

select *
from user_notnull;

insert into
 user_notnull
values (3,'lesss',null,'이순신','남','010478843367','lesss@naver.com'); #[23000][1048] Column 'user_pwd' cannot be null

insert into
 user_notnull (user_no, user_id, user_name, gender, phone) # not null이 있기 때문에 오류

create table if not exists user_unique
(
    user_no   int         not null unique , -- 컬럼레벨 user_no 중복값을 허용하지 않는다
    user_id   varchar(10) not null,
    user_pwd  varchar(50) not null,
    user_name varchar(50) not null,
    gender    char(1),
    phone     char(11)    not null, -- unique 요즘은 안한다
    email     varchar(100), -- unique 걸어도 괜찮다
    constraint uq_user_unique_user_id unique(user_id),-- 테이블 레벨
    constraint uq_user_unique_user_email unique(email)-- 테이블 레벨
);

desc user_unique;
select *
from information_schema.TABLE_CONSTRAINTS
where TABLE_NAME='user_unique'
and CONSTRAINT_SCHEMA='menudb';

insert into
    user_unique
values
    (1,'honggd','1234','홍길동','남','01012344567','hongged@naver.com'),
    (2,'sinsa','1234','신사임당','여','01047784467','sinsa@naver.com');

insert into
    user_unique
values (2,'sinsa','1234','신사임당','여','01047784467','sinsa@naver.com');
#[23000][1062] Duplicate entry '2' for key 'user_unique.user_no'

-- unique제약조건이 걸린 컬럼은 null을 허용한다
-- unique제약조건 컬럼은 null값을 여러개 허용한다 (ms-sql은 null값도 고유하게 취급해 하나만 허용)
-- 겹치지만 않으면 되지, 없은 건 상관없다
insert into user_unique
values (4,'lesss','1234','이순신','남','01012344789',null);

insert into user_unique
values (5,'cstangga','1234','최창욱','남','01078944789',null);

select *
from user_unique;

-- ----------------------------------------
-- PRIMARY KEY
-- ----------------------------------------
-- 고유식별컬럼을 지정하는 제약조건
-- 테이블에서 딱 한 행을 구분해 내기 위한 값을 의미
-- 중복 및 null 허용하지 않음
-- 테이블당 1개의 pk를 허용함
-- n개의 컬럼을 묶어서 복합 pk로 지저이 가능

create table if not exists user_primarykey
(
    user_no   int          , -- 컬럼레벨 user_no 중복값을 허용하지 않는다
    user_id   varchar(10) not null,
    user_pwd  varchar(50) not null,
    user_name varchar(50) not null,
    gender    char(1),
    phone     char(11)    not null, -- unique 요즘은 안한다
    email     varchar(100), -- unique 걸어도 괜찮다
    primary key(user_no), -- 기본키는 굳이 제약조건 지정할 필요 없음
    constraint uq_user_primary_user_id unique (user_id),
    constraint uq_user_primary_user_email unique (email)
);

desc user_primarykey;

select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA='menudb' and TABLE_NAME='user_primarykey';

insert into
    user_primarykey
values
    (1,'honggd','1234','홍길동','남','01012344567','hongged@naver.com'),
    (1,'sinsa','1234','신사임당','여','01047784467','sinsa@naver.com');
-- [23000][1062] Duplicate entry '1' for key 'user_primarykey.PRIMARY'
insert into
    user_primarykey
values
    (1,'honggd','1234','홍길동','남','01012344567','hongged@naver.com'),
    (null,'sinsa','1234','신사임당','여','01047784467','sinsa@naver.com');
-- [23000][1048] Column 'user_no' cannot be null

insert into
    user_primarykey
    values
    (5,'cstangga','1234','최창욱','남','01078944789',null);

select *
from user_primarykey;

# 복합 기본키
-- n개의 컬럼을 묶어서 고유하게 관리
create table tbl_order_composite_pk(
    prod_no int, -- 상품번호
    user_id varchar(50),
    count int default 1,
    order_date datetime default current_timestamp,
    primary key (prod_no,user_id,order_date)
);

select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA='menudb' and TABLE_NAME='tbl_order_composite_pk';
show create table tbl_order_composite_pk;
/*
CREATE TABLE `tbl_order_composite_pk` (
  `prod_no` int NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `count` int DEFAULT '1',
  `order_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`prod_no`,`user_id`,`order_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
*/
desc tbl_order_composite_pk;

insert into
tbl_order_composite_pk
values (100,'honggd',5,now());

insert into
    tbl_order_composite_pk
values (200,'sinsa',1,now());

insert into
    tbl_order_composite_pk (prod_no, user_id)
values ('300','leess');

select *
from tbl_order_composite_pk;

-- 복합 pk컴럼중 하나라도 null일 수는 없다
insert into
    tbl_order_composite_pk (null, user_id)
values ('300','leess');

-- 조회 -- 어떻게보면 단점이 될 수도 있다
select *
from tbl_order_composite_pk

where prod_no=300 and
      user_id='leess'
and order_date='2024-04-23 11:19:32';
# (prod_no, user_id, order_date) = (300,'leess','2024-04-23 11:19:32'); 이렇게도 검색 가능

-- 복합키본기의 대안
create table tbl_order_composite_pk2(
    prod_no int primary key auto_increment, -- 상품번호
    user_id varchar(50),
    count int default 1,
    order_date datetime default current_timestamp,
    unique (prod_no,user_id,order_date)
);

insert into
    tbl_order_composite_pk2 (prod_no, user_id)
values ('300','leess');

-- -----------------------------------------
-- FOREIGN KEY
-- -----------------------------------------
-- 외래키, 참조무결성 지원하기 위한 제약조건
-- 참조테이블에서 제공하는 값만 사용할 수 있도록 하는 것.
-- 외래키를 통해서 테이블과 테이블 간의 관계가 만들어진다. (Relational DBMS)
-- 참조테이블의 참조컬럼은 PK, UQ제약조건이 걸려있어야 한다
-- 제공되는 값외엔 NULL을 허용한다

create table user_grade(
    grade_code int primary key ,-- 회원등급
    grade_name varchar(100) not null
);

insert into
user_grade
values (10,'일반회원'),(20,'우수회원'),(30,'VIP회원');

select *
from user_grade;
-- drop table user_foreignkey
create table user_foreignkey
(
    user_no   int primary key ,                  -- 컬럼레벨 user_no 중복값을 허용하지 않는다
    user_id   varchar(10) not null,
    user_pwd  varchar(50) not null,
    user_name varchar(50) not null,
    grade_code int,
    gender    char(1),
    phone     char(11)    not null, -- unique 요즘은 안한다
    email     varchar(100),         -- unique 걸어도 괜찮다
    constraint fk_user_foreignkey_grade_code foreign key (grade_code)
        references user_grade(grade_code)
        on update set null -- 부모가 참조컬림이 수정되면, 자식FK컬럼을 null로 변경
        on delete set null -- 부모가 참조컬림이 삭제되면, 자식FK컬럼을 null로 변경
        on update cascade
        
    constraint uq_user_foreignkey_user_id unique (user_id),
    constraint uq_user_foreignkey_user_email unique (email)

);

select *
from user_foreignkey;

select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA='menudb' and TABLE_NAME='user_foreignkey';

insert into
user_foreignkey
values
(1,'honggd','1234','홍길동',10,'남','01012344567','hongged@naver.com'),
(2,'sinsa','1234','신사임당',20,'여','01047784467','sinsa@naver.com');

insert into
    user_foreignkey
values
    (3,'cstangga','1234','신사임당',50,'남','01047784467','sinsa@naver.com');
# 본 테이블에 없는 grade_code써서 안들어감 10,20,30
# [23000][1062] Duplicate entry 'sinsa@naver.com' for key 'user_foreignkey.uq_user_foreignkey_user_email'

# 본래 것이 아니라면 못바꾼다
update user_foreignkey
 set
     grade_code=50
where user_no=1;

만약에 부모데이터가 변경되면? -> 변경/삭제 불가
1. 참조하는 자식행을 먼저 수정/삭제 해야 한다
2. FK제약조건에, on update set null 이거나 on delete set null 옵션을 줄 수 있다.
delete from user_grade
where grade_code=10;

select *
from user_foreignkey;

select *
from user_grade;

show create table empdb.employee;

/*
CREATE TABLE `employee` (
  `EMP_ID` varchar(3) NOT NULL,
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
  PRIMARY KEY (`EMP_ID`), --------- 기본키
  UNIQUE KEY `IDX_EMPLOYEE_EMP_ID_PK` (`EMP_ID`),
  UNIQUE KEY `UQ_EMPLOYEE_EMP_NO` (`EMP_NO`),
  KEY `FK_EMPLOYEE_JOB` (`JOB_CODE`),
  KEY `FK_EMPLOYEE_DEPARTMENT` (`DEPT_CODE`),
  CONSTRAINT `FK_EMPLOYEE_DEPARTMENT` FOREIGN KEY (`DEPT_CODE`) REFERENCES `department` (`DEPT_ID`),
  CONSTRAINT `FK_EMPLOYEE_JOB` FOREIGN KEY (`JOB_CODE`) REFERENCES `job` (`JOB_CODE`),
  CONSTRAINT `CK_EMPLOYEE_QUIT_YN` CHECK ((`QUIT_YN` in (_utf8mb4'Y',_utf8mb4'N')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='사원'
*/

show create table tbl_category;
-- 같은 테이블 다른 컬럼을 참조, 상위카테고리의 category_code를 하위 카테고리 ref_category_code 를 참조
# CONSTRAINT `fk_ref_category_code` FOREIGN KEY (`ref_category_code`) REFERENCES `tbl_category` (`category_code`)

-- ---------------------------------------
-- CHECK
-- ---------------------------------------
-- 컬럼값을 도메인(값목록/범위)으로 제한하는 제약조건

create table if not exists user_check
(
    user_no   int primary key,      -- 컬럼레벨 user_no 중복값을 허용하지 않는다
    user_id   varchar(10) not null,
    user_pwd  varchar(50) not null,
    user_name varchar(50) not null,
    gender    char(1),
    age       int,
    phone     char(11)    not null, -- unique 요즘은 안한다
    email     varchar(100),         -- unique 걸어도 괜찮다
    constraint ck_user_check_gender check ( gender in ('M','F') ),
    -- 대소문자를 구분하고 싶다면 binary써라
    constraint ch_user_check_age check ( age>0 ),
    constraint uq_user_check_user_id unique (user_id),
    constraint uq_user_check_user_email unique (email)
);

select *
from information_schema.TABLE_CONSTRAINTS
where TABLE_NAME='user_check' and
      CONSTRAINT_SCHEMA='menudb';

insert into
    user_check (user_no, user_id, user_pwd, user_name, gender, age, phone, email)
values
    (1,'honggd','1234','홍길동','M',10,'01012344567','hongged@naver.com'),
    (2,'sinsa','1234','신사임당','F',20,'01047784467','sinsa@naver.com');

insert into
    user_check (user_no, user_id, user_pwd, user_name, gender, age, phone, email)
values
    (3,'leess','1234','이순신','남',10,'01012344567','hongged@naver.com');
#[HY000][3819] Check constraint 'ck_user_check_gender' is violated // 남 으로 젠더를 설정해서 안됨

update user_check
set age=age-50;
SELECT *
FROM user_check;

# default
-- 컬럼값이 주어지지 않았을 경우 대입되는 기본값
-- date타입 : 기본값 current_date
-- datetime타입 : 기본값 current_time, current_timestamp, now() 사용
-- 날짜/시간 관련 default 값은 괄호를 감싸줘야 한다
create table tbl_rent (
    rent_id int auto_increment primary key ,
    contractor_name varchar(50),
    car_name varchar(50),
    rent_date date default (current_date),
    rent_time time default (current_time),
    create_at datetime default (current_timestamp)
);
desc tbl_rent;

insert into
tbl_rent(car_name)
values ('그랜져');

insert into
    tbl_rent()
values (null,'홍길동','소나타',default,default,default);

select *
from tbl_rent;

# auto_increment
-- primary key가 지정된 정수형 컬럼에서 사용할 수 있다.
-- 중복되지 않는 숫자를 발급 - 중간에 튜플이 없어져도 그 다음 숫자를 발급한다
-- 특정숫자값을 직접 지정가능하다. 해당 숫자는 auto_increment는 건너뛰게 된다
-- truncate table을 통해서 reset할 수 잇다.

create table if not exists product2
(
    id        int auto_increment primary key comment '상품식별번호',
    name      varchar(10) not null comment '상품명',
    create_at datetime default (current_timestamp) comment '등록일시'
) comment = '상품테이블1';

desc product2;

insert into
product2 (name)
values ('일양전구');

select *
from product2;

-- 마지막 발급된 번호 가져오기
select last_insert_id();

-- ----------------------------------
-- ALTER
-- ----------------------------------
-- 테이블객체를 수정하는 DDL문
-- 컬컴을 추가/수정/삭제 이름변경 할 수 있다.
-- 제약조건을 추가/삭제 할 수 있다.

# 서브 명령어 구분
-- add : 컬럼 추가/제얀조건 추가
-- drop : 컬럼/제약조건 삭제
-- modify : 컬럼 자료형/not null 제약 조건 변경/auto_increament/ 순서 명령
-- change : 컴럼명 변경
-- rename : 테이블명 변경

create table product3(
    id int,
    name varchar(10),
    created_at datetime
);

select *
from product3;

create table if not exists product4(
    in int,
    name varchar(10),
    create_at datetime

);

-- ----------------------------
-- TRUNCATE
-- ----------------------------
-- 테이블의 모든 행을 잘라내느 DDL
-- where절 없는 delete(DML) 대비 속도 빠르다 (DML의 before image작업이 없기 때문)
-- auto_increment컬럼도 초기화된다

create table product5(
    id int auto_increment primary key ,
    name varchar(100) not null ,
    created_at datetime default (current_timestamp)
);

select *
from product5;

insert into product5(name)
values ('한증막투어'),
       ('아쿠아리움투어'),
       ('맛집투어');


truncate table product5;