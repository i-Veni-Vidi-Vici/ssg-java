
show create table tbl_menu;

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

show tables ;

desc tbl_menu;
-- auto_increment

insert into
    tbl_menu values (null, '바나나해장국',8500,  4,'Y');
select * from tbl_menu;

-- 컬럼명 제공 문법
insert into
    tbl_menu(menu_name, menu_price, category_code, orderable_status)
values('파인애플탕', 5500, 4, 'Y');

insert into
    tbl_menu(orderable_status, menu_price, menu_name)
values('Y', 7500, '소고기라떼');

insert into
    tbl_menu
values
    (null, '참치맛 아이스크림', 1700 ,12 , 'Y'),
    (null, '멸치맛 아이스크림', 1500 , 11 , 'Y'),
    (null, '소시지맛 카페오레',3500 , 8, 'Y');

select * from tbl_menu;

use empdb;
-- 다음 데이터를 추가하시오

desc employee;

insert into employee
values
    (301, '함지민', '781020-2123453', 'hamham@kh.or.kr', '01012343334', 'D1', 'J4', 'S3', 4300000, 0.2, '200', null, null, null),
    (302, '장채현', '901123-1080503', 'jang_ch@kh.or.kr', '01033334444', 'D2', 'J7', 'S3', 3500000, null, '20', null, null, null)

select * from employee;

use menudb;

-- 쿠폰 테이블
create table tbl_coupon(
    id int auto_increment primary key , -- 쿠폰 식별번호
    coupon_name varchar(1000) not null, -- 쿠폰명
    discount_price int, -- 금액할인인 경우 할인금액
    discount_rate double, -- 비율할인인 경우 할인비율 (0.5 -> 50%)
    issued_at datetime not null default now(), -- 발급일
    expires_at date not null -- 만료일
);

desc tbl_coupon;


insert into tbl_coupon
values
    (null,	'대한독립기념쿠폰', 5000, null, default,	'2024-05-22'),
    (null,	'건국기념쿠폰', null, 0.15, default, '2024-05-22'),
    (null, '봄맞이쿠폰', 3000, null,	default, '2024-06-01'),
    (null,	'여름맞이쿠폰',	3000, null,	default, '2024-09-01'),
    (null,	'가을맞이쿠폰',	3000, null,	default, '2024-12-01'),
    (null,	'겨울맞이쿠폰',	3000, null,	default, '2025-03-01');

select * from tbl_coupon;


update
    tbl_menu
set
    category_code = 7
where
    menu_name = '파인애플탕';

update
    tbl_menu
set
    category_code = (select
                         category_code
                    from
                        (select category_code from tbl_menu where menu_name = '우럭스무디') t)
where
    menu_code = 24;

select * from tbl_menu;

-- 한식메뉴의 가격을 1000원씩 인상하는 update문을 작성
-- DML은 트랜잭션 모드를 수동으로 지정해서 쿼리 실행, db 반영을 구분할 수 있다
-- 트랜잭션 수동 모드에서는 쿼리 실행 후, 별도의 commit 명령을 통해 결과를 반영할 수 있다
-- rollback 명령시 변경사항 없음

update
    tbl_menu
set
    menu_price = menu_price + 1000
where
    category_code = (select category_code
                     from (select category_code
                            from tbl_category
                            where category_name = '한식') c );

select * from tbl_menu;

-- rollback 변경사항을 취소하기
rollback;
commit;

-- 사원테이블에서 방명수 사원의 급여와 보너스를 유재식 사원과 동일하게 변경하세요
use empdb;

update
    employee
set
    SALARY = (select salary
             from(select SALARY
              from employee
              where EMP_NAME = '유재식') t),
    BONUS = (select BONUS
             from(select BONUS
              from employee
              where EMP_NAME = '유재식') t)
where
    EMP_NAME = '방명수';

select * from employee where EMP_NAME in ('방명수', '유재식');

-- 임시환 사원의 직급을 과장, 부서를 해외영업3부로 변경하세요

update
    employee
set
    JOB_CODE = (select JOB_CODE
                     from job
                     where JOB_NAME = '과장'),
    DEPT_CODE = (select DEPT_CODE
                      from department
                      where DEPT_TITLE = '해외영업3부')
where
    EMP_NAME = '임시환';

select * from employee e left join job j on e.JOB_CODE = j.JOB_CODE where EMP_NAME = '임시환';

--
use menudb;

# delete from
#            tbl_menu
# where
#     menu_code = 28;

select * from tbl_menu;

rollback ;

delete from
           tbl_menu
order by menu_price
limit 2;

select * from tbl_menu order by menu_price;

-- replace
select * from tbl_menu where menu_code= 17;

replace into
    tbl_menu
values (
        17, '참기름소주', 5000, 10, 'Y'
       );

-- merge
-- merge는 지원하지 않음
-- insert 사용해서 구현
-- 서브쿼리를 이용한 대량의 데이터를 insert 가능

-- 테이블의 구조만 복사
-- 서브쿼리로 테이블을 생성하면, 테이블 not null 제약조건 외에는 복사되지 않는다. (제약조건, default 값 등)
create table tbl_menu2
as
select * from tbl_menu where 1=2;

select * from tbl_menu2;

desc tbl_menu2;

-- menu_code pk 추가
alter table tbl_menu2
add constraint primary key(menu_code);

-- 서브쿼리를 이용한 데이터 병합
insert into
    tbl_menu2 (menu_code, menu_name, menu_price, category_code, orderable_status)
select *
from tbl_menu;

select * from tbl_menu2;

create table kb_bank(
  id int primary key ,
  name varchar(100) not null,
  balance bigint check(balance >= 0)
);

create table ssg_bank(
  id int primary key ,
  name varchar (100) not null,
  balance bigint check(balance >= 0)
);

insert into kb_bank values (1000, '홍길동', 1000000);
insert into ssg_bank values (2000, '박문수', 1000000);

-- 계좌이체 트랜잭션
start transaction ;
update
    kb_bank
set
    balance = balance - 500000
where
    id = 1000;

update
    ssg_bank
set
    balance = balance + 500000
where
    id = 2000;

-- 트랜잭션 내부 처리 모두 성공한 경우에만 commit
commit;

select * from kb_bank
union all
select * from ssg_bank;

