-- =====================
-- DML
-- =====================
-- Data Manipulation Language : 데이터 조작어
-- 테이블 행(레코드르)을 대상으로 CRUD 명령어 제공
-- create, read, update, delete 작업에 해당하는 명령어가 insert, select, update, delete이다.
-- 이중 select는 DQL로 구분한다.

-- -----------------
-- INSERT
-- -----------------
-- 새로운 행을 추가하고, 결과적으로 테이블의 행수가 늘어난다.
-- insert 요청시 처리된 행의 수가 반환된다.(Intellij에서 Service view - OUTPUT탭에서 확인이 가능하다.

# 문법
-- 1. 기본문법 : 테이블에 선언된 컬럼순서, 개수대로 입력
-- insert into 테이블 values(컬럼값1, 컬럼값2,...)
-- 2. 컬럼 작성문법 : 값을 입력할 컬럼을 명시한 후 값을 제공
-- insert into 테이블 (컬럼명1, 컬럼명 2..) values(컬럼값1, 컬럼값2, ..)
-- 3. bulk insert문법 : 대량의 데이터를 한번에 입력 가능
-- insert into 테이블 values(컬럼값1, 컬럼값2, ...),(컬럼값1, 컬럼값2, ...),(컬럼값1, 컬럼값2, ...)

    select * from tbl_menu;
-- 테이블의 구조
show create table tbl_menu; -- create table문 열람 가능
desc tbl_menu; -- 테이블의 구조를 쉽게 알 수 있음
-- auto_increment : 자동 증가 컬럼(PK : 고유식별컬럼값)은 별도의 값을 작성하지 않아도, 자동으로 고유한 숫자값을 발급.

-- 기본 문법
insert into
 tbl_menu
values(null, '바나나 해장국',8500,4,'Y');

-- 컬럼명 제공 문법
-- 기본값이 명시되지 않은 not null 컬럼은 생략 할 수 없다.
insert into
    tbl_menu(menu_name, menu_price, category_code, orderable_status)
value ('파인애플탕',5500,4,'Y');

insert into
    tbl_menu(orderable_status,menu_price,menu_name)
values(
       'Y',7500,'소고기라떼'
      );


insert into
    tbl_menu(menu_name)
values(
          '육회주스');

-- bulk insert문법
insert into
tbl_menu
values(null,'참치맛 아이스크림',1700,12,'Y'),
(null,'멸치맛 아이스크림',1500,11,'Y'),
(null,'소시지맛 카페오레',3500,8,'Y');

select * from tbl_menu;

insert into employee
values ('301', '함지만', '781020-2123453', 'hamham@ohgiraffers.com', '01012343344', 'D1', 'J4', 'S3', 43000000, 0.2, '200',
        now(), null, default);
insert into employee
values ('302', '장채현', '901123-1080503', 'jang_ch@ohgiraffers.com', '01033334444', 'D2', 'J7', 'S3', 3500000, 200);

drop table tbl_coupon;
-- 쿠폰테이블
create table tbl_coupon
(
    id int auto_increment primary key , -- 쿠폰 식별 번호(중복되지 않는 식별번호를 자동으로 발급)
    coupon_name varchar(1000) not null, -- 쿠폰명
    discount_price int, -- 금액 할인인 경우 할인 금액
    discount_rate double, -- 비율 할인인 경우 할인 비율
    issued_at datetime not null default now(),-- 발급일
    expires_at date not null -- 만료일
);
desc tbl_coupon;

-- insert시에 생략 가능한 컬럼 ? id, issued at ,price , rate

insert into tbl_coupon
values(null,'대한독립쿠폰',5000,null,now(),now() + interval  1 month),
      (null,'건국기념쿠폰',null,0.15,now(),now() + interval  1 month),
      (null,'봄맞이 쿠폰',3000,null,now(),now() + interval  1 month),
      (null,'여름맞이 쿠폰',3000,null,now(),now() + interval  1 month),
      (null,'가을맞이 쿠폰',3000,null,now(),now() + interval  1 month),
      (null,'겨울맞이 쿠폰',3000,null,now(),now() + interval  1 month);

select * from tbl_coupon;

-- -----------------
-- UPDATE
-- -----------------
-- 테이블 레코드 단위로 컬럼값을 수정하는 명령이다
-- 전체 행수는 변하지 않는다.

select * from tbl_menu;
-- 파인애플탕 메뉴의 카테고리를 퓨전(7)으로 변경
-- where절을 통해 대상행을 찾지 못한 경우, 오류는 발생하지 않는다. -> 그냥 값변경 X
update tbl_menu
    set
        category_code = 7
    where
       -- menu_name = '파인애플탕'
       menu_code = 24; -- 중복값이 없는 식별컬럼을 통해 찾는것이 좋다.

-- 서브쿼리를 통한 update
-- 우럭 스무디의 같은 카테고리로 파인애플탕의 카테고리를 수정하세요.
                       -- 수정하고자 하는 테이블을 서브쿼리에서 접근할 수 없다.

update tbl_menu
 set category_code = (select category_code
                      from tbl_menu
                      where menu_code = 2)
 where menu_code = 24;
-- 서브쿼리를 인라인뷰로 한번 감싸서 사용
update tbl_menu
 set category_code = (select category_code
                      from (select category_code
                          from tbl_menu
                      where menu_code = 2) t)

 where menu_code = 24;

select * from tbl_menu;

-- 한식 메뉴의 가격을 1000원씩 인상하는 update문을 작성 - category_code = 4
-- DML은 트랜잭션 모드를 수동(Manual)로 지정해서 쿼리 실행, db반영을 구별할 수 있음.
-- 트랜잭션 수동모드에서는 쿼리 실행 후 , 별도의 commit 명령을 통해 결과를 반영 할 수 있다. (rollback 명령 후 변환가능하다.)

update tbl_menu
set menu_price = menu_price + 1000
where category_code =  4;

select * from tbl_menu where category_code = 4;

-- rollback 변경사항을 취소하기
rollback;
-- commit 변경사항 적용하기 (취소불가)
commit;
select * from EMPLOYEE;
-- 사원 테이블에서 방명수 사원의 급여와 보너스를 유재식 사원과 동일하게 변경하세요.
update EMPLOYEE
set salary = (select SALARY
              from (select SALARY
                    from EMPLOYEE
                    where emp_id=204) s
              ),
    bonus = (select bonus
             from (select BONUS
                   from EMPLOYEE
                   where emp_id = 204) b
             )
where emp_id = 214;
-- 임시환 사원의 직급을 과장, 부서를 해외 영웝  부로 변경하세요 과장은 J5, 해외 영업부  D5,6,7
show tables;
select * from JOB;
select * from DEPARTMENT;

update EMPLOYEE
set job_code = (select JOB_code
                from JOB
                where job_name like '과장'),
    DEPT_CODE = (select DEPT_ID
                  from DEPARTMENT
                  where dept_title = '해외영업1부')
where emp_id = 219;

select * from EMPLOYEE;
commit;

-- -----------------
-- DELETE
-- -----------------
-- 테이블의 행을 삭제하는 명령
-- 실행결과 행수가 줄어든다
-- WHERE로 특정행을 한정해서 사용해야 한다.(WHERE절을 생략하면 모든행이 삭제된다.)

-- where절을 작성하지 않으면 모든 행을 삭제한다.
-- delete from
--     tbl_menu
-- where
-- menu_code = 28;

-- limi절을 이용한 제일 싼 2개 사용
delete from tbl_menu
order by menu_price
        limit 2; -- offset 지정안됨.

-- --------
-- Relplace
-- ---------
-- upsert : update + insert
-- pk컬림 기준으로 데이턱 ㅏ존재하면 update처리 , 존재하지 않으면 insert처리 .
select * from tbl_menu where menu_code = 17;

replace into
    tbl_menu
values(
       17, '참기름 소주', 5000, 10, 'Y'
      );
replace into
    tbl_menu
values(
       100, '고구마 소주', 15000, 10, 'Y'
      );

select * from tbl_menu where menu_code = 100

-- ------------
-- Merge
-- -----------
-- 병합 기능 지원
-- merge 멸영은 Mysql에서 지원하지 않는다. insert 사용
-- 서브쿼리를 이용한 대량이 데이터를 Insert 할 수 있다.


-- 테이블의 구조만 복사 (1=2 조건때문에 데이터는 복사되지 않는다.)
-- 서브 쿼리로 테이블을 생성하면, 테이블 NOT NULL 제약조건외에는 복사되지 않는다. (제약 조건 ,default값 등은 제외)
create table tbl_menu2
as
    select * from tbl_menu where 1 = 2;

select * from tbl_menu2;
desc tbl_menu2;


-- menu_code PK추가
alter table tbl_menu2
add constraint primary key (menu_code);

-- 서브 쿼리를 이용한 데이터 병합.
insert into
    tbl_menu2(menu_code,menu_name,menu_price,category_code, orderable_status)
select *
from tbl_menu;

select * from tbl_menu2;
desc tbl_menu2