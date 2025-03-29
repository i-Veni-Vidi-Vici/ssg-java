-- =========
-- 제약조건
-- =========
-- 제약조건. 테이블 작성시 각 컬럼에 대해서 값에 대한 제약을 작성 할 수 있다.
-- 데이터무결성 보장을 목적으로 한다.
-- 데이터를 입력 / 수정시에 자동으로 제약조건에 부합하는지를 검사한다.

# 구분
-- 1. NOT NULL : null을 허용하지 않는다.
-- 2. UNIQUE : 중복된 값을 허용하지 않는다.
-- 3. PRIMARY KEY : 기본키 -> 고유식별컬럼 (NOT NULL, UNIQUE 기능 포함)
-- 4. FOREIGN KEY : 외래키 -> 참조 테이블의 참조컬럼값만 작성 가능
-- 5. CHECK : 지정한 도메인에서만 값 사용 가능

# 제약조건 조회
select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA = 'menudb' and table_name  = 'employee'
-- ddl을 통해서 확인
show create table empdb.EMPLOYEE;
/*
 CREATE TABLE `EMPLOYEE` (
  `EMP_ID` varchar(3) NOT NULL, -- 컬럼레벨 작성
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
 -- 테이블 레벨 작성 --
  PRIMARY KEY (`EMP_ID`), --
  UNIQUE KEY `IDX_EMPLOYEE_EMP_ID_PK` (`EMP_ID`),
  UNIQUE KEY `UQ_EMPLOYEE_EMP_NO` (`EMP_NO`),
  KEY `FK_EMPLOYEE_JOB` (`JOB_CODE`),
  KEY `FK_EMPLOYEE_DEPARTMENT` (`DEPT_CODE`),
  CONSTRAINT `FK_EMPLOYEE_DEPARTMENT` FOREIGN KEY (`DEPT_CODE`) REFERENCES `DEPARTMENT` (`DEPT_ID`),
  CONSTRAINT `FK_EMPLOYEE_JOB` FOREIGN KEY (`JOB_CODE`) REFERENCES `JOB` (`JOB_CODE`),
  CONSTRAINT `CK_EMPLOYEE_QUIT_YN` CHECK ((`QUIT_YN` in (_utf8mb4'Y',_utf8mb4'N')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='사원'
 */

-- -----
-- NOT NULL
-- --------
-- NUll값을 허용하지 않는 제약 조건
-- 컬럼레벨에만 작성된다.

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

insert into
    user_notnull
values
    (1, 'honggd','1234','홍길동','남','01012341234','honggid@naver.com'),
    (2, 'sinsal','1234','신사임당','여','01056785678','sinsa@naver.com');

select * from user_notnull;

insert into
    user_notnull
values
    (3, 'lee',null,'이순신','남','01012341234',null); -- [23000][1048] Column 'user_pwd' cannot be null
 insert into
    user_notnull(user_no, user_id, user_name, gender, phone, email)
 values
     (3, 'lee','이순신','남','01012341234'); -- [21S01][1136] Column count doesn't match value count at row 1


 -- ----------
 -- UNIQUE
 -- ----------
 -- 중복값을 허용하지 않는 제약조건
                                         -- n개의 컬럼을 묶어서 복합 unqiue 제약조건도 가능하다.

create table if not exists user_unique(
        user_no int not null unique,
        user_id varchar(50) not null unique,
        user_pwd varchar(50) not null,
        user_name varchar(50) not null,
        gender char(1),
        phone char(11) not null,
        email varchar(100),
        constraint uq_user_unique_user_id unique(user_id) ,-- (테이블 레벨) 제약조건 이름 constraint uq_테이블명_unique_컬럼명
        constraint uq_user_unique_email unique(email)
);

-- 제약조건
select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA = 'menudb'
  and table_name = 'user_unique';

insert into
    user_unique
values
    (1, 'honggd','1234','홍길동','남','01012341234','honggid@naver.com'),
    (2, 'sinsal','1234','신사임당','여','01056785678','sinsa@naver.com');

select * from user_unique;

-- unique 제약조건이 컬럼은 null값을 허용한다.
-- unique 제약조건 컬럼은 null값을 여러러개 허용한다.

insert into
    user_unique
values
    (4, 'less','1234','이순신','남','01012341234',null);
insert into
    user_unique
values
    (5, 'nondog','1234','s논개','남','01012341234',null);


