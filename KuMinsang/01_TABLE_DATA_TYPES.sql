show databases;
use menudb;

select * from tbl_menu; -- 메뉴
select * from tbl_category; -- 카테고리
select * from tbl_order;    -- 주문 내역
select * from tbl_order_menu; -- 주문별 메뉴 정보
select * from tbl_payment; -- 결제
select * from tbl_payment_order; -- 결제-주문 연동데이터

-- db에서는 대소문자를 구분하지 않으므로 snake case 방식으로 단어를 연결해 사용한다
create table tbl_data_types_char (
    a char(10), -- 10글자
    b varchar(10) -- 10글자
);
select * from tbl_data_types_char;
desc tbl_data_types_char;

insert into tbl_data_types_char values ('korea', 'korea');
insert into tbl_data_types_char values ('개구리', '개구리');
insert into tbl_data_types_char values ('1234567890', '1234567890');
insert into tbl_data_types_char values ('12345678901', '12345678901'); -- [22001][1406] Data truncation: Data too long for column 'a' at row 1

select
    a, length(a), char_length(a),
    b, length(b), char_length(b)
from
    tbl_data_types_char;


-- ----------------------
-- 숫자형
-- ----------------------
-- int (integer) 정수타입

create table tbl_data_types_number
(
    a int,
    b float,
    c double,
    d decimal(30, 20)
);


insert into
    tbl_data_types_number
values (
        1234.5678,
        1234.5678,
        1234.5678111111111111111,
        1234.5678111111111111111
);

select * from tbl_data_types_number;

select now(); -- 특정테이블 참조 없이 사용가능
create table tbl_data_types_date
(
    a date,
    b time,
    c datetime,
    d timestamp,
    e year
);

insert into tbl_data_types_date
values (now(),
        now(),
        now(),
        now(),
        now()
);

select * from tbl_data_types_date;
-- 지역대 정보가 변경되면 timestamp 타입은 그에 알맞게 변환해서 불러온다
select @@session.time_zone; -- SYSTEM
set time_zone = '+09:00'; -- KST +09:00
set time_zone = '-04:00'; -- NewYork -04:00
