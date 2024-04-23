-- ===================================
-- DML
-- ===================================
-- Data Manipulation Language 데이터 조작어
-- 테이블 행(레코드)을 대상으로 CRUD 명령어를 제공
-- Create, Read, Update, Delete 작업에 해당하는 명령어가 각각 insert, select, update, delete이다.
-- 이 중 select는 DQL문으로 구분한다.

-- ----------------------------------
-- INSERT
-- ----------------------------------
-- 새로운 행을 추가. 결과적으로 테이블 행수가 늘어난다.
-- insert 요청 시 처리된 행의 수가 반환된다. (Intellij에서 Service뷰-Output탭에서 확인이 가능)

# 문법
-- 1. 기본문법 : 테이블에 선언된 컬럼순서, 개수대로 입력
--  insert into 테이블 values(컬럼값1, 컬럼값2, ...)
-- 2. 컬럼작성문법 : 값을 입력할 컬럼을 명시한 후 값을 제공
--  insert into 테이블 (컬럼명1, 컬럼명2, ...) values(컬럼값1, 컬럼값2, ...)
-- 3. bulk insert문법 : 대량의 데이터를 한번에 입력 가능
--  insert into 테이블 values (컬럼값1, 컬럼값2, ...), (컬럼값1, 컬러값2, ...), (컬럼값1, 컬러값2, ...), ...

-- 테이블의 구조
show create table tbl_menu; -- create table문을 열람

desc tbl_menu;
-- auto_increment 자동증가 컬럼(PK 고유식별컬럼)은 별도의 값을 작성하지 않아도, 자동으로 고유한 숫자값을 발급.

-- 기본문법
insert into
    tbl_menu
values(
          null,
          '바나나해장국',
          8500,
          4,
          'Y'
      );

insert into
    tbl_menu
values(
          null,
          '바나나해장국',
          8500,
          4
      ); -- [21S01][1136] Column count doesn't match value count at row 1

select * from tbl_menu;

-- 컬럼명 제공 문법
-- 기본값(default)이 명시되지 않은 not null컬럼은 생략할 수 없다.
insert into
    tbl_menu(menu_name, menu_price, category_code, orderable_status)
values(
          '파인애플탕',
          5500,
          4,
          'Y'
      );

insert into
    tbl_menu(orderable_status, menu_price, menu_name)
values (
           'Y',
           7500,
           '소고기라떼'
       );

insert into
    tbl_menu(menu_name)
values (
           '육회쥬스'
       ); -- [HY000][1364] Field 'menu_price' doesn't have a default value

-- bulk insert문법
-- 기본 insert 또는 컬럼지정 문법
insert into
    tbl_menu
values
    (null, '참치맛 아이스크림', 1700, 12, 'Y'),
    (null, '멸치맛 아이스크림', 1500, 11, 'Y'),
    (null, '소시지맛 카페오레', 3500, 8, 'Y');

select * from tbl_menu;

use empdb;
-- 다음 데이터를 추가 하세요.
desc employee;
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

insert into
    employee(emp_id, emp_name, emp_no, email, phone, dept_code, job_code, sal_level, salary, bonus, manager_id)
values
    (301, '함지민', '781020-2123453', 'hamham@kh.or.kr', '01012343334', 'D1', 'J4', 'S3', 4300000, 0.2, 200),
    (302, '장채현', '901123-1080503', 'jang_ch@kh.or.kr', '01033334444', 'D2', 'J7', 'S3', 3500000, null, 200);

select * from employee;

-- 쿠폰테이블
create table tbl_coupon (
    id int auto_increment primary key, -- 쿠폰식별번호 (중복되지 않는 식별번호 자동발급)
    coupon_name varchar(1000) not null, -- 쿠폰명
    discount_price int, -- 금액할인인 경우 할인금액
    discount_rate double, -- 비율할인인 경우 할인비율 (0.5 -> 50%)
    issued_at datetime not null default now(), -- 발급일
    expires_at date not null -- 만료일
);

