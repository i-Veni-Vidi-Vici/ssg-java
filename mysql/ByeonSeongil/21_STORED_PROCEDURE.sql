-- ==================================
-- STORED PROCEDURE
-- ==================================
-- 내부적으로 n개의 쿼리를 묶어서 처리할 수 있는 서브프로그램 객체
-- 여러 트랜잭션을 묶어서 처리할 목적으로 사용

-- call 키워드를 통해 프로시져 호출 (매개변수 전달) (SELECT문에서 호출 불가)
-- 리턴값은 없지만, OUT모드 매개변수를 통해서 호출부로 n개의 값을 전달 가능
-- 매개변수 모드 지원 : IN(프로시져에 값을 전달), OUT(호출부 값을 전달), INOUT(IN-OUT 둘다 가능, 실제로는 잘 사용하지 않음)
-- 프로시져안에서는 조건분기, 반복처리등 모두 가능

-- 회원등록 프로시져
-- 회원등록에 필요한 값을 프로시져에 전달, 생성된 PK컬럼값을 반환처리
create table tbl_member(
    id int primary key auto_increment,
    username varchar(50) not null ,
    password varchar(20) not null ,
    created_at datetime default (current_timestamp)
);

delimiter $$
create procedure proc_create_member(
    IN p_username varchar(50),
    IN p_password varchar(20),
    OUT p_id int
)
begin
    -- 지역변수 선언

    -- 실행부
    insert into tbl_member (username, password)
        values (p_username, p_password);
    -- 발급된 auto_increment컬럼값 가져오기
    set p_id := last_insert_id();
end $$  delimiter ;

-- 프로시져 호출
-- @member_id 사용자 정의변수(세션이 활성화되있는 동안 사용가능)
call proc_create_member('honggd', '1234', @member_id);
select @member_id "발급된 id";
select * from tbl_member where id = @member_id;

# 프로시져 안에서 LOOP
-- 1부터 사용자 지정한 수까지의 합 구하기
drop procedure proc_loop;
delimiter  //
create procedure  proc_loop(
    n int,
    OUT sum int
)
begin
    declare i int default 1;
    set sum :=0;
    abc: loop
        set sum := sum +i;
        set i := i+1;
        if i > n then
            leave abc;
        end if;
    end loop;
end // delimiter ;

call proc_loop(10, @sum);
select @sum;