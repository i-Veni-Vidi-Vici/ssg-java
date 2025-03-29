-- =============================
-- DML
-- =============================
-- Data Manipulation Language 데이터 조작어
-- 테이블 행(레코드)을 대상으로 CRUD 명령어를 조작

-- -----------------------------
-- INSERT
-- -----------------------------
-- 새로운 행을 추가, 결과적으로 테이블 행 수가 늘어난다.
-- insert 요청시 처리된 행의 수가 반환된다. (Intellij에서 Service뷰-Output탭에서 확인이 가능 // 1 row affected in 13 ms

# 문법
-- 1. 기본문법: 테이블에 선언된 컬럼 순서, 개수 대로 값을 입력 // 그렇지 않으면 오류
-- insert into 테이블 values(컬럼 값1, 컬럼 값2 ...)
-- 2. 컬럼 작성 문법: 값을 입력할 컬럼을 명시한 후 값을 입력
-- insert into 테이블(컬럼 명1, 컬럼 명2 ...) values(컬럼 값1, 컬럼 값2 ...)
-- 3. bulk insert 문법: 대량의 데이터를 한번에 입력 가능
-- insert into 테이블 values (컬럼 값1, 컬럼 값2 ...), (컬럼 값1, 컬럼 값2 ...), (컬럼 값1, 컬럼 값2 ...), ...

-- 테이블의 구조 보기
-- 방법1.
show create table tbl_menu; -- create table문을 볼 수 있다.
/*
 CREATE TABLE `tbl_menu` (
  `menu_code` int NOT NULL AUTO_INCREMENT COMMENT '메뉴코드',
  `menu_name` varchar(30) NOT NULL COMMENT '메뉴명',
  `menu_price` int NOT NULL COMMENT '메뉴가격',
  `category_code` int DEFAULT NULL COMMENT '카테고리코드',
  `orderable_status` char(1) NOT NULL COMMENT '주문가능상태',
  PRIMARY KEY (`menu_code`),
  KEY `fk_category_code` (`category_code`),
  CONSTRAINT `fk_category_code` FOREIGN KEY (`category_code`) REFERENCES `tbl_category` (`category_code`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='메뉴'
 */

-- 방법2.

desc tbl_menu;

-- auto_increment
-- 자동증가 컬럼은 별도의 값을 작성하지 않아도, 자동으로 고유한 숫자 값이 입력된다.
-- PK 고유식별컬럼에서만 사용 가능하다.

-- 기본문법
insert into
    tbl_menu
values (
        null,
        '바나나해장국',
        8500,
        4,
        'Y'
       );
-- 정상적으로 잘 입력되었는지 확인
-- 방법1. output 탭 // 1 row affected in 13 ms
-- 방법2. select로 조회
select
    *
from
    tbl_menu;

-- 컬럼명 제공 문법
-- 기본값(default)이 명시되지 않은 not null 컬럼은 생략할 수 없다.

insert into
    tbl_menu (menu_name, menu_price, category_code, orderable_status)
values(
       '파인애플탕',
       5500,
       4,
       'Y'
      );

insert into
    tbl_menu (orderable_status, menu_price, menu_name)
values(
       'Y',
       7500,
       '소고기라떼'
      );

select *
from tbl_menu;

insert into
    tbl_menu
values (

       );

-- bulk insert문법
insert into
    tbl_menu
values
    (null, '참치맛 아이스크림', 1700, 12, 'Y'),
    (null, '멸치맛 아이스크림', 1500, 11, 'Y'),
    (null, '소시지맛 카페오레', 6500, 8, 'Y');


/*
사번: 301
이름: 함지민
주민번호: 781020-2123453
이메일: hamham@kh.or.kr
전화번호: 01012343334
부서코드: D1
직급코드: J4
급여등급: S3
급여: 4300000
보너스: 0.2
관리자: 200


사번: 302
이름: 장채현
주민번호: 901123-1080503
이메일: jang_ch@kh.or.kr
전화번호: 01033334444
부서코드: D2
직급코드: J7
급여등급: S3
급여: 3500000
보너스: 없음
관리자: 20
 */

use empdb;

show tables;

desc employee;

show create table employee;

select *
from employee;

insert into employee
    (EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SAL_LEVEL, SALARY, BONUS, MANAGER_ID)
values
('301', '함지민', '781020-2123453', 'hamham@kh.or.kr', '01012343334', 'D1', 'J4', 'S3', 4300000, 0.2, '200'),
('302', '장채현', '901123-1080503', 'jang_ch@kh.or.kr', '01033334444', 'D2', 'J7', 'S3', 3500000, null, '20');

insert into employee
values
    ('301', '함지민', '781020-2123453', 'hamham@kh.or.kr', '01012343334', 'D1', 'J4', 'S3', 4300000, 0.2, '200'),
    ('302', '장채현', '901123-1080503', 'jang_ch@kh.or.kr', '01033334444', 'D2', 'J7', 'S3', 3500000, null, '20');

-- insert into시 컬럼명 지정하지 않고 데이터를 컬럼 수보다 적게 입력하는 경우, 기본 값이 들어간다. // 기본 값이 없으면 null 값이 들어간다.
-- ㄴ 위에 꺼 수업영상 다시 보고 정리 필요 // 오류 발생

delete from
    employee
where EMP_ID = '302';

insert into employee
values
    ('301', '함지민', '781020-2123453', 'hamham@kh.or.kr', '01012343334', 'D1', 'J4', 'S3', 4300000, 0.2, '200', now(), null, default),
    ('302', '장채현', '901123-1080503', 'jang_ch@kh.or.kr', '01033334444', 'D2', 'J7', 'S3', 3500000, null, '20', now(), null, default);

select * from employee;

-- 쿠폰 테이블
create table tbl_coupon (
    id int auto_increment primary key , -- 쿠폰 식별번호 (중복되지 않는 식별번호 자동발급)
    coupon_name varchar(1000) not null, -- 쿠폰명
    coupon_price int, -- 금액할인인 경우 할인금액
    discount_rate double, -- 비율할인인 경우 할인비율 (0.5 -> 50%)
    issued_at datetime not null default now(), -- 발급일
    expires_at date not null -- 만료일
);

desc tbl_coupon;

show tables;

-- drop table tbl_coupon;

-- insert시에 생략 가능한 컬럼은?
-- id, discount_price, discount_rate, issued_at(not null이지만, default 값 지정되어 있으므로)

-- 추가할 데이터
-- id	coupon_name	discount_price	discount_rate	issued_at	expires_at
-- 1	대한독립기념쿠폰	5000		                2024-04-22 11:18:46	2024-05-22
-- 2	건국기념쿠폰		            0.15	        2024-04-22 11:18:47	2024-05-22
-- 3	봄맞이쿠폰	3000		                    2024-02-15 00:00:00	2024-06-01
-- 4	여름맞이쿠폰	3000		                    2024-05-15 00:00:00	2024-09-01
-- 5	가을맞이쿠폰	3000		                    2024-08-15 00:00:00	2024-12-01
-- 6	겨울맞이쿠폰	3000		                    2024-11-15 00:00:00	2025-03-01

insert into tbl_coupon
(coupon_name, coupon_price, expires_at)
values
    ('대한독립기념쿠폰', 5000, '2024-05-22');


insert into tbl_coupon
    (coupon_name, discount_rate, expires_at)
values
    ('건국기념쿠폰', 0.15, '2024-05-22');

insert into tbl_coupon
    (coupon_name, coupon_price, issued_at, expires_at)
values
    ('봄맞이쿠폰', 3000, '2024-02-15', '2024-06-01'),
    ('여름맞이쿠폰', 3000, '2024-05-15', '2024-09-01'),
    ('가을맞이쿠폰', 3000, '2024-08-15', '2024-12-01'),
    ('겨울맞이쿠폰', 3000, '2024-11-15', '2025-03-01');

select *
from tbl_coupon;

drop table tbl_coupon;

-- bulk insert 문법
insert into tbl_coupon
    (coupon_name, coupon_price, discount_rate, issued_at, expires_at)
values
    ('대한독립기념쿠폰', 5000, null, default, '2024-05-22'),
    ('건국기념쿠폰', null, 0.15, default, '2024-05-22'),
    ('봄맞이쿠폰', 3000, null, '2024-02-15', '2024-06-01'),
    ('여름맞이쿠폰', 3000, null, '2024-05-15', '2024-09-01'),
    ('가을맞이쿠폰', 3000, null, '2024-08-15', '2024-12-01'),
    ('겨울맞이쿠폰', 3000, null, '2024-11-15', '2025-03-01');

-- -------------------------------------
-- UPDATE
-- -------------------------------------
-- 테이블 레코드 단위로 컬럼값을 수정하는 명령이다.
-- 전체 행수는 변하지 않는다.
-- WHERE절을 통해 특정 레코드를 한정한 후 수정한다. // WHERE절을 생략하면 모든 행의 데이터를 수정한다.
-- set 변경할 컬럼명 = 변경할 컬럼 값 // 콤마로 구분하여 여러개 나열 가능하다.

-- 파인애플탕 메뉴의 카테고리를 퓨전(7)로 변경
-- whrer절을 통해 대상행을 찾지 못한 경우, 오류는 발생하지 않는다.

select *
from tbl_menu
where menu_name = '파인애플탕';

desc tbl_menu;

# update category_code = '7'
# from tbl_menu
# where
#     menu_name = '파인애플탕';
#     menu_code = 24; -- 중복값이 없는

-- 서브쿼리를 통한 update
-- 우럭스무디의 같은 카테고리로 파인애플탕의 카테고리를 수정하세요.
-- 수정하고자 하는 테이블을 서브쿼리에서 접근할 수 없다. // mysql에서만
-- 서브쿼리를 인라인뷰로 감싸서 사용하면 가능하다.

update
    tbl_menu
set
    category_code = (select category_code from tbl_menu where menu_name = '우럭스무디')
where
    menu_code = 24; -- [HY000][1093] You can't specify target table 'tbl_menu' for update in FROM clause

update
    tbl_menu
set
    category_code = (
        select
            category_code
        from (select category_code from tbl_menu where menu_name = '우럭스무디') t
    )
where
    menu_code = 24;


-- 한식메뉴의 가격을 1000원씩 인상하는 update문을 작성
-- DML은 트랜잭션 모드를 수동(Manual)로 지정해서 쿼리샐행과 DB 반영을 구분할 수 있다.
-- 트랜잭션 수동모드에서는 쿼리 실행 후, 별도의 commit 명령을 통해 결과를 반영할 수 있다.
-- (rollback 명령을 하면 변경사항을 취소할 수 있다.)
-- 인텔리제이 Tx를 auto에서 Manual로 변경하였다.
-- auto는 쿼리 실행되는 즉시 commit이 반영되었다.

select *
from tbl_menu;

select *
from tbl_category;

update
    tbl_menu
set
    menu_price = menu_price + 1000
where
    category_code = (
        select
            category_code
        from
            tbl_category
        where
            category_name = '한식'
);

select
    category_code
from
    tbl_category
where
    category_name = '한식';

select *
from tbl_menu
where category_code = 4;

-- rollback 변경사항을 취소하기
rollback;

-- commit 변경사항을 적용하기 // 취소불가
commit;

-- commit을 하기 전에는 db 서버 메모리 상에서만 적용된 것이다. // 다른 클라이언트로 서버에 접속하면 가장 최근 커밋에 적용된 내용만 보인다.
-- rollback은 가장 최근 commit으로만 돌아갈 수 있다. // 그 이전 커밋으로는 돌아갈 수 없다.

-- 사원테이블에서 방명수 사원의 급여와 보너스를 유재식 사원과 동일하게 변경하세요.

use empdb;

select
    *
from
    employee
where
    EMP_NAME = '유재식';

select
    *
from
    employee
where
    EMP_NAME = '방명수';

update
    employee
set
    SALARY = (
        select
            SALARY
        from
            (select SALARY from employee where EMP_NAME = '유재식') t
    ),
     BONUS = (
        select
            BONUS
        from
            (select BONUS from employee where EMP_NAME = '유재식') t
    )
where
    EMP_NAME = '방명수';

-- 임시환 사원의 직급을 과장, 부서를 해외영업3부로 변경하세요.

select *
from job
where JOB_NAME = '과장';

select *
from department
where DEPT_TITLE = '해외영업3부';

update
    employee
set
    JOB_CODE = (
        select
            JOB_CODE
                from (select JOB_CODE from job where JOB_NAME = '과장') j
                ),
    DEPT_CODE = (
        select
            DEPT_ID
                from (select DEPT_ID from department where DEPT_TITLE = '해외영업3부') d
                -- 변경하고자 하는 테이블과 서브 쿼리에서 참조하고 있는 테이블 명이 다른 경우, 별칭 사용하지 않아도 된다.
                )
where
    emp_name = '임시환';

select *
from employee
where EMP_NAME = '임시환';

-- 동명이인이 있을 수 있으므로, 프라이머리 키 값으로 where절에 작성하는 것이 좋다.

-- -----------------------------
-- DELETE
-- -----------------------------
-- 테이블의 행을 삭제하는 명령
-- 실행결과 행 수가 줄어든다.
-- WHERE절로 특정 행을 한정해서 사용해야 한다. // where절을 생략하면 모든 행이 삭제된다. where절은 문법적으로 늘 생략가능하다.
-- 삭제된 행 수를 반환한다.

show tables;

select *
from tbl_menu;

# delete from
#            tbl_menu
# where
#     menu_code = 28;

-- where절을 작성하지 않으면, 모든 행을 삭제한다.
-- delete문은 혹시라더 삭제하지 않도록 주석처리하고, 블럭을 잡아 실행한다.
# delete from
#            tbl_menu;

-- limit절을 이용한 삭제
-- 가격이 제일 싼 2개 삭제
select * from tbl_menu order by menu_price;

delete from
    tbl_menu
order by
    menu_price
limit
    2; -- offset지정 안됨.

-- -----------------------------
-- REPLACE
-- -----------------------------
-- upsert(update + insert)
-- pk컬럼(menu_code) 기준으로 데이터가 존재하면 update처리, 존재하지 않으면 insert처리.
select * from tbl_menu where menu_code = 100;

replace into
    tbl_menu
values (
           17, '참기름소주', 5000, 10, 'Y'
       );
replace into
    tbl_menu
values (
           100, '고구마소주', 15000, 10, 'Y'
       );

-- -----------------------------
-- MERGE
-- -----------------------------
-- 병합 기능을 지원한다.
-- merge명령은 mysql에서 지원하지 않는다. insert 사용
-- 서브쿼리를 이용한 대량의 데이터를 insert할 수 있다.

-- 테이블의 구조만 복사 (1=2 조건때문에 데이터는 복사되지 않는다.)
-- 서브쿼리로 테이블을 생성하면, 테이블 NOT NULL제약조건외에는 복사되지 않는다. (제약조건, default값등은 제외)
create table tbl_menu2
as
select * from tbl_menu where 1 = 2;


select *
from tbl_menu2;

desc tbl_menu2;
desc tbl_menu;

-- menu_code PK 추가
alter table tbl_menu2
add constraint primary key (menu_code);

drop table
    tbl_menu2;
-- 서브쿼리를 이용한 데이터 병합
insert into
    tbl_menu2 (menu_code, menu_name, menu_price, category_code, orderable_status)
select
    *
from
    tbl_menu;

select *
from tbl_menu2;