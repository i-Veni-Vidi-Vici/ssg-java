-- ================
-- BUILT-IN FUNCTIONS
-- ================
-- 함수. 반복적으로 사용되는 작업을 묶어낸 단위.
-- 전달된 매개인자를 기반으로 작업을 수행, 반드시 하나의 리턴값을 반환한다.

# 함수 유형
-- 1. 단일행처리 함수 : 행별로 호출, 호출된만큼 결과를 반환
    -- 1-a 문자처리함수
    -- 1-b 숫자처리함수
    -- 1-c 날짜 / 시간 처리함수
    -- 1-d 형변환함수
    -- 1-e 기타함수

-- 2. 그룹함수 : 지정된 그룹별로 함수를 호출. 그룹당 하나의 결과를 반환

-- --------------
-- 문자처리함수
-- ---------------
-- ascii(문자) : 문자에 상응하는 아스키코드값 반환
-- char(아스키 코드) : 아스키 코드에 상응하는 문자 반환
select
    ascii('A'),
    char(65);

-- 문자열 길이 관련
-- length(문자열) : byte 수 반환
-- char_length(문자열) : 문자열의 길이 반환
-- bit_length(문자열) : bit수 반환 (byte * 8)
select length('pizza'),
       char_length('pizza'),
        bit_length('pizza');

select length('피자'), -- 6byte
       char_length('피자'), -- 2
       bit_length('피자'); -- 48 bit

select
    menu_name,
    length(menu_name),
    char_length(menu_name),
    bit_length(menu_name)
from
    tbl_menu;

-- 문자열 연결 연산
-- concat(값1, 값2,....)
-- concat_ws(구분자 , 값1, 값2,...) -> "값1 구분자 값2"

select
    concat('사자', '호랑이','토끼'),
    concat(',','사자', '호랑이','토끼');


-- 메뉴 조회 : "1. 떡볶이(3000원)"
select
   concat(menu_code,'.', menu_name,'(',menu_price,'원',')')
from
    tbl_menu;

-- 문자열 검색
-- elt(인덱스, 값1, 값2, .....) : 해당 인덱스의 값을 반환한다.
-- field(문자열, 값1, 값2, ..) 문자열과 일치하는 값의 인덱스를 반환
select
    -- elt(2,'사과','딸기','바나나');
    field('딸기','사과','딸기','바나나'); -- 인덱스 반환

-- csv데이터에서 값 찾기
-- find_in_set(문자열, csv데이터) 문자열과 일치하는 csv데이터의 인덱스를 반환
select
    find_in_set('딸기', '사과,딸기,바나나'),
    find_in_set('수박', '사과,딸기,바나나'); -- 없으면 인덱스 값 0 출력

-- order by에서 특정행만 끌어올리기 위한 용도로 사용 가능

select *
from
    tbl_menu
order by
    find_in_set(menu_code,'10') desc;
-- find_int_set 기준으로 컬럼을 정렬하기 때문에 10인 menu_code값은 1이고 나머지는 다 값이 0이다.
-- 오름차순 정렬되기 때문에 desc를 통해 맨위로 끌어주면 된다.

-- 문자열 검색
-- instr(대상 문자열, 찾는 문자열): 인덱스 반환
-- locate(찾는 문자열, 대상문자열): 인덱스 반환

select
    instr('사과딸기바나나','바나나'), -- 5
    locate('바나나','사과딸기바나나'), -- 5
    instr('사과딸기바나나','배'), -- 0
    locate('배','사과딸기바나나'); -- 0 -- 찾는 문자열이 해당문자열에 없으면 0반환

-- 숫자 포매팅(세자리 콤마찍기), 소수점이하 자리수 보전

-- format(숫자, 소수점 이하 자리수) : 형식 지정된 문자열 반환
select
    format(12345566778.12345678, 3),
    format(12345566778.12345678, 0);

-- 메뉴명 가격 조회
select
    menu_name,
    concat('`', format(menu_price,0)) menu_price
