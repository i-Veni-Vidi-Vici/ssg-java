-- =======================
-- DML
-- =======================
-- Data Manipulation Language  데이터 조작어
-- 테이블 행(레코드)을 대상으로 CRUD 명령어 제공
-- Create, Read, Update, Delete 작업에 해당하는 명령어가 각각 insert, select, update, delete
-- 이 중 select는 DQL문으로 구분함

-- -----------------------
-- INSERT
-- -----------------------
-- 새로운 행 추가 -> 결과적으로 테이블 행 수 늘어남
-- insert 요청시 처리된 행의 수 반환됨 (intellij에서는 Service뷰 - Output탭에서 확인 가능)

# 문법
-- 1. 기본문법 : 테이블에 선언된 컬럼순서, 개수대로 입력
-- insert into 테이블 values(컬럼값1, 컬럼값2, ..)
-- 2. 컬럼작성 문법 : 값을 입력할 컬럼을 명시한 후 값 제공
-- insert into 테이블(컬럼명1, 컬럼명2, ..) values(컬럼값1, 컬럼값2, ..)
-- 3. bulk insert문법 : 대량의 데이터를 한번에 입력
-- insert into 테이블 values(컬럼값1, 컬럼값2, ..), (컬럼값1, 컬럼값2, ..), (컬럼값1, 컬럼값2, ..), ..

-- 테이블 구조
show create table tbl_menu; -- create table문 열람
desc tbl_menu;
-- auto_increment 자동증가 컬럼(PK 고유식별컬럼)은 별도의 값을 작성하지 않아도 자동으로 고유한 숫자값 발급

-- 기본문법
insert into
    tbl_menu
values(
       null, '바나나해장국', 8500, 4, 'Y'
      );

select *
from tbl_menu;

-- 컬럼명 제공 문법
-- 기본값(default)이 명시되지 않은 not null컬럼은 생략할 수 없음
insert into
    tbl_menu(menu_name, menu_price, category_code, orderable_status)
values (
        '파인애플탕', 5500, 4, 'Y'
       );

insert into
    tbl_menu(orderable_status, menu_price, menu_name)
values (
        'Y',
        7500,
        '소고기라떼'
       );

# insert into tbl_menu(menu_name)
# values ('육회쥬스'); -- [HY000][1364] Field 'menu_price' doesn't have a default value

-- bulk insert 문법
insert into tbl_menu
values
    (null, '참치맛 아이스크림', 1700, 12, 'Y'),
    (null, '멸치맛 아이스크림', 1500, 11, 'Y'),
    (null, '소시지맛 카페오레', 3500, 8, 'Y');

use empdb;
-- 다음 데이터를 추가하세요.
show create table employee;
desc employee;

insert into employee
values
    ('301', '함지민', '781020-2123453', 'hamham@ohgiraffers.com', '01012343334', 'D1', 'J4', 'S3', 4300000, 0.2, '200', now(), null, default),
    ('302', '장채현', '901123-1080503', 'jang_ch@ohgiraffers.com', '01033334444', 'D2', 'J7', 'S3', 3500000, null, '200', now(), null, default);

select *
from employee;

-- 쿠폰테이블
create table tbl_coupon(
    id int auto_increment primary key, -- 쿠폰식별번호 (중복되지 않는 식별번호 자동 발급)
    coupon_name varchar(1000) not null, -- 쿠폰명
    discount_price int, -- 금액할인인 경우의 할인금액
    discount_rate double, -- 비율할인인 경우의 할인비율
    issued_at datetime not null default now(), -- 발급일
    expires_at date not null -- 만료일
);

desc tbl_coupon;
-- insert 시에 생략 가능한 컬럼 : id, discount_price, discount_rate, issued_at(not null이지만, default값 지정)

-- 데이터 초기화 (모든 행 삭제)
# truncate table tbl_coupon;

-- 데이터 추가
-- id : auto-increment 사용
-- issued_at : 1,2번 쿠폰은 현재 시각
insert into tbl_coupon
values
    (default, '대한독립기념쿠폰', 5000, null, default, '2024-05-22'),
    (default, '건국기념쿠폰', null, 0.15, default, '2024-05-22'),
    (default, '봄맞이쿠폰', 3000, null, '2024-02-15 00:00:00', '2024-06-01'),
    (default, '여름맞이쿠폰', 3000, null, '2024-05-15 00:00:00', '2024-09-01'),
    (default, '가을맞이쿠폰', 3000, null, '2024-08-15 00:00:00', '2024-12-01'),
    (default, '겨울맞이쿠폰', 3000, null, '2024-11-15 00:00:00', '2025-03-01');

select *
from tbl_coupon;

