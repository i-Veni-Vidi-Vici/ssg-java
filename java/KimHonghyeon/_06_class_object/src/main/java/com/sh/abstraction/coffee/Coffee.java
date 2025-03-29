package com.sh.abstraction.coffee;

public class Coffee {
    private String menuName;
    private String option;

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

    public Coffee(String menuName, String option) {
        this.menuName = menuName;
        this.option = option;
    }

    public String getInfo() {
        return this.option + " " + this.menuName;
    }
}