from tbl_menu;

-- 진수별 숫자표현
select
    bin(10), -- 1010
    oct(10), -- 12
    hex(10); -- A

-- 문자열 삽입
-- insert (대상 문자열, 시작 인덱스, 삭제할 개수, 추가할 문자열) : 변경된 문자열 반환
select insert("제이름은 아무개입니다. ", 6, 3, '홍길동');
select insert("제이름은 아무개입니다. ", 6, 0, '김');

-- 주스메뉴를 찾아서 '주우스'로 변경
select
    insert(menu_name,instr(menu_name,'쥬스'),2,"주우스")
from tbl_menu
where menu_name like '%쥬스%';

-- 문자열 잘라내기
-- left(대상문자열, 개수) : 왼쪽부터 지정한 개수만큼 잘라내서 반환
-- right(대상문자열, 개수) : 오른쪽부터 지정한 개수만큼 잘라내서 반환
-- left, right 둘다 잘라낸 값을 반환함.

select
    left('Hello world',3),
    right('Hello world',3);

-- subString(대상 문자열, 시작인덱스, 길이) " 잘라낸 문자열 반환
    select
        subString('d안녕하세요, 반갑습니다. ',8,2);
-- subSTring_index(대상문자열, 찾는 문자열, 횟수 n) : 대상문자열에서 n번째 문자열을 찾고, 그 이후를 버림 처리후 반환
    select SUBSTRING_INDEX('hong.gd@naver.com','.',1) -- hong
    select SUBSTRING_INDEX('hong.gd@naver.com','.',2) -- hong.get@naverc.
    select SUBSTRING_INDEX('hong.gd@naver.com','.',2) -- gd@naver.com

    select
        substring('hong.gd@naver.com',1,instr('hong.gd@naver.com','@') - 1),
        substring_index('hong.gd@anver.com', '@',1);
-- 대소문자 변환
select
    lower('HELLO WORLD'),
    upper('Hello World');

-- 문자열 채우기(padding : 여백)
-- lpad(문자열, 길이, 패딩문자) - 지정한 길이의 문자열에 첫번쨰 문자열과 왼쪽 남은 공간 패딩문자를 채운다.
-- rpad(문자열, 길이, 패딩문자) -  지정한 길이의 문자열에 첫번쨰 문자열과 오른쪽 남은 공간 패딩문자를 채운다.
select lpad('abc', 10, '@');
select rpad('abc', 10, '@');
-- 공백문자열 제거
-- ltrim(공백포함 문자열) : 왼쪽 공백문자 제거후 반환
-- rtrim(공백포함 문자열) : 오른쪽 공백문자 제거후 반환
-- trim(공백포함 문자열) : 양쪽 공백문자 제거후 반환
-- trim(방향 문자 from 대상문자열) : leading(좌) / trailing(우)/both ㅋ(방향지ㅋ)정후 해당문자 제거
select
    concat('(',ltrim('     안녕'),')'),
    rtrim('안녕      '),
    trim('     안녕      ');

select concat('(', trim(leading ' ' from '   안녕 '), ')');

-- 문자열 반복
select
    repeat('잼', 5),
    repeat('-',10);

-- 문자열 대체 : replace
select
    replace('마이 SQL', '마이','My')


select
    replace(menu_name,'쥬스','주우스')
from tbl_menu
where menu_name like '%쥬스';

-- 문자열 뒤집기 기능
select reverse('stressed');

-- 공란 생성
select
    concat('시작',space(5),'끝')

-- 정규표현식 관련
select
    regexp_replace('123,456,789원', '[^0-9]',''),-- 숫자의 정규표현식 : [0-9] 숫자가 아닌 정규표현식 [^0-9]
    regexp_substr('제 키는 188cm입니다.','[0-9]+'); -- '[0-9]+' : 숫자만 추출해줌 ,  + : 수량자 1개 이상

