package com.sh.call.by;

/**
 * <pre>
 *  DTO 클래스
 *  - 종합선물세트와 같이 getter/setter, 필드 생성자를 모두 준비해둔다.
 *  - 기본 생성자를 호출 + setter을 이용해서 값 대입
 *  - 필드 생성자 호출해서 값 대입
 * </pre>
 */
public class Item {
    private long id;
    private String name;
    private int price;

    //기본 생성자 만듦
    public Item(){}

    //필드 생성자
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void print() {
        System.out.println(this.id + "," + this.name + "," +this.price );
    }
}
