package com.ssg.exception.number;

public class NumberProcess {
    public NumberProcess() {
    }
    public boolean checkDouble(int a, int b)
    {
        boolean flag=false;
        try {
            if ((a < 0 || a > 100) || (b < 0 || b > 100)) {
                throw new NumberRangeException("1~100사이의 값이 아닙니다");
            }
            else
            {
                if (b % a == 0)
                {
                    flag = true;
                }
                else flag = false;
            }

        }catch (NumberRangeException e)
        {
            System.out.println(e.getMessage());
        }
        return flag;
    }
}
