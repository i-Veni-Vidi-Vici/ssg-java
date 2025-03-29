-- =================
-- CONSTRAINT
-- =================
-- 제약조건. 테이블 작성 시 각 컬럼에 대해 값에 대한 제약을 작성할 수 있음
-- 데이터 무결성 보장을 목적으로 함
-- 데이터 입력/수정 시 자동으로 제약조건에 부합하는지 검사

# 구분
-- 1. NOT NULL : null을 허용하지 않음
-- 2. UNIQUE : 중복된 값 허용하지 않음
-- 3. PRIMARY KEY : 기본키, 고유식별컬럼 (not null, unique 기능 포함)
-- 4. FOREIGN KEY : 외래키, 참조테이블의 참조컬럼값만 작성 가능
-- 5. CHECK : 지정한 도메인에서만 값 사용 가능
  
# 제약조건 조회
select *
from information_schema.TABLE_CONSTRAINTS
where
    CONSTRAINT_SCHEMA = 'empdb' and
    TABLE_NAME = 'employee';

-- ddl 통해 확인
show create table empdb.employee;
/*
 CREATE TABLE `employee` (
  `EMP_ID` varchar(3) NOT NULL, -- 컬럼 레벨(컬럼 선언시 옆에 작성)
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

 -- 테이블 레벨 (컬럼 선언 끝나고 한줄로 작성한 경우)
 PRIMARY KEY (`EMP_ID`),
  UNIQUE KEY `IDX_EMPLOYEE_EMP_ID_PK` (`EMP_ID`),
  UNIQUE KEY `UQ_EMPLOYEE_EMP_NO` (`EMP_NO`),
  KEY `FK_EMPLOYEE_JOB` (`JOB_CODE`),
  KEY `FK_EMPLOYEE_DEPARTMENT` (`DEPT_CODE`),
  CONSTRAINT `FK_EMPLOYEE_DEPARTMENT` FOREIGN KEY (`DEPT_CODE`) REFERENCES `department` (`DEPT_ID`),
  CONSTRAINT `FK_EMPLOYEE_JOB` FOREIGN KEY (`JOB_CODE`) REFERENCES `job` (`JOB_CODE`),
  CONSTRAINT `CK_EMPLOYEE_QUIT_YN` CHECK ((`QUIT_YN` in (_utf8mb4'Y',_utf8mb4'N')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='사원'
 */

-- ----------------
-- NOT NULL
-- ----------------
-- NULL 값을 허용하지 않는 제약조건
-- 컬럼레벨에만 작성 가능

# drop table user_notnull;
create table if not exists user_notnull(
    user_no int not null,
    user_id varchar(50) not null,
    user_pwd varchar(50) not null,
    user_name varchar(50) not null,
    gender char(1),
    phone char(11) not null,
    email varchar(100)
);

desc user_notnull;

insert into user_notnull
values
    (1, 'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'),
    (2, 'sinsa', '1234', '신사임당', '여', '01056785678', 'sinsa@naver.com');

select *
from user_notnull;

# insert into user_notnull
# values
#     (3, 'leess', null, '이순신', '남', '01012341234', null); -- [23000][1048] Column 'user_pwd' cannot be null

# insert into user_notnull(user_no, user_id, user_name, gender, phone)
# values (3, 'leess', '이순신', '남', '01012341234'); -- [HY000][1364] Field 'user_pwd' doesn't have a default value

-- -------------------
-- UNIQUE
-- -------------------
-- 중복값을 허용하지 않는 제약조건
-- n개의 컬럼을 묶어서 복합 unique 제약조건도 가능

create table if not exists user_unique(
      user_no int not null unique, -- (컬럼레벨 작성 ver.) user_no 중복값을 허용하지 않음
      user_id varchar(50) not null,
      user_pwd varchar(50) not null,
      user_name varchar(50) not null,
      gender char(1),
      phone char(11) not null, -- 핸드번번호에는 unique 사용X (가입된 번호를 다른 사람이 사용하게 될 경우 해당 사이트에 새로운 유저의 가입 불가)
      email varchar(100),
      constraint uq_user_unique_user_id unique(user_id), -- (테이블레벨 작성 ver.)
      constraint uq_user_unique_user_email unique(email)
);

-- 제약조건 확인
select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA = 'menudb' and
      TABLE_NAME = 'user_unique';

insert into user_unique
values
    (1, 'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'),
    (2, 'sinsa', '1234', '신사임당', '여', '01056785678', 'sinsa@naver.com');

select *
from user_unique;

# insert into user_unique
# values
#     (1, 'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com');
-- [23000][1062] Duplicate entry '1' for key 'user_unique.user_no'

insert into user_unique
values
    (3, 'gogd', '1234', '고길동', '남', '01012341234', 'gogd@naver.com');

-- unique 제약조건이 걸린 컬럼은 null 허용
insert into user_unique
values
    (4, 'leess', '1234', '이순신', '남', '01012341234', null);

