-- jpadb
-- root

create database jpadb;

grant all privileges on jpadb.* to 'sh'@'%';

-- sh

use jpadb;

select *
from tbl_member01;

select *
from tbl_member02;

select *
from tbl_member0301;

select *
from tbl_member0302;

select *
from tbl_sequence;

select *
from tbl_member04;

select *
from tbl_role_permission_0301;