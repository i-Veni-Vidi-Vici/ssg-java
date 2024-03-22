package com.sh.abstraction.coffee;

public class Coffee {
    private String coffeeName;
    private String option;
    private int count;

    public Coffee(String coffeeName, String option, int count) {
        this.coffeeName = coffeeName;
        this.option = option;
        this.count = count;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
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

    public String info(){
        return "%s(%s)-%d잔".formatted(coffeeName, option, count);
    }
}
