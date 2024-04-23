-- ======================================
-- CONSTRAINT
-- ======================================
-- 제약조건. 테이블 작성시 각 컬럼에 대해서 값에 대한 제약을 작성할 수 있다.
-- 데이터무결성 보장을 목적으로 한다.
-- 데이터를 입력/수정시에 자동으로 제약조건에 부합하는지 검사

# 구분
-- 1. NOT NULL : null을 허용하지 않음
-- 2. UNIQUE : 중복된 값을 허용하지 않음
-- 3. PRIMARY KEY : 기본키, 고유식별컬럼 (NOT NULL, UNIQUE)
-- 4. FOREIGN KEY : 외래키, 참조테이블의 참조컬럼값만 작성 가능
-- 5. CHECK : 지정한 도메인에서만 값 사용 가능

# 제약조건 조회
select
    *
from
    information_schema.table_constraints
where
    constraint_schema = 'empdb'
    and table_name = 'employee';
-- ddl을 통해 확인
show create table empdb.employee;
/*
CREATE TABLE `employee` (
---------------------------------------
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
------------------------------------------------ -- 컬럼레벨
------------------------------------------------
  PRIMARY KEY (`EMP_ID`), -- 테이블레벨
  UNIQUE KEY `IDX_EMPLOYEE_EMP_ID_PK` (`EMP_ID`),
  UNIQUE KEY `UQ_EMPLOYEE_EMP_NO` (`EMP_NO`),
  KEY `FK_EMPLOYEE_JOB` (`JOB_CODE`),
  KEY `FK_EMPLOYEE_DEPARTMENT` (`DEPT_CODE`),
  CONSTRAINT `FK_EMPLOYEE_DEPARTMENT` FOREIGN KEY (`DEPT_CODE`) REFERENCES `department` (`DEPT_ID`),
  CONSTRAINT `FK_EMPLOYEE_JOB` FOREIGN KEY (`JOB_CODE`) REFERENCES `job` (`JOB_CODE`),
  CONSTRAINT `CK_EMPLOYEE_QUIT_YN` CHECK ((`QUIT_YN` in (_utf8mb4'Y',_utf8mb4'N')))
------------------------------------------------ -- 테이블레벨
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='사원'
*/

-- -------------------------------------------
-- NOT NULL
-- -------------------------------------------
-- NULL값을 허용하지 않는 제약조건
-- 컬럼레벨에만 작성가능하다.

-- 테이블 잘못 생성시 삭제 코드
-- drop table user_notnull;

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

-- --------------------------------------
-- UNIQUE
-- --------------------------------------
-- 중복값을 허용하지 않는 제약조건
-- n개의 컬럼을 묶어서 복합unique 제약조건도 가능하다.

create table if not exists user_unique (
    user_no int not null unique, -- (컬럼레벨) user_no 중복값을 허용하지 않는다.
    user_id varchar(50) not null,
    user_pwd varchar(50) not null,
    user_name varchar(50) not null,
    gender char(1),
    phone char(11) not null,
    email varchar(100),
    constraint uq_user_unique_user_id unique(user_id), -- (테이블 레벨)
    constraint uq_user_unique_email unique(email)
);

-- 제약조건 확인
select
    *
from
    information_schema.TABLE_CONSTRAINTS
where
    CONSTRAINT_SCHEMA = 'menudb'
    and TABLE_NAME = 'user_unique';

insert into
    user_unique
values
    (1, 'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'),
    (2, 'sinsa', '1234', '신사임당', '여', '01056785678', 'sinsa@naver.com');

insert into
    user_unique
values
    (3, 'gogd', '1234', '고길동', '남', '01012341234', 'gogd@naver.com');
-- [23000][1062] Duplicate entry '1' for key 'user_unique.user_no'
-- [23000][1062] Duplicate entry 'honggd' for key 'user_unique.uq_user_unique_user_id'
-- [23000][1062] Duplicate entry 'honggd@naver.com' for key 'user_unique.uq_user_unique_email'

-- unique제약조건이 걸린 컬럼은 null을 허용한다.
-- unique제약조건 컬럼은 null값을 여러개 허용한다. (ms-sql은 null값도 고유하게 취급해 하나만 허용)
insert into
    user_unique
values
    (4, 'leess', '1234', '이순신', '남', '01012341234', null);

insert into
    user_unique
values
    (5, 'nondog', '1234', '논개', '여', '01012341234', null);

select * from user_unique;

-- ---------------------------------
-- PRIMARY KEY
-- ---------------------------------
-- 고유식별컬럼을 지정하는 제약조건. (기본키, 주키)
-- 테이블에서 딱 한행을 구분해 내기 위한 값을 의미
-- 중복을 허용하지 않고, NULL을 허용하지 않는다.
-- 테이블당 한개의 PK를 허용.
-- n개의 컬럼을 묶어서 복합 PK로 지정이 가능하다.

