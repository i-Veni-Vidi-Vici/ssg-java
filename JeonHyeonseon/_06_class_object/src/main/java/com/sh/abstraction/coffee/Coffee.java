package com.sh.abstraction.coffee;

public class Coffee {
    private String coffeName;
    private String option;
    private int count;

    public Coffee(int count, String coffeName, String option) {
        this.count = count;
        this.coffeName = coffeName;
        this.option = option;
    }

    public String getCoffeName() {
        return coffeName;
    }

    public void setCoffeName(String coffeName) {
        this.coffeName = coffeName;
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
    public String info() {
        return "%s(%s)-%d잔".formatted(coffeName, option, count);
    }
}
