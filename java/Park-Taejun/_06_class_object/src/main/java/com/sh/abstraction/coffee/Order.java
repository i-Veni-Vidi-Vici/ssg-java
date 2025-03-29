package com.sh.abstraction.coffee;

public class Order {

    private String menuName;
    private String option;
    private int count;

    public String getMenuName() {
        return menuName;
    }

    public String getOption() {
        return option;
    }

    public Order(String menuName, String option, int count){
        this.menuName = menuName;
        this.option = option;
        this.count = count;
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

    public int getCount() {
        return count;
    }
}
