package com.sh._enum._03.advanced;

public class Dev {
    private String id;
    private String name;
    private DevType devType; // 스트링 받아서 바로 데브타입으로 못 넣음 그래서 변환해서 넣어줘야됨

    public Dev(String id, String name, DevType devType) {
        this.id = id;
        this.name = name;
        this.devType = devType;
    }


}