-- 데이터 초기화
# truncate table tbl_coupon;

desc tbl_coupon;
-- insert시에 생량 가능한 컬럼은? id, discount_price, discount_rate, issued_at(not null이지만, default값 지정)

-- 추가할 데이터
-- id컬럼은 auto_increment이용
-- 1,2번 쿠폰 issued_at 컬럼은 현재시각으로 입력
-- id	coupon_name	discount_price	discount_rate	issued_at	        expires_at
-- 1	대한독립기념쿠폰	5000		                2024-04-22 11:18:46	2024-05-22
-- 2	건국기념쿠폰		                0.15        2024-04-22 11:18:47	2024-05-22
-- 3	봄맞이쿠폰	    3000		                2024-02-15 00:00:00	2024-06-01
-- 4	여름맞이쿠폰	    3000		                2024-05-15 00:00:00	2024-09-01
-- 5	가을맞이쿠폰	    3000		                2024-08-15 00:00:00	2024-12-01
-- 6	겨울맞이쿠폰	    3000		                2024-11-15 00:00:00	2025-03-01

insert into
    tbl_coupon
values
    (null, '대한독립기념쿠폰', 5000, null, default, now() + interval 1 month);

insert into
    tbl_coupon(coupon_name, discount_rate, expires_at)
values
    ('건국기념쿠폰', 0.15, now() + interval 1 month);

insert into
    tbl_coupon(coupon_name, discount_price, issued_at, expires_at)
values
    ('봄맞이쿠폰', 3000, '2024-02-15 00:00:00', '2024-06-01'),
    ('여름맞이쿠폰', 3000, '2024-05-15 00:00:00', '2024-09-01'),
    ('가을맞이쿠폰', 3000, '2024-08-15 00:00:00', '2024-12-01'),
    ('겨울맞이쿠폰', 3000, '2024-11-15 00:00:00', '2025-03-01');

select * from tbl_coupon;

-- ----------------------------------
-- UPDATE
-- ----------------------------------
-- 테이블 레코드 단위로 컬럼값을 수정하는 명령이다.
-- 전체 행수는 변하지 않는다.
-- WHERE절을 통해 특정레코드를 한정한 후 수정한다. (WHERE절을 생략하면 모든 행의 데이터를 수정한다.)

use menudb;
select * from tbl_menu;

-- 행을 delete하면서 다음에 추가하는 행의 PK의 값과 이전 값 사이가 차이날 때,
-- 이전 행 다음 행부터 시작할 수 있도록 설정해주는 코드
# ALTER TABLE tbl_menu AUTO_INCREMENT=29;

-- 파인애플탕 메뉴의 카테고리를 퓨전(7)으로 변경
update
    tbl_menu
set
    category_code = 7
where
    menu_name = '파인애플탕';

-- where절을 통해 대상행을 찾지 못한 경우, 오류는 발생하지 않는다.
update
    tbl_menu
set
    category_code = 7
where
#     menu_name = '파인애플탕탕탕';
    menu_code = 24; -- 중복값이 없는 식별컬럼(PK)을 통해 행을 찾는 것이 좋다.


-- 서브쿼리를 통한 update
-- 우럭스무디와 같은 카테고리로 파인애플탕의 카테고리를 수정하세요.
-- 수정하고자 하는 테이블을 서브쿼리에서 접근할 수 없다. (mysql)
update
    tbl_menu
set
    category_code = (
        select
            category_code
        from
            tbl_menu
        where
            menu_name = '우럭스무디'
        )
where
    menu_code = 24; -- [HY000][1093] You can't specify target table 'tbl_menu' for update in FROM clause

-- 서브쿼리를 인라인뷰로 감싸서 사용하면 가능하다.
update
    tbl_menu
set
    category_code = (
            select
                category_code
            from
                (select category_code from tbl_menu where menu_name = '우럭스무디') t
        )
where
    menu_code = 24;

select * from tbl_menu;

