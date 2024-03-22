package com.sh.abstraction.coffee;

public class Order {
    private String menuName;
    private String option;
    private int count;

    public Order(String menuName, String option, int count) { //생성자 : 1 , 기본생성자: x 이미 선언해서 없음)
        this.menuName = menuName;
        this.option = option;
        this.count = count;
    }

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
