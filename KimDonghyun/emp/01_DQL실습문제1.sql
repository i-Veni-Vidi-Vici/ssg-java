-- # DQL실습문제1 풀이
-- root계정으로 다음 실행
CREATE DATABASE empdb;
GRANT ALL PRIVILEGES ON empdb.* TO 'sh'@'%';

-- sh계정으로 다음 실행
use empdb;

-- 1. employee 테이블에서 이름 끝이 연으로 끝나는 사원의 이름을 출력하시오
select
    emp_name
from
    employee
where
    emp_name like '%연';


-- 2. employee 테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호를 출력하시오
select
    emp_name, phone
from
    employee
where
    phone not like '010%';

-- 3. employee 테이블에서 메일주소 '_'의 앞이 4자이면서, DEPT_CODE가 D9 또는 D5이고 고용일이 90/01/01 ~ 01/12/31이면서, 월급이 270만원 이상인 사원의 전체 정보를 출력하시오
select
    *
from
    employee
where
    (email like '____\_%')
  and
    (dept_code='D9' or dept_code='D6')
  and
    (hire_date between '90/01/01' and '00/12/01')
  and
    salary >= 2700000;

-- 4. tbl_escape_watch 테이블에서 description 컬럼에 99.99% 라는 글자가 들어있는 행만 추출하세요.
-- 테이블 및 데이터 등록후 문제풀이
create table tb_escape_watch(
                                watch_name   varchar(100),
                                description    varchar(1000)
);
-- drop table tb_escape_watch;
insert into tb_escape_watch values('금시계', '순금 99.99% 함유 고급시계');
insert into tb_escape_watch values('은시계', '고객 만족도 99.99점를 획득한 고급시계');
commit; -- Transaction 저장 명령 (Tx: Auto일때는 실행하지 않아도 된다.)
select * from tb_escape_watch;


select
    *
from
    tb_escape_watch
where
    description like '%99.99\%%';

-- 5. employee테이블에서 현재 근무중인 사원을 이름 오름차순으로 정렬해서 출력.
select
    *
from
    employee
where
    quit_yn = 'N'
order by
    emp_name;

-- 6. 사원별 입사일, 퇴사일, 근무기간(일)을 조회하세요. 퇴사자 역시 조회되어야 합니다.
select
    emp_name,
    hire_date,
    quit_date,
    datediff(ifnull(quit_date, now()), hire_date),
    quit_yn
from
    employee;