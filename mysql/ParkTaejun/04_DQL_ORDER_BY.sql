-- --------------------------------------
-- ORDER By
-- --------------------------------------
-- ResultSet 행에 대한 정렬을 지정하는 구문
-- DQL에 Select구문 다음에 실행.
-- 문자/숫자/날짜시간(과거~미래 순서)에 대해 오름차순(ASC)/내림차순(DESC) 정렬 작성
-- 컬럼명, 컬럼순서, 별칭으로 지정가능

SELECT
    *
FROM
    tbl_menu # ODERBY 안쓰면 정렬 순서 의도할 수 없음
    order by
#         menu_code; -- asc 오름차순이 기본 값임
#           menu_code desc ; -- 내림차순 큰 숫자부터 나오게 됨
#           menu_name asc -- 가나다 순임, 물론 asc생략 가능함
            menu_name desc;

-- 두개이상의 컬럼에 대해서 정렬 지원함.
-- 카테고리코드 오름차순, 가격 내림차순
-- 우선 카테고리코드 오름차순 적용, 카테고리코드가 같은 경우 두번 째 가겨 내림차순을 적용하게 됨.
select
    *
from
    tbl_menu
order by
    category_code asc,
    menu_price desc; -- 카테고리가 같으면 가격에 따라서 내림차순으로 적용하게 됨.

-- select 절의 컬럼순서로 지정가능.

-- 별칭으로 컬럼지정
select
    menu_code 메뉴코드,
    menu_name 메뉴명,
    menu_price 메뉴가격,
    category_code 카테고리번호,
    orderable_status 주문가능여부

from
    tbl_menu
order by
    메뉴가격 desc;
#     1; -- 카테고리에서 1번 컬럼순서로 나열된 순서에 첫 번째 순서를 기준으로 정렬해서 쓰겠가
       -- menu_name 의 순서로 정렬해주세요 라는 뜻

-- 가상컬럼값 기준
select
    menu_name,
    menu_price,
    category_code,
    menu_price *tbl_menu.category_code 두컬럼의곲
from
    tbl_menu
order by
    menu_price * tbl_menu.category_code; -- 곱한거로 정렬 하는것도 가능하다
;
-- 특정컬럼값을 변환해서 기준으로 사용
-- field(src, val1, val2, val3, ////) : 일치하는 값의 인덱스 반환

select
    field('A','A','B','C'),-- 1
    field('B','A','B','C'), -- 2
    field('X','A','B','C'); -- 0 (mysql에서는 존재하지 않는 인덱스)

select
    menu_name,
    tbl_menu.orderable_status,
    field(tbl_menu.orderable_status, 'y','N')
from
    tbl_menu
order by
    field(orderable_status, 'Y','N');

-- null 관련
-- 오름차순 정렬에서 null값은 기본적으로 맨 위에 온다.
-- 내림차순 정렬에서 null값은 기본적으로 맨 아래온다~
select
    *
from
    tbl_menu
order by
#     category_code desc; -- 아무것도 안적혀 있으면 오름차순이라네유, 내림차순으로 하면 null 값이 맨 밑으로 감.
#        category_code is null, -- is null asc에서는 null값이 가장 밑에 온다 true -> 1 false -> 0  따라서 오름차순 했을 때 null인 놈이 1이므로 오름차순 했을 떄 가장 밑으로 옴.
#        category_code ;
        category_code is null desc,
        category_code desc ; -- 내림차순이 됐지만 null 값이 맨위에 올 수 있다




