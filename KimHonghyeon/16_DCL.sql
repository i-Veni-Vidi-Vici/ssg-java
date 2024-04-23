create user 'qwerty'@'%' identified by 'qwerty';

select *
from mysql.user;

grant select on menudb.tbl_menu to 'qwerty'@'%';
show grants for 'qwerty'@'%';