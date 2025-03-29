-- 1. 직원명과 이메일 , 이메일 길이를 출력하시오
select
    EMP_NAME,
    EMAIL,
    length(EMAIL)
from
    EMPLOYEE;

-- 2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하시오
select
    EMP_NAME,
    substring_index(EMAIL, '@', 1)
from
    EMPLOYEE;

-- 3. 60년대에 태어난 직원명과 년생, 보너스 값을 출력하시오 그때 보너스 값이 null인 경우에는 0 이라고 출력 되게 만드시오
select
    EMP_NAME,
    concat('19', substring(EMP_NO, 1, 2)),
    ifnull(BONUS, 0)
from
    EMPLOYEE;

-- 4. '010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하시오 (뒤에 단위는 명을 붙이시오)
select
    left(PHONE, 3)
from
    EMPLOYEE;