-- -----------------------
-- UPDATE
-- -----------------------
-- 테이블 레코드 단위로 컬럼값을 수정하는 명령
-- 전체 행 수는 변하지 않음
-- WHERE절을 통해 특정 레코드를 한정한 후 수정함 (WHERE절 생략하면 모든 행의 데이터 수정)

select *
from tbl_menu;

-- 파인애플탕 메뉴의 카테고리코드를 퓨전(7)으로 변경
update tbl_menu
set category_code = 7
where
#    menu_name = '파인애플탕탕탕' -- where절을 통해 대상 행을 찾지 못한 경우, 오류는 발생하지 않음 (0행 수정)
#    menu_name = '파인애플탕'
    menu_code = 24; -- 중복값이 없는 식별컬럼(PK)을 통해 행을 찾는 것이 좋음

-- 서브쿼리를 통한 update
-- 우럭스무디와 같은 카테고리코드로 파인애플탕의 카테고리코드 수정
-- 수정하고자 하는 테이블을 서브쿼리에서 접근 불가 ([HY000][1093] You can't specify target table 'tbl_menu' for update in FROM clause)
update tbl_menu
set
# category_code = (select category_code from tbl_menu where menu_name = '우럭스무디')
    category_code = (select category_code from (select category_code from tbl_menu where menu_name = '우럭스무디') t)
where menu_code = 24;

-- 한식 메뉴의 가격을 1000원씩 인상하는 update문 작성
-- DML은 트랜잭션 모드를 수동(Manual)로 지정해서 쿼리실행, db반영을 구분할 수 있음
-- 트랜잭션 수동모드에서는 쿼리 실행 후, 별도의 commit 명령을 통해 결과 반영 (rollback 명령으로 변경사항 취소 가능)

update tbl_menu
set menu_price = menu_price + 1000
where category_code = (select category_code from tbl_category where category_name = '한식');

select *
from tbl_menu;

-- 변경사항 취소 (마지막 commit 상태로 돌아감)
rollback;

-- 변경사항 적용 (취소불가)
commit;

-- 사원테이블에서 방명수 사원의 급여와 보너스를 유재식 사원과 동일하게 변경
update employee
set
    SALARY = (select SALARY from (select SALARY from employee where EMP_NAME = '유재식') t),
    BONUS = (select BONUS from (select BONUS from employee where EMP_NAME = '유재식') t)
where EMP_NAME = '방명수';

select *
from employee;

-- 임시환 사원의 직급을 과장, 부서를 해외영업3부로 변경
update employee
set
    JOB_CODE = (select JOB_CODE from job where JOB_name = '과장'),
    DEPT_CODE = (select DEPT_id from department where DEPT_TITLE = '해외영업3부')
where emp_name = '임시환';

-- -----------------
-- DELETE
-- -----------------
-- 테이블의 행 삭제
-- 실행결과 행 수 줄어듦
-- WHERE로 특정 행을 한정해서 사용해야 함 (WHERE절 생략하면 모든 행 삭제)
select *
from tbl_menu order by menu_price;

-- delete 등 삭제 관련문은 주석처리 해놓기
# delete from tbl_menu
# where menu_code = 28;

-- limit절을 이용한 삭제
-- 가격이 제일 싼 2개 삭제
delete
from tbl_menu
order by menu_price
limit 2; -- offset 지정 안됨

-- -----------------
-- REPLACE
-- -----------------
-- upsert. (update + insert)
-- pk컬럼 기준으로 데이터가 존재하면 update처리, 존재하지 않으면 insert처리
select *
from tbl_menu;

replace into tbl_menu
values (
        17, '참기름소주', 5000, 10, 'Y'
       );

replace tbl_menu
values (
        100, '고구마소주', 15000, 10, 'Y'
       );

-- -----------------
-- MERGE
-- -----------------
-- 병합 기능 지원
-- merge명령은 mysql에서 지원X -> insert 사용
-- 서브쿼리를 이용한 대량의 데이터를 insert할 수 있음

-- 테이블의 구조만 복사 (1 = 2 조건때문에 데이터는 복사되지 않음)
-- 서브쿼리로 테이블을 생성하면, 테이블 not null 제약조건 외에는 복사되지 않음(제약조건, default값 등은 제외)

create table tbl_menu2
as select * from tbl_menu where 1 = 2;

select *
from tbl_menu2;

desc tbl_menu2;

-- menu_code PK 추가
alter table tbl_menu2
add constraint primary key(menu_code);

-- 서브쿼리를 이용한 데이터 병합 (values 대신 select문)
insert into
    tbl_menu2(menu_code, menu_name, menu_price, category_code, orderable_status)
select *
from tbl_menu;