-- ----------------------
-- 숫자처리 함수
-- ----------------------
-- 절대값 반환
-- abs(숫자) : 부호를 제거한 절대값 반환
                                              select
                                                  abs(123),
                                                  abs(-123);
-- 올림, 내림, 반올림, 버림
-- 올림 : ceiling
-- 내림 : floor
-- 반올림 : round(숫자, 소수점 이하 자리수)
-- 버림 : truncate(숫자, 소수점이하 자리수)

select
    ceiling(123.456),
   floor(123.456),
   round(1234.56),
   round(1234.56,1); -- 소수점 한자리까지만 출력함.

-- 내림 / 버림 비교
-- 1. 내림 : 지정한 수보다 작은 정수 최대값
-- 2.버림 : 절삭
select floor(12.34),
       truncate(12.34, 0),
       floor(-0.6),
    truncate(-0.6,0);

-- 나누기 / 나머지 연산
-- 나누기 /
-- 나누기 div : 목만 구하는 경우
-- 나머지 mod(), &, mod

select
    10/3,
    10 div 3;

select 10 % 3,
       10 mod 3,
       mod(10, 3);

-- 거듭제곱, 제곱근
-- pow(밑수, 지수)
-- sqrt(숫자) > 제곱근
select pow(2, 3);
select pow(2, 32);

select
    sqrt(16),
    sqrt(10);

-- 양수 / 0 / 음수 판단
-- sign(숫자) : 1/0/-1 반환
select sign(10.1234),
       sign(0),
       sign(-1234.15435);

-- 난수발생
-- rand() : 0.0이상 1.0미만의 난수(실수)를 반환
-- 내림(rand() * 경우의수 + 최소값)
select
    floor(rand() * 10 + 1); -- 1.0 ~ 11.0 미만

-- ----------------------
-- 날짜 / 시간 처리 함수
-- ----------------------
-- 날짜 연산
-- adddate(날짜, 일수) : 연산된 날짜 반환
-- adddate(날짜, interval n 단위) : 연산된 날짜 반환
-- subdate(날짜, 일수) : 연산된 날짜 반환
-- subdate(날짜, interval n 단위) : 연산된 날짜 반환

-- 지원하는 단위 year, month, day, hour, minute, second
select now(),
       adddate(now(), 1), -- 하루 추가해서 출력
       adddate(now(), interval 1 day),
       adddate(now(), interval 1 month),
       adddate(now(), interval 1 year);

select addDate('2024-01-31', interval 1 month); -- 2024-02-29
select
    subDate(now(),1),
    subDate(now(),interval 1 day),
    addDate(now(), -1);

-- addtime(날짜 시간, 시간)
-- subtime(날짜 시간, 시간)
-- addtime(날짜 시간, interval n 단위) -> 지원하지 않음.

select now(),
       addTime(now(), '1:2:3'),
       subTime(now(), '1:2:3'),
       ADDDATE(now(), interval 1 hour);

--  +, - 연산자로 처리하기
select
    now() + interval 1 hour;

-- 현재 날짜 가져오기
-- cudate(), current_date(), current_date
select
    curdate(),
    current_date(),
    current_date;

-- 현재 시각
-- curtime(), current_time() current_time
select
    curtime(),
    current_time(),
    current_time;

-- 현재 날짜 / 시각
-- now(), sysdate(), localtime, localtimestamp(), localtimestamp

select
    now(), sysdate(), localtime, localtimestamp(), localtimestamp

-- 년월일시분초 단위별로 추출
-- year(날짜)
-- month(날짜)
-- dayofmonth(날짜)
-- hour(시각)
-- minute(시각)
-- second(시각)

select year(now());

-- extract(단위 from 날짜 시각) : 해당 단위의 숫자 반환
select
    extract(year from now()),
    extract(month from now()),
    extract(day from now()),
    extract(hour from now()),
    extract(minute from now()),
    extract(second from now());

