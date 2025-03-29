-- ============================
-- EVENT SCHEDULER
-- ============================
-- 특정이벤트(DML, DDL, 프로시져호출)를 언제 또는 어떤 주기를 실행할지에 대한 정보를 가진 객체

# 스케쥴
-- 1. AT 언제 실행
-- 2. EVERY 얼마마다 실행
-- 3. STARTS 언제 시작
-- 4. ENDS 언제 끝

# event 실행가능여부
show variables like 'event_scheduler'; -- ON
set global event_scheduler = 'ON'; -- (root계정만) 관리자 허락하에 사용가능

# time_log 테이블에 기록하는 이벤트
create table time_log(
    id int primary key auto_increment,
    at datetime default current_timestamp
);

delimiter $$
create event event_time_log
-- schedule
    on schedule
#     at now() + interval 1 minute -- 1분후에 딱 한번 실행
#     at '2024/12/25 00:00:00'
    every 1 minute starts now() + interval 10 second
    ends now() + interval 5 minute
    on completion preserve enable -- 이벤트 종료후 제거여부 (기본값 on completion not preserve enable)
    comment '타임로그로그'
do
-- 이벤트 내용 작성
    insert into time_log
    values (null, default)
$$
delimiter ;

select * from information_schema.EVENTS;
select * from time_log;
