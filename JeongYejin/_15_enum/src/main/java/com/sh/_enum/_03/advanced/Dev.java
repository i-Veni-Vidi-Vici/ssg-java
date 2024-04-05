package com.sh._enum._03.advanced;

public class Dev {
    private String id;
    private String name;
    private DevType devType;

    public Dev(String id, String name, DevType devType) {
        this.id = id;
        this.name = name;
        this.devType = devType;
    }

    @Override
    public String toString() {
        return "Dev{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", devType=" + devType +
                '}';
    }
}
