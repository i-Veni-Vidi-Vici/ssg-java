
-- ======================================소제목
-- WHERE
-- ======================================소제목
-- DQL에서 특정행을 필터링하귀 위한 조건절 작성.
-- 조건절 내용에 따라 각행별로 연산을 수행 후 결과가 참인 행만 ResultSet에 포함된다

# WHERE 연산자
/*
1. = 같은가?
2. !=, <> 같지 않다
3. >, <, >=, <=
4. beteen and 범위연산(이상 이하)
5. like 문자열 패턴연산
6. is null 널 여부 검사
7. in (값, 값, .....) 값목록에 포함여부
8. 논리식 and && 그리고, or || 또는, not ! 부정(반전)
*/

# 주문 가능한 메뉴 조회
select
    menu_name,
    category_code,
    orderable_status
from
    tbl_menu
where
    orderable_status='Y';

# 메뉴 가격이 13000원인 메뉴 조회
select
    menu_code as 메뉴코드,
    menu_name as 메뉴이름,
    menu_price as 가격,
    '원' 단위
from tbl_menu
where menu_price=13000;

# 주문 불가능한 메뉴 조회 ( 메뉴코드, 메뉴명, 주문가능여부)
select menu_code        as 코드,
       menu_name        as 이름,
       orderable_status as 가능여부
from tbl_menu
-- where orderable_status!='Y';
-- where orderable_status = 'n'; -- 비교수행시 대소문자 구분 없이 처리한다
where binary orderable_status='n';-- 이때는 대소문자 구분한다
;
# 크기 비교
# 10000원 이하 메뉴만 조회
select *
from tbl_menu
where menu_price<=10000
order by menu_code;

# 20000원 넘는 메뉴
select *
from tbl_menu
where menu_price>20000;

# 카테고리코드가 10번이면서 주문가능한 메뉴 조회
select
    *
from
    tbl_menu
where
    category_code=10 && orderable_status='Y'
order by menu_code DESC ;

# 카테고리코드 = 10 이거나 주문가능

select
    *
from
    tbl_menu
where
    category_code=10 || orderable_status='Y'
order by menu_code DESC;

# 카테고리 코드 4 또는 가격이 9000면 이면서 메뉴번호 >10
select *
from tbl_menu
where category_code=4 || (menu_price=9000 && menu_code>10);
# and, or를 나열할 때, and연산자가 우선순위가 높다.

# between 연산자
# between 값1 and 값2
select *
from tbl_menu
where menu_price between 10000 and 25000;

# between 연산자
select *
from tbl_menu
where menu_name between '가'and '마';

select *
from tbl_menu
where menu_price not between 10000 and 25000;
#not where menu_price  between 10000 and 25000;
# where !(menu_price  between 10000 and 25000);

#LIKE 문자열 패턴 연산자
# 비교하려는 컬럼값이 특정패턴을 만족하면 true를 반환하는 연산자

# wildcard란? 다른 문자로 대체가능한 특수한 의미를 가진 문자
# 1. % 0개 이상의 문자열 의미
# 2. _개의 문자를 의미, ex) ___ 3글자
# '마늘'이란 말이 들어간 메뉴 조회
select *
from tbl_menu
where menu_name LIKE '흑마%';
/*
%마늘% = ~~~마늘~~~ 단어가 나온다 = 중간에 '마늘'이 나온다
마늘% = 마늘~~~~~ 단어가 나온다 = 마늘로 시작한다
%마늘 = ~~~~~마늘 = 마늘로 끝난다
 */

select *
from tbl_menu
where menu_name LIKE '___쥬스';
/*
'_흑마%' = 1글자 + 흑마 + 단어
____마늘 = 4글자+마늘
____%마늘 = 4글자+단어+마늘로 끝난다
*/

#1. 저번에 먹었던 땡땡떙 쥬스 조회
select *
from tbl_menu
where menu_name LIKE '%쥬스';

#2. 5000원 비싼,  10번 카테고리, '갈치'가 들어간 메뉴 조회
select *
from tbl_menu
where
    menu_name LIKE '%갈치%' &&
    menu_price>5000 &&
    category_code=10;

#3. 마늘이 안들어간 메뉴 조회
select *
from tbl_menu
where menu_name not LIKE '%마늘%';# == where not menu_name LIKE '%마늘%'

# null비교, 카테고리번호가 null인 메뉴 조회
select *
from tbl_menu
#where category_code=null;# 이거 안됨, is null 써야됨
where category_code is null;# 이거 안됨, is null 써야됨

select *
from tbl_menu
#where category_code=null;# 이거 안됨, is null 써야됨
where category_code is not null;# ==where not category_code is null;

    ;
# null처리함수(null은 동등비교할 수 없으므로, 다른 값으로 대체후에 비교)
# ifnull(nullableValue, value if null)
select ifnull('안녕','잘가'); # null이니?? 그럼 '안녕'쓰고, '안녕'자리가 null이면 '잘가'를 쓴다

select *
from tbl_menu
where ifnull(category_code,0)=category_code; #== category_code가 null이면 0이 나오고, 아니면 category_code 를 쓴다
#위에 경우는 menu_code 22번은 null값이기 때문에 0으로 넣어두고 )=0이므로 출력이 된다
;

# in연산자
# in(값1, 값2, ....)
# 해당 칼럼값이 in값 목록 중에 있으면 true를 반환

#카테고리 4,5,6번호만 조회

select *
from tbl_menu
where category_code in (4,5,6);

##############부정##################
select *
from tbl_menu
where category_code not in (4,5,6);

select *
from tbl_menu
where not category_code in (4,5,6);


select *
from tbl_menu
where category_code=4 ||category_code=4||category_code=4;

# 4,5,6번이 아닌 것은
select *
from tbl_menu
where category_code != 4 && category_code != 5 && category_code != 6 ;
#where not (category_code = 4 || category_code = 5 || category_code = 6) ;


























