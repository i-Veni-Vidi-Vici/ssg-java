show databases;
use menudb; -- 특정 database 를 선택하고, 테이블 작업이 가능하다.

select * from tbl_menu; -- 메튜
select * from tbl_category; -- 카테고리
select * from tbl_order; -- 주문내역
select * from tbl_order_menu; -- 주문별 메뉴정보
select * from tbl_payment; -- 결제
select * from tbl_payment_order;