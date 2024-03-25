<<<<<<< HEAD
package com.ssg.emp;
=======
package com.ohgiraffers.vo;
>>>>>>> 9392fcfa5e97a02d3ea4517a1734de634c7524e7

public class Silver extends Member {

    public Silver(String name, String grade, int point){
        super(name, grade, point);

    }

    @Override
    public double getEjapoint() {
        return this.point*0.05;
    }
}
