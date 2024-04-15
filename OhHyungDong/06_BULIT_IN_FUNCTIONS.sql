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



