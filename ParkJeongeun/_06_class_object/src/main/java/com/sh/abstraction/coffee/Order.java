package com.sh.abstraction.coffee;

public class Order {
    private String menuName;
    private String option;
    private int count;

    // 기본생성자 없이 아래와 같이만 만들게 하기위해 매개변수3개 있는 생성자만 생성
    public Order(String menuName, String option, int count) {
        this.menuName = menuName;
        this.option = option;
        this.count = count;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