-- 날짜 / 시간 차이 구하기
-- datadiff(미래 날짜, 과거날짜)
-- timediff(미래 시각, 과거 시각)
select
    datediff('2024/04/20', now()), -- 4
    datediff(now(),'2024/04.20'); -- -4

select timediff('12:50:00', '10:30:00'); -- 02 : 00

-- 수료일 d-day 계산 쿼리
select datediff('2024/09/05',now())

-- 날짜 정보 관련
-- dayofweek(날짜) : 요일에 해당하는 인덱스 반환 (일요일 : 1 ~ 토요일 - 7)
-- monthname : 월 이름 반환
-- dayofyear(날짜) : 해당년도 몇번째 날인지 반환
select
    dayofweek(now()),
    monthname(now()),
    dayofyear(now());

-- 말일계산
-- lastday(날짜) : 말일에 해당하는 날짜 반환
select
    last_day(now()),
    last_day('2023-02-01');

select
    last_day(now() + interval 1 month );

-- 날짜 / 시각 생성하기
-- makedata(년, 일수)  : 해당 년도 일수번째 날짜 반환
-- maketime(시, 분, 초) : 시각 반환
select
    makedate(2024,32);

-- 기간 계산
-- period_add(년월, 개월 수) : 연산된 년월 반환
-- period_diff(미래 년월, 과거년월) : 개월 수 차이 반환
select period_add(202404, 18);


