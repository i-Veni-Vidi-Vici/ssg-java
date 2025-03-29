use menudb;

insert into tbl_menu
values(
       null,
       '바나나해장국',
       8500,
       4,
       'Y'
      )

insert into tbl_menu
(menu_name, menu_price, category_code, orderable_status)
values ('파인애플탕', 5500, 4, 'Y');
select
    *
from tbl_menu;

use empdb;

insert into employee
(emp_id, emp_name, emp_no, email, phone, dept_code, job_code, sal_level, salary, bonus, manager_id)
VALUES(301, '함지민', '781020-2123453','hamham@ohgiraffers.com','01012343334', 'D1', 'J4', 'S3', 4300000, 0.2, 200);
insert into employee
(emp_id, emp_name, emp_no, email, phone, dept_code, job_code, sal_level, salary, bonus, manager_id)
VALUES(302, '장채현', '901123-1080503','jang_ch@ohgiraffers.com','01033334444', 'D2', 'J7', 'S3', 3500000, 0.0, 200);

select *
from employee;

create table tbl_coupon(
    id int primary key auto_increment,
    coupon_name varchar(1000) not null,
    discount_price int,
    discount_rate double,
    issued_at datetime not null default now(),
    expires_at date not null
);
desc tbl_coupon;

insert into tbl_coupon
(coupon_name, discount_price, expires_at)
values
    ('대한독립기념쿠폰',5000,'2024-05-22');

insert into tbl_coupon
(coupon_name, discount_rate, expires_at)
values
    ('건국기념쿠폰',0.15,'2024-05-22');

insert into tbl_coupon
(coupon_name, discount_price, issued_at, expires_at)
values
    ('봄맞이쿠폰',	3000,'2024-02-15 00:00:00',	'2024-06-01'),
    ('여름맞이쿠폰',3000,'2024-05-15 00:00:00','2024-09-01'),
    ('가을맞이쿠폰',3000,'2024-08-15 00:00:00','2024-12-01'),
    ('겨울맞이쿠폰',3000,'2024-11-15 00:00:00','2025-03-01');

select *
from tbl_coupon;

use menudb;
select *
from tbl_menu;

update tbl_menu
set category_code =7
where
   -- menu_name = '파인애플탕'
   menu_code =24;

update tbl_menu
set category_code = (select category_code from (select category_code from tbl_menu where menu_name='우럭스무디') t)
where menu_code = 24;

update tbl_menu m
set menu_price = menu_price+1000
where m.category_code = (select category_code from (select  category_code from tbl_category where category_name='한식') c);
select
    *
from tbl_menu;
rollback ;
commit;

use empdb;

update employee
set
    SALARY = (select SALARY from (select SALARY from employee where EMP_NAME='유재식') s),
    BONUS =(select bonus from (select bonus from employee where EMP_NAME='유재식') b)
where EMP_NAME='방명수';
select *
from employee;

update employee e
set
    e.JOB_CODE = (select JOB_CODE from job where JOB_NAME='과장' ),
    e.DEPT_CODE = (select DEPT_ID from department where DEPT_TITLE='해외영업3부')
where EMP_NAME='임시환';

commit;
use menudb;
commit;