-- unique 제약조건 컬럼은 null값 여러개 허용 (ms-sql은 null값도 고유하게 취급해 하나만 허용)
insert into user_unique
values
    (5, 'nondog', '1234', '논개', '여', '01012341234', null);

-- ------------------
-- PRIMARY KEY
-- ------------------
-- 기본키, 주키
-- 고유식별컬럼을 지정하는 제약조건
-- 테이블에서 딱 한 행을 구분하기 위한 값
-- 중복을 허용하지 않고, NULL을 허용하지 않음
-- 테이블 당 1개의 PK 허용
-- n개의 컬럼을 묶어서 복합 PK로 지정 가능

create table if not exists user_primarykey(
    user_no int,
    user_id varchar(50) not null,
    user_pwd varchar(50) not null,
    user_name varchar(50) not null,
    gender char(1),
    phone char(11) not null,
    email varchar(100),
    primary key(user_no), -- primary key 이름은 지정할 필요없음
    constraint uq_user_primarykey_user_id unique(user_id),
    constraint uq_user_primarykey_email unique(email)
);

select *
from information_schema.TABLE_CONSTRAINTS
where
    CONSTRAINT_SCHEMA = 'menudb' and
    TABLE_NAME = 'user_primarykey';

insert into user_primarykey
values
    (1, 'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'),
    (2, 'sinsa', '1234', '신사임당', '여', '01056785678', 'sinsa@naver.com');

select *
from user_primarykey;

insert into user_primarykey
values
#    (1, 'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'), -- [23000][1062] Duplicate entry '1' for key 'user_primarykey.PRIMARY'
#    (null, 'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'), -- [23000][1048] Column 'user_no' cannot be null
    (3, 'leess', '1234', '리순신', '남', '01012341234', 'leess@naver.com');

# 복합 기본키
-- n개의 컬럼을 묶어서 고유하게 관리
create table tbl_order_composite_pk(
    prod_no int, -- 상품번호
    user_id varchar(50), -- 회원아이디
    count int default 1,
    order_date datetime default current_timestamp,
    primary key (prod_no, user_id, order_date)
);

select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA = 'menudb' and
      TABLE_NAME = 'tbl_order_composite_pk';

insert into tbl_order_composite_pk
values (
        100, 'honggd', 5, now()
       );

select *
from tbl_order_composite_pk;

insert into tbl_order_composite_pk
values (
           200, 'sinsa', 1, now()
       );

insert into tbl_order_composite_pk(prod_no, user_id)
values (
           300, 'leess'
       );

-- 복합 pk 컬럼중 하나라도 null이면 안됨
insert into tbl_order_composite_pk(prod_no, user_id)
values (
           null, 'leess'
       ); -- [23000][1048] Column 'prod_no' cannot be null

-- 조회 : 모든 pk 컬럼 where절에서 비교
select *
from tbl_order_composite_pk
where
#    prod_no = 300 and
#    user_id = 'leess' and
#    order_date = '2024-04-23 11:20:55'
    (prod_no, user_id, order_date) = (300, 'leess', '2024-04-23 11:20:55');

-- 복합 기본키 대안
create table tbl_order_composite_pk2(
    id int auto_increment primary key, -- 식별번호 별도 지정
    prod_no int, -- 상품번호
    user_id varchar(50), -- 회원아이디
    count int default 1,
    order_date datetime default current_timestamp,
    unique (prod_no, user_id, order_date) -- 기본키였던 것을 유니크로 변경
);

insert into tbl_order_composite_pk2(prod_no, user_id)
values (
        300, 'leess'
);

-- 조회 : 위보다 더 간편해짐
select * from tbl_order_composite_pk2 where id = 1;

-- ------------------
-- FOREIGN KEY
-- ------------------
-- 외래키. 참조 무결성 지원하기 위한 제약조건
-- 참조테이블에서 제공하는 값만 사용할 수 있도록 함
-- 외래키를 통해 테이블과 테이블 간의 관계가 만들어짐 (Relational DBMS)
-- 참조테이블(user_grade)의 참조컬럼(grade_code)은 PK, UQ 제약조건이 있어야 함
-- 제공되는 값 외에 null 허용
create table user_grade(
    grade_code int primary key,
    grade_name varchar(100) not null
);

insert into user_grade
values
    (10, '일반회원'),
    (20, '우수회원'),
    (30, 'VIP회원');

select * from user_grade;

-- drop table user_foreignkey;
create table if not exists user_foreignkey(
     user_no int primary key,
     user_id varchar(50) not null,
     user_pwd varchar(50) not null,
     user_name varchar(50) not null,
     grade_code int, -- 참조 컬럼
     gender char(1),
     phone char(11) not null,
     email varchar(100),
     constraint fk_user_foreignkey_grade_code
         foreign key (grade_code) references user_grade(grade_code)
         on update set null -- 부모행 참조컬럼이 수정되면, 자식 fk컬럼을 null로 변경
         on delete set null, -- 부모행이 삭제되면, 자식 fk컬럼을 null로 변경
#        on update cascade, -- 부모행 참조컬럼이 수정되면, 자식 fk컬럼 수정
#        on delete cascade, -- 부모행이 삭제되면, 자식행도 삭제
     constraint uq_user_foreignkey_user_id unique(user_id),
     constraint uq_user_foreignkey_email unique(email)
);