-- 한식메뉴의 가격을 1000원씩 인상하는 update문을 작성
-- DML은 트랜잭션 모드를 수동 (Manual)로 지정해서 쿼리실행, db반영을 구분할 수 있다.
-- 트랜잭션 수동모드에서는 쿼리 실행 후, 별도의 commit 명령을 통해 결과를 반영할 수 있다.
-- (rollback명령하면 변경사항을 취소할 수 있다.)

select * from tbl_menu where category_code = 4;

update
    tbl_menu
set
#     컬럼 = 컬럼값,
#     컬럼 = 컬럼값
menu_price = menu_price + 1000
where
    category_code = 4;

-- rollback 변경사항을 취소하기
rollback;
-- commit 변경사항 적용하기 (취소불가)
commit;

-- 사원테이블에서 방명수 사원의 급여와 보너스를 유재식 사원과 동일하게 변경하세요.
use empdb;
select * from employee where EMP_NAME = '방명수';

update
    employee
set
    SALARY = (select SALARY from (select SALARY from employee where EMP_NAME = '유재식') s),
    BONUS = (select BONUS from (select BONUS from employee where EMP_NAME = '유재식') b)
where
    EMP_NAME = '방명수';

-- 임시환 사원의 직급을 과장, 부서를 해외영업3부로 변경하세요.
select * from employee where EMP_NAME = '임시환'; -- D2, J4 -> D7, J5

update
    employee
set
    JOB_CODE = (select JOB_CODE from job where JOB_NAME = '과장'),
    DEPT_CODE = (select DEPT_ID from department where DEPT_TITLE = '해외영업3부')
where
    EMP_NAME = '임시환';


-- -----------------------------------
-- DELETE
-- -----------------------------------
-- 테이블의 행을 삭제하는 명령
-- 실행결과 행수가 줄어든다.
-- WHERE로 특정행을 한정해서 사용해야 한다. (WHERE절을 생략하면 모든행이 삭제된다.)
select * from tbl_menu;

# delete from
#     tbl_menu
# where
#     menu_code = 28;

-- where절을 작성하지 않으면, 모든 행을 삭제한다.
# delete from
#     tbl_menu;

-- limit절을 이용한 삭제
-- 가격이 제일 싼 2개 삭제
select * from tbl_menu order by menu_price;

delete from
       tbl_menu
order by
    menu_price
limit
    2; -- offset 지정 안됨.

-- ---------------------------------
-- REPLACE
-- ---------------------------------
-- upsert(update + insert)
-- pk컬럼 기준으로 데이터가 존재하면 update처리, 존재하지 않으면 insert처리.
select * from tbl_menu where menu_code = 100;

replace into -- into는 생략 가능
    tbl_menu
values (
        17, '참기름소주', 5000, 10, 'Y'
       );

replace into
    tbl_menu
values (
           100, '고구마소주', 15000, 10, 'Y'
       );

-- -------------------------------------
-- MERGE
-- -------------------------------------
-- 병합 기능을 지원한다.
-- merge명령은 mysql에서 지원하지 않는다. insert 사용.
-- 서브쿼리를 이용한 대량의 데이터를 insert할 수 있다.

-- 테이블의 구조만 복사 (1 = 2 조건때문에 데이터는 복사되지 않는다.)
-- 서브쿼리로 테이블을 생성하면, 테이블 NOT NULL 제약조건 외에는 복사되지 않는다. (제약조건, default값 등은 제외)
create table tbl_menu2
as
select * from tbl_menu where 1 = 2;

select * from tbl_menu2;
desc tbl_menu2;
desc tbl_menu;

-- menu_code PK 추가
alter table tbl_menu2
add constraint primary key(menu_code);

-- 서브쿼리를 이용한 데이터 병합
insert into
    tbl_menu2 (menu_code, menu_name, menu_price, category_code, orderable_status)
select
    *
from
    tbl_menu;

select * from tbl_menu2;

commit;