create table if not exists user_primarykey (
    user_no int,
    user_id varchar(50) not null,
    user_pwd varchar(50) not null,
    user_name varchar(50) not null,
    gender char(1),
    phone char(11) not null,
    email varchar(100),
    constraint primary key(user_no), -- PRIMARY KEY 이름은 지정할 필요 없음
    constraint uq_user_primaryuser_id unique(user_id),
    constraint uq_user_primaryuser_email unique(email)
);

select
    *
from
    information_schema.TABLE_CONSTRAINTS
where
    CONSTRAINT_SCHEMA = 'menudb'
    and TABLE_NAME = 'user_primarykey';

show create table user_primarykey;

insert into
    user_primarykey
values
    (1, 'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'),
    (2, 'sinsa', '1234', '신사임당', '여', '01056785678', 'sinsa@naver.com');

insert into
    user_primarykey
values
#     (1, 'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'); -- [23000][1062] Duplicate entry '1' for key 'user_primarykey.PRIMARY'
#     (null, 'honggd', '1234', '홍길동', '남', '01012341234', 'honggd@naver.com'); -- [23000][1048] Column 'user_no' cannot be null
    (3, 'leess', '1234', '리순신', '남', '01012341234', 'leess@naver.com');

select * from user_primarykey;

# 복합 기본키
-- n개의 컬럼을 묶어서 고유하게 관리
create table tbl_order_composite_pk (
    prod_no int, -- 상품번호
    user_id varchar(50), -- 회원아이디
    count int default 1,
    order_date datetime default current_timestamp,
    primary key(prod_no, user_id, order_date)
);

select
    *
from
    information_schema.TABLE_CONSTRAINTS
where
    CONSTRAINT_SCHEMA = 'menudb'
    and TABLE_NAME = 'tbl_order_composite_pk';

show create table tbl_order_composite_pk;

insert into
    tbl_order_composite_pk
values (
    100, 'honggd', 5, now()
);

insert into
    tbl_order_composite_pk
values (
    200, 'sinsa', 1, now()
);

insert into
    tbl_order_composite_pk(prod_no, user_id)
values (
    300, 'leess'
);

-- 복합 pk컬럼 중 하나라도 null일 수 없다.
insert into
    tbl_order_composite_pk(prod_no, user_id)
values (
    null, 'leess'
); -- [23000][1048] Column 'prod_no' cannot be null

select * from tbl_order_composite_pk;

-- 조회
select
    *
from
    tbl_order_composite_pk
where
#     prod_no = 300
#   and
#     user_id = 'leess'
#   and
#     order_date = '2024-04-23 11:20:09';
    (prod_no, user_id, order_date) = (300, 'leess', '2024-04-23 11:20:09');

-- 복합기본키 대안
create table tbl_order_composite_pk2 (
    id int auto_increment primary key, -- 식별번호
    prod_no int, -- 상품번호
    user_id varchar(50), -- 회원아이디
    count int default 1,
    order_date datetime default current_timestamp,
    unique(prod_no, user_id, order_date)
);

insert into
    tbl_order_composite_pk2(prod_no, user_id)
values (
    300, 'leess'
);

select * from tbl_order_composite_pk2 where id = 1;

insert into
    tbl_order_composite_pk2(prod_no, user_id, order_date)
values (
           300, 'leess', '2024-04-23 11:28:12'
       );-- unique 처리했기 때문에 같은 하나라도 중복되는 값은 들어가지 않음. [23000][1062] Duplicate entry '300-leess-2024-04-23 11:28:12' for key 'tbl_order_composite_pk2.prod_no'

select * from tbl_order_composite_pk2;

-- --------------------------------
-- FOREIGN KEY
-- --------------------------------
-- 외래키. 참조 무결성 지원하기 위한 제약조건
-- 참조테이블에서 제공하는 값만 사용할 수 있도록 하는 것.
-- 외래키를 통해서 테이블과 테이블간의 관계가 만들어진다. (Relational DBMS)
-- 참조테이블의 참조컬럼은 PK, UQ제약조건이 걸려있어야 한다.
-- 제공되는 값외엔 NULL을 허용한다.

create table user_grade(
    grade_code int primary key,
    grade_name varchar(100) not null
);

insert into
    user_grade
values
    (10, '일반회원'),
    (20, '우수회원'),
    (30, 'VIP회원');

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
#         on update set null -- 부모행 참조컬럼이 수정되면, 자식fk컬럼을 null로 변경
#         on delete set null, -- 부모행이 삭제되면, 자식fk컬럼을 null로 변경
        on update cascade -- 부모행 참조컬럼이 수정되면, 자식fk컬럼을 수정
        on delete cascade, -- 부모행이 삭제되면, 자식행도 삭제
    constraint uq_user_foreignkey_user_id unique(user_id),
    constraint uq_user_foreignkey_email unique(email)
);

