select *
from employee;

desc employee;

-- 1. 직원명과 이메일 , 이메일 길이를 출력하시오
select
    EMP_NAME,
    EMAIL,
    char_length(email) '이메일 길이'
from
    employee;

-- 2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하시오
select
    EMP_NAME,
    substring_index(EMAIL, '@', 1) '아이디'
from
    employee;

-- 3. 60년대에 태어난 직원명과 년생, 보너스 값을 출력하시오
-- 그때 보너스 값이 null인 경우에는 0 이라고 출력 되게 만드시오

select
    EMP_NAME '직원명',
    concat(19, substring(EMP_NO, 1, 2)) '년생',
    ifnull(BONUS, 0) '보너스'
from
    employee
where
#     substr(EMP_NO,1,2) between 60 and 69
    EMP_NO like '6%';

-- 4. '010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하시오
-- (뒤에 단위는 명을 붙이시오)

