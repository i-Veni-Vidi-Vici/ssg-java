package com.sh.abstraction.coffee;

public class Order {
    private String menuName;
    private String option;
    private int count;

    // alt + insert => Constructor 에서 매개변수 선택
    public Order(String menuName, String option, int count) {
        this.menuName = menuName;
        this.option = option;
        this.count = count;
    }
    // 필드생성자를 별도로 선언하면 기본 생성자는 만들어지지 않기 때문에 생성자는 1개이다.
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
