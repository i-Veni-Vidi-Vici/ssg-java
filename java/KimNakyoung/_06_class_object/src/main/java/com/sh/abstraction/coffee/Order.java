package com.sh.abstraction.coffee;

public class Order {

    private String menuName;
    private String option;
    private int count;

    //getter setter alt + insert

    public String getMenuName() {
        return menuName;
    }

    public String getOption() {
        return option;
    }

    public int getCount() {
        return count;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //생성자 alt + insert
    public Order(String menuName, String option, int count) {
        this.menuName = menuName;
        this.option = option;
        this.count = count;
    }
}