-- 분기 확인
-- quarter(날짜) : 1, 2, 3, 4분기 반환
select
    quarter((now()),
    quarter('2024-03-03'),
    quarter('2024-08-08'),
    quarter('2024-11-08');

-- 초계산
-- time_to_sec(시간) : 초로 변환
select time_to_sec('1:0:0');

-- 날짜 시각을 특정형식으로 출력하기
-- date_format(날짜 / 시각, 형식문자열) : 지정된 형식의 문자열을 반환해준다.
-- 형식
-- %Y/ %y 연도 4자리 / 연도 2자리
-- %m 월
-- %d 일
-- %H / %h 시간(24시간) / 시간(12시간)
-- %i 분
-- %s 초
-- %w 요일 숫자로 반환 -> 일요일 0 ~ 토요일(6),
-- %W : 요일명으로 반환
-- %a 요일명 : 짧은것
-- %p : am/pm

select
    date_format(now(), '%y/%m%d'),
    date_format(now(), '%H/%i%s'),
    date_format(now(), '%Y년 %m월 %d일 (%a)');

-- 지역변경
select @@lc_time_names; -- en_US
select @@lc_time_names = 'ko_KR';

-- ================
-- 형변환 함수
-- ================
-- mysql에서는 암묵적 / 명시적 형변환 모두 지원한다

# 명시적 형변환
-- cast(값 as 자료형)
-- convert(값, 자료형)

select 123,
       cast(123 as char);

select
    123.456,
    cast(123.456 as signed integer),
    convert(123.456, unsigned integer);

#암묵적 형변환
select '1' + '2'; -- 3 숫자 변환 후 1+2 = 3 처리됨.
select '1' + 'zzz'; -- 1 , 숫자로 변화불가한 문자열은 0으로 변환후 1 + 0 계산
select concat(1, 2, 3, '원'); -- 123원 숫자가 문자열로 자동변환 후 연결 '1' '2' '3' '원'
select ADDDATE('2024-04001', 1); -- 2024 -04 -02 date형 먼저 변환 후 1일 더하기 처리

select '1' + '3만원' ;-- 1+3 숫자로 시작되는 문자열은 숫자부분만 변환 -> 얘는 숫자로 시작하기 떄문에 계산이 됨.
select '1' + '내가 가진 3만원' -- 1+0
select 3 > '오'; -- 1(ture) '오'는 0으로 암묵적 변환
select 3 > '5오오옹오' -- false 5가 숫자로 형변환 되기 때문에 false

-- ------------------
-- 기타 함수
-- ------------------
 #null처리 함수
-- ifnull(값 , null일 떄 값) : 값이 null이면, 값을 사용 , 값이 null이면 null일 때 값 사용
select
    ifnull('abc', 'xyz'),
    ifnull(null, 'xyz');

    -- 메뉴 테이블에서 메뉴명, 카테고리 번호(null일 경우 ' 카테고리 없음 '조회)
 select
        menu_name,
        ifnull(category_code,'카테고리없음') category_code
from tbl_menu;

-- Null이 아닌 값 찾기
-- coalesce(값1, 값2, ...) null이 아닌 첫번째 값 반환
select coalesce('a', 'b', 'c', null),
       coalesce(null, null, 'a', 'b', 'c', null);


-- 삼항 연산처리
-- if (조건식, 참일때 값, 거짓일때 깞)
select if(3 > 2, 3, 2);
-- 메뉴 테이블에서 메뉴명 , 가격, 주문 가능여부(주문가능 | 주문 불가)

select
    menu_name, menu_price,
    if(orderable_status ='Y','주문가능','주문불가')
from tbl_menu;

-- isnull(값) : null 여부 반환
select isnull('zzz'); -- null이 아니여서 0반환
select isnull(null); -- null이여서 1반환

-- if _ is null()
                     select
                         menu_name,
                         if(isnull(tbl_menu.category_code),'카테고리없음',tbl_menu.category_code) categorycode

                     from tbl_menu;

# 선택함수 case
-- 다양한 케이스에 따라 분기처리를 지원하는 함수 (결과값을 반환)

-- 타입 1 : if..else if
-- case
--      when 조건1 then 값1
--      when 조건2 then 값2
--      else 기본값
-- end case
-- 타입 2
-- case 표현식
--      when 값1 then 결과값1
--      when 값2 then 결과값2
--      ...
--      else 기본값
-- end

-- 싼거 5000원 미만
-- 적당한거 5000원 ~ 10000원
-- 좀비싼거 10000원 - 20000
-- 겁나 비싼거 20000 이상

select
    menu_name, menu_price,
    case
        when menu_price < 5000 then '싼거'
        when menu_price between 5000 and 10000 then '적당한거'
        when menu_price between 10000 and 20000 then '싼거'
        else '겁나비싼거'
    end "menu_label" -- 별칭
from tbl_menu;


select menu_name,
       menu_price,
       case category_code
           when isnull(category_code) then '카테고리 코드없음'
            when !isnull(category_code) then category_code
        end categorycode,
        case orderable_status
            when 'Y' then '주문 가능'
     --    when 'N' then '주문 불가 '
            else '주문 불가'
        end orderable
from
    tbl_menu;

-- -------------------
-- 그룸합수
-- -------------------
-- 하나 이상의 행을 그룹으로 묶고, 그룹당 하나의 결과값을 반환하는 함수
    -- group by를 사용하지 않는다면 , 전체(모든 행)를 하나의 그룹으로 간주한다.
    -- group by를 사용한다면, group by 그룹별로 하나의 결과를 반환한다
    -- ** 그룹함수의 결과와 일반컬럼은 동시에 사용할 수 없다.**


# sum
-- 특정 컬럼의 합을 계산해서 반환
select sum(menu_price)
from tbl_menu;


# avg
-- 특정 컬럼의 평균값 반환
select
    avg(tbl_menu.menu_price),
    truncate(avg(menu_price),1)
from tbl_menu;
# count
-- 특정 컬럼의 값의 개수를 세어 반환. null값은 처리하지 않는다.
select
    count(*) ,-- 모든 컬럼(행의 수)
    count(category_code)
from tbl_menu;

# max/min
-- 특정 컬럼의 최소 / 최대를 반환
-- 숫자 / 문자(사전 등재 순 맨먼저 ~ ㅁ맨뒤) / 날짜(과거 - 미래)에 대해서 적용 가능

select
    max(menu_price),
    min(menu_price),
    max(menu_name),
    min(menu_name)
from tbl_menu;