select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA = 'menudb' and
      TABLE_NAME = 'user_foreignkey';

insert into user_foreignkey
values
    (1, 'honggd', '1234', '홍길동', 10, '남', '01012341234', 'honggd@naver.com'),
    (2, 'sinsa', '1234', '신사임당', 20, '여', '01056785678', 'sinsa@naver.com');

select *
from user_foreignkey;

# insert into user_foreignkey
# values
#    (3, 'leess', '1234', '이순신', 50, '남', '01012341234', 'leess@naver.com');
/*
[23000][1452] Cannot add or update a child row: a foreign key constraint fails (`menudb`.`user_foreignkey`, CONSTRAINT
`fk_user_foreignkey_grade_code` FOREIGN KEY (`grade_code`) REFERENCES `user_grade` (`grade_code`))
 */

update user_foreignkey
set grade_code = 50
where user_id = 1; -- [22001][1292] Data truncation: Truncated incorrect DOUBLE value: 'honggd'

# 참조하는 자식행이 있는 경우 부모 컬럼은 삭제/변경할 수 없음
-- 1. 참조하는 자식행을 먼저 수정/삭제해야함
-- 2. fk제약조건에 on update set null, on delete set null 옵션을 줄 수 있음
# delete from user_grade
# where grade_code = 10;
/*
 [23000][1451] Cannot delete or update a parent row: a foreign key constraint fails (`menudb`.`user_foreignkey`,
 CONSTRAINT `fk_user_foreignkey_grade_code` FOREIGN KEY (`grade_code`) REFERENCES `user_grade` (`grade_code`))
 */ -- -> 위의 2번을 자식테이블 생성시 작성하면 오류X/삭제됨

-- tbl_menu -> tbl_category
show create table tbl_menu;
-- 자식 fk컬럼) CONSTRAINT `fk_category_code` FOREIGN KEY (`category_code`) REFERENCES `tbl_category` (`category_code`)
show create table tbl_category;
-- 부모 pk컬럼) PRIMARY KEY (`category_code`),
-- 자기참조 (같은 테이블 다른 컬럼을 참조, 상위 카테고리의 category_code를 하위카테고리 ref_category_code가 참조)
-- CONSTRAINT `fk_ref_category_code` FOREIGN KEY (`ref_category_code`) REFERENCES `tbl_category` (`category_code`)

-- employee -> department
show create table empdb.employee;
-- CONSTRAINT `FK_EMPLOYEE_DEPARTMENT` FOREIGN KEY (`DEPT_CODE`) REFERENCES `department` (`DEPT_ID`),
show create table empdb.department;
-- PRIMARY KEY (`DEPT_ID`),

-- ----------------
-- CHECK
-- ----------------
-- 컬럼값을 도메인(값목록/범위)으로 제한
-- drop table user_check;
create table if not exists user_check(
      user_no int primary key,
      user_id varchar(50) not null,
      user_pwd varchar(50) not null,
      user_name varchar(50) not null,
      gender char(1), -- 성별
      age int, -- 나이
      phone char(11) not null,
      email varchar(100),
      constraint ck_user_check_gender check (binary gender in ('M', 'F')), -- 대소문자 구분이 필요한 경우 binary 키워드 사용
      constraint ck_user_check_age check (age > 0),
      constraint uq_user_check_user_id unique(user_id),
      constraint uq_user_check_email unique(email)
);

select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA = 'menudb' and
      TABLE_NAME = 'user_check';

insert into user_check
values
    (1, 'honggd', '1234', '홍길동', 'M', 20, '01012341234', 'honggd@naver.com'),
    (2, 'sinsa', '1234', '신사임당', 'F', 40, '01056785678', 'sinsa@naver.com');

select * from user_check;

insert into user_check
values
#    (3, 'leess', '1234', '이순신', '남', 20, '01012341234', 'leess@naver.com'), -- [HY000][3819] Check constraint 'ck_user_check_gender' is violated.
#    (4, 'nondog', '1234', '논개', 'F', -1, '01012341234', 'nondog@naver.com'), -- [HY000][3819] Check constraint 'ck_user_check_age' is violated.
    (5, 'leess', '1234', '이순신', 'm', 20, '01012341234', 'leess@naver.com'); -- [HY000][3819] Check constraint 'ck_user_check_gender' is violated.

# update user_check
# set age = age - 20
# where user_no = 1; -- [HY000][3819] Check constraint 'ck_user_check_age' is violated.