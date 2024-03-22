package com.sh.call.by;

/**
 * DTO 클래스
 * - 종합선물세트와 같이 getter/setter, 필드생성자를 모두 준비해둔다.
 * - 기본 생성자 호출 + setter 값 대입
 * - 필드 생성자 호출 값 대입
 */
public class Item {
    private long id;
    private String name;
    private int price;

    // 기본 생성자
    public Item() { }

    // 필드 생성자
    public Item(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Item(Item other) {
        this.id = other.id;
        this.name = other.name;
        this.price = other.price;
    }

    // getter/setter
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void print() {
        System.out.println(this.id + ", " + this.name + ", " + this.price);
    }
}