select
    *
from
    information_schema.TABLE_CONSTRAINTS
where
    CONSTRAINT_SCHEMA = 'menudb'
    and TABLE_NAME = 'user_foreignkey';

show create table user_foreignkey;

insert into
    user_foreignkey
values
    (1, 'honggd', '1234', '홍길동', 10, '남', '01012341234', 'honggd@naver.com'),
    (2, 'sinsa', '1234', '신사임당', 20, '여', '01056785678', 'sinsa@naver.com');

insert into
    user_foreignkey
values
    (3, 'leess', '1234', '이순신', 50, '남', '01012341234', 'leess@naver.com');
-- [23000][1452] Cannot add or update a child row: a foreign key constraint fails (`menudb`.`user_foreignkey`, CONSTRAINT `fk_user_foreignkey_grade_code` FOREIGN KEY (`grade_code`) REFERENCES `user_grade` (`grade_code`))

update
    user_foreignkey
set
    grade_code = 50
where
    user_no = 1;
-- [23000][1452] Cannot add or update a child row: a foreign key constraint fails (`menudb`.`user_foreignkey`, CONSTRAINT `fk_user_foreignkey_grade_code` FOREIGN KEY (`grade_code`) REFERENCES `user_grade` (`grade_code`))

select * from user_grade;
select * from user_foreignkey;

# 참조하는 자식행이 있는 경우 부모컬럼은 삭제/변경할 수 없다.
-- 1. 참조하는 자식행을 먼저 수정/삭제해야 한다.
-- 2. FK제약조건에 on update set null, on delete set null 옵션을 줄 수 있다.
delete from
    user_grade
where
    grade_code = 10;
-- [23000][1451] Cannot delete or update a parent row: a foreign key constraint fails (`menudb`.`user_foreignkey`, CONSTRAINT `fk_user_foreignkey_grade_code` FOREIGN KEY (`grade_code`) REFERENCES `user_grade` (`grade_code`))

-- tbl_menu -> tbl_category
show create table tbl_menu;
-- 자식fk컬럼 CONSTRAINT `fk_category_code` FOREIGN KEY (`category_code`) REFERENCES `tbl_category` (`category_code`)
show create table tbl_category;
-- 부모pk컬럼 PRIMARY KEY (`category_code`)
-- 자기 참조 (같은 테이블 다른 컬럼을 참조, 상위 카테고리의 category_code를 하위카테고리 ref_category_code로 참조)
-- CONSTRAINT `fk_ref_category_code` FOREIGN KEY (`ref_category_code`) REFERENCES `tbl_category` (`category_code`)

-- employee -> department
show create table empdb.employee;
-- 자식fk컬럼 CONSTRAINT `FK_EMPLOYEE_DEPARTMENT` FOREIGN KEY (`DEPT_CODE`) REFERENCES `department` (`DEPT_ID`),
-- CONSTRAINT `FK_EMPLOYEE_JOB` FOREIGN KEY (`JOB_CODE`) REFERENCES `job` (`JOB_CODE`),
show create table empdb.department;
-- 부모pk컬럼 PRIMARY KEY (`DEPT_ID`),
show create table empdb.job;
-- PRIMARY KEY (`JOB_CODE`),

-- --------------------------------------
-- CHECK
-- --------------------------------------
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
    constraint ck_user_check_gender check(binary gender in ('M', 'F')), -- 대소문자 구분이 필요한 경우 binary키워드 사용
    constraint ck_user_check_age check(age > 0),
    constraint uq_user_check_user_id unique(user_id),
    constraint uq_user_check_email unique(email)
);

select
    *
from
    information_schema.TABLE_CONSTRAINTS
where
    CONSTRAINT_SCHEMA = 'menudb'
    and TABLE_NAME = 'user_check';

insert into
    user_check
values
    (1, 'honggd', '1234', '홍길동', 'M', 20, '01012341234', 'honggd@naver.com'),
    (2, 'sinsa', '1234', '신사임당', 'F', 40, '01056785678', 'sinsa@naver.com');

insert into
    user_check
values
#     (3, 'leess', '1234', '이순신', '남', 20, '01012341234', 'leess@naver.com'); -- [HY000][3819] Check constraint 'ck_user_check_gender' is violated.
    (3, 'leess', '1234', '이순신', 'm', 20, '01012341234', 'leess@naver.com'); -- 소문자 m 허용
    -- binary를 사용해서 구분이 됐다면 다음과 같은 에러 출력
    -- [23000][1062] Duplicate entry '3' for key 'user_check.PRIMARY'

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

select * from user_check;