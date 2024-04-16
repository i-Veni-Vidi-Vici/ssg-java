/*
===================================================================
 BUILT-IN FUNCTIONS
===================================================================
- 함수, 반복적으로 사용되는 작업을 묶어낸 단위
- 전달된 매개인자를 기반으로 작업을 수행, 반드시 하나의 리턴값을 반환

# 함수 유형
- 1. 단일행처리 함수 : 행별로 호출, 호출된만큼 결과를 반환
    1-a. 문자처리함수
    1-b. 숫자처리함수
    1-c. 날짜/시간처리함수
    1-d. 형변환함수
    1-e. 기타함수
- 2. 그룹함수 : 지정된 그룹별로 함수를 호출. 그룹당 하나의 결과를 반환
*/

/*
----------------------------------------------------------------
 문자처리함수
----------------------------------------------------------------
- ascii(문자) : 문자에 상응하는 아스키코드값 반환
- char(아스키코드) : 아스키코드에 상응하는 문자반환
*/
select
    ascii('A'),
    char(65);
#     ascii('한') # 실제 유니코드기반으로 뱉어주는 게 아니다?!
;

-- 문자열길이관련
-- length(문자열) byte수 반환
-- char_length(문자열) 문자열의 길이 반환
-- bit_length(문자열) bit수 반환 (byte * 8)
select
    length('pizza'), -- 5 byte
    char_length('pizza'), -- 5개
    bit_length('pizza'); -- 40 bit

select length('피자'), -- 6 byte ( 3 + 3)
       char_length('피자'), -- 2개
       bit_length('피자'); -- 48 bit

select
    menu_name,
    length(menu_name),
    char_length(menu_name),
    bit_length(menu_name)
from tbl_menu;

-- 문자열 연결연산
-- concat(값1, 값2) "값1값2"
-- concat_ws(구분자, 값1, 값2, ...) "값1구분자값2"

select
    concat('사자', '호랑이', '토끼'), -- 사자호랑이토끼
    concat_ws(',','사자', '호랑이', '토끼'); -- 사자,호랑이,토끼


-- 메뉴조회 : "1. 떡볶이 (3000원)"
select concat(menu_code, '. ', menu_name,'(', menu_price, '원)')
from tbl_menu;

-- 문자열 검색
-- elt(인덱스, 값1, 값2, ...) 해당 인덱스의 값을 반환
-- field(문자열, 값1, 값2, ...) 문자열과 일치하는 값의 인덱스를 반환
select elt(2, '사과', '딸기', '바나나'), -- 딸기
       field('딸기', '사과', '딸기', '바나나'); -- 2

-- csv데이터에서 값 찾기
-- find_in_set(문자열, csv데이터) 문자열과 일치하는 csv데이터의 인덱스를 반환
select
#     find_in_set('딸기', '사과,딸기,바나나'); -- 공백없이쓰기!
    find_in_set('아보카도', '사과,딸기,바나나'); -- 부재시 0
-- order by에서 특정행만 끌어올리기 위한 용도로 사용가능 (중요한 공지 pin하기와 같은 기능에 유용)

select *
from tbl_menu
order by
    find_in_set(menu_code, '10') desc ; -- 10빼고 다 0
#     find_in_set('1', '10') desc ; -- 0
#     find_in_set('10', '10') desc ; -- 1

-- 문자열 검색
-- instr(대상문자열, 찾는문자열) : 인덱스반환
-- locate(찾는문자열, 대상문자열) : 인덱스반환
select
    instr('사과딸기바나나', '바나나'), -- 5번지
    locate('바나나', '사과딸기바나나'), -- 5번지
    locate('바나나', '사과딸기'), -- 0번지
    locate('바나나', '사과딸기'); -- 0번지

-- 숫자포매팅(세자리콤마찍기, 소수점이하 자리수보전)
-- format(숫자, 소수점이하자리수) : 형식지정된 문자열반환
select
    format(1234567890.0127456789, 3), -- 소수점이하 네자리에서 반올림처리
    format(1234567890.0127456789, 0);

-- 메뉴명 가격조회 (살구쥬스 ￦1,200)
select
    concat('(',
        menu_name,
        ' ￦',
        format(menu_price, 0),
        ')'
    )
from tbl_menu;

-- 진수별 숫자표현
select
    bin(10), -- 1010
    oct(10), -- 12
    hex(10); -- A
    -- 왼쪽정렬 -> 문자열을 의미

-- 문자열 삽입
-- insert(대상 문자열, 시작 인덱스, 삭제할 개수, 추가할 문자열) : 변경된 문자열 반환
select insert('제 이름은 아무개입니다.', 7, 3, '홍길동'); -- 6번지에 3자리를 지우고 홍길동을 끼워넣으세요.
select insert('제 이름은 아무개입니다.', 7, 0, '김');

-- 쥬스메뉴를 찾아서 '주우스'로 변경 출력하세요.
select insert(menu_name, char_length(menu_name)-1, 2, '주우스') as menu_name
from tbl_menu
where menu_name like '%쥬스';

select insert(menu_name, instr(menu_name, '쥬스'), 2, '주우스') as menu_name
from tbl_menu
where menu_name like '%쥬스';

