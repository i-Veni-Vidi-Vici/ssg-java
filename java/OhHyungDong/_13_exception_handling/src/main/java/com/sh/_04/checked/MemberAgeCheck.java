package com.sh._04.checked;

public class MemberAgeCheck
{
    public void checkAge(int age)
    {
       if(age < 20) {
           throw new LimitAgeException("미성년자는 해당을 이용할 수 없습니다 : " + age);
       }

    }
}
