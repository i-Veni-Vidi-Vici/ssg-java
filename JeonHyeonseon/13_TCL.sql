-- ======================================
-- TCL
-- ======================================
-- Transaction Control Language 트랜잭션 제어어
-- DCL 하위로 분류
-- commit(변경사항 반영), rollback(변경사항을 취소), savepoint(변경사항을 중간 임시저장) 명령어 지원

# 트랜잭션이란
-- 한꺼번에 처리되어야 할 최소한의 작업단위
-- 트랜잭션 범위의 DML명령은 모두 성공되던가, 모두 실패되어야 한다.

# 트랜잭션 ACID 원칙
-- 1. Atomicity : 원자성.
--      - 트랜잭션과 관련된 일은 모두 실행되던지 모두 실행되지 않도록 하던지를 보장하는 특성이다.
-- 2. Consistency : 일관성.
--      - 트랜잭션이 성공했다면, 데이터베이스는 그 일관성을 유지해야 한다.
--      - 일관성은 특정한 조건을 두고, 그 조건을 만족하는지를 확인하는 방식으로 검사할 수 있다.
-- 3. Isolation : 독립성.
--      - 트랜잭션을 수행하는 도중에 다른 연산작업이 끼어들지 못하도록 한다.
--      - 임계영역을 두는 것으로 달성할 수 있다. 기본적으로 READ_COMMITED 방식을 적용한다.
-- 4. Durability : 지속성.
--      - 성공적으로 트랜잭션이 수행되었다면, 그 결과는 완전히 반영이 되어야 한다.
--      - 완전히 반영되면 로그를 남기게 되는데, 후에 이 로그를 이용해서 트랜잭션 수행전 상태로 되돌릴 수 있어야 한다.
--      - 때문에 트랜잭션은 로그저장이 완료된 시점에서 종료가 되어야 한다.

-- 예) 계좌이체 : a은행 계좌에서 출금, b은행 계좌에 입금하는 행위
-- 1. a은행 update문 : balance = balance - money
-- 2. b은행 update문 : balance = balance + money
-- 3. 완료 (commit) 또는 실패 (rollback)

create table kb_bank (
    id int primary key,
    name varchar(100) not null,
    balance bigint check (balance >= 0)
);
create table ssg_bank (
     id int primary key,
     name varchar(100) not null,
     balance bigint check (balance >= 0)
);
insert into kb_bank values (1000, '홍길동', 1000000);
insert into ssg_bank values (2000, '신사임당', 1000000);

-- 계좌이체 트랜잭션
start transaction; -- 트랜잭션을 수동으로 제어(Manual과 같음)
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
-- 트랜잭션 내부 처리가 모두 성공한 경우에만 commit
commit;
-- 트랜잭션 내부처리가 하나라도 실패한 경우는 rollback
rollback;

select * from kb_bank;
select * from ssg_bank;