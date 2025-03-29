-- ===================================
-- INDEX
-- ===================================
-- 색인객체.(책색인? 책의 내용을 쉽고 빠르게 찾을 수 있게 키워드 정리해 둔 페이지)
-- SQL명령어 처리 속도 향상을 위해서 테이블의 컬럼에 대해서 작성해둔 객체
-- key-value형태로 생성되며, key에는 실제 컬럼의 내용(값), value에는 레코드의 주소가 매칭됨

# 장점
-- 검색속도가 빨라지면서 시스템부하를 줄이고 전체적인 성능향상이 가능
# 단점
-- 테이블외에 추가적인저장공간이 필요. 인덱스를 관리하는 시간이 부가적으로 소요됨
-- DML 작업이 자주 일어나는 테이블은 인덱스 처리때문에 소요시간이 늘어날 수 있다. -> 성능저하

# 인덱스 컬럼 산정 기준
-- 선택도가 좋은 컬럼을 인덱스로 만들어야 한다.
-- PK/UQ 컬럼은 자동으로 인덱스 생성됨.
-- WHERE 조건절에 자주 사용되는 컬럼, 조인조건컬럼으로 사용되는 컬럼등을 추가적으로 지정할 수 있다.
-- mysql은 fk컬럼도 자동으로 인덱스 생성한다.
-- 데이터양이 많아질수록 인덱스는 필수적으로 필요하다.

# 선택도
-- 고유한 값이 많은 정도
-- 주민번호는 선택도 매우 좋은편
-- 이름은 선택도 좋은편
-- 성별은 선택도 나쁜편

create table  phone(
    phone_code int primary key auto_increment,
    phone_name varchar(100),
    phone_price int
);

insert into phone(phone_name, phone_price)
values ('갤럭시S24', 1500000),
 ('아이폰15', 1700000),
 ('갤럭시Z폴드', 1650000);

select * from phone;

-- 인덱스 조회
show index from phone;

show index from tbl_menu; -- pk, fk
show index from tbl_category; -- pk, fk

-- 인덱스 사용 추적
-- db 내부 optimizer 프로그램에 의해서 쿼리실행 계획
explain select * from  phone where phone_code =1; -- pk컬럼 - 인덱스(1번을 통해 레코드주소확인) - 테이블
explain select * from  phone where phone_name ='갤럭시S24';

explain select * from tbl_menu where category_code = 4;

-- 인덱스 생성(phone.phone_name)
create index idx_phone_name on phone (phone_name);
show index from phone;

explain select * from  phone where phone_name ='갤럭시S24';

# 인덱스 사용되지 않는 경우
-- optimizer의 결정이전 쿼리조건에 따라 인덱스사용되지 않을 수 있다.
-- 1. 인덱스컬럼의 값이 가공되는 경우 left(phone_name, 1) ='갤'
-- 2. 인덱스컬럼의 비교하는 값의 자료형이 다른 경우  phone_code ='1'
-- 3. 인덱스컬럼과 null 비교하는 경우
-- 4. 인덱스컬럼과 동일비교하지 않은 경우  phones_name != '갤럭시'

# DROP INDEX idx_phone_name ON phone;

explain select * from  phone where phone_name ='갤럭시S24'; -- idx_phone_name
explain select * from  phone where left(phone_name,1) ='갤'; -- null
explain select * from phone where phone_code = 1; -- PRIMARY
explain select * from phone where phone_code = '1'; -- PRIMARY (mysql)
explain select * from phone where phone_name is null; -- idx_phone_name (mysql)
explain select * from phone where phone_name != '갤럭시S24'; -- idx_phone_name (mysql)

# 복합인덱스
-- 컬럼을 2개이상 묶어서 인덱스로 지정할 수 있다.
-- 선택도가 좋은 컬럼을 앞에 위치 해야 한다.
explain select * from phone where phone_name = '갤럭시S24' and phone_price =1500000;
explain select * from phone where phone_name = '갤럭시S24' and phone_code =1;

create index idx_phone_name_price on phone (phone_name, phone_price);
show index from phone;

-- 더 오래걸림
explain
select *
from phone
use index (idx_phone_name_price)
where  phone_name = '갤럭시S24'
and  phone_price = 1500000;