select insert(menu_name, locate('쥬스', menu_name), 2, '주우스') as menu_name
from tbl_menu
where menu_name like '%쥬스';

-- 문자열 잘라내기
-- left(대상 문자열, 개수) : 왼쪽부터 지정한 개수만치 잘라내서 반환
-- right(대상 문자열, 개수) : 오른쪽부터 지정한 개수만치 잘라내서 반환
select
    left('Hello world!', 3),
    right('Hello world!', 3);

-- 대소문자 변환
select
    lower('Helloworld'), -- helloworld
    upper('Helloworld'); -- HELLOWORLD

-- substring(대상 문자열, 시작 인덱스, 길이) : 잘라낸 문자열 반화
select
    substring('안녕하세요, 반갑습니다~', 8, 2), -- 반갑
    substring('안녕하세요, 반갑습니다~', 8); -- 반갑습니다~

-- substring_index(대상 문자열, 찾는 문자열, 횟수n) : 대상문자열에서 n번째 문자열을 찾고, 그이후를 버림처리 후 반환
select
    substring_index('hong.gd@naver.com', '.', 1),
    substring_index('hong.gd@naver.com', '.', 2),
    substring_index('hong.gd@naver.com', '.', -2);

select
    substring('hong.gd@naver.com', 1, instr('hong.gd@naver.com', '@') - 1),
    substring_index('hong.gd@naver.com', '@', 1); -- hong.gd

-- 문자열 채우기
-- lpad(문자열, 길이, 패딩문자) - 지정한 길이의 문자열에 첫번째 문자열과 왼쪽 남은 공간에 패딩문자를 채운다.
-- rpad(문자열, 길이, 패딩문자) - 지정한 길이의 문자열에 첫번재 문자열과 오른쪽 남은 공간에 패딩문자를 채운다.

select
    lpad('abc', 10, '@'), -- @@@@@@@abc
    rpad('abc', 10, '@'); -- abc@@@@@@@

select lpad(123, 5, '0');

-- 공백문자열 제거
-- ltrim(공백포함문자열) : 왼쪽 공백문자 제거후 반환
-- rtrim(공백포함문자열) : 오른쪽 공백문자 제거후 반환
-- trim(공백포함문자열) : 양쪽 공백문자 제거후 반환
-- trim(방향 문자 from 대상문자열) : leading/trailing/both 방향지정후 해당문자 제거
select
    concat('(', ltrim('   안녕'), ')'),
    concat('(', rtrim('안녕   '), ')'),
    concat('(', trim('   안녕   '), ')');

select
    concat('(', trim(leading ' ' from '     안녕     '), ')'),
    concat('(', trim(trailing ' ' from '     안녕     '), ')'),
    concat('(', trim(both ' ' from '     안녕     '), ')');

-- 문자열 반복
select
    repeat('잼', 5),
    repeat('-', 10);

-- 문자열 대체
select
    replace('마이SQL', '마이', 'My');

select replace(menu_name, '쥬스', '주우스') menu_name
from tbl_menu
where menu_name like '%쥬스';

-- 문자열 뒤집기
select reverse('stressed'); -- desserts

-- 공란 생성
select concat('시작', space(5), '끝');

-- 정규표현식 관련
select
    regexp_replace('123,456,789원', '[^0-9]', ''),
    regexp_substr('제 키는 188cm입니다.', '[0-9]+'); -- + 수량자 1개이상

/*
------------------------------------------------------
숫자처리 함수
------------------------------------------------------
절대값 반환
abs(숫자) : 부호를 제거한 절대값 반환
 */

select
    abs(123), -- 123
    abs(-123); -- 123

/*
 올림, 내림, 반올림, 버림
 - ceilng(숫자), floor(숫자), round(숫자, 소수점이하자리수), truncate(숫자, 소수점이하자리수)
 */
 select
     ceiling(1234.56), -- 1235
     floor(1234.56), -- 1234
     round(1234.56), -- 1235
     round(1234.56, 1); -- 1234.6

select
    floor(12.34), -- 12
    truncate(12.34, 0), -- 12
    floor(-0.6), -- -1
    -- 내림 : 지정한 수보다 작은 정수 최댓값
    truncate(-0.6, 0); -- 0
    -- 버림 : 절삭

-- 나누기/나머지 연산
-- 나누기 /
-- 나누기 div : 몫만 구하는 경우
-- 나머지 mod(), %, mod

select
    10 / 3, -- 3.3333
    10 div 3; -- 3

select
    10 % 3, -- 1
    10 mod 3, -- 1
    mod(10, 3); -- 1

-- 거듭제곱, 제곱근
-- pow(밑수, 지수)
-- sqrt(숫자)

select
    pow(2, 3), -- 2^3
    pow(3, 3);

select
    sqrt(16), -- 루트16 = 4
    sqrt(10); -- 루트10

-- 양수/0/음수 판단
-- sign(숫자) : 1/0/-1 반환
select
    sign(10.1234), -- 1
    sign(0), -- 0
    sign(-1234.15435); -- -1

-- 난수발생
-- rand() : 0.0이상 1.0미만의 난수(실수)를 반환
-- floor(rand() * 경우의 수 + 최소값)

select
    floor(rand() * 10 + 1); -- 1.0 ~ 11.0미만