-- -------------------
-- PRIMARY
-- -------------------
-- 고유식별컬럼을 지정하는 제약조건.(기본키, 주키)
-- 테이블에서 딱 한행을 구분해내기 위한 값을 의미
-- 중복을 허용하지 않고, null을 허용하지 않는다.
-- 테이블당 1개의 PK를 허용한다. 2개 이상은 허용하지 않음
-- n개의 컬럼을 묶어서 복합 PK로 지정이 가능하다.

create table if not exists user_primarykey(
    user_no int ,
    user_id varchar(50) not null,
    user_pwd varchar(50) not null,
    user_name varchar(50) not null,
    gender char(1),
    phone char(11) not null,
    email varchar(100),
primary key (user_no),
    constraint  uq_user_primarykey_user_id unique(user_id),
    constraint  up_user_primarykey_email unique(email)
);
insert into
    user_unique
values
    (1, 'honggd','1234','홍길동','남','01012341234','honggid@naver.com'),
    (2, 'sinsal','1234','신사임당','여','01056785678','sinsa@naver.com');

# 복합 기본키
-- n개의 컬럼을 묶어서 고유하게 관리
create table tbl_order_composite_pk(
    prod_no int,
    user_id varchar(50),
    count int default 1,
    order_date datetime default current_timestamp,
    primary key (prod_no, user_id, order_date)
);

select * from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA = 'menudb' and TABLE_NAME = 'tbl_order_composite_pk';

show create table tbl_order_composite_pk;

insert into tbl_order_composite_pk
values (
        100, 'honggd', 5, now()
       );
insert into tbl_order_composite_pk
values (
           200, 'sinsa', 1, now()
       );
select * from tbl_order_composite_pk;

insert into tbl_order_composite_pk(prod_no, user_id)
values (300, 'leess');

-- 복합 pk컬럼중 하나라도 null일 수 없다.
insert into tbl_order_composite_pk(prod_no, user_id)
values (null, 'leess'); -- [23000][1048] Column 'prod_no' cannot be null

-- 조회
select *
from tbl_order_composite_pk
where
#   prod_no = 300
#   and user_id = 'leess'
#   and order_date = '2024-04-23 11:21:23';
    (prod_no,user_id,order_date) = (300,'leess','2024-04-23 11:21:23')

-- 복합기본키 대안
create table tbl_order_composite_pk2(
    id int auto_increment primary key, -- 식별번호
    prod_no int, -- 상품번호
    user_id varchar(50), -- 회원아이디
    count int default 1,
    order_date datetime default current_timestamp,
    unique (prod_no, user_id, order_date) -- unique로 설정하는거 중복으로 주문이 들어가는 경우를 방지하기 위해서 사용.
);

insert into tbl_order_composite_pk2(prod_no, user_id)
values (300, 'leess');

select * from tbl_order_composite_pk2 where id = 1;

-- -----------------
-- FOREIGN KEY
-- -----------------
-- 외래키 -> 참조 무결성 지원하기 위한 제약 조건
-- 참조테이블에서 제공하는 값만 사용 할 수 있도록 하는 것.
-- 외래키를 통해서 테이블과 테이블간의 관계가 만들어진다.(Relational DBMS)
-- 참조테이블의 참조컬럼은 PK, UQ제약 조건이 걸려있어야 한다.
-- 제공되는 값 외엔 NULL을 허용한다.

create table user_grade(
    grade_code int primary key ,
    grade_name varchar(100) not null
);

insert into user_grade
values (10, '일반회원'),
       (20, '우수회원'),
       (30, 'VIP회원');

-- drop table user_foreignkey
CREATE TABLE IF NOT EXISTS user_foreignkey (
    user_no INT PRIMARY KEY,
    user_id VARCHAR(50) NOT NULL,
    user_pwd VARCHAR(50) NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    grade_code INT,
    gender CHAR(1),
    phone CHAR(11) NOT NULL,
    email VARCHAR(100),
    CONSTRAINT fk_user_foreignkey_grade_code
        FOREIGN KEY (grade_code)
            REFERENCES user_grade(grade_code)
         #   ON UPDATE SET NULL -- 부모행 참조열이 수정될 경우, 자식 FK열을  NULL로 변경
         #   ON DELETE SET NULL, -- 부모행 참조열이 삭제될 경우, 자식 FK열을 NULL로 변경
            on update cascade -- 부모행 참조컬럼이 수정되면, 자식 컬럼 수정
            on delete cascade, -- 부모행 참조컬림이 삭제되면, 자식 컬럼 수정
    CONSTRAINT uq_user_foreignkey_user_id UNIQUE (user_id),
    CONSTRAINT up_user_foreignkey_email UNIQUE (email)
);


select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA = 'menudb'
  and TABLE_NAME = 'user_foreignkey';

show create table user_foreignkey;

insert into
    user_foreignkey
values
    (1, 'honggd','1234','홍길동',10,'남','01012341234','honggid@naver.com'),
    (2, 'sinsal','1234','신사임당',20,'여','01056785678','sinsa@naver.com');

insert into
    user_foreignkey
values
    (3, 'sinsa','1234','이순신',50,'남','01012341234','leess@naver.com');
-- [23000][1452] Cannot add or update a child row: a foreign key constraint fails (`menudb`.`user_foreignkey`, CONSTRAINT `fk_user_foreginkey_grade_code` FOREIGN KEY (`grade_code`)

update user_foreignkey set grade_code = 50  where user_no =1;

# 참조하는 자식행이 있는 경우 부모컬럼은 삭제 / 변경 할 수 없다.
-- 1. 참조하는 자식행을 먼저 수정 / 삭제해야 한다.
-- 2. FK제약조건에 on update set null, on delete set null이라는 옵션을 줄 수 있다.

select grade_code from user_foreignkey;


delete from user_grade where grade_code = 10;
-- [23000][1451] Cannot delete or update a parent row: a foreign key constraint fails (`menudb`.`user_foreignkey`, CONSTRAINT `fk_user_foreginkey_grade_code` FOREIGN KEY (`grade_code`) REFERENCES `user_grade` (`grade_code`))
-- 부모데이터 변경 불가능 x -> 이미 user_foreignkey가 참조하고 있어서

-- tbl_menu -> tbl_category
show create table tbl_menu;
-- 자식 fk컬럼 CONSTRAINT `fk_category_code` FOREIGN KEY (`category_code`) REFERENCES `tbl_category` (`category_code`)
show create table tbl_category;
-- 부모 pk컬럼  PRIMARY KEY (`category_code`)
-- 자기 참조 ( 같은 테이블 다른 컬럼을 참조, 상위 카테고리의 category_code를 하위카테고리 ref_category_code로 참조)
--  CONSTRAINT `fk_ref_category_code` FOREIGN KEY (`ref_category_code`) REFERENCES `tbl_category` (`category_code`)


-- employee -> department
show create table empdb.EMPLOYEE;
/* 자식 컬럼
CONNSTRAINT `FK_EMPLOYEE_DEPARTMENT` FOREIGN KEY (`DEPT_CODE`) REFERENCES `DEPARTMENT` (`DEPT_ID`),
CONSTRAINT `FK_EMPLOYEE_JOB` FOREIGN KEY (`JOB_CODE`) REFERENCES `JOB` (`JOB_CODE`),
 */
show create table empdb.DEPARTMENT;
-- PRIMARY KEY (`DEPT_ID`),


-- ----------
-- CHECK
-- ----------
-- 컬럼 값을 도메인(값 목록 / 범위)으로 제한하는 제약조건

-- drop table user_check
create table if not exists user_check(
    user_no int primary key ,
    user_id varchar(50) not null,
    user_pwd varchar(50) not null,
    user_name varchar(50) not null,
    gender char(1),
    age int,
    phone char(11) not null,
    email varchar(100),

    constraint  ck_user_check_gender check(gender in('M','F')),
    constraint  ck_user_check_age check(age > 0),
    constraint  uq_user_check_user_id unique(user_id),
    constraint  up_user_check_email unique(email)
);
select *
from information_schema.TABLE_CONSTRAINTS
where CONSTRAINT_SCHEMA = 'menudb'
  and TABLE_NAME = 'user_check';

insert into
    user_check
values
    (1, 'honggd','1234','홍길동','M',20,'01012341234','honggid@naver.com'),
    (2, 'sinsal','1234','신사임당','F',40,'01056785678','sinsa@naver.com');

insert into
    user_check
values
    (3, 'less','1234','이순신','남',20,'01012341234','less@naver.com');
-- [HY000][3819] Check constraint 'ck_user_check_gender' is violated.

insert into
    user_check
values
    (4, 'nondog','1234','논개','F',-1,'01012341234','non@naver.com');
-- [HY000][3819] Check constraint 'ck_user_check_age' is violated.

 update user_check set age = age - 20 where user_no = 1; -- [HY000][3819] Check constraint 'ck_user_check_age' is violated.

